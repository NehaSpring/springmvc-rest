package com.nehaspring.springmvcrest.controllers.v1;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nehaspring.springmvcrest.api.v1.model.CategoryDTO;
import com.nehaspring.springmvcrest.api.v1.model.CategoryListDTO;
import com.nehaspring.springmvcrest.services.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Fruit Categories")
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

	@Autowired
	private MessageSource messageSource;
	
	private final CategoryService categoryService;
	

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@ApiOperation(value = "Returns list of Fruit Categories ")
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public CategoryListDTO getAllCategories() {
				
		return new CategoryListDTO(categoryService.getAllCategory());		
	}
	
	
	@GetMapping("/{name}")
	@ResponseStatus(code = HttpStatus.OK)
	public CategoryDTO getCategoryByName(@PathVariable String name) {
		
		return categoryService.getCategoryByName(name);
		
	}

	@GetMapping("/i18n")
	@ResponseStatus(code = HttpStatus.OK)
	public String sayGoodMornig(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.msg", null ,locale);
	}
	
	
}
