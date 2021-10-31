package com.ivan.json;

import java.io.FileNotFoundException;

// Java program to read JSON from a file

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Leitura {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		Object obj = new JSONParser().parse(new FileReader("./src/main/java/teste2.json"));

		JSONObject jsonzinho = (JSONObject) obj;

		Iterator<String> chaves = jsonzinho.keySet().iterator();

		while (chaves.hasNext()) {
			String chave = chaves.next();
			System.out.println(chave + ": " + jsonzinho.get(chave));
		}

	}
}
