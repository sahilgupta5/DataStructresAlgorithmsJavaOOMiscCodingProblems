package com.coditlity.challenges;
public class BinaryGap {

	public static void main(String args[]) {
		binaryGap(5);
	}

	public static int binaryGap(int N) {
		Integer i = new Integer(N);
		if (N > Integer.MAX_VALUE || N <= 0) {
			return 0;
		}

		String str = Integer.toBinaryString(i);
		char[] chrArr = str.toCharArray();

		// int maxBinGap = 0;
		// int nextMaxBinGap = 0;
		// int indexOneFirst = 0;
		// int indexOneLast = 0;

		for (int j = 0; j < chrArr.length; j++) {
			// if (indexOneFirst < indexOneLast) {
			// if (chrArr[j] == '1') {
			// indexOneFirst = j;
			// }
			// }
			if (chrArr[i] == '1') {
				
			}
		}

		System.out.println(str);
		return N;
	}
}
