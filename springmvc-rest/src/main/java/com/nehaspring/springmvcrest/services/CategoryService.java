package com.nehaspring.springmvcrest.services;

import java.util.List;

import com.nehaspring.springmvcrest.api.v1.model.CategoryDTO;
import com.nehaspring.springmvcrest.api.v1.model.CustomerDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategory();
	CategoryDTO getCategoryByName(String name);
	
}
