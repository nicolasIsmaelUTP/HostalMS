package com.nicolas.hostal;

import com.nicolas.hostal.servicios.PoblarServicio;
import com.nicolas.hostal.vista.Home;

public class Hostal {

    public static void main(String[] args) {        
        new PoblarServicio().ejecutar();

        Home home = new Home();
        home.setVisible(true);
    }
}
