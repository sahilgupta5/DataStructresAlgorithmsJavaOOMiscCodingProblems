package com.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class SortingApplications {

	public static String sortString(String s) {

		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	/**
	 * Write a method to sort an array of strings so that all the anagrams are
	 * next to each other.
	 * 
	 * @param inArr
	 * @return
	 */
	public static String[] getSortedAnagramHash(String[] inArr) {

		HashMap<String, LinkedList<String>> m = new HashMap<String, LinkedList<String>>();
		for (String s : inArr) {
			String k = sortString(s);
			if (m.containsKey(k)) {
				m.get(k).add(s);
			} else {
				LinkedList<String> ll = new LinkedList<String>();
				ll.add(s);
				m.put(k, ll);
			}
		}
		int i = 0;
		for (String k : m.keySet()) {
			for (Object s : m.get(k).toArray()) {
				inArr[i] = s.toString();
				i++;
			}
		}

		return inArr;
	}

	/**
	 * Problem: Given a sorted array of n integers that has been rotated an
	 * unknown number of times, write code to find an element in the array. You
	 * may assume that the array was originally sorted in increasing order.
	 * 
	 * Solution: Perform a binary search to find the element. Since, it is in
	 * sorted order mostly we can find the number in O(log(n)) time.
	 * 
	 * @param args
	 */

	public int getElementIndexSortedArray(int[] arr, int numFind) {

		int index = arr.length / 2;

		for (int i = 0; i < arr.length; i++) {

		}

		return index;

	}

	public void testCase1SortedAnagramHash() {
		String[] arr = { "abd", "dab", "god", "bad", "dog" };
		// String[] arr1 = null;

		String[] outArr = getSortedAnagramHash(arr);
		for (String s : outArr) {
			System.out.println(s);
		}
		// System.out.println(getSortedAnagramHash(arr1).toString());
	}

	public void testCase2ElementIndexSortedArray() {
		int[] arr = { 56, 69, 73, 78, 81, 3, 5, 8, 13, 21, 25, 45 };
		int num = arr[6];
		System.out.println(getElementIndexSortedArray(arr, num));
	}

	public static void main(String args[]) {

		SortingApplications sa = new SortingApplications();
		sa.testCase1SortedAnagramHash();
		sa.testCase2ElementIndexSortedArray();
	}

}
