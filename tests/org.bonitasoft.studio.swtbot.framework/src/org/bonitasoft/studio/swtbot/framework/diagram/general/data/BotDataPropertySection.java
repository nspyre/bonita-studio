/*******************************************************************************
 * Copyright (C) 2014 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package org.bonitasoft.studio.swtbot.framework.diagram.general.data;

import org.bonitasoft.studio.data.i18n.Messages;
import org.bonitasoft.studio.swtbot.framework.BotBase;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;

/**
 * Data property section.
 * 
 * @author Joachim Segala
 */
public class BotDataPropertySection extends BotBase {

    public BotDataPropertySection(final SWTGefBot bot) {
        super(bot);
    }

    public BotAddDataDialog addData() {
        bot.button(Messages.addData).click();
        return new BotAddDataDialog(bot);
    }
}
