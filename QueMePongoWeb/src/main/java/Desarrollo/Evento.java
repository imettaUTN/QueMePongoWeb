 package Desarrollo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import Desarrollo.Enumerados.EnumEstadoEvento;
import Desarrollo.ObjetosValor.UbicacionEvento;

@Entity
@Table(name = "Evento")
public class Evento {
	
	private int codEvento;
	private String descripcion;
	private LocalDate fechaAlta;
	private LocalDate fechaEvento;
	private int temperaturaMinima;
	private int temperaturaMaxima;
	private Sugerencia sugerenciaSeleccionada; //Debería ser XML
	private List<Sugerencia> sugerencias = new ArrayList<Sugerencia>(); //No se persiste
	private ServidorColaDeEventos servidorCola;
	private EnumEstadoEvento estado;
	private InvokerGestorEvento invoker;
	private Usuario usuario;
	private UbicacionEvento ubicacion;
	private TipoEvento tipoEvt;
	
	
	public ServidorColaDeEventos getServidorCola() {
		return servidorCola;
	}

	public void setServidorCola(ServidorColaDeEventos servidorCola) {
		this.servidorCola = servidorCola;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public LocalDate getFechaEvento() {
		return fechaEvento;
	}


	public Sugerencia getSugerenciaSeleccionada() {
		return sugerenciaSeleccionada;
	}

	public EnumEstadoEvento getEstado() {
		return estado;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	

	public UbicacionEvento getUbicacion() {
		return ubicacion;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public void setSugerenciaSeleccionada(Sugerencia sugerencia) {
		this.sugerenciaSeleccionada = sugerencia;
	}

	public void setEstado(EnumEstadoEvento estado) {
		this.estado = estado;
	}

	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUbicacion(UbicacionEvento ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void ProcesarEvento() throws IOException {
		
		 this.servidorCola.EncolarNuevoEvento(this);
		
	}
	
	public InvokerGestorEvento getInvoker() {
		return invoker;
	}

	public void nuevoEvento(LocalDate fechaEvento, Usuario usuario, UbicacionEvento ubicacion, TipoEvento tipo){
						
			this.fechaEvento = fechaEvento;
			this.usuario = usuario;
			this.ubicacion = ubicacion;
			this.tipoEvt = tipo;
			this.fechaAlta = LocalDate.now();
			this.setTemperaturaMinima(0);
			this.setTemperaturaMaxima(0);
			this.estado = EnumEstadoEvento.NUEVO;
	}

	public int getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public List<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}

	public void setTemperaturaMinima(int temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public int getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(int temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}
	
}
