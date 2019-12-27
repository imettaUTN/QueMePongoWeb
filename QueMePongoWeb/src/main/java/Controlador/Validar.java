package Controlador;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import Modelo.*;

public class Validar {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
			String accion = request.getParameter("accion");
			
			if(accion.equalsIgnoreCase("Ingresar")) {
				
					boolean valida;
				
					String user = request.getParameter("txtUsuario");
					String pass = request.getParameter("txtPassword");
					
					UsuarioDAO userValida = new UsuarioDAO();
					valida = userValida.ejecutar(user, pass);
					
				
			}
			
		}	
		
}
