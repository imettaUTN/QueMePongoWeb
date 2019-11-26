package Desarrollo.Enumerados;

public enum EnumCapa {
	
	Primera("Primera Capa de Ropa",1), 
	Segunda("Segunda Capa de Ropa",2), 
	Tercera("Tercera Capa de Ropa",3), 
	Cuarta("Cuarta Capa de Ropao",4); 
	
	private String descripcion;
	private int valor;
	
	private EnumCapa (String descripcion, int valor){
		
		this.descripcion = descripcion;
		this.valor = valor;
	}
}
