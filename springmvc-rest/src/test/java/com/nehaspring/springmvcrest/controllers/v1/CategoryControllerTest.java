package com.nehaspring.springmvcrest.controllers.v1;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nehaspring.springmvcrest.api.v1.model.CategoryDTO;
import com.nehaspring.springmvcrest.services.CategoryService;

class CategoryControllerTest {

	@Mock
	CategoryService categoryService;
	
	@InjectMocks
	CategoryController categoryController;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
	}

	@Test
	void testGetAllCategories() throws Exception {
		CategoryDTO cat1 = new CategoryDTO();
					cat1.setId(11L);
					cat1.setName("Alex");

		CategoryDTO cat2 = new CategoryDTO();
					cat2.setId(12L);
					cat2.setName("Ryden");	
					
					
		List<CategoryDTO> categories = new ArrayList<>();
			categories.add(cat1);
			categories.add(cat2);
			
		when(categoryService.getAllCategory()).thenReturn(categories);
		

		mockMvc.perform(get("/api/v1/categories/")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.categories",hasSize(2)));
		
		
	}

	@Test
	void testGetCategoryByName() throws Exception {
		
		CategoryDTO cat1 = new CategoryDTO();
			cat1.setId(11L);
			cat1.setName("Alex");
			
			when(categoryService.getCategoryByName(anyString())).thenReturn(cat1);
			
			mockMvc.perform(get("/api/v1/categories/Alex")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name",equalTo("Alex")));
	}

}
