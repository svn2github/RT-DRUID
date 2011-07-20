/*
 * Created on Feb 21, 2005
 *
 * $Id: IGMethodsConsumer.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public interface IGMethodsConsumer extends IGComponent {
	boolean addRequiredMethods(String method);

	boolean addRequiredMethods(String[] methods);

	String[] getRequiredMethods();

	void addOutput(GConnection transtition);

}