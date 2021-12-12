package com.lti.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.Exception.ResourceNotFoundException;
import com.lti.Repository.CustomerRepository;
import com.lti.controllers.ProducerController;
import com.lti.model.Customer_Bank;

@Service
@Transactional
public class ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private CustomerRepository custrep;

	public Customer_Bank PostCustomer(Customer_Bank customer) {
		// TODO Auto-generated method stub
		return custrep.save(customer);
	}

	public List<Customer_Bank> getCustomers() {
		// TODO Auto-generated method stub
		return custrep.findAll();
	}

	public Customer_Bank getCustomersByID(int custid) throws ResourceNotFoundException {
		Customer_Bank cust = custrep.findById(custid)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + custid));

		return cust;
	}

	public String deleteCust(int custid) throws ResourceNotFoundException {
		Customer_Bank cust = custrep.findById(custid)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + custid));

		custrep.delete(cust);
		return "deleted" + custid;
	}

	public ResponseEntity<Customer_Bank> updateCustomer(int custid, Customer_Bank custDetails)
			throws ResourceNotFoundException {
		logger.info("****************Service Class :update customers****************");
		Customer_Bank cust = custrep.findById(custid)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + custid));
		cust.setName(custDetails.getName());
		cust.setAddressId(custDetails.getAddressId());
		cust.setAge(custDetails.getAge());
		cust.setTypeofAccount(custDetails.getTypeofAccount());
		final Customer_Bank updatedCustomer = custrep.save(cust);

		return ResponseEntity.ok(updatedCustomer);
	}

}
