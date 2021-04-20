package com.nehaspring.springmvcrest.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.nehaspring.springmvcrest.api.v1.model.CategoryDTO;
import com.nehaspring.springmvcrest.domain.Category;

class CategoryMapperTest {

	CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
	
	@Test
	void testCategoryToCategoryDTO() throws Exception{
		
		//given
		Category category = new Category();
		category.setId(11L);
		category.setName("Alex");
		
		//When
		
		CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
		
		//then
		assertEquals(Long.valueOf(11L), categoryDTO.getId());
		assertEquals("Alex", categoryDTO.getName());
		
	}

}
