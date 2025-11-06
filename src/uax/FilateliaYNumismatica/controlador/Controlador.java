package uax.FilateliaYNumismatica.controlador;

import uax.FilateliaYNumismatica.modelos.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static uax.FilateliaYNumismatica.servicios.Impl.ElementoColeccionableImpl.rangoRareza;

public class Controlador {

    public Controlador() {
        this.sc = new Scanner(System.in);
    }
    private boolean estadoPrograma = true;
    private Scanner sc;

    public void iniciar(Coleccion coleccion){
        try {
            sc = new Scanner(System.in);
            do {
                mostrarMenu();
                int opcion = leerOpcionMenu();
                procesarOpcion(opcion, coleccion);
            } while (estadoPrograma);
        }catch(Exception e){
                System.out.println("Ha ocurrido un error: " + e.getMessage());
                e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
    private void mostrarMenu(){
        System.out.println("Bienvenido a tu coleccion personal de sellos y monedas!");
        System.out.println("• 1-Añadir una nueva moneda ");
        System.out.println("• 2-Añadir un nuevo sello ");
        System.out.println("• 3-Mostrar todas las monedas");
        System.out.println("• 4-Mostar todos los sellos ");
        System.out.println("• 5-Mostrar el precio total de la colección ");
        System.out.println("• 6-Mostrar la rareza media de la colección ");
        System.out.println("• 0-Salir");
        System.out.println("Seleccione una opcion: (0-6) ");
    }
    private int leerOpcionMenu() {
        try {
            int opcion = sc.nextInt();
            sc.nextLine();
            return opcion;
        }catch(InputMismatchException e){
            sc.nextLine();
            System.out.println("Error: debe introducir un número"   );
            return -1;
        }
    }

    private void procesarOpcion(int opcion, Coleccion coleccion){
        switch (opcion) {
            case 1:
                anadirMoneda(coleccion);
                break;
            case 2:
                anadirSello(coleccion);
                break;
            case 3:
                coleccion.getMonedas();
                break;
            case 4:
                coleccion.getSellos();
                break;
            case 5:
                System.out.println("El precio total de la coleccion es de: " + coleccion.getPrecioTotal() + " €");
                break;
            case 6:
                System.out.println("La rareza media de la colección es:  " + coleccion.getRarezaPromedio());
                break;
            case 0:
                estadoPrograma = false;
                System.out.println("Finalizando el programa. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opcion invalida. Intente de nuevo.");
        }

    }

    private void anadirMoneda(Coleccion coleccion){
        try{
            //Input de datos de la moneda
            System.out.println("Ingrese el pais de procedencia: ");
            String pais = sc.nextLine();

            System.out.println("Ingrese la autoridad gobernante: ");
            String autoridadGobernante = sc.nextLine();

            int annus = leerEnteroPositivo("Ingrese el annus: ");
            float valor = leerFloatPositivo("Ingrese el valor: ");

            System.out.println("Ingrese la unidad monetaria: ");
            String unidadMonetaria = sc.nextLine();

            int rareza_= leerRareza();
            float precio = leerFloatPositivo("Ingrese el precio: ");

            System.out.println("Ingrese la composicion: ");
            String composicion = sc.nextLine();

            int peso = leerEnteroPositivo("Ingrese el peso en gramos: ");
            float diametro = leerFloatPositivo("Ingrese el diametro en mm: ");
            float grosor = leerFloatPositivo("Ingrese el grosor en mm: ");

            EstadoConservacionMoneda estado = leerEstadoConservacionMoneda();

            Moneda moneda = new Moneda(pais, autoridadGobernante, annus, valor, unidadMonetaria, rareza_, precio,
                    composicion, peso, diametro, grosor, estado);

            coleccion.anadirElemento(moneda);
            System.out.println("Moneda añadida correctamente.");
        }catch(IllegalArgumentException e){
            System.out.println("Error al crear la moneda: " + e.getMessage());
        }catch(InputMismatchException e){
            sc.nextLine();
            System.out.println("Tipo de dato incorrecto " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error inesperado: " + e.getMessage());
        }

    }
    private void anadirSello(Coleccion coleccion){
        try {
            System.out.println("Ingrese el pais de procedencia: ");
            String paisSello = sc.nextLine();
            System.out.println("Ingrese la autoridad gobernante: ");
            String autoridadGobernanteSello = sc.nextLine();

            int annusSello = leerEnteroPositivo("Ingrese el annus: ");
            float valorSello = leerFloatPositivo("Ingrese el valor: ");
            System.out.println("Ingrese la unidad monetaria: ");
            String unidadMonetariaSello = sc.nextLine();
            int rarezaSello = leerRareza();
            float precioSello = leerFloatPositivo("Ingrese el precio: ");
            float alto = leerFloatPositivo("Ingrese el alto en mm: ");
            float ancho = leerFloatPositivo("Ingrese el ancho en mm: ");
            System.out.println("Ingrese la imagen (URL o descripcion): ");
            String imagen = sc.nextLine();

            EstadoConservacionSello estadoConservacionSelloEnum = leerEstadoConservacionSello();
            Sello sello = new Sello(paisSello, autoridadGobernanteSello, annusSello, valorSello, unidadMonetariaSello,
                    rarezaSello, precioSello, alto, ancho, imagen, estadoConservacionSelloEnum);
            coleccion.anadirElemento(sello);
            System.out.println("Sello añadido correctamente.");

        }catch(IllegalArgumentException e){
            System.out.println("Error al crear el sello : " + e.getMessage());
        }catch (InputMismatchException e){
            sc.nextLine();
            System.out.println("Tipo de dato incorrecto " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    private int leerRareza(){
        int rareza = 0;
        do {
            rareza = leerEnteroPositivo("Ingrese la rareza (0-100): ");
            if (!rangoRareza(rareza)) {
                System.out.println("Rareza invalida. Intente de nuevo.");
            }
        }while (!rangoRareza(rareza));
        return rareza;
    }

    private EstadoConservacionMoneda leerEstadoConservacionMoneda(){
        int opcion;
        do{
            System.out.println("Ingrese el estado de conservacion (1-7):");
            System.out.println("1. (G) Regular");
            System.out.println("2. (VG) Bien Conservada");
            System.out.println("3. (F) Muy bien conservada");
            System.out.println("4. (VF) MUY bien conservada");
            System.out.println("5. (XF) Excelente conservada");
            System.out.println("6. (AU) Sin circular, casi perfecta");
            System.out.println("7. (UNC) Sin circular, flor de cuño");

            opcion = leerEnteroPositivo("Seleccione una opcion(1-7): ");
            if (opcion < 1 || opcion > 7) {
                System.out.println("Estado de conservacion invalido. Intente de nuevo.");
            }
        }while (opcion < 1 || opcion > 7);
        EstadoConservacionMoneda[] estados = EstadoConservacionMoneda.values();
        return estados[opcion - 1];
    }

    private EstadoConservacionSello leerEstadoConservacionSello(){
        int opcion;
        do{
            System.out.println("Ingrese el estado de conservacion (1-4):");
            System.out.println("1. Usado (U)");
            System.out.println("2. Nuevo Sin Fijasellos (NSG)");
            System.out.println("3. Nuevo Con Fallos (NF)");
            System.out.println("4. Nuevo (N)");

            opcion = leerEnteroPositivo("Seleccione una opcion(1-4): ");
            if (opcion < 1 || opcion > 4) {
                System.out.println("Estado de conservacion invalido. Intente de nuevo.");
            }
        }while (opcion < 1 || opcion > 4);
        EstadoConservacionSello[] estados = EstadoConservacionSello.values();
        return estados[opcion - 1];
    }

    private int leerEntero(String msg){
        while(true){
            try{
                System.out.println(msg);
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Error: debe introducir un número entero.");
            }
        }
    }

    private int leerEnteroPositivo(String msg){
        int valor;
        do{
            valor = leerEntero(msg);
            if(valor < 0){
                System.out.println("Error: debe introducir un número entero positivo.");
            }
        }while(valor < 0);
        return valor;
    }

    private float leerFloat(String msg){
        while(true){
            try{
                System.out.println(msg);
                float valor = sc.nextFloat();
                sc.nextLine();
                return valor;
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Error: debe introducir un número.");
            }
        }
    }

    private float leerFloatPositivo(String msg){
        float valor;
        do{
            valor = leerFloat(msg);
            if(valor < 0){
                System.out.println("Error: debe introducir un número positivo.");
            }
        }while(valor < 0);
        return valor;
    }


}
