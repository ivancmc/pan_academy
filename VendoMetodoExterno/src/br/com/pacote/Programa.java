package br.com.pacote;

import java.lang.reflect.Method;

public class Programa {

	public static void main(String[] args) {
		try {
			Object obj = Class.forName("br.com.pacote.Pessoa").newInstance();
			Method met = obj.getClass().getDeclaredMethod("pegarNome", String.class);
			met.setAccessible(true);
			
			String nome = (String) met.invoke(obj, "teste");
			System.out.println(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
