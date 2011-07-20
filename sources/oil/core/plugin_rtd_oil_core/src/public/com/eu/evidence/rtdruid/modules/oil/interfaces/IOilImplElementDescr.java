package com.eu.evidence.rtdruid.modules.oil.interfaces;

import java.util.Properties;

/**
 * This small class contains the description of an Oil Implementation element
 * 
 * @author Nicola Serreli
 *
 */
public interface IOilImplElementDescr {
	String getName();
	int getType();
	Properties getAttributes();
}