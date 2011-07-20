/*
 * Created on 15-nov-2004
 *
 * $Id: ShowLogo.java,v 1.4 2008/01/24 15:50:08 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.common;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * This little class show a graphic logo. The logo is showed only the first time
 * that this class is loaded.
 * 
 * @author Nicola Serreli
 */
final public class ShowLogo {
    /** Where find the logo */
    private static final String LOGO_PATH = "/splash.png";//"/splash.jpeg";
    /** The logo is showed for this number of millisecond */
    private static final int SHOWED_FOR = 2 * 1000;
    /** Splash screen width */
    private static final int SPLASH_WIDTH = 500;
    /** Splash screen height */
    private static final int SPLASH_HEIGHT = 330;
    
    private static boolean showed = false;
    
    /** Make a new instance. The first time show the logo. */
    public ShowLogo() {
        // do nothing;
    }

    /** show the logo */
    static {
    	initLogo();
    }
    
    final static void initLogo() {
    	if (true && !showed) {
        
    		try {
    			if (!PlatformUI.isWorkbenchRunning()) {
    				return;
    			}
	        final Display display = PlatformUI.getWorkbench().getDisplay();
	        display.asyncExec(new Runnable() {
	           public void run() {
	               
	               final Shell shell = new Shell(display, SWT.NO_TRIM | SWT.MODELESS);
	               
	               /* Paint the image */
	               shell.addPaintListener(new PaintListener() {
	                   public void paintControl(PaintEvent event) {
	                       GC gc = event.gc;
	                       
	                       /* Load the image */
	                       ImageLoader il = new ImageLoader();
	                       ImageData[] images;
	                       try {
	                           images = il.load(getClass().getResource(LOGO_PATH).openStream());
	                       } catch (Exception e) {
	                           // image not found
	                           if (!shell.isDisposed()) {
	                               shell.dispose();
	                           }
	                           return;
	                       }
	                       
	                       if (images.length >0) {
	                           Image img = new Image(event.display, images[0]);
	                           gc.drawImage(
	                                   img,
	                                   0,
	                                   0,
	                                   images[0].width,
	                                   images[0].height,
	                                   images[0].x,
	                                   images[0].y,
	                                   SPLASH_WIDTH, //images[0].width,
	                                   SPLASH_HEIGHT); //images[0].height);
	                           img.dispose();
	                       }
	                   }
	               }); // end shell.AddPaintListener(...)
	               
	               // center the image
	               Rectangle rect = display.getClientArea();
	               shell.setSize(SPLASH_WIDTH, SPLASH_HEIGHT);
	               shell.setLocation(rect.width/2 -SPLASH_WIDTH/2, rect.height/2 -SPLASH_HEIGHT/2);
	               shell.open();
	               shell.setActive();
	               
	               new Thread() {
	                   public void run() {
			               try {
			                   Thread.sleep(SHOWED_FOR);
			               } catch (InterruptedException e) {
			                   // do nothing ... just wake up early
			               }
			               // ask display thread to close and dispose the logo
			               if (!display.isDisposed()) {
				               display.asyncExec(new Runnable() {
				                   public void run() {
						               if (!shell.isDisposed()) {
						                   shell.dispose();
						               }
				                   }
				               });
			               }
	                   }
	               }.start();
	           } // end Runable.run()
	        });
	        showed=true;
    		} catch (Error e) {
    			RtdruidLog.showDebug(e);
    			
    		}
    	}
    }
}
