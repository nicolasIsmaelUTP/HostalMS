package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.ClienteDAO;
import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.MetodoPagoDAO;
import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.dao.RolDAO;
import com.nicolas.hostal.modelo.Cliente;
import com.nicolas.hostal.modelo.MetodoPago;
import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.modelo.Rol;

public class PoblarServicio {

    ProductoDAO productos;
    ClienteDAO clientes;
    MetodoPagoDAO metodosPago;
    RolDAO roles;

    public PoblarServicio(DAOManager manager) {
        this.productos = manager.getProductoDAO();
        this.clientes = manager.getClienteDAO();
        this.metodosPago = manager.getMetodoPagoDAO();
        this.roles = manager.getRolDAO();
    }
    
    public void ejecutar(){
        poblarProductos();
        poblarClientes();
        poblarMetodosPago();
        poblarRoles();
    }

    public void poblarProductos() {
        if (productos.obtenerTodos().isEmpty()) {
            productos.insertar(new Producto("Shampoo chico", 10, "Personales"));
            productos.insertar(new Producto("Shampoo grande", 18, "Personales"));
            productos.insertar(new Producto("Condones", 8, "Personales"));
            productos.insertar(new Producto("Cepillo de dientes", 5, "Personales"));
            productos.insertar(new Producto("Galletas", 2, "Alimentos"));
            productos.insertar(new Producto("Sublime", 3, "Alimentos"));
            productos.insertar(new Producto("Agua", 2, "Alimentos"));
        }
    }

    public void poblarClientes() {
        if (clientes.obtenerTodos().isEmpty()) {
            clientes.insertar(new Cliente("74184941", "Nicolas", "Ismael", "Alayo", "Arias"));
            clientes.insertar(new Cliente("12345678", "Juan", "Carlos", "Chavez", "Perez"));
            clientes.insertar(new Cliente("87654321", "Isaac", "Maria", "Rodriguez", "Lopez"));
            clientes.insertar(new Cliente("55555555", "Victor", "Alberto", "Torres", "Chavez"));
            clientes.insertar(new Cliente("99999999", "Mariana", "Beatriz", "Sanchez", "Martinez"));
            clientes.insertar(new Cliente("77777777", "Diego", "Andres", "Gomez", "Vargas"));
            clientes.insertar(new Cliente("44444444", "Lucia", "Valeria", "Huaman", "Mendoza"));
        }
    }
    
    public void poblarMetodosPago(){
        if(metodosPago.obtenerTodos().isEmpty()){
            metodosPago.insertar(new MetodoPago("Yape"));
            metodosPago.insertar(new MetodoPago("Plin"));
            metodosPago.insertar(new MetodoPago("Efectivo"));
        }
    }
    
    public void poblarRoles(){
        if(roles.obtenerTodos().isEmpty()){
            roles.insertar(new Rol("admin"));
            roles.insertar(new Rol("gerente"));
            roles.insertar(new Rol("recepcionista"));
            roles.insertar(new Rol("almacenero"));
        }
    }
}
