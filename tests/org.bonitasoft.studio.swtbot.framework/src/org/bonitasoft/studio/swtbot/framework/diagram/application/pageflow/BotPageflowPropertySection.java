/*******************************************************************************
 * Copyright (C) 2014 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package org.bonitasoft.studio.swtbot.framework.diagram.application.pageflow;

import org.bonitasoft.studio.properties.i18n.Messages;
import org.bonitasoft.studio.swtbot.framework.BotBase;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;

/**
 * Pageflow property section.
 * 
 * @author Joachim Segala
 */
public class BotPageflowPropertySection extends BotBase {

    public BotPageflowPropertySection(final SWTGefBot bot) {
        super(bot);
    }

    public BotAddFormWizardDialog addForm() {
        bot.button(Messages.addForm).click();
        return new BotAddFormWizardDialog(bot);
    }
}