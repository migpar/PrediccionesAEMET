package paquete.aemet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LecturaEscritura {
	
	private static String pathWrite = "/home/miguel/eclipse-Acceso-a-datos/PrediccionesAEMET/html/tabla.html";

	public static void escribirProvincias(List<Provincia> lista) {

		for (Provincia provincia : lista) {
			System.out.println(provincia.getCpine() + " - " + provincia.getNp());
		}

	}

	public static void escribirMunicipios(List<Municipio> lista) {

		for (Municipio municipio : lista) {
			System.out.println(
					municipio.getNm() + " - " + municipio.getLi().getCm());
		}

	}

	public static String elegirProvincia(List<Provincia> lista, String prov) {
		String resultado = "";
		for (Provincia provincia : lista) {
			if (provincia.getCpine().equals(prov)) {
				resultado = provincia.getNp().toLowerCase();

				break;
			}
		}
		resultado = resultado.substring(0, 1).toUpperCase() + resultado.substring(1);
		System.out.println(resultado);// prueba para ver como lo escribe
		return resultado;
	}
	
	public static void escribirHTML(String html) {
		
		try {
			FileWriter fw = new FileWriter(pathWrite);
			fw.write(html);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void abrirFirefox(String path) {
		ProcessBuilder pb = new ProcessBuilder("firefox", pathWrite);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
