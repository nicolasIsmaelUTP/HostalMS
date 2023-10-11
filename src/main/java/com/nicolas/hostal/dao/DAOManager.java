package com.nicolas.hostal.dao;

public interface DAOManager {
    
    ProductoDAO getProductoDAO();
    
    Producto_entranteDAO getProducto_entranteDAO();
    
    ProductoStockDAO getProductoStockDAO();
}
