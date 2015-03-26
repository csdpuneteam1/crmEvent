package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Before;

public class RPN {

	static String[] inputArray;

	String operatorsStr[] = new String[] { "+", "-", "*", "/" };
	Map operators = new HashMap<String, String>();
	BinaryOperators binOp = new BinaryOperators();

	public void populateOperators() {
		for (int i = 0; i < operatorsStr.length; i++) {
			operators.put(operatorsStr[i], operatorsStr[i]);
		}
	}

	public RPN(String[] strings) {
		// TODO Auto-generated constructor stub
		setInputArray(strings);
		populateOperators();
	}

	public static String[] getInputArray() {
		return inputArray;
	}

	public static void setInputArray(String[] inputArray) {
		RPN.inputArray = inputArray;
	}

	public static void main(String[] args) {
		args = new String[] { "6", "2", "/", "3", "*" };
		setInputArray(args);
		RPN r = new RPN(args);
		try {
			r.addStack();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addStack() throws Exception {
		Stack<Integer> numberStack = new Stack<Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			try {
				int val = Integer.parseInt(inputArray[i]);
				numberStack.push(val);
			} catch (NumberFormatException nfe) {
				// this should be operator
				// check for operator
				String operator = (String) operators.get(inputArray[i]);
				if (operator != null) {
					int f = numberStack.pop();
					int s = numberStack.pop();
					int c = getCalculateValue(s, f, operator);
					numberStack.push(c);
				} else {
					throw new Exception("Please enter only valid operators");
				}

			}
		}
		System.out.println("result " + numberStack.pop());
	}

	public int getCalculateValue(int f, int s, String operator) {

		switch (operator) {
		case "+":
			return f + s;
		case "-":
			return f - s;
		case "*":
			return f * s;
		case "/":
			return f / s;
		}
		return 0;
	}
}
