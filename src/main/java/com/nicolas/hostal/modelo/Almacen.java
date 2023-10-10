package com.nicolas.hostal.modelo;

import java.util.ArrayList;

public class Almacen {
    private ArrayList<Producto_entrante> almacen;

    public Almacen() {
        almacen = new ArrayList<>();
    }

    public ArrayList<Producto_entrante> getAlmacen() {
        return almacen;
    }
    
    
}
