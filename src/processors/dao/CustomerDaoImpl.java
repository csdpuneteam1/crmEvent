package processors.dao;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> getCustomerList() {
		Customer  cust = new Customer();
		cust.setCompany("Lean");
		cust.setCustomerName("Pune team member 1");
		cust.setEmailAddress("a.b@gmail.com");
		cust.setPhoneNumber("123123123");
		cust.setRegistrationNumber("R123");
		List<Customer> custList = new ArrayList<Customer>();
		custList.add(cust);
		return custList;
	}
	

}
