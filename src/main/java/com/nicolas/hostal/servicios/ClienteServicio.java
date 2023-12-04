package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.ClienteDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Cliente;
import java.util.List;

public class ClienteServicio {
    
    ClienteDAO clientes;
    
    public ClienteServicio(){
        this.clientes = MySQLDaoManager.getInstance().getClienteDAO();
    }
    
    // CRUD
    
    public void registrarCliente(Cliente c){
        clientes.insertar(c);
    }
    
    public void modificarCliente(Cliente c){
        clientes.modificar(c);
    }
    
    public void eliminarCliente(Cliente c){
        clientes.eliminar(c);
    }
    
    public List<Cliente> obtenerTodosClientes(){
        return clientes.obtenerTodos();
    }
    
    public Cliente obtenerClientePorDni(String dni){
        return clientes.obtener(dni);
    }
    
    //
    
    public boolean existeCliente(String dni){
        return (clientes.obtener(dni) != null);
    }
}
