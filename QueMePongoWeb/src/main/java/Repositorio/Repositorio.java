package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.Perfil;

public class Repositorio {
	
	private Perfiles perfiles;
	private Usuarios usuarios;
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
	
	public void cerrar() {
		em.close();
	}

}
