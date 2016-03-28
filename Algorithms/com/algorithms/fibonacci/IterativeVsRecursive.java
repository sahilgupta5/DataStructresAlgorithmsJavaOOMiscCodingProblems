package com.algorithms.fibonacci;

public class IterativeVsRecursive implements Runnable {

	public static long RecursiveFibNthElement(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}

		if (n == 1) {// 1st element is zero
			return 0;
		} else if (n == 2) {// 2nd element is zero and so on
			return 1;
		} else {
			return RecursiveFibNthElement(n - 1)
					+ RecursiveFibNthElement(n - 2);
		}
	}

	public static long IterativeFibNthElement(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}

		long[] arr = new long[n];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
		}

		return arr[n - 1];
	}

	@Override
	// Implement Recursive fibonacci in a multithreaded approach.
	public void run() {
	}

	public static void main(String[] args) {
		long currTimeRecursive = System.nanoTime();
		System.out.println("Recursive: " + RecursiveFibNthElement(40));
		System.out.println("Recursive Time: "
				+ (System.nanoTime() - currTimeRecursive));

		long currTimeIterative = System.nanoTime();
		System.out.println("Iterative: " + IterativeFibNthElement(40));
		System.out.println("Iterative Time: "
				+ (System.nanoTime() - currTimeIterative));
	}

}
