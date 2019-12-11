package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.Perfil;

public class Repositorio {
	
	private Perfiles perfiles;
	private Usuarios usuarios;
	private Colores colores;
	private SugerenciasRechazadas sugerencia;
	protected EntityManager em;
	
	public Repositorio(EntityManager em){
		this.em = em;
	}
	
	public Perfiles perfil(){
		
		if(perfiles == null) {
			perfiles = new Perfiles(em);
		}
		
		return perfiles;
	}
	
	public Usuarios usuario(){
		
		if(usuarios == null) {
			usuarios = new Usuarios(em);
		}
		
		return usuarios;
	}
	
	public Colores color(){
		
		if(colores == null) {
			colores = new Colores(em);
		}
		
		return colores;
	}
	
	public SugerenciasRechazadas sugerenciaRechaza(){
		
		if(sugerencia == null) {
			sugerencia = new SugerenciasRechazadas(em);
		}
		
		return sugerencia;
	}
	
	
	public void cerrar() {
		em.close();
	}

}
