package com.java.practice.oo.zoo.example;

public class Fish extends ColdBlooded {

	private boolean hasGills;
	private int numFins;

	public Fish(String scientificName, int backboneLength, boolean hasEggs,
			int lowBodyTemp, int highBodyTemp, int numFins) {
		// Notice that habitat is set to Water for fishes
		super(scientificName, "Water", backboneLength, hasEggs, lowBodyTemp,
				highBodyTemp);
		this.setHasGills(true);
		this.setNumFins(numFins);
	}

	public String toString() {
		return super.toString() + "Has Gills: " + isHasGills()
				+ "\nNumber of Fins: " + getNumFins() + "\n";
	}

	public boolean isHasGills() {
		return hasGills;
	}

	public void setHasGills(boolean hasGills) {
		this.hasGills = hasGills;
	}

	public int getNumFins() {
		return numFins;
	}

	public void setNumFins(int numFins) {
		this.numFins = numFins;
	}

}
