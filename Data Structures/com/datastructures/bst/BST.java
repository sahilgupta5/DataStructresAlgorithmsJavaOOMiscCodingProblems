package com.datastructures.bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BST<T extends Comparable<T>> {

	private Node<T> root;
	private int size = 0;
	
	private Node<T> deleteParentHelper;
	private Node<T> PredecessorHelperDelete;
	private Node<T> Predecessor;
	private T finalRemovedVal;

	/**
	 * Adds a data entry to the BST
	 * 
	 * null is positive infinity
	 * 
	 * @param data
	 *            The data entry to add
	 */
	public void add(T data) {
		if (data == null) {
			root = addNull(root, data);
		} else {
			root = add(root, data);
		}
	}

	/**
	 * Adds a data entry to the tree by making a recursive call to itself
	 * 
	 * @param current
	 *            Current node in the tree
	 * @param data
	 *            Value to add in the tree
	 * @return current Returns the current node being inspected
	 */
	private Node<T> add(Node<T> current, T data) {
		if ((current != null) && (current.getData() != null)) {
			if (strictlyLess(data, current.getData())) {// data < current.data
				current.setLeft(add(current.getLeft(), data));
			} else if (strictlyLess(current.getData(), data)) {// data > current.data
				current.setRight(add(current.getRight(), data));
			}
		} else if ((current != null) && (current.getData() == null)) {
			current.setLeft(add(current.getLeft(), data));// null treated as positive
			// infinity, so new node can only be on left.
		} else {
			current = new Node<T>(data);
			setSize(getSize() + 1);
		}
		return current;
	}

	/**
	 * Adds a null data entry to the tree which is treated as positive infinity
	 * by making a recursive call to itself
	 * 
	 * @param current
	 *            current node in the tree
	 * @param data
	 *            Null value to add in the tree
	 * @return current Returns the current node being inspected
	 */

	private Node<T> addNull(Node<T> current, T data) {
		if (current != null) {
			current.setRight(addNull(current.getRight(), data));// go all the way to
															// the right
		} else {
			current = new Node<T>(data);// data is null here and treated as
										// positive infinity
			setSize(getSize() + 1);
		}
		return current;
	}

	/**
	 * Adds each data entry from the collection to this BST
	 * 
	 * @param c
	 */
	public void addAll(Collection<? extends T> c) {
		if (c == null) {
			throw new NullPointerException("Null collection being added!");
		} else {
			for (Iterator<? extends T> itr = c.iterator(); itr.hasNext();) {
				add(itr.next());
			}
		}
	}

	/**
	 * Checks if the BST contains a data entry
	 * 
	 * null is positive infinity
	 * 
	 * @param data
	 *            The data entry to be checked
	 * @return If the data entry is in the BST
	 */
	public boolean contains(T data) {
		return contains(root, data);
	}

	/**
	 * Checks if the BST contains a data entry by making a recursive call to
	 * itself
	 * 
	 * null is positive infinity
	 * 
	 * @param current
	 *            The current node in the tree
	 * @param data
	 *            The data entry to be checked
	 * @return If the data entry is in the BST
	 */

	private boolean contains(Node<T> current, T data) {
		if (current != null) {
			if ((current.getData() != null) && current.getData().equals(data)) {
				return true;
			} else if((current.getData() == null) &&  data == null){
				//handles null pointer exception when both are null and gives the right result
				return true;
			}
			else {
				if ((current.getData() != null) && (data != null) && strictlyLess(data, current.getData())) {
					// data<current.data
					current = current.getLeft();
					return contains(current, data);
				} else if ((current.getData() != null) && (data != null) && strictlyLess(current.getData(), data)) {
					// data > current.data
					current = current.getRight();
					return contains(current, data);
				} else if ((current.getData() == null) && (data != null)) {
					// handles case when current's data is null and data is not null
					current = current.getLeft();
					return contains(current, data);
				} else if(data == null){
					// handles case when data is null
					current = current.getRight();
					return contains(current, data);
				}
			}
		}
		return false;
	}

	/**
	 * Removes a data entry from the BST
	 * 
	 * null is positive infinity
	 * 
	 * @param data
	 *            The data entry to be removed
	 * @return The removed data entry (null if nothing is removed)
	 */
	public T remove(T data) {
		remove(root, data);
		return getFinalRemovedVal();
	}

	private Node<T> remove(Node<T> current, T data) {
		if (current != null) {
			if ((current.getData() != null) && current.getData().equals(data)) {
				current = removeNode(current);
			} else if((current.getData() == null) &&  data == null){
				//handles null pointer exception when both are null and gives the right result
				current = removeNode(current);
			} else {
				if ((current.getData() != null) && (data != null) && strictlyLess(data, current.getData())) {
					// data<current.data
					setDeleteParentHelper(current);
					current = current.getLeft();
					remove(current, data);
				} else if ((current.getData() != null) && (data != null) && strictlyLess(current.getData(), data)) {
					// data > current.data
					setDeleteParentHelper(current);
					current = current.getRight();
					return remove(current, data);
				} else if ((current.getData() == null) && (data != null)) {
					// handles case when current's data is null and data is not null
					setDeleteParentHelper(current);
					current = current.getLeft();
					return remove(current, data);
				} else if(data == null){
					// handles case when data is null
					setDeleteParentHelper(current);
					current = current.getRight();
					return remove(current, data);
				}
			}
		}
		return current;
	}

	private Node<T> removeNode(Node<T> current) {
		//case1:No children are there
		if(current.getLeft() == null && current.getRight() == null){
			setFinalRemovedVal(current.getData());
			if(getDeleteParentHelper().getLeft() == current){
				getDeleteParentHelper().setLeft(null);
			}else if(getDeleteParentHelper().getRight() == current){
				getDeleteParentHelper().setRight(null);
			}
			setSize(getSize()-1);
			return current;
			//case2:1 children is there
		}else if((current.getLeft() == null || current.getRight() == null) && ((current.getLeft() == null || current.getRight() == null))){
			setFinalRemovedVal(current.getData());
			if(getDeleteParentHelper().getLeft() == current){
				if(getDeleteParentHelper().getLeft().getLeft() != null){
					getDeleteParentHelper().setLeft(current.getLeft());
				}else{
					getDeleteParentHelper().setLeft(current.getRight());
				}
			}else if(getDeleteParentHelper().getRight() == current){
				if(getDeleteParentHelper().getLeft() != null){
					getDeleteParentHelper().setRight(current.getLeft());
				}else{
					getDeleteParentHelper().setRight(current.getRight());
				}
			}
			Node<T> temp = current;
			current = null;
			setSize(getSize()-1);
			return temp;
			//case3:2 children are there
		}else if(current.getLeft() != null && current.getRight() != null){
			setFinalRemovedVal(current.getData());
			setPredecessor(current.getLeft());
			setPredecessorHelperDelete(current);
			while(Predecessor.getRight() != null){//find the predecessor
				setPredecessorHelperDelete(Predecessor);
				setPredecessor(Predecessor.getRight());
			}
			current.setData(Predecessor.getData());//set the data of predecessor to current node to delete
			
			if(Predecessor.getLeft() == null){
				if(Predecessor.getData().equals(PredecessorHelperDelete.getData())){
					getPredecessorHelperDelete().setLeft(null);
				}else if(strictlyLess(PredecessorHelperDelete.getData(), Predecessor.getData())){
					getPredecessorHelperDelete().setRight(null);
				}
				
			}else{
				current.setLeft(Predecessor.getLeft());
				getPredecessorHelperDelete().setLeft(Predecessor.getLeft());
			}
			setSize(getSize()-1);
		}
		return current;
	}

	/**
	 * Finds the pre-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in pre-order
	 */
	public List<T> preOrder() {
		List<T> L = new ArrayList<T>();
		L = preOrder(root);
		return L;
	}

	private List<T> preOrder(Node<T> current) {
		List<T> L = new ArrayList<T>();
		if (current != null) {
			L.add(current.getData());
			L.addAll(preOrder(current.getLeft()));
			L.addAll(preOrder(current.getRight()));
		}
		return L;
	}

	/**
	 * Finds the in-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in in-order
	 */
	public List<T> inOrder() {
		List<T> L = new ArrayList<T>();
		L = inOrder(root);
		return L;
	}
	
	private List<T> inOrder(Node<T> current) {
		List<T> L = new ArrayList<T>();
		if (current != null) {
			L.addAll(inOrder(current.getLeft()));
			L.add(current.getData());
			L.addAll(inOrder(current.getRight()));
		}
		return L;
	}

	/**
	 * Finds the post-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in post-order
	 */
	public List<T> postOrder() {
		List<T> L = new ArrayList<T>();
		L = postOrder(root);
		return L;
	}

	private List<T> postOrder(Node<T> current) {
		List<T> L = new ArrayList<T>();
		if (current != null) {
			L.addAll(postOrder(current.getLeft()));
			L.addAll(postOrder(current.getRight()));
			L.add(current.getData());
		}
		return L;
	}
	
	/**
	 * Checks to see if the BST is empty
	 * 
	 * @return If the BST is empty or not
	 */
	public boolean isEmpty() {
		if (getSize() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Clears this BST
	 */
	public void clear() {
		root = null;
		setSize(0);
	}

	/**
	 * @return the size of this BST
	 */
	public int size() {
		if (getSize() > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else
			return getSize();
	}

	/**
	 * First clears this BST, then reconstructs the BST that is uniquely defined
	 * by the given preorder and inorder traversals
	 * 
	 * (When you finish, this BST should produce the same preorder and inorder
	 * traversals as those given)
	 * 
	 * @param preorder
	 *            a preorder traversal of the BST to reconstruct
	 * @param inorder
	 *            an inorder traversal of the BST to reconstruct
	 */
	public void reconstruct(List<? extends T> preorder,
			List<? extends T> inorder) {
		if(preorder == null){
			return ;//do nothing because tree cannot be reconstructed
		}
		this.clear();
		this.addAll(preorder);
	}

	/**
	 * this is how you use a comparator
	 * 
	 * @param a
	 * @param b
	 * @param comparator
	 * @return true if a < b, check using the comparator
	 */

	public static <T extends Comparable<T>> boolean strictlyLess(T a, T b) {
		if (a.compareTo(b) < 0) {
			return true;
		} else
			return false;
	}

	/*
	 * The following methods are for grading, do not modify them
	 */

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<T> getDeleteParentHelper() {
		return deleteParentHelper;
	}

	public void setDeleteParentHelper(Node<T> deleteParentHelper) {
		this.deleteParentHelper = deleteParentHelper;
	}

	public Node<T> getPredecessorHelperDelete() {
		return PredecessorHelperDelete;
	}

	public void setPredecessorHelperDelete(Node<T> predecessorHelperDelete) {
		PredecessorHelperDelete = predecessorHelperDelete;
	}

	public T getFinalRemovedVal() {
		return finalRemovedVal;
	}

	public void setFinalRemovedVal(T finalRemovedVal) {
		this.finalRemovedVal = finalRemovedVal;
	}

	public Node<T> getPredecessor() {
		return Predecessor;
	}

	public void setPredecessor(Node<T> predecessor) {
		Predecessor = predecessor;
	}

	public static class Node<K extends Comparable<K>> {

		private K data;
		private Node<K> left, right;

		public Node(K data) {
			setData(data);
		}

		public K getData() {
			return data;
		}

		public void setData(K data) {
			this.data = data;
		}

		public Node<K> getLeft() {
			return left;
		}

		public void setLeft(Node<K> left) {
			this.left = left;
		}

		public Node<K> getRight() {
			return right;
		}

		public void setRight(Node<K> right) {
			this.right = right;
		}
	}

}
