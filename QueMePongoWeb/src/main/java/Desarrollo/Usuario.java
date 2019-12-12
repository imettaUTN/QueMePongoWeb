package Desarrollo;
import java.io.IOException;
import Desarrollo.*;
import Desarrollo.ObjetosValor.UbicacionEvento;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

	@Id
	@Column(name = "UsrCod")
	private String codigoUsuario;	
	
	@Column(name = "UsrPass")
	private String password;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Apellido")
	private String apellido; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PrfCod", referencedColumnName = "PrfCod")
	private Perfil codPerfil;
	
	@Column(name = "UsrPremium")
	private boolean userPremium;
	
	private LocalDate fechaAlta;
	
	public void guardar(){
		
		JPAUtil trn = new JPAUtil();
		trn.transaccion().usuario().persistir(this);
	}
	
	/*
	@OneToMany(mappedBy = "Guardarropa", cascade = CascadeType.ALL)
	private List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();
	
	@OneToMany(mappedBy = "Evento", cascade = CascadeType.ALL)
	private List<Evento> eventos = new ArrayList<Evento>();
	*/
	
	/*
	public void CargarEvento(LocalDate fecha, UbicacionEvento ubicacion, TipoEvento tipo) throws Exception{
		
		Evento evento = new Evento();
		evento.nuevoEvento(fecha,this, ubicacion,tipo);
		this.eventos.add(evento);
		evento.ProcesarEvento();
	}
	*/
	
	// Nota: Valor false porque supera el limite disponible.
	/*
	public boolean agregarPrendaAGuardarropa(Prenda prenda, int guardarropa){
		
		return this.getGuardarropas().get(guardarropa).agregarPrenda(prenda);
		
	}
	*/
	
	/*
	public void eliminarPrenda(Prenda prenda, int guardarropa){
		
		this.getGuardarropas().get(guardarropa).eliminarPrenda(prenda);
		
	}
	*/
	
	// Ver Tema de Rechazo.
	public void aceptarSugerencia(Sugerencia sugerencia, Evento evento){
		
		/*
		for(Sugerencia sg : evento.getSugerencias()) {
			if(sg.getIdSugerencia() != sugerencia.getIdSugerencia()) {
				sugerencia.RechazarSugerencia();
			}
			else {
				sugerencia.AceptarSugerencia();
				evento.setSugerenciaSeleccionada(sugerencia);
			}
		}
		*/
		
	}
	
	/*
	public int cantidadDeGuardarropas() {
			
			return this.guardarropas.size();
			
	}
	*/
	
	/*
	public void eliminarGuardarropa(int guardarropa, boolean compartido){
		
		this.guardarropas.remove(guardarropa);
		
	}
	*/
	
	
	/*
	public void crearGuardarropa(String desc, boolean compartido){
		
		Guardarropa nuevoGuardarropa = new Guardarropa();
		nuevoGuardarropa.crearGuardarropa(desc, compartido, this);
		this.guardarropas.add(nuevoGuardarropa);
	}
	*/

	
	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Perfil getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(Perfil codPerfil) {
		this.codPerfil = codPerfil;
	}

	public boolean isUserPremium() {
		return userPremium;
	}

	public void setUserPremium(boolean userPremium) {
		this.userPremium = userPremium;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/*
	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}

	public void setGuardarropas(List<Guardarropa> guardarropas) {
		this.guardarropas = guardarropas;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	*/
	
}
