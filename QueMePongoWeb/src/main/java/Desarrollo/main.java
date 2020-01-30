package Desarrollo;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import Repositorio.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Desarrollo.Enumerados.EnumCategoria;
import Repositorio.*;

public class main {

	public static void main(String[] args) throws IOException, SQLException {
		
		System.out.println("Persistencia Iniciada.");
		
		JPAUtil jpa = new JPAUtil();
		Usuario usuario = new Usuario();
		Guardarropa guardarropa = new Guardarropa();
		
		usuario = jpa.transaccion().usuario().buscarPorId("Ezequiel");
		guardarropa = usuario.obtenerGuardarropa(0);
		guardarropa.setAdministrador(usuario);
		
		guardarropa.setPrendasDisponibles(jpa.transaccion().prenda().listado(guardarropa.getId()));
		
		System.out.println("Cantidad de Prendas:" + guardarropa.cantidadDePrendas());
		
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
	
		System.out.print("Cantidad de Prendas en el Guardarropas: " + guardarropa.cantidadDePrendas() + "\n");
		
		sugerencias = guardarropa.recomendacion(35, 37);
		
		System.out.print("Cantidad de Sugerencias: " + sugerencias.size() + "\n");
		
		int contador=1;
		
		for(Sugerencia sugerencia:sugerencias){
			
			System.out.println("Combinación: " + contador + "\n");
			
			System.out.println("Prendas Combinanadas:" + sugerencia.prendasSugeridas.size());
			
			if(sugerencia.getMaxCapaSuperior() == 4) {
				
				System.out.println("Parte Superior Capa 4:" + sugerencia.prendasSugeridas.get(14).getCodPrenda());
				System.out.println("Parte Superior Capa 3:" + sugerencia.prendasSugeridas.get(13).getCodPrenda());
				System.out.println("Parte Superior Capa 2:" + sugerencia.prendasSugeridas.get(12).getCodPrenda());
				System.out.println("Parte Superior Capa 1:" + sugerencia.prendasSugeridas.get(11).getCodPrenda());
			}
			
			if(sugerencia.getMaxCapaSuperior() == 3) {
				
				System.out.println("Parte Superior Capa 3:" + sugerencia.prendasSugeridas.get(13).getCodPrenda());
				System.out.println("Parte Superior Capa 2:" + sugerencia.prendasSugeridas.get(12).getCodPrenda());
				System.out.println("Parte Superior Capa 1:" + sugerencia.prendasSugeridas.get(11).getCodPrenda());
			}
			
			if(sugerencia.getMaxCapaSuperior() == 2) {
				
				System.out.println("Parte Superior Capa 2:" + sugerencia.prendasSugeridas.get(12).getCodPrenda());
				System.out.println("Parte Superior Capa 1:" + sugerencia.prendasSugeridas.get(11).getCodPrenda());
			}
			
			if(sugerencia.getMaxCapaSuperior() == 1) {
				
				System.out.println("Parte Superior Capa 1:" + sugerencia.prendasSugeridas.get(11).getCodPrenda());
			}
			
			if(sugerencia.getMaxCapaInferior() == 2) {
				
				System.out.println("Parte Inferior Capa 2:" + sugerencia.prendasSugeridas.get(22).getCodPrenda());
				System.out.println("Parte Inferior Capa 1:" + sugerencia.prendasSugeridas.get(21).getCodPrenda());
			}
			
			if(sugerencia.getMaxCapaInferior() == 1) {
				
				System.out.println("Parte Inferior Capa 1:" + sugerencia.prendasSugeridas.get(21).getCodPrenda());
			}
			
				System.out.println("Calzado:" + sugerencia.prendasSugeridas.get(31).getCodPrenda());
			
				contador++;
		}
		
	}
	
	
}	

