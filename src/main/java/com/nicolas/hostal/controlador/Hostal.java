package com.nicolas.hostal.controlador;

import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.servicios.PoblarServicio;

public class Hostal {

    public static void main(String[] args) {
        MySQLDaoManager manager = new MySQLDaoManager();
        
        new PoblarServicio(manager.getProductoDAO()).poblar();
        
    }
}
