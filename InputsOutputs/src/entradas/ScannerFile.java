package entradas;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFile {

	public static void main(String[] args) throws IOException {
		String path = "./src/teste.txt";
		File arquivo = new File(path);
		Scanner sc = new Scanner(arquivo);
		int i = 1;
		while (sc.hasNext()) {
			System.out.println(i + sc.nextLine());
			i++;
		}
		sc.close();
	}

}
