package com.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * This was asked by Affirm. Documented here as well:
 * https://www.careercup.com/question?id=18805666
 * 
 * The question was:
 * insert(k, v) <- O(1)
 * lookup(k) <- O(1)
 * remove(k) <- O(1)
 * iterate() <- Iterate through all keys in order of insertion. O(n)
 * 
 * Answer: This is Analogous to Java's LinkedHashMap. Just create a LinkedList structure and attach new nodes 
 * (elements) as they are added, it's going to be in added order.
 * 
 * http://www.javamadesoeasy.com/2015/02/linkedhashmap-custom-implementation.html
 */

/*
 * This is the easiet solution I found and implemented self. I think this may not be fully accurate.
 * IDEALLY a linked hash map should actually be implemented NOT the solution below.
 */
public class OrderedHashTable<k, v> {

	ArrayList<k> arrOrder;
	HashMap<k, v> hm;

	public OrderedHashTable() {
		arrOrder = new ArrayList<k>();
		hm = new HashMap<k, v>();
	}

	public void insert(k key, v value) {
		hm.put(key, value);
		arrOrder.add(key);
	}

	public v lookup(k key) {
		return hm.get(key);
	}

	public void remove(k key) {
		hm.remove(key);
	}

	public String iteratorKey() {
		StringBuilder sb = new StringBuilder();
		for (k itr : arrOrder) {
			sb.append(itr).append("   ");
		}
		return sb.toString();
	}

	public String iteratorVal() {
		StringBuilder sb = new StringBuilder();
		for (k itr : arrOrder) {
			sb.append(this.lookup(itr)).append("   ");
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		OrderedHashTable<Integer, String> oht = new OrderedHashTable<Integer, String>();
		oht.insert(4, "Test Insert 1");
		oht.insert(5, "Test Insert 2");
		oht.insert(6, "Test Insert 3");
		oht.insert(7, "Test Insert 4");
		oht.insert(4, "Test Insert 5");
		oht.insert(8, "Test Insert 6");
		oht.insert(5, "Test Insert 7");
		System.out.println(oht.iteratorKey());
		System.out.println(oht.iteratorVal());
	}
}