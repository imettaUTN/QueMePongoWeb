package Repositorio;
import javax.persistence.EntityManager;
import Desarrollo.Guardarropa;

public class GuardarropasPersistencia extends Repositorio{
	
	public GuardarropasPersistencia(EntityManager em) {
		super(em);
	}

	public Guardarropa buscarPorId(int i) {
		return em.find(Guardarropa.class, i);
	}
	
	public void persistir(Guardarropa guardarropa){
		em.getTransaction().begin();
		em.merge(guardarropa);
		em.getTransaction().commit();
	}
}
