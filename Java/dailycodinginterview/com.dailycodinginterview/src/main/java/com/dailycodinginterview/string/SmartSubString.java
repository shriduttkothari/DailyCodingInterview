package com.dailycodinginterview.string;

/**
 * <b>Problem Statement:</b> "Smart substring" </br>
 * </br>
 * Write a function that takes maximum 30 characters from a string but without
 * cutting the words.
 * 
 * </br>
 * </br>
 * Full description: "Featuring stylish rooms and moorings for recreation boats,
 * Room Mate Aitana is a designer hotel built in 2013 on an island in the IJ
 * River in Amsterdam." </br>
 * </br>
 * First 30 characters: "Featuring stylish rooms and mo" </br>
 * </br>
 * Smarter approach (max 30 characters, no words are broken): "Featuring stylish
 * rooms and"
 *
 * </br>
 * Solution Approach: 1. Check if string length is less than 30 or if string is
 * null, return the string</br>
 * 2. If 30th index in space return subString from 0 to 29 </br>
 * 3. Else traverse from right to left from 30th index till we find space, \n or
 * \t etc, and </br>
 * 4. If we find space return subString from 0 till currentIndex</br>
 * 5. Else return blank or may be the complete string.</br>
 * 
 * Time Complexity: Big O (n) where N = 30;
 * 
 * @author Shridutt.Kothari
 *
 */
public class SmartSubString {

	public static void main(String[] args) {

		String input = "Featuring stylish rooms and moorings for recreation boats, Room Mate Aitana is a designer hotel built in 2013 on an island in the IJ River in Amsterdam.";
		String output = getSmartString(input);
		System.out.println("Input String: " + input);
		System.out.println("Smart String: " + output);
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		String input1 = null;
		String output1 = getSmartString(input1);
		System.out.println("Input String: " + input1);
		System.out.println("Smart String: " + output1);
		System.out.println("--------------------------------------------------------------------------------------------------------");	
		
		String input2 = "ABC";
		String output2 = getSmartString(input2);
		System.out.println("Input String: " + input2);
		System.out.println("Smart String: " + output2);
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		
		String input3 = "";
		String output3 = getSmartString(input3);
		System.out.println("Input String: " + input3);
		System.out.println("Smart String: " + output3);
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		String input4 = "ABCCDEFGHIJKLMNOPQRSTUVWYZ1234567890"; //37 Chars
		String output4 = getSmartString(input4);
		System.out.println("Input String: " + input4);
		System.out.println("Smart String: " + output4);
		System.out.println("--------------------------------------------------------------------------------------------------------");

		String input5 = "ABCCDEFGHIJKLMNOPQRSTUVWYZ1234 567890"; //37 Chars
		String output5 = getSmartString(input5);
		System.out.println("Input String: " + input5);
		System.out.println("Smart String: " + output5);
		System.out.println("--------------------------------------------------------------------------------------------------------");

	}

	private static String getSmartString(String input) {
		if (null == input || input.length() < 30) {
			return input;
		}

		int indexToBreak = 0;
		for (int index = 30; index >= 0; index--) {
			indexToBreak = index;
			char currentChar = input.charAt(index);
			if (currentChar == ' ' || currentChar == '\n' || currentChar == '\t') {
				break;
			}
		}
		if(indexToBreak == 0) {
			return input.substring(0, indexToBreak);
		} else if(indexToBreak == 30) {
			return input.substring(0, indexToBreak);
		}
		return input.substring(0, indexToBreak + 1);
	}
}
