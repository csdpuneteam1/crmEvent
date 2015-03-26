package processors.test;

import static org.junit.Assert.*;

import java.util.List;

import model.Customer;

import org.junit.Test;

import processors.dao.CustomerDao;
import processors.dao.CustomerDaoImpl;

public class RetrievalTest {
	CustomerDao dao;
	@Test
	public void testCustomerDaoObject() {
		dao = new CustomerDaoImpl();
		assert( dao != null);
		
	}
	
	@Test
	public void testCustomerDaoList() {
		dao = new CustomerDaoImpl();
		List<Customer> custList = dao.getCustomerList();
		assert(custList != null );
		
	}
}
	

