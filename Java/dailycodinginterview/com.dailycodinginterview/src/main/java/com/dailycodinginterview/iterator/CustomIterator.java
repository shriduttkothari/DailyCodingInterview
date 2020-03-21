package com.dailycodinginterview.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Shridutt.Kothari </br>
 * 
 *         <b>Problem Statement:</b></br>
 *         </br>
 *         Given K sorted (ascending) arrays with N elements in each array,
 *         implement an iterator for iterating over the elements of the arrays
 *         in ascending order. </br>
 *         </br>
 * 
 *         The constructor receives all of the input as array of arrays.</br>
 *         </br>
 * 
 *         You need to implement the MyIterator class with a constructor and the
 *         following methods:</br>
 *         </br>
 * 
 *         class MyIterator<T> {</br>
 *         T next(); </br>
 *         boolean hasNext(); </br>
 *         } </br>
 *         </br>
 * 
 *         You are allowed to use only O(K) extra space with this class.</br>
 *         example: </br>
 *         input:</br>
 *         [[1,5,7], [2,3,10],[4,6,9]] </br>
 * 
 *         The iterator should return:</br>
 *         1,2,3,4,5,6,7,9,10
 */

public class CustomIterator {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		List<Integer> list1 = Arrays.asList(new Integer[] { 1, 5, 7 });
		List<Integer> list2 = Arrays.asList(new Integer[] { 2, 3, 10 });
		List<Integer> list3 = Arrays.asList(new Integer[] { 4, 6, 9 });
		list.add(list1);
		list.add(list2);
		list.add(list3);

		MyIterator<?> myIterator = new MyIterator<>(list);

		while (myIterator.hasNext()) {
			System.out.print(myIterator.next());
			if (myIterator.hasNext()) {
				System.out.print(",");
			}
		}
	}

	public static class MyIterator<T extends Comparable<? super T>> {

		private List<T> list;
		private int index;

		public MyIterator(List<List<T>> data) {
			list = new ArrayList<T>();
			index = 0;
			for (List<T> internalList : data) {
				list.addAll(internalList);
			}
			Collections.sort(list);
		}

		public T next() {
			if (hasNext()) {
				return list.get(index++);
			} else
				return null;
		}

		public boolean hasNext() {
			return index < list.size();
		}

		public T remove() {
			if (hasNext()) {
				T t = list.get(index);
				list.remove(index);
				return t;
			} else
				return null;
		}
	}
}
