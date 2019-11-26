package Desarrollo;
import java.time.LocalDate;
import Desarrollo.Enumerados.*;

public class Prenda {

	int id;
	private String descripcion;
	private LocalDate fechaDeCreacion;
	private String colorPrimario;
	private String colorSecundario;
	private TipoPrenda tipoPrenda;
	private EnumCategoria categoria;
	private String tela;
	private EnumCapa numeroDeCapa;
	private String urlImagen;
	private boolean disponibleParaSugerir = true;
	private int capa;
	
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
	
	public String getColorPrimario() {
		return colorPrimario;
	}

	public String getColorSecundario() {
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

	public void setColorPrimario(String colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public void setColorSecundario(String colorSecundario) {
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
