/**
 * Copyright (C) 2011 BonitaSoft S.A.
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
package org.bonitasoft.studio.profiles;

import org.bonitasoft.studio.profiles.ProfilePlugin;
import org.bonitasoft.studio.profiles.manager.BonitaProfilesManager;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @author Romain Bioteau
 */
public class ProfilePreferenceInitializer extends AbstractPreferenceInitializer {

    /**
	 * 
	 */
    public ProfilePreferenceInitializer() {

    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = ProfilePlugin.getDefault().getPreferenceStore();
        store.setDefault(BonitaProfilesManager.PREF_ACTIVE_PROFILE, BonitaProfilesManager.APPLICATION_DEVELOPER_PROFILE);
        store.setDefault(BonitaProfilesManager.SHOW_SELECT_PROFILE, true);
    }

}
