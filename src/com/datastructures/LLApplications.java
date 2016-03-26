package com.datastructures;
import java.util.HashMap;
import java.util.LinkedList;

public class LLApplications {

	public static void main(String args[]) {

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(10);
		ll.add(30);

		// removeDuplicates(ll);
		//getKthLastElement(1, ll);

		// System.out.println(ll.toString());
		System.out.println(getKthLastElement(3, ll));

	}

	public static void removeDuplicates(LinkedList<Integer> ll) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (Integer i : ll) {
			m.put(i, i);
		}

		ll.removeAll(ll);

		for (Integer i : m.keySet()) {
			ll.add(i);
		}
	}

	public static Integer getKthLastElement(int i, LinkedList<Integer> ll) {
		int index = ll.size() - i;
		return ll.get(index).intValue();
	}

}