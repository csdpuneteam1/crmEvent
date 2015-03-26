package processors;

import java.util.List;

import email.BulkEmail;

import model.Customer;
import processors.dao.CustomerDao;
import processors.dao.CustomerDaoImpl;

public class SendBulkEmail {
	public void sendEmail() {
		CustomerDao dao = new CustomerDaoImpl();
		List<Customer> custList = dao.getCustomerList();
		BulkEmail email = new BulkEmail();
		for(int i = 0; i<custList.size(); i++) {
			Customer cust = custList.get(i); 
			email.sendEmail(cust, "Sample Subject", "c:\\test\\testpdf");
		}
	}

}
