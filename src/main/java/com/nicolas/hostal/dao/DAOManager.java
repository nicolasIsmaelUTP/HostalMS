package com.nicolas.hostal.dao;

public interface DAOManager {
    
    ProductoDAO getProductoDAO();
    
    Producto_entranteDAO getProducto_entranteDAO();
    
    HabitacionDAO getHabitacionDAO();
    
    TipoHabitacionDAO getTipoHabitacionDAO();
    
    ClienteDAO getClienteDAO();
    
    MetodoPagoDAO getMetodoPagoDAO();
    
    UsuarioDAO getUsuarioDAO();
    
    RolDAO getRolDAO();
    
    VentaDAO getVentaDAO();
    
    ItemProductoDAO getItemProductoDAO();
}
