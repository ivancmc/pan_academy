package json.methods;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
		JSONExamplWriter();
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

	private static void JSONExampleArray1() {
		// We create a JSONObject from a String containing an array using JSONArray
		// Firstly, we declare an Array in a String

		String arrayStr = "[" + "true," + "false," + "\"true\"," + "\"false\"," + "\"hello\"," + "23.45e-4,"
				+ "\"23.45\"," + "42," + "\"43\"," + "[" + "\"world\"" + "]," + "{" + "\"key1\":\"value1\","
				+ "\"key2\":\"value2\"," + "\"key3\":\"value3\"," + "\"key4\":\"value4\"" + "}," + "0," + "\"-1\""
				+ "]";

		// configura o arrayStr como JSONArray passando pelo construtor

		JSONArray array = new JSONArray(arrayStr);
		System.out.println("Values array: " + array);

		// Cria um JSONArray de chaves

		JSONArray list = listNumberArray(array.length());
		System.out.println("Label Array: " + list.toString());
		// Faz o mapeamento de chave > valor tranformando em JSONObject
		JSONObject object = array.toJSONObject(list);
		System.out.println("Final JSONOBject: " + object);
	}

	// Esse metodo cria um JSONArray de chaves

	private static JSONArray listNumberArray(int max) {
		JSONArray res = new JSONArray();
		for (int i = 0; i < max; i++) {
			// O valor dos labels devem ser String pra funcionar
			res.put(String.valueOf(i));
		}
		return res;
	}

	private static void JSONExampleArray2() {

		// Cria um JSONArray vazio

		JSONArray array = new JSONArray();

		// Adiciona valores com o .put()

		array.put("value");
		array.put(5);
		array.put(-23.45e67);
		array.put(true);

		// Converte em JSONObject provendo um array de chaves

		JSONArray list = listNumberArray(array.length());
		JSONObject object = array.toJSONObject(list);
		System.out.println("Final JSONOBject: " + object);
	}

	private static void JSONExampleStringer() {

		// instancia o JSONStringer

		JSONStringer jsonStringer = new JSONStringer();

		// Inicia o processo de adicionar elementos com o .object()

		jsonStringer.object();

		// Adiciona elementos como chava > valor

		jsonStringer.key("trueValue").value(true);
		jsonStringer.key("falseValue").value(false);
		jsonStringer.key("nullValue").value(null);
		jsonStringer.key("stringValue").value("hello world!");
		jsonStringer.key("complexStringValue").value("h\be\tllo w\u1234orld!");
		jsonStringer.key("intValue").value(42);
		jsonStringer.key("doubleValue").value(-23.45e67);

		// Encerra o procedimento com .ednObject

		jsonStringer.endObject();

		// Com JSONStringer, converte em JSONObject gerando uma String e passando pro
		// construtor do JSONObject

		String str = jsonStringer.toString();
		JSONObject jsonObject = new JSONObject(str);

		System.out.println("Final JSONOBject: " + jsonObject);
	}

	private static void JSONExampleObject1() {

		// Cria um JSONObject a partir de uma String com o construtor da classe

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);
		System.out.println("Final JSONObject: " + example);

	}

	private static void JSONExampleObject2() {

		// Tambem pode criar um JSONObject diretamente

		JSONObject example = new JSONObject();

		// Adiciona o par chave e valor
		example.put("key", "value");

		example.put("key2", 5);
		example.put("key3", -23.45e67);
		example.put("trueValue", true);

		// Porem nao pode adicionar valor null

		// example.put("nullValue", null); //Isso nao eh possivel

		System.out.println("Final JSONOBject: " + example);
	}

	private static void JSONExampleObject3() {

		// Tambem pode criar um JSONObject com um Map
		// A chave tem que ser String e o valor pode ser qualquer coisa

		Map<String, Double> map = new HashMap<String, Double>();

		map.put("key1", 1.0);
		map.put("key2", -23.45e67);

		// Cria o JSONObject passando o map no construtor

		JSONObject example = new JSONObject(map);
		System.out.println("Final JSONOBject: " + example);
	}

	private static void JSONExamplWriter() {

		// This method works in a very similar way to Object and Stringer in the
		// construction of the JSON.
		// The difference is that it needs a Java object called "Appendable" like
		// StringBuilder

		StringBuilder write = new StringBuilder();
		JSONWriter jsonWriter = new JSONWriter(write);

		// We behave now the same way as Stringer

		jsonWriter.object();

		jsonWriter.key("trueValue").value(true);
		jsonWriter.key("falseValue").value(false);
		jsonWriter.key("nullValue").value(null);
		jsonWriter.key("stringValue").value("hello world!");
		jsonWriter.key("complexStringValue").value("h\be\tllo w\u1234orld!");
		jsonWriter.key("intValue").value(42);
		jsonWriter.key("doubleValue").value(-23.45e67);

		jsonWriter.endObject();

		// The resoult should be in the "write" object

		System.out.println("JSON: " + write.toString());

		// The difference is that we don't get a JSONObject in this one.

	}

	private static void JSONExampleTokener() {

		// A partir de una String podemos crear un JSONTokener, que lo podemos usar
		// alternativamente para JSONArray,JSONObject

		String string = "this is not a valid JSON string";
		JSONTokener token = new JSONTokener(string);

		// Now you can use the token in JSONObject and Array the same way as a String

		JSONObject object = new JSONObject(token);
		JSONArray array = new JSONArray(token);

	}
	
	// Conversao para JSONArray

	private static void JSONObjectToArray() {
		// We start with a JSONObject

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";

		JSONObject example = new JSONObject(string);

		// We need a list of key strings like the reverse operation

		JSONArray keyStrings = listNumberArray(example.length());

		// Then we convert to the Array using both elelements

		JSONArray array = example.toJSONArray(keyStrings);

		System.out.println("Final JSONArray: " + array);
	}
	
	// Conversao de XML

	private static void XMLToExampleConversion() {

		// We start with a JSONObject

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		// We obtain a String with XML format with toString()

		String output = XML.toString(example);
		System.out.println("Final XML: " + output);
	}

	private static void XMLFromExampleConversion() {

		// We start with a string with the XML format

		String string = "<0>value</0><1>5</1><2>-2.345E+68</2><3>true</3>";

		// We obtain a JSONObject with toJSONOBject()

		JSONObject output = XML.toJSONObject(string);

		System.out.println("Final JSONObject: " + output);
	}

	// Conversao de Cookie
	
	private static void CookieToExampleConversion() {

		// We start with a JSONObject
		// The JSONOBject needs to entries that gives the cookie a name and gives the
		// field "name" a name too.
		// The Cokkie format doesn't support booleans

		String string = "{\"name\":\"Cookie-Name\",\"value\":\"name\",\"1\":5,\"2\":-2.345E68,\"3\":'true'}";
		JSONObject example = new JSONObject(string);

		// We obtain a String with Cookie format with toString()

		String output = Cookie.toString(example);
		System.out.println("Final Cookie: " + output);
	}

	private static void CookieFromExampleConversion() {

		// We start with a string with the Cookie format

		String string = "Cookie-Name=name;1=5;2=-2.345E%2b68;3=true";

		// We obtain a JSONObject with toJSONOBject()

		JSONObject output = Cookie.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}

	// Conversao de HTTP
	
	private static void HTTPToExampleConversion() {

		// We start with a JSONObject
		// The JSONObject must have the minimun header for a HTTP request or header

		String string = "{\"Method\":\"POST\",\"Request-URI\":'/',\"HTTP-Version\":'HTTP/1.1',\"Value1\":true,\"Value2\":2,\"Value3\":-2.345E68}";

		JSONObject example = new JSONObject(string);

		// We obtain a String with HTTP format with toString()

		String output = HTTP.toString(example);
		System.out.println("Final HTTP: " + output);
	}

	private static void HTTPFromExampleConversion() {

		// We start with a string with the HTTP format

		String string = "Final HTTP: POST '/' HTTP/1.1 Value3: -2.345E+68 Value1: true Value2: 2";

		// We obtain a JSONObject with toJSONOBject()

		JSONObject output = HTTP.toJSONObject(string);
		System.out.println("Final JSONObject: " + output);
	}

	// Conversao de CDL

	private static void CDLToExampleConversion() {

		// We start with some JSONObjects with the same values in the keys but different
		// values in the "values"

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		String string2 = "{\"0\":\"value2\",\"1\":6,\"2\":-8.345E68,\"3\":false}";
		JSONObject example2 = new JSONObject(string2);

		// We need now a JSONArray with those JSONObjects

		JSONArray array = new JSONArray();
		array.put(example);
		array.put(example2);

		// We obtain a String with XML format with toString()

		String output = CDL.toString(array);
		System.out.println("Final CDL: \r\n" + output);
	}

	private static void CDLFromExampleConversion() {

		// We start wtih a String with the CDL format

		String string = "0,1,2,3\n" + "value,5,-2.345E+68,true\n" + "value2,6,-8.345E+68,false";

		// We obtain a JSONArray with toJSONOBject()

		JSONArray output = CDL.toJSONArray(string);
		System.out.println("Final JSONArray: " + output);
	}

	// Conversao de properties

	private static Properties PropertyToExampleConversion() {

		// We start with a JSONObject

		String string = "{\"0\":\"value\",\"1\":5,\"2\":-2.345E68,\"3\":true}";
		JSONObject example = new JSONObject(string);

		// We obtain a String with Properties format with toString()

		Properties output = Property.toProperties(example);
		System.out.println("Final Properties: " + output);

		return output;
	}

	private static void PropertyFromExampleConversion() {

		//We start with a Properties object

		Properties input = PropertyToExampleConversion();

		//We obtain a JSONObject with toJSONOBject()

		JSONObject output = Property.toJSONObject(input);
		System.out.println("Final JSONObject: " + output);
	}

}
