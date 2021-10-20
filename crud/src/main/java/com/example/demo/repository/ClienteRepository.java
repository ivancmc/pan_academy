package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
	
	@Query(value = "SELECT * FROM CLIENTE_MODEL",
			nativeQuery = true)
	public List<ClienteModel> procuraTodos();
	
	@Query(value = "SELECT * FROM CLIENTE_MODEL c WHERE c.tipo = :tipo",
			nativeQuery = true)
	public List<ClienteModel> procuraTipoPessoas(Integer tipo);
}
