package com.nehaspring.springmvcrest.services;

import java.util.List;

import com.nehaspring.springmvcrest.api.v1.model.ProductDTO;

public interface ProductService {

	List<ProductDTO> listAllProducts();
	ProductDTO create(ProductDTO productDTO);
	ProductDTO getProductById(Long id);
	void delete(Long id);
	ProductDTO updateProduct(Long id, ProductDTO productDTO);
	
}
