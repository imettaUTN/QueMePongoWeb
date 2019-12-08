package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.*;

public class Usuarios extends Repositorio{
		
	public Usuarios(EntityManager em) {
		super(em);
	}

	public Usuario buscarPorId(String i) {
		return em.find(Usuario.class, i);
	}
	
	public void persistir(Usuario usuario){
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}
}
