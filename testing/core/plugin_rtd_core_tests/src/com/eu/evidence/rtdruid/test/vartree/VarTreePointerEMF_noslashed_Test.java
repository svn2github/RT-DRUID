package com.eu.evidence.rtdruid.test.vartree;

/**
 * The VarTreePointer Test, where all names are without slashes
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class VarTreePointerEMF_noslashed_Test extends VarTreePointerEMFTest {

	public VarTreePointerEMF_noslashed_Test() {
		NAME_SYSTEM = "MySystem";
		NAME_TASK = "MyTask";
		NAME_PROC = "myProc";
		NAME_VAR = "myVar";
		NAME_TIME_CONST_ELEMENT = "abc";
		tceId = new String[] { "a", "b" , "c"};
		VALUE_NEW_NAME = "Nome";
		
		completePaths();
	}
}
