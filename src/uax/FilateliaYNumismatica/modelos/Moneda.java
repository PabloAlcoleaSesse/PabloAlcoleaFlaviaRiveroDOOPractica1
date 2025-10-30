package uax.FilateliaYNumismatica.modelos;

import uax.FilateliaYNumismatica.servicios.Impl.ElementoColeccionableImpl;

public class Moneda extends ElementoColeccionableImpl {

    private String composicion;
    private int peso;
    private float diametro;
    private float grosor;
    private EstadoConservacionMoneda estadoConservacion;


    public Moneda(String pais, String autoridadGobernante, int annus, float valor, String unidadMonetaria, int rareza, float precio,
           String composicion, int peso, float diametro, float grosor, EstadoConservacionMoneda estadoConservacion) {
        super (pais, autoridadGobernante, annus, valor, unidadMonetaria, rareza, precio);
        this.composicion = composicion;
        this.peso = peso;
        this.diametro = diametro;
        this.grosor = grosor;
        this.estadoConservacion = estadoConservacion;
    }

    public String toString() {
        return "Moneda{" +
                "Pais='" + pais + '\'' +
                ", Autoridad Gobernante='" + autoridadGobernante + '\'' +
                ", Annus=" + annus +
                ", Valor=" + valor +
                ", Unidad Monetaria='" + unidadMonetaria + '\'' +
                ", Rareza=" + rareza +
                ", Precio=" + precio +
                ", " +
                "composicion='" + composicion + '\'' +
                ", peso=" + peso +
                ", diametro=" + diametro +
                ", grosor=" + grosor +
                ", estadoConservacion=" + estadoConservacion +
                "} " + super.toString();

    }

}
