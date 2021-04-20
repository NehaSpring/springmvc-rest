package com.nehaspring.springmvcrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nehaspring.springmvcrest.api.v1.mapper.ProductMapper;
import com.nehaspring.springmvcrest.api.v1.model.ProductDTO;
import com.nehaspring.springmvcrest.domain.Product;
import com.nehaspring.springmvcrest.repositories.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	

	public ProductServiceImp(ProductRepository productRepository,
			ProductMapper productMapper) {
		super();
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public List<ProductDTO> listAllProducts() {
		List<ProductDTO> products = productRepository
									.findAll()
									.stream()
									.map(product ->{
											ProductDTO productDTO = productMapper.productToProductDTO(product);
											productDTO.setProductUrl("/api/v1/products/"+product.getId());
											return productDTO;
									}).collect(Collectors.toList());
		return products;
	}

	@Override
	public ProductDTO create(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
