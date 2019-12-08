/*
package Testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import Desarrollo.Perfil;
import Repositorio.Repositorio;

public class PruebaPersistencia {
	
	private Perfil perfil;
	private static final String PERSISTENCE_UNIT_NAME = "DDS";
	private EntityManagerFactory emFactory;
	private Repositorio repositorio;
	
	@Before
	public void setUp() throws Exception{
		
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		repositorio = new Repositorio(emFactory.createEntityManager() );
		
		Perfil p1 = new Perfil();
		p1.setDescripcion("UsuarioPremium");
		
		
		
		repositorio.perfil().persistir(p1);
		
	}

	@Test
	
		
		  public void testExtraerMensaje() {
		    assertEquals("1","1","1");
		  }
		
	
	
}

*/


