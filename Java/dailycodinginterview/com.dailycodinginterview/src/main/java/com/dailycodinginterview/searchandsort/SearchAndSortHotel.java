package com.dailycodinginterview.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <b>Problem statement</b>:<br>
 * <br>
 * 
 * Given a set of hotels and its guests reviews,<br>
 * sort the hotels based on a list of words specified by a user. The criteria to
 * sort the hotels should be how many times the words specified by the user is
 * mentioned in the hotel reviews.
 * 
 * <br>
 * <br>
 * <b>Input:</b><br>
 * <br>
 * 
 * The first line contains a space-separated set of words which we want to find
 * mentions in the hotel reviews. The second line contains one integer M, which
 * is the number of reviews. This is followed by M+M lines, which alternates an
 * hotel ID and a review belonging to that hotel.
 * 
 * Output A list of hotel IDs sorted, in descending order, by how many mentions
 * they have of the words specified in the input.<br>
 * If the count is same, sort according to the hotel IDs.
 * 
 * </br>
 * </br>
 * <b>Solution Approach:</b></br>
 * 1. Iterate the Hotels</br>
 * 2. Iterate Reviews of each hotel</br>
 * 3. Split each review into words (lower case and replace ,. with space)</br>
 * 4. Check each word if it is present in the given list of words and count it.</br>
 * 5. Create Custom HotelRatings Object with hotel id and count of words matched</br>
 * 6. Sort the List of HotelRatings using Comparable based on HotelRating and HotelId</br></br>
 * 
 * @author Shridutt.Kothari
 *
 */
public class SearchAndSortHotel {

	public static void main(String[] args) {

		List<String> listOfWords = Arrays.asList(new String[] { "Bathroom".toLowerCase(), "TV".toLowerCase(),
				"Bed".toLowerCase(), "Dryer".toLowerCase(), "Silent".toLowerCase() });
		Set<Hotel> hotelReviews = buildHotelReviews();

		List<HotelRatings> sortedHotelsJava7 = searchAndSortJava7(hotelReviews, listOfWords);
		System.out.println(sortedHotelsJava7);

		List<HotelRatings> sortedHotels = searchAndSortJava8(hotelReviews, listOfWords);
		System.out.println(sortedHotels);
	}

	private static List<HotelRatings> searchAndSortJava7(Set<Hotel> hotels, List<String> listOfWords) {
		List<HotelRatings> hotelRatingsList = new ArrayList<>();

		for (Hotel hotel : hotels) {
			int wordCounts = 0;
			for (String hoteReview : hotel.reviews) {
				String[] tokens = hoteReview.replaceAll("[,.]", "").toLowerCase().split("\\s+");
				for (String token : tokens) {
					if (listOfWords.contains(token)) {
						wordCounts++;
					}
				}
			}
			hotelRatingsList.add(new HotelRatings(hotel.hotelId, wordCounts));

		}
		Collections.sort(hotelRatingsList);
		return hotelRatingsList;
	}

	private static List<HotelRatings> searchAndSortJava8(Set<Hotel> hotelReviews, List<String> listOfWords) {
		List<HotelRatings> sortedHotels = hotelReviews.parallelStream().map(hotelReview -> {
			return buildHotelRating(hotelReview, listOfWords);
		}).sorted().collect(Collectors.toList());
		return sortedHotels;
	}

	private static HotelRatings buildHotelRating(Hotel hotelReview, List<String> listOfWords) {
		int wordsCount = (int) hotelReview.reviews.parallelStream()
				.flatMap(review -> Arrays.stream(review.toLowerCase().split(" "))) // ["word1", word2, "word3"...]
				.map(word -> word.replaceAll("[,.]", "")).filter(word -> listOfWords.contains(word)).count();
		return new HotelRatings(hotelReview.hotelId, wordsCount);

	}

	private static class HotelRatings implements Comparable<HotelRatings> {
		int hotelId;
		int wordsCount;

		public HotelRatings(int hotelId, int wordsCount) {
			this.hotelId = hotelId;
			this.wordsCount = wordsCount;
		}

		@Override
		public String toString() {
			return "hotelId: " + hotelId + ", wordsCount: " + wordsCount + "\n";
		}

		@Override
		public int compareTo(HotelRatings another) {
			int difference = this.wordsCount - another.wordsCount;
			if (difference == 0) {
				return this.hotelId - another.hotelId;
			}
			return difference;
		}
	}

	private static class Hotel {
		int hotelId;
		List<String> reviews;

		public Hotel(int hotelId, List<String> reviews) {
			this.hotelId = hotelId;
			this.reviews = reviews;
		}
	}

	private static Set<Hotel> buildHotelReviews() {
		Set<Hotel> hotelAndTheirReviews = new HashSet<>();
		hotelAndTheirReviews.add(new Hotel(111, Arrays.asList(new String[] { "This hotel has nice bathroom", "Big TV",
				"There was no hair dryer in the room", "Not an quit room" })));
		hotelAndTheirReviews.add(new Hotel(222, Arrays.asList(new String[] { "This hotel is very bad",
				"TV was not working", "Not recommanded", "TV was not working", "Very silent and scary room" })));
		hotelAndTheirReviews.add(new Hotel(333, Arrays.asList(new String[] {
				"Loved the hotel, had all accessories like tv, dryer, a big bathroom and it was a corner room so an silent private room",
				"TV was having lots of channels", "highly recommanded", "Double bed was very comfertable",
				"Very silent and beautiful room" })));
		return hotelAndTheirReviews;
	}

}
