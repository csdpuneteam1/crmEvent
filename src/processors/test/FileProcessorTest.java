package processors.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import model.Customer;

import org.junit.Test;

import processors.FileProcessor;

public class FileProcessorTest extends TestCase {

	@Test
	public void testReadFile() {
		FileProcessor fileProcessor = new FileProcessor();
		try {
			assertNotNull(fileProcessor
					.readFile("C:\\Documents and Settings\\Mohit Garg\\Desktop\\CustomerData.csv"));
		} catch (FileNotFoundException e) {
			fail("exception occured");
		} catch (IOException e) {
			fail("exception occured");
		}
	}

	@Test
	public void testReadFile3() {
		FileProcessor fileProcessor = new FileProcessor();
		try {
			assertNotNull(fileProcessor.readFile("omerData.csv"));
			fail("exception occured");
		} catch (FileNotFoundException e) {
			assertTrue(true);
		} catch (IOException e) {
			fail("exception occured");
		}
	}

	@Test
	public void testReadFile2() {
		FileProcessor fileProcessor = new FileProcessor();
		try {
			List<String[]> listOfLines = fileProcessor
					.readFile("C:\\Documents and Settings\\Mohit Garg\\Desktop\\CustomerData.csv");
			assertEquals(7, listOfLines.size());
		} catch (FileNotFoundException e) {
			fail("exception occured");
		} catch (IOException e) {
			fail("exception occured");
		}
	}

	@Test
	public void testConvertExcelData() {
		List<String[]> listOfLines = new ArrayList();
		FileProcessor fileProcessor = new FileProcessor();
		List<Customer> customers = null;
		listOfLines.add(new String[] { "Mohit", "mohit.garg@sungard.com",
				"8605504740", "Sungard", "1" });
		listOfLines.add(new String[] { "Mohit", "mohit.garg@sungard.com",
				"8605504740", "Sungard", "2" });
		listOfLines.add(new String[] { "Mohit", "mohit.garg@sungard.com",
				"8605504740", "Sungard", "3" });
		listOfLines.add(new String[] { "Mohit", "mohit.garg@sungard.com",
				"8605504740", "Sungard", "4" });
		listOfLines.add(new String[] { "Mohit", "mohit.garg@sungard.com",
				"8605504740", "Sungard", "5" });
		listOfLines.add(new String[] { "Mohit", "mohit.garg@sungard.com",
				"8605504740", "Sungard", "6" });

		customers = fileProcessor.convertExcelData(listOfLines);
		assertEquals(6, customers.size());
	}

	@Test
	public void testConvertExcelData1() {
		List<String[]> listOfLines = null;
		FileProcessor fileProcessor = new FileProcessor();
		List<Customer> customers = null;

		customers = fileProcessor.convertExcelData(listOfLines);
		assertEquals(6, customers.size());
	}
}
