package com.recursion;

import java.util.HashSet;

/**
 * Given the chemical periodic table, it has 1-char and 2-char symbols e.g. H,
 * He, write a routine, which accepts as input a word e.g. Hello, determine
 * whether this word can be composed of those symbols.
 * 
 * @author sahil.gupta
 *
 */

public class WordInPeriodicTable {

	HashSet<String> pt;// HashSet representing periodic table

	public WordInPeriodicTable(HashSet<String> pt) {
		this.pt = pt;
	}

	/**
	 * @param word
	 *            Convert the word to lower case before passing
	 * @return true or false depending on if the word can be composed from
	 *         periodic table
	 */
	public boolean isWordFromPeriodTable(String word) {
		HashSet<String> symbols = new HashSet<String>();

		for (int i = 0; i < word.length(); i++) {
			symbols.add(word.substring(i, i));// 1 character
			symbols.add(word.substring(i, i + 1));// 2 characters
		}

		for (String s : symbols) {
			if (!pt.contains(s)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		String word = "Hello";// returns false for this
		String word1 = "cob";// returns true for this
		String word2 = "nib";// returns true for this
		String word3 = "Periodic Table";// returns false for this

		/*
		 * Let's assume that our periodic table only comprises of these elements
		 */
		HashSet<String> pt = new HashSet<String>();
		pt.add(new String("He").toLowerCase());
		pt.add(new String("O").toLowerCase());
		pt.add(new String("C").toLowerCase());
		pt.add(new String("Li").toLowerCase());
		pt.add(new String("B").toLowerCase());
		pt.add(new String("Ni").toLowerCase());
		WordInPeriodicTable wpt = new WordInPeriodicTable(pt);

		System.out.println(wpt.isWordFromPeriodTable(word.toLowerCase()));
		System.out.println(wpt.isWordFromPeriodTable(word1.toLowerCase()));
		System.out.println(wpt.isWordFromPeriodTable(word2.toLowerCase()));
		System.out.println(wpt.isWordFromPeriodTable(word3.toLowerCase()));
	}

}
