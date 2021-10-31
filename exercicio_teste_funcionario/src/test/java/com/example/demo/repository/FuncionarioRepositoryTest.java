package com.example.demo.repository;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Funcionario;


@RunWith(SpringRunner.class)
@DataJpaTest
public class FuncionarioRepositoryTest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private Funcionario funcionario;

	@Before
	public void start() {
		funcionario = new Funcionario("Fulano", "Financeiro", 4500.00);
	}
	
	@Test
	public void saveComNomeNuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("Nome deve ser preenchido!");

		funcionario.setNome(null);
		funcionarioRepository.save(funcionario);
	}

	@Test
	public void saveComDepartamentoNuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("Departamento deve ser preenchido!");

		funcionario.setDepartamento(null);
		funcionarioRepository.save(funcionario);
	}
	
	@Test
	public void saveComSalarioNuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("Salario nao pode ser nulo!");

		funcionario.setSalario(null);
		funcionarioRepository.save(funcionario);
	}
	
	@Test
	public void saveDeveSalvarFuncionario() {
		funcionarioRepository.save(funcionario);
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		Assert.assertEquals(1, funcionarios.size());
		funcionarioRepository.deleteAll();
	}
	
	@Test
	public void deleteByIdDeveRemoverFuncionario() {
		funcionarioRepository.save(funcionario);
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		Assert.assertEquals(1, funcionarios.size());

		funcionarioRepository.deleteById(funcionario.getId());
		List<Funcionario> resultado = funcionarioRepository.findAll();
		Assert.assertEquals(0, resultado.size());
	}
}
