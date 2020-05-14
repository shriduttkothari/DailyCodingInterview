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

		int index = 0;
		Iterator<String> keyIterator = startCharMap.keySet().iterator();
		while (keyIterator.hasNext()) {
			String currentKey = keyIterator.next();
			if (!endCharMap.keySet().contains(currentKey)) {
				output[index++] = startCharMap.get(currentKey);
			}
		}
		Set<String> keySet = startCharMap.keySet();
		Iterator<String> keyIterator2 = keySet.iterator();
		while (keyIterator2.hasNext()) {
			String lastWord = output[index - 1];
			char charForNewWord = lastWord.charAt(lastWord.length() - 1);
			if (keySet.contains(Character.toString(charForNewWord).toUpperCase())) {
				output[index++] = startCharMap.get(Character.toString(charForNewWord).toUpperCase());
			}
			keyIterator2.next();
		}
		return output;
	}
}
