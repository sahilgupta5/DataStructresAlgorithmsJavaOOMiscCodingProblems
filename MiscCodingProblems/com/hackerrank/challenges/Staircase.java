package com.hackerrank.challenges;

import java.util.Scanner;

public class Staircase {
	static void StairCaseSolution1(int n) {
		if (n < 1 || n > 100) {
			return;
		}

		for (int i = 1; i <= n; i++) {
			StringBuilder s = new StringBuilder();
			int k = n - i;
			for (int j = 1; j <= n; j++) {
				if (j <= k) {
					s.append(' ');
				} else {
					s.append('#');
				}
			}
			if (i != n) {
				s.append("\n");
			}
			System.out.print(s.toString());
			s.delete(i - 1, n - 1);
		}
	}

	static void StairCaseSolution2(int n) {
		if (n < 1 || n > 100) {
			return;
		}

		StringBuilder fl = new StringBuilder();
		StringBuilder ll = new StringBuilder();
		for (int i = 0; i < n; i++) {
			fl.append(' ');
			ll.append("#");
		}
		String firstLine = fl.toString();
		String lastLine = ll.toString();

		for (int i = 0; i < n; i++) {
			String line;
			String pre = firstLine.substring(0, n - i - 1);
			String post = lastLine.substring(n - i - 1, n);

			line = pre + post;
			if (i == (n - 1)) {
				line = line + "\n";
			}
			System.out.println(line);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _n;
		_n = Integer.parseInt(in.nextLine().trim());

		long sol1StartTime = System.nanoTime();
		StairCaseSolution1(_n);
		System.out.println("\nElapsed Time:" + (System.nanoTime() - sol1StartTime));
		long sol2StartTime = System.nanoTime();
		StairCaseSolution2(_n);
		System.out.println("\nElapsed Time:" + (System.nanoTime() - sol2StartTime));
		in.close();
	}
}