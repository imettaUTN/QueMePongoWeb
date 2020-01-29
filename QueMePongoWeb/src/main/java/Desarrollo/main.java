package Desarrollo;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

import Repositorio.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Desarrollo.Enumerados.EnumCategoria;
import Repositorio.*;

public class main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Persistencia Iniciada.");
		
		JPAUtil jpa = new JPAUtil();
		Usuario usuario = new Usuario();
		
		usuario = jpa.transaccion().usuario().buscarPorId("Cristian");
		
		/*
		TipoPrenda tipo = new TipoPrenda(); //Remera
		tipo = jpa.transaccion().tipoPrenda().buscarPorId(3);
		
		Categoria categoria = new Categoria(); //Parte Superior
		categoria = jpa.transaccion().categorias().buscarPorId(1);
		*/
		
		System.out.println("Cantidad de Guardarropas:"+usuario.cantidadDeGuardarropas());
		
		Guardarropa g = new Guardarropa();
		List<Prenda> prendasDisponibles = new ArrayList<Prenda>();
		prendasDisponibles = jpa.transaccion().prenda().listado(11);
		
		g = usuario.obtenerGuardarropa(0);
		g.setPrendasDisponibles(prendasDisponibles);
	
		
		System.out.println("Cantidad de Prendas:"+g.cantidadDePrendas());
		
		for(Prenda p:prendasDisponibles) {
			
			System.out.println("Prendas: " + p.getDescripcion());
		}
		
		
		
		

		/*
		
		guardarropa = usuario.obtenerGuardarropa(0);
		System.out.println("Desc Guardarropa:" + guardarropa.getDescripcion());
		
		prenda.setGuardarropa(guardarropa);
		prenda.setDescripcion("Camiseta Suplente Nueva");
		prenda.setColorPrimario("Violeta");
		prenda.setColorSecundario("Blanco");
		prenda.setTipoPrenda(tipo);
		prenda.setCategoria(categoria);
		prenda.guardar();
		
		*/
		
		//System.out.println("Cantidad Prendas:" + usuario.obtenerGuardarropa(0).cantidadDePrendas());
		
		System.out.println("Persistencia Finalizada.");
		
		
		//usr.agregarGuardarropa(guardarropa);
		//usr.guardar();
		
		//System.out.println("Cantidad Guardarropas:"+usr.cantidadDeGuardarropas());
	
		/*
		
		Usuario usr = jpa.transaccion().usuario().buscarPorId("RomeroCris");
		
		System.out.println("Apellido:"+usr.getApellido());
		
		usr.setNombre("Cristian Ezequiel");
		usr.guardar();
		*/
		
		/*
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
			
			CallableStatement miSentencia = miConexion.prepareCall("{call SP_COMBINACION_EXCLUIDA(?,?,?,?)}");
			
			miSentencia.setString(1, "cromero");
			miSentencia.setInt(2, 4);
			miSentencia.setInt(3, 0);
			miSentencia.registerOutParameter(4, Types.BIT);
			miSentencia.execute();
		*/	
			
			/*
			while(rs.next()){
				
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			*/
		
			/*
			boolean salida = miSentencia.getBoolean(4);
			
			System.out.println("Salida: " + salida);
			*/
			
			//rs.close();
			
			/*
			
		}catch(Exception e) {
			
			System.out.print(e.getMessage());
		}
		
		*/
		
		/*
		Perfil perfil;
		final String PERSISTENCE_UNIT_NAME = "DDS";
		EntityManagerFactory emFactory;
		Repositorio repositorio;
		
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		repositorio = new Repositorio(emFactory.createEntityManager());
		
		// ****** Prueba de Persistencia de Perfil ******
		
		/*
		Perfil p1 = new Perfil();
		p1.setDescripcion("UsuarioComun");
		repositorio.perfil().persistir(p1);
		System.out.println("Proceso Finalizado.");
		System.out.println(p1.getDescripcion());
		
		
		Perfil p2 = new Perfil();
		p2 = repositorio.perfil().buscarPorId(2); 
		System.out.println("Perfil Encontrado: \n");
		System.out.println(p2.getDescripcion());
		*/
		
		// ****** Prueba de Persistencia de Usuario ******
		
		/*
		Perfil premium = new Perfil();
		premium = repositorio.perfil().buscarPorId(2); 
		System.out.println("Perfil Encontrado: \n");
		System.out.println(premium.getDescripcion());
		
		Usuario usuario = new Usuario();
		usuario.setCodigoUsuario("cromero"); 
		usuario.setPassword("Sistemas2016");
		usuario.setNombre("Cristian Ezequiel");
		usuario.setApellido("Romero");
		usuario.setUserPremium(true);
		usuario.setCodPerfil(premium);
		
		repositorio.usuario().persistir(usuario);
		System.out.println("Finaliza persistencia de Usuario \n");
		
		/*
		
		Guardarropa guardarropa = new Guardarropa(); 
		guardarropa.setMaximoPrendas(250);
		
		TipoPrenda tipo1 = new TipoPrenda();
		tipo1.setNivelAbrigo(7);
		
		TipoPrenda tipo2 = new TipoPrenda();
		tipo2.setNivelAbrigo(4);
		
		Prenda prenda1 = new Prenda();
		prenda1.setCategoria(EnumCategoria.Superior);
		prenda1.setColorPrimario("Verde");
		prenda1.setColorSecundario("Rojo");
		prenda1.setCapa(1);
		prenda1.setTipoPrenda(tipo1);
		prenda1.setDescripcion("Remera Verde y Rojo");
		guardarropa.agregarPrenda(prenda1);
		
		Prenda prenda2 = new Prenda();
		prenda2.setCategoria(EnumCategoria.Superior);
		prenda2.setColorPrimario("Azul");
		prenda2.setCapa(1);
		prenda2.setTipoPrenda(tipo1);
		prenda2.setDescripcion("Remera Azul");
		guardarropa.agregarPrenda(prenda2);
		
		Prenda prenda3 = new Prenda();
		prenda3.setCategoria(EnumCategoria.Superior);
		prenda3.setColorPrimario("Amarillo");
		prenda3.setColorSecundario("Naranja");
		prenda3.setCapa(1);
		prenda3.setTipoPrenda(tipo1);
		prenda3.setDescripcion("Remera Amarilla y Naranja");
		guardarropa.agregarPrenda(prenda3);
		
		
		Prenda prenda4 = new Prenda();
		prenda4.setCategoria(EnumCategoria.Superior);
		prenda4.setColorPrimario("Amarillo");
		prenda4.setCapa(2);
		prenda4.setTipoPrenda(tipo2);
		prenda4.setDescripcion("Manga larga Amarilla");
		guardarropa.agregarPrenda(prenda4);
		
		Prenda prenda9 = new Prenda();
		prenda9.setCategoria(EnumCategoria.Superior);
		prenda9.setColorPrimario("Naranja");
		prenda9.setCapa(2);
		prenda9.setTipoPrenda(tipo2);
		prenda9.setDescripcion("Manga Larga Naranja");
		guardarropa.agregarPrenda(prenda9);
		
		Prenda prenda8 = new Prenda();
		prenda8.setCategoria(EnumCategoria.Superior);
		prenda8.setColorPrimario("Morado");
		prenda8.setColorSecundario("Purpura");
		prenda8.setCapa(3);
		prenda8.setTipoPrenda(tipo1);
		prenda8.setDescripcion("Campera Morada y Purpura.");
		guardarropa.agregarPrenda(prenda8);
		
		Prenda prenda11 = new Prenda();
		prenda11.setCategoria(EnumCategoria.Superior);
		prenda11.setColorPrimario("Blue");
		prenda11.setColorSecundario("Naranja");
		prenda11.setCapa(3);
		prenda11.setTipoPrenda(tipo1);
		prenda11.setDescripcion("Campera Blue y Naranja");
		guardarropa.agregarPrenda(prenda11);
		
		Prenda prenda5 = new Prenda();
		prenda5.setCategoria(EnumCategoria.Inferior);
		prenda5.setColorPrimario("Verde");
		prenda5.setColorSecundario("Rojo");
		prenda5.setCapa(1);
		prenda5.setTipoPrenda(tipo2);
		prenda5.setDescripcion("Jean Verde y Rojo");
		guardarropa.agregarPrenda(prenda5);
		
		Prenda prenda6 = new Prenda();
		prenda6.setCategoria(EnumCategoria.Inferior);
		prenda6.setColorPrimario("Blanco y Negro");
		prenda6.setCapa(1);
		prenda6.setTipoPrenda(tipo2);
		prenda6.setDescripcion("Pantalón Blanco y negro");
		guardarropa.agregarPrenda(prenda6);
		
		Prenda prenda7 = new Prenda();
		prenda7.setCategoria(EnumCategoria.Calzado);
		prenda7.setColorPrimario("Marrón y Negro");
		prenda7.setCapa(1);
		prenda7.setTipoPrenda(tipo2);
		prenda7.setDescripcion("Zapato Marron y Negro");
		guardarropa.agregarPrenda(prenda7);
		
		Prenda prenda10 = new Prenda();
		prenda10.setCategoria(EnumCategoria.Calzado);
		prenda10.setColorPrimario("Blanco y Azul");
		prenda10.setCapa(1);
		prenda10.setTipoPrenda(tipo2);
		prenda10.setDescripcion("Zapatilla Blanco y Azul");
		guardarropa.agregarPrenda(prenda10);
		
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		List<Sugerencia> sugerenciasParteSuperior = new ArrayList<Sugerencia>();
		List<Sugerencia> sugerenciasParteInferior = new ArrayList<Sugerencia>();
		
		sugerenciasParteSuperior = guardarropa.sugerenciaParteSuperior(10);
		sugerenciasParteInferior = guardarropa.sugerenciaParteInferior(10);
		
		System.out.print("Cantidad de Prendas en el Guardarropas: " + guardarropa.cantidadDePrendas() + "\n");
		
		sugerencias = guardarropa.recomendacion(10);
		
		System.out.print("Cantidad de Sugerencias: " + sugerencias.size() + "\n");
		
		int contador=0;
		
		for(Sugerencia sugerencia:sugerencias){
			
			contador++;
			
			System.out.print("===== Inicio de Combinación: " + contador + " =====\n");
			System.out.print("*** Parte Superior - Capa Máxima - " + sugerencia.getMaxCapaSuperior() + "***\n");
			
			if(sugerencia.getMaxCapaSuperior() >= 1) {
				System.out.print("Capa 1: " + sugerencia.getParteSuperior1().getDescripcion() + "\n");
			}
			
			if(sugerencia.getMaxCapaSuperior() >= 2) {
				System.out.print("Capa 2: " + sugerencia.getParteSuperior2().getDescripcion() + "\n");
			}
			
			if(sugerencia.getMaxCapaSuperior() >= 3) {
				System.out.print("Capa 3: " + sugerencia.getParteSuperior3().getDescripcion() + "\n");
			}
			
			if(sugerencia.getMaxCapaSuperior() >= 4) {
				System.out.print("Capa 4: " + sugerencia.getParteSuperior4().getDescripcion() + "\n");
			}
			
			System.out.print("*** Parte Inferior - Capa Máxima - " + sugerencia.getMaxCapaInferior() + " *** \n");
			
			if(sugerencia.getMaxCapaInferior() >= 1) {
				System.out.print("Capa 1: " + sugerencia.getParteInferior1().getDescripcion() + "\n");
			}
			
			if(sugerencia.getMaxCapaInferior() >= 2) {
				System.out.print("Capa 2: " + sugerencia.getParteInferior2().getDescripcion() + "\n");
			}	
			
			System.out.print("*** Parte Calzado *** \n");
			System.out.print("Capa 1: " + sugerencia.getParteCalzado().getDescripcion() + "\n");
			System.out.print("=== Fin de Combinación ===\n");
			
		}
		
		*/
	}
	
	
	
}
	

