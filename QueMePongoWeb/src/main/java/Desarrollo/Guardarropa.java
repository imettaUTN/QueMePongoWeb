package Desarrollo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.*;
import java.*;

import Desarrollo.Enumerados.EnumCategoria;
import Desarrollo.Enumerados.EnumEstadoSugerencia;

@Entity
@Table(name = "Guardarropas")
public class Guardarropa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodGuardarropa")
	private int id;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "Compartido")
	private boolean compartido;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "UsrCod", referencedColumnName = "UsrCod")
	@Transient
	private Usuario administrador;
	
	@Transient
	private List<Prenda> prendasDisponibles = new ArrayList<Prenda>();
	
	/*
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="UsrCod")
	private List<Usuario> usuariosCompartiendo = new ArrayList<Usuario>(); 
	*/
	
	public void crearGuardarropa(String descripcion, boolean compartido, Usuario admin){
		
		this.descripcion = descripcion;
		this.compartido = compartido;
		this.administrador = admin;
	}
	
	public void guardar(){
		
		JPAUtil trn = new JPAUtil();
		trn.transaccion().guardarropa().persistir(this);
	}
	

	/*
	
	public List<Sugerencia> GenerarSugerencia(int temperaturaMinima, int temperaturaMaxima) throws IOException{
			
			return algortimoDeRecomendacion(temperaturaMinima,temperaturaMaxima); 
	}
	
	*/
	
	public boolean agregarPrenda(Prenda prenda){
		
		//Se compara contra usuario comun
		if(this.administrador.getCodPerfil().getCodigoPerfil() == 2) {
		
			if(cantidadDePrendas() <= this.administrador.getPrendasDisponibles()) {
				
				prendasDisponibles.add(prenda);
				return true;
				
			}else {
				
				return false;
			}
			
		}else {
			
			prendasDisponibles.add(prenda);
			return true;
		}	
		
	}
	
	public void eliminarPrenda(Prenda prenda){
	
		this.prendasDisponibles.remove(prenda);
	}
	
	public int cantidadDePrendas() {
		
		return this.prendasDisponibles.size();
	}
	
	public List<Sugerencia> sugerenciaParteSuperior(int temperaturaMinima, int temperaturaMaxima) throws SQLException{
		
		System.out.print("Ingreso a method sugerenciaParteSuperior. \n");
		
		int capaMaxima = 0;
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		
		if(this.prendasDisponibles.size() >0) {
			
		NivelesDeAbrigo abrigo = new NivelesDeAbrigo();	
		final int nivelDeAbrigo = abrigo.obtenerNivelDeAbrigo(temperaturaMinima, temperaturaMaxima);
		
		List<Object> parteSuperior = this.prendasDisponibles.stream().filter(new Predicate<Prenda>() {
			public boolean test(Prenda p) {
				return p.esSuperior() && p.nivelAbrigo() <= nivelDeAbrigo;
			}
		}).collect(Collectors.toList());
		System.out.print("Cantidad de Prendas Parte Superior: " + parteSuperior.size() + "\n");
		
		List<Object> capaCuatro = parteSuperior.stream().filter(p->((Prenda) p).getCapa() == 4).collect(Collectors.toList());
		System.out.print("Cantidad Prendas Capa 4: " + capaCuatro.size()+ "\n");
		
		List<Object> capaTres = parteSuperior.stream().filter(p->((Prenda) p).getCapa() == 3).collect(Collectors.toList());
		System.out.print("Cantidad Prendas Capa 3: " + capaTres.size() + "\n");
		
		List<Object> capaDos = parteSuperior.stream().filter(p->((Prenda) p).getCapa() == 2).collect(Collectors.toList());
		System.out.print("Cantidad Prendas Capa 2: " + capaDos.size() + "\n");
		
		List<Object> capaUno = parteSuperior.stream().filter(p->((Prenda) p).getCapa() == 1).collect(Collectors.toList());
		System.out.print("Cantidad Prendas Capa 1: " + capaUno.size() + "\n");
		
		for(Object prenda:parteSuperior){
			
			if(((Prenda) prenda).getCapa()>capaMaxima){
				
				capaMaxima = ((Prenda) prenda).getCapa();
				
			}
			
			if(((Prenda) prenda).getCapa() == 4){
				
				capaMaxima = 4;
				break;
			}
		}
		
		System.out.print("Valor de Capa M�xima: " + capaMaxima + "\n");
		
		switch(capaMaxima){
		
			case 4:
				
				System.out.print("Combino por Capa 4. \n");
				
				for(Object prendaCapaCuatro:capaCuatro){
					
					for(Object prendaCapaTres:capaTres){
						
						for(Object prendaCapaDos:capaDos){
							
							for(Object prendaCapaUno:capaUno){
								
								Sugerencia sugerencia = new Sugerencia();
								
								sugerencia.prendasSugeridas.put(14, (Prenda) prendaCapaCuatro);
								sugerencia.prendasSugeridas.put(13, (Prenda) prendaCapaTres);
								sugerencia.prendasSugeridas.put(12, (Prenda) prendaCapaDos);
								sugerencia.prendasSugeridas.put(11, (Prenda) prendaCapaUno);
							
								sugerencia.setMaxCapaSuperior(capaMaxima);
								sugerencias.add(sugerencia);
								
							}
						}
					}
				}
				
			break;
				
			case 3:
				
				System.out.print("Combino por Capa 3. \n");
				
				for(Object prendaCapaTres:capaTres){
					
					for(Object prendaCapaDos:capaDos){
						
						for(Object prendaCapaUno:capaUno){
							
							Sugerencia sugerencia = new Sugerencia();
							
							sugerencia.prendasSugeridas.put(13, (Prenda) prendaCapaTres);
							sugerencia.prendasSugeridas.put(12, (Prenda) prendaCapaDos);
							sugerencia.prendasSugeridas.put(11, (Prenda) prendaCapaUno);
							
							sugerencia.setMaxCapaSuperior(capaMaxima);
							
							sugerencias.add(sugerencia);
							
						}
					}
				}
				
				break;
				
			case 2:
				
				System.out.print("Combino por Capa 2. \n");
				
				for(Object prendaCapaDos:capaDos){
					
					for(Object prendaCapaUno:capaUno){
						
						Sugerencia sugerencia = new Sugerencia();
						sugerencia.prendasSugeridas.put(12, (Prenda) prendaCapaDos);
						sugerencia.prendasSugeridas.put(11, (Prenda) prendaCapaUno);
						sugerencia.setMaxCapaSuperior(capaMaxima);
						sugerencias.add(sugerencia);
						
					}
				}
				
				break;
				
			
			case 1:	
				
				System.out.print("Combino por Capa 1. \n");
				
				for(Object prendaCapaUno:capaUno){
					
					Sugerencia sugerencia = new Sugerencia();
					sugerencia.prendasSugeridas.put(11, (Prenda) prendaCapaUno);
					sugerencia.setMaxCapaSuperior(capaMaxima);
					sugerencias.add(sugerencia);
					
				}
				
				break;
		}
		
			return sugerencias;
		
		}else {
		
			System.out.print("Lista Vac�a. \n");
			sugerencias.clear();
			return sugerencias;
		
		}
	} 
	
	public List<Sugerencia> sugerenciaParteInferior(int temperaturaMinima, int temperaturaMaxima) throws SQLException{
		
		System.out.print("Ingreso a method sugerenciaParteInferior. \n");
		
		NivelesDeAbrigo abrigo = new NivelesDeAbrigo();	
		final int nivelDeAbrigo = abrigo.obtenerNivelDeAbrigo(temperaturaMinima, temperaturaMaxima);
		
		int capaMaxima = 1;
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		
		if(this.prendasDisponibles.size() >0 ) {
		
		List<Prenda> parteInferior = this.prendasDisponibles.stream().filter(p->p.esInferior() && p.nivelAbrigo() <= nivelDeAbrigo).collect(Collectors.toList());
		
		List<Prenda> capaDos = parteInferior.stream().filter(p->p.getCapa() == 2).collect(Collectors.toList());
		List<Prenda> capaUno = parteInferior.stream().filter(p->p.getCapa() == 1).collect(Collectors.toList());
		
		System.out.print("Cantidad de Prendas Parte Inferior: " + parteInferior.size() + "\n");
		System.out.print("Cantidad de Prendas Capa 1: " + capaUno.size() + "\n");
		System.out.print("Cantidad de Prendas Capa 2: " + capaDos.size() + "\n");
		
		for(Prenda prenda:parteInferior){
			
			if(prenda.getCapa()>capaMaxima){
				
				capaMaxima = prenda.getCapa();
				
			}
			
			if(prenda.getCapa() == 4){
				
				capaMaxima = 4;
				break;
			}
		}
		
		switch(capaMaxima){
		
			case 2:
				
				System.out.print("Se combina por capa 2. \n");
				
				for(Prenda prendaCapaDos:capaDos){
					
					for(Prenda prendaCapaUno:capaUno){
						
						Sugerencia sugerencia = new Sugerencia();
						sugerencia.prendasSugeridas.put(22, (Prenda) prendaCapaDos);
						sugerencia.prendasSugeridas.put(21, (Prenda) prendaCapaUno);
						sugerencia.setMaxCapaInferior(capaMaxima);
						sugerencias.add(sugerencia);
						
					}
				}
				
				break;
				
			
			case 1:	
				
				System.out.print("Se combina por capa 1. \n");
				
				for(Prenda prendaCapaUno:capaUno){
					
					Sugerencia sugerencia = new Sugerencia();
					sugerencia.prendasSugeridas.put(21, (Prenda) prendaCapaUno);
					sugerencia.setMaxCapaInferior(capaMaxima);
					sugerencias.add(sugerencia);
					
				}
				
				break;
		}
		
			return sugerencias;
		
		}else {
		
			System.out.print("Lista Vac�a. \n");
			sugerencias.clear();
			return sugerencias;
		
		}
	}
	
	public List<Sugerencia> recomendacion(int tempMinima, int tempMaxima) throws IOException, SQLException{
		
		System.out.print("Ingreso a metodo de Recomendacion. \n");
		int nivelDeAbrigo = 7;
		
		List<Sugerencia> sugerenciasSuperior = this.sugerenciaParteSuperior(tempMinima, tempMaxima);
		System.out.print("Cantidad combinaciones ParteSuperior: " + sugerenciasSuperior.size() + "\n");
		
		List<Sugerencia> sugerenciasInferior = this.sugerenciaParteInferior(tempMinima, tempMaxima);
		System.out.print("Cantidad combinaciones ParteInferior. " + sugerenciasInferior.size() +"\n");
	
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		//List<Prenda> parteSuperior = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esSuperior() && p.nivelAbrigo() <= nivelDeAbrigo).collect(Collectors.toList());
		//List<Prenda> parteInferior = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esInferior() && p.nivelAbrigo() <= nivelDeAbrigo).collect(Collectors.toList());
		List<Prenda> calzados = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esCalzado() && p.nivelAbrigo() <= nivelDeAbrigo).collect(Collectors.toList());
		List<Prenda> accesorios = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esAccesorio() && p.nivelAbrigo() <= nivelDeAbrigo).collect(Collectors.toList());
		
		System.out.print("Cantidad de Calzados. " + calzados.size() +"\n");
		
		for(Sugerencia sugerenciaSup : sugerenciasSuperior){
			
			for(Sugerencia sugerenciaInf:sugerenciasInferior){
					
					for(Prenda prendaCalzado:calzados){
						
							Sugerencia suger = new Sugerencia();
							//suger.setParteSuperior3(sugerenciaSup.getParteSuperior3());
							suger.prendasSugeridas.put(13, sugerenciaSup.prendasSugeridas.get(13));
							
							//suger.setParteSuperior2(sugerenciaSup.getParteSuperior2());
							suger.prendasSugeridas.put(12, sugerenciaSup.prendasSugeridas.get(12));
							
							//suger.setParteSuperior1(sugerenciaSup.getParteSuperior1());
							suger.prendasSugeridas.put(11, sugerenciaSup.prendasSugeridas.get(11));
							
							suger.setMaxCapaSuperior(sugerenciaSup.getMaxCapaSuperior());
							
							//suger.setParteInferior1(sugerenciaInf.getParteInferior1());
							suger.prendasSugeridas.put(21, sugerenciaSup.prendasSugeridas.get(21));
							
							//suger.setParteInferior2(sugerenciaInf.getParteInferior2());
							suger.prendasSugeridas.put(22, sugerenciaSup.prendasSugeridas.get(22));
							
							suger.setMaxCapaInferior(sugerenciaInf.getMaxCapaInferior());
							
							suger.prendasSugeridas.put(41, prendaCalzado);
							
							//TODO: Falta agregar combinaci�n de accesorios.
							
							suger.setMaxCapaInferior(sugerenciaInf.getMaxCapaInferior());
							sugerencias.add(suger);
					}
			}
			
		}	
		
		List<Sugerencia> sugerenciasColoresExcluidos = new ArrayList<Sugerencia>();
		sugerenciasColoresExcluidos.clear();
		
		List<Sugerencia> sugerenciasFinales = new ArrayList<Sugerencia>();
		sugerenciasFinales.clear();
		
		ColoresExcluidos excluidos = new ColoresExcluidos();
		SugerenciasExcluidas sugerExclu = new SugerenciasExcluidas();
		
		for(Sugerencia sugerencia:sugerencias) {
			
			Prenda p1 = null;
			Prenda p2 = null;
			
			switch(sugerencia.getMaxCapaSuperior()) {
			
				case 4:
					
					p1 = sugerencia.prendasSugeridas.get(14);
					break;
					
				case 3:
					
					p1 = sugerencia.prendasSugeridas.get(13);
					break;
					
				case 2:
					
					p1 = sugerencia.prendasSugeridas.get(12);
					break;
					
				case 1:
					
					p1 = sugerencia.prendasSugeridas.get(11);
					break;
			}	
			
			switch(sugerencia.getMaxCapaInferior()) {
			
				case 2:
					
					p2 = sugerencia.prendasSugeridas.get(22);
					break;
					
				case 1:
					
					p2 = sugerencia.prendasSugeridas.get(21);
					break;
		}
			
			//Si la combinacion de colores no esta excluida agrego a la lista.
			if(!excluidos.ejecutar(this.administrador,p1,p2)){
				
				sugerenciasColoresExcluidos.add(sugerencia);
			}
				
		}
			sugerencias.clear(); //Limpio lista anterior de combinaciones
			
			//Sugerencia de Colores Combinados Excluidos
			
			
			for(Sugerencia sugerencia:sugerenciasColoresExcluidos){
				
				if(!sugerExclu.ejecutar(this.administrador, sugerencia)){
					
					sugerenciasFinales.add(sugerencia);
				}
				
			}
			
			return sugerenciasFinales;
		}
		
	/*
	
	public List<Sugerencia> algortimoDeRecomendacion(int temperaturaMaxima, int temperaturaMinima) throws IOException{
		
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		List<Prenda> parteSuperior = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esSuperior());
		List<Prenda> parteInferior = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esInferior());
		List<Prenda> calzados = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esCalzado());
		List<Prenda> accesorios = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esAccesorio());
		
		//Parte superior
		// cantidadCapasASuperponer = Buscar cantidad de capas a cubrir
		// For :
		// Buscar el primer elemento de la lista de parteSuperior cuyo nivel de abrigo sea = a la cantidad de capas a llenar y este disponible
		// agregar prenda a la lista de sugerencia
		// setear prenda como no disponible para que no la vueva a elegir
		
		//Parte inferior

		// cantidadCapasASuperponer = Buscar cantidad de capas a cubrir
				// For :
				// Buscar el primer elemento de la lista de parteSuperior cuyo nivel de abrigo sea = a la cantidad de capas a llenar y este disponible
				// agregar prenda a la lista de sugerencia
				// setear prenda como no disponible para que no la vueva a elegir 
				
		
		// 2 funciones para procesar las lista de suegerencia
		//1) dada dose listas, devuelve una lista de sugerencia con la combinacion de ambas ( no tiene en cuenta el color entre capas)
		//2) dada la lista de sugerencia anterior (nivel superior) , le mando como segundo parametro la lista parte inferior filtrada para el nivel de capa. 
		//internamente va a evaluar que la combinacion de colores tenga sentido (usar funcion) y en  caso que para una sugerencias de la parte sup no pueda ser
		//combinada con la prenda de la parte inferior, eliminar sugerencia de la lista ( lista global al metodo).
		
		// una vez procesada todas las categorias de la prendas, deberiamos tener una lista con las sugerencias que se lograron combinar  y de esas elegir 4 para devolver al usuario.
		
		for(Prenda prendaSuperior:parteSuperior){
			if(cantidadCapasASuperponer == 0) {
				//PARA CADA CATEGORIA SE OBTIENE EL NIVEL DE ABRIGO QUE SE TIENE QUE LOGRAR
				//EJ: PARTE SUPERIOR TIENE QUE LOGRARSE UN NIVEL 3
			cantidadCapasASuperponer = GetNivelAbrigoByCategoria(EnumCategoria.Superior,temperaturaMinima,temperaturaMaxima);}
			Sugerencia sugerencia = new Sugerencia();
			
			//filtrar por el nivel de capa de la prenda
			
			
			sugerencia.agregarPrendaSeleccionada(prendaSuperior);
			
			cantidadCapasASuperponer --;
			if(cantidadCapasASuperponer <= 0) {
				
				for(Prenda prendaInferior:parteInferior){
					if(cantidadCapasASuperponer == 0) {
						cantidadCapasASuperponer = GetNivelAbrigoByCategoria(EnumCategoria.Inferior,temperaturaMinima,temperaturaMaxima);}
					sugerencia.agregarPrendaSeleccionada(prendaInferior);
					cantidadCapasASuperponer --;
					if(cantidadCapasASuperponer <= 0) {
							if((EsColorCombinable(prendaSuperior.getColorPrimario(), prendaInferior.getColorSecundario())) &&
									(EsColorCombinable(prendaInferior.getColorPrimario(), prendaSuperior.getColorSecundario())))
							{									
								for(Prenda calzado:calzados){									
										sugerencia.agregarPrendaSeleccionada(calzado);
										if((EsColorCombinable(prendaSuperior.getColorPrimario(), calzado.getColorSecundario())) &&
												(EsColorCombinable(calzado.getColorPrimario(), prendaSuperior.getColorSecundario())) &&
												(EsColorCombinable(prendaInferior.getColorPrimario(), calzado.getColorSecundario())) &&
												(EsColorCombinable(calzado.getColorPrimario(), prendaInferior.getColorSecundario()))
											)	
										{
										
											for(Prenda accesorio:accesorios){
											if((EsColorCombinable(prendaSuperior.getColorPrimario(), accesorio.getColorSecundario())) &&
													(EsColorCombinable(accesorio.getColorPrimario(), prendaSuperior.getColorSecundario())) &&
													(EsColorCombinable(prendaInferior.getColorPrimario(), accesorio.getColorSecundario())) &&
													(EsColorCombinable(accesorio.getColorPrimario(), prendaInferior.getColorSecundario())) &&
													(EsColorCombinable(calzado.getColorPrimario(), accesorio.getColorSecundario())) &&
													(EsColorCombinable(accesorio.getColorPrimario(), calzado.getColorSecundario())) 
											)
											{
												sugerencia.agregarPrendaSeleccionada(accesorio);
												sugerencia.setEstado(EnumEstadoSugerencia.NUEVO);
												sugerencias.add(sugerencia);
											}
										}
									}
							   }
							}
					}
				}
			}
		}
		
		return sugerencias;
	}
	
	*/

	/*
	private int GetNivelAbrigoByCategoria(EnumCategoria categoria, int temperaturaMinima, int temperaturaMaxima) throws IOException {
		for(Parametros par: Testing.TestLeerArchivoJson.JsonToParametros()) {
			if(par.getCategoria().equals(categoria) && par.getRangoTemperaturaDesde() >= temperaturaMinima && par.getRangoTemperaturaHasta() <= temperaturaMaxima) {
				return par.getNivelAbrigoDeseado();
			}
		}
		return 0;
	}*/
	
	private boolean EsColorCombinable(String colorPrimario, String colorSecundario) {
		
		if(colorPrimario.equals("ROJO")) {
			return colorSecundario.equals("BLANCO") || colorSecundario.equals("NEGRO") || colorSecundario.equals("GRIS") || colorSecundario.equals("AMARILLO") || colorSecundario.equals("BEIGE") ;
		}
		if(colorPrimario.equals("AMARILLO")) {
			return colorSecundario.equals("BLANCO") || colorSecundario.equals("NEGRO") || colorSecundario.equals("GRIS") || colorSecundario.equals("AZUL") || colorSecundario.equals("MORADO") || colorSecundario.equals("ROJO") ;
		}
		if(colorPrimario.equals("AZUL")) {
			return colorSecundario.equals("AMARILLO") || colorSecundario.equals("BLANCO") || colorSecundario.equals("NARANJA") || colorSecundario.equals("NARANJA") || colorSecundario.equals("MARRON")  || colorSecundario.equals("VERDE") || colorSecundario.equals("ROJO") ;
		}
		if(colorPrimario.equals("BLANCO")) {
			return colorSecundario.equals("BLANCO");
		}
		if(colorPrimario.equals("NEGRO")) {
			return colorSecundario.equals("NEGRO");
		}
		
		return false;		
	}
	
	public List<Prenda> getPrendasDisponibles() {
		return prendasDisponibles;
	}

	public boolean isGuardarropasCompartido() {
		return this.compartido;
	}

	/*
	public List<Usuario> getUsuariosCompartiendo() {
		return usuariosCompartiendo;
	}
	*/

	public void setPrendasDisponibles(List<Prenda> prendasDisponibles) {
		this.prendasDisponibles = prendasDisponibles;
	}

	
	public void setGuardarropasCompartido(boolean guardarropasCompartido) {
		this.compartido = guardarropasCompartido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isCompartido() {
		return compartido;
	}

	public void setCompartido(boolean compartido) {
		this.compartido = compartido;
	}


	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

	/*
	public void AddUsuariosCompartiendo(Usuario usuarioCompartiendo) {
		this.usuariosCompartiendo.add(usuarioCompartiendo);
	}
	*/
	
/*
	public void generarSugerencias(int nivelDeAbrigo){
		
		List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		List<Prenda> parteSuperior = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esSuperior() && p.esNivelDeAbrigo(nivelDeAbrigo));
		List<Prenda> parteInferior = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esInferior() && p.esNivelDeAbrigo(nivelDeAbrigo));
		List<Prenda> calzados = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esCalzado() && p.esNivelDeAbrigo(nivelDeAbrigo));
		List<Prenda> accesorios = (List<Prenda>) this.prendasDisponibles.stream().filter(p->p.esAccesorio() && p.esNivelDeAbrigo(nivelDeAbrigo));
		
		
		for(Prenda prendaSuperior: parteSuperior){
			
			Sugerencia sugerencia = new Sugerencia();
			sugerencia.agregarPrendaSeleccionada(prendaSuperior);
			
				for(Prenda prendaInferior:parteInferior){
					
					sugerencia.agregarPrendaSeleccionada(prendaInferior);
	
						for(Prenda calzado:calzados){
							
							sugerencia.agregarPrendaSeleccionada(calzado);
								
								for(Prenda accesorio:accesorios){
									
									sugerencia.agregarPrendaSeleccionada(accesorio);
									sugerencias.add(sugerencia);
									
								}
						}
				}
		}
	}

*/	
	
	
	
}
