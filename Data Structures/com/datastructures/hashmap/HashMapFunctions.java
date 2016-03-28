package com.datastructures.hashmap;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapFunctions<k, v> {

	int size = 0;
	int INITIAL_CAPACITY = 10;
	Entry<k, v>[] table;

	static class Entry<k, v> {
		k Key;
		v Value;
		Entry<k, v> next;

		public Entry(k Key, v Value, Entry<k, v> next) {
			this.Key = Key;
			this.Value = Value;
			this.next = next;
		}

		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("Key is: ").append(this.Key).append(" and Value is: ")
					.append(this.Value).append(" and Key Hash Code is: ")
					.append(this.Key.hashCode()).append("\n");
			return s.toString();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMapFunctions() {
		this.table = new Entry[INITIAL_CAPACITY];
	}

	public int hash(k key) {
		return Math.abs(key.hashCode() % INITIAL_CAPACITY);
	}

	public void put(k key, v data) {

		if (key == null)
			return;

		Entry<k, v> e = new Entry<k, v>(key, data, null);
		int hash = hash(key);

		if (table[hash] == null)
			table[hash] = e;
		else {
			Entry<k, v> prev = null;
			Entry<k, v> cur = table[hash];
			while (cur != null) {
				if (cur.Key.equals(data)) {
					cur.Value = data;
				}
				prev = cur;
				cur = cur.next;
			}
			prev.next = e;
		}

		size++;
	}

	public v get(k key) {
		int hash = hash(key);
		if (table[hash] == null)
			return null;
		else {
			Entry<k, v> cur = table[hash];
			while (cur != null) {
				if (cur.Key.equals(key))
					return cur.Value;
				cur = cur.next;
			}
			return null;
		}
	}

	public boolean remove(k key) {
		int hash = hash(key);
		if (table[hash] != null) {
			// for the first element in the linked list matches, remove it
			if (table[hash].Key.equals(key)) {
				table[hash] = table[hash].next;
				size--;
				return true;
			}
			Entry<k, v> cur = table[hash];
			Entry<k, v> prev = null;
			while (cur != null) {
				if (cur.Key.equals(key)) {
					prev.next = cur.next;
					size--;
					return true;
				}
				prev = cur;
				cur = cur.next;
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < INITIAL_CAPACITY; i++) {
			Entry<k, v> cur = table[i];
			if (cur != null) {
				while (cur != null) {
					s.append("Key is: ").append(cur.Key)
							.append(" and Value is: ").append(cur.Value)
							.append(" and Hash Code is: ")
							.append(hash(cur.Key))
							.append(" and Key Hash Code is: ")
							.append(cur.Key.hashCode()).append("\n");
					cur = cur.next;
				}
			}
		}
		s.append("\n");

		return s.toString();
	}

	public static void main(String args[]) {

		HashMap<String, Double> hm = new HashMap<String, Double>();
		// Put elements to the map
		@SuppressWarnings("unused")
		Hashtable<String, Double> ht = new Hashtable<String, Double>();
		hm.put("Zara", new Double(3434.34));
		hm.put("Zara", new Double(4000.34));

		hm.put("Mahnaz", new Double(123.22));
		hm.put("Ayan", new Double(1378.00));
		hm.put("Daisy", new Double(99.22));
		hm.put("Qadir", new Double(-19.08));
		System.out.println(hm.toString());
		System.out.println("\n");

		HashMapFunctions<String, Double> hmf = new HashMapFunctions<String, Double>();
		hmf.put("Zara", new Double(3434.34));
		hmf.put("Zara", new Double(4000.34));
		hmf.put("Tim", new Double(764.34));
		hmf.put("Patty", new Double(5435.34));
		hmf.put("Mahnaz", new Double(123.22));
		hmf.put("Ayan", new Double(1378.00));
		hmf.put("Daisy", new Double(99.22));
		hmf.put("Qadir", new Double(-19.08));
		hmf.put("Mahnaz", new Double(89));
		hmf.put("Ayan", new Double(1378.00));
		hmf.put("Daisy", new Double(99.22));
		System.out.println(hmf.toString());

		hmf.remove("Zara");
		System.out.println(hmf.toString());

		hmf.put("Qadir", new Double(-19.08));
		hmf.put("James", new Double(123.22));
		hmf.put("Karen", new Double(1378.00));
		hmf.put("Shiv", new Double(99.22));
		hmf.put("Cesar", new Double(-19.08));
		hmf.put("Kevin", new Double(123.22));
		System.out.println(hmf.toString());

		System.out.println("Shiv: " + hmf.get("Shiv"));
		hmf.remove("Shiv");
		System.out.println(hmf.toString());

		System.out.println("Mahnaz: " + hmf.get("Mahnaz"));
		hmf.remove("Mahnaz");
		System.out.println(hmf.toString());

		System.out.println("Mahnaz: " + hmf.get("Mahnaz"));
		hmf.remove("Mahnaz");
		System.out.println(hmf.toString());
	}

}