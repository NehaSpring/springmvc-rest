package com.nehaspring.springmvcrest.api.v1.model;

import lombok.Data;

/*
 * Data Transfer Object. To expose your Domain object.
 * We use MapStruct to map this DTO's with Domain Model.
 * So we need not to expose our domain model directly
 */

@Data
public class CategoryDTO {

	private Long id;
	private String name;
}
