package com.dailycodinginterview.stack;

import java.util.Stack;

/**
 * <b>Problem Statement:</b><br>
 * <br>
 * 
 * Write a function to test if the given set of brackets are balanced or not.
 * e.g. {{}}{)([][]
 * 
 * <b>Solution Approach:</b><br>
 * <br>
 * 1) Declare a character stack S. <br>
 * <br>
 * 2) Now traverse the expression string exp.<br>
 * a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then
 * push it to stack. <br>
 * b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]‘) then pop
 * from stack and if the popped character is the matching starting bracket then
 * fine else parenthesis are not balanced. <br>
 * <br>
 * 3) After complete traversal, if there is some starting bracket left in stack
 * then “not balanced”
 * 
 * 
 * @author Shridutt.Kothari
 *
 */
public class ValidParenthesis {

	public static void main(String[] args) {
		String input = "{{}}{)([][]";
		boolean isValid = isValidParenthesis(input);
		System.out.println("input1: " + input + " isValid1= " + isValid);

		String input2 = "{ABcsfafafaf()}";
		boolean isValid2 = isValidParenthesis(input2);
		System.out.println("input2: " + input2 + " isValid2= " + isValid2);

		String input3 = "{([][][]() {{{}}})}";
		boolean isValid3 = isValidParenthesis(input3);
		System.out.println("input3: " + input3 + " isValid3= " + isValid3);

		String input4 = "}";
		boolean isValid4 = isValidParenthesis(input4);
		System.out.println("input4" + input4 + " isValid4= " + isValid4);

		String input5 = "(";
		boolean isValid5 = isValidParenthesis(input5);
		System.out.println("input5" + input5 + " isValid5= " + isValid5);

	}

	private static boolean isValidParenthesis(String input) {
		if (null == input || input.trim().equals("")) {
			return true;
		}
		Stack<Character> charStack = new Stack<Character>();
		int length = input.length();
		for (int index = 0; index < length; index++) {
			char currentCharcter = input.charAt(index);
			if (currentCharcter == '{' || currentCharcter == '(' || currentCharcter == '[') {
				charStack.add(currentCharcter);
			} else {
				Character lastChar = null;
				if (currentCharcter == '}') {
					if (charStack.isEmpty()) {
						return false;
					} else {
						lastChar = charStack.peek();
						if (lastChar == '{') {
							charStack.pop();
						} else {
							return false;
						}
					}
				} else if (currentCharcter == ')') {
					if (charStack.isEmpty()) {
						return false;
					} else {
						lastChar = charStack.peek();
						if (lastChar == '(') {
							charStack.pop();
						} else {
							return false;
						}
					}
				}
				if (currentCharcter == ']') {
					if (charStack.isEmpty()) {
						return false;
					} else {
						lastChar = charStack.peek();
						if (lastChar == '[') {
							charStack.pop();
						} else {
							return false;
						}
					}
				}
			}
		}

		if (!charStack.isEmpty()) {
			return false;
		}
		return true;
	}
}
