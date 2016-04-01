package com.misc.coding.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * You have an array of 1 million integers. Write routine to find the N smallest
 * numbers in this array.
 * 
 * @author sahilgupta
 *
 */

public class SmallestIntegersInMillion {

	public int[] getSmallestN(int[] arr, int n) {
		if (arr == null || arr.length < 10 || n > arr.length)
			return null;

		// using a min heap where largest numbers are stored at the root, we
		// will remove the largest when we find a smaller number in the array

		// Java implementation of max binary heap
		PriorityQueue<Integer> smallestN = new PriorityQueue<Integer>(10,
				Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			smallestN.add(arr[i]);
		}

		for (int i = n; i < arr.length; i++) {
			if (smallestN.peek() > new Integer(arr[i])) {
				smallestN.poll();
				smallestN.add(arr[i]);
			}
		}

		int[] smallest = new int[n];

		for (int i = 0; i < n; i++) {
			smallest[i] = smallestN.poll();
		}
		return smallest;
	}

	public static void main(String args[]) {

		int size = 1000000;
		Random r = new Random();
		int[] test = new int[size];
		for (int i = 0; i < size; i++) {
			test[i] = r.nextInt(1000000);
		}

		int n = 10;

		SmallestIntegersInMillion lim = new SmallestIntegersInMillion();
		int[] l = lim.getSmallestN(test, n);

		for (int i : l) {
			System.out.println(i);
		}

		Arrays.sort(test);

		System.out.println("\n\n\n");

		for (int i = 0; i < n; i++) {
			System.out.println(test[i]);
		}
	}
}
