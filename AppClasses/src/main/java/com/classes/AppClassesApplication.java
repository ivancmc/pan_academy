package com.classes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.classes.tables.Products;

@SpringBootApplication
public class AppClassesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppClassesApplication.class, args);
		
		Products product1 = new Products();
		product1.setDescription("Luva");
		product1.setValue(20.5);
		
		System.out.println(product1);
		System.out.println(product1.getDescription());
		System.out.println(product1.getValue());
	}
}
