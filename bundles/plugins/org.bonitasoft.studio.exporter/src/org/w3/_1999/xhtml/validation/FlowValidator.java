/**
 * <copyright>
 * </copyright>
 * $Id$
 */
package org.w3._1999.xhtml.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.w3._1999.xhtml.AType;
import org.w3._1999.xhtml.AbbrType;
import org.w3._1999.xhtml.AcronymType;
import org.w3._1999.xhtml.AddressType;
import org.w3._1999.xhtml.BType;
import org.w3._1999.xhtml.BdoType;
import org.w3._1999.xhtml.BigType;
import org.w3._1999.xhtml.BlockquoteType;
import org.w3._1999.xhtml.BrType;
import org.w3._1999.xhtml.ButtonType;
import org.w3._1999.xhtml.CiteType;
import org.w3._1999.xhtml.CodeType;
import org.w3._1999.xhtml.DelType;
import org.w3._1999.xhtml.DfnType;
import org.w3._1999.xhtml.DivType;
import org.w3._1999.xhtml.DlType;
import org.w3._1999.xhtml.EmType;
import org.w3._1999.xhtml.FieldsetType;
import org.w3._1999.xhtml.FormType;
import org.w3._1999.xhtml.H1Type;
import org.w3._1999.xhtml.H2Type;
import org.w3._1999.xhtml.H3Type;
import org.w3._1999.xhtml.H4Type;
import org.w3._1999.xhtml.H5Type;
import org.w3._1999.xhtml.H6Type;
import org.w3._1999.xhtml.HrType;
import org.w3._1999.xhtml.IType;
import org.w3._1999.xhtml.ImgType;
import org.w3._1999.xhtml.InputType1;
import org.w3._1999.xhtml.InsType;
import org.w3._1999.xhtml.KbdType;
import org.w3._1999.xhtml.LabelType;
import org.w3._1999.xhtml.MapType;
import org.w3._1999.xhtml.NoscriptType;
import org.w3._1999.xhtml.ObjectType;
import org.w3._1999.xhtml.OlType;
import org.w3._1999.xhtml.PType;
import org.w3._1999.xhtml.PreType;
import org.w3._1999.xhtml.QType;
import org.w3._1999.xhtml.SampType;
import org.w3._1999.xhtml.ScriptType;
import org.w3._1999.xhtml.SelectType;
import org.w3._1999.xhtml.SmallType;
import org.w3._1999.xhtml.SpanType;
import org.w3._1999.xhtml.StrongType;
import org.w3._1999.xhtml.SubType;
import org.w3._1999.xhtml.SupType;
import org.w3._1999.xhtml.TableType;
import org.w3._1999.xhtml.TextareaType;
import org.w3._1999.xhtml.TtType;
import org.w3._1999.xhtml.UlType;
import org.w3._1999.xhtml.VarType;

/**
 * A sample validator interface for {@link org.w3._1999.xhtml.Flow}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface FlowValidator {

    boolean validate();

    boolean validateGroup(FeatureMap value);

    boolean validateP(EList<PType> value);

    boolean validateH1(EList<H1Type> value);

    boolean validateH2(EList<H2Type> value);

    boolean validateH3(EList<H3Type> value);

    boolean validateH4(EList<H4Type> value);

    boolean validateH5(EList<H5Type> value);

    boolean validateH6(EList<H6Type> value);

    boolean validateDiv(EList<DivType> value);

    boolean validateUl(EList<UlType> value);

    boolean validateOl(EList<OlType> value);

    boolean validateDl(EList<DlType> value);

    boolean validatePre(EList<PreType> value);

    boolean validateHr(EList<HrType> value);

    boolean validateBlockquote(EList<BlockquoteType> value);

    boolean validateAddress(EList<AddressType> value);

    boolean validateFieldset(EList<FieldsetType> value);

    boolean validateTable(EList<TableType> value);

    boolean validateForm(EList<FormType> value);

    boolean validateA(EList<AType> value);

    boolean validateBr(EList<BrType> value);

    boolean validateSpan(EList<SpanType> value);

    boolean validateBdo(EList<BdoType> value);

    boolean validateMap(EList<MapType> value);

    boolean validateObject(EList<ObjectType> value);

    boolean validateImg(EList<ImgType> value);

    boolean validateTt(EList<TtType> value);

    boolean validateI(EList<IType> value);

    boolean validateB(EList<BType> value);

    boolean validateBig(EList<BigType> value);

    boolean validateSmall(EList<SmallType> value);

    boolean validateEm(EList<EmType> value);

    boolean validateStrong(EList<StrongType> value);

    boolean validateDfn(EList<DfnType> value);

    boolean validateCode(EList<CodeType> value);

    boolean validateQ(EList<QType> value);

    boolean validateSamp(EList<SampType> value);

    boolean validateKbd(EList<KbdType> value);

    boolean validateVar(EList<VarType> value);

    boolean validateCite(EList<CiteType> value);

    boolean validateAbbr(EList<AbbrType> value);

    boolean validateAcronym(EList<AcronymType> value);

    boolean validateSub(EList<SubType> value);

    boolean validateSup(EList<SupType> value);

    boolean validateInput(EList<InputType1> value);

    boolean validateSelect(EList<SelectType> value);

    boolean validateTextarea(EList<TextareaType> value);

    boolean validateLabel(EList<LabelType> value);

    boolean validateButton(EList<ButtonType> value);

    boolean validateNoscript(EList<NoscriptType> value);

    boolean validateIns(EList<InsType> value);

    boolean validateDel(EList<DelType> value);

    boolean validateScript(EList<ScriptType> value);
}
