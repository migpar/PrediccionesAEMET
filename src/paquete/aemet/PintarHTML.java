package paquete.aemet;

import java.util.List;

public class PintarHTML {

	private static String inicioHTML = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n"
			+ "    <meta charset=\"UTF-8\">\n"
			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
			+ "    <title>Tabla Covid</title>\n" + "</head>\n" + "<body>\n" + "";
	private static String finalHTML = "    \n" + "</body>\n" + "</html>";

	public static String crearHTML(Localidad l) {
		List<Dia> lista = l.getPrediccion();
		String tabla = "<table border='2a'>";
		tabla += "<tr>" + "<td style=\"background-color: #eaf195\">" + "Fecha" + "</td>"
				+ "<td style=\"background-color: #ef84f7\">" + "Temperatura Maxima" + "</td>"
				+ "<td style=\"background-color: #ef84f7\">" + "Temperatura Minima" + "</td></tr>";

		for (int i = 0; i < lista.size(); i++) {

			tabla = tabla + "<tr>";
			tabla += "<td style=\"background-color: hsl(181, 100%, 50%)\" >" + lista.get(i).getFecha() + "</td>";
			tabla += "<td style=\"background-color: hsl(63, 100%, 83%)\" >" + lista.get(i).getTemperatura().getMaxima()
					+ "</td>";
			tabla += "<td style=\"background-color: hsl(63, 100%, 83%)\" >" + lista.get(i).getTemperatura().getMinima()
					+ "</td>";

		}
		tabla += "</table>";
		return inicioHTML + tabla + finalHTML;

	}

}
