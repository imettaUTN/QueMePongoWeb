package Desarrollo;
import java.util.*;

import Desarrollo.Enumerados.EnumEstadoSugerencia;

public class Sugerencia {
	
	private int idSugerencia;
	private Prenda parteSuperior4;
	private Object parteSuperior3;
	private Prenda parteSuperior2;
	private Prenda parteSuperior1;
	private Prenda parteInferior2;
	private Prenda parteInferior1;
	private Prenda parteCalzado;
	private Prenda parteAccesorio;
	private int maxCapaSuperior;
	private int maxCapaInferior;
	private EnumEstadoSugerencia estado;
	int motivoDeRechazo;
	
	public int getIdSugerencia() {
		return idSugerencia;
	}

	public void setIdSugerencia(int idSugerencia) {
		this.idSugerencia = idSugerencia;
	}

	public EnumEstadoSugerencia getEstado() {
		return estado;
	}

	public void setEstado(EnumEstadoSugerencia estado) {
		this.estado = estado;
	}
	public void AceptarSugerencia() {
		this.setEstado(EnumEstadoSugerencia.ACEPTADA);
		//TODO: Bloquear las prendas que son aceptadas por el usuario.
		/*
		for(Prenda p : this.getSugerencia()) {
			p.BoquearPrenda();
		}
		*/
	}
	public void RechazarSugerencia() {
		this.setEstado(EnumEstadoSugerencia.RECHAZADA);
		
		//TODO: Cambiar estado a prendas que fueron rechazadas.
		
		/*
		for(Prenda p : this.getSugerencia()) {
			p.SetDisponibleParaSugerir();
		}
		*/
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
		this.parteSuperior3 = prendaCapaTres;
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
