package com.misc.coding.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * You have an array of 1 million integers. Write routine to find the 10 largest
 * numbers in this array.
 * 
 * @author sahilgupta
 *
 */

public class LargestIntegersInMillion {

	public LinkedList<Integer> getLargest10(int[] arr) {
		if (arr == null || arr.length < 10)
			return null;

		// smallest elements are stored in the beginnning of the queue towards
		// the head
		LinkedList<Integer> largest10 = new LinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			largest10.add(0);
		}

		for (int i = 0; i < arr.length; i++) {
			// if the number is greater push at the end of queue and remove the
			// head or beginning of queue
			if (largest10.peek() < arr[i]) {
				largest10.poll();
				largest10.addLast(arr[i]);
			}
		}

		return largest10;
	}

	public static void main(String args[]) {

		int size = 100;
		Random r = new Random();
		int[] test = new int[size];
		for (int i = 0; i < size; i++) {
			test[i] = r.nextInt(1000);
		}

		LargestIntegersInMillion lim = new LargestIntegersInMillion();
		LinkedList<Integer> l = lim.getLargest10(test);

		for (Integer i : l) {
			System.out.println(i);
		}

		Arrays.sort(test);

		System.out.println("\n\n\n");

		for (int i = 0; i < 10; i++) {
			System.out.println(test[size - i - 1]);
		}
	}
}
