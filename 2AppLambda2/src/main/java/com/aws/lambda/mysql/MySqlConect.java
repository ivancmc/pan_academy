package com.aws.lambda.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.lambda.mysql.data.RequestDetails;
import com.aws.lambda.mysql.data.ResponseDetails;
import com.amazonaws.services.lambda.runtime.Context;
public class MySqlConect implements RequestHandler<RequestDetails, ResponseDetails>
{
	
	//connecta
	private Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
				String url = "jdbc:mysql://database-1:3306";
				String username = "admin";
				String password = "12345678";
				Connection conn = DriverManager.getConnection(url, username, password);
				return conn;
	}
	
//usa a conexao para inserir
	private void insertDetails(RequestDetails requestDetails, ResponseDetails responseDetails) throws SQLException {
		//pega a conexao
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		// pega a instancia
		Connection connection = getConnection();
		//cria o estado
		Statement statement = connection.createStatement();
		//passa a query de baixo
		String query = getquery(requestDetails);
		int responseCode = statement.executeUpdate(query);
		if(1 == responseCode)
		{
			responseDetails.setMessageID(String.valueOf(responseCode));
			responseDetails.setMessageReason("Mensagem inserida com sucesso!");
		}
		
	}
	private String getquery(RequestDetails requestDetails) {
		
		String query = "INSERT INTO dblambda.tb_ivan(id, message) VALUES (";
		
		query = query.concat("'" + requestDetails.getId() + "','"  + requestDetails.getMessage() + "')");
		
		//INSERT INTO dblambda.tb_ivan(id, message) VALUES (' getID  ', 'getMessage');
	
		return query;
	}
	public ResponseDetails handleRequest(RequestDetails requestDetails, Context arg1) {
		
		
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			insertDetails(requestDetails, responseDetails);
		} catch (SQLException sqlException) {
			responseDetails.setMessageID("=(");
			responseDetails.setMessageReason("Putz, deu erro "+sqlException);
		}
		return responseDetails;
}
	
}