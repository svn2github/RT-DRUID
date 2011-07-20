package com.eu.evidence.rtdruid.internal.vartree;

// project package

// standard java package
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import com.eu.evidence.rtdruid.vartree.IObserver;

// exceptions
/**	This IObserver stores notifications and sends only one notification, using a timer to
*	make sequential notifications, and then sequential access to shared tree (VarTree).
*
*	This IObserver stores all path of changed nodes and send a notification to given ActionListner
*   only if there wasn't any path when the notification arrived. Use getHistory() to get all
*   path, clear the observer and re-enable it to send the next notification.
* 
* @author Nicola Serreli
*/
public class ComplexObserver implements com.eu.evidence.rtdruid.vartree.IObserver {
	/** A private actionListener for internal timer */
	private ActionListener internal;
	/** External actionListener for external notifications */
	private ActionListener external;
	/** Timer used to make a sequential updating */
	private javax.swing.Timer timer;
	/** List of notifications */
	private LinkedList story;
	/** Store if a notification is sent or not */
	private boolean none;
	
	/** This object */
	private IObserver thisObserver; 
	
	/**	Makes a new observer.
	*
	*	@param	act	the actionListener to which send notifications
	*
	*	@throws NullPointerException if act is null
	*/
	public ComplexObserver(ActionListener act) {
		story = new LinkedList();
		thisObserver = this;
		none = true;
		
		if (act == null) 
			throw new NullPointerException("ComplexObserver with a null ActionListner");
		
		//store external actionListener ...
		external = act;
		
		// ... and setup the interna actionListener
		internal = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				check(evt);
			}
		};
		
		//		... timer ...
		timer = new javax.swing.Timer(0, internal);
		timer.setRepeats(false);
	}
	
	/**	Checks if the notification is already sent. If not, sends one.
	*/
	private synchronized void check(ActionEvent evt) {
		if ( none ) {
			// store  "sent" information
			none = false;
			
			evt.setSource(thisObserver);
			
			// send only one notification
			external.actionPerformed( evt );
		}
	}
	
	/**	Recives notifications from VarTree
	*
	*	@param	path	the node changed
	*/
	public synchronized void handler(String path) {
//rtdruid.desk.Messages.sendDebug("IObserver = " + path);					
		story.addLast( path );
		timer.restart();
	}
	
	/**	Returns all stored notifications and clear internal history. In this way, says to
	*	this observer to send the next notification to given ActionListner.
	*/
	public synchronized String[] getHistory() {
		String[] risp = (String[]) story.toArray( new String[0] );
		story.clear();
		none = true;
		
		return risp;
	}
}
