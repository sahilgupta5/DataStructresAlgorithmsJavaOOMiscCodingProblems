package com.java.practice.oo.programming.example;

public class Mammal extends WarmBlooded {

	// Notice the private modifier for vairables.
	private int numLimbs;
	private boolean hasHair;

	public Mammal(String scientificName, String habitat, float backboneLength,
			boolean hasEggs, int normalBodyTemp, int numLimbs, boolean hasHair) {
		super(scientificName, habitat, backboneLength, hasEggs, normalBodyTemp);
		this.numLimbs = numLimbs;
		this.hasHair = hasHair;
	}

	// This constructor represents animals of species homo.
	public Mammal(String scientificName) {
		super(scientificName, 0.71f, false, 36);
		this.numLimbs = 4;
		this.hasHair = true;
	}

	public String toString() {
		return super.toString() + "Number of Limbs: " + getNumLimbs()
				+ "\nHas Hair: " + isHasHair() + "\n";
	}

	public int getNumLimbs() {
		return numLimbs;
	}

	public void setNumLimbs(int numLimbs) {
		this.numLimbs = numLimbs;
	}

	public boolean isHasHair() {
		return hasHair;
	}

	public void setHasHair(boolean hasHair) {
		this.hasHair = hasHair;
	}

}
