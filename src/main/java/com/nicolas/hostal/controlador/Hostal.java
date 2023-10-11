package com.nicolas.hostal.controlador;

import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Almacen;
import com.nicolas.hostal.modelo.Producto;

public class Hostal {

    public static void main(String[] args) {
        MySQLDaoManager manager = new MySQLDaoManager();
        Producto p = manager.getProductoDAO().obtener(1);
        System.out.println("En stock de "+p.getNombre()+" hay "+Almacen.obtenerCantidad(p));
    }
}
