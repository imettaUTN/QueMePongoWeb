package Repositorio;

import javax.persistence.EntityManager;

import Desarrollo.*;

public class TipoPrendas extends Repositorio{
	
	public TipoPrendas(EntityManager em) {
		super(em);
	}

	public TipoPrenda buscarPorId(int i) {
		return em.find(TipoPrenda.class, i);
	}
	
	public void persistir(TipoPrenda tipoPrenda){
		em.getTransaction().begin();
		em.merge(tipoPrenda);
		em.getTransaction().commit();
	}
}