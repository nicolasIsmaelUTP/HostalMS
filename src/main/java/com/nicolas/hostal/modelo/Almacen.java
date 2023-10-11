package com.nicolas.hostal.modelo;

import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import java.util.ArrayList;

public class Almacen {

    private static final ArrayList<Producto_entrante> entradas = new ArrayList<>(new MySQLDaoManager().getProducto_entranteDAO().obtenerTodos());

    public static ArrayList<Producto_entrante> getEntradas() {
        return entradas;
    }

    public static int obtenerCantidad(Producto p) {
        int cantidadTotal = 0;

        for (Producto_entrante entrada : entradas) {
            if (entrada.getProducto_id() == p.getId()) {
                cantidadTotal += entrada.getCantidad();
            }
        }

        return cantidadTotal;
    }
}
