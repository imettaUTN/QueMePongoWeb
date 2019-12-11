package Desarrollo;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "SugerenciaExcluida")
public class Sugerencia{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdSugerencia")
	private int IdSugerencia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodPrenda", referencedColumnName = "CodPreda")
	private Prenda parteSuperior4;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodPrenda", referencedColumnName = "CodPreda")
	private Prenda parteSuperior3;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodPrenda", referencedColumnName = "CodPreda")
	private Prenda parteSuperior2;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodPrenda", referencedColumnName = "CodPreda")
	private Prenda parteSuperior1;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodPrenda", referencedColumnName = "CodPreda")
	private Prenda parteInferior2;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodPrenda", referencedColumnName = "CodPreda")
	private Prenda parteInferior1;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodPrenda", referencedColumnName = "CodPreda")
	private Prenda parteCalzado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodPrenda", referencedColumnName = "CodPreda")
	private Prenda parteAccesorio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UsrCod", referencedColumnName = "UsrCod")
	private Usuario usuario;
	
	private int maxCapaSuperior;
	private int maxCapaInferior;
	
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
		// TODO: Recahazar Sugerencias.
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

	public Prenda getParteSuperior4() {
		return parteSuperior4;
	}

	public void setParteSuperior4(Object prendaCapaCuatro) {
		this.parteSuperior4 = (Prenda) prendaCapaCuatro;
	}

	public Prenda getParteSuperior3() {
		return (Prenda) parteSuperior3;
	}

	public void setParteSuperior3(Object prendaCapaTres) {
		this.parteSuperior3 = (Prenda) prendaCapaTres;
	}

	public Prenda getParteSuperior2() {
		return parteSuperior2;
	}

	public void setParteSuperior2(Object prendaCapaDos) {
		this.parteSuperior2 = (Prenda) prendaCapaDos;
	}

	public Prenda getParteSuperior1() {
		return parteSuperior1;
	}

	public void setParteSuperior1(Object prendaCapaUno) {
		this.parteSuperior1 = (Prenda) prendaCapaUno;
	}

	public Prenda getParteInferior2() {
		return parteInferior2;
	}

	public void setParteInferior2(Prenda parteInferior2) {
		this.parteInferior2 = parteInferior2;
	}

	public Prenda getParteInferior1() {
		return parteInferior1;
	}

	public void setParteInferior1(Prenda parteInferior1) {
		this.parteInferior1 = parteInferior1;
	}

	public Prenda getParteCalzado() {
		return parteCalzado;
	}

	public void setParteCalzado(Prenda parteCalzado) {
		this.parteCalzado = parteCalzado;
	}

	public Prenda getParteAccesorio() {
		return parteAccesorio;
	}

	public void setParteAccesorio(Prenda parteAccesorio) {
		this.parteAccesorio = parteAccesorio;
	}

	public int getMotivoDeRechazo() {
		return motivoDeRechazo;
	}
	
	
}
