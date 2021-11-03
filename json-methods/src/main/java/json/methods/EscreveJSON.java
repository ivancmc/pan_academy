package json.methods;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class EscreveJSON
{
	// suprime os avisos
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        // instancia um obj JSON 
        JSONObject fichaAluno1 = new JSONObject();
        
        // adiciona pares de chave e valor
        fichaAluno1.put("Nome", "João");
        fichaAluno1.put("Nota", "8,9");
        fichaAluno1.put("Aprovado", "Sim");
         
        // instancia outro obj JSON e insere o obj JSON anterior nele 
        JSONObject aluno1 = new JSONObject(); 
        aluno1.put("Aluno", fichaAluno1);
         
        // instancia um obj JSON 
        JSONObject fichaAluno2 = new JSONObject();
        // adiciona pares de chave e valor
        fichaAluno2.put("Nome", "Henrique");
        fichaAluno2.put("Nota", "6,5");
        fichaAluno2.put("Aprovado", "Não");
         
        // instancia outro obj JSON e insere o obj JSON anterior nele
        JSONObject aluno2 = new JSONObject(); 
        aluno2.put("Aluno", fichaAluno2);
         
        // Adiciona os dois objetos JSON preenchidos num array JSON
        JSONArray turma = new JSONArray();
        turma.add(aluno1);
        turma.add(aluno2);
         
        // Tenta escrever num arquivo chamado turma.json
    	// instancia o arquivo
        try (FileWriter file = new FileWriter("./turma.json")) {        	
            // escreve a string gerada a partir do array JSON no arquivo
            file.write(turma.toJSONString());
            // descarrega o fluxo de dados no arquivo, persistindo as alteracoes no disco
            file.flush();
            // encerra o fluxo de dados no arquivo
            file.close();
 
        } catch (IOException e) {
        	// se der erro de entrada e saida, imprime a pilha de erros lancados pela excecao
            e.printStackTrace();
        }
    }
}
