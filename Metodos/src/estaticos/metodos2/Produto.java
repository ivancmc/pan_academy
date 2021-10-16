package estaticos.metodos2;

public class Produto {

	public static int resultado(int arroz, int feijao) {
		return arroz + feijao;
	}
	
	public String mudeNomeProduto(String nomeProd) {
		return nomeProd;
	}
	
	public static String pegarCpf(String cpf) {
		String tratei = cpf.strip();
		return tratei;
	}
}
