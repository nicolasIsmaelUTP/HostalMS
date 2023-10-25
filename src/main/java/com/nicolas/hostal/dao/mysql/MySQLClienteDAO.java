package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.ClienteDAO;
import com.nicolas.hostal.modelo.Cliente;
import com.nicolas.hostal.persistencia.ClienteJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLClienteDAO implements ClienteDAO{
    
    ClienteJpaController jpa;
    
    MySQLClienteDAO(EntityManagerFactory emf){
        this.jpa = new ClienteJpaController(emf);
    }

    @Override
    public void insertar(Cliente a) {
        try {
            jpa.create(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Cliente a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Cliente a) {
        try {
            jpa.destroy(a.getNumDoc());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Cliente> obtenerTodos() {
        return jpa.findClienteEntities();
    }

    @Override
    public Cliente obtener(String id) {
        return jpa.findCliente(id);
    }
    
}
