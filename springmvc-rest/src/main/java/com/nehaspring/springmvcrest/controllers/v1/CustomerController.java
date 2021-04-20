package com.nehaspring.springmvcrest.controllers.v1;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nehaspring.springmvcrest.api.v1.model.CustomerDTO;
import com.nehaspring.springmvcrest.api.v1.model.CustomerListDTO;
import com.nehaspring.springmvcrest.services.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Customers")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@ApiOperation(value = "Returns list of Customers ")
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public CustomerListDTO getAllCutomers(){
		
		return new CustomerListDTO(customerService.getAllCustomers());
	}
	
	//Legacy Way of returning Response
	/*
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id){
		
		ResponseEntity<CustomerDTO> response = new ResponseEntity<CustomerDTO>
												(customerService.getCustomerById(Long.valueOf(id)), HttpStatus.OK);
		return response;
	}
	*/
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CustomerDTO getCustomerById(@PathVariable String id){
	
		return customerService.getCustomerById(Long.valueOf(id));
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerDTO createNewCustomer(@Valid @RequestBody CustomerDTO customerDTO){
		
		return customerService.createNewCustomer(customerDTO);
	}
	
	
	public ResponseEntity<CustomerDTO> patchCustomer2Demo(@RequestBody CustomerDTO customerDTO) {
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(customerDTO.getId()).toUri();
		return  ResponseEntity.created(location).build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO){
		
		return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(Long.valueOf(id), customerDTO), HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CustomerDTO patchCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO){
		
		return customerService.patchCustomer(Long.valueOf(id), customerDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCustomer(@PathVariable String id){
		
		
		customerService.deleteCustomerId(Long.valueOf(id));
		
	}
	
	
	
}
