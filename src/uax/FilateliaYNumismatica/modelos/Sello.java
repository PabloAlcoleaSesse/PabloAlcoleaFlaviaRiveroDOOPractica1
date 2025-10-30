package uax.FilateliaYNumismatica.modelos;

import uax.FilateliaYNumismatica.servicios.Impl.ElementoColeccionableImpl;

public class Sello extends ElementoColeccionableImpl {
    private float alto;
    private float ancho;
    private String imagen;
    private EstadoConservacionSello estadoConservacion;

    public Sello (String pais, String autoridadGobernante, int annus, float valor, String unidadMonetaria, int rareza, float precio,
           float alto, float ancho, String imagen, EstadoConservacionSello estadoConservacion) {
        super (pais, autoridadGobernante, annus, valor, unidadMonetaria, rareza, precio);
        this.alto = alto;
        this.ancho = ancho;
        this.imagen = imagen;
        this.estadoConservacion = estadoConservacion;
    }

    public String toString() {
        return "Sello{" +
                "Pais='" + pais + '\'' +
                ", Autoridad Gobernante='" + autoridadGobernante + '\'' +
                ", Annus=" + annus +
                ", Valor=" + valor +
                ", Unidad Monetaria='" + unidadMonetaria + '\'' +
                ", Rareza=" + rareza +
                ", Precio=" + precio +
                ", " +
                "alto=" + alto +
                ", ancho=" + ancho +
                ", imagen='" + imagen + '\'' +
                ", estadoConservacion=" + estadoConservacion +
                "} " + super.toString();
    }

}
