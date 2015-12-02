package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	
	public static Connection connection;
	
	static{
		String endereco = "jdbc:mysql://localhost:3306/mecanica";
		String usuario = "root";
		String senha = "root";
		try{
			connection = DriverManager.getConnection(endereco, usuario, senha);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return connection;
}
}