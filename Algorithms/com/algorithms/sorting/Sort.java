package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Sort {

	/**
	 * Implement bubble sort.
	 * 
	 * It should be:
	 *  inplace
	 *  stable
	 *  
	 * Have a worst case running time of:
	 *  O(n^2)
	 *  
	 * And a best case running time of:
	 *  O(n)
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<T>> void bubblesort(T[] arr) {
		/*
		 * Pseudo Code:
		 * for 1 to n elements of array
		 * 	for i = 0 to n-1 elements of array
		 * 		if(array[i+1] < array[i])
		 * 			swap(array[i], array[i+1]);
		 */
		int arrLength = arr.length;
		T Temp;
		for(int i = 1; i < arrLength; i++){
			for(int j = 0; j < arrLength - 1; j++){
				if(strictlyLess(arr[j+1], arr[j])){
						Temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = Temp;
				}
			}
		}
	}
	
	/**
	 * Implement insertion sort.
	 * 
	 * It should be:
	 *  inplace
	 *  stable
	 *  
	 * Have a worst case running time of:
	 *  O(n^2)
	 *  
	 * And a best case running time of:
	 *  O(n)
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<T>> void insertionsort(T[] arr) {
		/*
		 * Pseudo Code
		 * for i = 1 to n elements of array
		 * 	valueToInsert = array[i];
		 * 	for (j = i; (j > 0 && valToinsert < array[j - 1]); j--)
		 * 		array[j] = array[j - 1]; 
		 * 	array[j] = valueToInsert;
		 */
		T valToInsert;
		int holePosition;
		for(int i = 1; i < arr.length; i++){
			valToInsert = arr[i];
			for(holePosition = i; (holePosition > 0 && strictlyLess(valToInsert, arr[holePosition - 1])); holePosition--){
				arr[holePosition] = arr[holePosition - 1];
			}
			arr[holePosition] = valToInsert;
		}
	}
	
	/**
	 * Implement quick sort.
	 * 
	 * Use the provided random object to select your pivots. For example if you
	 * need a pivot between a (inclusive) and b (exclusive) where b > a, use the
	 * following code:
	 * 
	 * int pivotIndex = r.nextInt(b - a) + a;
	 * 
	 * It should be: inplace
	 * 
	 * Have a worst case running time of: O(n^2)
	 * 
	 * And a best case running time of: O(n log n)
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<T>> void quicksort(T[] arr, Random r) {
		quickSortRecursive(arr, 0, arr.length - 1, r);
	}

	public static <T> void quickSortRecursive(T arr[], int leftIndex, int rightIndex,
			Random r) {
		int middleIndex = quickpartition(arr, leftIndex, rightIndex);
		if(leftIndex < middleIndex - 1){
			quickSortRecursive(arr, leftIndex, middleIndex - 1, r);
		}
		if(middleIndex < rightIndex){
			quickSortRecursive(arr, middleIndex, rightIndex, r);
		}
	}

	private static <T> int quickpartition(T arr[], int leftIndex, int rightIndex) {
		int i = leftIndex;
		int j = rightIndex; // I pointer to first && J pointer to last
		Random r = new Random();
		int pivotIndex = r.nextInt((rightIndex - leftIndex) + leftIndex); // random pivot index
		int pivot = (Integer) arr[pivotIndex];
		T temporary;
		while(i <= j){
			while((Integer) arr[i] < pivot){
				i++;
			}
			while((Integer) arr[j] > pivot){
				j--;
			}
			if(i <= j){
				temporary = (T) arr[i];
				arr[i++] = arr[j];
				arr[j--] = (T) temporary;
			}
		}
		return i;
	}
	
	/**
	 * Implement merge sort.
	 * 
	 * It should be:
	 *  stable
	 *  
	 * Have a worst case running time of:
	 *  O(n log n)
	 *  
	 * And a best case running time of:
	 *  O(n log n)
	 *  
	 * @param arr
	 * @return
	 */
	public static <T extends Comparable<T>> T[] mergesort(T[] arr) {
		/*
		 * Pseudo Code:
		 * mergeSort(Array[] array){
		 *	if(array.length < 2)
		 * 		return array;
		 * 	Array[] leftArray, rightArray;
		 * 	Integer middle = array.length / 2;
		 * 	Integer i, j;
		 * 	for(i = 0; i < middle; i++)
		 * 		add to the leftArray
		 * 	for(j = middle; j < array.length; j++)
		 * 		add to the rightArray
		 * 	//Recursively split to get left and right array
		 * 	leftArray = mergeSort(leftArray);
		 * 	rightArray = mergeSort(rightArray);
		 * 	return mergeArrays(leftArray, rightArray);
		 * }
		 * mergeArrays(leftArray, rightArray){
		 * 	Array[] sortedResult;
		 * 	Integer leftIndex, rightIndex, sortedResultIndex to 0;
		 * 	while(leftIndex < leftArray.length || rightIndex < rightArray.length){
		 * 		if(leftIndex < leftArray.length && rightIndex < rightArray.length){
		 * 			if(leftIndex < leftArray.length){
		 * 				sortedResult[sortedResultIndex] = leftArray[leftIndex];
		 * 				sortedResultIndex++;
		 * 				leftIndex++;
		 * 			}else{
		 * 		 		sortedResult[sortedResultIndex] = rightArray[rightIndex];
		 * 				sortedResultIndex++;
		 * 				rightIndex++;
		 * 			}
		 * 		}else if(leftIndex < leftArray.length){
		 * 				sortedResult[sortedResultIndex] = leftArray[leftIndex];
		 * 				sortedResultIndex++;
		 * 				leftIndex++;
		 * 		}else if(rightIndex < rightArray.length){
		 * 				sortedResult[sortedResultIndex] = rightArray[rightIndex];
		 * 				sortedResultIndex++;
		 * 				rightIndex++;
		 * 		}
		 * 	}
		 * }
		 */
		// conversion from array into array list because java
		// does not allow creation of generic arrays at run time

		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[arr.length];
		mergeSortBreak(arr, result, 0, arr.length - 1);
		return result;
	}

	public static <T extends Comparable<T>> void mergeSortBreak(T[] arr, T[] result, int low, int high) {
			if (low < high) {
				int middle = (low + high) / 2;
				mergeSortBreak(arr, result, low, middle);
				mergeSortBreak(arr, result, middle + 1, high);
				mergeSortCombineSort(arr, result, low, middle + 1, high);
		}
	}

	public static <T extends Comparable<T>> void mergeSortCombineSort(T[] arr,
			T[] result, int leftIndex, int rightIndex, int rightIndexAtEnd) {
		int leftIndexAtEnd = rightIndex - 1;
		int temporaryIndex = leftIndex;
		int numElements = rightIndexAtEnd - leftIndex + 1;

		while (leftIndex <= leftIndexAtEnd || rightIndex <= rightIndexAtEnd) {
			if (leftIndex <= leftIndexAtEnd && rightIndex <= rightIndexAtEnd)
				if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0) {
					result[temporaryIndex] = arr[leftIndex];
					temporaryIndex++;
					leftIndex++;
				} else {
					result[temporaryIndex] = arr[rightIndex];
					temporaryIndex++;
					rightIndex++;
				}
			else if (leftIndex <= leftIndexAtEnd){
				result[temporaryIndex] = arr[leftIndex];
				temporaryIndex++;
				leftIndex++;
			} else if (rightIndex <= rightIndexAtEnd){
				result[temporaryIndex] = arr[rightIndex];
				temporaryIndex++;
				rightIndex++;
			}
		}
		for (int i = 0; i < numElements; i++, rightIndexAtEnd--)
			arr[rightIndexAtEnd] = result[rightIndexAtEnd];
	}

	/**
	 * Implement radix sort
	 * 
	 * Hint: You can use Integer.toString to get a string
	 * of the digits. Don't forget to account for negative
	 * integers, they will have a '-' at the front of the
	 * string.
	 * 
	 * It should be:
	 *  stable
	 *  
	 * Have a worst case running time of:
	 *  O(kn)
	 *  
	 * And a best case running time of:
	 *  O(kn)
	 * 
	 * @param arr
	 * @return
	 */
	
	public static int[] radixsort(int[] arr) {
		ArrayList<Integer> positiveZeroList = new ArrayList<Integer>();
		ArrayList<Integer> negativeList = new ArrayList<Integer>();
		ArrayList<Integer> positiveSorted = null, negativeSorted = null;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] >= 0){
				positiveZeroList.add(arr[i]);
			}else{
				negativeList.add(-1 * arr[i]);
			}
		}
		if(positiveZeroList.size() != 0){
			positiveSorted = radixSortArray(positiveZeroList);
		}
		if(negativeList.size() != 0){
			negativeSorted = radixSortArray(negativeList);
		}
		int j, k;
		System.out.println("Size of N:" + negativeSorted.size());
		System.out.println("Size of arr:" + arr.length);
		System.out.println("Size of P:" + positiveSorted.size());
		for(j = 0; j < negativeSorted.size(); j++){
			arr[j] = -1 * negativeSorted.get(negativeSorted.size() - j - 1);
		}
		for(k = 0; k < positiveSorted.size(); k++){
			arr[j + k] = positiveSorted.get(k);
		}
		return arr;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> radixSortArray(ArrayList<Integer> arrList) {
		final int MAXINTEGERLENGTH = 10;
		int maximum = Collections.max(arrList);
		int bucketIndex;
		int tempIndexModHelper;
		@SuppressWarnings("rawtypes")
		ArrayList[] buckets = new ArrayList[MAXINTEGERLENGTH];
		for(int j = 0; j < MAXINTEGERLENGTH; j++){
			buckets[j] = new ArrayList<Integer>();
		}
		String tempStr;
		//Run the loop for each digits place and since integer can be maximum
		//10 digits in java.
		for(int i = 0; i < MAXINTEGERLENGTH; i++){
			for(int j = 0; j < arrList.size(); j++){
				tempStr = new Integer(arrList.get(j)).toString();
				int tempLen = tempStr.length();
				for(int l = 0; l < (MAXINTEGERLENGTH - tempLen); l++){
					tempStr = '0' + tempStr;
				}
				tempIndexModHelper = Character.getNumericValue(tempStr.charAt(tempStr.length() - i - 1));
				bucketIndex = tempIndexModHelper % 10;
				buckets[bucketIndex].add(arrList.get(j));
			}
			arrList.clear();
			for(int k = 0; k < MAXINTEGERLENGTH; k++){
				if(buckets[k] != null){
					for (Iterator<Integer> itr = buckets[k].iterator(); itr.hasNext();) {
						arrList.add(itr.next());
					}
				}
			}
			for(int j = 0; j < MAXINTEGERLENGTH; j++){
				buckets[j] = new ArrayList<Integer>();
			}
			if(i == (new Integer(maximum).toString().length())){
				break;
			}
		}
		return arrList;
	
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
}
