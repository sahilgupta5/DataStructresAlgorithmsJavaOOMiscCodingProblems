package com.datastructures.hashmap;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

public class HashTableTest {
	@Test
	public void testSimpleAdd1() {
		HashTable<String, Integer> table = new HashTable<String, Integer>();
		String key1 = "Sahil";
		Integer value1 = 90264;
		table.put(key1, value1);
		Hashtable<String, Integer> actualHash = new Hashtable<String, Integer>();
		actualHash.put(key1, value1);
		assertEquals(actualHash, table);
	}
}