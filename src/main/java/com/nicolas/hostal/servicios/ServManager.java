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
    private MetodoPagoServicio metodospago = null;
    private UsuarioServicio usuarios = null;
    private RolServicio roles = null;

    public ProductoServicio getProductoServicio() {
        if (productos == null) {
            productos = new ProductoServicio(dao);
        }
        return productos;
    }

    public ProductoEntranteServicio getProductoEntranteServicio() {
        if (entrantes == null) {
            entrantes = new ProductoEntranteServicio(dao);
        }
        return entrantes;
    }

    public HabitacionServicio getHabitacionServicio() {
        if (habitaciones == null) {
            habitaciones = new HabitacionServicio();
        }
        return habitaciones;
    }

    public ClienteServicio getClienteServicio() {
        if (clientes == null) {
            clientes = new ClienteServicio(dao);
        }
        return clientes;
    }

    public MetodoPagoServicio getMetodoPagoServicio() {
        if (metodospago == null) {
            metodospago = new MetodoPagoServicio(dao);
        }
        return metodospago;
    }

    public UsuarioServicio getUsuarioServicio() {
        if (usuarios == null) {
            usuarios = new UsuarioServicio(dao);
        }
        return usuarios;
    }
    
    public RolServicio getRolServicio() {
        if (roles == null) {
            roles = new RolServicio(dao);
        }
        return roles;
    }
}
