/*
 * Created on Sep 7, 2005
 *
 * $Id: OilReaderFactory.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilReader;

/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class OilReaderFactory {
	public static IOilReader getAnOilReader() {
		return new OilReader();
	}
}
