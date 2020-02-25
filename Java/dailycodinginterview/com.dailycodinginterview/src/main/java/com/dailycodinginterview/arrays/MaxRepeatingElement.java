package com.dailycodinginterview.arrays;

import java.util.HashMap;

/**
 * <b>Problem Statement:</b><br>
 * Given an array, find the most frequent element in it. If there are multiple
 * elements that appear maximum number of times, print any one of them. <br>
 * <br>
 * <b>Input:</b><br>
 * input[] = { 1, 2, 3, 5, 4, 4, 3, 1, 2, 4, 3, 8, 10, 9, 4, 4 }; <br>
 * <br>
 * <b>Output:</b><br>
 * 4 <br>
 * Max Repeating Element is: 4, as it appeared 5 times <br>
 * <br>
 * <b>Solution Approach:</b><br>
 * 1. Create a Map for keeping count of every element's repeated frequency<br>
 * 2. Iterate through input array<br>
 * 3. Check if that element is present in count Map, if present increment the
 * frequency<br>
 * 4. and if not present initialize it's frequency to 1 <br>
 * 5. While iterating also keep a integer to track the maximum frequency till
 * now and update it if any new max frequency is found,and store the element
 * corresponding to the max frequency as max repeating element <br>
 * 
 * <br>
 * <b>Time Complexity:</b><br>
 * Big O(N) where N is the number of elements in input array
 * 
 * @author Shridutt.Kothari
 *
 */
public class MaxRepeatingElement {

	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 5, 4, 4, 3, 1, 2, 4, 3, 8, 10, 9, 4, 4 };

		int maxRepeatingElement = findMaxRepeatingElement(input);
		System.out.println("Max Repeating Element is : " + maxRepeatingElement);
		System.out.println("-------------------------------------------------------");

		int maxRepeatingElement1 = findMaxRepeatingElement(null);
		System.out.println("Max Repeating Element is : " + maxRepeatingElement1);

	}

	private static int findMaxRepeatingElement(int[] input) {
		if (null == input || input.length == 0) {
			return -1;
		}
		HashMap<Integer, Integer> repeatingCount = new HashMap<>();
		int maxRepeatingElementCount = Integer.MIN_VALUE;
		int maxRepeatingElement = input[0];

		for (int element : input) {
			int count = 0;
			if (repeatingCount.keySet().contains(element)) {
				count = repeatingCount.get(element);
			}
			repeatingCount.put(element, ++count);
			if (count > maxRepeatingElementCount) {
				maxRepeatingElementCount = count;
				maxRepeatingElement = element;
			}
		}
		return maxRepeatingElement;
	}
}
