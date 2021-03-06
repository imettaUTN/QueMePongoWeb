 package Desarrollo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;
import javax.swing.text.Document;

import Desarrollo.Enumerados.EnumEstadoEvento;
import Desarrollo.ObjetosValor.UbicacionEvento;

@Entity
@Table(name = "Evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodEvento")
	private int codEvento;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "FechaEvento")
	private LocalDateTime fechaEvento; //Para cuando es el evento.
	
	@Column(name = "TempMinEvt")
	private int temperaturaMinima;
	
	@Column(name = "TempMaxEvt")
	private int temperaturaMaxima;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EstadoEvt", referencedColumnName = "CodEstadoEvt")
	private EstadoEvento estado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UsrCod", referencedColumnName = "UsrCod")
	private Usuario usuario;
	
	@Column(name = "Latitud")
	private float latitud;
	
	@Column(name = "Longitud")
	private float longitud;
	
	@Column(name = "FrecuenciaEvt")
	private int frecuencia;
	
	/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodTipoEvento")
	private TipoEvento tipoEvt;
	*/
	
	@Transient
	private Document sugerenciaSeleccionada; //Debe ser XML para persistir
	
	@Transient
	private List<Sugerencia> sugerencias = new ArrayList<Sugerencia>(); 
	

	//private ServidorColaDeEventos servidorCola;
	//private InvokerGestorEvento invoker;
	//private LocalDate fechaAlta;
	
	/*
	public ServidorColaDeEventos getServidorCola() {
		return servidorCola;
	}

	public void setServidorCola(ServidorColaDeEventos servidorCola) {
		this.servidorCola = servidorCola;
	}
	*/

	public void guardar() {
		
		JPAUtil trn = new JPAUtil();
		trn.transaccion().evento().persistir(this);
	}
	
	public EstadoEvento getEstado() {
		return estado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setFechaEvento(LocalDateTime fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	
	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}
	
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*
	public void ProcesarEvento() throws IOException {
		
		 this.servidorCola.EncolarNuevoEvento(this);
		
	}
	
	public InvokerGestorEvento getInvoker() {
		return invoker;
	}
	*/

	public void nuevoEvento(LocalDateTime fechaEvento, Usuario usuario, float latitud, float longitud, TipoEvento tipo, EstadoEvento estado){
						
			this.fechaEvento = fechaEvento;
			this.usuario = usuario;
			//this.tipoEvt = tipo;
			this.latitud = latitud;
			this.longitud = longitud;
			this.setTemperaturaMinima(0);
			this.setTemperaturaMaxima(0);
			//this.estado = estado;
	}

	public int getTemperaturaMinima() {
		return temperaturaMinima;
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

	public void setearFechaEvento(int anio, int mes, int dia, int hora, int minutos) {
		
		//LocalDate fecha = LocalDate.of(anio, mes, dia);
		LocalDateTime fecha = LocalDateTime.of(anio, mes, dia, hora, minutos);
		this.fechaEvento = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
}
