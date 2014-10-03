/*******************************************************************************
 * Copyright (C) 2014 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package org.bonitasoft.studio.swtbot.framework.diagram.general.form.data;


import org.bonitasoft.studio.common.jface.SWTBotConstants;
import org.bonitasoft.studio.swtbot.framework.BotBase;
import org.bonitasoft.studio.swtbot.framework.composite.BotOperationComposite;
import org.bonitasoft.studio.swtbot.framework.expression.BotExpressionEditorDialog;
import org.bonitasoft.studio.test.swtbot.util.SWTBotTestUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;

/**
 * General property section.
 *
 * @author Romain Bioteau
 */
public class BotDataFormPropertySection extends BotBase {

    public BotDataFormPropertySection(final SWTGefBot bot) {
        super(bot);
    }

    public BotDataFormPropertySection setName(final String pName) {
        bot.button(org.bonitasoft.studio.form.properties.i18n.Messages.Edit).click();
        bot.waitUntil(Conditions.shellIsActive(org.bonitasoft.studio.form.properties.i18n.Messages.editWidgetNameTitle));
        bot.textWithLabel(org.bonitasoft.studio.form.properties.i18n.Messages.name).setText(pName);
        bot.button(IDialogConstants.OK_LABEL).click();
        return this;
    }

    public BotDataFormPropertySection setFieldType(final String pType) {
        bot.comboBoxWithLabel(org.bonitasoft.studio.form.properties.i18n.Messages.formFieldType).setSelection(pType);
        return this;
    }

    public BotDataFormPropertySection setDisplayName(final String widgetLabel) {
        bot.textWithId(SWTBotConstants.SWTBOT_ID_EXPRESSIONVIEWER_TEXT).setText(widgetLabel);
        return this;

    }

    public BotExpressionEditorDialog editInitialValue() {
        bot.toolbarButtonWithId(SWTBotConstants.SWTBOT_ID_EDITBUTTON, 0).click();
        return new BotExpressionEditorDialog(bot);
    }

    public BotDataFormPropertySection setFieldModifier(final String className) {
        bot.comboBoxWithLabel(org.bonitasoft.studio.form.properties.i18n.Messages.fieldModifier).setSelection(className);
        return this;
    }

    public String getFieldModifier() {
        return bot.comboBoxWithLabel(org.bonitasoft.studio.form.properties.i18n.Messages.fieldModifier).getText();
    }

    /**
     * Select output variable.
     *
     * @deprecated use {@link #getOutputOperation()}
     * @param variableName
     * @param returnType
     * @return
     */
    @Deprecated
    public BotDataFormPropertySection selectOutputVariable(final String variableName, final String returnType) {
        SWTBotTestUtil.selectExpressionProposal(bot, variableName, returnType, 1);
        return this;
    }

    /**
     * Edit output expression.
     *
     * @deprecated use {@link #getOutputOperation()}
     * @return
     */
    @Deprecated
    public BotExpressionEditorDialog editOutputOperationExpression() {
        bot.toolbarButtonWithId(SWTBotConstants.SWTBOT_ID_EDITBUTTON, 1).click();
        return new BotExpressionEditorDialog(bot);
    }

    /**
     * Get the output operation.
     *
     * @return
     */
    public BotOperationComposite getOutputOperation() {
        return new BotOperationComposite(bot, 0);
    }
}