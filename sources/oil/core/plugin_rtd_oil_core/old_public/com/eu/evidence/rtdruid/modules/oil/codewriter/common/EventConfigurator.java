/*
 * Created on Aug 4, 2005
 *
 * $Id: EventConfigurator.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;



/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class EventConfigurator {
	
	final static String SGR_EVENT_LIST = "elenco eventi richiesti da un task";
	final static String SGR_TASK_DISABLED = "indica che un task e' gia' sotto esame e deve essere saltato";

//	LinkedList tasks = new LinkedList();
//	
//	LinkedList events = new LinkedList();
//	
	public void compute() {
		
	}
	
	
	
	protected boolean tasks(LinkedList tasks, LinkedList events) {
	
		/*
		 * Scorre la lista dei task e prende in esame un task alla volta.
		 * Se le funzioni da lui chiamate falliscono, passa al task successivo.
		 * 
		 * Prima di chiamare la funzione, estrae il task corrente dalla lista
		 */
		

		for (Iterator iter = tasks.iterator(); iter.hasNext();) {
			
			// task corrente
			ISimpleGenRes  task = (ISimpleGenRes) iter.next();
			
			if (!task.containsProperty(SGR_TASK_DISABLED)
					&& task.containsProperty(SGR_EVENT_LIST)) {

				// Il task va esaminato : quindi lo disabilito per le prossime attivazioni del task
				
				task.setProperty(SGR_TASK_DISABLED, "disabled");
				
				/*
				 * Esaminare se si trova una configurazione valida, fissando, a
				 * questo passaggio, i valori di questo task
				 */
				if (events(task, tasks, events)) {
					
					/* TROVATA !! */
					return true;
				}
				
				/*
				 * L'iterazione non e' andata a buon fine:
				 * 
				 * 1. Ri-abilitare il task corrente
				 * 
				 * 2. passare al prossimo task
				 */
				task.removeAProperty(SGR_TASK_DISABLED);
				
			}
		}
		
		// se e' arrivata qui la funzione, significa che non c'e' nulla da fare
		return false;
	}
	
	
	protected boolean events(ISimpleGenRes current, LinkedList tasks, LinkedList events) {
		
		// prelevo la lista di eventi di questo task
		ArrayList tEvents = (ArrayList) current.getObject(SGR_EVENT_LIST);
		
		
		
		
		
		return false;
	}
	
	// 	----------------------------------------------------------
	
}
