package com.dailycodinginterview.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * <b>Problem Statements:</b><br>
 * Remove repeated values from a integer array, returning the resultant array in
 * the same order as original?<br>
 * <br>
 * 
 * <b>Solution Approach:</b><br>
 * 
 * Step 1: Iterate the given input<br>
 * Step 2: Insert each value in a LinkedHashMap<br>
 * Step 3: Elements which are successfully added in LinkedHaMap are unique so
 * return those as output<br>
 * <br>
 *
 * <b>Space Complexity:</b> <br>
 * Big O(N) where N is the length of given input<br>
 * <br>
 * <b>Time Complexity:</b> <br>
 * Big O(N) where N is the length of given input<br>
 *
 * @author Shridutt.Kothari
 *
 */
public class RemoveDuplicateFromArray {

	public static void main(String[] args) {
		List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 3, 5, 6, 7, 8, 1, 9, 10);

		List<Integer> outputListUsingLinkedHashSet = removeDuplicatesUsingLinkedHashSet(inputList);
		System.out.println("output Using Linked HashSet:" + outputListUsingLinkedHashSet);

		List<Integer> outputListUsingHashSet = removeDuplicatesUsingHashSet(inputList);
		System.out.println("output Using Simple HashSet:" + outputListUsingHashSet);
	}

	private static List<Integer> removeDuplicatesUsingHashSet(List<Integer> inputList) {
		ArrayList<Integer> output = new ArrayList<>();
		Set<Integer> uniqueValueInOrder = new HashSet<>();
		for (Integer value : inputList) {
			boolean isAdded = uniqueValueInOrder.add(value);
			if (isAdded) {
				output.add(value);
			}
		}
		return output;
	}

	private static List<Integer> removeDuplicatesUsingLinkedHashSet(List<Integer> inputList) {
		Set<Integer> uniqueValueInOrder = new LinkedHashSet<>();
		for (Integer value : inputList) {
			uniqueValueInOrder.add(value);
		}

		return Arrays.asList(uniqueValueInOrder.toArray(new Integer[uniqueValueInOrder.size()]));
	}
}
