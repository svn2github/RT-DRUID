/*
 * Created on Feb 21, 2005
 * 
 * $Id: BorderAnchor.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
class BorderAnchor extends AbstractConnectionAnchor {

	final static public int TOP = 0;

	final static public int RIGHT = 1;

	final static public int BOTTOM = 2;

	final static public int LEFT = 3;

	private int offset = -1;

	private int direction;

	private int index = -1;
	private int maxIndex = -1;
	private int orthogonalOffset = 0;
	/**
	 * Index va da 0 a maxIndex-1 (come negli vettori)
	 * */
	public BorderAnchor(IFigure source, int direction, int index, int maxIndex, int orthogonalOffset) {
		super(source);

		if (direction != TOP && direction != RIGHT && direction != BOTTOM
				&& direction != LEFT) {
			throw new IllegalArgumentException("Not valid direction");
		}
		
		if (index <0 || index>maxIndex) {
			throw new IllegalArgumentException("Not valid index and/or maxIndex");
		}

		this.direction = direction;
		this.index = index;
		this.maxIndex = maxIndex;
		this.orthogonalOffset = orthogonalOffset;
		
	}

	
	public BorderAnchor(IFigure source, int direction, int offset) {
		super(source);

		if (direction != TOP && direction != RIGHT && direction != BOTTOM
				&& direction != LEFT) {
			throw new IllegalArgumentException("Not valid direction");
		}

		this.direction = direction;
		this.offset = offset;
	}

	public Point getLocation(Point reference) {
		Rectangle r = getOwner().getBounds().getCopy();
		getOwner().translateToAbsolute(r);
		int off = offset;
		{ // check offset, and compute a new value if needed
			int value = direction == TOP || direction == BOTTOM ? r.width : r.height;
			if (index != -1) {
				off = (value * (index +1) )/ (maxIndex+1);
			} else if (off == -1) {
				off = value / 2;
			}
		}

		switch (direction) {
			case TOP: {
				/***************************************************************
				 * T O P
				 **************************************************************/
				return r.getTopLeft().translate(off, orthogonalOffset);
			}
			case RIGHT: {
				/***************************************************************
				 * R I G H T
				 **************************************************************/
				return r.getTopRight().translate(orthogonalOffset-1, off);
			}
			case BOTTOM: {
				/***************************************************************
				 * B O T T O M
				 **************************************************************/
				return r.getBottomLeft().translate(off, orthogonalOffset-1);
			}
			case LEFT: {
				/***************************************************************
				 * L E F T
				 **************************************************************/
				return r.getTopLeft().translate(orthogonalOffset, off);
			}

			default: {
				/***************************************************************
				 * O T H E R S    D I R E C T I O N S
				 **************************************************************/
				// for all "not valid directions", return the center of parent figure
				Point ref = getOwner().getBounds().getCenter();
				getOwner().translateToAbsolute(ref);
				return ref;
			}
		}

	}

}