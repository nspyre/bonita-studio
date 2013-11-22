/**
 * 
 */
package org.bonitasoft.studio.migration.custom.migration;

import org.bonitasoft.studio.migration.utils.StringToExpressionConverter;
import org.eclipse.emf.edapt.migration.CustomMigration;
import org.eclipse.emf.edapt.migration.Instance;
import org.eclipse.emf.edapt.migration.Metamodel;
import org.eclipse.emf.edapt.migration.MigrationException;
import org.eclipse.emf.edapt.migration.Model;

/**
 * @author Florine Boudin
 *
 */
public class InitializePoolDynamicDescription extends CustomMigration {

	@Override
	public void migrateAfter(final Model model, final Metamodel metamodel)	throws MigrationException {
		
		for(Instance pool : model.getAllInstances("process.Pool")){
				
				Instance newDescriptionExpr = StringToExpressionConverter.createEmptyExpressionInstance(model, true);
				pool.set("dynamicDescription", newDescriptionExpr);
			}
	}
	
}
