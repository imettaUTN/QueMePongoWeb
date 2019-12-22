package Repositorio;

import javax.persistence.EntityManager;

import Desarrollo.Prenda;

public class Prendas extends Repositorio{
	
	public Prendas(EntityManager em) {
		super(em);
	}

	public Prenda buscarPorId(int i) {
		return em.find(Prenda.class, i);
	}
	
	public void persistir(Prenda prenda){
		em.getTransaction().begin();
		em.merge(prenda);
		em.getTransaction().commit();
	}
}
