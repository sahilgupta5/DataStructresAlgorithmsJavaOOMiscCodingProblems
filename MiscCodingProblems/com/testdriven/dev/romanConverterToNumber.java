package com.testdriven.dev;

public class romanConverterToNumber {
	
	static int romanToInteger(String string) {
		int count = 0;
		for(int i = 0; i <= string.length()-1; i++){
//			return -1 if the character is invalid currently not behaving correctly
//			behaving correctly for invalid chars.
//			if(string.charAt(i) != 'I' || 
//					string.charAt(i) != 'V' || 
//					string.charAt(i) != 'X' || 
//					string.charAt(i) != 'L' ||
//					string.charAt(i) != 'C' ||
//					string.charAt(i) != 'D' ||
//					string.charAt(i) != 'M'){
//				return -1;
//			}
			
			if(string.charAt(i) == 'M'){
				count += 1000;
				if(i > 0 && string.charAt(i-1) == 'C'){
					count -= 200;
				}
			}
			
			if(string.charAt(i) == 'D'){
				count += 500;
				if(i > 0 && string.charAt(i-1) == 'C'){
					count -= 200;
				}
			}
			
			if(string.charAt(i) == 'L'){
				count += 50;
				if(i > 0 && string.charAt(i-1) == 'X'){
					count -= 20;
				}
			}
			
			if(string.charAt(i) == 'C'){
				count += 100;
				if(i > 0 && string.charAt(i-1) == 'X'){
					count -= 20;
				}
			}
			
			if(string.charAt(i) == 'X'){
				count += 10;
				if(i > 0 && string.charAt(i-1) == 'I'){
					count -= 2;
				}
			}
			
			if(string.charAt(i) == 'V'){
				count += 5;
				if(i > 0 && string.charAt(i-1) == 'I'){
					count -= 2;
				}
			}

			if(string.charAt(i) == 'I'){
				count++;
			}
		}
		return count;
	}

}
