package com.misc.coding.problems;

import java.util.HashSet;

/**
 * Given the chemical periodic table, it has 1-char and 2-char symbols e.g. H,
 * He, write a routine, which accepts as input a word e.g. Hello, determine
 * whether this word can be composed of those symbols.
 * 
 * @author sahil.gupta
 *
 */

public class WordFromPeriodicTable {

	HashSet<String> pt;// HashSet representing periodic table

	public WordFromPeriodicTable(HashSet<String> pt) {
		this.pt = pt;
	}

	/**
	 * @param word
	 *            Convert the word to lower case before passing
	 * @param bInd
	 *            The beginning index on where to check the string from
	 * @return true or false depending on if the word can be composed from
	 *         periodic table
	 */
	public boolean isWordFromPeriodTable(String word, int bInd) {
		if (pt.contains(word))
			return true;
		if (word.equals(""))
			return false;
		int ind = 0;
		isWordFromPeriodTable(word, bInd - 1);
		return false;
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
		WordFromPeriodicTable wpt = new WordFromPeriodicTable(pt);

		wpt.isWordFromPeriodTable(word.toLowerCase());
		wpt.isWordFromPeriodTable(word1.toLowerCase());
		wpt.isWordFromPeriodTable(word2.toLowerCase());
		wpt.isWordFromPeriodTable(word3.toLowerCase());
	}

}
