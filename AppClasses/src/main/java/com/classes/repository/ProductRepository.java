package com.classes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classes.tables.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{

}
