package com.java.practice;
import java.util.Random;

public class typesOperators {

	public static void main(String args[]) {

		System.out.println("How are you doing?");
		System.out.print("I am doing great. And you?\n");

		// primitives
		int answer = 42;
		// byte smallNumber1, smallNumber2;
		long countedStars = 86827263927L;
		float ratio = 0.2363F;
		double delta = 453.523311903;
		// Character
		char topGrade = 'A';
		// char symbol1, symbol2, symbol3;
		char terminator = ';', separator = ' ';
		// Booleans
		boolean flag = false;
		// boolean tooHigh, tooSmall, tooRough;
		boolean done = false;

		if (flag) {
			System.out.println(String.valueOf(answer) + separator
					+ String.valueOf(countedStars));
		} else if (done == false) {
			System.out.println(ratio + delta);
		} else {
			System.out.println(String.valueOf(ratio) + separator
					+ String.valueOf(delta) + separator + topGrade + separator
					+ terminator);
		}

		String helloWorld = new String("Hello World");
		System.out.println(helloWorld);

		String phrase = new String("Change is inevitable");
		String mutation1, mutation2, mutation3, mutation4;
		System.out.println("Original string: \"" + phrase + "\"");
		System.out.println("Length of string: " + phrase.length());
		mutation1 = phrase.concat(", except from vending machines.");
		mutation2 = mutation1.toUpperCase();
		mutation3 = mutation2.replace('E', 'X');
		mutation4 = mutation3.substring(3, 30);
		// Print each mutated string
		System.out.println("Mutation #1: " + mutation1);
		System.out.println("Mutation #2: " + mutation2);
		System.out.println("Mutation #3: " + mutation3);
		System.out.println("Mutation #4: " + mutation4);
		System.out.println("Mutated length: " + mutation4.length());

		Random generator = new Random();
		int num1;
		float num2;
		num1 = generator.nextInt();
		System.out.println("A random integer: " + num1);
		num1 = generator.nextInt(10);
		System.out.println("From 0 to 9: " + num1);
		num1 = generator.nextInt(10) + 1;
		System.out.println("From 1 to 10: " + num1);
		num1 = generator.nextInt(15) + 20;
		System.out.println("From 20 to 34: " + num1);
		num1 = generator.nextInt(20) - 10;
		System.out.println("From -10 to 9: " + num1);
		num2 = generator.nextFloat();
		System.out.println("A random float [between 0-1]: " + num2);
		num2 = generator.nextFloat() * 6; // 0.0 to 5.999999
		num1 = (int) num2 + 1;
		System.out.println("From 1 to 6: " + num1);

	}
}
