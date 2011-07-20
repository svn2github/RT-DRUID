/*
 * Created on Oct 14, 2004
 *
 * $Id: Progress.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

/** TRADURRE !!
 * 
 * @author Nicola Serreli
 */
public interface Progress {
    /** Aggiunge un numero di passi necessari */
    void addSteps(long steps);

    /**
     * Indica alla progress bar che sono stati effettuati altri
     * <code>steps</code> passi. Questo valore e' da intedersi relativo e non
     * assoluto.
     * 
     * @param steps
     *            numero passi effettuati (valore relativo)
     */
    void worked(long steps);

    /**
     * Segnala che TUTTO il lavoro e' stato completato. Nota bene : se un lavoro
     * e' formato da piu' "lavori elementari", questa funzione va chiamata solo
     * alla fine di tutto
     */
    void done();

    /** Controlla se e' stato richiesto di interrompere il lavoro */
    boolean stoped();
}