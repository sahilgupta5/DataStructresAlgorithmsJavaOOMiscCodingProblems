package com.datastructures.hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashTable<K, V> {

	/**
	 * The maximum load factor for this hashtable
	 */
	private final double MAX_LOAD_FACTOR = .64;

	/**
	 * The number of entries in this hashtable
	 */
	private int size;
	private final int INITIAL_SIZE = 11;
	private int CURRENT_SIZE;

	/**
	 * The underlying array for this hashtable
	 */
	private Entry<K, V>[] table;

	/**
	 * Puts the key value pair into the table. If the key already exists in the
	 * table, replace the old value with the new one and return the old value
	 * 
	 * @param key
	 *            , never null
	 * @param value
	 *            , possibly null
	 * @return the replaced value, null if nothing existed previously
	 */
	@SuppressWarnings("unchecked")
	public V put(K key, V value) {
		if (table == null) {
			table = (Entry<K, V>[]) new Object[INITIAL_SIZE];
			CURRENT_SIZE = INITIAL_SIZE;
		}
		int index = (key.hashCode() % this.INITIAL_SIZE);// hash the key and
															// compress it.
		V Val = null;
		if (table[index] == null) {// check if the index is null (stick a new
									// node in it)
			table[index] = new Entry<K, V>(key, value);
			table[index].setAvailable(false);
			Val = null;
		} else if (table[index].isAvailable()) {// check to see if the Entry
												// object there is available
												// (stick in the key value pair)
			Val = table[index].getValue();
			table[index].setKey(key);
			table[index].setValue(value);
			table[index].setAvailable(false);
		} else {
			while (table[index].isAvailable() || table[index] == null) {
				if (table[index].isAvailable()) {
					Val = table[index].getValue();
					table[index].setKey(key);
					table[index].setValue(value);
					table[index].setAvailable(false);
					size++;
					return Val;
				} else if (table[index] == null) {
					table[index] = new Entry<K, V>(key, value);
					table[index].setAvailable(false);
					size++;
					return null;
				}
				index--;
				if (index < 0) {// reaches to the top, now wrap from bottom of
								// the table
					index = this.size - 1;
				}
			}
		}
		size++;
		this.checkResize();
		return Val;
	}

	@SuppressWarnings("unchecked")
	private void checkResize() {
		double currentLoadFactor = this.size() / this.CURRENT_SIZE;
		if (currentLoadFactor > this.MAX_LOAD_FACTOR) {// if true, then double
														// the size and rebuild
														// the table
			int OLD_SIZE = this.CURRENT_SIZE;
			this.CURRENT_SIZE = OLD_SIZE * 2 + 1;
			Entry<K, V>[] tempTable = table;
			table = (Entry<K, V>[]) new Object[this.CURRENT_SIZE];
			for (int i = 0; i < OLD_SIZE; i++) {
				if (tempTable[i] != null && tempTable[i].isAvailable() == false) {
					this.put(tempTable[i].getKey(), tempTable[i].getValue());
				}
			}
		}
	}

	/**
	 * Removes the entry containing the given key
	 * 
	 * (remember that all objects have a hashCode method)
	 * 
	 * @param key
	 *            , never null
	 * @return the value of the removed entry
	 */
	public V remove(Object key) {
		int index = (key.hashCode() % this.size);// hash the key and compress
													// the hash
		if (table[index] == null) {// check if the index is null (return null)
			size--;
			return null;
		} else if (!table[index].isAvailable()
				&& table[index].getKey().equals(key)) {// if the entry object is
														// not available
			// and has the key you are looking for set the available flag to
			// true and return the value
			table[index].available = true;
			size--;
			return table[index].getValue();
		} else {// linear probe until you see null
			index--;
			while (table[index] == null) {
				if (!table[index].isAvailable()
						&& table[index].getKey().equals(key)) {
					table[index].available = true;
					size--;
					return table[index].getValue();
				}
				index--;
				if (index < 0) {// reaches to the top, now wrap from bottom of
								// the table
					index = this.size - 1;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the value of the entry given a specific key
	 * 
	 * (remember that all objects have a hashCode method)
	 * 
	 * @param key
	 *            , never null
	 * @return
	 */
	public V get(Object key) {
		int index = (key.hashCode() % this.size);// hash the key and compress
													// the hash
		while (table[index] == null) {
			if (!table[index].isAvailable()
					&& table[index].getKey().equals(key)) {
				return table[index].getValue();
			}
			index--;
			if (index < 0) {// reaches to the top, now wrap from bottom of the
							// table
				index = this.size - 1;
			}
		}
		return null;
	}

	/**
	 * @param key
	 *            , never null
	 * @return true if this table contains the given key, false otherwise
	 */
	public boolean containsKey(Object key) {
		int index = (key.hashCode() % this.size);// hash the key and compress
													// the hash
		while (table[index] == null) {
			if (!table[index].isAvailable()
					&& table[index].getKey().equals(key)) {
				return true;
			}
			index--;
			if (index < 0) {// reaches to the top, now wrap from bottom of the
							// table
				index = this.size - 1;
			}
		}
		return false;
	}

	/**
	 * Clears this hashTable
	 */
	public void clear() {
		this.table = null;
		this.size = 0;
	}

	/**
	 * @return true if this hashtable is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (this.getTable() == null && size == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the value from this hashtable
	 */
	public Collection<V> values() {
		ArrayList<V> collection = new ArrayList<V>();
		for (int i = 0; i < this.CURRENT_SIZE; i++) {
			if (this.table[i] != null && this.table[i].isAvailable() == false) {
				collection.add(this.table[i].getValue());
			}
		}
		return collection;
	}

	/**
	 * @return the unique keys from this hashtable
	 */
	public Set<K> keySet() {
		HashSet<K> set = new HashSet<K>();
		for (int i = 0; i < this.CURRENT_SIZE; i++) {
			if (this.table[i] != null && this.table[i].isAvailable() == false) {
				set.add(this.table[i].getKey());
			}
		}
		return set;
	}

	/**
	 * @return the unique entries from this hashtable
	 */
	public Set<Entry<K, V>> entrySet() {
		HashSet<Entry<K, V>> set = new HashSet<Entry<K, V>>();
		for (int i = 0; i < this.CURRENT_SIZE; i++) {
			if (this.table[i] != null && this.table[i].isAvailable() == false) {
				set.add(new Entry<K, V>(this.table[i].getKey(), this.table[i]
						.getValue()));
			}
		}
		return set;
	}

	/**
	 * @return the size of this hashtable
	 */
	public int size() {
		return size;
	}

	/*
	 * Don't modify any code below this point
	 */

	public void setSize(int size) {
		this.size = size;
	}

	public Entry<K, V>[] getTable() {
		return table;
	}

	public void setTable(Entry<K, V>[] table) {
		this.table = table;
	}

	public double getMaxLoadFactor() {
		return MAX_LOAD_FACTOR;
	}

	public static class Entry<K, V> {
		private K key;
		private V value;
		private boolean available;

		public Entry(K key, V value) {
			this.setKey(key);
			this.setValue(value);
			this.setAvailable(true);
		}

		public void setKey(K key) {
			this.key = key;
		}

		public K getKey() {
			return this.key;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public V getValue() {
			return this.value;
		}

		public boolean isAvailable() {
			return available;
		}

		public void setAvailable(boolean available) {
			this.available = available;
		}
	}
}
