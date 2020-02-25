package com.dailycodinginterview.arrays;

import java.util.Arrays;

/**
 * <b>Problem Statements:</b></br>
 * 
 * Given dates of check-in and check-out of all the guests of any hotel, find the busiest day of the hotel.<br><br>
 * 
 * <b>Input:</b> </br>
 * arrivals [] 	 = {1, 2, 9, 5, 5} </br>
 * departures [] = {4, 5, 12, 9, 12} </br>
 * </br>
 * First guest in the system arrives at 1 and leaves at 4, </br>
 * second guest arrives at 2 and leaves at 5, and so on. <br>
 * <br>
 * <b>Output:</b></br>
 * 5 </br>
 * There are maximum 3 guests at day 5. <br>
 * <br>
 * <b>Solution Approach:</b></br>
 * 1. Create a array of dates </br>
 * 2. Iterate for the number of persons, and fill the dateArray with the number
 * of person came on that day and leave on next day </br>
 * 3. Find the highest value from the dates array <br>
 * <br>
 * <b>Time Complexity:</b> <br>
 * Big O (N) where N is the difference between starting date and end date from first arrival and last departure respectively.<br>
 * 
 * @author Shridutt.Kothari
 *
 */
public class BusiestDayOfHotel {

	public static void main(String[] args) {
		// arrivals of person1, person2, person3, person4, person5
		int arrivals[] = { 1, 2, 9, 5, 5 }; // dates
		
		// departures of person1, person2, person3, person4, person5
		int departures[] = { 4, 5, 12, 9, 12 }; // dates

		int numberOfDays = findMaximumNumberOfDays(arrivals, departures);
		int dates[] = new int[numberOfDays + 2];
		dates = fillWithPersonPresent(dates, arrivals, departures);

		int maxPeoplePresentInSystem = Integer.MIN_VALUE;
		int currentnoOfPeoplePresent = 0;
		int onWhichDay = 0;

		for (int index = 0; index < dates.length; index++) {
			currentnoOfPeoplePresent = currentnoOfPeoplePresent + dates[index];
			if (maxPeoplePresentInSystem < currentnoOfPeoplePresent) {
				maxPeoplePresentInSystem = currentnoOfPeoplePresent;
				onWhichDay = index;
			}
		}
		System.out.println("Max People Present In Hotel: " + maxPeoplePresentInSystem);
		System.out.println("Max People Present In Hotel on : " + onWhichDay);

	}

	private static int[] fillWithPersonPresent(int[] dates, int[] arrivals, int[] departures) {
		Arrays.fill(dates, 0); // By default there's is no one on any date
		int totalPersonsCameIn = arrivals.length;
		for (int index = 0; index < totalPersonsCameIn; index++) {
			int personCameInOnDate = arrivals[index];
			int personLeftOnDate = departures[index] + 1;

			dates[personCameInOnDate] = dates[personCameInOnDate] + 1;
			dates[personLeftOnDate] = dates[personLeftOnDate] - 1;
		}
		return dates;
	}

	private static int findMaximumNumberOfDays(int[] arrivals, int[] departures) {
		int lastDayOfArrival = Arrays.stream(arrivals).max().getAsInt();
		int lastDayOfDeparture = Arrays.stream(departures).max().getAsInt();
		return Math.max(lastDayOfArrival, lastDayOfDeparture);
	}
}
