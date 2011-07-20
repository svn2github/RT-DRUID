/*
 * Created on Sep 22, 2004
 *
 * $Id: IProgressMonitorWatcher.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.presentation;


import org.eclipse.core.runtime.IProgressMonitor;

import com.eu.evidence.rtdruid.internal.modules.jscan.Progress;
import com.eu.evidence.rtdruid.vartree.IVarTree;


/**
 * Piccola classe che controlla il monitor ed in caso sia stato premuto il tasto
 * "cancel" cerca di ammazzare il thread
 * 
 * @author Nicola Serreli
 */
class IProgressMonitorWatcher implements Runnable, Progress {
	IProgressMonitor mon;

	Thread parentTh;

	IVarTree vt;

	boolean go = true;
	
	double done=0;
	volatile long worked=0;
	volatile long steps=0;
	double unit=0;

	public IProgressMonitorWatcher(Thread parentThread,
			IProgressMonitor monitor, IVarTree varTree) {
		mon = monitor;
		parentTh = parentThread;
		vt = varTree;
	}

	public void run() {
		while (again()) {
			try {
				Thread.sleep(200);

				if (mon.isCanceled()) {

					vt.getThreadMonitor().kill(parentTh);
					return;
				}
				
				// compute new steps
				double delta = worked - done;
				if (delta > unit && done<steps) {
					int n = (new Double(Math.floor(delta/unit))).intValue();
					mon.worked(n);
					done += unit * n;
				}

			} catch (InterruptedException e) {
				// nothing
			}

		}

	}

	public synchronized void end() {
		go = false;
	}

	private synchronized boolean again() {
		return go;
	}
	
	// ------------------------

	public void addSteps(long newSteps) {
		steps += newSteps;
		unit = (0.0 + steps) / 100;
	}

	public void done() {
		worked = steps;
	}

	public boolean stoped() {
		return mon.isCanceled();
	}

	public void worked(long workedSteps) {
		worked+=workedSteps;
	}
}