package Desarrollo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class SugerenciasExcluidas {
	
	
	public boolean ejecutar(Usuario usuario, Sugerencia sugerencia) throws SQLException {
		
		boolean salida = false;
		Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
		CallableStatement miSentencia = cn.prepareCall("{call SP_COMBINACION_PRENDA_EXCLUIDA(?,?,?,?,?,?,?,?,?,?)}");
		
		miSentencia.setString(1, usuario.getCodigoUsuario());
		miSentencia.setInt(2, sugerencia.getParteSuperior1().getCodPrenda());
		miSentencia.setInt(3, sugerencia.getParteSuperior2().getCodPrenda());
		miSentencia.setInt(4, sugerencia.getParteSuperior3().getCodPrenda());
		miSentencia.setInt(5, sugerencia.getParteSuperior4().getCodPrenda());
		miSentencia.setInt(6, sugerencia.getParteInferior1().getCodPrenda());
		miSentencia.setInt(7, sugerencia.getParteInferior2().getCodPrenda());
		miSentencia.setInt(8, sugerencia.getParteCalzado().getCodPrenda());
		miSentencia.setInt(9, sugerencia.getParteAccesorio().getCodPrenda());
		miSentencia.registerOutParameter(10, Types.BIT);
		
		miSentencia.execute();
		salida = miSentencia.getBoolean(10);
		
		return salida;
	}
}	
