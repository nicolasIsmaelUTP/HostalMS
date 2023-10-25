package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;

public class ServManager {
    DAOManager dao;
    public ServManager() {
        this.dao = new MySQLDaoManager();
    }
    
    // Servicios
    private ProductoServicio productos = null;
    private ProductoEntranteServicio entrantes = null;
    private HabitacionServicio habitaciones = null;
    private ClienteServicio clientes = null;
    
    public ProductoServicio getProductoServicio() {
        if(productos == null){
            productos = new ProductoServicio(dao);
        }
        return productos;
    }

    public ProductoEntranteServicio getProductoEntranteServicio() {
        if(entrantes == null){
            entrantes = new ProductoEntranteServicio(dao);
        }
        return entrantes;
    }

    public HabitacionServicio getHabitacionServicio() {
        if(habitaciones == null){
            habitaciones = new HabitacionServicio(dao);
        }
        return habitaciones;
    }
    
    public ClienteServicio getClienteServicio(){
        if(clientes == null){
            clientes = new ClienteServicio(dao);
        }
        return clientes;
    }
}
