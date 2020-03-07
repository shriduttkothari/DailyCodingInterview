package com.dailycodinginterview.arrays.multidimentional;

/**
 * <b>Problem Statement: </b><br>
 * Given a matrix, transpose it. Transposing (Rotating) a matrix means the rows
 * are now the column and vice-versa. (This question was asked by twitter) <br>
 * <br>
 * <b>Solution Approach: </b><br>
 * 1. lets assume vertical length of input array be lengthVerical, and
 * horizontal length of input array be lengthHorizontal ex. int [lengthVertical]
 * [lengthHorizontal] <br>
 * 2. Create a new array with dimensions as int [lengthHorizontal]
 * [lengthVertical]<br>
 * 3. Copy elements from input array to output with interchanging the values at
 * indices like below:<br>
 * vertical, horizontal from input into horizontal, vertical in output
 * 
 * <br>
 * <br>
 * <b>Time Complexity:</b><br>
 * Big O(N*M): where N is the vertical length of array and M is the horizontal
 * length of array
 * 
 * @author Shridutt.Kothari
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		int input[][] = { { 1, 2, 3 }, { 4, 5, 6 } };

		System.out.println("input array: ");
		System.out.println("{" + printMultiDArray(input) + "}");
		int output[][] = rotateArray(input);

		System.out.println("output array: ");
		System.out.println("{" + printMultiDArray(output) + "}");

		int input1[][] = { { 1, 2, 3 } };

		System.out.println("input array: ");
		System.out.println("{" + printMultiDArray(input1) + "}");
		int output1[][] = rotateArray(input1);

		System.out.println("output array: ");
		System.out.println("{" + printMultiDArray(output1) + "}");

	}

	private static int[][] rotateArray(int[][] input) {

		int inputVLength = input.length;
		int inputHLength = input[0].length;

		int output[][] = new int[inputHLength][inputVLength];
		for (int indexVertical = 0; indexVertical < inputVLength; indexVertical++) {
			for (int indexHorizontal = 0; indexHorizontal < inputHLength; indexHorizontal++) {
				output[indexHorizontal][indexVertical] = input[indexVertical][indexHorizontal];
			}
		}
		return output;
	}

	private static String printMultiDArray(int[][] input) {
		int inputVLength = input.length;
		int inputHLength = input[0].length;

		StringBuilder arrayToString = new StringBuilder();

		for (int indexVertical = 0; indexVertical < inputVLength; indexVertical++) {
			arrayToString.append("{");

			for (int indexHorizontal = 0; indexHorizontal < inputHLength; indexHorizontal++) {
				arrayToString.append(input[indexVertical][indexHorizontal]);
				arrayToString.append(",");
			}
			arrayToString = arrayToString.replace(arrayToString.length() - 1, arrayToString.length(), "");
			arrayToString.append("},");
		}
		arrayToString = arrayToString.replace(arrayToString.length() - 1, arrayToString.length(), "");

		return arrayToString.toString();
	}
}
