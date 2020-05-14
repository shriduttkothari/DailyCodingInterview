package com.dailycodinginterview.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * <b>Problem Statement: </b><br>
 * Given a list/array of names(String) sort them such that each name is followed
 * by a name which starts with the last character of the previous name. <br>
 * <br>
 * 
 * <b># Input: </b><br>
 * [ Luis, Hector, Selena, Emmanuel, Amish ]<br>
 * <br>
 * 
 * <b># Output: </b><br>
 * [ Emmanuel, Luis, Selena, Amish, Hector ]<br>
 * 
 * <b>Solution: </b><br>
 * 
 * Step 1: Iterate through the given input Strings <br>
 * Step 2: Build two Maps with start Char, end Char as key String respectively
 * with value as actual String<br>
 * Step 3: Find first word for output whose first character is not present in
 * keyset of endCharMap<br>
 * Step 4: Set first word in output array<br>
 * Step 5: Loop through any map and find next word starting with the end
 * character from last word from output array<br>
 * <br>
 * 
 * <b>Space Complexity:</b> <br>
 * Big O(3N) i.e. Big O (N) where N is the number of words<br>
 * As we need three additional data structure i.e. map1, map2, output array<br>
 * <br>
 * 
 * <b>Time Complexity:</b> <br>
 * Big O(3N) i.e. Big O (N) where N is the number of words<br>
 * As we are iterating 3 times over all the elements, and lookup in Set, Map is
 * Big O(1)<br>
 * 
 * @author Shridutt.Kothari
 *
 */
public class LinkedStringLikeAntakshari {

	public static void main(String[] args) {

		String[] input = new String[] { "Luis", "Hector", "Selena", "Emmanuel", "Amish" };

		String[] output = buildLinkedStringLikeAntakshari(input);

		System.out.println("Input: " + Arrays.toString(input));
		System.out.println("Output: " + Arrays.toString(output));
	}

	private static String[] buildLinkedStringLikeAntakshari(String[] input) {
		String[] output = new String[input.length];
		HashMap<String, String> startCharMap = new HashMap<>();
		HashMap<String, String> endCharMap = new HashMap<>();

		for (String eachString : input) {
			startCharMap.put(Character.toString(eachString.charAt(0)).toUpperCase(), eachString);
			endCharMap.put(Character.toString(eachString.charAt(eachString.length() - 1)).toUpperCase(), eachString);
		}

		Set<String> startCharKeySet = startCharMap.keySet();
		Iterator<String> startCharKeyIterator = startCharKeySet.iterator();
		while (startCharKeyIterator.hasNext()) {
			String currentStartCharKey = startCharKeyIterator.next();
			if (!endCharMap.keySet().contains(currentStartCharKey)) {
				output[0] = startCharMap.get(currentStartCharKey);
				break;
			}
		}

		for (int index = 1; index < output.length; index++) {
			String lastWord = output[index - 1];
			char startCharForNewWord = lastWord.charAt(lastWord.length() - 1);
			if (startCharKeySet.contains(Character.toString(startCharForNewWord).toUpperCase())) {
				output[index] = startCharMap.get(Character.toString(startCharForNewWord).toUpperCase());
			}
		}
		return output;
	}
}
