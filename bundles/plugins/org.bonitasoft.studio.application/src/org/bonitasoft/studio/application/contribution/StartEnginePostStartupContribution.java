/**
 * Copyright (C) 2010 BonitaSoft S.A.
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

package org.bonitasoft.studio.application.contribution;

import org.bonitasoft.studio.application.actions.StartEngineInBackgoundCommand;
import org.bonitasoft.studio.common.extension.IPostStartupContribution;
import org.bonitasoft.studio.common.log.BonitaStudioLog;
import org.bonitasoft.studio.common.platform.tools.PlatformUtil;
import org.eclipse.core.commands.ExecutionException;

/**
 * @author Romain Bioteau
 */
public class StartEnginePostStartupContribution implements IPostStartupContribution {

    /*
     * (non-Javadoc)
     * @see org.bonitasoft.studio.application.contribution.IPostStartupContribution#execute()
     */
    @Override
    public void execute() {
        try {
            if (PlatformUtil.isHeadless()) {
                return;
            }
            new StartEngineInBackgoundCommand().execute(null);
        } catch (ExecutionException e) {
            BonitaStudioLog.error(e);
        }

    }

}
