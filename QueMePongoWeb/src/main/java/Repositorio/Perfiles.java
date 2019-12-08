package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.Perfil;

public class Perfiles extends Repositorio{
		
	public Perfiles(EntityManager em) {
		super(em);
	}

	public Perfil buscarPorId(int i) {
		return em.find(Perfil.class, i);
	}
	
	public void persistir(Perfil perfil){
		em.getTransaction().begin();
		em.merge(perfil);
		em.getTransaction().commit();
	}
}
