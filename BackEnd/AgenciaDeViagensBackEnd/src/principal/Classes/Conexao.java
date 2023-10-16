package principal.Classes;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

 

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3306/agencia_de_viagens";

	private static final String USUARIO = "root";

	private static final String SENHA = "2002";

 

	public static Connection conectar() throws SQLException {

		return DriverManager.getConnection(URL, USUARIO, SENHA);

	}

}