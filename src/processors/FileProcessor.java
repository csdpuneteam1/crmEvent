package processors;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

import au.com.bytecode.opencsv.CSVReader;

public class FileProcessor {

	public List<String[]> readFile(String fileName) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(fileName));
		String[] nextLine = null;
		List<String[]> listOfLines = new ArrayList<>();
		while ((nextLine = reader.readNext()) != null) {
			listOfLines.add(nextLine);
		}
		reader.close();
		return listOfLines;
	}

	public List<Customer> convertExcelData(List<String[]> excelData) {
		List<Customer> customers = new ArrayList<>();
		Customer customer = null;
		for (String[] strings : excelData) {
			customer = new Customer();
			customer.setCustomerName(strings[0]);
			customer.setEmailAddress(strings[1]);
			customer.setPhoneNumber(strings[2]);
			customer.setCompany(strings[3]);
			customer.setRegistrationNumber(strings[4]);
			customers.add(customer);
		}
		return customers;
	}
	
}
