package com.java.practice.oo.zoo.example;

public class WarmBlooded extends Vertebrate {

	private int normalBodyTemp; // in Celsius

	public WarmBlooded(String scientificName, String habitat,
			float backboneLength, boolean hasEggs, int normalBodyTemp) {
		super(scientificName, habitat, backboneLength, hasEggs);
		this.normalBodyTemp = normalBodyTemp;
	}

	public WarmBlooded(String scientificName, float backboneLength,
			boolean hasEggs, int normalBodyTemp) {
		super(scientificName, backboneLength, hasEggs);
		this.normalBodyTemp = normalBodyTemp;
	}

	public String toString() {
		return super.toString() + "Normal Body Temp (Celcius): "
				+ getNormalBodyTemp() + "\n";
	}

	protected int getNormalBodyTemp() {
		return normalBodyTemp;
	}

	public void setNormalBodyTemp(int normalBodyTemp) {
		this.normalBodyTemp = normalBodyTemp;
	}

}
