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

	public static void main(String args[]) {
		String[] arr = { "abd", "dab", "god", "bad", "dog" };
		// String[] arr1 = null;

		String[] outArr = getSortedAnagramHash(arr);
		for (String s : outArr) {
			System.out.println(s);
		}
		// System.out.println(getSortedAnagramHash(arr1).toString());
	}

}
