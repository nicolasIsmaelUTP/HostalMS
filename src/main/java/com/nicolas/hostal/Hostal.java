package com.nicolas.hostal;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.servicios.PoblarServicio;

public class Hostal {

    public static void main(String[] args) {
        DAOManager manager = new MySQLDaoManager();
        
        new PoblarServicio(manager).ejecutar();
        
    }
}
