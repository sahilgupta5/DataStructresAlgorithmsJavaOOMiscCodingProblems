package com.datastructures;

public class LinkedListFunctions {

	Node head, tail;
	int length = 0;

	private class Node {
		public Node(int data) {
			this.data = data;
		}

		public int data;
		public Node next;
	}

	public void addToHeadLL(int data) {
		Node a = new Node(data);
		if (length == 0) {
			tail = a;
			head = a;
			a.next = null;
		} else {
			a.next = head; // add to the front of the list
			head = a; // now set the head to this new node

		}
		length++;
	}

	public void addToTailLL(int data) {
		Node a = new Node(data);
		if (length == 0) {
			head = a;
			tail = a;
			a.next = null;
		} else {
			tail.next = a; // add to the end of the list
			tail = a; // now set the tail to this new node
		}

		length++;
	}

	public void removeFromHeadLL() {
		head = head.next;
		length--;
	}

	public void removeFromTailLL() {
		Node iterate = head;
		while (!iterate.next.equals(tail)) {
			iterate = iterate.next;
		}

		iterate.next = null;
		length--;
	}

	public int getValueAtIndex(int i) {

		if (i < 0 || i >= length) {
			return (int) Math.pow(2.0, 31.0);
		}
		Node iterator = head;
		int count = 0;
		while (count != i) {
			iterator = iterator.next;
			count++;
		}
		return iterator.data;
	}

	public String toString() {
		if (head == null) {
			return "Linked List is empty!";
		}
		StringBuilder ll = new StringBuilder();
		Node iterator = head;

		ll.append("[ ");

		for (int i = 0; i < length; i++) {
			ll.append(new Integer(iterator.data).toString()).append(" ");
			iterator = iterator.next;
		}
		ll.append("]");

		return ll.toString();
	}

	public static void main(String args[]) {
		LinkedListFunctions ll = new LinkedListFunctions();
		ll.addToHeadLL(10);
		ll.addToHeadLL(20);
		ll.addToHeadLL(30);

		ll.addToHeadLL(43);
		ll.addToHeadLL(32);
		ll.addToHeadLL(69);

		ll.addToTailLL(40);
		ll.addToTailLL(-10);
		ll.addToTailLL(5);

		ll.addToTailLL(100);
		ll.addToTailLL(0);
		ll.addToTailLL(50);

		System.out.println(ll.toString());

		ll.removeFromHeadLL();
		System.out.println(ll.toString());

		ll.removeFromHeadLL();
		System.out.println(ll.toString());

		ll.removeFromTailLL();
		System.out.println(ll.toString());

		System.out.println(ll.length);
		System.out.println(ll.getValueAtIndex(10));
	}
}
