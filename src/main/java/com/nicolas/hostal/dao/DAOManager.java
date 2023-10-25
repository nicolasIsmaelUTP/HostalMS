package com.nicolas.hostal.dao;

public interface DAOManager {
    
    ProductoDAO getProductoDAO();
    
    Producto_entranteDAO getProducto_entranteDAO();
    
    HabitacionDAO getHabitacionDAO();
    
    TipoHabitacionDAO getTipoHabitacionDAO();
    
    TarifaDAO getTarifaDAO();
    
    ClienteDAO getClienteDAO();
    
    MetodoPagoDAO getMetodoPagoDAO();
}
