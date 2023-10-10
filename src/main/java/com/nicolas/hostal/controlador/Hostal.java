package com.nicolas.hostal.controlador;

import com.nicolas.hostal.dao.mysql.MySQLProductoDAO;
import com.nicolas.hostal.modelo.Producto;

public class Hostal {

    public static void main(String[] args) {
        MySQLProductoDAO productoDAO = new MySQLProductoDAO();
        Producto p = new Producto("Gato", 124124.6, "aseo", true);
        productoDAO.insertar(p);
        System.out.println(p);
    }
}
