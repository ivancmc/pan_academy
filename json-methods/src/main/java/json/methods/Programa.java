package json.methods;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// implementa maneiras de transformar JSON em objetos Java 
import org.json.*;

public class Programa {

	public static void main(String[] args) {
		// JSONObjectToArray();
		// JSONExampleArray1();
		// JSONExampleArray2();
		// JSONExampleStringer();
		// JSONExampleObject1();
		// JSONExampleObject2();
		// JSONExampleObject3();
		// JSONExamplWriter();
		// XMLToExampleConversion();
		// XMLFromExampleConversion();
		// CookieToExampleConversion();
		// CookieFromExampleConversion();
		// HTTPToExampleConversion();
		// HTTPFromExampleConversion();
		// CDLToExampleConversion();
		// CDLFromExampleConversion();
		// PropertyToExampleConversion();
		// PropertyFromExampleConversion();
	}
	
	// Criando um documento JSON

	// Cria um JSONObject a partir de uma String contendo um array usando JSONArray
	private static void JSONExampleArray1() {
		// Declara um array em uma String
		String arrayStr = "[" + "true," + "false," + "\"true\"," + "\"false\"," + "\"hello\"," + "23.45e-4,"
				+ "\"23.45\"," + "42," + "\"43\"," + "[" + "\"world\"" + "]," + "{" + "\"key1\":\"value1\","
				+ "\"key2\":\"value2\"," + "\"key3\":\"value3\"," + "\"key4\":\"value4\"" + "}," + "0," + "\"-1\""
				+ "]";

		// configura o arrayStr como JSONArray passando pelo construtor e imprime
		JSONArray array = new JSONArray(arrayStr);
		System.out.println("Values array: " + array);

		// Cria um JSONArray de chaves e imprime
		JSONArray list = listNumberArray(array.length());
		System.out.println("Label Array: " + list.toString());
		
		// Faz o mapeamento de chave e valor tranformando em JSONObject e imprime
		JSONObject object = array.toJSONObject(list);
		System.out.println("Final JSONOBject: " + object);
	}

	// Esse metodo cria um JSONArray de chaves
	private static JSONArray listNumberArray(int max) {
		// instancia um JSONArray
		JSONArray res = new JSONArray();
		// Percorre os indices de 0 até que i seja menor do que o parametro passado
		for (int i = 0; i < max; i++) {
			// Adiciona o indice como String no JSONArray
			res.put(String.valueOf(i));
		}
		// Retorna um JSONArray contendo os indices como String
		return res;
	}

	// Cria um JSONObject a partir de um JSONArray de valores
	private static void JSONExampleArray2() {

		// instancia um JSONArray
		JSONArray array = new JSONArray();

		// Adiciona valores de diversos tipos
		array.put("value");
		array.put(5);
		array.put(-23.45e67);
		array.put(true);

		// Cria um JSONArray de chaves
		JSONArray list = listNumberArray(array.length());
		// Faz o mapeamento de chave (indice) e valor e imprime
		JSONObject object = array.toJSONObject(list);
		System.out.println("Final JSONOBject: " + object);
	}

	// Cria um JSONObject a partir de um JSONStringer com chaves e valores
	private static void JSONExampleStringer() {
		// instancia o JSONStringer
		JSONStringer jsonStringer = new JSONStringer();

		// Inicia o processo de adicionar elementos com o .object()
		jsonStringer.object();

		// Adiciona elementos de diversos tipos como chave e valor
		jsonStringer.key("trueValue").value(true);
		jsonStringer.key("falseValue").value(false);
		jsonStringer.key("nullValue").value(null);
		jsonStringer.key("stringValue").value("hello world!");
		jsonStringer.key("complexStringValue").value("h\be\tllo w\u1234orld!");
		jsonStringer.key("intValue").value(42);
		jsonStringer.key("doubleValue").value(-23.45e67);

		// Encerra o processo de adicao com .endObject
		jsonStringer.endObject();

		// Transforma o jsonStringer numa String
		String str = jsonStringer.toString();
		// instancia um JSONObject passando uma string pelo construtor e imprime
		JSONObject jsonObject = new JSONObject(str);
		System.out.println("Final JSONOBject: " + jsonObject);
	}

	// Cria um JSONObject a partir de uma String em formato de JSON
	private static void JSONExampleObject1() {

		// Cria uma string em formato de JSON
		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		// Cria um JSONObject a partir de uma String com o construtor da classe e imprime
		JSONObject example = new JSONObject(string);
		System.out.println("Final JSONObject: " + example);

	}

	// Cria um JSONObject diretamente
	private static void JSONExampleObject2() {

		// instancia um JSONObject
		JSONObject example = new JSONObject();

		// Adiciona pares de chave (string) e valor (diversos tipos)
		example.put("key", "value");
		example.put("key2", 5);
		example.put("key3", -23.45e67);
		example.put("trueValue", true);

		// mostra que nao pode adicionar valor null
		// example.put("nullValue", null); //Isso nao eh possivel

		// imprime
		System.out.println("Final JSONOBject: " + example);
	}

	// Cria um JSONObject com um Map
	private static void JSONExampleObject3() {

		// instancia um Map de String (chave) e Double (valor)
		Map<String, Double> map = new HashMap<String, Double>();

		//Adiciona os pares
		map.put("key1", 1.0);
		map.put("key2", -23.45e67);

		// Cria o JSONObject passando o map no construtor e imprime
		JSONObject example = new JSONObject(map);
		System.out.println("Final JSONOBject: " + example);
	}

	// Cria um JSONWriter com StringBuilder
	private static void JSONExamplWriter() {

		// instancia um StringBuilder
		StringBuilder write = new StringBuilder();
		// instancia um JSONWriter a partir do StringBuilder vazio
		JSONWriter jsonWriter = new JSONWriter(write);

		// inicia o processo de adicao semelhante ao JSONStringer
		jsonWriter.object();

		// adiciona os pares de chave e valor
		jsonWriter.key("trueValue").value(true);
		jsonWriter.key("falseValue").value(false);
		jsonWriter.key("nullValue").value(null);
		jsonWriter.key("stringValue").value("hello world!");
		jsonWriter.key("complexStringValue").value("h\be\tllo w\u1234orld!");
		jsonWriter.key("intValue").value(42);
		jsonWriter.key("doubleValue").value(-23.45e67);

		// encerra o processo de adicao
		jsonWriter.endObject();

		// imprime o StringBuilder que foi modificado pelo JSONWriter
		System.out.println("JSON: " + write.toString());
	}

	// Cria um JSONObject e um JSONArray a partir de um JSONTokener
	private static void JSONExampleTokener() {

		// cria uma string sem formato de json
		String string = "this is not a valid JSON string";
		JSONTokener token = new JSONTokener(string);

		// Passa o token para o JSONObject e para o JSONArray
		JSONObject object = new JSONObject(token);
		JSONArray array = new JSONArray(token);

	}
	
	// Conversao para JSONArray

	// Cria um JSONArray a partir de uma String em formato de JSON
	private static void JSONObjectToArray() {
		// cria uma string em formato de json
		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";

		// instancia um JSONObject a partir da string
		JSONObject example = new JSONObject(string);

		// cria um array de chaves (indice)
		JSONArray keyStrings = listNumberArray(example.length());

		// obtem um array somente com os valores e imprime
		JSONArray array = example.toJSONArray(keyStrings);
		System.out.println("Final JSONArray: " + array);
	}
	
	// Conversao de XML

	// Cria um XML a partir de uma String em formato de JSON
	private static void XMLToExampleConversion() {

		// cria uma string em formato de json
		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		
		// instancia um JSONObject a partir da string
		JSONObject example = new JSONObject(string);

		// obtem uma string com formato de XML atraves do JSONObject e imprime
		String output = XML.toString(example);
		System.out.println("Final XML: " + output);
	}

	// Cria um JSONObject a partir de uma string em formato de XML
	private static void XMLFromExampleConversion() {

		// cria uma string em formato de XML
		String string = "<0>value</0><1>5</1><2>-2.345E+68</2><3>true</3>";

		// instancia um JSONObject a partir da string e imprime
		JSONObject output = XML.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}

	// Conversao de Cookie
	
	// Cria uma string no formato de Cookie a partir de uma String em formato de JSON
	private static void CookieToExampleConversion() {

		// cria uma string em formato de json
		String string = "{\"name\":\"Cookie-Name\",\"value\":\"name\",\"1\":5,\"2\":-2.345E68,\"3\":'true'}";
		
		// instancia um JSONObject a partir da string
		JSONObject example = new JSONObject(string);

		// obtem uma String com formato de Cookie e imprime
		String output = Cookie.toString(example);
		System.out.println("Final Cookie: " + output);
	}

	// Cria um JSONObject a partir de uma string em formato de Cookie
	private static void CookieFromExampleConversion() {

		// cria uma string em formato de Cookie
		String string = "Cookie-Name=name;1=5;2=-2.345E%2b68;3=true";

		// converte a string em formato de Cookie e imprime
		JSONObject output = Cookie.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}

	// Conversao de HTTP
	
	// Cria uma string em formato HTTP a partir de uma string em formato de JSON
	private static void HTTPToExampleConversion() {

		// cria uma string em formato de JSON
		String string = "{\"Method\":\"POST\",\"Request-URI\":'/',\"HTTP-Version\":'HTTP/1.1',\"Value1\":true,\"Value2\":2,\"Value3\":-2.345E68}";

		// instancia um JSONObject a partir da string
		JSONObject example = new JSONObject(string);

		// obtem uma string no formato HTTP e imprime
		String output = HTTP.toString(example);
		System.out.println("Final HTTP: " + output);
	}

	// Cria um JSONObject a partir de uma string em formato HTTP
	private static void HTTPFromExampleConversion() {

		// cria uma string em formato HTTP
		String string = "Final HTTP: POST '/' HTTP/1.1 Value3: -2.345E+68 Value1: true Value2: 2";

		// converte a string HTTP em JSONObject e imprime
		JSONObject output = HTTP.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}

	// Conversao de CDL

	// Cria uma string em formato CDL a partir de 2 strings em formato JSON
	private static void CDLToExampleConversion() {

		// cria duas strings em formato de JSON e converte para JSONObject
		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);
		String string2 = "{\"0\":\"value2\",\"1\":6,\"2\":-8.345E68,\"3\":false}";
		JSONObject example2 = new JSONObject(string2);

		// Cria um JSONArray a partir dos dois objetos JSON
		JSONArray array = new JSONArray();
		array.put(example);
		array.put(example2);

		// obtem uma string em formato CDL a partir do array de JSON e imprime
		String output = CDL.toString(array);
		System.out.println("Final CDL: \r\n" + output);
	}

	// Cria um JSONArray a partir de uma string em formato CDL
	private static void CDLFromExampleConversion() {

		// cria uma string em formato CDL
		String string = "0,1,2,3\n" + "value,5,-2.345E+68,true\n" + "value2,6,-8.345E+68,false";

		// instancia um JSONArray atraves da string e imprime
		JSONArray output = CDL.toJSONArray(string);
		System.out.println("Final JSONArray: " + output);
	}

	// Conversao de properties

	// Retorna um Properties a partir de uma string em formato JSON
	private static Properties PropertyToExampleConversion() {

		// cria uma string em formato JSON e converte em JSONObject
		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		// Obtem uma string em formato Properties a partir do JSON e imprime
		Properties output = Property.toProperties(example);
		System.out.println("Final Properties: " + output);

		// retorna o objeto Properties
		return output;
	}

	// Cria um JSONObject a partir de um Properties
	private static void PropertyFromExampleConversion() {

		// recebe um objeto Properties obtido no metodo anterior
		Properties input = PropertyToExampleConversion();

		//converte o Properties em JSON e imprime
		JSONObject output = Property.toJSONObject(input);
		System.out.println("Final JSONObject: " + output);
	}

}
