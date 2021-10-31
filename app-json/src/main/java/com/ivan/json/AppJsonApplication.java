package com.ivan.json;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppJsonApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(AppJsonApplication.class, args);
		
		JSONObject jsonzinho = new JSONObject();
		
		jsonzinho.put("Nome", "Julio");
		jsonzinho.put("Sobrenome", "Smith");
		jsonzinho.put("Idade", 25);
		jsonzinho.put("Nome", "Julio");
		jsonzinho.put("Sobrenome", "Smith");
		jsonzinho.put("Idade", 25);
		
		System.out.println(jsonzinho);
		
		PrintWriter salvar = new PrintWriter("./src/main/java/teste2.json");
		salvar.write(jsonzinho.toJSONString());
		
		salvar.flush();
		salvar.close();
	}

}
