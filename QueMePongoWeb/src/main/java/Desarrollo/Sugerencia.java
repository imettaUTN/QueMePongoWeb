package Desarrollo;
import java.util.*;
import javax.persistence.*;

import Repositorio.Repositorio;

@Entity
@Table(name = "Exclusion")
public class Sugerencia{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodExclusion")
	private int IdSugerencia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UsrCod", referencedColumnName = "UsrCod")
	private Usuario usuario;
	
	@Transient
	HashMap<Integer, Prenda> prendasSugeridas = new HashMap<Integer, Prenda>();
	
	@Transient
	HashMap<Integer, Prenda> prendasRechazadas = new HashMap<Integer, Prenda>();
	
	@Transient
	private int maxCapaSuperior;
	
	@Transient
	private int maxCapaInferior;
	
	@Transient
	int motivoDeRechazo;
	
	public int getIdSugerencia() {
		return IdSugerencia;
	}

	public void setIdSugerencia(int idSugerencia) {
		IdSugerencia = idSugerencia;
	}

	public void AceptarSugerencia(Sugerencia sugerencia) {
		// TODO: Asignar sugerencia a Evento.
	}
	public void RechazarSugerencia() {
		
		JPAUtil jpa = new JPAUtil();
		jpa.transaccion().sugerenciaRechaza().persistir(this);
	}
	
	public int getMaxCapaSuperior(){
		
		return this.maxCapaSuperior;
	}
	
	public void setMaxCapaSuperior(int capa){
			
		this.maxCapaSuperior = capa; 
	}
	
	public int getMaxCapaInferior(){
		
		return this.maxCapaInferior;
	}
	
	public void setMaxCapaInferior(int capa){
		
		this.maxCapaInferior = capa;
	}
	
	public int getMotivoDeRechazo() {
		return motivoDeRechazo;
	}
	
}
