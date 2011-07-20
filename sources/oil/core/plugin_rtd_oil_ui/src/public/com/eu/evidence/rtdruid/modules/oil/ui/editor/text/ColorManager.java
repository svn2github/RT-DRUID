/*
 * Created on Jan 26, 2005
 *
 * $Id: ColorManager.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * This class provides all colors used by OilEditor
 * 
 * @author Nicola Serreli
 */
public class ColorManager {

	/*
	 * COLORS
	 */
	public static final RGB RGB_LONG_COMMENT = new RGB(192, 0, 0);

	public static final RGB RGB_LINE_COMMENT = new RGB(160, 32, 32);

	public static final RGB RGB_OBJECT = new RGB(0, 64, 192);

	public static final RGB RGB_OBJECT_REFERENCE = new RGB(0, 192, 255);

	public static final RGB RGB_TYPE = new RGB(0, 96, 255);

	public static final RGB RGB_STRING = new RGB(128, 128, 128);

	public static final RGB RGB_OPERATOR = new RGB(42, 160, 19);

	public static final RGB RGB_DEFAULT = new RGB(0, 0, 0);

	/** Contains a cache with all used colors */
	final protected Map fColorTable = new HashMap(10);

	/** Dispose the cache and all it's objects */
	public void dispose() {
		Iterator e = fColorTable.values().iterator();
		while (e.hasNext())
			((Color) e.next()).dispose();
	}

	/**
	 * Returns the specified color. If that color was already request, get it
	 * from cache.
	 * 
	 * @param rgb
	 *            the RGB rapresentation of color
	 * 
	 * @return the required color, computed by current display
	 */
	public Color getColor(RGB rgb) {
		Color color = (Color) fColorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			fColorTable.put(rgb, color);
		}
		return color;
	}
}