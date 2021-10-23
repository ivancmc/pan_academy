package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vinho;
import com.example.demo.repository.VinhoRepository;

@RestController
@RequestMapping("/api/vinhos")
public class VinhoResource {
	
	@Autowired
	private VinhoRepository vinhoRepository;
	
	@GetMapping
	private ResponseEntity<List<Vinho>> listar() {
		return ResponseEntity.ok().body(vinhoRepository.findAll());
	}
}
