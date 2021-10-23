package com.ivan.microcalculadora.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.microcalculadora.model.Calculadora;
import com.ivan.microcalculadora.services.CalculadoraService;

@RestController
@RequestMapping("/resuldado")
public class CalculadoraResource {
	
	@Autowired
	private CalculadoraService service;
	
	@GetMapping("/{tabelaId}/multiplique/{dias}")
	private ResponseEntity<Calculadora> getPayment(@PathVariable Long tabelaId, @PathVariable Integer dias) {
		Calculadora calculadora = service.getCalculo(tabelaId, dias);
		return ResponseEntity.ok(calculadora);
	}
}
