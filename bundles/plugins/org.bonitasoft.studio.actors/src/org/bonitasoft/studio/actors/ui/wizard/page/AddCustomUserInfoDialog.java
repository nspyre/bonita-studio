/**
 * 
 */
package org.bonitasoft.studio.actors.ui.wizard.page;


import java.util.Set;

import org.bonitasoft.studio.actors.i18n.Messages;
import org.bonitasoft.studio.actors.validator.CustomerUserInformationDefinitionNameValidator;
import org.bonitasoft.studio.common.jface.databinding.DialogSupport;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author Florine Boudin
 *
 */
public class AddCustomUserInfoDialog extends Dialog {

	
    private DataBindingContext context;

    private String customUserInfoName;
	private String customUserInfoDescription; 

	private Button okButton;

	private Text customInfoNameText;
	
	private Set<String> existingNames;

	private Text customInfoDefinitionText;
	
	

	protected AddCustomUserInfoDialog(Shell parentShell) {
		super(parentShell);
	}
	

	/**
	 * 
	 * @param parentShell
	 * @param existingNames all name must be with lower case
	 */
	protected AddCustomUserInfoDialog(Shell parentShell, Set<String> existingNames) {
		this(parentShell);
		this.existingNames=existingNames;
	}	
	
	
    @Override
    protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {

    	if (id == IDialogConstants.OK_ID){

    		okButton = super.createButton(parent, id, label, defaultButton);    	
    		okButton.setEnabled(false);

    		return okButton;
    	}else{
    		return super.createButton(parent, id, label, defaultButton);
    	}

    }

    
	@Override
	protected Control createDialogArea(Composite parent) {

		context = new DataBindingContext() ;

		Composite area = new Composite(parent, SWT.NONE);
		area.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).margins(5, 5).create());
		area.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());

		Label customInfoNameLabel = new Label(area, SWT.NONE) ;
		customInfoNameLabel.setLayoutData(GridDataFactory.fillDefaults().align(SWT.END,SWT.CENTER).create()) ;
		customInfoNameLabel.setText(Messages.customUserInfoName+" *") ;


		customInfoNameText = new Text(area, SWT.BORDER);
		customInfoNameText.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).indent(10, 0).create()) ;

		Label customInfoDefinitionLabel = new Label(area, SWT.NONE) ;
		customInfoDefinitionLabel.setLayoutData(GridDataFactory.fillDefaults().align(SWT.END,SWT.CENTER).create()) ;
		customInfoDefinitionLabel.setText(Messages.customUserInfoDescription) ;

		customInfoDefinitionText = new Text(area, SWT.BORDER );
		customInfoDefinitionText.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).indent(10, 0).create()) ;
		customInfoDefinitionText.setToolTipText(customInfoDefinitionText.getText());

		bindName();

		DialogSupport.create(this, context);
		
		return area;
	}


	protected void bindName() {
		UpdateValueStrategy uvsName = new UpdateValueStrategy();
		
		CustomerUserInformationDefinitionNameValidator nameValidator = new CustomerUserInformationDefinitionNameValidator(existingNames);
		uvsName.setBeforeSetValidator(nameValidator);
		
		ISWTObservableValue observeText = SWTObservables.observeText(customInfoNameText, SWT.Modify);
		
		Binding binding =context.bindValue(observeText, PojoProperties.value(AddCustomUserInfoDialog.class,"customUserInfoName").observe(this), uvsName, null) ;
        context.bindValue(SWTObservables.observeText(customInfoDefinitionText, SWT.Modify), PojoProperties.value(AddCustomUserInfoDialog.class,"customUserInfoDescription").observe(this)) ;
        
        ControlDecorationSupport.create(binding, SWT.TOP | SWT.LEFT);
	}
	
	@Override
	 protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText(Messages.customUserInformationAddWindowTitle);
	      shell.setSize(500, 200);
	   }
	

	public String getCustomUserInfoName() {
		return customUserInfoName;
	}
	
    public String getCustomUserInfoDescription() {
		return customUserInfoDescription;
	}


	public void setCustomUserInfoDescription(String customUserInfoDescription) {
		this.customUserInfoDescription = customUserInfoDescription;
	}

	public void setCustomUserInfoName(String customUserInfoName) {
		this.customUserInfoName = customUserInfoName;
	}

	@Override
    public boolean close() {
        if(context != null){
            context.dispose() ;
        }
        return super.close();
    }
	
}