package com.nehaspring.springmvcrest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private String name;
	private Double price;
	
	@JsonProperty("product_url")
	private String productUrl;
	
	
	@JsonProperty("category_url")
	private String categoryUrl;
	
	@JsonProperty("vendor_url")
	private String vendorUrl;
	
	
}
