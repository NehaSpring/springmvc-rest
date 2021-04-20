package com.nehaspring.springmvcrest.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nehaspring.springmvcrest.api.v1.mapper.CategoryMapper;
import com.nehaspring.springmvcrest.api.v1.model.CategoryDTO;
import com.nehaspring.springmvcrest.domain.Category;
import com.nehaspring.springmvcrest.repositories.CategoryRepository;

class CategoryServiceTest {

	public static final String NAME = "Alex";
	public static final Long ID = 11L;
	
	CategoryService categoryService;
	
	@Mock
	CategoryRepository categoryRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		categoryService = new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
		
	}

	@Test
	void testGetAllCategory() {
		
		//mock category list
		List<Category> mockCategories = new ArrayList<>();
			mockCategories.add(new Category());
			mockCategories.add(new Category());
			mockCategories.add(new Category());
			mockCategories.add(new Category());
			
	   when(categoryRepository.findAll()).thenReturn(mockCategories);
	   
	   List<CategoryDTO> categoryDTOs = categoryService.getAllCategory();
	   
	   assertEquals(4, categoryDTOs.size());
	   
		
	}

	@Test
	void testGetCategoryByName() {
		//mock category by name
		
		Category mockCategory = new Category();
			mockCategory.setId(ID);
			mockCategory.setName(NAME);
			
		when(categoryRepository.findByName(NAME)).thenReturn(mockCategory);
		
		CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);
		
		assertEquals(NAME, categoryDTO.getName());
	}

}
