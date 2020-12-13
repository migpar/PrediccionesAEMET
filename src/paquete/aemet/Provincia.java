package paquete.aemet;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "prov", strict = false)
public class Provincia {
	@Element
	private String cpine;
	@Element
	private String np;

	public Provincia() {
		super();
	}

	public Provincia(String cpine, String np) {
		super();
		this.cpine = cpine;
		this.np = np;
	}

	public String getCpine() {
		return cpine;
	}

	public void setCpine(String cpine) {
		this.cpine = cpine;
	}

	public String getNp() {
		return np;
	}

	public void setNp(String np) {
		this.np = np;
	}

	@Override
	public String toString() {
		return "Provincia [cpine=" + cpine + ", np=" + np + "]";
	}

}
