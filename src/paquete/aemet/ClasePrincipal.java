package paquete.aemet;

import java.util.List;
import java.util.Scanner;

import paquete.aemet.PeticionesRetrofit.Actualizacion;

public class ClasePrincipal implements Actualizacion {

	static List<Provincia> listaProvincias;
	static List<Municipio> listaMunicipios;
	static Scanner sc = new Scanner(System.in);
	String prov;

	public static void main(String[] args) {
		ClasePrincipal p = new ClasePrincipal();
		p.iniciarAplicacion();

	}

	public void iniciarAplicacion() {

		listaProvincias = AccesoDatos.recuperarDatosProvincias();
		if (listaProvincias == null) {
			PeticionesRetrofit.pedirProvincias(this);
		} else {
			LecturaEscritura.escribirProvincias(listaProvincias);
			recuperarMunicipios(listaProvincias);
		}
	}

	public void recuperarMunicipios(List<Provincia> lista) {
		System.out.println("Selecciona Provincia");
		prov = sc.nextLine();
		String provincia = LecturaEscritura.elegirProvincia(lista, prov);
		List<Municipio> lista_municipios = AccesoDatos.recuperarMunicipios(prov);
		if (lista_municipios == null) {
			PeticionesRetrofit.pedirMunicipios(this, provincia);
		} else {
			LecturaEscritura.escribirMunicipios(lista_municipios);
		}
	}

	@Override
	public void recuperardatosProvincias(Provinciero p) {
		AccesoDatos.insertarTablaProvincia(p);
		listaProvincias = p.getProvinciero();
		LecturaEscritura.escribirProvincias(listaProvincias);
		recuperarMunicipios(listaProvincias);

	}

	@Override
	public void recuperardatosMunicipios(Municipiero m) {
		listaMunicipios = m.getMunicipiero();
		LecturaEscritura.escribirMunicipios(listaMunicipios);
		String codLocalidad = sc.nextLine();
		String localidad = AnalisisDatos.getLocalidad(codLocalidad, prov);
		PeticionesRetrofit.pedirLocalidad(this, localidad);

	}

	@Override
	public void recuperardatosLocalidad(Localidad l) {
		String html = PintarHTML.crearHTML(l);
		LecturaEscritura.escribirHTML(html);
		LecturaEscritura.abrirFirefox(null);

	}

}
