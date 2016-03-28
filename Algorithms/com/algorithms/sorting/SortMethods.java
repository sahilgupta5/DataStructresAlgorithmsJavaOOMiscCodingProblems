package com.algorithms.sorting;

public class SortMethods {

	public int[] BubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public int[] InsertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

	public int[] SelectionSort(int[] arr) {

		return arr;
	}

	public int[] MergeSort(int[] arr) {
		int len = arr.length;
		int mid = len / 2;
		int[] arrLeft = new int[mid];
		int[] arrRight = new int[len - mid];
		for (int i = 0; i < mid; i++) {
			arrLeft[i] = arr[i];
		}
		for (int i = mid; i < len; i++) {
			arrRight[i - mid] = arr[i];
		}
		arrLeft = MergeSort(arrLeft);
		arrRight = MergeSort(arrRight);
		int[] result = Merge(arrLeft, arrRight);
		return result;
	}

	private int[] Merge(int[] arrLeft, int[] arrRight) {

		return null;
	}

	public int[] QuickSort(int arr[]) {

		return arr;
	}

	public int[] RadixSort(int arr[]) {

		return arr;
	}

	public int[] HeapSort(int arr[]) {

		return arr;
	}

}