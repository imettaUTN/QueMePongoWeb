package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class UsuarioDAO {
	
	public boolean ejecutar(String username, String password) throws SQLException {
		
		boolean salida;
		Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
		CallableStatement miSentencia = cn.prepareCall("{call SP_VALIDAR_LOGIN(?,?,?)}");
		
		miSentencia.setString(1, username);
		miSentencia.setString(2, password);
		miSentencia.registerOutParameter(3, Types.BIT);
		miSentencia.execute();
		
		salida = miSentencia.getBoolean(3);
	
		return salida;
	}
}	
