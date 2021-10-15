package model;

import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tarefas {

	@GeneratedValue
	@Column
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String tarefa;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarefa() {
		return tarefa;
	}

	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}

	public Calendar getDataNascimentoCalendar() {
		return createdAt;
	}

	public void setDataNascimentoCalendar(Calendar dataNascimentoCalendar) {
		this.createdAt = dataNascimentoCalendar;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
