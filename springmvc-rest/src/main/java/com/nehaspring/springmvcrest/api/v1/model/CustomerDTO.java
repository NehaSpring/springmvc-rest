package com.nehaspring.springmvcrest.api.v1.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {
	
	private Long id;
	@ApiModelProperty(value = "First Name of Customer", required  = true)
	@Size(min = 2, message = "Name should be minimum 2 Charachters long")
	@NotBlank
	private String firstname;
	@ApiModelProperty(value = "Last Name of Customer", required = true)
	private String lastname;
	private String customer_url;
	
}
