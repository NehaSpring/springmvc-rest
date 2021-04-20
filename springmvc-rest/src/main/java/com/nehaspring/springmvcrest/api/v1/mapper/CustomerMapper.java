package com.nehaspring.springmvcrest.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nehaspring.springmvcrest.api.v1.model.CustomerDTO;
import com.nehaspring.springmvcrest.domain.Customer;

@Mapper
public interface CustomerMapper {

	public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDTO  customerToCustomerDTO(Customer customer);
	Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
