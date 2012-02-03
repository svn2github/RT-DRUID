package com.eu.evidence.rtdruid.test.vartree;




/**
 * The VarTreePointer Test, where all names are without slashes
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class VarTreePointerEMF_slashed_Test extends VarTreePointerEMFTest {

	public VarTreePointerEMF_slashed_Test() {
		NAME_SYSTEM = "My\\S/y\\/\\st**em";
		NAME_TASK = "m*/*\\yTask";
		NAME_PROC = "m\\yPro/c*";
		NAME_VAR = "m*yV/ar";
		NAME_TIME_CONST_ELEMENT = "a/b*c";
		tceId = new String[] { "a/", "b\\" , "****c****" };
	
		VALUE_NEW_NAME = "N*ome";
		
		completePaths();
	}
}
