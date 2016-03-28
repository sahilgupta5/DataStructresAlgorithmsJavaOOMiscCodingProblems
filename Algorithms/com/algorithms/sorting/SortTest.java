package com.algorithms.sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class SortTest {
	
	Random rand = new Random();
	final int NUMBEROFINPUTS = 100;
	
	@Test//(timeout = 10)
	public void testBubbleSort() {
		Integer arrayInteger[] = new Integer[NUMBEROFINPUTS];
		int sortedArrayInteger[] = new int[NUMBEROFINPUTS];
		int arrSorted[] = new int[NUMBEROFINPUTS];
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrayInteger[i] = rand.nextInt();
		}
		//create a deep copy of the test array and then sort it
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			sortedArrayInteger[i] = arrayInteger[i];
		}
		Sort.bubblesort(arrayInteger);
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrSorted[i] = arrayInteger[i];
		}
		Arrays.sort(sortedArrayInteger);
		System.out.println("The array is: " + Arrays.toString(arrayInteger));
		System.out.println("The array is: " + Arrays.toString(sortedArrayInteger));
		assertArrayEquals(arrSorted, sortedArrayInteger);
	}
	
	@Test//(timeout = 5)
	public void testInsertionSort() {
		Integer arrayInteger[] = new Integer[NUMBEROFINPUTS];
		int sortedArrayInteger[] = new int[NUMBEROFINPUTS];
		int arrSorted[] = new int[NUMBEROFINPUTS];
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrayInteger[i] = rand.nextInt();
		}
		//create a deep copy of the test array and then sort it
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			sortedArrayInteger[i] = arrayInteger[i];
		}
		Sort.insertionsort(arrayInteger);
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrSorted[i] = arrayInteger[i];
		}
		Arrays.sort(sortedArrayInteger);
		System.out.println("The array is: " + Arrays.toString(arrayInteger));
		System.out.println("The array is: " + Arrays.toString(sortedArrayInteger));
		assertArrayEquals(arrSorted, sortedArrayInteger);
	}
	
	@Test//(timeout = 10)
	public void testQuickSort() {
		Integer arrayInteger[] = new Integer[NUMBEROFINPUTS];
		int sortedArrayInteger[] = new int[NUMBEROFINPUTS];
		int arrSorted[] = new int[NUMBEROFINPUTS];
		Random rand = new Random();
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrayInteger[i] = rand.nextInt();
		}
		//create a deep copy of the test array and then sort it
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			sortedArrayInteger[i] = arrayInteger[i];
		}
		Sort.quicksort(arrayInteger, rand);
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrSorted[i] = arrayInteger[i];
		}
		System.out.println("The initial array is: " + Arrays.toString(sortedArrayInteger));
		Arrays.sort(sortedArrayInteger);
		System.out.println("The array is: " + Arrays.toString(arrayInteger));
		System.out.println("The array is: " + Arrays.toString(sortedArrayInteger));
		assertArrayEquals(arrSorted, sortedArrayInteger);
	}
	
	@Test//(timeout = 2)
	public void testMergeSort() {
		Integer arrayInteger[] = new Integer[NUMBEROFINPUTS];
		int sortedArrayInteger[] = new int[NUMBEROFINPUTS];
		int arrSorted[] = new int[NUMBEROFINPUTS];
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrayInteger[i] = rand.nextInt();
		}
		//create a deep copy of the test array and then sort it
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			sortedArrayInteger[i] = arrayInteger[i];
		}
		Sort.mergesort(arrayInteger);
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrSorted[i] = arrayInteger[i];
		}
		System.out.println("The initial array is: " + Arrays.toString(sortedArrayInteger));
		Arrays.sort(sortedArrayInteger);
		System.out.println("The array is: " + Arrays.toString(arrayInteger));
		System.out.println("The array is: " + Arrays.toString(sortedArrayInteger));
		assertArrayEquals(arrSorted, sortedArrayInteger);
	}
	
	@Test//(timeout = 2)
	public void testMergeSort1() {
		Integer mergeSortArray[] = {-5, -10, 30, 5, 2, 25, -1, 0};
		Integer SortedArray[] = {-5, -10, 30, 5, 2, 25, -1, 0};
		Sort.mergesort(mergeSortArray);
		Arrays.sort(SortedArray);
		System.out.println("The array is: " + Arrays.toString(SortedArray));
		System.out.println("The array is: " + Arrays.toString(mergeSortArray));
		assertArrayEquals(SortedArray, mergeSortArray);
	}
	
	@Test//(timeout = 2)
	public void testRadixSort() {
		int arrayInteger[] = new int[NUMBEROFINPUTS];
		int sortedArrayInteger[] = new int[NUMBEROFINPUTS];
		int arrSorted[] = new int[NUMBEROFINPUTS];
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrayInteger[i] = rand.nextInt();
		}
		//create a deep copy of the test array and then sort it
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			sortedArrayInteger[i] = arrayInteger[i];
		}
		Sort.radixsort(arrayInteger);
		for(int i = 0; i < NUMBEROFINPUTS; i++){
			arrSorted[i] = arrayInteger[i];
		}
		Arrays.sort(sortedArrayInteger);
		System.out.println("The array is: " + Arrays.toString(arrayInteger));
		System.out.println("The array is: " + Arrays.toString(sortedArrayInteger));
		assertArrayEquals(arrSorted, sortedArrayInteger);
	}
	
}
