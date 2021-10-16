package estaticos.metodos2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Programa {

	public static void main(String[] args) {
		System.out.println(Produto.resultado(10, 50));
		Produto prod = new Produto();
		System.out.println(prod.mudeNomeProduto("João"));
		System.out.println(Produto.pegarCpf("   999-222-333-22 "));
	}

}
