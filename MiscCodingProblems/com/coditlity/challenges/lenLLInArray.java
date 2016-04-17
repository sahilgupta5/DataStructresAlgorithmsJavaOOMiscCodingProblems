package com.coditlity.challenges;

/**
 * Given an array which represents a linked list with condition described below:
 * A =   [1, 4, -1, 3, 2]
 * Index  0  1   2  3  4
 * 
 * 1. A[i] = -1 indicates end of the linked list.
 * 2. A[i] is the index of the successor e.g. A[0] = 1 indicates that next
 * element can be found at index 1.
 * 
 * 			  ___________
 * 			  |			|
 *            |			V
 *  A =   [1, 4, -1, 3, 2]
 *         |  ^   ^     |
 *         |__|   |     |
 *         		  |_____|
 *  
 * Find the length of this linked list.
 * @author sahilgupta
 *
 */

public class lenLLInArray {

	public static int lengthOfLinkedListInArray(int[] A) {

		// make sure no infinite list exists i.e. -1 is not present
		// BUT assumption says it is always possible to construct the list
		// hence no need to test edge cases based on assumptions
		// Also return value in case of edge case has NOT been provided in
		// the question.

		int len = 0;
		for (int i = 0; i < A.length;) {
			// assuming A[k] is a valid index always
			if (A[i] == -1) {
				len++;
				return len;
			} else {
				len++;
				i = A[i];
			}
		}
		return len;
	}

	public static void main(String args[]) {
		int[] A = { 1, 4, -1, 3, 2 };
		System.out.println(lengthOfLinkedListInArray(A));
	}

}