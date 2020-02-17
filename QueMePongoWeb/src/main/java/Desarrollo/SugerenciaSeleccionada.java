package Desarrollo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class SugerenciaSeleccionada {
	
	private List<Prenda> prendas = new ArrayList<Prenda>();

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}
}
