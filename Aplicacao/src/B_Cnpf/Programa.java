package B_Cnpf;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Regex.adicionarMascara("1234567890123"));
		System.out.println(Regex.adicionarMascara("66674085000100"));
		System.out.println(Regex.adicionarMascaraCpf("1234567890123"));
		System.out.println(Regex.adicionarMascaraCpf("59432696065"));
		System.out.println(Regex.limpar("594.326.960-65"));
	}

}
