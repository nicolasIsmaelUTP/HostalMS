package com.nicolas.hostal.controlador;

import com.nicolas.hostal.dao.mysql.MySQLDaoManager;

public class Hostal {

    public static void main(String[] args) {
        MySQLDaoManager daomanager = new MySQLDaoManager();
        System.out.println(daomanager.getProductoDAO().obtenerTodos());
    }
}
