package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.TarefasModel;

import java.util.List;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
	
	public List<TarefasModel> findAllByTarefaContainingIgnoreCase(String tarefa);
	
	public List<TarefasModel> findByTarefaAndId(String tarefa, Long id);

	public List<TarefasModel> findByTarefaOrId(String tarefa, Long id);
	
	@Query(value = "SELECT * FROM TAREFAS_MODEL",
			nativeQuery = true)
	public List<TarefasModel> procuraTodos();
}
