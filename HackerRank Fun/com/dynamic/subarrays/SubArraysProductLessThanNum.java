package com.dynamic.subarrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * A sub array of an array, "numbers", is a contiguous block of nums having
 * length less than or equal to length of the "numbers" array.
 * 
 * Example: numbers = {1, 2, 3} sub arrays are = {1}, {2}, {3}, {1, 2}, {2, 3}
 * and {1, 2, 3}.
 * 
 * "products for sub arrays" are = 1, 2, 3, 2, 6, 6 correspondingly.
 * 
 * Write the function "count" which takes two params: 1. An array of n integers,
 * numbers. 2. integer k
 * 
 * Such that:
 * 
 * "count" returns the long result containing total number of
 * "products for sub arrays" < k.
 * 
 * @author sahilgupta
 */

public class SubArraysProductLessThanNum {

	static long count(int[] numbers, int k) {
		int len = numbers.length;

		long counter = 0;

		/*
		 * Multiple ways of doing this: Dynamic programming and brute force.
		 * Below attempt using dynamic programming bottom up approach.
		 */

		int mult = 1;

		int winLeft = 0, winRight = -1;
		while (winLeft < len) {
			int subArrSize;

			while (winRight + 1 < len && numbers[winRight + 1] < Math.ceil((double) k / mult)) {
				mult *= numbers[++winRight];
			}

			subArrSize = winRight - winLeft + 1;

			counter += subArrSize;
			mult = mult / numbers[winLeft];
			++winLeft;
		}

		return counter;
	}

	public static void main(String args[]) throws IOException {
		Scanner input = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter output = new BufferedWriter(new FileWriter(fileName));

		int size = Integer.parseInt(input.nextLine().trim());
		int nums[] = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = Integer.parseInt(input.nextLine().trim());
		}
		int k = Integer.parseInt(input.nextLine().trim());

		long result = count(nums, k);

		output.write(String.valueOf(result));
		output.newLine();
		output.close();
		input.close();
	}

}
