package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.ClienteDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Cliente;
import java.util.List;

import javax.swing.JOptionPane;

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

    /**
     * Valida los datos de un cliente.
     * 
     * @param cliente el cliente a validar
     * @return true si los datos son válidos, false de lo contrario
     */
    public boolean validarCliente(Cliente cliente) {
        boolean validacion = true;
        if (cliente.getNumDoc().length() != 8) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "El numero de documento debe tener 8 digitos");
        }
        if (cliente.getPrimerNombre().isEmpty()) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "Falta el primer nombre");
        }
        if (cliente.getApellidoPaterno().isEmpty()) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "Falta el apellido paterno");
        }
        if (cliente.getApellidoMaterno().isEmpty()) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "Falta el apellido materno");
        }
        return validacion;
    }

    /**
     * Valida si el número de documento de un cliente tiene 8 dígitos.
     * 
     * @param cliente el cliente a validar
     * @return true si el número de documento tiene 8 dígitos, false de lo contrario
     */
    public boolean validarClienteSoloNumDoc(Cliente cliente) {
        boolean validacion = true;
        if (cliente.getNumDoc().length() != 8) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "El numero de documento debe tener 8 digitos");
        }
        return validacion;
    }

}
