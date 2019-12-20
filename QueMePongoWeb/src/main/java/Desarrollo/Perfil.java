package Desarrollo;

import javax.persistence.*;

@Entity
@Table(name = "Perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PrfCod")
	private int codigoPerfil;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	public int getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(int codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void guardar(){
		
		JPAUtil trn = new JPAUtil();
		trn.transaccion().perfil().persistir(this);
	}
	
	public Perfil recuperar(int id){
		
		JPAUtil trn = new JPAUtil();
		return trn.transaccion().perfil().buscarPorId(id);
	}
}
