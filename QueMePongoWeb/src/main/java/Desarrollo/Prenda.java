package Desarrollo;
import java.time.LocalDate;
import javax.persistence.*;
import Desarrollo.Enumerados.*;

@Entity
@Table(name = "Prenda")
public class Prenda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodPrenda")
	int codPrenda;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	private LocalDate fechaDeCreacion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ColorPrimario", referencedColumnName = "ColorPrimario")
	private Colores colorPrimario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ColorSecundario", referencedColumnName = "ColorSecundario")
	private Colores colorSecundario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodGuardarropa", referencedColumnName = "CodGuardarropa")
	private Guardarropa guardarropa;
	
	private TipoPrenda tipoPrenda;
	private EnumCategoria categoria;
	private String tela;
	private EnumCapa numeroDeCapa;
	private String urlImagen;
	private boolean disponibleParaSugerir = true;
	private int capa;
	
	public int getCodPrenda() {
		return codPrenda;
	}

	public void setCodPrenda(int codPrenda) {
		this.codPrenda = codPrenda;
	}

	public Guardarropa getGuardarropa() {
		return guardarropa;
	}

	public void setGuardarropa(Guardarropa guardarropa) {
		this.guardarropa = guardarropa;
	}

	public int nivelAbrigo() {
		
		return this.tipoPrenda.getNivelAbrigo();
	}
	
	public int getCapa(){
		
		return this.capa;
	}
	
	public void setCapa(int capa) {
		
		this.capa = capa;
	}
	
	
	public void setNumeroCapa(EnumCapa capa){
		
		this.numeroDeCapa = capa;
	}
	
	public EnumCapa getNumeroCapa(){
		
		return this.numeroDeCapa;
	}
	
	
	public boolean esInferior(){
		
		return (categoria == EnumCategoria.Inferior);
	}
	
	public boolean esSuperior(){
		
		return (categoria == EnumCategoria.Superior);
	}
	
	public boolean esAccesorio(){
		
		return (categoria == EnumCategoria.Accesorio);
	}
	
	public boolean esCalzado(){
		
		return (categoria == EnumCategoria.Calzado);
	}
	
	public Colores getColorPrimario() {
		return colorPrimario;
	}

	public Colores getColorSecundario() {
		return colorSecundario;
	}

	public TipoPrenda getTipoPrenda() {
		return tipoPrenda;
	}

	public String getTela() {
		return tela;
	}

	public EnumCategoria getCategoria() {
		return categoria;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public boolean isDisponibleParaSugerir() {
		return disponibleParaSugerir;
	}

	public void setColorPrimario(Colores colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public void setColorSecundario(Colores colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

	public void setTipoPrenda(TipoPrenda tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public void setCategoria(EnumCategoria categoria) {
		this.categoria = categoria;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public void SetDisponibleParaSugerir() {
		this.disponibleParaSugerir = true;
	}

	public void BoquearPrenda() {
		this.disponibleParaSugerir = false;
	}
	
	public void visualizar(){
		
		System.out.print(" Prenda: " + tipoPrenda.getDescripcion() + " - Color Primario: " + colorPrimario + " - Color Secundario: " + colorSecundario + "\n");
		
	}
	
	public void setDescripcion(String desc) {
		
		this.descripcion = desc;
	}
	
	public String getDescripcion() {
		
		return this.descripcion;
	}
}
