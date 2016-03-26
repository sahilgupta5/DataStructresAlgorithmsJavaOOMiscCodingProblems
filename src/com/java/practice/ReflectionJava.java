package com.java.practice;

import java.lang.reflect.Method;

import com.datastructures.BinarySearchTreeFunctions;

public class ReflectionJava {

	public static void main(String args[]) {
		BinarySearchTreeFunctions<String> b = new BinarySearchTreeFunctions<String>();
		b.iterativeInsert(5, new String("S"));
		b.iterativeInsert(-5, new String("a"));
		b.iterativeInsert(30, new String("h"));
		b.iterativeInsert(-30, new String("i"));
		b.iterativeInsert(-1, new String("l"));
		b.iterativeInsert(20, new String("G"));
		b.iterativeInsert(70, new String("u"));
		b.iterativeInsert(-60, new String("p"));
		b.iterativeInsert(-20, new String("t"));
		b.iterativeInsert(-4, new String("a"));
		b.iterativeInsert(13, new String("Sahil Gupta"));

		System.out.println(b.iterativeFind(13));
		System.out.println("\n");

		b.recursiveInOrder(b.getRoot());
		System.out.println("\n");

		@SuppressWarnings("rawtypes")
		Class bst = b.getClass();
		System.out.println(bst.getClass().getName());
		for (Method m : bst.getClass().getMethods()) {
			System.out.println(m.getName());
		}

		System.out.println(bst.getClass().getDeclaredMethods());
		for (Method m : bst.getClass().getDeclaredMethods()) {
			System.out.println(m.getName());
		}
	}

}
