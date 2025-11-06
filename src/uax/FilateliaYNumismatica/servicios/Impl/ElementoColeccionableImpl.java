package uax.FilateliaYNumismatica.servicios.Impl;

import java.security.PrivilegedActionException;

public abstract class ElementoColeccionableImpl {
    protected String pais;
    protected String autoridadGobernante;
    protected int annus;
    protected float valor;
    protected String unidadMonetaria;
    protected int rareza;
    protected float precio;

    protected ElementoColeccionableImpl( String pais, String autoridadGobernante, int annus, float valor, String unidadMonetaria, int rareza, float precio) {
        this.pais = pais;
        this.autoridadGobernante = autoridadGobernante;
        this.annus = annus;
        this.rareza = rareza;
        this.valor = valor;
        this.unidadMonetaria = unidadMonetaria;
        this.precio = precio;
    }

    public static boolean rangoRareza(int rareza) {
        if (rareza > 100 || rareza < 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getRareza() {
        return rareza;
    }

    public float getPrecio() {
        return precio;
    }



}
