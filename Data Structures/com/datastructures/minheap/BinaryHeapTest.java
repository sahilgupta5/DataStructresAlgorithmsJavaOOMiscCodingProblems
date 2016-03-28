package com.datastructures.minheap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryHeapTest {
	@Test(timeout = 1000)
	public void testSimpleAdd1() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		heap.add("6");
		assertEquals("6", heap.peek());
		System.out.println(heap.peek());
		System.out.println(heap.size());
		assertEquals(false, heap.isEmpty());
	}

	@Test(timeout = 1000)
	public void testSimpleAdd2() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		heap.add("6");
		heap.add("5");
		assertEquals("5", heap.peek());
		System.out.println(heap.peek());
		System.out.println(heap.size());
		assertEquals("[5 6 ]", heap.toString());
	}

	@Test(timeout = 1000)
	public void testAdd1() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		heap.add("6");
		heap.add("5");
		heap.add("3");
		heap.add("1");
		assertEquals("1", heap.peek());
		System.out.println(heap.peek());
		System.out.println(heap.size());
		assertEquals("[1 3 5 6 ]", heap.toString());
	}

	@Test(timeout = 1000)
	public void testAdd2() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		heap.add("6");
		heap.add("5");
		heap.add("3");
		heap.add("1");
		heap.add("8");
		heap.add("7");
		heap.add("2");
		heap.add("4");
		assertEquals("1", heap.peek());
		System.out.println(heap.peek());
		System.out.println(heap.size());
		assertEquals("[1 3 2 4 8 7 5 6 ]", heap.toString());
	}

	@Test(timeout = 1000)
	public void testSimpleRemove1() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		heap.add("6");
		heap.remove();
		assertEquals(null, heap.peek());
		assertEquals(true, heap.isEmpty());
		assertEquals("[]", heap.toString());
	}

	@Test(timeout = 1000)
	public void testSimpleRemove2() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		heap.add("6");
		heap.add("5");
		heap.remove();
		assertEquals("6", heap.peek());
		assertEquals("[6 ]", heap.toString());
	}

	@Test(timeout = 1000)
	public void testRemove1() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		heap.add("6");
		heap.add("5");
		heap.add("3");
		heap.add("1");
		heap.add("8");
		heap.add("7");
		heap.add("2");
		heap.add("4");
		heap.remove();
		assertEquals("2", heap.peek());
		assertEquals("[2 3 5 4 8 7 6 ]", heap.toString());
	}

	@Test(timeout = 1000)
	public void testIsEmpty() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		assertEquals(true, heap.isEmpty());
		heap.add("6");
		assertEquals(false, heap.isEmpty());
	}

	@Test(timeout = 1000)
	public void testPeek() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		assertEquals(null, heap.peek());
		heap.add("6");
		assertEquals("6", heap.peek());
	}

	@Test(timeout = 1000)
	public void testSize() {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		assertEquals(0, heap.size());
		heap.add("6");
		assertEquals(1, heap.size());
		heap.add("5");
		assertEquals(2, heap.size());
		heap.add("4");
		heap.add("10");
		assertEquals(4, heap.size());
		heap.remove();
		assertEquals(3, heap.size());
	}

}