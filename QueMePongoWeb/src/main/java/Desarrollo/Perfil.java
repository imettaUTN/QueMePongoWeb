package Desarrollo;

import javax.persistence.*;

@Entity
@Table(name = "Perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigoPerfil;
	private String descripcion;
	
	@Column(name = "PrfCod")
	public int getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(int codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	
	@Column(name = "Descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
