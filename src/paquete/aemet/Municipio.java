package paquete.aemet;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Municipio {
	@Element
	private String nm;
	@Element
	private Locat locat;
	@Element
	private Loine loine;
	

	public Municipio() {
		super();
	}

	public Municipio(String nm, Locat lc, Loine li) {
		super();
		this.nm = nm;
		this.locat = lc;
		this.loine = li;
	}

	public Loine getLi() {
		return loine;
	}

	public void setLi(Loine li) {
		this.loine = li;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public Locat getLc() {
		return locat;
	}

	public void setLc(Locat lo) {
		this.locat = lo;
	}

}
