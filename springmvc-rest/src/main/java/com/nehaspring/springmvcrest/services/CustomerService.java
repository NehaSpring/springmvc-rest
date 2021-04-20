package com.nehaspring.springmvcrest.services;

import java.util.List;

import com.nehaspring.springmvcrest.api.v1.model.CustomerDTO;

public interface CustomerService {

	List<CustomerDTO> getAllCustomers();
	CustomerDTO getCustomerByName(String firstname);
	CustomerDTO getCustomerById(Long id);
	CustomerDTO createNewCustomer(CustomerDTO customerDTO);
	CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
	CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);
	void deleteCustomerId(Long id);
}
