package com.java.practice.oo.examples;

/**
 * Concept of over-riding and hiding static methods.
 * Ref: https://docs.oracle.com/javase/tutorial/java/IandI/override.html
 * @author sahil gupta
 *
 */

public class Animal {

	public static void testClassMethod() {
		System.out.println("The static method in Animal");
	}

	public void testInstanceMethod() {
		System.out.println("The instance method in Animal");
	}

	public static void main(String[] args) {
		Cat myCat = new Cat();
		Animal myAnimal = myCat;
		Animal anim = new Animal();

		Animal.testClassMethod();
		myAnimal.testInstanceMethod();
		anim.testInstanceMethod();

		Cat.testClassMethod();
		myCat.testInstanceMethod();
	}
}

class Cat extends Animal {
	public static void testClassMethod() {
		System.out.println("The static method in Cat");
	}

	public void testInstanceMethod() {
		System.out.println("The instance method in Cat");
	}

}