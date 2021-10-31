package for_json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class Programa {

    public static void main(String[] args) throws IOException {

    	 String json
         = String.join(" ",
                 Files.readAllLines(
                         Paths.get("./src/for_json/config.json"),
                         StandardCharsets.UTF_8)
         );

 Config config = new Gson().fromJson(json, Config.class);
 

 System.out.println(config.getNome());
 System.out.println(config.getIdade());

 
 

 

}
}
