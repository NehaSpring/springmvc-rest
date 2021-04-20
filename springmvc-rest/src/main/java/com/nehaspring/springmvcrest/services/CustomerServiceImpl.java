package com.nehaspring.springmvcrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nehaspring.springmvcrest.api.v1.mapper.CustomerMapper;
import com.nehaspring.springmvcrest.api.v1.model.CustomerDTO;
import com.nehaspring.springmvcrest.domain.Customer;
import com.nehaspring.springmvcrest.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		super();
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		
		return customerRepository.findAll()
								 .stream()
								 //.map(customerMapper::customerToCustomerDTO)
								 .map(customer -> {
									 CustomerDTO cutsomerDTO = customerMapper.customerToCustomerDTO(customer);
									 cutsomerDTO.setCustomer_url("/api/v1/customer/"+customer.getId());
									 return cutsomerDTO;
								 })
								 .collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerByName(String firstname) {
		
		return customerMapper.customerToCustomerDTO(customerRepository.findByFirstname(firstname));
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		
		return customerRepository.findById(id)
								 .map(customer -> {
									 CustomerDTO cutsomerDTO = customerMapper.customerToCustomerDTO(customer);
									 cutsomerDTO.setCustomer_url("/api/v1/customer/"+customer.getId());
									 return cutsomerDTO;
								 })
								 .orElseThrow(ResourceNotFoundException:: new);
								 
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		return saveCustomer(customer);
	}
	
	
	@Override
	public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
		
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		customer.setId(id);
		return saveCustomer(customer);
	}
	
	private CustomerDTO saveCustomer(Customer customer) {
		
		Customer savedCustomer = customerRepository.save(customer);
		CustomerDTO savedCustomerDTO = customerMapper.customerToCustomerDTO(savedCustomer);
		savedCustomerDTO.setCustomer_url("/api/v1/customer/"+savedCustomer.getId());
		return savedCustomerDTO;
	}

	@Override
	public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
		
		return customerRepository.findById(id)
								  .map(customer ->{
									 if(customerDTO.getFirstname() !=null) {
										 customer.setFirstname(customerDTO.getFirstname());
									 }
									 
									 if(customerDTO.getLastname() !=null) {
										 customer.setLastname(customerDTO.getLastname());
									 }
									 
									 return saveCustomer(customer);
								  }).orElseThrow(ResourceNotFoundException:: new);
	}

	@Override
	public void deleteCustomerId(Long id) {
		
		customerRepository.deleteById(id);
	}

	
	
}
