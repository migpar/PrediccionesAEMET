package paquete.aemet;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="root", strict =false)
public class Localidad {

    @Element(name="nombre")
    private String nombre_municipio;
    @ElementList
    private List<Dia> prediccion;

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public List<Dia> getPrediccion() {
        return prediccion;
    }

    public void setPrediccion(List<Dia> prediccion) {
        this.prediccion = prediccion;
    }

    @Override
    public String toString() {
        return "ClaseRaiz{" + "nombre_municipio=" + nombre_municipio + ", prediccion=" + prediccion + '}';
    }

}