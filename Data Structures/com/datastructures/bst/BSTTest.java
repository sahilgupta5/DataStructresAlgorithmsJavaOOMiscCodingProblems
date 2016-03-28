package com.datastructures.bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class BSTTest {

	@Test
	public void test() {
		BST<Integer> B = new BST<Integer>();

		System.out.println("Is Empty Before Creation: " + B.isEmpty());

		B.add(112);
		B.add(46);
		B.add(170);

		List<Integer> L = new ArrayList<Integer>();
		L.add(150);
		L.add(130);
		L.add(160);
		L.add(30);
		L.add(60);

		B.addAll(L);

		B.add(70);
		B.add(null);
		B.add(15);
		B.add(300);
		B.add(250);
		B.add(350);

		List<Integer> LInOrder = B.inOrder();
		String resultInOrder = "[ ";
		for (Iterator<Integer> itr = LInOrder.iterator(); itr.hasNext();) {
			Integer temp = itr.next();
			if (temp != null) {
				resultInOrder += temp.toString();
				resultInOrder += " ";
			} else {
				resultInOrder += "Null";
				resultInOrder += " ";
			}
		}
		resultInOrder += "]";

		System.out.println("List is right before all removals in InOrder: "
				+ resultInOrder);

		List<Integer> LPreOrder = B.preOrder();
		String resultPreOrder = "[ ";
		for (Iterator<Integer> itr = LPreOrder.iterator(); itr.hasNext();) {
			Integer temp = itr.next();
			if (temp != null) {
				resultPreOrder += temp.toString();
				resultPreOrder += " ";
			} else {
				resultPreOrder += "Null";
				resultPreOrder += " ";
			}

		}
		resultPreOrder += "]";

		System.out.println("List is right before all removals in PreOrder: "
				+ resultPreOrder);

		List<Integer> LPostOrder = B.postOrder();
		String resultPostOrder = "[ ";
		for (Iterator<Integer> itr = LPostOrder.iterator(); itr.hasNext();) {
			Integer temp = itr.next();
			if (temp != null) {
				resultPostOrder += temp.toString();
				resultPostOrder += " ";
			} else {
				resultPostOrder += "Null";
				resultPostOrder += " ";
			}
		}
		resultPostOrder += "]";

		System.out.println("List is right before all removals in PostOrder: "
				+ resultPostOrder);

		System.out.println("Size is: " + B.size());
		System.out.println("Is Empty After Creation: " + B.isEmpty());

		B.reconstruct(LPreOrder, LInOrder);

		List<Integer> LInOrder1 = B.inOrder();
		String resultInOrder1 = "[ ";
		for (Iterator<Integer> itr = LInOrder1.iterator(); itr.hasNext();) {
			Integer temp = itr.next();
			if (temp != null) {
				resultInOrder1 += temp.toString();
				resultInOrder1 += " ";
			} else {
				resultInOrder1 += "Null";
				resultInOrder1 += " ";
			}
		}
		resultInOrder1 += "]";

		System.out.println("List is right after reconstruction in InOrder: "
				+ resultInOrder1);

		List<Integer> LPreOrder1 = B.preOrder();
		String resultPreOrder1 = "[ ";
		for (Iterator<Integer> itr = LPreOrder1.iterator(); itr.hasNext();) {
			Integer temp = itr.next();
			if (temp != null) {
				resultPreOrder1 += temp.toString();
				resultPreOrder1 += " ";
			} else {
				resultPreOrder1 += "Null";
				resultPreOrder1 += " ";
			}

		}
		resultPreOrder1 += "]";

		System.out.println("List is right before all removals in PreOrder: "
				+ resultPreOrder1);

		Integer containInteger = 400;
		boolean bool = B.contains(containInteger);
		System.out.println("Contains " + containInteger + " :" + bool);

		Integer containInteger1 = 200;
		boolean bool1 = B.contains(containInteger1);
		System.out.println("Contains " + containInteger1 + " :" + bool1);

		Integer containInteger2 = 110;
		boolean bool2 = B.contains(containInteger2);
		System.out.println("Contains " + containInteger2 + " :" + bool2);

		Integer containInteger3 = null;
		boolean bool3 = B.contains(containInteger3);
		System.out.println("Contains " + containInteger3 + " :" + bool3);

		Integer containInteger4 = 15;
		boolean bool4 = B.contains(containInteger4);
		System.out.println("Contains " + containInteger4 + " :" + bool4);

		Integer removeInteger = 112;
		Integer removeIntegerRet = B.remove(removeInteger);// Node with 2
															// children
		System.out.println("Removed: " + removeIntegerRet);

		Integer removeInteger1 = 15;
		Integer removeIntegerRet1 = B.remove(removeInteger1);// Node with no
																// child
		System.out.println("Removed: " + removeIntegerRet1);

		Integer removeInteger2 = null;
		Integer removeIntegerRet2 = B.remove(removeInteger2);// Node with null
		System.out.println("Removed: " + removeIntegerRet2);

		Integer removeInteger3 = 350;
		Integer removeIntegerRet3 = B.remove(removeInteger3);// Node with no
																// child
		System.out.println("Removed: " + removeIntegerRet3);

		Integer removeInteger4 = 46;
		Integer removeIntegerRet4 = B.remove(removeInteger4);// Node with no
																// child
		System.out.println("Removed: " + removeIntegerRet4);

		System.out.println("Size is: " + B.size());

		List<Integer> LInOrder2 = B.inOrder();
		String resultInOrder2 = "[ ";
		for (Iterator<Integer> itr = LInOrder2.iterator(); itr.hasNext();) {
			Integer temp = itr.next();
			if (temp != null) {
				resultInOrder2 += temp.toString();
				resultInOrder2 += " ";
			} else {
				resultInOrder2 += "Null";
				resultInOrder2 += " ";
			}
		}
		resultInOrder2 += "]";

		System.out.println("List is right before all removals in InOrder: "
				+ resultInOrder2);
	}

}
