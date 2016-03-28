package com.algorithms.sorting;
import java.util.Arrays;

public class Sorting {

	private int A[];
	private int tempArr[];

	public void bubbleSort(int[] inA) {
		this.A = inA;

		int l = inA.length;
		int k = 0;
		for (int i = l; i > 0; i--) {
			for (int j = 0; j < l - 1; j++) {
				k++;
				if (inA[k] < inA[j]) {
					swap(j, k, inA);
				}
			}
			k = 0;
		}
	}

	public void selectionSort(int[] inA) {
		this.A = inA;
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (inA[i] > inA[j]) {
					swap(i, j, A);
				}
			}
		}
	}

	public void insertionSort(int[] inA) {

	}

	public void quickSort(int[] inA) {
		this.A = inA;
		quickSortingAndPartitioning(0, A.length - 1);
	}

	public void quickSortingAndPartitioning(int lowIndex, int highIndex) {
		int i = lowIndex, j = highIndex;
		int pivot = A[lowIndex + (highIndex - lowIndex) / 2];
		// System.out.println("Pivot is: " + pivot);

		while (i <= j) {
			while (A[i] < pivot) {
				i++;
			}
			while (A[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j, A);
				i++;
				j--;
			}
		}

		if (lowIndex < j)
			quickSortingAndPartitioning(lowIndex, j);
		if (i < highIndex)
			quickSortingAndPartitioning(i, highIndex);
	}

	public void mergeSort(int[] inA) {
		this.A = inA;

		this.tempArr = new int[A.length];
		mergeSortSplit(0, A.length - 1);
	}

	public void mergeSortSplit(int lowIndex, int highIndex) {
		int middleIndex;
		// System.out.println(lowIndex + " " + highIndex);
		if (lowIndex < highIndex) {
			middleIndex = lowIndex + (highIndex - lowIndex) / 2;
			mergeSortSplit(lowIndex, middleIndex);
			mergeSortSplit(middleIndex + 1, highIndex);
			merge(lowIndex, middleIndex, highIndex);
			// System.out.println(lowIndex + " " + middleIndex + " " +
			// highIndex);
		}
	}

	// this function helps in merging two smaller arrays into larger ones which
	// are sorted
	public void merge(int lowIndex, int middleIndex, int highIndex) {
		// first make a copy of the original array to the helper/working array
		// this gives the ability to organize the source array by over-writing
		// it in a sorted order.
		for (int i = lowIndex; i <= highIndex; i++) {
			tempArr[i] = A[i];
		}
		int i, j, k;
		i = lowIndex;
		j = middleIndex + 1;
		k = lowIndex;

		// make comparisons of the left side array with the right side array to
		// store only the smaller first in the original array.
		while (i <= middleIndex && j <= highIndex) {
			// if the left array value is smaller, store it in original else
			// store right array value in original.
			if (tempArr[i] < tempArr[j]) {
				A[k] = tempArr[i];
				i++;
			} else {
				A[k] = tempArr[j];
				j++;
			}
			k++;
		}

		// since there is a possibility that only right side array may have only
		// been copied over, complete the copy of the left side of the array
		// you comment this piece out and see the difference it makes :)
		while (i <= middleIndex) {
			A[k] = tempArr[i];
			i++;
			k++;
		}
	}

	public static void swap(int i, int j, int[] A) {
		// System.out.println("Swapping " + A[i] + " with " + A[j]);
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}

	public static void main(String args[]) {
		Sorting s = new Sorting();

		int[] arr = { 28, 22, 12, -71, -28, 26, 2, -44, -20, 89, 17, 40, -5,
				-25, 37, -67, 30, -84, 75, -21 };
		int[] arrUse = { 28, 22, 12, -71, -28, 26, 2, -44, -20, 89, 17, 40, -5,
				-25, 37, -67, 30, -84, 75, -21 };
		s.bubbleSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		Arrays.sort(arrUse);
		System.out.print("\nAre they equal? " + Arrays.equals(arr, arrUse)
				+ "\n");
		System.out.print("\n");

		int[] arr1 = { 1, 7, 4, 3, 7, -10, 10, 3, 89, 12, 100, -35, 63, -51 };
		int[] arr1Use = { 1, 7, 4, 3, 7, -10, 10, 3, 89, 12, 100, -35, 63, -51 };
		s.mergeSort(arr1);
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		Arrays.sort(arr1Use);
		System.out.print("\nAre they equal? " + Arrays.equals(arr1, arr1Use)
				+ "\n");
		System.out.print("\n");

		int[] arr2 = { 1, 7, 4, 3, 7, -71, -28, 26, 2, -44, -20, 89, 17, 40,
				-5, -35, 63, -51 };
		int[] arr2Use = { 1, 7, 4, 3, 7, -71, -28, 26, 2, -44, -20, 89, 17, 40,
				-5, -35, 63, -51 };
		s.quickSort(arr2);
		for (int i : arr2) {
			System.out.print(i + " ");
		}
		Arrays.sort(arr2Use);
		System.out.print("\nAre they equal? " + Arrays.equals(arr2, arr2Use)
				+ "\n");
		System.out.print("\n");

		int[] arr3 = { 78, 21, -4, -71, 31, 54, -10, 65, -19, 89, 17, 40, -5 };
		int[] arr3Use = { 78, 21, -4, -71, 31, 54, -10, 65, -19, 89, 17, 40, -5 };
		s.selectionSort(arr3);
		for (int i : arr3) {
			System.out.print(i + " ");
		}
		Arrays.sort(arr3Use);
		System.out.print("\nAre they equal? " + Arrays.equals(arr, arr3Use)
				+ "\n");
		for (int i : arr3Use) {
			System.out.print(i + " ");
		}
		System.out.print("\n");

	}
}
