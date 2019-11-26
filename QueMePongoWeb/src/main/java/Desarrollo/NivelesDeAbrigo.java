package Desarrollo;

public class NivelesDeAbrigo {
	
	private int nivelDeAbrigo;
	private String descripcion;
	private int temperaturaLimiteInferior;
	private int temperaturaLimiteSuperior;
	
	public int obtenerNivelDeAbrigo(int temperaturaMinima, int temperaturaMaxima){
		
		int temperaturaPromedio = (temperaturaMinima + temperaturaMaxima)/2;
		int nivel = 0;
		
		//Funcion para buscar en tabla de parametros;
		
		return nivel;
	
	}

	public int getNivelDeAbrigo() {
		return nivelDeAbrigo;
	}

	public void setNivelDeAbrigo(int nivelDeAbrigo) {
		this.nivelDeAbrigo = nivelDeAbrigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTemperaturaLimiteInferior() {
		return temperaturaLimiteInferior;
	}

	public void setTemperaturaLimiteInferior(int temperaturaLimiteInferior) {
		this.temperaturaLimiteInferior = temperaturaLimiteInferior;
	}

	public int getTemperaturaLimiteSuperior() {
		return temperaturaLimiteSuperior;
	}

	public void setTemperaturaLimiteSuperior(int temperaturaLimiteSuperior) {
		this.temperaturaLimiteSuperior = temperaturaLimiteSuperior;
	}
	
	
	
}
