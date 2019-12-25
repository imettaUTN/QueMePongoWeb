package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.*;

public class EstadosEventos extends Repositorio{
		
	public EstadosEventos(EntityManager em) {
		super(em);
	}

	public EstadoEvento buscarPorId(int i) {
		return em.find(EstadoEvento.class, i);
	}
	
	public void persistir(EstadoEvento estado){
		em.getTransaction().begin();
		em.merge(estado);
		em.getTransaction().commit();
	}
}
