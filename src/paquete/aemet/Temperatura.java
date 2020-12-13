package paquete.aemet;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Temperatura {

    @Element
    private int minima;
    @Element
    private int maxima;

    public int getMinima() {
        return minima;
    }

    public void setMinima(int minima) {
        this.minima = minima;
    }

    public int getMaxima() {
        return maxima;
    }

    public void setMaxima(int maxima) {
        this.maxima = maxima;
    }

    @Override
    public String toString() {
        return "Temperatura{" + "minima=" + minima + ", maxima=" + maxima + '}';
    }


}