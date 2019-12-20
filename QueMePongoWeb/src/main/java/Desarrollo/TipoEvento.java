package Desarrollo;
import javax.persistence.*;

@Entity
@Table(name = "TipoEvento")
public class TipoEvento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodTipoEvento")
	private int codTipoEvento;
	
	@Column(name = "Descripcion")
	private String descripcion;

	public int getCodTipoEvento() {
		return codTipoEvento;
	}

	public void setCodTipoEvento(int codTipoEvento) {
		this.codTipoEvento = codTipoEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
