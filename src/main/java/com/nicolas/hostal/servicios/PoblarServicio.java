package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.ClienteDAO;
import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.MetodoPagoDAO;
import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.dao.RolDAO;
import com.nicolas.hostal.dao.TipoHabitacionDAO;
import com.nicolas.hostal.dao.UsuarioDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Cliente;
import com.nicolas.hostal.modelo.MetodoPago;
import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.modelo.Rol;
import com.nicolas.hostal.modelo.TipoHabitacion;
import com.nicolas.hostal.modelo.Usuario;
import java.util.ArrayList;
import java.util.Arrays;

public class PoblarServicio {

    ProductoDAO productos;
    ClienteDAO clientes;
    MetodoPagoDAO metodosPago;
    UsuarioDAO usuarios;
    RolDAO roles;
    TipoHabitacionDAO tiposHabitacion;

    public PoblarServicio() {
        this.productos = MySQLDaoManager.getInstance().getProductoDAO();
        this.clientes = MySQLDaoManager.getInstance().getClienteDAO();
        this.metodosPago = MySQLDaoManager.getInstance().getMetodoPagoDAO();
        this.usuarios = MySQLDaoManager.getInstance().getUsuarioDAO();
        this.roles = MySQLDaoManager.getInstance().getRolDAO();
        this.tiposHabitacion = MySQLDaoManager.getInstance().getTipoHabitacionDAO();
    }

    public void ejecutar() {
        poblarProductos();
        poblarClientes();
        poblarMetodosPago();
        poblarRoles();
        poblarUsuarios();
        poblarTiposHabitacion();
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

    public void poblarTiposHabitacion(){
        if (tiposHabitacion.obtenerTodos().isEmpty()){
            tiposHabitacion.insertar(new TipoHabitacion("Ventana a la calle basico", 25));
            tiposHabitacion.insertar(new TipoHabitacion("Ventana a la calle dia", 50));
            tiposHabitacion.insertar(new TipoHabitacion("Ventana adentro basico", 20));
            tiposHabitacion.insertar(new TipoHabitacion("Ventana adentro dia", 40));
            tiposHabitacion.insertar(new TipoHabitacion("Doble cama", 70, 2));
        }
    }
    
    public void poblarClientes() {
        if (clientes.obtenerTodos().isEmpty()) {
            clientes.insertar(new Cliente("99999999", "Mariana", "Beatriz", "Sanchez", "Martinez"));
            clientes.insertar(new Cliente("77777777", "Diego", "Andres", "Gomez", "Vargas"));
            clientes.insertar(new Cliente("44444444", "Lucia", "Valeria", "Huaman", "Mendoza"));
        }
    }

    public void poblarMetodosPago() {
        if (metodosPago.obtenerTodos().isEmpty()) {
            metodosPago.insertar(new MetodoPago("Yape"));
            metodosPago.insertar(new MetodoPago("Plin"));
            metodosPago.insertar(new MetodoPago("Efectivo"));
        }
    }

    // Roles
    Rol admin = new Rol("admin");
    Rol gerente = new Rol("gerente");
    Rol recepcionista = new Rol("recepcionista");
    Rol almacenero = new Rol("almacenero");

    // Usuarios
    Usuario nalayo = new Usuario("nalayo", "111", "Nicolas Alayo");
    Usuario jchavez = new Usuario("jchavez", "222", "Juan Carlos Chavez");
    Usuario itakamura = new Usuario("itakamura", "333", "Isaac Takamura");
    Usuario vsevillano = new Usuario("vsevillano", "444", "Victor Sevillano");
    Usuario jhurtado = new Usuario("jhurtado", "555", "Jose Hurtado");

    private void asignarRoles(){
        nalayo.setRoles(new ArrayList<>(Arrays.asList(admin,gerente)));
        jhurtado.setRoles(new ArrayList<>(Arrays.asList(recepcionista)));
    }
    
    public void poblarRoles() {
        if (roles.obtenerTodos().isEmpty()) {
            roles.insertar(admin);
            roles.insertar(gerente);
            roles.insertar(recepcionista);
            roles.insertar(almacenero);
        }
    }

    public void poblarUsuarios() {
        if (usuarios.obtenerTodos().isEmpty()) {
            
            asignarRoles();
            
            usuarios.insertar(nalayo);
            usuarios.insertar(jchavez);
            usuarios.insertar(itakamura);
            usuarios.insertar(vsevillano);
            usuarios.insertar(jhurtado);
        }
    }

}
