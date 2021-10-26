package entradas;

import java.util.Scanner;

public class LerScanner {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter username:");
		
		String userName = myObj.nextLine();
		System.out.println("Username is " + userName);
		
		System.out.println("Enter age:");
		Integer age = myObj.nextInt();
		System.out.println("Your age is " + age.toString());
		myObj.close();
	}

}
