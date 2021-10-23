package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ClienteModel;
import com.example.demo.model.TarefasModel;
import com.example.demo.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/listar/clientes")
	public List<ClienteModel> findAll() {
		return clienteRepository.findAll();
	}
	
	@PostMapping("/salvar/clientes")
	public ResponseEntity<ClienteModel> post(@RequestBody ClienteModel clientinho) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clientinho));
	}
	
	@GetMapping("/listar/clientes/todos")
	public ResponseEntity<List<ClienteModel>> todosClientes() {
		return ResponseEntity.ok(clienteRepository.procuraTodos());
	}
	
	@GetMapping("/listar/clientes/{tipo}")
	public ResponseEntity<List<ClienteModel>> filterByTipo(@PathVariable Integer tipo) {
		return ResponseEntity.ok(clienteRepository.procuraTipoPessoas(tipo));
	}
	
	@GetMapping("/listar/clientes/sql/alfabetico")
	public List<ClienteModel> procuraTodosAlfabetico() {
		return clienteRepository.procuraTodosAlfabetico();
	}
}
