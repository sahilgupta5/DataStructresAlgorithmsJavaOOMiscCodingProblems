package com.datastructures.minheap;

import org.junit.Test;

public class MinHeapTest {

	@Test
	public void test() {

		BinaryHeap<Integer> bp = new BinaryHeap<Integer>();

		bp.add(5);
		System.out.println(bp.toString());
		bp.add(9);
		System.out.println(bp.toString());
		bp.add(13);
		System.out.println(bp.toString());
		bp.add(4);
		System.out.println(bp.toString());
		bp.add(2);
		System.out.println(bp.toString());
		bp.add(7);
		System.out.println(bp.toString());
		bp.add(9);
		System.out.println(bp.toString());
		bp.add(10);
		System.out.println(bp.toString());
		// bp.add(15);
		// System.out.println(bp.toString());
		// bp.add(3);
		// System.out.println(bp.toString());
		// bp.add(4);
		// System.out.println(bp.toString());
		// bp.add(5);
		// System.out.println(bp.toString());
		// bp.add(11);
		// System.out.println(bp.toString());
		bp.add(null);
		bp.add(null);
		bp.add(null);
		bp.add(17);
		bp.add(18);
		bp.add(null);
		System.out.println("List after adding everything is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		bp.remove();
		System.out.println("List after adding remove is: ");
		System.out.println(bp.toString());

		// Test Case 2:

		// bp.add(8);
		// bp.add(10);
		// bp.add(8);
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());

		// Test 3:

		// bp.add(2);
		// bp.add(8);
		// bp.add(8);
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());

		// Test 4:
		// bp.add(8);
		// bp.add(8);
		// bp.add(10);
		// bp.add(2);
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());
		// bp.remove();
		// System.out.println(bp.toString());

	}

}