/**
 * 25/giu/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.validation;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public interface IValidationCodes {

	String MissingCpuSection = "missing_cpu_section";
	
	String MissingWithAuto_valueType = "missing_with_auto_keyword__valueType";
	
	String AddQuotesToReferce_parametervalue = "add quotes to reference (parameter value)";
	String RemoveQuotesToReferce_parametervalue = "remove quotes from a String (parameter value)";

	String FixReference_parametervalue = "fix/remove a reference (parameter value)";

	String StringRestrictions_valueType = "string cannot have value range/list";

	String ReplaceWithAValidValue = "replace current value with a valid one";

	String InvertRangeBoundaries = "Invert range boundaries";
}
