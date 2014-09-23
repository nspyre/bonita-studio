/**
 * Copyright (C) 2014 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.studio.contract.ui.property.edit;

import org.bonitasoft.studio.contract.core.ContractDefinitionValidator;
import org.bonitasoft.studio.model.process.ContractInput;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertyColumnLabelProvider;


/**
 * @author Romain Bioteau
 *
 */
public class DescriptionCellLabelProvider extends PropertyColumnLabelProvider {

    private final ContractDefinitionValidator validator;

    public DescriptionCellLabelProvider(final IPropertySourceProvider propertySourceProvider, final ContractDefinitionValidator validator) {
        super(propertySourceProvider, "description");
        this.validator = validator;
    }

    @Override
    public Image getImage(final Object object) {
        return null;
    }

    @Override
    public String getToolTipText(final Object element) {
        final String description = ((ContractInput) element).getDescription();
        final IStatus status = validator.validateInputDescription((ContractInput) element, description);
        if (status.isOK()) {
            return description;
        } else {
            return status.getMessage();
        }
    }

    @Override
    public Color getBackground(final Object element) {
        final String description = ((ContractInput) element).getDescription();
        final IStatus status = validator.validateInputDescription((ContractInput) element, description);
        if (status.isOK()) {
            return super.getBackground(element);
        } else {
            return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
        }
    }



}