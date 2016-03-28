package com.datastructures.bst;

import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTreeFunctions<V> {

	public Node<V> getRoot() {
		return root;
	}

	public void setRoot(Node<V> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<V> root;
	public int size;

	static class Node<V> {
		int Key;
		V Val;
		Node<V> left;
		Node<V> right;

		public Node(int Key, V Val, Node<V> left, Node<V> right) {
			this.Key = Key;
			this.Val = Val;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Val.toString();
		}
	}

	/*
	 * Perform a breadth first search and output the strings in that order
	 */
	public String toStringBFS() {

		StringBuilder order = new StringBuilder();
		LinkedList<Node<V>> s = new LinkedList<Node<V>>();

		s.add(root);
		while (!s.isEmpty()) {
			Node<V> t = s.poll();
			order.append(t.toString()).append(" ");// dequeue
			if (t.left != null) {
				s.add(t.left);// enqueue left child
			}
			if (t.right != null) {
				s.add(t.right);// enqueue left child
			}
		}

		return order.toString();
	}

	public Node<V> leftNode(Node<V> node) {
		return node.left;
	}

	public Node<V> rightNode(Node<V> node) {
		return node.right;
	}

	public void iterativeInsert(int k, V v) {
		/*
		 * Input is the key and value. Set current node to root. Create parent.
		 * Loop until current.key != k which means key is already there, so
		 * replace Or current =! null. Set parent to current If key is greater
		 * than current node, current = current.right If key is lesser than
		 * current node, current = current.left
		 * 
		 * After exiting loop, create a new node and insert to the parent
		 * depending on condition.
		 */

		Node<V> newNode = new Node<V>(k, v, null, null);

		if (root == null) {
			root = newNode;
			size++;
			return;
		}

		Node<V> current = this.root;
		Node<V> parent = null;
		while (current != null) {
			parent = current;
			if (k > current.Key)
				current = rightNode(current);
			else if (current.Key == k)
				current.Val = v;
			else if (k < current.Key)
				current = leftNode(current);
		}

		if (k > parent.Key)
			parent.right = newNode;
		else if (k < parent.Key)
			parent.left = newNode;

		size++;
	}

	public void recursiveInsert(int k, V v) {
	}

	public Node<V> iterativeFind(int k) {
		if (root == null) {
			return null;
		}

		Node<V> current = this.root;
		while (current != null) {
			if (k > current.Key)
				current = rightNode(current);
			else if (current.Key == k)
				return current;
			else if (k < current.Key)
				current = leftNode(current);
		}

		return current;
	}

	/*
	 * Takes in the root node and outputs the string containing appropriate
	 * order traversal.
	 */
	public void recursiveInOrder(Node<V> node) {
		if (node == null)
			return;
		// LNR
		recursiveInOrder(leftNode(node));
		System.out.println(node.toString());
		recursiveInOrder(rightNode(node));
	}

	public void recursivePreOrder(Node<V> node) {
		if (node == null)
			return;
		// NLR
		System.out.println(node.toString());
		recursivePreOrder(leftNode(node));
		recursivePreOrder(rightNode(node));
	}

	public void recursivePostOrder(Node<V> node) {
		if (node == null)
			return;
		// LRN
		recursivePostOrder(leftNode(node));
		recursivePreOrder(rightNode(node));
		System.out.println(node.toString());
	}

	public void iterativeInOrder(Node<V> node) {
		if (node == null) {
			return;
		}
		Stack<Node<V>> s = new Stack<Node<V>>();
		Node<V> current = node;
		while (true) {
			if (current != null) {
				s.push(current);
				current = current.left;
			} else {
				if (s.isEmpty()) {
					break;
				}
				current = s.pop();
				System.out.println(current.toString());
				current = current.right;
			}
		}
	}

	// NLR
	public void iterativePreOrder(Node<V> node) {
		if (node == null) {
			return;
		}
		Stack<Node<V>> s = new Stack<Node<V>>();
		Node<V> current = node;
		while (true) {
			if (current != null) {
				System.out.println(current.toString());
				s.push(current);
				current = current.left;
			} else {
				if (s.isEmpty()) {
					break;
				}
				current = s.pop();
				current = current.right;
			}
		}
	}

	// NLR
	public void iterativePostOrder(Node<V> node) {
		if (node == null) {
			return;
		}
		Stack<Node<V>> s1 = new Stack<Node<V>>();
		Stack<Node<V>> s2 = new Stack<Node<V>>();
		Node<V> current = node;
		s1.push(current);
		while (!s1.isEmpty()) {
			current = s1.pop();
			s2.push(current);
			if (current.left != null) {
				s1.push(current.left);
			}
			if (current.right != null) {
				s1.push(current.right);
			}
		}

		while (!s2.isEmpty()) {
			System.out.println(s2.pop().toString());
		}
	}

	public boolean recursiveIsMirror(Node<V> n) {
		return recursiveIsMirrorValue(n.left, n.right);
	}

	public boolean recursiveIsMirrorValue(Node<V> n1, Node<V> n2) {

		if (n1 == null || n2 == null)
			return true;
		// n1.left != null && n1.right != null && n2.left != null
		// && n2.right != null
		if (n1.Val.equals(n2.Val) && n1.left.Val.equals(n2.right.Val)
				&& n1.right.Val.equals(n2.left.Val)) {
			recursiveIsMirrorValue(n1.left, n2.right);
			recursiveIsMirrorValue(n1.right, n2.left);
		}

		return false;
	}

	public int getHeight(Node<V> n) {
		if (n == null) {
			return -1;
		}
		// DONT DO BELOW WHICH WAS INITIAL THOUGHT
		// if (n.left == null) {
		// if (n.right == null) {
		// return 0;
		// } else {
		// return -1;
		// }
		// } else {
		// if (n.right == null) {
		// return 1;
		// }
		// }

		int left = getHeight(n.left);
		int right = getHeight(n.right);

		if (left > right) {
			return left + 1;
		} else {
			return right + 1;
		}
	}

	public boolean isBalanced(Node<V> n) {
		if (n == null || isBalanced(n.left) && isBalanced(n.right)
				&& (Math.abs(getHeight(n.left) - getHeight(n.right)) <= 1))
			return true;
		return false;
	}

	public static void main(String agrs[]) {
		// testBSTTraveralAndFunctions();
		// testMirror();
		// testHeight();
		testBalance();

		BinarySearchTreeFunctions<Integer> sortedBalanced = new BinarySearchTreeFunctions<Integer>();
		int[] sortedArray = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
				233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711,
				28657, 46368, 75025, 121393, 196418, 317811 };

		for (int i = 0; i < sortedArray.length; i++) {
			for (int j = 0; j < sortedArray.length; j++) {
				if (sortedArray[j] != Integer.MIN_VALUE) {
					sortedBalanced.recursiveInsert(sortedArray[j], new Integer(
							sortedArray[j]));
					sortedArray[j] = Integer.MIN_VALUE;
					sortedBalanced.recursiveInsert(sortedArray[2 * j + 1],
							new Integer(sortedArray[2 * j + 1]));
					sortedArray[2 * j + 1] = Integer.MIN_VALUE;
					sortedBalanced.recursiveInsert(sortedArray[2 * j + 2],
							new Integer(sortedArray[2 * j + 2]));
					sortedArray[2 * j + 2] = Integer.MIN_VALUE;
				}
			}
		}

		for (int i : sortedArray) {
			System.out.println(i);
		}
	}

	public static void testBSTTraveralAndFunctions() {
		BinarySearchTreeFunctions<String> b = new BinarySearchTreeFunctions<String>();
		b.iterativeInsert(5, new String("S"));
		b.iterativeInsert(-5, new String("a"));
		b.iterativeInsert(30, new String("h"));
		b.iterativeInsert(-30, new String("i"));
		b.iterativeInsert(-1, new String("l"));
		b.iterativeInsert(20, new String("G"));
		b.iterativeInsert(70, new String("u"));
		b.iterativeInsert(-60, new String("p"));
		b.iterativeInsert(-20, new String("t"));
		b.iterativeInsert(-4, new String("a"));
		b.iterativeInsert(13, new String("Sahil Gupta"));

		System.out.println(b.iterativeFind(13));
		System.out.println("\n");

		b.recursiveInOrder(b.root);
		System.out.println("\n");

		b.recursivePreOrder(b.root);
		System.out.println("\n");

		b.recursivePostOrder(b.root);
		System.out.println("\n");

		b.iterativeInOrder(b.root);
		System.out.println("\n");

		b.iterativePreOrder(b.root);
		System.out.println("\n");

		b.iterativePostOrder(b.root);
		System.out.println("\n");

		System.out.println(b.toStringBFS());
	}

	public static void testMirror() {
		BinarySearchTreeFunctions<String> b = new BinarySearchTreeFunctions<String>();
		b.iterativeInsert(6, new String("6"));
		b.iterativeInsert(2, new String("2"));
		b.iterativeInsert(8, new String("2"));
		b.iterativeInsert(1, new String("1"));
		b.iterativeInsert(5, new String("3"));
		b.iterativeInsert(7, new String("3"));
		b.iterativeInsert(10, new String("1"));

		b.iterativeInOrder(b.root);
		System.out.println("\n");
		System.out.println(b.recursiveIsMirror(b.root));
	}

	public static void testHeight() {
		BinarySearchTreeFunctions<String> b = new BinarySearchTreeFunctions<String>();
		b.iterativeInsert(6, new String("6"));
		b.iterativeInsert(2, new String("2"));
		b.iterativeInsert(8, new String("2"));
		b.iterativeInsert(1, new String("1"));
		b.iterativeInsert(5, new String("3"));
		b.iterativeInsert(7, new String("3"));
		b.iterativeInsert(10, new String("1"));

		b.recursiveInOrder(b.root);
		System.out.println("\n");
		System.out.println(b.getHeight(b.root));
	}

	public static void testBalance() {
		BinarySearchTreeFunctions<String> b = new BinarySearchTreeFunctions<String>();
		b.iterativeInsert(6, new String("6"));
		b.iterativeInsert(2, new String("2"));
		b.iterativeInsert(8, new String("2"));
		b.iterativeInsert(1, new String("1"));
		b.iterativeInsert(5, new String("3"));
		b.iterativeInsert(7, new String("3"));
		b.iterativeInsert(10, new String("1"));

		b.recursiveInOrder(b.root);
		System.out.println("\n");
		System.out.println(b.isBalanced(b.root));
	}
}