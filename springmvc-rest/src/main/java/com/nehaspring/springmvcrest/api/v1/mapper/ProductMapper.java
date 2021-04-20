package com.nehaspring.springmvcrest.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nehaspring.springmvcrest.api.v1.model.ProductDTO;
import com.nehaspring.springmvcrest.domain.Product;

@Mapper
public interface ProductMapper {

	public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	Product productDTOToProduct(ProductDTO productDTO);
	ProductDTO productToProductDTO(Product product);
}
