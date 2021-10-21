import java.util.HashMap;

public class HashIfFor {

    public static void main(String[] args) {
        HashMap<String, String> capitais = new HashMap<String, String>();
        capitais.put("Inglaterra", "Londres");
        capitais.put("Alemanha", "Berlim");
        capitais.put("Brasil", "Brasilia");

        for (String i : capitais.values()){
            if( i != "Londres") {
                System.out.println(i);
            }
        }
    }
}
