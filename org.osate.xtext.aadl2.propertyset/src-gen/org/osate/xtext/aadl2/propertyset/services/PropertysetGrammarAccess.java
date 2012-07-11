/*
* /**
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>

*/

package org.osate.xtext.aadl2.propertyset.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

@Singleton
public class PropertysetGrammarAccess extends AbstractGrammarElementFinder {


	public class PropertySetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertySet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPropertyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cSetKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cIsKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cWithKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cImportedUnitAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cImportedUnitPropertySetCrossReference_4_1_0 = (CrossReference)cImportedUnitAssignment_4_1.eContents().get(0);
		private final RuleCall cImportedUnitPropertySetIDTerminalRuleCall_4_1_0_1 = (RuleCall)cImportedUnitPropertySetCrossReference_4_1_0.eContents().get(1);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cImportedUnitAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final CrossReference cImportedUnitPropertySetCrossReference_4_2_1_0 = (CrossReference)cImportedUnitAssignment_4_2_1.eContents().get(0);
		private final RuleCall cImportedUnitPropertySetIDTerminalRuleCall_4_2_1_0_1 = (RuleCall)cImportedUnitPropertySetCrossReference_4_2_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cOwnedPropertyTypeAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cOwnedPropertyTypePropertyTypeParserRuleCall_5_0_0 = (RuleCall)cOwnedPropertyTypeAssignment_5_0.eContents().get(0);
		private final Assignment cOwnedPropertyAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cOwnedPropertyPropertyDefinitionParserRuleCall_5_1_0 = (RuleCall)cOwnedPropertyAssignment_5_1.eContents().get(0);
		private final Assignment cOwnedPropertyConstantAssignment_5_2 = (Assignment)cAlternatives_5.eContents().get(2);
		private final RuleCall cOwnedPropertyConstantPropertyConstantParserRuleCall_5_2_0 = (RuleCall)cOwnedPropertyConstantAssignment_5_2.eContents().get(0);
		private final Keyword cEndKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final RuleCall cIDTerminalRuleCall_7 = (RuleCall)cGroup.eContents().get(7);
		private final Keyword cSemicolonKeyword_8 = (Keyword)cGroup.eContents().get(8);

		//// Properties
		//PropertySet returns aadl2::PropertySet:
		//	"property" "set" name=ID "is" ("with" importedUnit+=[aadl2::PropertySet] ("," importedUnit+=[aadl2::PropertySet])*
		//	";")* (ownedPropertyType+=PropertyType | ownedProperty+=PropertyDefinition | ownedPropertyConstant+=PropertyConstant)*
		//	"end" ID ";";
		public ParserRule getRule() { return rule; }

		//"property" "set" name=ID "is" ("with" importedUnit+=[aadl2::PropertySet] ("," importedUnit+=[aadl2::PropertySet])* ";")*
		//(ownedPropertyType+=PropertyType | ownedProperty+=PropertyDefinition | ownedPropertyConstant+=PropertyConstant)* "end"
		//ID ";"
		public Group getGroup() { return cGroup; }

		//"property"
		public Keyword getPropertyKeyword_0() { return cPropertyKeyword_0; }

		//"set"
		public Keyword getSetKeyword_1() { return cSetKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//"is"
		public Keyword getIsKeyword_3() { return cIsKeyword_3; }

		//("with" importedUnit+=[aadl2::PropertySet] ("," importedUnit+=[aadl2::PropertySet])* ";")*
		public Group getGroup_4() { return cGroup_4; }

		//"with"
		public Keyword getWithKeyword_4_0() { return cWithKeyword_4_0; }

		//importedUnit+=[aadl2::PropertySet]
		public Assignment getImportedUnitAssignment_4_1() { return cImportedUnitAssignment_4_1; }

		//[aadl2::PropertySet]
		public CrossReference getImportedUnitPropertySetCrossReference_4_1_0() { return cImportedUnitPropertySetCrossReference_4_1_0; }

		//ID
		public RuleCall getImportedUnitPropertySetIDTerminalRuleCall_4_1_0_1() { return cImportedUnitPropertySetIDTerminalRuleCall_4_1_0_1; }

		//("," importedUnit+=[aadl2::PropertySet])*
		public Group getGroup_4_2() { return cGroup_4_2; }

		//","
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }

		//importedUnit+=[aadl2::PropertySet]
		public Assignment getImportedUnitAssignment_4_2_1() { return cImportedUnitAssignment_4_2_1; }

		//[aadl2::PropertySet]
		public CrossReference getImportedUnitPropertySetCrossReference_4_2_1_0() { return cImportedUnitPropertySetCrossReference_4_2_1_0; }

		//ID
		public RuleCall getImportedUnitPropertySetIDTerminalRuleCall_4_2_1_0_1() { return cImportedUnitPropertySetIDTerminalRuleCall_4_2_1_0_1; }

		//";"
		public Keyword getSemicolonKeyword_4_3() { return cSemicolonKeyword_4_3; }

		//(ownedPropertyType+=PropertyType | ownedProperty+=PropertyDefinition | ownedPropertyConstant+=PropertyConstant)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//ownedPropertyType+=PropertyType
		public Assignment getOwnedPropertyTypeAssignment_5_0() { return cOwnedPropertyTypeAssignment_5_0; }

		//PropertyType
		public RuleCall getOwnedPropertyTypePropertyTypeParserRuleCall_5_0_0() { return cOwnedPropertyTypePropertyTypeParserRuleCall_5_0_0; }

		//ownedProperty+=PropertyDefinition
		public Assignment getOwnedPropertyAssignment_5_1() { return cOwnedPropertyAssignment_5_1; }

		//PropertyDefinition
		public RuleCall getOwnedPropertyPropertyDefinitionParserRuleCall_5_1_0() { return cOwnedPropertyPropertyDefinitionParserRuleCall_5_1_0; }

		//ownedPropertyConstant+=PropertyConstant
		public Assignment getOwnedPropertyConstantAssignment_5_2() { return cOwnedPropertyConstantAssignment_5_2; }

		//PropertyConstant
		public RuleCall getOwnedPropertyConstantPropertyConstantParserRuleCall_5_2_0() { return cOwnedPropertyConstantPropertyConstantParserRuleCall_5_2_0; }

		//"end"
		public Keyword getEndKeyword_6() { return cEndKeyword_6; }

		//ID
		public RuleCall getIDTerminalRuleCall_7() { return cIDTerminalRuleCall_7; }

		//";"
		public Keyword getSemicolonKeyword_8() { return cSemicolonKeyword_8; }
	}

	public class PropertyTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cBooleanTypeParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cStringTypeParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final RuleCall cEnumerationTypeParserRuleCall_0_2 = (RuleCall)cAlternatives_0.eContents().get(2);
		private final RuleCall cUnitsTypeParserRuleCall_0_3 = (RuleCall)cAlternatives_0.eContents().get(3);
		private final RuleCall cRealTypeParserRuleCall_0_4 = (RuleCall)cAlternatives_0.eContents().get(4);
		private final RuleCall cIntegerTypeParserRuleCall_0_5 = (RuleCall)cAlternatives_0.eContents().get(5);
		private final RuleCall cRangeTypeParserRuleCall_0_6 = (RuleCall)cAlternatives_0.eContents().get(6);
		private final RuleCall cClassifierTypeParserRuleCall_0_7 = (RuleCall)cAlternatives_0.eContents().get(7);
		private final RuleCall cReferenceTypeParserRuleCall_0_8 = (RuleCall)cAlternatives_0.eContents().get(8);
		private final RuleCall cRecordTypeParserRuleCall_0_9 = (RuleCall)cAlternatives_0.eContents().get(9);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);

		//PropertyType returns aadl2::PropertyType:
		//	(BooleanType | StringType | EnumerationType | UnitsType | RealType | IntegerType | RangeType | ClassifierType |
		//	ReferenceType | RecordType) ";";
		public ParserRule getRule() { return rule; }

		//(BooleanType | StringType | EnumerationType | UnitsType | RealType | IntegerType | RangeType | ClassifierType |
		//ReferenceType | RecordType) ";"
		public Group getGroup() { return cGroup; }

		//BooleanType | StringType | EnumerationType | UnitsType | RealType | IntegerType | RangeType | ClassifierType |
		//ReferenceType | RecordType
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//BooleanType
		public RuleCall getBooleanTypeParserRuleCall_0_0() { return cBooleanTypeParserRuleCall_0_0; }

		//StringType
		public RuleCall getStringTypeParserRuleCall_0_1() { return cStringTypeParserRuleCall_0_1; }

		//EnumerationType
		public RuleCall getEnumerationTypeParserRuleCall_0_2() { return cEnumerationTypeParserRuleCall_0_2; }

		//UnitsType
		public RuleCall getUnitsTypeParserRuleCall_0_3() { return cUnitsTypeParserRuleCall_0_3; }

		//RealType
		public RuleCall getRealTypeParserRuleCall_0_4() { return cRealTypeParserRuleCall_0_4; }

		//IntegerType
		public RuleCall getIntegerTypeParserRuleCall_0_5() { return cIntegerTypeParserRuleCall_0_5; }

		//RangeType
		public RuleCall getRangeTypeParserRuleCall_0_6() { return cRangeTypeParserRuleCall_0_6; }

		//ClassifierType
		public RuleCall getClassifierTypeParserRuleCall_0_7() { return cClassifierTypeParserRuleCall_0_7; }

		//ReferenceType
		public RuleCall getReferenceTypeParserRuleCall_0_8() { return cReferenceTypeParserRuleCall_0_8; }

		//RecordType
		public RuleCall getRecordTypeParserRuleCall_0_9() { return cRecordTypeParserRuleCall_0_9; }

		//";"
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}

	public class UnnamedPropertyTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedPropertyType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cListTypeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cUnnamedBooleanTypeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cUnnamedStringTypeParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cUnnamedEnumerationTypeParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cUnnamedUnitsTypeParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cUnnamedRealTypeParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cUnnamedIntegerTypeParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cUnnamedRangeTypeParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cUnnamedClassifierTypeParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cUnnamedReferenceTypeParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cUnnamedRecordTypeParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);

		//UnnamedPropertyType returns aadl2::PropertyType:
		//	ListType | UnnamedBooleanType | UnnamedStringType | UnnamedEnumerationType | UnnamedUnitsType | UnnamedRealType |
		//	UnnamedIntegerType | UnnamedRangeType | UnnamedClassifierType | UnnamedReferenceType | UnnamedRecordType;
		public ParserRule getRule() { return rule; }

		//ListType | UnnamedBooleanType | UnnamedStringType | UnnamedEnumerationType | UnnamedUnitsType | UnnamedRealType |
		//UnnamedIntegerType | UnnamedRangeType | UnnamedClassifierType | UnnamedReferenceType | UnnamedRecordType
		public Alternatives getAlternatives() { return cAlternatives; }

		//ListType
		public RuleCall getListTypeParserRuleCall_0() { return cListTypeParserRuleCall_0; }

		//UnnamedBooleanType
		public RuleCall getUnnamedBooleanTypeParserRuleCall_1() { return cUnnamedBooleanTypeParserRuleCall_1; }

		//UnnamedStringType
		public RuleCall getUnnamedStringTypeParserRuleCall_2() { return cUnnamedStringTypeParserRuleCall_2; }

		//UnnamedEnumerationType
		public RuleCall getUnnamedEnumerationTypeParserRuleCall_3() { return cUnnamedEnumerationTypeParserRuleCall_3; }

		//UnnamedUnitsType
		public RuleCall getUnnamedUnitsTypeParserRuleCall_4() { return cUnnamedUnitsTypeParserRuleCall_4; }

		//UnnamedRealType
		public RuleCall getUnnamedRealTypeParserRuleCall_5() { return cUnnamedRealTypeParserRuleCall_5; }

		//UnnamedIntegerType
		public RuleCall getUnnamedIntegerTypeParserRuleCall_6() { return cUnnamedIntegerTypeParserRuleCall_6; }

		//UnnamedRangeType
		public RuleCall getUnnamedRangeTypeParserRuleCall_7() { return cUnnamedRangeTypeParserRuleCall_7; }

		//UnnamedClassifierType
		public RuleCall getUnnamedClassifierTypeParserRuleCall_8() { return cUnnamedClassifierTypeParserRuleCall_8; }

		//UnnamedReferenceType
		public RuleCall getUnnamedReferenceTypeParserRuleCall_9() { return cUnnamedReferenceTypeParserRuleCall_9; }

		//UnnamedRecordType
		public RuleCall getUnnamedRecordTypeParserRuleCall_10() { return cUnnamedRecordTypeParserRuleCall_10; }
	}

	public class BooleanTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BooleanType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cAadlbooleanKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//BooleanType returns aadl2::AadlBoolean:
		//	name=ID ":" "type" "aadlboolean";
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "aadlboolean"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"aadlboolean"
		public Keyword getAadlbooleanKeyword_3() { return cAadlbooleanKeyword_3; }
	}

	public class UnnamedBooleanTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedBooleanType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAadlBooleanAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAadlbooleanKeyword_1 = (Keyword)cGroup.eContents().get(1);

		//UnnamedBooleanType returns aadl2::AadlBoolean:
		//	{aadl2::AadlBoolean} "aadlboolean";
		public ParserRule getRule() { return rule; }

		//{aadl2::AadlBoolean} "aadlboolean"
		public Group getGroup() { return cGroup; }

		//{aadl2::AadlBoolean}
		public Action getAadlBooleanAction_0() { return cAadlBooleanAction_0; }

		//"aadlboolean"
		public Keyword getAadlbooleanKeyword_1() { return cAadlbooleanKeyword_1; }
	}

	public class StringTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StringType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cAadlstringKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//StringType returns aadl2::AadlString:
		//	name=ID ":" "type" "aadlstring";
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "aadlstring"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"aadlstring"
		public Keyword getAadlstringKeyword_3() { return cAadlstringKeyword_3; }
	}

	public class UnnamedStringTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedStringType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAadlStringAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAadlstringKeyword_1 = (Keyword)cGroup.eContents().get(1);

		//UnnamedStringType returns aadl2::AadlString:
		//	{aadl2::AadlString} "aadlstring";
		public ParserRule getRule() { return rule; }

		//{aadl2::AadlString} "aadlstring"
		public Group getGroup() { return cGroup; }

		//{aadl2::AadlString}
		public Action getAadlStringAction_0() { return cAadlStringAction_0; }

		//"aadlstring"
		public Keyword getAadlstringKeyword_1() { return cAadlstringKeyword_1; }
	}

	public class EnumerationTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EnumerationType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cEnumerationKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedLiteralAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedLiteralEnumerationLiteralParserRuleCall_5_0 = (RuleCall)cOwnedLiteralAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cCommaKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cOwnedLiteralAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cOwnedLiteralEnumerationLiteralParserRuleCall_6_1_0 = (RuleCall)cOwnedLiteralAssignment_6_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_7 = (Keyword)cGroup.eContents().get(7);

		//EnumerationType returns aadl2::EnumerationType:
		//	name=ID ":" "type" "enumeration" "(" ownedLiteral+=EnumerationLiteral ("," ownedLiteral+=EnumerationLiteral)* ")";
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "enumeration" "(" ownedLiteral+=EnumerationLiteral ("," ownedLiteral+=EnumerationLiteral)* ")"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"enumeration"
		public Keyword getEnumerationKeyword_3() { return cEnumerationKeyword_3; }

		//"("
		public Keyword getLeftParenthesisKeyword_4() { return cLeftParenthesisKeyword_4; }

		//ownedLiteral+=EnumerationLiteral
		public Assignment getOwnedLiteralAssignment_5() { return cOwnedLiteralAssignment_5; }

		//EnumerationLiteral
		public RuleCall getOwnedLiteralEnumerationLiteralParserRuleCall_5_0() { return cOwnedLiteralEnumerationLiteralParserRuleCall_5_0; }

		//("," ownedLiteral+=EnumerationLiteral)*
		public Group getGroup_6() { return cGroup_6; }

		//","
		public Keyword getCommaKeyword_6_0() { return cCommaKeyword_6_0; }

		//ownedLiteral+=EnumerationLiteral
		public Assignment getOwnedLiteralAssignment_6_1() { return cOwnedLiteralAssignment_6_1; }

		//EnumerationLiteral
		public RuleCall getOwnedLiteralEnumerationLiteralParserRuleCall_6_1_0() { return cOwnedLiteralEnumerationLiteralParserRuleCall_6_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_7() { return cRightParenthesisKeyword_7; }
	}

	public class UnnamedEnumerationTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedEnumerationType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEnumerationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedLiteralAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedLiteralEnumerationLiteralParserRuleCall_2_0 = (RuleCall)cOwnedLiteralAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCommaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedLiteralAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedLiteralEnumerationLiteralParserRuleCall_3_1_0 = (RuleCall)cOwnedLiteralAssignment_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//UnnamedEnumerationType returns aadl2::EnumerationType:
		//	"enumeration" "(" ownedLiteral+=EnumerationLiteral ("," ownedLiteral+=EnumerationLiteral)* ")";
		public ParserRule getRule() { return rule; }

		//"enumeration" "(" ownedLiteral+=EnumerationLiteral ("," ownedLiteral+=EnumerationLiteral)* ")"
		public Group getGroup() { return cGroup; }

		//"enumeration"
		public Keyword getEnumerationKeyword_0() { return cEnumerationKeyword_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//ownedLiteral+=EnumerationLiteral
		public Assignment getOwnedLiteralAssignment_2() { return cOwnedLiteralAssignment_2; }

		//EnumerationLiteral
		public RuleCall getOwnedLiteralEnumerationLiteralParserRuleCall_2_0() { return cOwnedLiteralEnumerationLiteralParserRuleCall_2_0; }

		//("," ownedLiteral+=EnumerationLiteral)*
		public Group getGroup_3() { return cGroup_3; }

		//","
		public Keyword getCommaKeyword_3_0() { return cCommaKeyword_3_0; }

		//ownedLiteral+=EnumerationLiteral
		public Assignment getOwnedLiteralAssignment_3_1() { return cOwnedLiteralAssignment_3_1; }

		//EnumerationLiteral
		public RuleCall getOwnedLiteralEnumerationLiteralParserRuleCall_3_1_0() { return cOwnedLiteralEnumerationLiteralParserRuleCall_3_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class EnumerationLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EnumerationLiteral");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);

		//EnumerationLiteral returns aadl2::EnumerationLiteral:
		//	name=ID;
		public ParserRule getRule() { return rule; }

		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}

	public class UnitsTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnitsType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cUnitsKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedLiteralAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedLiteralUnitLiteralParserRuleCall_5_0 = (RuleCall)cOwnedLiteralAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cCommaKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cOwnedLiteralAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cOwnedLiteralUnitLiteralConversionParserRuleCall_6_1_0 = (RuleCall)cOwnedLiteralAssignment_6_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_7 = (Keyword)cGroup.eContents().get(7);

		//UnitsType returns aadl2::UnitsType:
		//	name=ID ":" "type" "units" "(" ownedLiteral+=UnitLiteral ("," ownedLiteral+=UnitLiteralConversion)* ")";
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "units" "(" ownedLiteral+=UnitLiteral ("," ownedLiteral+=UnitLiteralConversion)* ")"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"units"
		public Keyword getUnitsKeyword_3() { return cUnitsKeyword_3; }

		//"("
		public Keyword getLeftParenthesisKeyword_4() { return cLeftParenthesisKeyword_4; }

		//ownedLiteral+=UnitLiteral
		public Assignment getOwnedLiteralAssignment_5() { return cOwnedLiteralAssignment_5; }

		//UnitLiteral
		public RuleCall getOwnedLiteralUnitLiteralParserRuleCall_5_0() { return cOwnedLiteralUnitLiteralParserRuleCall_5_0; }

		//("," ownedLiteral+=UnitLiteralConversion)*
		public Group getGroup_6() { return cGroup_6; }

		//","
		public Keyword getCommaKeyword_6_0() { return cCommaKeyword_6_0; }

		//ownedLiteral+=UnitLiteralConversion
		public Assignment getOwnedLiteralAssignment_6_1() { return cOwnedLiteralAssignment_6_1; }

		//UnitLiteralConversion
		public RuleCall getOwnedLiteralUnitLiteralConversionParserRuleCall_6_1_0() { return cOwnedLiteralUnitLiteralConversionParserRuleCall_6_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_7() { return cRightParenthesisKeyword_7; }
	}

	public class UnnamedUnitsTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedUnitsType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cUnitsKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedLiteralAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedLiteralUnitLiteralParserRuleCall_2_0 = (RuleCall)cOwnedLiteralAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCommaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedLiteralAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedLiteralUnitLiteralConversionParserRuleCall_3_1_0 = (RuleCall)cOwnedLiteralAssignment_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//UnnamedUnitsType returns aadl2::UnitsType:
		//	"units" "(" ownedLiteral+=UnitLiteral ("," ownedLiteral+=UnitLiteralConversion)* ")";
		public ParserRule getRule() { return rule; }

		//"units" "(" ownedLiteral+=UnitLiteral ("," ownedLiteral+=UnitLiteralConversion)* ")"
		public Group getGroup() { return cGroup; }

		//"units"
		public Keyword getUnitsKeyword_0() { return cUnitsKeyword_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//ownedLiteral+=UnitLiteral
		public Assignment getOwnedLiteralAssignment_2() { return cOwnedLiteralAssignment_2; }

		//UnitLiteral
		public RuleCall getOwnedLiteralUnitLiteralParserRuleCall_2_0() { return cOwnedLiteralUnitLiteralParserRuleCall_2_0; }

		//("," ownedLiteral+=UnitLiteralConversion)*
		public Group getGroup_3() { return cGroup_3; }

		//","
		public Keyword getCommaKeyword_3_0() { return cCommaKeyword_3_0; }

		//ownedLiteral+=UnitLiteralConversion
		public Assignment getOwnedLiteralAssignment_3_1() { return cOwnedLiteralAssignment_3_1; }

		//UnitLiteralConversion
		public RuleCall getOwnedLiteralUnitLiteralConversionParserRuleCall_3_1_0() { return cOwnedLiteralUnitLiteralConversionParserRuleCall_3_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class UnitLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnitLiteral");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);

		//UnitLiteral returns aadl2::UnitLiteral:
		//	name=ID;
		public ParserRule getRule() { return rule; }

		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}

	public class UnitLiteralConversionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnitLiteralConversion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cBaseUnitAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cBaseUnitUnitLiteralCrossReference_2_0 = (CrossReference)cBaseUnitAssignment_2.eContents().get(0);
		private final RuleCall cBaseUnitUnitLiteralIDTerminalRuleCall_2_0_1 = (RuleCall)cBaseUnitUnitLiteralCrossReference_2_0.eContents().get(1);
		private final RuleCall cSTARParserRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Assignment cFactorAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cFactorNumberValueParserRuleCall_4_0 = (RuleCall)cFactorAssignment_4.eContents().get(0);

		//UnitLiteralConversion returns aadl2::UnitLiteral:
		//	name=ID "=>" baseUnit=[aadl2::UnitLiteral] STAR factor=NumberValue;
		public ParserRule getRule() { return rule; }

		//name=ID "=>" baseUnit=[aadl2::UnitLiteral] STAR factor=NumberValue
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }

		//baseUnit=[aadl2::UnitLiteral]
		public Assignment getBaseUnitAssignment_2() { return cBaseUnitAssignment_2; }

		//[aadl2::UnitLiteral]
		public CrossReference getBaseUnitUnitLiteralCrossReference_2_0() { return cBaseUnitUnitLiteralCrossReference_2_0; }

		//ID
		public RuleCall getBaseUnitUnitLiteralIDTerminalRuleCall_2_0_1() { return cBaseUnitUnitLiteralIDTerminalRuleCall_2_0_1; }

		//STAR
		public RuleCall getSTARParserRuleCall_3() { return cSTARParserRuleCall_3; }

		//factor=NumberValue
		public Assignment getFactorAssignment_4() { return cFactorAssignment_4; }

		//NumberValue
		public RuleCall getFactorNumberValueParserRuleCall_4_0() { return cFactorNumberValueParserRuleCall_4_0; }
	}

	public class RealTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RealType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cAadlrealKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRangeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRangeRealRangeParserRuleCall_4_0 = (RuleCall)cRangeAssignment_4.eContents().get(0);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cOwnedUnitsTypeAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_5_0_0 = (RuleCall)cOwnedUnitsTypeAssignment_5_0.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cAlternatives_5.eContents().get(1);
		private final Keyword cUnitsKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cUnitsTypeAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final CrossReference cUnitsTypeUnitsTypeCrossReference_5_1_1_0 = (CrossReference)cUnitsTypeAssignment_5_1_1.eContents().get(0);
		private final RuleCall cUnitsTypeUnitsTypeQPREFParserRuleCall_5_1_1_0_1 = (RuleCall)cUnitsTypeUnitsTypeCrossReference_5_1_1_0.eContents().get(1);

		//RealType returns aadl2::AadlReal:
		//	name=ID ":" "type" "aadlreal" range=RealRange? (ownedUnitsType=UnnamedUnitsType | "units"
		//	unitsType=[aadl2::UnitsType|QPREF])?;
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "aadlreal" range=RealRange? (ownedUnitsType=UnnamedUnitsType | "units"
		//unitsType=[aadl2::UnitsType|QPREF])?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"aadlreal"
		public Keyword getAadlrealKeyword_3() { return cAadlrealKeyword_3; }

		//range=RealRange?
		public Assignment getRangeAssignment_4() { return cRangeAssignment_4; }

		//RealRange
		public RuleCall getRangeRealRangeParserRuleCall_4_0() { return cRangeRealRangeParserRuleCall_4_0; }

		//(ownedUnitsType=UnnamedUnitsType | "units" unitsType=[aadl2::UnitsType|QPREF])?
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//ownedUnitsType=UnnamedUnitsType
		public Assignment getOwnedUnitsTypeAssignment_5_0() { return cOwnedUnitsTypeAssignment_5_0; }

		//UnnamedUnitsType
		public RuleCall getOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_5_0_0() { return cOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_5_0_0; }

		//"units" unitsType=[aadl2::UnitsType|QPREF]
		public Group getGroup_5_1() { return cGroup_5_1; }

		//"units"
		public Keyword getUnitsKeyword_5_1_0() { return cUnitsKeyword_5_1_0; }

		//unitsType=[aadl2::UnitsType|QPREF]
		public Assignment getUnitsTypeAssignment_5_1_1() { return cUnitsTypeAssignment_5_1_1; }

		//[aadl2::UnitsType|QPREF]
		public CrossReference getUnitsTypeUnitsTypeCrossReference_5_1_1_0() { return cUnitsTypeUnitsTypeCrossReference_5_1_1_0; }

		//QPREF
		public RuleCall getUnitsTypeUnitsTypeQPREFParserRuleCall_5_1_1_0_1() { return cUnitsTypeUnitsTypeQPREFParserRuleCall_5_1_1_0_1; }
	}

	public class UnnamedRealTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedRealType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAadlRealAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAadlrealKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRangeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRangeRealRangeParserRuleCall_2_0 = (RuleCall)cRangeAssignment_2.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cOwnedUnitsTypeAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_3_0_0 = (RuleCall)cOwnedUnitsTypeAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cAlternatives_3.eContents().get(1);
		private final Keyword cUnitsKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cUnitsTypeAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final CrossReference cUnitsTypeUnitsTypeCrossReference_3_1_1_0 = (CrossReference)cUnitsTypeAssignment_3_1_1.eContents().get(0);
		private final RuleCall cUnitsTypeUnitsTypeQPREFParserRuleCall_3_1_1_0_1 = (RuleCall)cUnitsTypeUnitsTypeCrossReference_3_1_1_0.eContents().get(1);

		//UnnamedRealType returns aadl2::AadlReal:
		//	{aadl2::AadlReal} "aadlreal" range=RealRange? (ownedUnitsType=UnnamedUnitsType | "units"
		//	unitsType=[aadl2::UnitsType|QPREF])?;
		public ParserRule getRule() { return rule; }

		//{aadl2::AadlReal} "aadlreal" range=RealRange? (ownedUnitsType=UnnamedUnitsType | "units"
		//unitsType=[aadl2::UnitsType|QPREF])?
		public Group getGroup() { return cGroup; }

		//{aadl2::AadlReal}
		public Action getAadlRealAction_0() { return cAadlRealAction_0; }

		//"aadlreal"
		public Keyword getAadlrealKeyword_1() { return cAadlrealKeyword_1; }

		//range=RealRange?
		public Assignment getRangeAssignment_2() { return cRangeAssignment_2; }

		//RealRange
		public RuleCall getRangeRealRangeParserRuleCall_2_0() { return cRangeRealRangeParserRuleCall_2_0; }

		//(ownedUnitsType=UnnamedUnitsType | "units" unitsType=[aadl2::UnitsType|QPREF])?
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//ownedUnitsType=UnnamedUnitsType
		public Assignment getOwnedUnitsTypeAssignment_3_0() { return cOwnedUnitsTypeAssignment_3_0; }

		//UnnamedUnitsType
		public RuleCall getOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_3_0_0() { return cOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_3_0_0; }

		//"units" unitsType=[aadl2::UnitsType|QPREF]
		public Group getGroup_3_1() { return cGroup_3_1; }

		//"units"
		public Keyword getUnitsKeyword_3_1_0() { return cUnitsKeyword_3_1_0; }

		//unitsType=[aadl2::UnitsType|QPREF]
		public Assignment getUnitsTypeAssignment_3_1_1() { return cUnitsTypeAssignment_3_1_1; }

		//[aadl2::UnitsType|QPREF]
		public CrossReference getUnitsTypeUnitsTypeCrossReference_3_1_1_0() { return cUnitsTypeUnitsTypeCrossReference_3_1_1_0; }

		//QPREF
		public RuleCall getUnitsTypeUnitsTypeQPREFParserRuleCall_3_1_1_0_1() { return cUnitsTypeUnitsTypeQPREFParserRuleCall_3_1_1_0_1; }
	}

	public class IntegerTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntegerType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cAadlintegerKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRangeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRangeIntegerRangeParserRuleCall_4_0 = (RuleCall)cRangeAssignment_4.eContents().get(0);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cOwnedUnitsTypeAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_5_0_0 = (RuleCall)cOwnedUnitsTypeAssignment_5_0.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cAlternatives_5.eContents().get(1);
		private final Keyword cUnitsKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cUnitsTypeAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final CrossReference cUnitsTypeUnitsTypeCrossReference_5_1_1_0 = (CrossReference)cUnitsTypeAssignment_5_1_1.eContents().get(0);
		private final RuleCall cUnitsTypeUnitsTypeQPREFParserRuleCall_5_1_1_0_1 = (RuleCall)cUnitsTypeUnitsTypeCrossReference_5_1_1_0.eContents().get(1);

		//IntegerType returns aadl2::AadlInteger:
		//	name=ID ":" "type" "aadlinteger" range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | "units"
		//	unitsType=[aadl2::UnitsType|QPREF])?;
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "aadlinteger" range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | "units"
		//unitsType=[aadl2::UnitsType|QPREF])?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"aadlinteger"
		public Keyword getAadlintegerKeyword_3() { return cAadlintegerKeyword_3; }

		//range=IntegerRange?
		public Assignment getRangeAssignment_4() { return cRangeAssignment_4; }

		//IntegerRange
		public RuleCall getRangeIntegerRangeParserRuleCall_4_0() { return cRangeIntegerRangeParserRuleCall_4_0; }

		//(ownedUnitsType=UnnamedUnitsType | "units" unitsType=[aadl2::UnitsType|QPREF])?
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//ownedUnitsType=UnnamedUnitsType
		public Assignment getOwnedUnitsTypeAssignment_5_0() { return cOwnedUnitsTypeAssignment_5_0; }

		//UnnamedUnitsType
		public RuleCall getOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_5_0_0() { return cOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_5_0_0; }

		//"units" unitsType=[aadl2::UnitsType|QPREF]
		public Group getGroup_5_1() { return cGroup_5_1; }

		//"units"
		public Keyword getUnitsKeyword_5_1_0() { return cUnitsKeyword_5_1_0; }

		//unitsType=[aadl2::UnitsType|QPREF]
		public Assignment getUnitsTypeAssignment_5_1_1() { return cUnitsTypeAssignment_5_1_1; }

		//[aadl2::UnitsType|QPREF]
		public CrossReference getUnitsTypeUnitsTypeCrossReference_5_1_1_0() { return cUnitsTypeUnitsTypeCrossReference_5_1_1_0; }

		//QPREF
		public RuleCall getUnitsTypeUnitsTypeQPREFParserRuleCall_5_1_1_0_1() { return cUnitsTypeUnitsTypeQPREFParserRuleCall_5_1_1_0_1; }
	}

	public class UnnamedIntegerTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedIntegerType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAadlIntegerAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAadlintegerKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRangeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRangeIntegerRangeParserRuleCall_2_0 = (RuleCall)cRangeAssignment_2.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cOwnedUnitsTypeAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_3_0_0 = (RuleCall)cOwnedUnitsTypeAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cAlternatives_3.eContents().get(1);
		private final Keyword cUnitsKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cUnitsTypeAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final CrossReference cUnitsTypeUnitsTypeCrossReference_3_1_1_0 = (CrossReference)cUnitsTypeAssignment_3_1_1.eContents().get(0);
		private final RuleCall cUnitsTypeUnitsTypeQPREFParserRuleCall_3_1_1_0_1 = (RuleCall)cUnitsTypeUnitsTypeCrossReference_3_1_1_0.eContents().get(1);

		//UnnamedIntegerType returns aadl2::AadlInteger:
		//	{aadl2::AadlInteger} "aadlinteger" range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | "units"
		//	unitsType=[aadl2::UnitsType|QPREF])?;
		public ParserRule getRule() { return rule; }

		//{aadl2::AadlInteger} "aadlinteger" range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | "units"
		//unitsType=[aadl2::UnitsType|QPREF])?
		public Group getGroup() { return cGroup; }

		//{aadl2::AadlInteger}
		public Action getAadlIntegerAction_0() { return cAadlIntegerAction_0; }

		//"aadlinteger"
		public Keyword getAadlintegerKeyword_1() { return cAadlintegerKeyword_1; }

		//range=IntegerRange?
		public Assignment getRangeAssignment_2() { return cRangeAssignment_2; }

		//IntegerRange
		public RuleCall getRangeIntegerRangeParserRuleCall_2_0() { return cRangeIntegerRangeParserRuleCall_2_0; }

		//(ownedUnitsType=UnnamedUnitsType | "units" unitsType=[aadl2::UnitsType|QPREF])?
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//ownedUnitsType=UnnamedUnitsType
		public Assignment getOwnedUnitsTypeAssignment_3_0() { return cOwnedUnitsTypeAssignment_3_0; }

		//UnnamedUnitsType
		public RuleCall getOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_3_0_0() { return cOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_3_0_0; }

		//"units" unitsType=[aadl2::UnitsType|QPREF]
		public Group getGroup_3_1() { return cGroup_3_1; }

		//"units"
		public Keyword getUnitsKeyword_3_1_0() { return cUnitsKeyword_3_1_0; }

		//unitsType=[aadl2::UnitsType|QPREF]
		public Assignment getUnitsTypeAssignment_3_1_1() { return cUnitsTypeAssignment_3_1_1; }

		//[aadl2::UnitsType|QPREF]
		public CrossReference getUnitsTypeUnitsTypeCrossReference_3_1_1_0() { return cUnitsTypeUnitsTypeCrossReference_3_1_1_0; }

		//QPREF
		public RuleCall getUnitsTypeUnitsTypeQPREFParserRuleCall_3_1_1_0_1() { return cUnitsTypeUnitsTypeQPREFParserRuleCall_3_1_1_0_1; }
	}

	public class RangeTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RangeType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cRangeKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cOfKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cOwnedNumberTypeAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final Alternatives cOwnedNumberTypeAlternatives_5_0_0 = (Alternatives)cOwnedNumberTypeAssignment_5_0.eContents().get(0);
		private final RuleCall cOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_5_0_0_0 = (RuleCall)cOwnedNumberTypeAlternatives_5_0_0.eContents().get(0);
		private final RuleCall cOwnedNumberTypeUnnamedRealTypeParserRuleCall_5_0_0_1 = (RuleCall)cOwnedNumberTypeAlternatives_5_0_0.eContents().get(1);
		private final Assignment cNumberTypeAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final CrossReference cNumberTypeNumberTypeCrossReference_5_1_0 = (CrossReference)cNumberTypeAssignment_5_1.eContents().get(0);
		private final RuleCall cNumberTypeNumberTypeQPREFParserRuleCall_5_1_0_1 = (RuleCall)cNumberTypeNumberTypeCrossReference_5_1_0.eContents().get(1);

		//RangeType returns aadl2::RangeType:
		//	name=ID ":" "type" "range" "of" (ownedNumberType=(UnnamedIntegerType | UnnamedRealType) |
		//	numberType=[aadl2::NumberType|QPREF]);
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "range" "of" (ownedNumberType=(UnnamedIntegerType | UnnamedRealType) |
		//numberType=[aadl2::NumberType|QPREF])
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"range"
		public Keyword getRangeKeyword_3() { return cRangeKeyword_3; }

		//"of"
		public Keyword getOfKeyword_4() { return cOfKeyword_4; }

		//ownedNumberType=(UnnamedIntegerType | UnnamedRealType) | numberType=[aadl2::NumberType|QPREF]
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//ownedNumberType=(UnnamedIntegerType | UnnamedRealType)
		public Assignment getOwnedNumberTypeAssignment_5_0() { return cOwnedNumberTypeAssignment_5_0; }

		//UnnamedIntegerType | UnnamedRealType
		public Alternatives getOwnedNumberTypeAlternatives_5_0_0() { return cOwnedNumberTypeAlternatives_5_0_0; }

		//UnnamedIntegerType
		public RuleCall getOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_5_0_0_0() { return cOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_5_0_0_0; }

		//UnnamedRealType
		public RuleCall getOwnedNumberTypeUnnamedRealTypeParserRuleCall_5_0_0_1() { return cOwnedNumberTypeUnnamedRealTypeParserRuleCall_5_0_0_1; }

		//numberType=[aadl2::NumberType|QPREF]
		public Assignment getNumberTypeAssignment_5_1() { return cNumberTypeAssignment_5_1; }

		//[aadl2::NumberType|QPREF]
		public CrossReference getNumberTypeNumberTypeCrossReference_5_1_0() { return cNumberTypeNumberTypeCrossReference_5_1_0; }

		//QPREF
		public RuleCall getNumberTypeNumberTypeQPREFParserRuleCall_5_1_0_1() { return cNumberTypeNumberTypeQPREFParserRuleCall_5_1_0_1; }
	}

	public class UnnamedRangeTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedRangeType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRangeTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cRangeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cOfKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cOwnedNumberTypeAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final Alternatives cOwnedNumberTypeAlternatives_3_0_0 = (Alternatives)cOwnedNumberTypeAssignment_3_0.eContents().get(0);
		private final RuleCall cOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_3_0_0_0 = (RuleCall)cOwnedNumberTypeAlternatives_3_0_0.eContents().get(0);
		private final RuleCall cOwnedNumberTypeUnnamedRealTypeParserRuleCall_3_0_0_1 = (RuleCall)cOwnedNumberTypeAlternatives_3_0_0.eContents().get(1);
		private final Assignment cNumberTypeAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final CrossReference cNumberTypeNumberTypeCrossReference_3_1_0 = (CrossReference)cNumberTypeAssignment_3_1.eContents().get(0);
		private final RuleCall cNumberTypeNumberTypeQPREFParserRuleCall_3_1_0_1 = (RuleCall)cNumberTypeNumberTypeCrossReference_3_1_0.eContents().get(1);

		//UnnamedRangeType returns aadl2::RangeType:
		//	{aadl2::RangeType} "range" "of" (ownedNumberType=(UnnamedIntegerType | UnnamedRealType) |
		//	numberType=[aadl2::NumberType|QPREF]);
		public ParserRule getRule() { return rule; }

		//{aadl2::RangeType} "range" "of" (ownedNumberType=(UnnamedIntegerType | UnnamedRealType) |
		//numberType=[aadl2::NumberType|QPREF])
		public Group getGroup() { return cGroup; }

		//{aadl2::RangeType}
		public Action getRangeTypeAction_0() { return cRangeTypeAction_0; }

		//"range"
		public Keyword getRangeKeyword_1() { return cRangeKeyword_1; }

		//"of"
		public Keyword getOfKeyword_2() { return cOfKeyword_2; }

		//ownedNumberType=(UnnamedIntegerType | UnnamedRealType) | numberType=[aadl2::NumberType|QPREF]
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//ownedNumberType=(UnnamedIntegerType | UnnamedRealType)
		public Assignment getOwnedNumberTypeAssignment_3_0() { return cOwnedNumberTypeAssignment_3_0; }

		//UnnamedIntegerType | UnnamedRealType
		public Alternatives getOwnedNumberTypeAlternatives_3_0_0() { return cOwnedNumberTypeAlternatives_3_0_0; }

		//UnnamedIntegerType
		public RuleCall getOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_3_0_0_0() { return cOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_3_0_0_0; }

		//UnnamedRealType
		public RuleCall getOwnedNumberTypeUnnamedRealTypeParserRuleCall_3_0_0_1() { return cOwnedNumberTypeUnnamedRealTypeParserRuleCall_3_0_0_1; }

		//numberType=[aadl2::NumberType|QPREF]
		public Assignment getNumberTypeAssignment_3_1() { return cNumberTypeAssignment_3_1; }

		//[aadl2::NumberType|QPREF]
		public CrossReference getNumberTypeNumberTypeCrossReference_3_1_0() { return cNumberTypeNumberTypeCrossReference_3_1_0; }

		//QPREF
		public RuleCall getNumberTypeNumberTypeQPREFParserRuleCall_3_1_0_1() { return cNumberTypeNumberTypeQPREFParserRuleCall_3_1_0_1; }
	}

	public class ClassifierTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClassifierType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cClassifierKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cClassifierReferenceAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cClassifierReferenceQMReferenceParserRuleCall_4_1_0 = (RuleCall)cClassifierReferenceAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cClassifierReferenceAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cClassifierReferenceQMReferenceParserRuleCall_4_2_1_0 = (RuleCall)cClassifierReferenceAssignment_4_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);

		//ClassifierType returns aadl2::ClassifierType:
		//	name=ID ":" "type" "classifier" ("(" classifierReference+=QMReference ("," classifierReference+=QMReference)* ")")?;
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "classifier" ("(" classifierReference+=QMReference ("," classifierReference+=QMReference)* ")")?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"classifier"
		public Keyword getClassifierKeyword_3() { return cClassifierKeyword_3; }

		//("(" classifierReference+=QMReference ("," classifierReference+=QMReference)* ")")?
		public Group getGroup_4() { return cGroup_4; }

		//"("
		public Keyword getLeftParenthesisKeyword_4_0() { return cLeftParenthesisKeyword_4_0; }

		//classifierReference+=QMReference
		public Assignment getClassifierReferenceAssignment_4_1() { return cClassifierReferenceAssignment_4_1; }

		//QMReference
		public RuleCall getClassifierReferenceQMReferenceParserRuleCall_4_1_0() { return cClassifierReferenceQMReferenceParserRuleCall_4_1_0; }

		//("," classifierReference+=QMReference)*
		public Group getGroup_4_2() { return cGroup_4_2; }

		//","
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }

		//classifierReference+=QMReference
		public Assignment getClassifierReferenceAssignment_4_2_1() { return cClassifierReferenceAssignment_4_2_1; }

		//QMReference
		public RuleCall getClassifierReferenceQMReferenceParserRuleCall_4_2_1_0() { return cClassifierReferenceQMReferenceParserRuleCall_4_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4_3() { return cRightParenthesisKeyword_4_3; }
	}

	public class UnnamedClassifierTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedClassifierType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cClassifierTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cClassifierKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cClassifierReferenceAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cClassifierReferenceQMReferenceParserRuleCall_2_1_0 = (RuleCall)cClassifierReferenceAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cClassifierReferenceAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cClassifierReferenceQMReferenceParserRuleCall_2_2_1_0 = (RuleCall)cClassifierReferenceAssignment_2_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);

		//UnnamedClassifierType returns aadl2::ClassifierType:
		//	{aadl2::ClassifierType} "classifier" ("(" classifierReference+=QMReference ("," classifierReference+=QMReference)*
		//	")")?;
		public ParserRule getRule() { return rule; }

		//{aadl2::ClassifierType} "classifier" ("(" classifierReference+=QMReference ("," classifierReference+=QMReference)* ")")?
		public Group getGroup() { return cGroup; }

		//{aadl2::ClassifierType}
		public Action getClassifierTypeAction_0() { return cClassifierTypeAction_0; }

		//"classifier"
		public Keyword getClassifierKeyword_1() { return cClassifierKeyword_1; }

		//("(" classifierReference+=QMReference ("," classifierReference+=QMReference)* ")")?
		public Group getGroup_2() { return cGroup_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//classifierReference+=QMReference
		public Assignment getClassifierReferenceAssignment_2_1() { return cClassifierReferenceAssignment_2_1; }

		//QMReference
		public RuleCall getClassifierReferenceQMReferenceParserRuleCall_2_1_0() { return cClassifierReferenceQMReferenceParserRuleCall_2_1_0; }

		//("," classifierReference+=QMReference)*
		public Group getGroup_2_2() { return cGroup_2_2; }

		//","
		public Keyword getCommaKeyword_2_2_0() { return cCommaKeyword_2_2_0; }

		//classifierReference+=QMReference
		public Assignment getClassifierReferenceAssignment_2_2_1() { return cClassifierReferenceAssignment_2_2_1; }

		//QMReference
		public RuleCall getClassifierReferenceQMReferenceParserRuleCall_2_2_1_0() { return cClassifierReferenceQMReferenceParserRuleCall_2_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_2_3() { return cRightParenthesisKeyword_2_3; }
	}

	public class QMReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QMReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cAnnexNameAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cAnnexNameIDTerminalRuleCall_0_1_0 = (RuleCall)cAnnexNameAssignment_0_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final RuleCall cSTARParserRuleCall_0_3 = (RuleCall)cGroup_0.eContents().get(3);
		private final RuleCall cSTARParserRuleCall_0_4 = (RuleCall)cGroup_0.eContents().get(4);
		private final Assignment cMetaclassNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cMetaclassNameAlternatives_1_0 = (Alternatives)cMetaclassNameAssignment_1.eContents().get(0);
		private final RuleCall cMetaclassNameCoreKeyWordParserRuleCall_1_0_0 = (RuleCall)cMetaclassNameAlternatives_1_0.eContents().get(0);
		private final RuleCall cMetaclassNameIDTerminalRuleCall_1_0_1 = (RuleCall)cMetaclassNameAlternatives_1_0.eContents().get(1);

		//QMReference returns aadl2::MetaclassReference:
		//	("{" annexName=ID "}" STAR STAR)? metaclassName+=(CoreKeyWord | ID)+;
		public ParserRule getRule() { return rule; }

		//("{" annexName=ID "}" STAR STAR)? metaclassName+=(CoreKeyWord | ID)+
		public Group getGroup() { return cGroup; }

		//("{" annexName=ID "}" STAR STAR)?
		public Group getGroup_0() { return cGroup_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0_0() { return cLeftCurlyBracketKeyword_0_0; }

		//annexName=ID
		public Assignment getAnnexNameAssignment_0_1() { return cAnnexNameAssignment_0_1; }

		//ID
		public RuleCall getAnnexNameIDTerminalRuleCall_0_1_0() { return cAnnexNameIDTerminalRuleCall_0_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_0_2() { return cRightCurlyBracketKeyword_0_2; }

		//STAR
		public RuleCall getSTARParserRuleCall_0_3() { return cSTARParserRuleCall_0_3; }

		//STAR
		public RuleCall getSTARParserRuleCall_0_4() { return cSTARParserRuleCall_0_4; }

		//metaclassName+=(CoreKeyWord | ID)+
		public Assignment getMetaclassNameAssignment_1() { return cMetaclassNameAssignment_1; }

		//CoreKeyWord | ID
		public Alternatives getMetaclassNameAlternatives_1_0() { return cMetaclassNameAlternatives_1_0; }

		//CoreKeyWord
		public RuleCall getMetaclassNameCoreKeyWordParserRuleCall_1_0_0() { return cMetaclassNameCoreKeyWordParserRuleCall_1_0_0; }

		//ID
		public RuleCall getMetaclassNameIDTerminalRuleCall_1_0_1() { return cMetaclassNameIDTerminalRuleCall_1_0_1; }
	}

	public class QCReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QCReference");
		private final Assignment cClassifierAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cClassifierComponentClassifierCrossReference_0 = (CrossReference)cClassifierAssignment.eContents().get(0);
		private final RuleCall cClassifierComponentClassifierFQCREFParserRuleCall_0_1 = (RuleCall)cClassifierComponentClassifierCrossReference_0.eContents().get(1);

		//QCReference returns aadl2::ClassifierValue:
		//	classifier=[aadl2::ComponentClassifier|FQCREF];
		public ParserRule getRule() { return rule; }

		//classifier=[aadl2::ComponentClassifier|FQCREF]
		public Assignment getClassifierAssignment() { return cClassifierAssignment; }

		//[aadl2::ComponentClassifier|FQCREF]
		public CrossReference getClassifierComponentClassifierCrossReference_0() { return cClassifierComponentClassifierCrossReference_0; }

		//FQCREF
		public RuleCall getClassifierComponentClassifierFQCREFParserRuleCall_0_1() { return cClassifierComponentClassifierFQCREFParserRuleCall_0_1; }
	}

	public class ReferenceTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReferenceType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cReferenceKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cNamedElementReferenceAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cNamedElementReferenceQMReferenceParserRuleCall_4_1_0 = (RuleCall)cNamedElementReferenceAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cNamedElementReferenceAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cNamedElementReferenceQMReferenceParserRuleCall_4_2_1_0 = (RuleCall)cNamedElementReferenceAssignment_4_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);

		//ReferenceType returns aadl2::ReferenceType:
		//	name=ID ":" "type" "reference" ("(" namedElementReference+=QMReference ("," namedElementReference+=QMReference)*
		//	")")?;
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "reference" ("(" namedElementReference+=QMReference ("," namedElementReference+=QMReference)* ")")?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"reference"
		public Keyword getReferenceKeyword_3() { return cReferenceKeyword_3; }

		//("(" namedElementReference+=QMReference ("," namedElementReference+=QMReference)* ")")?
		public Group getGroup_4() { return cGroup_4; }

		//"("
		public Keyword getLeftParenthesisKeyword_4_0() { return cLeftParenthesisKeyword_4_0; }

		//namedElementReference+=QMReference
		public Assignment getNamedElementReferenceAssignment_4_1() { return cNamedElementReferenceAssignment_4_1; }

		//QMReference
		public RuleCall getNamedElementReferenceQMReferenceParserRuleCall_4_1_0() { return cNamedElementReferenceQMReferenceParserRuleCall_4_1_0; }

		//("," namedElementReference+=QMReference)*
		public Group getGroup_4_2() { return cGroup_4_2; }

		//","
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }

		//namedElementReference+=QMReference
		public Assignment getNamedElementReferenceAssignment_4_2_1() { return cNamedElementReferenceAssignment_4_2_1; }

		//QMReference
		public RuleCall getNamedElementReferenceQMReferenceParserRuleCall_4_2_1_0() { return cNamedElementReferenceQMReferenceParserRuleCall_4_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4_3() { return cRightParenthesisKeyword_4_3; }
	}

	public class UnnamedReferenceTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedReferenceType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReferenceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cReferenceTypeAction_1 = (Action)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cNamedElementReferenceAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cNamedElementReferenceQMReferenceParserRuleCall_2_1_0 = (RuleCall)cNamedElementReferenceAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cNamedElementReferenceAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cNamedElementReferenceQMReferenceParserRuleCall_2_2_1_0 = (RuleCall)cNamedElementReferenceAssignment_2_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);

		//UnnamedReferenceType returns aadl2::ReferenceType:
		//	"reference" {aadl2::ReferenceType} ("(" namedElementReference+=QMReference ("," namedElementReference+=QMReference)*
		//	")")?;
		public ParserRule getRule() { return rule; }

		//"reference" {aadl2::ReferenceType} ("(" namedElementReference+=QMReference ("," namedElementReference+=QMReference)*
		//")")?
		public Group getGroup() { return cGroup; }

		//"reference"
		public Keyword getReferenceKeyword_0() { return cReferenceKeyword_0; }

		//{aadl2::ReferenceType}
		public Action getReferenceTypeAction_1() { return cReferenceTypeAction_1; }

		//("(" namedElementReference+=QMReference ("," namedElementReference+=QMReference)* ")")?
		public Group getGroup_2() { return cGroup_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//namedElementReference+=QMReference
		public Assignment getNamedElementReferenceAssignment_2_1() { return cNamedElementReferenceAssignment_2_1; }

		//QMReference
		public RuleCall getNamedElementReferenceQMReferenceParserRuleCall_2_1_0() { return cNamedElementReferenceQMReferenceParserRuleCall_2_1_0; }

		//("," namedElementReference+=QMReference)*
		public Group getGroup_2_2() { return cGroup_2_2; }

		//","
		public Keyword getCommaKeyword_2_2_0() { return cCommaKeyword_2_2_0; }

		//namedElementReference+=QMReference
		public Assignment getNamedElementReferenceAssignment_2_2_1() { return cNamedElementReferenceAssignment_2_2_1; }

		//QMReference
		public RuleCall getNamedElementReferenceQMReferenceParserRuleCall_2_2_1_0() { return cNamedElementReferenceQMReferenceParserRuleCall_2_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_2_3() { return cRightParenthesisKeyword_2_3; }
	}

	public class RecordTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RecordType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cRecordKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedFieldAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedFieldRecordFieldParserRuleCall_5_0 = (RuleCall)cOwnedFieldAssignment_5.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);

		//RecordType returns aadl2::RecordType:
		//	name=ID ":" "type" "record" "(" ownedField+=RecordField+ ")";
		public ParserRule getRule() { return rule; }

		//name=ID ":" "type" "record" "(" ownedField+=RecordField+ ")"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"record"
		public Keyword getRecordKeyword_3() { return cRecordKeyword_3; }

		//"("
		public Keyword getLeftParenthesisKeyword_4() { return cLeftParenthesisKeyword_4; }

		//ownedField+=RecordField+
		public Assignment getOwnedFieldAssignment_5() { return cOwnedFieldAssignment_5; }

		//RecordField
		public RuleCall getOwnedFieldRecordFieldParserRuleCall_5_0() { return cOwnedFieldRecordFieldParserRuleCall_5_0; }

		//")"
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }
	}

	public class UnnamedRecordTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedRecordType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRecordKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedFieldAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedFieldRecordFieldParserRuleCall_2_0 = (RuleCall)cOwnedFieldAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//UnnamedRecordType returns aadl2::RecordType:
		//	"record" "(" ownedField+=RecordField+ ")";
		public ParserRule getRule() { return rule; }

		//"record" "(" ownedField+=RecordField+ ")"
		public Group getGroup() { return cGroup; }

		//"record"
		public Keyword getRecordKeyword_0() { return cRecordKeyword_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//ownedField+=RecordField+
		public Assignment getOwnedFieldAssignment_2() { return cOwnedFieldAssignment_2; }

		//RecordField
		public RuleCall getOwnedFieldRecordFieldParserRuleCall_2_0() { return cOwnedFieldRecordFieldParserRuleCall_2_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class RecordFieldElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RecordField");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cPropertyTypeAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final CrossReference cPropertyTypePropertyTypeCrossReference_2_0_0 = (CrossReference)cPropertyTypeAssignment_2_0.eContents().get(0);
		private final RuleCall cPropertyTypePropertyTypeQPREFParserRuleCall_2_0_0_1 = (RuleCall)cPropertyTypePropertyTypeCrossReference_2_0_0.eContents().get(1);
		private final Assignment cOwnedPropertyTypeAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_2_1_0 = (RuleCall)cOwnedPropertyTypeAssignment_2_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//RecordField returns aadl2::BasicProperty:
		//	name=ID ":" (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//	| ownedPropertyType=UnnamedPropertyType) ";";
		public ParserRule getRule() { return rule; }

		//name=ID ":" (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//| ownedPropertyType=UnnamedPropertyType) ";"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//| ownedPropertyType=UnnamedPropertyType
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//propertyType=[aadl2::PropertyType|QPREF]
		public Assignment getPropertyTypeAssignment_2_0() { return cPropertyTypeAssignment_2_0; }

		//[aadl2::PropertyType|QPREF]
		public CrossReference getPropertyTypePropertyTypeCrossReference_2_0_0() { return cPropertyTypePropertyTypeCrossReference_2_0_0; }

		//QPREF
		public RuleCall getPropertyTypePropertyTypeQPREFParserRuleCall_2_0_0_1() { return cPropertyTypePropertyTypeQPREFParserRuleCall_2_0_0_1; }

		//ownedPropertyType=UnnamedPropertyType
		public Assignment getOwnedPropertyTypeAssignment_2_1() { return cOwnedPropertyTypeAssignment_2_1; }

		//UnnamedPropertyType
		public RuleCall getOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_2_1_0() { return cOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_2_1_0; }

		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class PropertyDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cInheritAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cInheritInheritKeyword_2_0 = (Keyword)cInheritAssignment_2.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cPropertyTypeAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final CrossReference cPropertyTypePropertyTypeCrossReference_3_0_0 = (CrossReference)cPropertyTypeAssignment_3_0.eContents().get(0);
		private final RuleCall cPropertyTypePropertyTypeQPREFParserRuleCall_3_0_0_1 = (RuleCall)cPropertyTypePropertyTypeCrossReference_3_0_0.eContents().get(1);
		private final Assignment cOwnedPropertyTypeAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final RuleCall cOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_3_1_0 = (RuleCall)cOwnedPropertyTypeAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cEqualsSignGreaterThanSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cDefaultValueAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cDefaultValuePropertyExpressionParserRuleCall_4_1_0 = (RuleCall)cDefaultValueAssignment_4_1.eContents().get(0);
		private final Keyword cAppliesKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cToKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cLeftParenthesisKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Alternatives cAlternatives_8 = (Alternatives)cGroup.eContents().get(8);
		private final Group cGroup_8_0 = (Group)cAlternatives_8.eContents().get(0);
		private final Assignment cAppliesToAssignment_8_0_0 = (Assignment)cGroup_8_0.eContents().get(0);
		private final RuleCall cAppliesToPropertyOwnerParserRuleCall_8_0_0_0 = (RuleCall)cAppliesToAssignment_8_0_0.eContents().get(0);
		private final Group cGroup_8_0_1 = (Group)cGroup_8_0.eContents().get(1);
		private final Keyword cCommaKeyword_8_0_1_0 = (Keyword)cGroup_8_0_1.eContents().get(0);
		private final Assignment cAppliesToAssignment_8_0_1_1 = (Assignment)cGroup_8_0_1.eContents().get(1);
		private final RuleCall cAppliesToPropertyOwnerParserRuleCall_8_0_1_1_0 = (RuleCall)cAppliesToAssignment_8_0_1_1.eContents().get(0);
		private final Assignment cAppliesToAssignment_8_1 = (Assignment)cAlternatives_8.eContents().get(1);
		private final RuleCall cAppliesToAllReferenceParserRuleCall_8_1_0 = (RuleCall)cAppliesToAssignment_8_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Keyword cSemicolonKeyword_10 = (Keyword)cGroup.eContents().get(10);

		////&&&&& Property Definition
		//PropertyDefinition returns aadl2::Property:
		//	name=ID ":" inherit?="inherit"? (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//	| ownedPropertyType=UnnamedPropertyType) ("=>" defaultValue=PropertyExpression)? "applies" "to" "("
		//	(appliesTo+=PropertyOwner ("," appliesTo+=PropertyOwner)* | appliesTo+=AllReference) ")" ";";
		public ParserRule getRule() { return rule; }

		//name=ID ":" inherit?="inherit"? (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//| ownedPropertyType=UnnamedPropertyType) ("=>" defaultValue=PropertyExpression)? "applies" "to" "("
		//(appliesTo+=PropertyOwner ("," appliesTo+=PropertyOwner)* | appliesTo+=AllReference) ")" ";"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//inherit?="inherit"?
		public Assignment getInheritAssignment_2() { return cInheritAssignment_2; }

		//"inherit"
		public Keyword getInheritInheritKeyword_2_0() { return cInheritInheritKeyword_2_0; }

		//propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//| ownedPropertyType=UnnamedPropertyType
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//propertyType=[aadl2::PropertyType|QPREF]
		public Assignment getPropertyTypeAssignment_3_0() { return cPropertyTypeAssignment_3_0; }

		//[aadl2::PropertyType|QPREF]
		public CrossReference getPropertyTypePropertyTypeCrossReference_3_0_0() { return cPropertyTypePropertyTypeCrossReference_3_0_0; }

		//QPREF
		public RuleCall getPropertyTypePropertyTypeQPREFParserRuleCall_3_0_0_1() { return cPropertyTypePropertyTypeQPREFParserRuleCall_3_0_0_1; }

		//ownedPropertyType=UnnamedPropertyType
		public Assignment getOwnedPropertyTypeAssignment_3_1() { return cOwnedPropertyTypeAssignment_3_1; }

		//UnnamedPropertyType
		public RuleCall getOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_3_1_0() { return cOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_3_1_0; }

		//("=>" defaultValue=PropertyExpression)?
		public Group getGroup_4() { return cGroup_4; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_4_0() { return cEqualsSignGreaterThanSignKeyword_4_0; }

		//defaultValue=PropertyExpression
		public Assignment getDefaultValueAssignment_4_1() { return cDefaultValueAssignment_4_1; }

		//PropertyExpression
		public RuleCall getDefaultValuePropertyExpressionParserRuleCall_4_1_0() { return cDefaultValuePropertyExpressionParserRuleCall_4_1_0; }

		//"applies"
		public Keyword getAppliesKeyword_5() { return cAppliesKeyword_5; }

		//"to"
		public Keyword getToKeyword_6() { return cToKeyword_6; }

		//"("
		public Keyword getLeftParenthesisKeyword_7() { return cLeftParenthesisKeyword_7; }

		//appliesTo+=PropertyOwner ("," appliesTo+=PropertyOwner)* | appliesTo+=AllReference
		public Alternatives getAlternatives_8() { return cAlternatives_8; }

		//appliesTo+=PropertyOwner ("," appliesTo+=PropertyOwner)*
		public Group getGroup_8_0() { return cGroup_8_0; }

		//appliesTo+=PropertyOwner
		public Assignment getAppliesToAssignment_8_0_0() { return cAppliesToAssignment_8_0_0; }

		//PropertyOwner
		public RuleCall getAppliesToPropertyOwnerParserRuleCall_8_0_0_0() { return cAppliesToPropertyOwnerParserRuleCall_8_0_0_0; }

		//("," appliesTo+=PropertyOwner)*
		public Group getGroup_8_0_1() { return cGroup_8_0_1; }

		//","
		public Keyword getCommaKeyword_8_0_1_0() { return cCommaKeyword_8_0_1_0; }

		//appliesTo+=PropertyOwner
		public Assignment getAppliesToAssignment_8_0_1_1() { return cAppliesToAssignment_8_0_1_1; }

		//PropertyOwner
		public RuleCall getAppliesToPropertyOwnerParserRuleCall_8_0_1_1_0() { return cAppliesToPropertyOwnerParserRuleCall_8_0_1_1_0; }

		//appliesTo+=AllReference
		public Assignment getAppliesToAssignment_8_1() { return cAppliesToAssignment_8_1; }

		//AllReference
		public RuleCall getAppliesToAllReferenceParserRuleCall_8_1_0() { return cAppliesToAllReferenceParserRuleCall_8_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_9() { return cRightParenthesisKeyword_9; }

		//";"
		public Keyword getSemicolonKeyword_10() { return cSemicolonKeyword_10; }
	}

	public class AllReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AllReference");
		private final Assignment cMetaclassNameAssignment = (Assignment)rule.eContents().get(1);
		private final Keyword cMetaclassNameAllKeyword_0 = (Keyword)cMetaclassNameAssignment.eContents().get(0);

		//AllReference returns aadl2::MetaclassReference:
		//	metaclassName+= // &&&&& actually set it to NamedElement using ALL rule returning "named element" as string
		//	"all";
		public ParserRule getRule() { return rule; }

		//metaclassName+= // &&&&& actually set it to NamedElement using ALL rule returning "named element" as string
		//"all"
		public Assignment getMetaclassNameAssignment() { return cMetaclassNameAssignment; }

		//// &&&&& actually set it to NamedElement using ALL rule returning "named element" as string
		//"all"
		public Keyword getMetaclassNameAllKeyword_0() { return cMetaclassNameAllKeyword_0; }
	}

	public class ListTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ListType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cListKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cOfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cElementTypeAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final CrossReference cElementTypePropertyTypeCrossReference_2_0_0 = (CrossReference)cElementTypeAssignment_2_0.eContents().get(0);
		private final RuleCall cElementTypePropertyTypeQPREFParserRuleCall_2_0_0_1 = (RuleCall)cElementTypePropertyTypeCrossReference_2_0_0.eContents().get(1);
		private final Assignment cOwnedElementTypeAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cOwnedElementTypeUnnamedPropertyTypeParserRuleCall_2_1_0 = (RuleCall)cOwnedElementTypeAssignment_2_1.eContents().get(0);

		//ListType returns aadl2::ListType:
		//	"list" "of" (elementType=[aadl2::PropertyType|QPREF] | ownedElementType=UnnamedPropertyType);
		public ParserRule getRule() { return rule; }

		//"list" "of" (elementType=[aadl2::PropertyType|QPREF] | ownedElementType=UnnamedPropertyType)
		public Group getGroup() { return cGroup; }

		//"list"
		public Keyword getListKeyword_0() { return cListKeyword_0; }

		//"of"
		public Keyword getOfKeyword_1() { return cOfKeyword_1; }

		//elementType=[aadl2::PropertyType|QPREF] | ownedElementType=UnnamedPropertyType
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//elementType=[aadl2::PropertyType|QPREF]
		public Assignment getElementTypeAssignment_2_0() { return cElementTypeAssignment_2_0; }

		//[aadl2::PropertyType|QPREF]
		public CrossReference getElementTypePropertyTypeCrossReference_2_0_0() { return cElementTypePropertyTypeCrossReference_2_0_0; }

		//QPREF
		public RuleCall getElementTypePropertyTypeQPREFParserRuleCall_2_0_0_1() { return cElementTypePropertyTypeQPREFParserRuleCall_2_0_0_1; }

		//ownedElementType=UnnamedPropertyType
		public Assignment getOwnedElementTypeAssignment_2_1() { return cOwnedElementTypeAssignment_2_1; }

		//UnnamedPropertyType
		public RuleCall getOwnedElementTypeUnnamedPropertyTypeParserRuleCall_2_1_0() { return cOwnedElementTypeUnnamedPropertyTypeParserRuleCall_2_1_0; }
	}

	public class PropertyOwnerElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyOwner");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cQMReferenceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cQCReferenceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//PropertyOwner returns aadl2::PropertyOwner: // classifier value is always qualified by a package name
		//	QMReference | QCReference;
		public ParserRule getRule() { return rule; }

		//// classifier value is always qualified by a package name
		//QMReference | QCReference
		public Alternatives getAlternatives() { return cAlternatives; }

		//// classifier value is always qualified by a package name
		//QMReference
		public RuleCall getQMReferenceParserRuleCall_0() { return cQMReferenceParserRuleCall_0; }

		//QCReference
		public RuleCall getQCReferenceParserRuleCall_1() { return cQCReferenceParserRuleCall_1; }
	}

	public class PropertyConstantElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PropertyConstant");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cConstantKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cPropertyTypeAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final CrossReference cPropertyTypePropertyTypeCrossReference_3_0_0 = (CrossReference)cPropertyTypeAssignment_3_0.eContents().get(0);
		private final RuleCall cPropertyTypePropertyTypeQPREFParserRuleCall_3_0_0_1 = (RuleCall)cPropertyTypePropertyTypeCrossReference_3_0_0.eContents().get(1);
		private final Assignment cOwnedPropertyTypeAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final RuleCall cOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_3_1_0 = (RuleCall)cOwnedPropertyTypeAssignment_3_1.eContents().get(0);
		private final Keyword cEqualsSignGreaterThanSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cConstantValueAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cConstantValueConstantPropertyExpressionParserRuleCall_5_0 = (RuleCall)cConstantValueAssignment_5.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);

		//PropertyConstant returns aadl2::PropertyConstant:
		//	name=ID ":" "constant" (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//	| ownedPropertyType=UnnamedPropertyType) "=>" constantValue=ConstantPropertyExpression ";";
		public ParserRule getRule() { return rule; }

		//name=ID ":" "constant" (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//| ownedPropertyType=UnnamedPropertyType) "=>" constantValue=ConstantPropertyExpression ";"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//"constant"
		public Keyword getConstantKeyword_2() { return cConstantKeyword_2; }

		//propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
		//| ownedPropertyType=UnnamedPropertyType
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//propertyType=[aadl2::PropertyType|QPREF]
		public Assignment getPropertyTypeAssignment_3_0() { return cPropertyTypeAssignment_3_0; }

		//[aadl2::PropertyType|QPREF]
		public CrossReference getPropertyTypePropertyTypeCrossReference_3_0_0() { return cPropertyTypePropertyTypeCrossReference_3_0_0; }

		//QPREF
		public RuleCall getPropertyTypePropertyTypeQPREFParserRuleCall_3_0_0_1() { return cPropertyTypePropertyTypeQPREFParserRuleCall_3_0_0_1; }

		//ownedPropertyType=UnnamedPropertyType
		public Assignment getOwnedPropertyTypeAssignment_3_1() { return cOwnedPropertyTypeAssignment_3_1; }

		//UnnamedPropertyType
		public RuleCall getOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_3_1_0() { return cOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_3_1_0; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_4() { return cEqualsSignGreaterThanSignKeyword_4; }

		//constantValue=ConstantPropertyExpression
		public Assignment getConstantValueAssignment_5() { return cConstantValueAssignment_5; }

		//ConstantPropertyExpression
		public RuleCall getConstantValueConstantPropertyExpressionParserRuleCall_5_0() { return cConstantValueConstantPropertyExpressionParserRuleCall_5_0; }

		//";"
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}

	public class NumberValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NumberValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cRealLitParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIntegerLitParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//NumberValue returns aadl2::NumberValue:
		//	RealLit | IntegerLit;
		public ParserRule getRule() { return rule; }

		//RealLit | IntegerLit
		public Alternatives getAlternatives() { return cAlternatives; }

		//RealLit
		public RuleCall getRealLitParserRuleCall_0() { return cRealLitParserRuleCall_0; }

		//IntegerLit
		public RuleCall getIntegerLitParserRuleCall_1() { return cIntegerLitParserRuleCall_1; }
	}

	public class RealLitElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RealLit");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSignedRealParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);

		//RealLit returns aadl2::RealLiteral:
		//	value=SignedReal;
		public ParserRule getRule() { return rule; }

		//value=SignedReal
		public Assignment getValueAssignment() { return cValueAssignment; }

		//SignedReal
		public RuleCall getValueSignedRealParserRuleCall_0() { return cValueSignedRealParserRuleCall_0; }
	}

	public class IntegerLitElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntegerLit");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSignedIntParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);

		//IntegerLit returns aadl2::IntegerLiteral:
		//	value=SignedInt;
		public ParserRule getRule() { return rule; }

		//value=SignedInt
		public Assignment getValueAssignment() { return cValueAssignment; }

		//SignedInt
		public RuleCall getValueSignedIntParserRuleCall_0() { return cValueSignedIntParserRuleCall_0; }
	}

	public class ConstantPropertyExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConstantPropertyExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cRecordTermParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNumericRangeTermParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cComputedTermParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cStringTermParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cRealTermParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cIntegerTermParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cComponentClassifierTermParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cListTermParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cLiteralorReferenceTermParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cBooleanLiteralParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);

		//ConstantPropertyExpression returns aadl2::PropertyExpression:
		//	RecordTerm | NumericRangeTerm | ComputedTerm | StringTerm | RealTerm | IntegerTerm | ComponentClassifierTerm |
		//	ListTerm | LiteralorReferenceTerm | BooleanLiteral;
		public ParserRule getRule() { return rule; }

		//RecordTerm | NumericRangeTerm | ComputedTerm | StringTerm | RealTerm | IntegerTerm | ComponentClassifierTerm | ListTerm
		//| LiteralorReferenceTerm | BooleanLiteral
		public Alternatives getAlternatives() { return cAlternatives; }

		//RecordTerm
		public RuleCall getRecordTermParserRuleCall_0() { return cRecordTermParserRuleCall_0; }

		//NumericRangeTerm
		public RuleCall getNumericRangeTermParserRuleCall_1() { return cNumericRangeTermParserRuleCall_1; }

		//ComputedTerm
		public RuleCall getComputedTermParserRuleCall_2() { return cComputedTermParserRuleCall_2; }

		//StringTerm
		public RuleCall getStringTermParserRuleCall_3() { return cStringTermParserRuleCall_3; }

		//RealTerm
		public RuleCall getRealTermParserRuleCall_4() { return cRealTermParserRuleCall_4; }

		//IntegerTerm
		public RuleCall getIntegerTermParserRuleCall_5() { return cIntegerTermParserRuleCall_5; }

		//ComponentClassifierTerm
		public RuleCall getComponentClassifierTermParserRuleCall_6() { return cComponentClassifierTermParserRuleCall_6; }

		//ListTerm
		public RuleCall getListTermParserRuleCall_7() { return cListTermParserRuleCall_7; }

		//LiteralorReferenceTerm
		public RuleCall getLiteralorReferenceTermParserRuleCall_8() { return cLiteralorReferenceTermParserRuleCall_8; }

		//BooleanLiteral
		public RuleCall getBooleanLiteralParserRuleCall_9() { return cBooleanLiteralParserRuleCall_9; }
	}

	public class IntegerRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntegerRange");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLowerBoundAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cLowerBoundAlternatives_0_0 = (Alternatives)cLowerBoundAssignment_0.eContents().get(0);
		private final RuleCall cLowerBoundIntegerTermParserRuleCall_0_0_0 = (RuleCall)cLowerBoundAlternatives_0_0.eContents().get(0);
		private final RuleCall cLowerBoundSignedConstantParserRuleCall_0_0_1 = (RuleCall)cLowerBoundAlternatives_0_0.eContents().get(1);
		private final RuleCall cLowerBoundConstantValueParserRuleCall_0_0_2 = (RuleCall)cLowerBoundAlternatives_0_0.eContents().get(2);
		private final Keyword cFullStopFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cUpperBoundAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cUpperBoundAlternatives_2_0 = (Alternatives)cUpperBoundAssignment_2.eContents().get(0);
		private final RuleCall cUpperBoundIntegerTermParserRuleCall_2_0_0 = (RuleCall)cUpperBoundAlternatives_2_0.eContents().get(0);
		private final RuleCall cUpperBoundSignedConstantParserRuleCall_2_0_1 = (RuleCall)cUpperBoundAlternatives_2_0.eContents().get(1);
		private final RuleCall cUpperBoundConstantValueParserRuleCall_2_0_2 = (RuleCall)cUpperBoundAlternatives_2_0.eContents().get(2);

		//IntegerRange returns aadl2::NumericRange:
		//	lowerBound=(IntegerTerm | SignedConstant | ConstantValue) ".." upperBound=(IntegerTerm | SignedConstant |
		//	ConstantValue);
		public ParserRule getRule() { return rule; }

		//lowerBound=(IntegerTerm | SignedConstant | ConstantValue) ".." upperBound=(IntegerTerm | SignedConstant | ConstantValue)
		public Group getGroup() { return cGroup; }

		//lowerBound=(IntegerTerm | SignedConstant | ConstantValue)
		public Assignment getLowerBoundAssignment_0() { return cLowerBoundAssignment_0; }

		//IntegerTerm | SignedConstant | ConstantValue
		public Alternatives getLowerBoundAlternatives_0_0() { return cLowerBoundAlternatives_0_0; }

		//IntegerTerm
		public RuleCall getLowerBoundIntegerTermParserRuleCall_0_0_0() { return cLowerBoundIntegerTermParserRuleCall_0_0_0; }

		//SignedConstant
		public RuleCall getLowerBoundSignedConstantParserRuleCall_0_0_1() { return cLowerBoundSignedConstantParserRuleCall_0_0_1; }

		//ConstantValue
		public RuleCall getLowerBoundConstantValueParserRuleCall_0_0_2() { return cLowerBoundConstantValueParserRuleCall_0_0_2; }

		//".."
		public Keyword getFullStopFullStopKeyword_1() { return cFullStopFullStopKeyword_1; }

		//upperBound=(IntegerTerm | SignedConstant | ConstantValue)
		public Assignment getUpperBoundAssignment_2() { return cUpperBoundAssignment_2; }

		//IntegerTerm | SignedConstant | ConstantValue
		public Alternatives getUpperBoundAlternatives_2_0() { return cUpperBoundAlternatives_2_0; }

		//IntegerTerm
		public RuleCall getUpperBoundIntegerTermParserRuleCall_2_0_0() { return cUpperBoundIntegerTermParserRuleCall_2_0_0; }

		//SignedConstant
		public RuleCall getUpperBoundSignedConstantParserRuleCall_2_0_1() { return cUpperBoundSignedConstantParserRuleCall_2_0_1; }

		//ConstantValue
		public RuleCall getUpperBoundConstantValueParserRuleCall_2_0_2() { return cUpperBoundConstantValueParserRuleCall_2_0_2; }
	}

	public class RealRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RealRange");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLowerBoundAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cLowerBoundAlternatives_0_0 = (Alternatives)cLowerBoundAssignment_0.eContents().get(0);
		private final RuleCall cLowerBoundRealTermParserRuleCall_0_0_0 = (RuleCall)cLowerBoundAlternatives_0_0.eContents().get(0);
		private final RuleCall cLowerBoundSignedConstantParserRuleCall_0_0_1 = (RuleCall)cLowerBoundAlternatives_0_0.eContents().get(1);
		private final RuleCall cLowerBoundConstantValueParserRuleCall_0_0_2 = (RuleCall)cLowerBoundAlternatives_0_0.eContents().get(2);
		private final Keyword cFullStopFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cUpperBoundAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cUpperBoundAlternatives_2_0 = (Alternatives)cUpperBoundAssignment_2.eContents().get(0);
		private final RuleCall cUpperBoundRealTermParserRuleCall_2_0_0 = (RuleCall)cUpperBoundAlternatives_2_0.eContents().get(0);
		private final RuleCall cUpperBoundSignedConstantParserRuleCall_2_0_1 = (RuleCall)cUpperBoundAlternatives_2_0.eContents().get(1);
		private final RuleCall cUpperBoundConstantValueParserRuleCall_2_0_2 = (RuleCall)cUpperBoundAlternatives_2_0.eContents().get(2);

		//RealRange returns aadl2::NumericRange:
		//	lowerBound=(RealTerm | SignedConstant | ConstantValue) ".." upperBound=(RealTerm | SignedConstant | ConstantValue);
		public ParserRule getRule() { return rule; }

		//lowerBound=(RealTerm | SignedConstant | ConstantValue) ".." upperBound=(RealTerm | SignedConstant | ConstantValue)
		public Group getGroup() { return cGroup; }

		//lowerBound=(RealTerm | SignedConstant | ConstantValue)
		public Assignment getLowerBoundAssignment_0() { return cLowerBoundAssignment_0; }

		//RealTerm | SignedConstant | ConstantValue
		public Alternatives getLowerBoundAlternatives_0_0() { return cLowerBoundAlternatives_0_0; }

		//RealTerm
		public RuleCall getLowerBoundRealTermParserRuleCall_0_0_0() { return cLowerBoundRealTermParserRuleCall_0_0_0; }

		//SignedConstant
		public RuleCall getLowerBoundSignedConstantParserRuleCall_0_0_1() { return cLowerBoundSignedConstantParserRuleCall_0_0_1; }

		//ConstantValue
		public RuleCall getLowerBoundConstantValueParserRuleCall_0_0_2() { return cLowerBoundConstantValueParserRuleCall_0_0_2; }

		//".."
		public Keyword getFullStopFullStopKeyword_1() { return cFullStopFullStopKeyword_1; }

		//upperBound=(RealTerm | SignedConstant | ConstantValue)
		public Assignment getUpperBoundAssignment_2() { return cUpperBoundAssignment_2; }

		//RealTerm | SignedConstant | ConstantValue
		public Alternatives getUpperBoundAlternatives_2_0() { return cUpperBoundAlternatives_2_0; }

		//RealTerm
		public RuleCall getUpperBoundRealTermParserRuleCall_2_0_0() { return cUpperBoundRealTermParserRuleCall_2_0_0; }

		//SignedConstant
		public RuleCall getUpperBoundSignedConstantParserRuleCall_2_0_1() { return cUpperBoundSignedConstantParserRuleCall_2_0_1; }

		//ConstantValue
		public RuleCall getUpperBoundConstantValueParserRuleCall_2_0_2() { return cUpperBoundConstantValueParserRuleCall_2_0_2; }
	}

	public class CoreKeyWordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CoreKeyWord");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cSystemKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cThreadKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cGroupKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cProcessKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cDataKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cProcessorKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cMemoryKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cDeviceKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cBusKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cVirtualKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cSubprogramKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cFeatureKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cPackageKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cParameterKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cPortKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cCallsKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cEventKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cFlowKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cImplementationKeyword_18 = (Keyword)cAlternatives.eContents().get(18);
		private final Keyword cTypeKeyword_19 = (Keyword)cAlternatives.eContents().get(19);
		private final Keyword cModeKeyword_20 = (Keyword)cAlternatives.eContents().get(20);
		private final Keyword cPrototypeKeyword_21 = (Keyword)cAlternatives.eContents().get(21);
		private final Keyword cToKeyword_22 = (Keyword)cAlternatives.eContents().get(22);
		private final Keyword cEndKeyword_23 = (Keyword)cAlternatives.eContents().get(23);
		private final Keyword cAbstractKeyword_24 = (Keyword)cAlternatives.eContents().get(24);
		private final Keyword cAccessKeyword_25 = (Keyword)cAlternatives.eContents().get(25);
		private final Keyword cClassifierKeyword_26 = (Keyword)cAlternatives.eContents().get(26);

		//// the next ones are filtered as they could be used in an annex
		////	 |'reference' | 'connections' |'constant'|'delta'
		////	| 'and' | 'all' | 'annex' | 'applies' |'binding'|'boolean'|'enumeration'|'path'|'private'
		////	|'extends'|'false'|'features'|'flows'|'in'|'inherit'|'initial'|'integer'|'inverse'|'is'|'list'|'modes'|'none'
		////	|'not'
		//// more to come if we have annex parsers
		//CoreKeyWord:
		//	"system" | "thread" | "group" | "process" | "data" | "processor" | "memory" | "device" | "bus" | "virtual" |
		//	"subprogram" | "feature" | "package" | "parameter" | "port" | "calls" | "event" | "flow" | "implementation" | "type" |
		//	"mode" | "prototype" | "to" | "end" | "abstract" | "access" | "classifier";
		public ParserRule getRule() { return rule; }

		//"system" | "thread" | "group" | "process" | "data" | "processor" | "memory" | "device" | "bus" | "virtual" |
		//"subprogram" | "feature" | "package" | "parameter" | "port" | "calls" | "event" | "flow" | "implementation" | "type" |
		//"mode" | "prototype" | "to" | "end" | "abstract" | "access" | "classifier"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"system"
		public Keyword getSystemKeyword_0() { return cSystemKeyword_0; }

		//"thread"
		public Keyword getThreadKeyword_1() { return cThreadKeyword_1; }

		//"group"
		public Keyword getGroupKeyword_2() { return cGroupKeyword_2; }

		//"process"
		public Keyword getProcessKeyword_3() { return cProcessKeyword_3; }

		//"data"
		public Keyword getDataKeyword_4() { return cDataKeyword_4; }

		//"processor"
		public Keyword getProcessorKeyword_5() { return cProcessorKeyword_5; }

		//"memory"
		public Keyword getMemoryKeyword_6() { return cMemoryKeyword_6; }

		//"device"
		public Keyword getDeviceKeyword_7() { return cDeviceKeyword_7; }

		//"bus"
		public Keyword getBusKeyword_8() { return cBusKeyword_8; }

		//"virtual"
		public Keyword getVirtualKeyword_9() { return cVirtualKeyword_9; }

		//"subprogram"
		public Keyword getSubprogramKeyword_10() { return cSubprogramKeyword_10; }

		//"feature"
		public Keyword getFeatureKeyword_11() { return cFeatureKeyword_11; }

		//"package"
		public Keyword getPackageKeyword_12() { return cPackageKeyword_12; }

		//"parameter"
		public Keyword getParameterKeyword_13() { return cParameterKeyword_13; }

		//"port"
		public Keyword getPortKeyword_14() { return cPortKeyword_14; }

		//"calls"
		public Keyword getCallsKeyword_15() { return cCallsKeyword_15; }

		//"event"
		public Keyword getEventKeyword_16() { return cEventKeyword_16; }

		//"flow"
		public Keyword getFlowKeyword_17() { return cFlowKeyword_17; }

		//"implementation"
		public Keyword getImplementationKeyword_18() { return cImplementationKeyword_18; }

		//"type"
		public Keyword getTypeKeyword_19() { return cTypeKeyword_19; }

		//"mode"
		public Keyword getModeKeyword_20() { return cModeKeyword_20; }

		//"prototype"
		public Keyword getPrototypeKeyword_21() { return cPrototypeKeyword_21; }

		//"to"
		public Keyword getToKeyword_22() { return cToKeyword_22; }

		//"end"
		public Keyword getEndKeyword_23() { return cEndKeyword_23; }

		//"abstract"
		public Keyword getAbstractKeyword_24() { return cAbstractKeyword_24; }

		//"access"
		public Keyword getAccessKeyword_25() { return cAccessKeyword_25; }

		//"classifier"
		public Keyword getClassifierKeyword_26() { return cClassifierKeyword_26; }
	}

	public class FQCREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FQCREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);

		//// fully qualified classifier name (always includes package name
		//FQCREF:
		//	(ID "::")+ ID ("." ID)?;
		public ParserRule getRule() { return rule; }

		//(ID "::")+ ID ("." ID)?
		public Group getGroup() { return cGroup; }

		//(ID "::")+
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//"::"
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//("." ID)?
		public Group getGroup_2() { return cGroup_2; }

		//"."
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }
	}


	private PropertySetElements pPropertySet;
	private PropertyTypeElements pPropertyType;
	private UnnamedPropertyTypeElements pUnnamedPropertyType;
	private BooleanTypeElements pBooleanType;
	private UnnamedBooleanTypeElements pUnnamedBooleanType;
	private StringTypeElements pStringType;
	private UnnamedStringTypeElements pUnnamedStringType;
	private EnumerationTypeElements pEnumerationType;
	private UnnamedEnumerationTypeElements pUnnamedEnumerationType;
	private EnumerationLiteralElements pEnumerationLiteral;
	private UnitsTypeElements pUnitsType;
	private UnnamedUnitsTypeElements pUnnamedUnitsType;
	private UnitLiteralElements pUnitLiteral;
	private UnitLiteralConversionElements pUnitLiteralConversion;
	private RealTypeElements pRealType;
	private UnnamedRealTypeElements pUnnamedRealType;
	private IntegerTypeElements pIntegerType;
	private UnnamedIntegerTypeElements pUnnamedIntegerType;
	private RangeTypeElements pRangeType;
	private UnnamedRangeTypeElements pUnnamedRangeType;
	private ClassifierTypeElements pClassifierType;
	private UnnamedClassifierTypeElements pUnnamedClassifierType;
	private QMReferenceElements pQMReference;
	private QCReferenceElements pQCReference;
	private ReferenceTypeElements pReferenceType;
	private UnnamedReferenceTypeElements pUnnamedReferenceType;
	private RecordTypeElements pRecordType;
	private UnnamedRecordTypeElements pUnnamedRecordType;
	private RecordFieldElements pRecordField;
	private PropertyDefinitionElements pPropertyDefinition;
	private AllReferenceElements pAllReference;
	private ListTypeElements pListType;
	private PropertyOwnerElements pPropertyOwner;
	private PropertyConstantElements pPropertyConstant;
	private NumberValueElements pNumberValue;
	private RealLitElements pRealLit;
	private IntegerLitElements pIntegerLit;
	private ConstantPropertyExpressionElements pConstantPropertyExpression;
	private IntegerRangeElements pIntegerRange;
	private RealRangeElements pRealRange;
	private CoreKeyWordElements pCoreKeyWord;
	private FQCREFElements pFQCREF;

	private final GrammarProvider grammarProvider;

	private PropertiesGrammarAccess gaProperties;

	@Inject
	public PropertysetGrammarAccess(GrammarProvider grammarProvider,
		PropertiesGrammarAccess gaProperties) {
		this.grammarProvider = grammarProvider;
		this.gaProperties = gaProperties;
	}

	public Grammar getGrammar() {
		return grammarProvider.getGrammar(this);
	}


	public PropertiesGrammarAccess getPropertiesGrammarAccess() {
		return gaProperties;
	}


	//// Properties
	//PropertySet returns aadl2::PropertySet:
	//	"property" "set" name=ID "is" ("with" importedUnit+=[aadl2::PropertySet] ("," importedUnit+=[aadl2::PropertySet])*
	//	";")* (ownedPropertyType+=PropertyType | ownedProperty+=PropertyDefinition | ownedPropertyConstant+=PropertyConstant)*
	//	"end" ID ";";
	public PropertySetElements getPropertySetAccess() {
		return (pPropertySet != null) ? pPropertySet : (pPropertySet = new PropertySetElements());
	}

	public ParserRule getPropertySetRule() {
		return getPropertySetAccess().getRule();
	}

	//PropertyType returns aadl2::PropertyType:
	//	(BooleanType | StringType | EnumerationType | UnitsType | RealType | IntegerType | RangeType | ClassifierType |
	//	ReferenceType | RecordType) ";";
	public PropertyTypeElements getPropertyTypeAccess() {
		return (pPropertyType != null) ? pPropertyType : (pPropertyType = new PropertyTypeElements());
	}

	public ParserRule getPropertyTypeRule() {
		return getPropertyTypeAccess().getRule();
	}

	//UnnamedPropertyType returns aadl2::PropertyType:
	//	ListType | UnnamedBooleanType | UnnamedStringType | UnnamedEnumerationType | UnnamedUnitsType | UnnamedRealType |
	//	UnnamedIntegerType | UnnamedRangeType | UnnamedClassifierType | UnnamedReferenceType | UnnamedRecordType;
	public UnnamedPropertyTypeElements getUnnamedPropertyTypeAccess() {
		return (pUnnamedPropertyType != null) ? pUnnamedPropertyType : (pUnnamedPropertyType = new UnnamedPropertyTypeElements());
	}

	public ParserRule getUnnamedPropertyTypeRule() {
		return getUnnamedPropertyTypeAccess().getRule();
	}

	//BooleanType returns aadl2::AadlBoolean:
	//	name=ID ":" "type" "aadlboolean";
	public BooleanTypeElements getBooleanTypeAccess() {
		return (pBooleanType != null) ? pBooleanType : (pBooleanType = new BooleanTypeElements());
	}

	public ParserRule getBooleanTypeRule() {
		return getBooleanTypeAccess().getRule();
	}

	//UnnamedBooleanType returns aadl2::AadlBoolean:
	//	{aadl2::AadlBoolean} "aadlboolean";
	public UnnamedBooleanTypeElements getUnnamedBooleanTypeAccess() {
		return (pUnnamedBooleanType != null) ? pUnnamedBooleanType : (pUnnamedBooleanType = new UnnamedBooleanTypeElements());
	}

	public ParserRule getUnnamedBooleanTypeRule() {
		return getUnnamedBooleanTypeAccess().getRule();
	}

	//StringType returns aadl2::AadlString:
	//	name=ID ":" "type" "aadlstring";
	public StringTypeElements getStringTypeAccess() {
		return (pStringType != null) ? pStringType : (pStringType = new StringTypeElements());
	}

	public ParserRule getStringTypeRule() {
		return getStringTypeAccess().getRule();
	}

	//UnnamedStringType returns aadl2::AadlString:
	//	{aadl2::AadlString} "aadlstring";
	public UnnamedStringTypeElements getUnnamedStringTypeAccess() {
		return (pUnnamedStringType != null) ? pUnnamedStringType : (pUnnamedStringType = new UnnamedStringTypeElements());
	}

	public ParserRule getUnnamedStringTypeRule() {
		return getUnnamedStringTypeAccess().getRule();
	}

	//EnumerationType returns aadl2::EnumerationType:
	//	name=ID ":" "type" "enumeration" "(" ownedLiteral+=EnumerationLiteral ("," ownedLiteral+=EnumerationLiteral)* ")";
	public EnumerationTypeElements getEnumerationTypeAccess() {
		return (pEnumerationType != null) ? pEnumerationType : (pEnumerationType = new EnumerationTypeElements());
	}

	public ParserRule getEnumerationTypeRule() {
		return getEnumerationTypeAccess().getRule();
	}

	//UnnamedEnumerationType returns aadl2::EnumerationType:
	//	"enumeration" "(" ownedLiteral+=EnumerationLiteral ("," ownedLiteral+=EnumerationLiteral)* ")";
	public UnnamedEnumerationTypeElements getUnnamedEnumerationTypeAccess() {
		return (pUnnamedEnumerationType != null) ? pUnnamedEnumerationType : (pUnnamedEnumerationType = new UnnamedEnumerationTypeElements());
	}

	public ParserRule getUnnamedEnumerationTypeRule() {
		return getUnnamedEnumerationTypeAccess().getRule();
	}

	//EnumerationLiteral returns aadl2::EnumerationLiteral:
	//	name=ID;
	public EnumerationLiteralElements getEnumerationLiteralAccess() {
		return (pEnumerationLiteral != null) ? pEnumerationLiteral : (pEnumerationLiteral = new EnumerationLiteralElements());
	}

	public ParserRule getEnumerationLiteralRule() {
		return getEnumerationLiteralAccess().getRule();
	}

	//UnitsType returns aadl2::UnitsType:
	//	name=ID ":" "type" "units" "(" ownedLiteral+=UnitLiteral ("," ownedLiteral+=UnitLiteralConversion)* ")";
	public UnitsTypeElements getUnitsTypeAccess() {
		return (pUnitsType != null) ? pUnitsType : (pUnitsType = new UnitsTypeElements());
	}

	public ParserRule getUnitsTypeRule() {
		return getUnitsTypeAccess().getRule();
	}

	//UnnamedUnitsType returns aadl2::UnitsType:
	//	"units" "(" ownedLiteral+=UnitLiteral ("," ownedLiteral+=UnitLiteralConversion)* ")";
	public UnnamedUnitsTypeElements getUnnamedUnitsTypeAccess() {
		return (pUnnamedUnitsType != null) ? pUnnamedUnitsType : (pUnnamedUnitsType = new UnnamedUnitsTypeElements());
	}

	public ParserRule getUnnamedUnitsTypeRule() {
		return getUnnamedUnitsTypeAccess().getRule();
	}

	//UnitLiteral returns aadl2::UnitLiteral:
	//	name=ID;
	public UnitLiteralElements getUnitLiteralAccess() {
		return (pUnitLiteral != null) ? pUnitLiteral : (pUnitLiteral = new UnitLiteralElements());
	}

	public ParserRule getUnitLiteralRule() {
		return getUnitLiteralAccess().getRule();
	}

	//UnitLiteralConversion returns aadl2::UnitLiteral:
	//	name=ID "=>" baseUnit=[aadl2::UnitLiteral] STAR factor=NumberValue;
	public UnitLiteralConversionElements getUnitLiteralConversionAccess() {
		return (pUnitLiteralConversion != null) ? pUnitLiteralConversion : (pUnitLiteralConversion = new UnitLiteralConversionElements());
	}

	public ParserRule getUnitLiteralConversionRule() {
		return getUnitLiteralConversionAccess().getRule();
	}

	//RealType returns aadl2::AadlReal:
	//	name=ID ":" "type" "aadlreal" range=RealRange? (ownedUnitsType=UnnamedUnitsType | "units"
	//	unitsType=[aadl2::UnitsType|QPREF])?;
	public RealTypeElements getRealTypeAccess() {
		return (pRealType != null) ? pRealType : (pRealType = new RealTypeElements());
	}

	public ParserRule getRealTypeRule() {
		return getRealTypeAccess().getRule();
	}

	//UnnamedRealType returns aadl2::AadlReal:
	//	{aadl2::AadlReal} "aadlreal" range=RealRange? (ownedUnitsType=UnnamedUnitsType | "units"
	//	unitsType=[aadl2::UnitsType|QPREF])?;
	public UnnamedRealTypeElements getUnnamedRealTypeAccess() {
		return (pUnnamedRealType != null) ? pUnnamedRealType : (pUnnamedRealType = new UnnamedRealTypeElements());
	}

	public ParserRule getUnnamedRealTypeRule() {
		return getUnnamedRealTypeAccess().getRule();
	}

	//IntegerType returns aadl2::AadlInteger:
	//	name=ID ":" "type" "aadlinteger" range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | "units"
	//	unitsType=[aadl2::UnitsType|QPREF])?;
	public IntegerTypeElements getIntegerTypeAccess() {
		return (pIntegerType != null) ? pIntegerType : (pIntegerType = new IntegerTypeElements());
	}

	public ParserRule getIntegerTypeRule() {
		return getIntegerTypeAccess().getRule();
	}

	//UnnamedIntegerType returns aadl2::AadlInteger:
	//	{aadl2::AadlInteger} "aadlinteger" range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | "units"
	//	unitsType=[aadl2::UnitsType|QPREF])?;
	public UnnamedIntegerTypeElements getUnnamedIntegerTypeAccess() {
		return (pUnnamedIntegerType != null) ? pUnnamedIntegerType : (pUnnamedIntegerType = new UnnamedIntegerTypeElements());
	}

	public ParserRule getUnnamedIntegerTypeRule() {
		return getUnnamedIntegerTypeAccess().getRule();
	}

	//RangeType returns aadl2::RangeType:
	//	name=ID ":" "type" "range" "of" (ownedNumberType=(UnnamedIntegerType | UnnamedRealType) |
	//	numberType=[aadl2::NumberType|QPREF]);
	public RangeTypeElements getRangeTypeAccess() {
		return (pRangeType != null) ? pRangeType : (pRangeType = new RangeTypeElements());
	}

	public ParserRule getRangeTypeRule() {
		return getRangeTypeAccess().getRule();
	}

	//UnnamedRangeType returns aadl2::RangeType:
	//	{aadl2::RangeType} "range" "of" (ownedNumberType=(UnnamedIntegerType | UnnamedRealType) |
	//	numberType=[aadl2::NumberType|QPREF]);
	public UnnamedRangeTypeElements getUnnamedRangeTypeAccess() {
		return (pUnnamedRangeType != null) ? pUnnamedRangeType : (pUnnamedRangeType = new UnnamedRangeTypeElements());
	}

	public ParserRule getUnnamedRangeTypeRule() {
		return getUnnamedRangeTypeAccess().getRule();
	}

	//ClassifierType returns aadl2::ClassifierType:
	//	name=ID ":" "type" "classifier" ("(" classifierReference+=QMReference ("," classifierReference+=QMReference)* ")")?;
	public ClassifierTypeElements getClassifierTypeAccess() {
		return (pClassifierType != null) ? pClassifierType : (pClassifierType = new ClassifierTypeElements());
	}

	public ParserRule getClassifierTypeRule() {
		return getClassifierTypeAccess().getRule();
	}

	//UnnamedClassifierType returns aadl2::ClassifierType:
	//	{aadl2::ClassifierType} "classifier" ("(" classifierReference+=QMReference ("," classifierReference+=QMReference)*
	//	")")?;
	public UnnamedClassifierTypeElements getUnnamedClassifierTypeAccess() {
		return (pUnnamedClassifierType != null) ? pUnnamedClassifierType : (pUnnamedClassifierType = new UnnamedClassifierTypeElements());
	}

	public ParserRule getUnnamedClassifierTypeRule() {
		return getUnnamedClassifierTypeAccess().getRule();
	}

	//QMReference returns aadl2::MetaclassReference:
	//	("{" annexName=ID "}" STAR STAR)? metaclassName+=(CoreKeyWord | ID)+;
	public QMReferenceElements getQMReferenceAccess() {
		return (pQMReference != null) ? pQMReference : (pQMReference = new QMReferenceElements());
	}

	public ParserRule getQMReferenceRule() {
		return getQMReferenceAccess().getRule();
	}

	//QCReference returns aadl2::ClassifierValue:
	//	classifier=[aadl2::ComponentClassifier|FQCREF];
	public QCReferenceElements getQCReferenceAccess() {
		return (pQCReference != null) ? pQCReference : (pQCReference = new QCReferenceElements());
	}

	public ParserRule getQCReferenceRule() {
		return getQCReferenceAccess().getRule();
	}

	//ReferenceType returns aadl2::ReferenceType:
	//	name=ID ":" "type" "reference" ("(" namedElementReference+=QMReference ("," namedElementReference+=QMReference)*
	//	")")?;
	public ReferenceTypeElements getReferenceTypeAccess() {
		return (pReferenceType != null) ? pReferenceType : (pReferenceType = new ReferenceTypeElements());
	}

	public ParserRule getReferenceTypeRule() {
		return getReferenceTypeAccess().getRule();
	}

	//UnnamedReferenceType returns aadl2::ReferenceType:
	//	"reference" {aadl2::ReferenceType} ("(" namedElementReference+=QMReference ("," namedElementReference+=QMReference)*
	//	")")?;
	public UnnamedReferenceTypeElements getUnnamedReferenceTypeAccess() {
		return (pUnnamedReferenceType != null) ? pUnnamedReferenceType : (pUnnamedReferenceType = new UnnamedReferenceTypeElements());
	}

	public ParserRule getUnnamedReferenceTypeRule() {
		return getUnnamedReferenceTypeAccess().getRule();
	}

	//RecordType returns aadl2::RecordType:
	//	name=ID ":" "type" "record" "(" ownedField+=RecordField+ ")";
	public RecordTypeElements getRecordTypeAccess() {
		return (pRecordType != null) ? pRecordType : (pRecordType = new RecordTypeElements());
	}

	public ParserRule getRecordTypeRule() {
		return getRecordTypeAccess().getRule();
	}

	//UnnamedRecordType returns aadl2::RecordType:
	//	"record" "(" ownedField+=RecordField+ ")";
	public UnnamedRecordTypeElements getUnnamedRecordTypeAccess() {
		return (pUnnamedRecordType != null) ? pUnnamedRecordType : (pUnnamedRecordType = new UnnamedRecordTypeElements());
	}

	public ParserRule getUnnamedRecordTypeRule() {
		return getUnnamedRecordTypeAccess().getRule();
	}

	//RecordField returns aadl2::BasicProperty:
	//	name=ID ":" (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
	//	| ownedPropertyType=UnnamedPropertyType) ";";
	public RecordFieldElements getRecordFieldAccess() {
		return (pRecordField != null) ? pRecordField : (pRecordField = new RecordFieldElements());
	}

	public ParserRule getRecordFieldRule() {
		return getRecordFieldAccess().getRule();
	}

	////&&&&& Property Definition
	//PropertyDefinition returns aadl2::Property:
	//	name=ID ":" inherit?="inherit"? (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
	//	| ownedPropertyType=UnnamedPropertyType) ("=>" defaultValue=PropertyExpression)? "applies" "to" "("
	//	(appliesTo+=PropertyOwner ("," appliesTo+=PropertyOwner)* | appliesTo+=AllReference) ")" ";";
	public PropertyDefinitionElements getPropertyDefinitionAccess() {
		return (pPropertyDefinition != null) ? pPropertyDefinition : (pPropertyDefinition = new PropertyDefinitionElements());
	}

	public ParserRule getPropertyDefinitionRule() {
		return getPropertyDefinitionAccess().getRule();
	}

	//AllReference returns aadl2::MetaclassReference:
	//	metaclassName+= // &&&&& actually set it to NamedElement using ALL rule returning "named element" as string
	//	"all";
	public AllReferenceElements getAllReferenceAccess() {
		return (pAllReference != null) ? pAllReference : (pAllReference = new AllReferenceElements());
	}

	public ParserRule getAllReferenceRule() {
		return getAllReferenceAccess().getRule();
	}

	//ListType returns aadl2::ListType:
	//	"list" "of" (elementType=[aadl2::PropertyType|QPREF] | ownedElementType=UnnamedPropertyType);
	public ListTypeElements getListTypeAccess() {
		return (pListType != null) ? pListType : (pListType = new ListTypeElements());
	}

	public ParserRule getListTypeRule() {
		return getListTypeAccess().getRule();
	}

	//PropertyOwner returns aadl2::PropertyOwner: // classifier value is always qualified by a package name
	//	QMReference | QCReference;
	public PropertyOwnerElements getPropertyOwnerAccess() {
		return (pPropertyOwner != null) ? pPropertyOwner : (pPropertyOwner = new PropertyOwnerElements());
	}

	public ParserRule getPropertyOwnerRule() {
		return getPropertyOwnerAccess().getRule();
	}

	//PropertyConstant returns aadl2::PropertyConstant:
	//	name=ID ":" "constant" (propertyType=[aadl2::PropertyType|QPREF] //	('list' 'of')* is handled as part of UnnamedPropertytype
	//	| ownedPropertyType=UnnamedPropertyType) "=>" constantValue=ConstantPropertyExpression ";";
	public PropertyConstantElements getPropertyConstantAccess() {
		return (pPropertyConstant != null) ? pPropertyConstant : (pPropertyConstant = new PropertyConstantElements());
	}

	public ParserRule getPropertyConstantRule() {
		return getPropertyConstantAccess().getRule();
	}

	//NumberValue returns aadl2::NumberValue:
	//	RealLit | IntegerLit;
	public NumberValueElements getNumberValueAccess() {
		return (pNumberValue != null) ? pNumberValue : (pNumberValue = new NumberValueElements());
	}

	public ParserRule getNumberValueRule() {
		return getNumberValueAccess().getRule();
	}

	//RealLit returns aadl2::RealLiteral:
	//	value=SignedReal;
	public RealLitElements getRealLitAccess() {
		return (pRealLit != null) ? pRealLit : (pRealLit = new RealLitElements());
	}

	public ParserRule getRealLitRule() {
		return getRealLitAccess().getRule();
	}

	//IntegerLit returns aadl2::IntegerLiteral:
	//	value=SignedInt;
	public IntegerLitElements getIntegerLitAccess() {
		return (pIntegerLit != null) ? pIntegerLit : (pIntegerLit = new IntegerLitElements());
	}

	public ParserRule getIntegerLitRule() {
		return getIntegerLitAccess().getRule();
	}

	//ConstantPropertyExpression returns aadl2::PropertyExpression:
	//	RecordTerm | NumericRangeTerm | ComputedTerm | StringTerm | RealTerm | IntegerTerm | ComponentClassifierTerm |
	//	ListTerm | LiteralorReferenceTerm | BooleanLiteral;
	public ConstantPropertyExpressionElements getConstantPropertyExpressionAccess() {
		return (pConstantPropertyExpression != null) ? pConstantPropertyExpression : (pConstantPropertyExpression = new ConstantPropertyExpressionElements());
	}

	public ParserRule getConstantPropertyExpressionRule() {
		return getConstantPropertyExpressionAccess().getRule();
	}

	//IntegerRange returns aadl2::NumericRange:
	//	lowerBound=(IntegerTerm | SignedConstant | ConstantValue) ".." upperBound=(IntegerTerm | SignedConstant |
	//	ConstantValue);
	public IntegerRangeElements getIntegerRangeAccess() {
		return (pIntegerRange != null) ? pIntegerRange : (pIntegerRange = new IntegerRangeElements());
	}

	public ParserRule getIntegerRangeRule() {
		return getIntegerRangeAccess().getRule();
	}

	//RealRange returns aadl2::NumericRange:
	//	lowerBound=(RealTerm | SignedConstant | ConstantValue) ".." upperBound=(RealTerm | SignedConstant | ConstantValue);
	public RealRangeElements getRealRangeAccess() {
		return (pRealRange != null) ? pRealRange : (pRealRange = new RealRangeElements());
	}

	public ParserRule getRealRangeRule() {
		return getRealRangeAccess().getRule();
	}

	//// the next ones are filtered as they could be used in an annex
	////	 |'reference' | 'connections' |'constant'|'delta'
	////	| 'and' | 'all' | 'annex' | 'applies' |'binding'|'boolean'|'enumeration'|'path'|'private'
	////	|'extends'|'false'|'features'|'flows'|'in'|'inherit'|'initial'|'integer'|'inverse'|'is'|'list'|'modes'|'none'
	////	|'not'
	//// more to come if we have annex parsers
	//CoreKeyWord:
	//	"system" | "thread" | "group" | "process" | "data" | "processor" | "memory" | "device" | "bus" | "virtual" |
	//	"subprogram" | "feature" | "package" | "parameter" | "port" | "calls" | "event" | "flow" | "implementation" | "type" |
	//	"mode" | "prototype" | "to" | "end" | "abstract" | "access" | "classifier";
	public CoreKeyWordElements getCoreKeyWordAccess() {
		return (pCoreKeyWord != null) ? pCoreKeyWord : (pCoreKeyWord = new CoreKeyWordElements());
	}

	public ParserRule getCoreKeyWordRule() {
		return getCoreKeyWordAccess().getRule();
	}

	//// fully qualified classifier name (always includes package name
	//FQCREF:
	//	(ID "::")+ ID ("." ID)?;
	public FQCREFElements getFQCREFAccess() {
		return (pFQCREF != null) ? pFQCREF : (pFQCREF = new FQCREFElements());
	}

	public ParserRule getFQCREFRule() {
		return getFQCREFAccess().getRule();
	}

	//PModel returns aadl2::Element: //| BasicPropertyAssociation | PropertyAssociation
	//	ContainedPropertyAssociation;
	public PropertiesGrammarAccess.PModelElements getPModelAccess() {
		return gaProperties.getPModelAccess();
	}

	public ParserRule getPModelRule() {
		return getPModelAccess().getRule();
	}

	//// Properties
	//ContainedPropertyAssociation returns aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ("=>" | append?="+=>") constant?="constant"? (ownedValue+=OptionalModalPropertyValue
	//	("," ownedValue+=OptionalModalPropertyValue)*) ("applies" "to" appliesTo+=ContainmentPath (","
	//	appliesTo+=ContainmentPath)*)? ("in" "binding" "(" inBinding+=[aadl2::Classifier|QCREF] ")")? ";";
	public PropertiesGrammarAccess.ContainedPropertyAssociationElements getContainedPropertyAssociationAccess() {
		return gaProperties.getContainedPropertyAssociationAccess();
	}

	public ParserRule getContainedPropertyAssociationRule() {
		return getContainedPropertyAssociationAccess().getRule();
	}

	//PropertyAssociation returns aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ("=>" | append?="+=>") constant?="constant"? (ownedValue+=OptionalModalPropertyValue
	//	("," ownedValue+=OptionalModalPropertyValue)*) ("in" "binding" "(" inBinding+=[aadl2::Classifier|QCREF] ")")? ";";
	public PropertiesGrammarAccess.PropertyAssociationElements getPropertyAssociationAccess() {
		return gaProperties.getPropertyAssociationAccess();
	}

	public ParserRule getPropertyAssociationRule() {
		return getPropertyAssociationAccess().getRule();
	}

	//BasicPropertyAssociation returns aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] "=>" ownedValue+=PropertyValue ";";
	public PropertiesGrammarAccess.BasicPropertyAssociationElements getBasicPropertyAssociationAccess() {
		return gaProperties.getBasicPropertyAssociationAccess();
	}

	public ParserRule getBasicPropertyAssociationRule() {
		return getBasicPropertyAssociationAccess().getRule();
	}

	//ContainmentPath returns aadl2::ContainedNamedElement:
	//	{aadl2::ContainedNamedElement} containmentPathElement+=ContainmentPathElement ("."
	//	containmentPathElement+=ContainmentPathElement)*;
	public PropertiesGrammarAccess.ContainmentPathElements getContainmentPathAccess() {
		return gaProperties.getContainmentPathAccess();
	}

	public ParserRule getContainmentPathRule() {
		return getContainmentPathAccess().getRule();
	}

	//ModalPropertyValue returns aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression "in" "modes" "(" inMode+=[aadl2::Mode] ("," inMode+=[aadl2::Mode])* ")";
	public PropertiesGrammarAccess.ModalPropertyValueElements getModalPropertyValueAccess() {
		return gaProperties.getModalPropertyValueAccess();
	}

	public ParserRule getModalPropertyValueRule() {
		return getModalPropertyValueAccess().getRule();
	}

	//OptionalModalPropertyValue returns aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression // phf made this optional: need to check separately that only the last one is optional
	//	("in" "modes" "(" inMode+=[aadl2::Mode] ("," inMode+=[aadl2::Mode])* ")")?;
	public PropertiesGrammarAccess.OptionalModalPropertyValueElements getOptionalModalPropertyValueAccess() {
		return gaProperties.getOptionalModalPropertyValueAccess();
	}

	public ParserRule getOptionalModalPropertyValueRule() {
		return getOptionalModalPropertyValueAccess().getRule();
	}

	//// &&&&&&&&&& handling of in binding
	//PropertyValue returns aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression;
	public PropertiesGrammarAccess.PropertyValueElements getPropertyValueAccess() {
		return gaProperties.getPropertyValueAccess();
	}

	public ParserRule getPropertyValueRule() {
		return getPropertyValueAccess().getRule();
	}

	//PropertyExpression returns aadl2::PropertyExpression:
	//	OldRecordTerm | RecordTerm | ReferenceTerm | ComponentClassifierTerm | ComputedTerm | StringTerm | NumericRangeTerm |
	//	RealTerm | IntegerTerm | ListTerm | BooleanLiteral | LiteralorReferenceTerm;
	public PropertiesGrammarAccess.PropertyExpressionElements getPropertyExpressionAccess() {
		return gaProperties.getPropertyExpressionAccess();
	}

	public ParserRule getPropertyExpressionRule() {
		return getPropertyExpressionAccess().getRule();
	}

	//LiteralorReferenceTerm returns aadl2::NamedValue:
	//	namedValue=[aadl2::AbstractNamedValue|QPREF];
	public PropertiesGrammarAccess.LiteralorReferenceTermElements getLiteralorReferenceTermAccess() {
		return gaProperties.getLiteralorReferenceTermAccess();
	}

	public ParserRule getLiteralorReferenceTermRule() {
		return getLiteralorReferenceTermAccess().getRule();
	}

	//BooleanLiteral returns aadl2::BooleanLiteral:
	//	{aadl2::BooleanLiteral} (value?="true" | "false");
	public PropertiesGrammarAccess.BooleanLiteralElements getBooleanLiteralAccess() {
		return gaProperties.getBooleanLiteralAccess();
	}

	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}

	//ConstantValue returns aadl2::NamedValue:
	//	namedValue=[aadl2::PropertyConstant|QPREF];
	public PropertiesGrammarAccess.ConstantValueElements getConstantValueAccess() {
		return gaProperties.getConstantValueAccess();
	}

	public ParserRule getConstantValueRule() {
		return getConstantValueAccess().getRule();
	}

	//ReferenceTerm returns aadl2::ReferenceValue:
	//	"reference" "(" containmentPathElement+=ContainmentPathElement ("." containmentPathElement+=ContainmentPathElement)*
	//	")";
	public PropertiesGrammarAccess.ReferenceTermElements getReferenceTermAccess() {
		return gaProperties.getReferenceTermAccess();
	}

	public ParserRule getReferenceTermRule() {
		return getReferenceTermAccess().getRule();
	}

	//RecordTerm returns aadl2::RecordValue:
	//	"[" ownedFieldValue+=FieldPropertyAssociation+ "]";
	public PropertiesGrammarAccess.RecordTermElements getRecordTermAccess() {
		return gaProperties.getRecordTermAccess();
	}

	public ParserRule getRecordTermRule() {
		return getRecordTermAccess().getRule();
	}

	//OldRecordTerm returns aadl2::RecordValue:
	//	"(" ownedFieldValue+=FieldPropertyAssociation+ ")";
	public PropertiesGrammarAccess.OldRecordTermElements getOldRecordTermAccess() {
		return gaProperties.getOldRecordTermAccess();
	}

	public ParserRule getOldRecordTermRule() {
		return getOldRecordTermAccess().getRule();
	}

	//ComputedTerm returns aadl2::ComputedValue:
	//	"compute" "(" function=ID ")";
	public PropertiesGrammarAccess.ComputedTermElements getComputedTermAccess() {
		return gaProperties.getComputedTermAccess();
	}

	public ParserRule getComputedTermRule() {
		return getComputedTermAccess().getRule();
	}

	//ComponentClassifierTerm returns aadl2::ClassifierValue:
	//	"classifier" "(" classifier=[aadl2::ComponentClassifier|QCREF] ")";
	public PropertiesGrammarAccess.ComponentClassifierTermElements getComponentClassifierTermAccess() {
		return gaProperties.getComponentClassifierTermAccess();
	}

	public ParserRule getComponentClassifierTermRule() {
		return getComponentClassifierTermAccess().getRule();
	}

	//ListTerm returns aadl2::ListValue:
	//	"(" ownedListElement+=PropertyExpression ("," ownedListElement+=PropertyExpression)* ")";
	public PropertiesGrammarAccess.ListTermElements getListTermAccess() {
		return gaProperties.getListTermAccess();
	}

	public ParserRule getListTermRule() {
		return getListTermAccess().getRule();
	}

	//FieldPropertyAssociation returns aadl2::BasicPropertyAssociation:
	//	property=[aadl2::BasicProperty] "=>" ownedValue=PropertyExpression ";";
	public PropertiesGrammarAccess.FieldPropertyAssociationElements getFieldPropertyAssociationAccess() {
		return gaProperties.getFieldPropertyAssociationAccess();
	}

	public ParserRule getFieldPropertyAssociationRule() {
		return getFieldPropertyAssociationAccess().getRule();
	}

	//// from AADL2
	//// need to add annex path element
	//ContainmentPathElement returns aadl2::ContainmentPathElement:
	//	namedElement=[aadl2::NamedElement] arrayRange+=ArrayRange? | "annex" namedElement=[aadl2::NamedElement|ANNEXREF];
	public PropertiesGrammarAccess.ContainmentPathElementElements getContainmentPathElementAccess() {
		return gaProperties.getContainmentPathElementAccess();
	}

	public ParserRule getContainmentPathElementRule() {
		return getContainmentPathElementAccess().getRule();
	}

	//ANNEXREF: // check what values are ok inside ** **
	//	"{" STAR STAR ID STAR STAR "}";
	public PropertiesGrammarAccess.ANNEXREFElements getANNEXREFAccess() {
		return gaProperties.getANNEXREFAccess();
	}

	public ParserRule getANNEXREFRule() {
		return getANNEXREFAccess().getRule();
	}

	//PlusMinus returns aadl2::OperationKind:
	//	"+" | "-";
	public PropertiesGrammarAccess.PlusMinusElements getPlusMinusAccess() {
		return gaProperties.getPlusMinusAccess();
	}

	public ParserRule getPlusMinusRule() {
		return getPlusMinusAccess().getRule();
	}

	//StringTerm returns aadl2::StringLiteral:
	//	value=NoQuoteString;
	public PropertiesGrammarAccess.StringTermElements getStringTermAccess() {
		return gaProperties.getStringTermAccess();
	}

	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}

	//NoQuoteString: // remove quotes from string in ValueConverter
	//	STRING;
	public PropertiesGrammarAccess.NoQuoteStringElements getNoQuoteStringAccess() {
		return gaProperties.getNoQuoteStringAccess();
	}

	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}

	//ArrayRange returns aadl2::ArrayRange:
	//	{aadl2::ArrayRange} "[" lowerBound=INTVALUE (".." upperBound=INTVALUE)? "]";
	public PropertiesGrammarAccess.ArrayRangeElements getArrayRangeAccess() {
		return gaProperties.getArrayRangeAccess();
	}

	public ParserRule getArrayRangeRule() {
		return getArrayRangeAccess().getRule();
	}

	//SignedConstant returns aadl2::Operation:
	//	op=PlusMinus ownedPropertyExpression+=ConstantValue;
	public PropertiesGrammarAccess.SignedConstantElements getSignedConstantAccess() {
		return gaProperties.getSignedConstantAccess();
	}

	public ParserRule getSignedConstantRule() {
		return getSignedConstantAccess().getRule();
	}

	//IntegerTerm returns aadl2::IntegerLiteral:
	//	value=SignedInt unit=[aadl2::UnitLiteral]?;
	public PropertiesGrammarAccess.IntegerTermElements getIntegerTermAccess() {
		return gaProperties.getIntegerTermAccess();
	}

	public ParserRule getIntegerTermRule() {
		return getIntegerTermAccess().getRule();
	}

	//SignedInt returns aadl2::Integer:
	//	("+" | "-")? INTEGER_LIT;
	public PropertiesGrammarAccess.SignedIntElements getSignedIntAccess() {
		return gaProperties.getSignedIntAccess();
	}

	public ParserRule getSignedIntRule() {
		return getSignedIntAccess().getRule();
	}

	//RealTerm returns aadl2::RealLiteral:
	//	value=SignedReal unit=[aadl2::UnitLiteral]?;
	public PropertiesGrammarAccess.RealTermElements getRealTermAccess() {
		return gaProperties.getRealTermAccess();
	}

	public ParserRule getRealTermRule() {
		return getRealTermAccess().getRule();
	}

	//SignedReal returns aadl2::Real:
	//	("+" | "-")? REAL_LIT;
	public PropertiesGrammarAccess.SignedRealElements getSignedRealAccess() {
		return gaProperties.getSignedRealAccess();
	}

	public ParserRule getSignedRealRule() {
		return getSignedRealAccess().getRule();
	}

	//NumericRangeTerm returns aadl2::RangeValue:
	//	minimum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt ".." maximum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt ("delta" delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt)?;
	public PropertiesGrammarAccess.NumericRangeTermElements getNumericRangeTermAccess() {
		return gaProperties.getNumericRangeTermAccess();
	}

	public ParserRule getNumericRangeTermRule() {
		return getNumericRangeTermAccess().getRule();
	}

	//NumAlt returns aadl2::PropertyExpression:
	//	RealTerm | IntegerTerm | SignedConstant | ConstantValue;
	public PropertiesGrammarAccess.NumAltElements getNumAltAccess() {
		return gaProperties.getNumAltAccess();
	}

	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}

	//terminal SL_COMMENT:
	//	"--" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaProperties.getSL_COMMENTRule();
	}

	//INTVALUE returns aadl2::Integer: //NUMERAL
	//	INTEGER_LIT;
	public PropertiesGrammarAccess.INTVALUEElements getINTVALUEAccess() {
		return gaProperties.getINTVALUEAccess();
	}

	public ParserRule getINTVALUERule() {
		return getINTVALUEAccess().getRule();
	}

	////terminal NUMERAL:
	////	(DIGIT)+('_' (DIGIT)+)*
	////;
	////terminal INT returns ecore::EInt: (DIGIT)+('_' (DIGIT)+)*;
	//terminal fragment EXPONENT:
	//	("e" | "E") ("+" | "-")? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return gaProperties.getEXPONENTRule();
	}

	//terminal fragment INT_EXPONENT:
	//	("e" | "E") "+"? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return gaProperties.getINT_EXPONENTRule();
	}

	//terminal REAL_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("." DIGIT+ ("_" DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return gaProperties.getREAL_LITRule();
	}

	//terminal INTEGER_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("#" BASED_INTEGER "#" INT_EXPONENT? | INT_EXPONENT?);
	public TerminalRule getINTEGER_LITRule() {
		return gaProperties.getINTEGER_LITRule();
	}

	//terminal fragment DIGIT:
	//	"0".."9";
	public TerminalRule getDIGITRule() {
		return gaProperties.getDIGITRule();
	}

	//terminal fragment EXTENDED_DIGIT:
	//	"0".."9" | "a".."f" | "A".."F";
	public TerminalRule getEXTENDED_DIGITRule() {
		return gaProperties.getEXTENDED_DIGITRule();
	}

	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ("_"? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return gaProperties.getBASED_INTEGERRule();
	}

	//QPREF:
	//	ID ("::" ID)?;
	public PropertiesGrammarAccess.QPREFElements getQPREFAccess() {
		return gaProperties.getQPREFAccess();
	}

	public ParserRule getQPREFRule() {
		return getQPREFAccess().getRule();
	}

	//QCREF:
	//	(ID "::")* ID ("." ID)?;
	public PropertiesGrammarAccess.QCREFElements getQCREFAccess() {
		return gaProperties.getQCREFAccess();
	}

	public ParserRule getQCREFRule() {
		return getQCREFAccess().getRule();
	}

	//STAR:
	//	"*";
	public PropertiesGrammarAccess.STARElements getSTARAccess() {
		return gaProperties.getSTARAccess();
	}

	public ParserRule getSTARRule() {
		return getSTARAccess().getRule();
	}

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaProperties.getSTRINGRule();
	}

	////terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	//terminal ID:
	//	("a".."z" | "A".."Z") ("_"? ("a".."z" | "A".."Z" | "0".."9"))*;
	public TerminalRule getIDRule() {
		return gaProperties.getIDRule();
	}

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaProperties.getWSRule();
	}
}
