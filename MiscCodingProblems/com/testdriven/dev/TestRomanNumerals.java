package com.testdriven.dev;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void InputITest1() {
		assertEquals(1, romanConverterToNumber.romanToInteger("I"));
	}

	@Test
	public void InputIITest2() {
		assertEquals(2, romanConverterToNumber.romanToInteger("II"));
	}

	@Test
	public void InputIIITest3() {
		assertEquals(3, romanConverterToNumber.romanToInteger("III"));
	}
	
	@Test
	public void InputIVTest4() {
		assertEquals(4, romanConverterToNumber.romanToInteger("IV"));
	}

	@Test
	public void InputVTest5() {
		assertEquals(5, romanConverterToNumber.romanToInteger("V"));
	}
	
	@Test
	public void InputVITest6() {
		assertEquals(6, romanConverterToNumber.romanToInteger("VI"));
	}
	
	@Test
	public void InputVIITest7() {
		assertEquals(7, romanConverterToNumber.romanToInteger("VII"));
	}

	@Test
	public void InputVIIITest8() {
		assertEquals(8, romanConverterToNumber.romanToInteger("VIII"));
	}	
	
	@Test
	public void InputIXTest9() {
		assertEquals(9, romanConverterToNumber.romanToInteger("IX"));
	}	
	
	@Test
	public void InputXTest10() {
		assertEquals(10, romanConverterToNumber.romanToInteger("X"));
	}	
	
	@Test
	public void InputXIXTest19() {
		assertEquals(19, romanConverterToNumber.romanToInteger("XIX"));
	}	

	@Test
	public void InputXXTest20() {
		assertEquals(20, romanConverterToNumber.romanToInteger("XX"));
	}	
	
	@Test
	public void InputXXITest21() {
		assertEquals(21, romanConverterToNumber.romanToInteger("XXI"));
	}
	
	@Test
	public void InputXXVTest25() {
		assertEquals(25, romanConverterToNumber.romanToInteger("XXV"));
	}	
	
	@Test
	public void InputLTest50() {
		assertEquals(50, romanConverterToNumber.romanToInteger("L"));
	}	
	
	@Test
	public void InputXLIXTest49() {
		assertEquals(49, romanConverterToNumber.romanToInteger("XLIX"));
	}
	
	@Test
	public void InputXLTest40() {
		assertEquals(40, romanConverterToNumber.romanToInteger("XL"));
	}
	
	@Test
	public void InputXCTest90() {
		assertEquals(90, romanConverterToNumber.romanToInteger("XC"));
	}
	
	@Test
	public void InputCDXCTest490() {
		assertEquals(490, romanConverterToNumber.romanToInteger("CDXC"));
	}
	
	@Test
	public void InputMCMIVTest1904() {
		assertEquals(1904, romanConverterToNumber.romanToInteger("MCMIV"));
	}
	
	@Test
	public void InputMCMLIVTest1954() {
		assertEquals(1954, romanConverterToNumber.romanToInteger("MCMLIV"));
	}

	@Test
	public void InputMMVIIITest2008 () {
		assertEquals(2008 , romanConverterToNumber.romanToInteger("MMVIII"));
	}
	
//	@Test
//	public void InputInvalidCharTest () {
//		assertEquals(-1 , romanConverterToNumber.romanToInteger("MMVIHJII"));
//	}

}
