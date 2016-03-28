package com.coditlity.challenges;
class DoesEquilibriumIndexExist {

	public static void main(String args[]) {

		int A[] = { -1, 3, -4, 5, 1, -6, 2, 1 };

		System.out.println(isEquiIndex(A, 7));

		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		// int ind = 0;// denotes equilibrium index
		for (int i = 0; i < A.length; i++) {
			if (isEquiIndex(A, i))
				return i;
		}
		return -1;
	}

	public static boolean isEquiIndex(int[] A, int index) {
		int leftSum = 0, rightSum = 0;
		for (int i = 0; i < index; i++)
			leftSum += A[i];
		for (int i = index + 1; i < A.length; i++)
			rightSum += A[i];
		if (leftSum == rightSum)
			return true;
		else
			return false;
	}

	public static int isEquiFastIndex(int[] A) {
		int index;
		if (A.length % 2 == 0)
			index = A.length / 2;
		else
			index = (A.length + 1) / 2;
		int leftSum = 0, rightSum = 0;
		for(int j = 0; j < A.length; j++){
			for (int i = 0; i < index; i++)
				leftSum += A[i];
			for (int i = index + 1; i < A.length; i++)
				rightSum += A[i];
			if (leftSum == rightSum)
				return index;
			else if(leftSum < rightSum)
				index--;
		}
		return -1;
	}
}