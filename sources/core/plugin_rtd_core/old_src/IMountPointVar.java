package com.eu.evidence.rtdruid.vartree;


import org.eclipse.emf.edit.domain.EditingDomain;

/*
 * Created on Aug 30, 2004
 *
 * $Id: IMountPointVar.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
/**
 * @author Nicola Serreli
 */
public interface IMountPointVar {

	ISubVarTreePointer getPointer(EditingDomain vt);
}
