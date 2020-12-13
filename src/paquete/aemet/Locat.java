package paquete.aemet;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "locat", strict = false)
public class Locat {

	@Element
	private String cmc;

	public Locat() {
		super();
	}

	public Locat(String cmc) {
		super();
		this.cmc = cmc;
	}

	public String getCmc() {
		return cmc;
	}

	public void setCmc(String cmc) {
		this.cmc = cmc;
	}

}
