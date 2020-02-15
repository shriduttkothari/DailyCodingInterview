package com.dailycodinginterview.linkedlist.removeduplicatefromsortedlinkedlist;

/**
 * 
 * <b>Problem Statement:</b><br>
 * <br>
 * Given a <b> sorted linked list</b> of integers, remove all the duplicate
 * elements in the linked list so that all elements in the linked list are
 * unique. <br>
 * (This problem was recently asked by Amazon)
 * 
 * <br>
 * <br>
 * <b>Problem Source:</b> @see
 * <a href="https://www.techseries.dev/daily">DailyInterviewPro</a> <br>
 * <br>
 * <b>Solution Approach:</b><br>
 * <br>
 * As the list is sorted in nature, we can compare each element with next and if
 * they are equal, we will remove one of them, and link the next of duplicate
 * with the remaining unique node.
 * 
 * <br>
 * <br>
 * <b> Time Complexity:</b> <br>
 * <br>
 * Big O (n) where n is the number of nodes present in LinkedList
 * 
 * @author Shridutt.Kothari
 *
 */
public class RemoveDuplicate {

	public static void main(String[] args) {
		System.out.println("Start");

		// As per the problem statement, LinkedList is sorted
		SinglyLinkedList linkedList = new SinglyLinkedList(
				new Node(1, new Node(2, new Node(2, new Node(3, new Node(4, new Node(4, null)))))));

		System.out.println("Printing LinkedList values before removing duplicate");
		print(linkedList);

		removeDuplicateFromSortedLinkedList(linkedList);

		System.out.println("Printing LinkedList values after removing duplicate");

		print(linkedList);
		System.out.println("Exit");
	}

	private static void removeDuplicateFromSortedLinkedList(SinglyLinkedList linkedList) {
		Node currentNode = linkedList.head;
		while (null != currentNode.next) {
			if (currentNode.value == currentNode.next.value) {
				currentNode.next = currentNode.next.next;
			} else {
				currentNode = currentNode.next;
			}
		}
	}

	private static void print(SinglyLinkedList linkedList) {
		Node currentNodeNew = linkedList.head;
		while (null != currentNodeNew) {
			System.out.println(currentNodeNew.value);
			currentNodeNew = currentNodeNew.next;
		}
	}

}
