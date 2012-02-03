/*
 * Created on Aug 4, 2005
 *
 * $Id: IntegerPermutationTest.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.IntegerPermutation;

import junit.framework.TestCase;

/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class IntegerPermutationTest extends TestCase {

	public void testNext() {
		
		//assertTrue(false);
		
		work(new int[] {0});
		work(new int[] {0,1});
		work(new int[] {0,1,2});
		work(new int[] {0,1,2,3});
		long a = System.currentTimeMillis();
		//work(new int[] {1,2,3,4,5,6,7,8,9}); // -> 362880 permutazioni
		long b = System.currentTimeMillis();
		System.err.println("Delta = " + (b-a));
	}
	
	public void testSpeed() {
		
		
		long a = System.currentTimeMillis();
		speedWorkNew(new int[] {0,1,2,3,4,5,6}); // -> 362880 permutazioni
		long b = System.currentTimeMillis();
		System.err.println("Time new = " + (b-a));

		a = System.currentTimeMillis();
		speedWorkOld(new int[] {0,1,2,3,4,5,6}); // -> 362880 permutazioni
		b = System.currentTimeMillis();
		System.err.println("Time old = " + (b-a));

	}

	protected void work(int[] initV) {
		System.err.println("\n----------------------\n");
		int count = 1;
		
		System.err.println("NUM : " + count + ") " + arrayToString(initV));
		count++;
		
		for (IntegerPermutation perm = new IntegerPermutation(initV); perm.hasNext(); count++ ) {
			int[] values = perm.next();
			System.err.println("NUM : " + count + ") " + arrayToString(values));
		}
	}
	
	
	
	protected void speedWorkNew(int[] initV) {
		int count =1;
		for (IntegerPermutation perm = new IntegerPermutation(initV);
			perm.hasNext(); perm.next() ) {
			count++;
		}
		System.err.println("Tot = " + count);
	}
	
	protected void speedWorkOld(int[] initV) {
		int count =1;
		while(nextPermutation(initV, initV.length, initV.length)) {
			// nothing
			count++;
		}
		System.err.println("Tot = " + count);
	}
	
	
	
	// -------------------------
	
	/**
	 * Computes next Permutation of the given Array in P
	 * 
	 * @param P   an array of integer between 0 and N-1
	 * @param N   the number of distinc integer (0 ... N-1)
	 * @param C   length of the array P (number of distinct integer)
	 */
	private boolean nextPermutation(int[] P, int N, int C) {
		// the current level of permutation : always start from lower level
		int currLevel = C - 1;

		//System.err.println(">>> INIZIO ");
		while (true) {
			//System.err.println("While " + arrayToString(P) + " | lvl= "+currLevel);
			
			// the current element contains the last valid integer ?
			if (P[currLevel] != N - 1) {
				// no : increment this value and check if it is already used
				//      (if no, the array contains a valid permutation)
				P[currLevel]++;
				if (isValidPermutation(P, currLevel))
					break;
			} else {
				// yes : all permutation of this "level" are already checked,
				//       then go to the previous level and make a new loop
				currLevel--;
			}

			// 0 is the higer level, then a level<0 means that all permutation
			// are checked
			if (currLevel < 0) {
				//System.err.println("<<<< STOOOP ");
				return false;
			}
		}

		// if current level isn't the lower one, for each level search the lower
		// integer that make this "sub-array" a valid permutation
		for (int j = currLevel + 1; j < C; j++) {
			for (P[j] = 0; !isValidPermutation(P, j); P[j]++) {
				// do nothing
			}
		}
		//System.err.println("<<< FINE " + arrayToString(P));

		return true;
	}

	/**
	 * Check if given array contains a valid permutation. A permutation is valid
	 * if it contains only distinct integers and this function check that the
	 * value contained in the element <b>idx </b> is different from all others
	 * elements between index <b>0 </b> to index <b>idx-1 </b>
	 * 
	 * @param P   the array
	 * @param idx the lower level
	 */
	private boolean isValidPermutation(int[] P, int idx) {
		
		// value stored in the lower level 
		int value = P[idx];
		
		// check if that value is stored in one of higer level
		for (int level = idx - 1; level >= 0; level--) {
			if (value == P[level]) {
				return false;
			}
		}
		return true;
	}

	
	
	protected String arrayToString(int[] initV) {
		StringBuffer buff = new StringBuffer(" values = [");
		for (int i=0; i<initV.length; i++) {
			buff.append((i==0? "" : ", ") +  initV[i]);
		}
		buff.append("]");
		return buff.toString();
	}
	
}
