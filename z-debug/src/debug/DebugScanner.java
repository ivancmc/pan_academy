package debug;

import java.util.Locale;
import java.util.Scanner;

public class DebugScanner {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Largura..");
		double largura = sc.nextDouble();
		System.out.println("Comprimento..");
		double comprimento = sc.nextDouble();
		System.out.println("Preço por m²..");
		double metroQuadrado = sc.nextDouble();
		
		double area = largura * comprimento;
		double preco = area * metroQuadrado;
		System.out.printf("Area = %.2f%n", area);
		System.out.printf("Preço = %.2f%n", preco);
		sc.close();
	}

}
