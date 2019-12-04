package Conexion;
import java.sql.*;

public class PruebaConexion {
	
private static Connection cn;
	
	public static Connection getConnection() {
		
		try {
			
			System.out.println("Pirulo");
			Class c=Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("nnn"+c.toString());
			cn=DriverManager.getConnection("jdbc:sqlserver://CRISTIAN-PC\\SQLEXPRESS:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
			
		}catch(Exception e){
			System.out.println("Error"+e.getMessage());
			cn=null;
		}
		
		return cn;
	}
	
	public static void main(String[] args) {
		
		Connection pruebaCn= PruebaConexion.getConnection();
		
		if(pruebaCn!=null){
			System.out.println("Conectado");
			System.out.println(pruebaCn);
		}else{
			System.out.println("Desconectado");
		}
	}
	

}
