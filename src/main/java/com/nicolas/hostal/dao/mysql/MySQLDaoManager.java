package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.ClienteDAO;
import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.HabitacionDAO;
import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.dao.Producto_entranteDAO;
import com.nicolas.hostal.dao.TarifaDAO;
import com.nicolas.hostal.dao.TipoHabitacionDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLDaoManager implements DAOManager{

    // Fábrica de Gestores de Entidades
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    
    // DAO
    private ProductoDAO productos = null;
    private Producto_entranteDAO productos_entrantes = null;
    private HabitacionDAO habitaciones = null;
    private TipoHabitacionDAO tipo_habitaciones = null;
    private TarifaDAO tarifas = null;
    private ClienteDAO clientes = null;
    
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

    @Override
    public HabitacionDAO getHabitacionDAO() {
        if(habitaciones == null){
            habitaciones = new MySQLHabitacionDAO(emf);
        }
        return habitaciones;
    }

    @Override
    public TipoHabitacionDAO getTipoHabitacionDAO() {
        if(tipo_habitaciones == null){
            tipo_habitaciones = new MySQLTipoHabitacionDAO(emf);
        }
        return tipo_habitaciones;
    }

    @Override
    public TarifaDAO getTarifaDAO() {
        if(tarifas == null){
            tarifas = new MySQLTarifaDAO(emf);
        }
        return tarifas;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        if(clientes == null){
            clientes = new MySQLClienteDAO(emf);
        }
        return clientes;
    }
    
}
