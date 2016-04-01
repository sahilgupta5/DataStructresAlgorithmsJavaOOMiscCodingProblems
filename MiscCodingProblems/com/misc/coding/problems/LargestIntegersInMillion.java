package com.misc.coding.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * You have an array of 1 million integers. Write routine to find the N largest
 * numbers in this array.
 * 
 * @author sahilgupta
 *
 */

public class LargestIntegersInMillion {

	public int[] getLargestN(int[] arr, int n) {
		if (arr == null || arr.length < 10 || n > arr.length)
			return null;

		// using a min heap where minimum numbers are stored at the root, we
		// will remove the smallest when we find a larger number in the array
		PriorityQueue<Integer> largestN = new PriorityQueue<Integer>();

		for (int i = 0; i < n; i++) {
			largestN.add(arr[i]);
		}

		for (int i = n; i < arr.length; i++) {
			if (largestN.peek() < new Integer(arr[i])) {
				largestN.poll();
				largestN.add(arr[i]);
			}
		}

		int[] largest = new int[n];

		for (int i = 0; i < n; i++) {
			largest[i] = largestN.poll();
		}
		return largest;
	}

	public static void main(String args[]) {

		int size = 1000000;
		Random r = new Random();
		int[] test = new int[size];
		for (int i = 0; i < size; i++) {
			test[i] = r.nextInt(1000000);
		}

		int n = 10;

		LargestIntegersInMillion lim = new LargestIntegersInMillion();
		int[] l = lim.getLargestN(test, n);

		for (int i : l) {
			System.out.println(i);
		}

		Arrays.sort(test);

		System.out.println("\n\n\n");

		for (int i = 0; i < n; i++) {
			System.out.println(test[size - n + i]);
		}
	}
}
