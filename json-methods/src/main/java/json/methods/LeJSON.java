package json.methods;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class LeJSON 
{
	// suprime os avisos
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        //objeto para converter a leitura do arquivo em JSON
        JSONParser jsonParser = new JSONParser();
         
        // Tenta fazer a leitura do arquivo
    	// le o conteudo do arquivo passado como parametro
        try (FileReader reader = new FileReader("./turma.json"))
        {        	
            // faz a conversao do texto do arquivo para obj
            Object obj = jsonParser.parse(reader);
 
            // converte o obj em array JSON e imprime
            JSONArray turma = (JSONArray) obj;
            System.out.println(turma);
             
            //itera sobre o array turma e converse cada item em um obj JSON
            turma.forEach( al -> converteEmObjAluno( (JSONObject) al ) );
 
        } catch (FileNotFoundException e) {
        	// se o arquivo nao for encontrado, imprime a pilha de erros lancados pela excecao
            e.printStackTrace();
        } catch (IOException e) {
        	// se der erro de entrada e saida, imprime a pilha de erros lancados pela excecao
            e.printStackTrace();
        } catch (ParseException e) {
        	// se der erro de conversao, imprime a pilha de erros lancados pela excecao
            e.printStackTrace();
        }
    }
 
    private static void converteEmObjAluno(JSONObject aluno) 
    {
        // pega o obj aluno dentro da lista
        JSONObject alunoObj = (JSONObject) aluno.get("Aluno");
         
        // pega o nome do aluno e imprime
        String nome = (String) alunoObj.get("Nome");    
        System.out.println(nome);
         
        // pega a nota do aluno e imprime
        String nota = (String) alunoObj.get("Nota");  
        System.out.println(nota);
         
        // pega o campo aprovado do aluno e imprime
        String aprovado = (String) alunoObj.get("Aprovado");    
        System.out.println(aprovado);
    }
}
