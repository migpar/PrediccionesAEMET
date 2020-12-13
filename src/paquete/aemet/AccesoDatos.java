package paquete.aemet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos {

	public static List<Provincia> recuperarDatosProvincias() {
		Connection c;
		ArrayList<Provincia> lista = new ArrayList<Provincia>();
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBpruebas", "root", "rootpw");
			Statement stmt = c.createStatement();
			String qwery = "SELECT * FROM DBpruebas.Provincias;";
			ResultSet rset = stmt.executeQuery(qwery);
			if (rset.next() == false) {
				return null;
			}
			 do {
				Provincia p = new Provincia(rset.getString("cpine"), rset.getString("np"));
				lista.add(p);
			}while (rset.next());

			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
	
	public static List<Municipio> recuperarMunicipios(String prov) {
		Connection c;
		ArrayList<Municipio> lista = new ArrayList<Municipio>();
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBpruebas", "root", "rootpw");
			Statement stmt = c.createStatement();
			String qwery = "SELECT * FROM DBpruebas.Municipios;";
			ResultSet rset = stmt.executeQuery(qwery);
			if (rset.next() == false) {
				return null;
			}
			while (rset.next()) {
				//String nm, Locat lc, Loine li
				Municipio municipio = new Municipio(rset.getString("nm"), new Locat(rset.getString("lc")), new Loine(rset.getString("li")));
				lista.add(municipio);
			}

			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	public static void insertarTablaProvincia(Provinciero p) {

		try {
			List<Provincia> lista = p.getProvinciero();
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBpruebas", "root", "rootpw");
			Statement stmt = c.createStatement();
			System.out.println("conexion Establecida");
			for (Provincia provincia : lista) {
				String insert = "INSERT INTO `Provincias` VALUES('" + provincia.getCpine() + "', '" + provincia.getNp()
						+ "');";
				stmt.executeUpdate(insert);
			}
			c.close();
			System.out.println("datos insertados");
		} catch (SQLException e) {
			crearTablaProvincia();
			List<Provincia> lista = p.getProvinciero();
			Connection c;
			try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBpruebas", "root", "rootpw");
				Statement stmt = c.createStatement();
				for (Provincia provincia : lista) {
					String insert = "INSERT INTO `Provincias` VALUES('" + provincia.getCpine() + "', '"
							+ provincia.getNp() + "');";
					stmt.executeUpdate(insert);
				}
			} catch (SQLException e1) {

			}

		}
	}

	public static void crearTablaProvincia() {

		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBpruebas", "root", "rootpw");
			Statement stmt = c.createStatement();
			String qwery = "CREATE TABLE `DBpruebas`.`Provincias` (\n" + "  `cpine` VARCHAR(2) NOT NULL,\n"
					+ "  `np` VARCHAR(45) NOT NULL,\n" + "  PRIMARY KEY (`cpine`));";
			stmt.executeUpdate(qwery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
