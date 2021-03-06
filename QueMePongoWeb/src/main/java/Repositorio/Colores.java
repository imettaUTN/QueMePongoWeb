package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.*;

public class Colores extends Repositorio{
		
	public Colores(EntityManager em) {
		super(em);
	}

	public Colores buscarPorId(String i) {
		return em.find(Colores.class, i);
	}
	
	public void persistir(Colores colores){
		em.getTransaction().begin();
		em.merge(colores);
		em.getTransaction().commit();
	}
}