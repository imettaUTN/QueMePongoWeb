package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.Perfil;

public class Repositorio {
	
	private Perfiles perfiles;
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

}
