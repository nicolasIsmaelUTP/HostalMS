package com.nicolas.hostal.controlador;

import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.dao.mysql.MySQLProductoDAO;
import com.nicolas.hostal.modelo.Producto;

public class Hostal {

    public static void main(String[] args) {
        MySQLDaoManager daomanager = new MySQLDaoManager();
        System.out.println(daomanager.getProductoDAO().obtenerTodos());
    }
}
