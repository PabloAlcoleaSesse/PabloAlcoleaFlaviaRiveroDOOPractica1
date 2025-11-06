package uax.FilateliaYNumismatica;

import uax.FilateliaYNumismatica.modelos.Coleccion;
import uax.FilateliaYNumismatica.controlador.Controlador;


public class Main {
    public static void main(String[] args) {

        Coleccion coleccion = new Coleccion();
        Controlador controlador = new Controlador();
        controlador.iniciar(coleccion);

    }
}