package Desarrollo;
import java.time.LocalDate;
import javax.persistence.*;
import Desarrollo.Enumerados.*;

@Entity
@Table(name = "Prendas")
public class Prenda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodPrenda")
	int codPrenda;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "ColorPrimario")
	private String  colorPrimario;
	
	@Column(name = "ColorSecundario")
	private String colorSecundario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodGuardarropa", referencedColumnName = "CodGuardarropa")
	private Guardarropa guardarropa;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodTipoPrenda", referencedColumnName = "CodTipoPrenda")
	private TipoPrenda tipoPrenda;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodCategoria", referencedColumnName = "CodCategoria")
	private Categoria categoria;
	
	@Column(name = "PrendaDisponible")
	private boolean disponible = true;
	
	@Transient
	private EnumCapa numeroDeCapa;
	
	@Transient
	private String urlImagen;
	
	public void guardar(){
		
		JPAUtil trn = new JPAUtil();
		trn.transaccion().prenda().persistir(this);
	}
	
	public int nivelAbrigo() {
		
		int abrigo = this.tipoPrenda.getNivelAbrigo().getId();
		
		return abrigo; 
	}
	
	public boolean esInferior(){
		
		return (categoria.getDescripcion() == "Inferior");
	}
	
	public boolean esSuperior(){
		
		return (categoria.getDescripcion() == "Superior");
	}
	
	public boolean esAccesorio(){
		
		return (categoria.getDescripcion() == "Accesorios");
	}
	
	public boolean esCalzado(){
		
		return (categoria.getDescripcion() == "Calzado");
	}
	
	public void BoquearPrenda() {
		this.disponible = false;
	}
	
	public void DesbloquearPrenda() {
		this.disponible = false;
	}
	
	public void visualizar(){
		
		System.out.print(" Prenda: " + tipoPrenda.getDescripcion() + " - Color Primario: " + colorPrimario + " - Color Secundario: " + colorSecundario + "\n");
		
	}
	
	public String getDescripcion() {
		
		return this.descripcion;
	}
	
	public int getCapa(){
		
		return this.tipoPrenda.getCapa();
	}

	public int getCodPrenda() {
		return codPrenda;
	}

	public void setCodPrenda(int codPrenda) {
		this.codPrenda = codPrenda;
	}

	public String getColorPrimario() {
		return colorPrimario;
	}

	public void setColorPrimario(String colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public String getColorSecundario() {
		return colorSecundario;
	}

	public void setColorSecundario(String colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

	public Guardarropa getGuardarropa() {
		return guardarropa;
	}

	public void setGuardarropa(Guardarropa guardarropa) {
		this.guardarropa = guardarropa;
	}

	public TipoPrenda getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(TipoPrenda tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public EnumCapa getNumeroDeCapa() {
		return numeroDeCapa;
	}

	public void setNumeroDeCapa(EnumCapa numeroDeCapa) {
		this.numeroDeCapa = numeroDeCapa;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDisponibleParaSugerir(boolean disponibleParaSugerir) {
		this.disponible = disponibleParaSugerir;
	}
}
