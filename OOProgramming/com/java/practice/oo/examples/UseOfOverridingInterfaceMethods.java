package com.java.practice.oo.examples;

/**
 * Ref: https://docs.oracle.com/javase/tutorial/java/IandI/override.html As this
 * says: Interface Methods
 * 
 * Default methods and abstract methods in interfaces are inherited like
 * instance methods. However, when the supertypes of a class or interface
 * provide multiple default methods with the same signature, the Java compiler
 * follows inheritance rules to resolve the name conflict. These rules are
 * driven by the following two principles:
 * 
 * Instance methods are preferred over interface default methods.
 * 
 * @author sahil gupta
 */

public class UseOfOverridingInterfaceMethods {
	public static void main(String... args) {
		Dragon myApp = new Dragon();
		System.out.println(myApp.identifyMyself());
	}
}

interface Anim {
	default public String identifyMyself() {
		return "I am an animal.";
	}
}

interface EggLayer extends Anim {
	default public String identifyMyself() {
		return "I am able to lay eggs.";
	}
}

interface FireBreather extends Anim {
	/*
	 * If this method below is declared, compiler will complain: Duplicate
	 * default methods named identifyMyself with the parameters () and () are
	 * inherited from the types FireBreather and EggLayer
	 */
	// default public String identifyMyself() {
	// return "I am able to breath fire.";
	// }
}

class Dragon implements EggLayer, FireBreather {

}
