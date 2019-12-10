package Desarrollo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ColoresExcluidos {
	
	public boolean ejecutar(Usuario username,Prenda p1, Prenda p2) throws SQLException {
		
		boolean salida;
		Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
		CallableStatement miSentencia = cn.prepareCall("{call SP_COMBINACION_EXCLUIDA(?,?,?,?,?,?)}");
		
		miSentencia.setString(1, username.getCodigoUsuario());
		miSentencia.setInt(2, p1.getColorPrimario().getCodColor());
		miSentencia.setInt(3, p1.getColorSecundario().getCodColor());
		miSentencia.setInt(4, p2.getColorPrimario().getCodColor());
		miSentencia.setInt(5, p2.getColorSecundario().getCodColor());
		miSentencia.registerOutParameter(6, Types.BIT);
		miSentencia.execute();
		
		salida = miSentencia.getBoolean(4);
	
		return salida;
	}
}	
	



