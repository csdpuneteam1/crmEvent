package test.java;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import main.java.RPN;

import org.junit.Before;

public class testRPN extends TestCase {
	RPN r = new RPN(new String[] { "1", "2", "+" });
	String operatorsStr[] = new String[] { "+", "-", "*", "/" };
	Map operators = new HashMap<String, String>();

	@Before
	public void populateOperators() {
		for (int i = 0; i < operatorsStr.length; i++) {
			operators.put(operatorsStr[i], operatorsStr[i]);
		}

	}

	public void testInputIsNotNull() {
		assertNotNull(r.getInputArray());
	}

	public void testInputLength() {
		String array[] = r.getInputArray();
		boolean len = array.length >= 3;
		assertEquals(true, len);
	}

	public void testInitialTwoEntries() {
		testInputLength();
		String array[] = r.getInputArray();
		int firstValue;
		try {
			firstValue = Integer.parseInt(array[0]);
			assertEquals(true, new Integer(firstValue) instanceof Integer);
			firstValue = Integer.parseInt(array[1]);
			assertEquals(true, new Integer(firstValue) instanceof Integer);
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(false);

		}
	}

	public void testValidInput() {
		for (int i = 0; i < operatorsStr.length; i++) {
			operators.put(operatorsStr[i], operatorsStr[i]);
		}
		String inputArray[] = r.getInputArray();
		for (int i = 0; i < inputArray.length; i++) {
			try {
				int val = Integer.parseInt(inputArray[i]);
				assertTrue(true);

			} catch (NumberFormatException nfe) {
				// this should be operator
				// check for operator
				String object = (String) operators.get(inputArray[i]);
				if (object == null) {
					assertTrue(false);
				}
			}
		}

	}

}
