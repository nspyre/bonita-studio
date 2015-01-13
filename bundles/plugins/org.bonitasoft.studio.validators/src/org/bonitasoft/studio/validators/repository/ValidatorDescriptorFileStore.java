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
package org.bonitasoft.studio.validators.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bonitasoft.studio.common.log.BonitaStudioLog;
import org.bonitasoft.studio.common.repository.RepositoryManager;
import org.bonitasoft.studio.common.repository.filestore.EMFFileStore;
import org.bonitasoft.studio.common.repository.model.IRepositoryStore;
import org.bonitasoft.studio.pics.Pics;
import org.bonitasoft.studio.validators.ValidatorPlugin;
import org.bonitasoft.studio.validators.descriptor.validator.ValidatorDescriptor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author Romain Bioteau
 */
public class ValidatorDescriptorFileStore extends EMFFileStore {

    public ValidatorDescriptorFileStore(String fileName, IRepositoryStore<? extends EMFFileStore> store) {
        super(fileName, store);
    }

    @Override
    public String getDisplayName() {
        return getContent().getName();
    }

    @Override
    public Image getIcon() {
        return Pics.getImage("Validator.png", ValidatorPlugin.getDefault());
    }

    @Override
    public ValidatorDescriptor getContent() {
        return (ValidatorDescriptor) super.getContent();
    }

    /*
     * (non-Javadoc)
     * @see org.bonitasoft.studio.common.repository.filestore.AbstractFileStore#doSave(java.lang.Object)
     */
    @Override
    protected void doSave(Object content) {
        if (content instanceof ValidatorDescriptor) {
            Resource emfResource = getEMFResource();
            emfResource.getContents().clear();
            emfResource.getContents().add(EcoreUtil.copy((EObject) content));
            Map<String, String> options = new HashMap<String, String>();
            options.put(XMLResource.OPTION_ENCODING, "UTF-8");
            options.put(XMLResource.OPTION_XML_VERSION, "1.0");
            try {
                emfResource.save(options);
            } catch (IOException e) {
                BonitaStudioLog.error(e);
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see org.bonitasoft.studio.common.repository.filestore.AbstractFileStore#doOpen()
     */
    @Override
    protected IWorkbenchPart doOpen() {
        return null;
    }

    public IType getValidatorClassType() {
        try {
            IJavaProject project = RepositoryManager.getInstance().getCurrentRepository().getJavaProject();
            return project.findType(getContent().getClassName());
        } catch (Exception ex) {
            BonitaStudioLog.error(ex);
            return null;
        }
    }

}
