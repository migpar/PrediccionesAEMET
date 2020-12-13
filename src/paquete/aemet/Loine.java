package paquete.aemet;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "loine", strict = false)
public class Loine {

	@Element
	private String cm;

	public Loine() {
		super();
	}

	public Loine(String cm) {
		super();
		this.cm = cm;
	}

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}

}
