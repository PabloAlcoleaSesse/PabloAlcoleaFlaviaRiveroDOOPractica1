package uax.FilateliaYNumismatica.modelos;

import uax.FilateliaYNumismatica.servicios.Impl.ElementoColeccionableImpl;

import java.util.ArrayList;


public class Coleccion {
    private final ArrayList<ElementoColeccionableImpl> colecciones = new ArrayList<>();

    public void anadirElemento(ElementoColeccionableImpl elemento) {
        colecciones.add(elemento);
    }

    public void getMonedas() {
        for (ElementoColeccionableImpl elemento : colecciones) {
            if (elemento instanceof Moneda m) {
                System.out.println(m.toString());
            }
        }
    }

    public void getSellos(){
        for (ElementoColeccionableImpl elemento : colecciones) {
            if (elemento instanceof Sello s) {
                System.out.println(s.toString());
            }
        }
    }

    public int getRarezaPromedio(){
        int rarezaTotal = 0;
        if (colecciones.isEmpty()) {
            return 0;
        }
        for (ElementoColeccionableImpl elemento : colecciones) {
            rarezaTotal += elemento.getRareza();
        }
        return rarezaTotal/ colecciones.size();

    }

    public float getPrecioTotal(){
        float precioTotal = 0;
        for (ElementoColeccionableImpl elemento : colecciones) {
            precioTotal += elemento.getPrecio();
        }
        return precioTotal;
    }
}