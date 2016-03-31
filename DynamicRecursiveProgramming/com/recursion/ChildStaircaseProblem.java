package com.recursion;

/**
 * A child is running up a staircase with n steps, can hop either 1 step, 2 step
 * or steps at a time. Implement a method to count how many possible ways the
 * child can run up the stairs.
 * 
 * @author sahilgupta
 *
 */

public class ChildStaircaseProblem {

	public int countWays(int steps) {
		if (steps < 1)
			return 0;
		if (steps == 1)
			return 1;
		if (steps == 2)
			return 2;
		if (steps == 3)
			// 1+1+1, (1+2, 2+1), 3
			return 4;
		return countWays(steps - 1) + countWays(steps - 2)
				+ countWays(steps - 3);
	}

	public static void main(String args[]) {
		ChildStaircaseProblem cs = new ChildStaircaseProblem();

		System.out.println(cs.countWays(5));
		System.out.println(cs.countWays(35));
		System.out.println(cs.countWays(36));
		System.out.println(cs.countWays(37));
	}

}
