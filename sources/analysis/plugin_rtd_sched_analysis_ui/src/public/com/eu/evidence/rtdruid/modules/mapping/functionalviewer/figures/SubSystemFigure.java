/*
 * Created on Feb 21, 2005
 *
 * $Id: SubSystemFigure.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class SubSystemFigure extends Figure {

	public final static int TOP_WITDH = 18;
	public final static int BOTTOM_WITDH = 18;
	
	protected boolean selected;

	protected IFigure contents;

	protected IFigure footer;

	protected IFigure header;
	
	protected int providedInterfaces = 0;
	protected int requiredInterfaces = 0;

	/**
	 */
	public SubSystemFigure() {
		IFigure header = new Label("");
		IFigure footer = new Label("");
		contents = new Figure();
		contents.setLayoutManager(new XYLayout());
		add(contents);
		add(this.header = header);
		add(this.footer = footer);

		setBorder(new MarginBorder(3, 5, 3, 0));
		setOpaque(true);
	}

	public IFigure getContents() {
		return contents;
	}

	public IFigure getFooter() {
		return footer;
	}

	public IFigure getHeader() {
		return header;
	}
	
	public void setProvidedInterfacesNumber(int number) {
		providedInterfaces = number;
	}
	public void setRequiredInterfacesNumber(int number) {
		requiredInterfaces = number;
	}
	
	

	/**
	 * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
	 */
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension dim = new Dimension();
		dim.width = getFooter().getPreferredSize().width;
		dim.width += getInsets().getWidth();
		dim.height = 50;
		return dim;
	}

	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
		rect = Rectangle.SINGLETON;
		getClientArea(rect);
		contents.setBounds(rect);
		Dimension size = footer.getPreferredSize();
		footer.setLocation(rect.getBottomLeft().translate(0, -size.height));
		footer.setSize(size);

		size = header.getPreferredSize();
		header.setSize(size);
		header.setLocation(rect.getLocation());
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		Rectangle r = getBounds();
		g.setBackgroundColor(ColorConstants.button);
		if (selected) {
			g.setBackgroundColor(ColorConstants.menuBackgroundSelected);
			g.setForegroundColor(ColorConstants.menuForegroundSelected);
		}

		g.fillRectangle(r.x, r.y, 3, r.height);
		g.fillRectangle(r.right() - 3, r.y, 3, r.height);
		g.fillRectangle(r.x, r.bottom() - BOTTOM_WITDH, r.width, BOTTOM_WITDH);
		g.fillRectangle(r.x, r.y, r.width, TOP_WITDH);
		
		
		g.setBackgroundColor(ColorConstants.blue);
		if (requiredInterfaces > 0) {
			int value = r.width;
			for (int i=0; i<requiredInterfaces; i++) {
				int off = (value * (i +1) )/ (requiredInterfaces+1);
				
				g.fillRectangle(r.x + off-1, r.bottom() - BOTTOM_WITDH, 2, BOTTOM_WITDH);
			}
		}

		if (providedInterfaces > 0) {
			int value = r.width;
			for (int i=0; i<providedInterfaces; i++) {
				int off = (value * (i +1) )/ (providedInterfaces+1);
				
				g.fillRectangle(r.x+ off-1, r.y, 2, TOP_WITDH);
			}
		}
		
	}

	public void setSelected(boolean selected) {
		
		if (this.selected == selected)
			return;
		this.selected = selected;
		if (!selected) {
			getHeader().setForegroundColor(null);
			getFooter().setForegroundColor(null);
		} else {
			getHeader().setForegroundColor(
					ColorConstants.menuForegroundSelected);
			getFooter().setForegroundColor(
					ColorConstants.menuForegroundSelected);
		}

		repaint();
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#handleMouseDoubleClicked(org.eclipse.draw2d.MouseEvent)
	 */
	public void handleMouseDoubleClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		super.handleMouseDoubleClicked(event);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#handleMousePressed(org.eclipse.draw2d.MouseEvent)
	 */
	public void handleMousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		super.handleMousePressed(event);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#handleMouseReleased(org.eclipse.draw2d.MouseEvent)
	 */
	public void handleMouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		super.handleMouseReleased(event);
	}
	
}