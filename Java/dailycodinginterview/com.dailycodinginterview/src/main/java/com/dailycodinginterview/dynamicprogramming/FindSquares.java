
package com.dailycodinginterview.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given number N, Find the least number of perfect square numbers needed to sum
 * up to N. <br>
 * <br>
 * 
 * <b>Example :</b><br>
 * n=5 (4+1) i.e. 2 <br>
 * n=7 (4+1+1+1) i.e. 4 <br>
 * n=12 (4+4+4) i.e 3 <br>
 * n=20 (16+4) i.e. 2 <br>
 * <br>
 * <b>Solution: </b><br>
 * <br>
 * This is a Dynamic Programming problem, so we need to solve it similar to Coin
 * Change problem but we also need to find denominations first (in this case
 * perfect squares) <br>
 * <br>
 * <b>Step 1:</b> Calculate perfect squares less than equal to given amount into
 * a list<br>
 * <b>Step 2:</b> for each denomination, loop<br>
 * <b>Step 3:</b> for each number from 0 till total amount given loop<br>
 * <b>Step 4:</b> check if current denomination is less than equal to current
 * amount<br>
 * <b>Step 5:</b> if true, we can use this denomination, so if we use it that
 * will be 1 denomination, so for remaining amount (current amount - current
 * denomination), whatever denominations we needed earlier, this is the new
 * number of denominations needed if we consider taking this current
 * denomination!! so lets decide either we take it or the denominations we
 * needed without considering current denomination whichever is minimum and
 * update the current index in array <br>
 * <b>Step 6:</b> after complete loop, we have minimum number of denominations
 * needed in the array<br>
 * <br>
 * 
 * <b>Space Complexity:</b> O(N) Where N is the amount<br>
 * <b>Time Complexity:</b> O(N * D) Where N is the amount, and D is the number
 * of denominations <br>
 * <br>
 * 
 * @author Shridutt.Kothari
 *
 */

public class FindSquares {

	public static void main(String[] args) {

		// Perfect squares variation
		System.out.println("min Perfact Squares Needed for 5: " + minNumberOfPerfactSquares(5));
		System.out.println("min Perfact Squares Needed for 7: " + minNumberOfPerfactSquares(7));
		System.out.println("min Perfact Squares Needed for 12: " + minNumberOfPerfactSquares(12));
		System.out.println("min Perfact Squares Needed for 20: " + minNumberOfPerfactSquares(20));

		// Coin Change Problem
		System.out.println("\nmin Coins Needed To Make Change of 20: " + minNumberOfCoinsNeededForChange(9));

	}

	private static int minNumberOfPerfactSquares(int number) {
		List<Integer> perfactSquares = findPerfactSquaresLessThan(number);
		int minPerfactSquaresNeeded = findMinimumNumberOfCoins(number, perfactSquares);
		return minPerfactSquaresNeeded;
	}

	private static int minNumberOfCoinsNeededForChange(int totalAmount) {
		// Coin Problem
		List<Integer> denominations = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000);
		int minCoinsNeeded = findMinimumNumberOfCoins(totalAmount, denominations);
		return minCoinsNeeded;
	}

	private static int findMinimumNumberOfCoins(int totalAmount, List<Integer> denominations) {

		int[] minNumbers = new int[totalAmount + 1];
		Arrays.setAll(minNumbers, i -> Integer.MAX_VALUE);

		minNumbers[0] = 0; // for zero amount we always need 0 denominations

		for (int currentDenomination : denominations) {
			for (int currentAmount = 0; currentAmount <= totalAmount; currentAmount++) {
				if (currentDenomination <= currentAmount) {
					minNumbers[currentAmount] = Integer.min(minNumbers[currentAmount],
							1 + minNumbers[currentAmount - currentDenomination]);
					// as we are using currentDenomination i.e. 1 coin and than for remaining amount
					// we have coins in array computed earlier
				}
			}
		}

		if (minNumbers[totalAmount] == Integer.MAX_VALUE) {
			// for given total amount no combination was possible
			return -1;
		}
		return minNumbers[totalAmount];
	}

	private static ArrayList<Integer> findPerfactSquaresLessThan(int givenNumber) {
		ArrayList<Integer> perfactSquares = new ArrayList<>();
		int currentNumber = 1;
		do {
			perfactSquares.add(currentNumber * currentNumber);
			currentNumber++;
		} while (currentNumber * currentNumber <= givenNumber);
		return perfactSquares;
	}

}
