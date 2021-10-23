package com.ivan.microcalculadora.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ivan.microcalculadora.model.Calculadora;
import com.ivan.microcalculadora.model.Tabela;

@Service
public class CalculadoraService {
	
//	@Value("http://localhost:8004")
	@Value("${micro_tabela.host}")
	private String microTabela;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Calculadora getCalculo(Long tabelaId, Integer dias) {
		Map<String, String> urlParametros = new HashMap<String, String>();
		urlParametros.put("id", tabelaId.toString());
		Tabela tabela = restTemplate.getForObject(microTabela+"/tabela/{id}", Tabela.class, urlParametros);
		return new Calculadora(tabela.getPessoa(), tabela.getPrecoPorDia(), dias);
	}
}
