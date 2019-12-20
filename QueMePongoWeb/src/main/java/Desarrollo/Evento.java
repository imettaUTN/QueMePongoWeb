 package Desarrollo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
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
	private LocalDate fechaEvento;
	
	@Column(name = "TempMinEvt")
	private int temperaturaMinima;
	
	@Column(name = "TempMaxEvt")
	private int temperaturaMaxima;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UsrCod", referencedColumnName = "UsrCod")
	private Usuario usuario;
	
	@Column(name = "Latitud")
	private float latitud;
	
	@Column(name = "Longitud")
	private float longitud;
	
	/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodTipoEvento")
	private TipoEvento tipoEvt;
	*/
	
	/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodEstadoEvt")
	private EstadoEvento estado;
	*/
	
	
	//private Sugerencia sugerenciaSeleccionada; //Debería ser XML
	//private List<Sugerencia> sugerencias = new ArrayList<Sugerencia>(); //No se persiste
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

	/*
	public EstadoEvento getEstado() {
		return estado;
	}
	*/

	public Usuario getUsuario() {
		return usuario;
	}

	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	/*
	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}
	*/

	
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

	public void nuevoEvento(LocalDate fechaEvento, Usuario usuario, float latitud, float longitud, TipoEvento tipo, EstadoEvento estado){
						
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
	
}
