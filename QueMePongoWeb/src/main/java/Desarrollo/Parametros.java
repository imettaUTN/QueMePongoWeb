package Desarrollo;

import Desarrollo.Enumerados.EnumCategoria;

public class Parametros {
private int NivelAbrigoDeseado;
private EnumCategoria categoria;
private int rangoTemperaturaDesde;
private int rangoTemperaturaHasta;

public int getNivelAbrigoDeseado() {
	return NivelAbrigoDeseado;
}
public void setNivelAbrigoDeseado(int nivelAbrigoDeseado) {
	NivelAbrigoDeseado = nivelAbrigoDeseado;
}
public EnumCategoria getCategoria() {
	return categoria;
}
public void setCategoria(EnumCategoria categoria) {
	this.categoria = categoria;
}
public int getRangoTemperaturaDesde() {
	return rangoTemperaturaDesde;
}
public void setRangoTemperaturaDesde(int rangoTemperaturaDesde) {
	this.rangoTemperaturaDesde = rangoTemperaturaDesde;
}
public int getRangoTemperaturaHasta() {
	return rangoTemperaturaHasta;
}
public void setRangoTemperaturaHasta(int rangoTemperaturaHasta) {
	this.rangoTemperaturaHasta = rangoTemperaturaHasta;
}
}
