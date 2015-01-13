/**
 * Copyright (C) 2014 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
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
package org.bonitasoft.studio.expression.editor.filter;

import org.bonitasoft.studio.common.log.BonitaStudioLog;
import org.bonitasoft.studio.common.repository.RepositoryManager;
import org.bonitasoft.studio.expression.editor.ExpressionEditorPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author Romain Bioteau
 */
public class ExpressionReturnTypeFilter {

    /**
     * @param currentReturnType
     * @param targetReturnType
     * @return true if currentReturnType is in the targetReturnType hierarchy or if one of the both types is unknown
     */
    public boolean compatibleReturnTypes(final String currentReturnType, final String targetReturnType) {
        if (currentReturnType.equals(targetReturnType)) {
            return true;
        }
        try {
            final Class<?> currentReturnTypeClass = Class.forName(currentReturnType);
            final Class<?> targetReturnTypeClass = Class.forName(targetReturnType);
            return currentReturnTypeClass.isAssignableFrom(targetReturnTypeClass);
        } catch (final ClassNotFoundException e) {
            final IJavaProject javaProject = getJavaProject();
            if (javaProject != null) {
                try {
                    final IType currentType = javaProject.findType(currentReturnType);
                    final IType targetType = javaProject.findType(targetReturnType);
                    if (currentType != null && targetType != null) {
                        return currentType.newTypeHierarchy(null).contains(targetType);
                    }
                } catch (final JavaModelException e1) {

                }
            }
            BonitaStudioLog.debug("Failed to determine the compatibility between " + targetReturnType + " and "
                    + currentReturnType, ExpressionEditorPlugin.PLUGIN_ID);
        }
        return true;
    }

    protected IJavaProject getJavaProject() {
        return RepositoryManager.getInstance().getCurrentRepository().getJavaProject();
    }

}
