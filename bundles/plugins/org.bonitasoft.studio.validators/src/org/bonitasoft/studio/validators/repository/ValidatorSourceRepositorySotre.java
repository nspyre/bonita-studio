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

import java.util.HashSet;
import java.util.Set;

import org.bonitasoft.studio.common.repository.filestore.PackageFileStore;
import org.bonitasoft.studio.common.repository.model.IRepositoryFileStore;
import org.bonitasoft.studio.common.repository.store.SourceRepositoryStore;
import org.bonitasoft.studio.pics.Pics;
import org.bonitasoft.studio.validators.ValidatorPlugin;
import org.bonitasoft.studio.validators.i18n.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * @author Romain Bioteau
 */
public class ValidatorSourceRepositorySotre extends SourceRepositoryStore {

    public static final String VALIDATOR_PATH_IN_BAR = "forms/validators/";
    private static final String STORE_NAME = "src-validators";
    private static final Set<String> extensions = new HashSet<String>();

    /*
     * (non-Javadoc)
     * @see org.bonitasoft.studio.common.repository.model.IRepositoryStore#createRepositoryFileStore(java.lang.String)
     */
    @Override
    public IRepositoryFileStore createRepositoryFileStore(String packageName) {
        return new PackageFileStore(packageName, this);
    }

    /*
     * (non-Javadoc)
     * @see org.bonitasoft.studio.common.repository.model.IRepositoryStore#getName()
     */
    @Override
    public String getName() {
        return STORE_NAME;
    }

    /*
     * (non-Javadoc)
     * @see org.bonitasoft.studio.common.repository.model.IRepositoryStore#getDisplayName()
     */
    @Override
    public String getDisplayName() {
        return Messages.validatorSource;
    }

    /*
     * (non-Javadoc)
     * @see org.bonitasoft.studio.common.repository.model.IRepositoryStore#getIcon()
     */
    @Override
    public Image getIcon() {
        return Pics.getImage("java.gif", ValidatorPlugin.getDefault());
    }

    /*
     * (non-Javadoc)
     * @see org.bonitasoft.studio.common.repository.model.IRepositoryStore#getCompatibleExtensions()
     */
    @Override
    public Set<String> getCompatibleExtensions() {
        return null;
    }

    //    @Override
    //    public List<IRepositoryFileStore> getChildren() {
    //        refresh() ;
    //        List<IRepositoryFileStore> result = new ArrayList<IRepositoryFileStore>() ;
    //        try {
    //            IJavaProject javaProject = RepositoryManager.getInstance().getCurrentRepository().getJavaProject() ;
    //            IPackageFragmentRoot packageFragmentRoot = javaProject.getPackageFragmentRoot(getResource()) ;
    //            for(IJavaElement javaElement : packageFragmentRoot.getChildren()){
    //                if(javaElement instanceof IPackageFragment){
    //                    if(!((IPackageFragment)javaElement).hasSubpackages() && !javaElement.getElementName().isEmpty()){
    //                        File[] content = javaElement.getResource().getLocation().toFile().listFiles(new FilenameFilter() {
    //
    //                            @Override
    //                            public boolean accept(File dir, String name) {
    //                                return name.endsWith(".java");
    //                            }
    //                        }) ;
    //                        if(content != null && content.length > 0){
    //                            result.add(createRepositoryFileStore(((IPackageFragment)javaElement).getElementName())) ;
    //                        }
    //                    }
    //                }
    //            }
    //        } catch (CoreException e) {
    //            BonitaStudioLog.error(e) ;
    //        }
    //        return result;
    //    }

}
