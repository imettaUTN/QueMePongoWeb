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

}
