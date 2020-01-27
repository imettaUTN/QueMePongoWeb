package Repositorio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
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
	
	public List<Prenda> listado(){
		
		List<Prenda> prendas = new ArrayList<>();
		Query query = em.createQuery("SELECT P FROM Prenda P");
		prendas = query.getResultList();
		return prendas;
	}
}
