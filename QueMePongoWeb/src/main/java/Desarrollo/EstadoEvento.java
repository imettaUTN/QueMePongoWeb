package Desarrollo;
import javax.persistence.*;

@Entity
@Table(name = "EstadoEvento")
public class EstadoEvento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodEstadoEvt")
	private int id;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
