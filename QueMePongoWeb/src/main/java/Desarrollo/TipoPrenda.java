package Desarrollo;
import java.util.*;

import Desarrollo.Enumerados.EnumCapa;

public class TipoPrenda {
	
	private List<String> telasValidas = new ArrayList<String>();
	private int nivelAbrigo;
	private String descripcion;
	private EnumCapa capa;
	
	public void AddTelaValida(String tela) {
		
		this.telasValidas.add(tela);
	}
	public int getNivelAbrigo() {
		return nivelAbrigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setNivelAbrigo(int nivelAbrigo) {
		this.nivelAbrigo = nivelAbrigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean IsTelaValida(String tela) {
		return this.telasValidas.contains(tela);
	}
	
	public void agregarTelaValida(String tela){
		
		this.telasValidas.add(tela);
	}
}
