package com.datastructures.minheap;

import java.util.Comparator;

/**
 * This is an implementation of a heap that is backed by an array.
 * 
 * This implementation will accept a comparator object that can be used to
 * define an ordering of the items contained in this heap, other than the
 * objects' default compareTo method (if they are comparable). This is useful if
 * you wanted to sort strings by their length rather than their lexicographic
 * ordering. That's just one example.
 * 
 * Null should be treated as positive infinity if no comparator is provided. If
 * a comparator is provided, you should let it handle nulls, which means it
 * could possibly throw a NullPointerException, which in this case would be
 * fine.
 * 
 * If a comparator is provided that should always be what you use to compare
 * objects. If no comparator is provided you may assume the objects are
 * Comparable and cast them to type Comparable<T> for comparisons. If they
 * happen to not be Comparable you do not need to handle anything, and you can
 * just let your cast throw a ClassCastException.
 * 
 * This is a minimum heap, so the smallest item should always be at the root.
 * 
 * @param <T>
 *            The type of objects in this heap
 */
public class BinaryHeap<T> implements Heap<T> {

	/**
	 * The comparator that should be used to order the elements in this heap
	 */
	private Comparator<T> comp;

	/**
	 * The backing array of this heap
	 */
	private T[] data;

	/**
	 * The number of elements that have been added to this heap, this is NOT the
	 * same as data.length
	 */
	private int size;

	/**
	 * Default constructor, this should initialize data to a default size (11 is
	 * normally a good choice)
	 * 
	 * This assumes that the generic objects are Comparable, you will need to
	 * cast them when comparing since there are no bounds on the generic
	 * parameter
	 */

	@SuppressWarnings("unchecked")
	public BinaryHeap() {
		data = (T[]) new Object[11];
		size = 0;
		comp = new Comparator<T>() {
			@Override
			public int compare(T a, T b) {
				return ((Comparable<T>) a).compareTo(b);
			}
		};
	}

	/**
	 * Constructor that accepts a comparator to use with this heap. Also
	 * initializes data to a default size.
	 * 
	 * When a comparator is provided it should be preferred over the objects'
	 * compareTo method
	 * 
	 * If the comparator given is null you should attempt to cast the objects to
	 * Comparable as if a comparator were not given
	 * 
	 * @param comp
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap(Comparator<T> comp) {
		data = (T[]) new Object[11];
		size = 0;
		if (comp == null) {
			comp = new Comparator<T>() {
				@Override
				public int compare(T a, T b) {
					return ((Comparable<T>) a).compareTo(b);
				}
			};
		} else {
			this.comp = comp;
		}
	}

	/**
	 * This method adds an item to the heap by using the comparator.
	 */
	@Override
	public void add(T item) {
		/*
		 * Pseudo Code: add(item){ check for resize; put item at the end of the
		 * heap; while(item is not in the root and item < parent(item)){ swap
		 * item with it's parent; } }
		 * 
		 * example: if the array is [size]
		 */
		if (data.length == (size() + 1)) {
			resize(data);
		}

		int tempIndexOfItem = size + 1;// the end of the list
		int parentIndexOfItem = tempIndexOfItem / 2;

		T tempSwap;

		data[tempIndexOfItem] = item;// add the item to the index of item

		size++;
		if (item != null) {
			// perform the bubble up operation or bottom up operation.
			// while (ItemIndex is not the rootIndex or 1 and parent is not null
			// and item < parent) keep looping
			while (tempIndexOfItem != 1 && data[parentIndexOfItem] != null
					&& (comp.compare(item, data[parentIndexOfItem]) <= 0)) {
				tempSwap = data[parentIndexOfItem];
				data[parentIndexOfItem] = data[tempIndexOfItem];
				data[tempIndexOfItem] = tempSwap;
				tempIndexOfItem = parentIndexOfItem;
				parentIndexOfItem = tempIndexOfItem / 2;
			}

			// if parent is null then we will always swap because it is a
			// minimum-heap
			// and null is treated as positive infinity
			if (parentIndexOfItem != 0 && data[parentIndexOfItem] == null) {
				while (tempIndexOfItem != 1 && data[parentIndexOfItem] == null) {
					data[parentIndexOfItem] = data[tempIndexOfItem];
					data[tempIndexOfItem] = null;
					parentIndexOfItem = tempIndexOfItem / 2;
				}
			}
		}
		// if item == null then do nothing because it is automatically added to
		// the last available position
	}

	@Override
	public T remove() {
		/*
		 * Pseudo Code: remove(){ extract the item from the root put the item
		 * from the last leaf in its place; remove the last leaf; both subtrees
		 * of the roots are heaps; p = the root; while(p != leaf && p > any of
		 * its children) { swap p with the smaller child; } }
		 */

		if (size == 0) {
			return null;
		}

		T root = data[1];
		data[1] = data[size];
		data[size] = null;
		size--;
		T p = data[1];

		int tempIndexOfItem = 1;// beginning of the list
		int childIndexOfItemLeft = 2 * tempIndexOfItem;
		int childIndexOfItemRight = (2 * tempIndexOfItem) + 1;

		T TempSwap;

		if (p != null) {
			if (data[childIndexOfItemLeft] != null
					&& data[childIndexOfItemRight] != null) {
				while (childIndexOfItemLeft <= size
						&& childIndexOfItemRight <= size
						&& data[childIndexOfItemLeft] != null
						&& data[childIndexOfItemRight] != null
						&& ((comp.compare(data[tempIndexOfItem],
								data[childIndexOfItemLeft]) >= 0) || (comp
								.compare(data[tempIndexOfItem],
										data[childIndexOfItemRight]) >= 0))) {
					if (comp.compare(data[childIndexOfItemRight],
							data[childIndexOfItemLeft]) >= 0) {
						// bubble down with left child
						TempSwap = data[tempIndexOfItem];// parent
						data[tempIndexOfItem] = data[childIndexOfItemLeft];
						data[childIndexOfItemLeft] = TempSwap;
						tempIndexOfItem = childIndexOfItemLeft;
					} else if (comp.compare(data[childIndexOfItemLeft],
							data[childIndexOfItemRight]) > 0) {
						// bubble down with right child
						TempSwap = data[tempIndexOfItem];// parent
						data[tempIndexOfItem] = data[childIndexOfItemRight];
						data[childIndexOfItemRight] = TempSwap;
						tempIndexOfItem = childIndexOfItemRight;
					}
					childIndexOfItemLeft = 2 * tempIndexOfItem;
					childIndexOfItemRight = (2 * tempIndexOfItem) + 1;
				}
			} else {
				// case: call remove on [15, N, 17, N, N, N, 18]
				if (data[childIndexOfItemLeft] == null
						&& size > 2
						&& comp.compare(data[tempIndexOfItem],
								data[childIndexOfItemRight]) > 0) {
					// bubble down with right child
					TempSwap = data[tempIndexOfItem];// parent
					data[tempIndexOfItem] = data[childIndexOfItemRight];
					data[childIndexOfItemRight] = TempSwap;
					tempIndexOfItem = childIndexOfItemRight;
				} else if (data[childIndexOfItemRight] == null
						&& size > 2
						&& comp.compare(data[tempIndexOfItem],
								data[childIndexOfItemLeft]) > 0) {
					// bubble down with left child
					TempSwap = data[tempIndexOfItem];// parent
					data[tempIndexOfItem] = data[childIndexOfItemLeft];
					data[childIndexOfItemLeft] = TempSwap;
					tempIndexOfItem = childIndexOfItemLeft;
				}
				if (data[childIndexOfItemLeft] == null && size != 1) {
					if (data[childIndexOfItemRight] != null
							&& comp.compare(data[tempIndexOfItem],
									data[childIndexOfItemRight]) > 0) {
						// bubble down with right child
						TempSwap = data[tempIndexOfItem];// parent
						data[tempIndexOfItem] = data[childIndexOfItemRight];
						data[childIndexOfItemRight] = TempSwap;
						tempIndexOfItem = childIndexOfItemRight;
					}
				} else if (data[childIndexOfItemRight] == null && size != 1) {
					if (data[childIndexOfItemLeft] != null
							&& comp.compare(data[tempIndexOfItem],
									data[childIndexOfItemLeft]) > 0) {
						// bubble down with left child
						TempSwap = data[tempIndexOfItem];// parent
						data[tempIndexOfItem] = data[childIndexOfItemLeft];
						data[childIndexOfItemLeft] = TempSwap;
						tempIndexOfItem = childIndexOfItemLeft;
					}
				}
				childIndexOfItemLeft = 2 * tempIndexOfItem;
				childIndexOfItemRight = (2 * tempIndexOfItem) + 1;
			}
		} else {
			while (childIndexOfItemLeft <= size
					&& childIndexOfItemRight <= size) {
				if (data[childIndexOfItemLeft] != null
						&& data[childIndexOfItemRight] != null) {
					if (comp.compare(data[childIndexOfItemLeft],
							data[childIndexOfItemRight]) > 0) {
						// bubble down with right child
						data[tempIndexOfItem] = data[childIndexOfItemRight];
						data[childIndexOfItemRight] = null;
						tempIndexOfItem = childIndexOfItemRight;
					} else {
						// bubble down with left child
						data[tempIndexOfItem] = data[childIndexOfItemLeft];
						data[childIndexOfItemLeft] = null;
						tempIndexOfItem = childIndexOfItemLeft;
					}
				} else if (data[childIndexOfItemLeft] == null) {
					// bubble down with right child
					data[tempIndexOfItem] = data[childIndexOfItemRight];
					data[childIndexOfItemRight] = null;
					tempIndexOfItem = childIndexOfItemRight;
				} else if (data[childIndexOfItemRight] == null) {
					// bubble down with left child
					data[tempIndexOfItem] = data[childIndexOfItemLeft];
					data[childIndexOfItemLeft] = null;
					tempIndexOfItem = childIndexOfItemLeft;
				}
				childIndexOfItemLeft = 2 * tempIndexOfItem;
				childIndexOfItemRight = (2 * tempIndexOfItem) + 1;
			}
		}

		return root;
	}

	/**
	 * This method takes in the array to resize and creates a new array twice
	 * the size and assigns it to the current array.
	 * 
	 * @param data
	 *            The array to resize
	 */
	@SuppressWarnings("unchecked")
	private void resize(T[] data) {
		int newSize = 2 * data.length;
		T[] tempData = data;
		this.data = (T[]) new Object[newSize];
		// Copy the elements in the new resized object
		for (int i = 0; i < tempData.length; i++) {
			this.data[i] = tempData[i];
		}
	}

	@Override
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T peek() {
		// return the root/minimum element in this min heap
		if (this.isEmpty()) {
			return null;
		} else {
			return this.data[1];
		}
	}

	@Override
	public int size() {
		return size;
	}

	public String toString() {
		String result = "[";
		for (int i = 1; i <= this.size(); i++) {
			result += (data[i] + " ");
		}

		result = result + "]";
		return result;
	}

}