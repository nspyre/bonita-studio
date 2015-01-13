/**
 * <copyright>
 * </copyright>
 * $Id$
 */
package org.w3._1999.xhtml.validation;

import java.math.BigInteger;
import java.util.List;

import org.w3._1999.xhtml.DirType;
import org.w3._1999.xhtml.NohrefType;
import org.w3._1999.xhtml.Shape;

/**
 * A sample validator interface for {@link org.w3._1999.xhtml.AreaType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AreaTypeValidator {

    boolean validate();

    boolean validateAccesskey(String value);

    boolean validateAlt(String value);

    boolean validateClass(List<String> value);

    boolean validateCoords(String value);

    boolean validateDir(DirType value);

    boolean validateHref(String value);

    boolean validateId(String value);

    boolean validateLang(String value);

    boolean validateLang1(String value);

    boolean validateNohref(NohrefType value);

    boolean validateOnblur(String value);

    boolean validateOnclick(String value);

    boolean validateOndblclick(String value);

    boolean validateOnfocus(String value);

    boolean validateOnkeydown(String value);

    boolean validateOnkeypress(String value);

    boolean validateOnkeyup(String value);

    boolean validateOnmousedown(String value);

    boolean validateOnmousemove(String value);

    boolean validateOnmouseout(String value);

    boolean validateOnmouseover(String value);

    boolean validateOnmouseup(String value);

    boolean validateShape(Shape value);

    boolean validateStyle(String value);

    boolean validateTabindex(BigInteger value);

    boolean validateTitle(String value);
}
