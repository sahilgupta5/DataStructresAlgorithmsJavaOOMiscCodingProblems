package com.misc.coding.problems;

import java.util.ArrayList;
import java.util.HashSet;

public class ListIntersections {

	/**
	 * Given two sorted lists, how will you find the intersection of the two
	 * lists.
	 */

	public ArrayList<Integer> getSortedListIntersection(ArrayList<Integer> s1,
			ArrayList<Integer> s2) {
		// S1 = 0, 3, 7, 9, 20, 25 ; l = 6
		// S2 = 1, 5, 6, 7 ; l = 4

		// 1. No duplicates
		// 2. Integer = positive and negative
		// 3. One item in each list

		ArrayList<Integer> result = new ArrayList<Integer>();

		int a = 0, b = 0;

		for (int i = 0; i < (s1.size() + s2.size()); i++) {
			if (s1.get(a) < s2.get(b)) {
				a++;
			} else if (s2.get(b) < s1.get(a)) {
				b++;
			} else if (s1.get(a) == s2.get(b)) {
				result.add(s1.get(a));
			}

			if (a > s1.size() || b > s2.size()) {
				break;
			}
		}

		return result;
	}

	/**
	 * Given two unsorted lists, how will you find the intersection of the two
	 * lists.
	 */

	public ArrayList<Integer> getUnsortedListIntersection(ArrayList<Integer> u1,
			ArrayList<Integer> u2) {
		// S1 = 7, 9, 0, 3, 20, 25 ; l = 6
		// S2 = 4, 5, 1, 7 ; l = 4

		// Create Hash map using u1
		HashSet<Integer> u1Set = new HashSet<Integer>();

		for (int i = 0; i < u1.size(); i++) {
			u1Set.add(u1.get(i));
		}

		u1 = new ArrayList<Integer>();

		for (int j = 0; j < u2.size(); j++) {
			if (u1Set.contains(u2.get(j))) {
				u1.add(u2.get(j));
			}
		}

		return u1;
	}

}
