package com.nehaspring.springmvcrest.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nehaspring.springmvcrest.api.v1.mapper.CategoryMapper;
import com.nehaspring.springmvcrest.api.v1.model.CategoryDTO;
import com.nehaspring.springmvcrest.api.v1.model.CustomerDTO;
import com.nehaspring.springmvcrest.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		
		return categoryRepository.findAll()
								 .stream()
								 .map(categoryMapper::categoryToCategoryDTO)
								 .collect(Collectors.toList());
	}

	@Override
	public CategoryDTO getCategoryByName(String name) {
		CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(
									categoryRepository.findByName(name));
		return categoryDTO;
	}

	

}
