/*
 * Created on Aug 4, 2005
 *
 * $Id: IntegerPermutation.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import java.util.BitSet;

/**
 * Questa classe gestisce la permutazione di un vettore di interi
 * 
 * @author Nicola Serreli
 */
public class IntegerPermutation {

	/** Vettore dei valori di partenza */
	protected int[] values;

	/**
	 * Vettore degli indici: per ogni posizione, indica quale elemento deve
	 * essere ritornato in seguito alla permutazione.
	 */
	protected int[] index;

	/**
	 * E' stato scoperto che non esistono altre permutazioni
	 */
	protected boolean stop = false;

	/**
	 * E' stato gia' calcolato il valore della prossima ma non e' stato ancora
	 * restituito dalla funzione next()
	 */
	protected boolean computed = false;

	/**
	 * Crea una nuova class di permutazione
	 */
	public IntegerPermutation(int values[]) {
		this.values = values;
		index = new int[values.length];
		reset();
	}

	/** Resetta la permutazione al valore di partenza */
	public void reset() {
		stop = false;
		for (int i = 0; i < index.length; i++) {
			index[i] = i;
		}
	}

	/** Indica se e' presente un'altra permutazione */
	public boolean hasNext() {
		return computeNextPermutation();
	}

	/** Fornisce il prossimo valore */
	public int[] next() {

		if (!computeNextPermutation()) {
			return null;
		}
		computed = false;

		int[] answer = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			answer[i] = values[index[i]];
		}

		return answer;
	}

	/**
	 * Aggiorna il vettore index con la prossima permutazione. Ritorna true se
	 * esiste una nuova permutazione, false in caso contrario
	 */
	protected boolean computeNextPermutation() {
		// already computed
		if (computed) {
			return true;
		}
		// already know that there are no more permutations
		if (stop) {
			return false;
		}

		// the max value
		int max = index.length - 1;

		// the current level of permutation : always start from level
		// index.length-1
		int currLevel = max;

		BitSet free = new BitSet(index.length);

		// the last index will be changed
		free.set(index[index.length - 1]);

		while (true) {
			// 0 is the higer level, then a level<0 means that all permutation
			// are checked
			if (currLevel < 0) {
				stop = true;
				return false;
			}


			// the current element contains the last valid integer ?
			if (index[currLevel] != max) {
				// no : increment this value and check if it is already used
				//      (if no, the array contains a valid permutation)
				index[currLevel]++;

				// if this index is free, a valid permutation is found
				if (free.get(index[currLevel])) {
					// remember that this index is not more free
					free.clear(index[currLevel]);
					break;
				}
			} else {
				// yes : all permutation of this "level" are already checked,
				//       then go to the previous level and make a new loop
				currLevel--;
				
				if (currLevel >= 0) {
					// free the index of this new level
					free.set(index[currLevel]);
				}
			}

		}

		// for each level search the lower
		// integer that make this "sub-array" a valid permutation
		for (int j = currLevel + 1; j < index.length; j++) {
			// the first valid integer is the index of the first free bit
			index[j] = free.nextSetBit(0);
			free.clear(index[j]);
		}

		// remember that the permutation is already computed
		computed = true;

		return true;
	}
}