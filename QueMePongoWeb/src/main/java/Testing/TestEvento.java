/*package Testing;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Desarrollo.*;
import Desarrollo.ObjetosValor.UbicacionEvento;

public class TestEvento {
Evento evento = new Evento();
Usuario usuario = new Usuario();
ServidorColaDeEventos servidorCola ;
UbicacionEvento ubicacion;
Guardarropa guardarropa = new Guardarropa();
@Before

	public void init() throws IOException{
		//usuario.setTipoUsuario(EnumUsuario.Gratuito);
		guardarropa.setMaximoPrendas(20);
		guardarropa.AddUsuariosCompartiendo(usuario);
		//guardarropa.setPrendasDisponibles(Testing.TestLeerArchivoJson.JsonToPrendas());
		servidorCola = new ServidorColaDeEventos();
        ubicacion = new UbicacionEvento();

	}
	
	@Test
	public void ProcesarEvento() throws IOException{
		evento.setFechaAlta(LocalDate.now());
		evento.setFechaEvento(LocalDate.now());
		evento.setServidorCola(servidorCola);
		evento.setUbicacion(ubicacion);
		ubicacion.setLatitudEvento(100);
		ubicacion.setLongitudEvento(50);
		evento.setUsuario(usuario);
		evento.ProcesarEvento();
		usuario.aceptarSugerencia(evento.getSugerencias().get(0), evento);		
		Assert.assertEquals(1, evento.getSugerenciaSeleccionada());
		
	}
	
	
	
}
*/
