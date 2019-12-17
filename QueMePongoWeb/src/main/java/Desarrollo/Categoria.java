package Desarrollo;
import javax.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodCategoria")
	private int CodCategoria;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	public int getCodCategoria() {
		return CodCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		CodCategoria = codCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
