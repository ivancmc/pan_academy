package app.datas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.datas.model.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

}
