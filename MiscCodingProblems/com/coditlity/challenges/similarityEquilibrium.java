package com.coditlity.challenges;

/**
 * An array A and int X is given to you. Find a number k such that A can be
 * divided into two sub parts A[0....k] and A[k....N-1] based on this condition:
 * The number of elements same as X in A[0....k] is equal to number of elements
 * different from X in A[k....N-1].
 * 
 * @author sahilgupta
 *
 */

class similarityEquilibrium {

	public static int solutions(int X, int[] A) {
		int same = 0;
		int diff = 0;
		int i = 0;

		while (i < A.length) {
			if (A[i] == X) {
				same++;
			} else if (A[A.length - i - 1] != X) {
				diff++;
			}
			if (same == diff) {
				return i + 1;
			}
			i++;
		}

		return i;

	}

	public static void main(String args[]) {
		int[] A = { 5, 5, 1, 7, 2, 3, 5 };
		System.out.println(solutions(5, A));

		int[] B = { 5, 5, 5 };
		System.out.println(solutions(5, B));

		int[] C = { 3, 4, 1, 7, 2, 3, 10 };
		System.out.println(solutions(5, C));
	}

}