package com.dailycodinginterview.arrays;

/**
 * <b>Problem Statement:</b> Write an algorithm that takes subsequent characters
 * and just emits how often they were seen. <br>
 * <br>
 * <b>Example Input:</b> abababaabbbaaaaa <br>
 * <b>Output:</b> a1b1a1b1a1b1a2b3a5<br>
 * <br>
 * <b>Solution Approach:</b><br>
 * 1. Traverse from start of the string and if any current char is same as next
 * char count it<br>
 * 2. If any char is not same as next char add current chat+count in result <br>
 * <br>
 * <b>Time Complexity</b><br>
 * Big O(N) where N is the length of the given String<br>
 * 
 * @author Shridutt.Kothari
 *
 */
public class Compression {

	public static void main(String[] args) {
		String input = "abababaabbbaaaaa";
		String output = compressSubSequentChars(input);
		System.out.println("input: " + input);
		System.out.println("output: " + output);
		System.out.println("--------------------------------------------");

		String input2 = "";
		String output2 = compressSubSequentChars(input2);
		System.out.println("input: " + input2);
		System.out.println("output: " + output2);
		System.out.println("--------------------------------------------");

		String input3 = "aaaa";
		String output3 = compressSubSequentChars(input3);
		System.out.println("input: " + input3);
		System.out.println("output: " + output3);
		System.out.println("--------------------------------------------");

		String input4 = null;
		String output4 = compressSubSequentChars(input4);
		System.out.println("input: " + input4);
		System.out.println("output: " + output4);
		System.out.println("--------------------------------------------");

		String input5 = "a";
		String output5 = compressSubSequentChars(input5);
		System.out.println("input: " + input5);
		System.out.println("output: " + output5);
		System.out.println("--------------------------------------------");

		String input6 = "213";
		String output6 = compressSubSequentChars(input6);
		System.out.println("input: " + input6);
		System.out.println("output: " + output6);
		System.out.println("--------------------------------------------");

	}

	private static String compressSubSequentChars(String input) {
		if (null == input || input.equals("")) {
			return input;
		}
		int inputLength = input.length();
		StringBuilder result = new StringBuilder();
		if (inputLength == 1) {
			return input + inputLength;
		}

		int repeatingCharCount = 1;
		for (int index = 1; index < inputLength; index++) {
			if (input.charAt(index) == input.charAt(index - 1)) {
				repeatingCharCount++;
				if (index == inputLength - 1) {
					result.append(input.charAt(index - 1));
					result.append(repeatingCharCount);
				}
			} else {
				result.append(input.charAt(index - 1));
				result.append(repeatingCharCount);

				repeatingCharCount = 1;
				if (index == inputLength - 1) {
					result.append(input.charAt(index));
					result.append(repeatingCharCount);
				}
			}
		}
		return result.toString();
	}
}
