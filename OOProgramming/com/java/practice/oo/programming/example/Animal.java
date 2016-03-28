package com.java.practice.oo.programming.example;

public class Animal {

	private String scientificName;
	private String habitat;

	public Animal(String scientificName, String habitat) {
		this.scientificName = scientificName;
		this.habitat = habitat;
	}

	public Animal(String scientificName) {
		this.scientificName = scientificName;
		this.habitat = "Land";
	}

	// overriding the default toString method
	public String toString() {
		return "Scientific Name: " + this.scientificName + "\nHabitat: "
				+ this.habitat + "\n";
	}

	protected String getScientificName() {
		return scientificName;
	}

	protected void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

}
