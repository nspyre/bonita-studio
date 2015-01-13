/**
 * <copyright>
 * </copyright>
 * $Id$
 */
package org.w3._1999.xhtml.validation;

import org.w3._1999.xhtml.DirType;

/**
 * A sample validator interface for {@link org.w3._1999.xhtml.MetaType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MetaTypeValidator {

    boolean validate();

    boolean validateContent(Object value);

    boolean validateDir(DirType value);

    boolean validateHttpEquiv(Object value);

    boolean validateId(String value);

    boolean validateLang(String value);

    boolean validateLang1(String value);

    boolean validateName(Object value);

    boolean validateScheme(Object value);
}
