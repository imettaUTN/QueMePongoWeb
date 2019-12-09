package Desarrollo;
import javax.persistence.*;

@Entity
@Table(name = "Colores")

public class Colores {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodColor")
	private int codColor;
	
	@Column(name = "Descripcion")
	private String descripcion;

	public int getCodColor() {
		return codColor;
	}

	public void setCodColor(int codColor) {
		this.codColor = codColor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
