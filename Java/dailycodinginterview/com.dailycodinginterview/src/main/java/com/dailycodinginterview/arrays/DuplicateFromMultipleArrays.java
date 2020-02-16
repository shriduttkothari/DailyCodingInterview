package com.dailycodinginterview.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Booking.com Interview Question for Android Engineers</br>
 * </br>
 * <b>Problem Statement:</b> </br>
 * </br>
 * You have three Arrays.</br>
 * A = {2, 5, 3, 2, 8, 1} </br>
 * B = {7, 9, 5, 2, 4, 10, 10}</br>
 * C = {6, 7, 5, 5, 3, 7}</br>
 * </br>
 * Make an array from this three arrays which elements is present in at least
 * two array. </br>
 * </br>
 * This question was followed by instead of three arrays. </br>
 * If you have a list of array then what will be the solution?</br>
 * Also what will be the time complexity?</br>
 * </br>
 * <b>Solution Approach: </b></br>
 * 1. Step remove duplicates from each array </br>
 * 2. Merge all three arrays into single array </br>
 * 3. find values more than once
 * 
 * </br>
 * </br>
 * 
 * <b>Problem Statement: (Similar)</b> </br>
 * Given arrays for N (>= 2) users, each representing the IDs of hotels visited,
 * find the common IDs of the hotels visited amongst the users. </br>
 * </br>
 * Input:</br>
 * userA = { 2, 3, 1 } </br>
 * userB = { 2, 5, 3 } </br>
 * userC = { 7, 3, 1 } </br>
 * </br>
 * Output: {3} </br>
 * </br>
 * 
 * <b>Problem Statement: (Similar)</b> </br>
 * Given reviews of hotels find review present in all hotel </br>
 * hotelA = { "hotel with bathroom", "niceHotel", "nice breakfast" }</br>
 * hotelB = { "hotel with bathroom", "bad", "best hotel near beach" }</br>
 * hotelC = { "hotel with bathroom", "not pet friendly", "bad dinner" }</br>
 * 
 * </br>
 * <b> Assumptions:</b></br>
 * Arrays are unsorted.</br>
 * </br>
 * 
 * <b>Problem Variations:</b></br>
 * 1) Each array consists of distinct hotel IDs </br>
 * 2) Each array may contain duplicate hotel IDs</br>
 * 
 * @author Shridutt.Kothari
 *
 */
public class DuplicateFromMultipleArrays {

	public static void main(String[] args) {
		int[] A = new int[] { 2, 5, 3, 2, 8, 1 };
		int[] B = new int[] { 7, 9, 5, 2, 4, 10, 10 };
		int[] C = new int[] { 6, 7, 5, 5, 3, 7 };

		Integer[] newA = removeDuplicates(A);
		Integer[] newB = removeDuplicates(B);
		Integer[] newC = removeDuplicates(C);
		// 5n
		Integer[] mergedArray = mergeArrays(newA, newB, newC);

		LinkedHashSet<Integer> uniqueSet = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> commonIntegers = new LinkedHashSet<Integer>();
		for (Integer value : mergedArray) {
			boolean isAdded = uniqueSet.add(value);
			if (!isAdded) {
				// duplicate element
				// add this to duplicate list
				boolean isAddedToCommonSet = commonIntegers.add(value);
				if (isAddedToCommonSet) {
					System.out.println(value);
				}
			}
		}

	}

	public static Integer[] mergeArrays(Integer[]... arrays) {
		List<Integer> list = new ArrayList<Integer>();

		for (Integer[] array : arrays)
			Collections.addAll(list, array);

		return list.toArray(new Integer[list.size()]);
	}

	private static Integer[] removeDuplicates(int[] arrayWithDuplicates) {

		LinkedHashSet<Integer> uniqueSet = new LinkedHashSet<Integer>();
		for (int value : arrayWithDuplicates) {
			uniqueSet.add(value);
		}
		return uniqueSet.toArray(new Integer[uniqueSet.size()]);
	}
}
