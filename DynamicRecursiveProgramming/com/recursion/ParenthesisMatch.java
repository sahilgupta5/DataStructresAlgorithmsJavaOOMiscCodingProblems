package com.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Implement an algorithm to print all valid (e.g. properly opened and closed)
 * combinations of n-pairs of parentheses. Example:
 * 
 * Input: 3 Output: ((())), (()()), (())(), ()(()), ()()()
 * 
 * @author sahil.gupta
 *
 */

public class ParenthesisMatch {

	/*
	 * Since we do not want duplicates, we can use hash set.
	 */
	public Set<String> parenthesisMatch(int n) {
		Set<String> s = new HashSet<String>();
		if (n == 0) {
			s.add("");
			// return s;
		} else {
			Set<String> prev = parenthesisMatch(n - 1);
			for (String str : prev) {
				for (int i = 0; i < str.length(); i++) {
					String subFirst, subSecond;
					if (str.charAt(i) == '(') {
						// perform the "()" insert
						subFirst = str.substring(0, i + 1);
						subSecond = str.substring(i + 1, str.length());
						s.add(subFirst + "()" + subSecond);
					}
				}
				if (!prev.contains("()" + str)) {
					s.add("()" + str);
				}
			}
		}
		return s;

	}

	public static void main(String args[]) {
		ParenthesisMatch pm = new ParenthesisMatch();
		System.out.println(pm.parenthesisMatch(0).toString());
		System.out.println(pm.parenthesisMatch(1).toString());
		System.out.println(pm.parenthesisMatch(2).toString());
		System.out.println(pm.parenthesisMatch(3).toString());
		System.out.println(pm.parenthesisMatch(4).toString());
	}

}
