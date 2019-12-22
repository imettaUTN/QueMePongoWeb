package Repositorio;

import javax.persistence.EntityManager;

import Desarrollo.*;

public class Categorias extends Repositorio{
	
	public Categorias(EntityManager em) {
		super(em);
	}

	public Categoria buscarPorId(int i) {
		return em.find(Categoria.class, i);
	}
	
	public void persistir(Categoria categoria){
		em.getTransaction().begin();
		em.merge(categoria);
		em.getTransaction().commit();
	}
}
