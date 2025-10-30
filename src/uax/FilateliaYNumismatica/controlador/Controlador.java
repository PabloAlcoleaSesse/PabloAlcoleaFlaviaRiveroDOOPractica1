package uax.FilateliaYNumismatica.controlador;

import uax.FilateliaYNumismatica.modelos.*;

import java.util.Scanner;

public class Controlador {

    public Controlador() {}
    private boolean estadoPrograma = true;

    public void iniciar(Coleccion coleccion){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
                    "Bienvenido a tu coleccion personal de sellos y monedas!");
            System.out.println("Seleccione una opcion: ");
            System.out.println("• 1-Añadir una nueva moneda ");
            System.out.println("• 2-Añadir un nuevo sello ");
            System.out.println("• 3-Mostrar todas las monedas" );
            System.out.println("• 4-Mostar todos los sellos ");
            System.out.println("• 5-Mostrar el precio total de la colección ");
            System.out.println("• 6-Mostrar la rareza media de la colección ");
            System.out.println("• 0-Salir");

            int opcion = sc.nextInt();
            sc.nextLine();


            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el pais de procedencia: ");
                    String pais = sc.nextLine();
                    System.out.println("Ingrese la autoridad gobernante: ");
                    String autoridadGobernante = sc.nextLine();
                    System.out.println("Ingrese el annus: ");
                    int annus = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el valor: ");
                    float valor = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Ingrese la unidad monetaria: ");
                    String unidadMonetaria = sc.nextLine();
                    System.out.println("Ingrese la rareza (0-100): ");
                    int rareza = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el precio: ");
                    float precio = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Ingrese la composicion: ");
                    String composicion = sc.nextLine();
                    System.out.println("Ingrese el peso en gramos: ");
                    int peso = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el diametro en mm: ");
                    float diametro = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Ingrese el grosor en mm: ");
                    float grosor = sc.nextFloat();
                    sc.nextLine();

                    int estadoConservacion;
                    do {
                        System.out.println("Ingrese el estado de conservacion (1-5):");
                        System.out.println("1. (G) Regular");
                        System.out.println("2. (VG) Bien Conservada");
                        System.out.println("3. (F) Muy bien conservada");
                        System.out.println("4. (VF) MUY bien conservada");
                        System.out.println("5. (XF) Excelente conservada");
                        System.out.println("6. (AU) Sin circular, casi perfecta");
                        System.out.println("7. (UNC) Sin circular, flor de cuño");

                        estadoConservacion = sc.nextInt();
                        if (estadoConservacion < 1 || estadoConservacion > 7) {
                            System.out.println("Estado de conservacion invalido. Intente de nuevo.");
                        }
                    } while (estadoConservacion < 1 || estadoConservacion > 8);

                    EstadoConservacionMoneda estado = EstadoConservacionMoneda.G;

                    switch (estadoConservacion) {
                        case 1:
                            break;
                        case 2:
                            estado = EstadoConservacionMoneda.VG;
                            break;
                        case 3:
                            estado = EstadoConservacionMoneda.F;
                            break;
                        case 4:
                            estado = EstadoConservacionMoneda.VF;
                            break;
                        case 5:
                            estado = EstadoConservacionMoneda.XF;
                            break;
                        case 6:
                            estado = EstadoConservacionMoneda.AU;
                            break;
                        case 7:
                            estado = EstadoConservacionMoneda.UNC;
                            break;
                    }
                    try {
                        Moneda moneda = new Moneda(pais, autoridadGobernante, annus, valor, unidadMonetaria, rareza, precio,
                                composicion, peso, diametro, grosor, estado);
                        coleccion.anadirElemento(moneda);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                case 2:
                    System.out.println("Ingrese el pais de procedencia: ");
                    String paisSello = sc.nextLine();
                    System.out.println("Ingrese la autoridad gobernante: ");
                    String autoridadGobernanteSello = sc.nextLine();
                    System.out.println("Ingrese el annus: ");
                    int annusSello = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el valor: ");
                    float valorSello = sc.nextFloat();
                    System.out.println("Ingrese la unidad monetaria: ");
                    String unidadMonetariaSello = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Ingrese la rareza: ");
                    int rarezaSello = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el precio: ");
                    float precioSello = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Ingrese el alto en mm: ");
                    float alto = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Ingrese el ancho en mm: ");
                    float ancho = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Ingrese la imagen (URL o descripcion): ");
                    String imagen = sc.nextLine();
                    sc.nextLine();
                    int estadoConservacionSello;
                    do {
                        System.out.println("Ingrese el estado de conservacion (1-5):");
                        System.out.println("1. Usado (U)");
                        System.out.println("2. Nuevo Sin Fijasellos (NSG)");
                        System.out.println("3. Nuevo Con Fallos (NF)");
                        System.out.println("4. Nuevo (N)");

                        estadoConservacionSello = sc.nextInt();
                        if (estadoConservacionSello < 1 || estadoConservacionSello > 4) {
                            System.out.println("Estado de conservacion invalido. Intente de nuevo.");
                        }
                    } while (estadoConservacionSello < 1 || estadoConservacionSello > 4);
                    EstadoConservacionSello estadoConservacionSelloEnum = EstadoConservacionSello.U;
                    switch (estadoConservacionSello) {
                        case 1:
                            break;
                        case 2:
                            estadoConservacionSelloEnum = EstadoConservacionSello.NSG;
                            break;
                        case 3:
                            estadoConservacionSelloEnum = EstadoConservacionSello.NF;
                            break;
                        case 4:
                            estadoConservacionSelloEnum = EstadoConservacionSello.N;
                            break;
                    }
                    try{
                        Sello sello = new Sello(paisSello, autoridadGobernanteSello, annusSello, valorSello, unidadMonetariaSello,
                                rarezaSello, precioSello, alto, ancho, imagen, estadoConservacionSelloEnum);
                        coleccion.anadirElemento(sello);
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    coleccion.getMonedas();
                    break;
                case 4:
                    coleccion.getSellos();
                    break;
                case 5:
                    System.out.println("El precio total de la coleccion es de: " + coleccion.getPrecioTotal()+ " €");
                    break;
                case 6:
                    System.out.println("La rareza media de la colección es:  " + coleccion.getRarezaPromedio());
                    break;
                case 0:
                    estadoPrograma = false;
                    System.out.println("Finalizando el programa. ¡Hasta luego!");
            }


        } while (estadoPrograma);

        sc.close();


    }
}
