package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.dao.Producto_entranteDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLDaoManager implements DAOManager{

    // Fábrica de Gestores de Entidades
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    
    // DAO
    private ProductoDAO productos = null;
    private Producto_entranteDAO productos_entrantes = null;

    
    @Override
    public ProductoDAO getProductoDAO() {
        if(productos == null){
            productos = new MySQLProductoDAO(emf);
        }
        return productos;
    }

    @Override
    public Producto_entranteDAO getProducto_entranteDAO() {
        if(productos_entrantes == null){
            productos_entrantes = new MySQLProductoEntranteDAO(emf);
        }
        return productos_entrantes;
    }
    
}
