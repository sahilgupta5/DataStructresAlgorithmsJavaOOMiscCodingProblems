package com.java.practice.oo.programming.example;


public class Zoo {

	public static void main(String args[]) {

		Animal gorilla = new Animal("Gorilla");
		Vertebrate dog = new Vertebrate("Canis lupus familiaris", 0.5f, false);
		System.out.println(gorilla.toString());
		System.out.println(dog.toString());

		// Quiz/Test Code
		WarmBlooded Dolphin = new WarmBlooded("Delphinidae", "Water", 2f,
				false, 37);
		System.out.println(Dolphin.toString());

		Mammal homoSapien = new Mammal("Homo Sapien");
		Mammal horse = new Mammal("Equus caballus", "Land", 2.7f, false, 37, 4,
				true);
		Fish shark = new Fish("Selachimorpha", 8, true, 4, 35, 2);
		System.out.println(homoSapien.toString());
		System.out.println(horse.toString());
		System.out.println(shark.toString());

	}
}
