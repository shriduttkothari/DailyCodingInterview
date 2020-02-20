package com.dailycodinginterview.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * <b>Problem Statement:</b></br>
 * Given two arrays a, b as below:</br>
 * int [] a = [3, 1, 4, 5, 19, 6];</br>
 * int [] b = [14, 9, 22, 36, 8, 0, 64, 25];</br>
 * </br>
 * Some elements in the second array are squares. </br>
 * Print elements that have a square root existing in the first array. </br>
 * b[1] = 9, it’s square root is 3 (a[0]) </br>
 * b[3] = 36, it’s square root is 6 (a[5]) </br>
 * b[7] = 25, it’s square root is 5 (a[3]) </br>
 * </br>
 * </br>
 * <b>Result:</b> </br>
 * [9, 36, 25] </br>
 * 
 * </br>
 * <b>Solution APproach:</b></br>
 * 1. Iterate Array a and build a HashSet with squares of each element from it
 * </br>
 * 2. Iterate Array b and see if it is present in the HashSet, and if found add
 * this to result array</br>
 * </br>
 * <b>Time Complexity:</b></br>
 * Big O(N * M) Where N is the length array a, and M is the length of array b
 * </br>
 * 
 * @author Shridutt.Kothari
 *
 */
public class SquareRootInTwoArray {

	public static void main(String[] args) {

		int[] a = new int[] { 3, 1, 4, 5, 19, 6 };
		int[] b = new int[] { 14, 9, 22, 36, 8, 0, 64, 25 };

		ArrayList<Integer> resultArray = findSquareRootsFromFirstArray(a, b);

		System.out.println("------------------------------------------");
		System.out.println("a: " + Arrays.toString(a));
		System.out.println("b: " + Arrays.toString(b));
		System.out.println("resultArray: " + resultArray);
		System.out.println("------------------------------------------");

		a = null;
		b = null;

		ArrayList<Integer> resultArray1 = findSquareRootsFromFirstArray(a, b);
		System.out.println("------------------------------------------");
		System.out.println("a: " + Arrays.toString(a));
		System.out.println("b: " + Arrays.toString(b));
		System.out.println("resultArray: " + resultArray1);
		System.out.println("------------------------------------------");
	}

	private static ArrayList<Integer> findSquareRootsFromFirstArray(int[] a, int[] b) {
		ArrayList<Integer> squaresPresentInSecondArray = new ArrayList<>();
		if (a == null || b == null) {
			return squaresPresentInSecondArray;
		}

		HashSet<Integer> squareSet = new HashSet<>();
		for (int value : a) {
			squareSet.add(value * value);
		}

		for (int value : b) {
			if (squareSet.contains(value)) {
				squaresPresentInSecondArray.add(value);
			}
		}
		return squaresPresentInSecondArray;
	}
}
