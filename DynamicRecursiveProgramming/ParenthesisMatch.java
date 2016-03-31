/**
 * Implement an algorithm to print all valid (e.g. properly opened and closed)
 * combinations of n-pairs of parentheses. Example:
 * 
 * Input: 3 Output: ((())), (()()), (())(), ()(()), ()()()
 * 
 * @author sahil.gupta
 *
 */

public class ParenthesisMatch {

	public String parenthesisMatch(int n) {
		if (n < 0)
			return "";
		if (n == 1)
			return "()";
		//if ()

	}

	public static void main(String args[]) {
		int n1 = 1, n2 = 2, n3 = 3;
		String case1 = "()";
		String case2 = "()(), (())";
		String case3 = "((())), (()()), (())(), ()(()), ()()()";

	}

}
