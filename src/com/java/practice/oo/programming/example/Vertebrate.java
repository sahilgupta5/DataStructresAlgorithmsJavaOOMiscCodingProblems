package com.java.practice.oo.programming.example;

public class Vertebrate extends Animal {

	private float backboneLength;// length in metres
	private boolean hasEggs;

	public Vertebrate(String scientificName, String habitat,
			float backboneLength, boolean hasEggs) {
		super(scientificName, habitat);
		this.backboneLength = backboneLength;
		this.hasEggs = hasEggs;
	}

	public Vertebrate(String scientificName, float backboneLength,
			boolean hasEggs) {
		// Notice that we call a different constructor for the parent
		super(scientificName);
		this.backboneLength = backboneLength;
		this.hasEggs = hasEggs;
	}

	public String toString() {
		return super.toString() + "Backbone Length (Meters): "
				+ getBackboneLength() + "\nHas Eggs: " + isHasEggs() + "\n";
	}

	public float getBackboneLength() {
		return backboneLength;
	}

	public void setBackboneLength(float backboneLength) {
		this.backboneLength = backboneLength;
	}

	public boolean isHasEggs() {
		return hasEggs;
	}

	public void setHasEggs(boolean hasEggs) {
		this.hasEggs = hasEggs;
	}

}
