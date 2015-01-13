/**
 * Copyright (C) 2012 BonitaSoft S.A.
 * BonitaSoft, 31 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.studio.expression.editor.viewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bonitasoft.studio.common.ExpressionConstants;
import org.bonitasoft.studio.common.jface.databinding.validator.EmptyInputValidator;
import org.bonitasoft.studio.common.widgets.MagicComposite;
import org.bonitasoft.studio.expression.editor.i18n.Messages;
import org.bonitasoft.studio.expression.editor.provider.ExpressionContentProvider;
import org.bonitasoft.studio.expression.editor.provider.IExpressionNatureProvider;
import org.bonitasoft.studio.model.expression.Expression;
import org.bonitasoft.studio.model.expression.ExpressionPackage;
import org.bonitasoft.studio.pics.Pics;
import org.bonitasoft.studio.pics.PicsConstants;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;

/**
 * @author Romain Bioteau
 */
public class PatternExpressionViewer extends Composite {

    private TextViewer viewer;
    private ExpressionViewer expressionViewer;
    private final IExpressionNatureProvider expressionNatureProvider = ExpressionContentProvider.getInstance();
    private ExpressionContentAssistProcessor contentAssisProcessor;
    private final Set<ViewerFilter> filters = new HashSet<ViewerFilter>();
    protected Expression expression;
    private List<Expression> filteredExpressions;
    private PatternLineStyleListener patternLineStyle;
    private ControlDecoration hintDecoration;
    private ComputePatternDependenciesJob dependencyJob;
    private final MagicComposite mc;
    private EMFDataBindingContext context;
    protected String mandatoryFieldLabel;
    private EObject contextInput;
    private Binding patternBinding;
    private ControlDecoration helpDecoration;

    public PatternExpressionViewer(final Composite parent, final int style) {
        super(parent, style);
        setLayout(GridLayoutFactory.fillDefaults().numColumns(1).margins(0, 0).create());
        mc = new MagicComposite(this, SWT.INHERIT_DEFAULT);
        mc.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).margins(0, 0).extendedMargins(15, 25, 0, 0).create());
        mc.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
        createTextViewer();
        createExpressionViewer();
        createEditorSwitch();
        mc.hide(getViewerControl());
        mc.show(expressionViewer.getControl());

    }

    private void createEditorSwitch() {
        final Link switchControl = new Link(mc, SWT.NONE);
        switchControl.setText(Messages.switchEditor);
        switchControl.setLayoutData(GridDataFactory.swtDefaults().align(SWT.END, SWT.CENTER).create());
        switchControl.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(final SelectionEvent e) {
                switchEditorType();
            }
        });
    }

    protected void initializeEditorType() {
        if (ExpressionConstants.PATTERN_TYPE.equals(expression.getType())) {
            expression.setName("<pattern-expression>");
            mc.hide(expressionViewer.getControl());
            mc.show(getViewerControl());
            helpDecoration.show();
            mc.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).margins(0, 0).extendedMargins(15, 25, 0, 0).create());
            bindPatternExpression();
        } else {
            mc.hide(getViewerControl());
            mc.show(expressionViewer.getControl());
            helpDecoration.hide();
            mc.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).margins(0, 0).create());
            bindExpressionViewer();
        }
        mc.layout(true, true);
    }

    protected void switchEditorType() {
        if (MessageDialog.openQuestion(mc.getShell(), Messages.eraseExpressionTitle, Messages.eraseExpressionMsg)) {
            if (!expressionMode()) {
                showExpressionViewer();
                bindExpressionViewer();
                mc.layout(true, true);
            } else {
                showTextViewer();
                bindPatternExpression();
            }
        }
    }

    protected void showTextViewer() {
        mc.hide(expressionViewer.getControl());
        mc.show(getViewerControl());
        expression.setContent("");
        expression.setName("<pattern-expression>");
        expression.setInterpreter(null);
        expression.setType(ExpressionConstants.PATTERN_TYPE);
        bindPatternExpression();
        mc.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).margins(0, 0).extendedMargins(15, 25, 0, 0).create());
        mc.layout(true, true);
        helpDecoration.show();
        if (hintDecoration.getDescriptionText() != null) {
            hintDecoration.show();
        }
    }

    protected Control getViewerControl() {
        return viewer.getControl();
    }

    protected void showExpressionViewer() {
        helpDecoration.hide();
        hintDecoration.hide();
        mc.hide(getViewerControl());
        mc.show(expressionViewer.getControl());
        expression.setContent("");
        expression.setName("");
        expression.setInterpreter(null);
        expression.setType(ExpressionConstants.CONSTANT_TYPE);
        expression.getReferencedElements().clear();
        expressionViewer.setSelection(new StructuredSelection(expression));
        mc.setLayout(GridLayoutFactory.fillDefaults().numColumns(1).margins(0, 0).create());
    }

    protected boolean expressionMode() {
        return expressionViewer.getControl().isVisible();
    }

    private void bindExpressionViewer() {
        expressionViewer.setContext(contextInput);
        expressionViewer.setInput(contextInput);
        if (mandatoryFieldLabel != null) {
            expressionViewer.setMandatoryField(mandatoryFieldLabel, context);
        }
        expressionViewer.setExternalDataBindingContext(context);
        expressionViewer.setSelection(new StructuredSelection(expression));
    }

    protected void bindPatternExpression() {
        final UpdateValueStrategy startegy = new UpdateValueStrategy();
        if (mandatoryFieldLabel != null) {
            startegy.setAfterConvertValidator(new EmptyInputValidator(mandatoryFieldLabel));
        }
        if (patternBinding != null) {
            patternBinding.dispose();
            patternBinding = null;
        }
        expression.getReferencedElements().clear();
        patternBinding = context.bindValue(SWTObservables.observeText(viewer.getTextWidget(), SWT.Modify),
                EMFObservables.observeValue(expression, ExpressionPackage.Literals.EXPRESSION__CONTENT), startegy, null);
    }

    protected void createExpressionViewer() {
        expressionViewer = new ExpressionViewer(mc, SWT.BORDER);
        expressionViewer.getControl().setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
    }

    protected void createTextViewer() {
        viewer = createViewer(mc);
        viewer.getControl().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
        configureTextViewer();

        helpDecoration = new ControlDecoration(viewer.getControl(), SWT.TOP | SWT.RIGHT, this);
        helpDecoration.setImage(JFaceResources.getImage(Dialog.DLG_IMG_HELP));
        helpDecoration.setDescriptionText(Messages.patternViewerHelp);
        helpDecoration.setMarginWidth(2);
        helpDecoration.hide();

        hintDecoration = new ControlDecoration(viewer.getControl(), SWT.TOP | SWT.LEFT, this);
        hintDecoration.setImage(Pics.getImage(PicsConstants.hint));
        hintDecoration.setMarginWidth(2);
        hintDecoration.setShowHover(true);
        hintDecoration.setShowOnlyOnFocus(true);
        hintDecoration.hide();

        viewer.addTextListener(new ITextListener() {

            @Override
            public void textChanged(final TextEvent event) {
                viewer.getTextWidget().notifyListeners(SWT.Modify, new Event());
            }
        });

        contentAssisProcessor = new ExpressionContentAssistProcessor(viewer.getDocument());
        final ContentAssistant assistant = new ContentAssistant();
        assistant.setContentAssistProcessor(contentAssisProcessor, IDocument.DEFAULT_CONTENT_TYPE);
        assistant.setShowEmptyList(true);
        assistant.enableAutoActivation(true);
        assistant.install(viewer);

        viewer.getTextWidget().addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(final KeyEvent e) {

                switch (e.keyCode) {
                    case SWT.F1:
                        assistant.showPossibleCompletions();
                        break;
                    default:
                        //ignore everything else
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                if ((e.stateMask == SWT.CTRL || e.stateMask == SWT.COMMAND) && e.keyCode == SWT.SPACE) {
                    assistant.showPossibleCompletions();
                }
            }
        });

        final ISWTObservableValue observable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(getTextControl(), SWT.Modify));
        observable.addValueChangeListener(new IValueChangeListener() {

            @Override
            public void handleValueChange(final ValueChangeEvent event) {
                if (!expressionMode()) {
                    updateExpressionDependencies();
                }
            }
        });

        helpDecoration.show();
    }

    protected void configureTextViewer() {
        viewer.setDocument(new Document());
    }

    protected TextViewer createViewer(final Composite parent) {
        return new TextViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
    }

    private void updateExpressionDependencies() {
        dependencyJob.schedule();
    }

    @Override
    public void dispose() {
        super.dispose();
        if (dependencyJob != null) {
            dependencyJob.cancel();
        }
    }

    public void setContextInput(final EObject input) {
        contextInput = input;
        manageNatureProviderAndAutocompletionProposal(input);
    }

    public void setExpression(final Expression expression) {
        this.expression = expression;
        initializeEditorType();
    }

    protected void manageNatureProviderAndAutocompletionProposal(final Object input) {
        filteredExpressions = getFilteredExpressions();
        final Set<Expression> expressionSet = new HashSet<Expression>(filteredExpressions);
        contentAssisProcessor.setExpressions(expressionSet);
        if (patternLineStyle != null) {
            patternLineStyle.setExpressions(expressionSet);
        }
        dependencyJob = new ComputePatternDependenciesJob(viewer.getDocument(), filteredExpressions);
        dependencyJob.addJobChangeListener(new IJobChangeListener() {

            @Override
            public void aboutToRun(final IJobChangeEvent event) {
            }

            @Override
            public void awake(final IJobChangeEvent event) {
            }

            @Override
            public void done(final IJobChangeEvent event) {
                if (dependencyJob != null) {
                    final List<EObject> deps = dependencyJob.getDependencies(viewer.getDocument().get());
                    expression.getReferencedElements().clear();
                    if (deps != null && !deps.isEmpty()) {
                        expression.getReferencedElements().addAll(deps);
                    }
                }
            }

            @Override
            public void running(final IJobChangeEvent event) {
            }

            @Override
            public void scheduled(final IJobChangeEvent event) {
            }

            @Override
            public void sleeping(final IJobChangeEvent event) {
            }
        });
    }

    private List<Expression> getFilteredExpressions() {
        final List<Expression> filteredExpressions = new ArrayList<Expression>();
        final Expression[] expressions = expressionNatureProvider.getExpressions(contextInput);
        if (expressions != null) {
            filteredExpressions.addAll(Arrays.asList(expressions));
            if (contextInput != null) {
                for (final Expression exp : expressions) {
                    for (final ViewerFilter filter : filters) {
                        if (filter != null && !filter.select(viewer, contextInput, exp)) {
                            filteredExpressions.remove(exp);
                        }
                    }
                }
            }
        }
        return filteredExpressions;
    }

    public void addFilter(final ViewerFilter viewerFilter) {
        filters.add(viewerFilter);
        expressionViewer.addFilter(viewerFilter);
    }

    public StyledText getTextControl() {
        return viewer.getTextWidget();
    }

    public void setHint(final String hint) {
        hintDecoration.setDescriptionText(hint);
        hintDecoration.show();
        expressionViewer.setMessage(hint, IStatus.INFO);
    }

    public void setEMFBindingContext(final EMFDataBindingContext context) {
        this.context = context;
    }

    public void setMandatoryField(final String mandatoryFieldLabel) {
        this.mandatoryFieldLabel = mandatoryFieldLabel;
    }
}
