package com.classes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classes.repository.ProductRepository;
import com.classes.tables.Products;

@RestController
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/produtos")
	private List<Products> buscarTodos() {
		return repository.findAll();
	}
}
