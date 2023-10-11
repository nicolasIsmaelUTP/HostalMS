package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.modelo.Producto;

public class TablaProductoServicio {
    
    ProductoDAO dao;

    public TablaProductoServicio(ProductoDAO dao) {
        this.dao = dao;
    }
    
    public void poblar(){
        if (dao.obtenerTodos().isEmpty()){
            dao.insertar(new Producto("Shampoo chico", 10, "Personales"));
            dao.insertar(new Producto("Shampoo grande", 18, "Personales"));
            dao.insertar(new Producto("Condones", 8, "Personales"));
            dao.insertar(new Producto("Cepillo de dientes", 5, "Personales"));
            dao.insertar(new Producto("Galletas", 2, "Alimentos"));
            dao.insertar(new Producto("Sublime", 3, "Alimentos"));
            dao.insertar(new Producto("Agua", 2, "Alimentos"));
        }
    }
}
