package com.eu.evidence.rtdruid.internal.vartree;

// project package

// standard java package
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.eu.evidence.rtdruid.vartree.IObserver;

// exceptions
/**	This simple IObserver groups together many notifications and sends only one notification, using a timer to
*	make sequential notifications, and then sequential access to shared tree (VarTree). Doesn't store
*	any path of changes.
*
* @author Nicola Serreli
*/
public class SimpleObserver implements com.eu.evidence.rtdruid.vartree.IObserver {
	/** A private actionListener for internal timer */
	private ActionListener internal;
	/** External actionListener for external notifications */
	private ActionListener external;
	/** Groups together some notifications */
	private boolean send;
	/** Timer used to make a sequential updating */
	private javax.swing.Timer timer;
	
	/** This object */
	private IObserver thisObserver; 

	/**	Makes a new observer.
	*
	*	@param	act	the actionListener to which send notifications
	*
	*	@throws NullPointerException if act is null
	*/
	public SimpleObserver(ActionListener act) {
		send = false;
		
		if (act == null) 
			throw new NullPointerException("SimpleObserver with a null ActionListner");
		
		//store external actionListener ...
		external = act;
		
		// ... and setup the interna actionListener
		internal = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				check( evt );
			}
		};
		
		//		... timer ...
		timer = new javax.swing.Timer(0, internal);
		timer.setRepeats(false);
	}
	
	/**	Checks if the notification is already sent. If not, sends one.
	*/
	private synchronized void check(ActionEvent evt) {
		if ( send ) {
			// store  "sent" information
			send = false;
			
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
		send = true;
		timer.restart();
	}
}
