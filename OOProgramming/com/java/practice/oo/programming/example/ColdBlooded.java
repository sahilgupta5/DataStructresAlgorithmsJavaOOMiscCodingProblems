package com.java.practice.oo.programming.example;

public class ColdBlooded extends Vertebrate {

	private int lowBodyTemp; // in Celsius
	private int highBodyTemp; // in Celsius

	public ColdBlooded(String scientificName, String habitat,
			float backboneLength, boolean hasEggs, int lowBodyTemp,
			int highBodyTemp) {
		super(scientificName, habitat, backboneLength, hasEggs);
		this.lowBodyTemp = lowBodyTemp;
		this.highBodyTemp = highBodyTemp;
	}

	public String toString() {
		return super.toString() + "Low Body Temp (Celcius): "
				+ getLowBodyTemp() + "\nHigh Body Temp (Celcius): "
				+ getHighBodyTemp() + "\n";
	}

	public int getLowBodyTemp() {
		return lowBodyTemp;
	}

	public void setLowBodyTemp(int lowBodyTemp) {
		this.lowBodyTemp = lowBodyTemp;
	}

	public int getHighBodyTemp() {
		return highBodyTemp;
	}

	public void setHighBodyTemp(int highBodyTemp) {
		this.highBodyTemp = highBodyTemp;
	}

}
