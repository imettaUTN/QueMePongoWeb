package Desarrollo;
import javax.persistence.*;

@Entity
@Table(name = "NivelAbrigo")
public class NivelDeAbrigo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CodNivelAbrigo")
	private int id;
	
	@Column(name = "TempMinima")
	private int tempMinima;
	
	@Column(name = "TempMaxima")
	private int tempMaxima;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getTempMinima() {
		return tempMinima;
	}



	public void setTempMinima(int tempMinima) {
		this.tempMinima = tempMinima;
	}



	public int getTempMaxima() {
		return tempMaxima;
	}



	public void setTempMaxima(int tempMaxima) {
		this.tempMaxima = tempMaxima;
	}



	public int obtenerNivelAbrigo(float temperatura) {
		
		int abrigo=7;
		
		return abrigo;
		
	}

}
