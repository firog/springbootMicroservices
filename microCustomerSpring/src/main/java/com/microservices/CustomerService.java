package com.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.Customer;

@RestController
@RequestMapping(value = "/rest/customer")
public class CustomerService {
	
	@Autowired
	public CustomerRepo repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Customer> getAllCustomers()
	{
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getById(@PathVariable String id) throws Exception
	{
		if(repository.exists(id))
		{
			return repository.findById(id);
		} else {
			throw new Exception("Customer with id " + id + "does not exist");
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Customer addCustomer(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName", defaultValue = "unknown") String lastName)
	{
		Customer customer = new Customer(firstName, lastName);
		repository.save(customer);
		return customer;
	}
}
