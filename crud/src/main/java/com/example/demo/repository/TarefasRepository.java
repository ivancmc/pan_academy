package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TarefasModel;

import java.util.List;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
	
	public List<TarefasModel> findAllByTarefaContainingIgnoreCase(String tarefa);
}
