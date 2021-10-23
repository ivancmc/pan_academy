package com.ivan.microtabela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivan.microtabela.model.Tabela;

public interface TabelaRepository extends JpaRepository<Tabela, Long> {

}
