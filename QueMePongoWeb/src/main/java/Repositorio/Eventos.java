package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.*;

public class Eventos extends Repositorio{
		
	public Eventos(EntityManager em) {
		super(em);
	}

	public Evento buscarPorId(int i) {
		return em.find(Evento.class, i);
	}
	
	public void persistir(Evento evento){
		em.getTransaction().begin();
		em.merge(evento);
		em.getTransaction().commit();
	}
}