package com.nehaspring.springmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nehaspring.springmvcrest.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);
}
