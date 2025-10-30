package uax.FilateliaYNumismatica;

import uax.FilateliaYNumismatica.modelos.Coleccion;
import uax.FilateliaYNumismatica.modelos.EstadoConservacionMoneda;
import uax.FilateliaYNumismatica.modelos.Moneda;
import uax.FilateliaYNumismatica.servicios.Impl.ElementoColeccionableImpl;
import uax.FilateliaYNumismatica.controlador.Controlador;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Coleccion coleccion = new Coleccion();
        Controlador controlador = new Controlador();
        controlador.iniciar(coleccion);

    }
}