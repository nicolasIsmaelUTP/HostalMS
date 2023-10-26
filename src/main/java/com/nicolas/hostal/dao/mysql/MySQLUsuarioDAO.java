package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.UsuarioDAO;
import com.nicolas.hostal.modelo.Usuario;
import com.nicolas.hostal.persistencia.UsuarioJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLUsuarioDAO implements UsuarioDAO{

    UsuarioJpaController jpa;
    
    MySQLUsuarioDAO(EntityManagerFactory emf){
        this.jpa = new UsuarioJpaController(emf);
    }
    
    @Override
    public void insertar(Usuario a) {
        try {
            jpa.create(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Usuario a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Usuario a) {
        try {
            jpa.destroy(a.getUsername());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return jpa.findUsuarioEntities();
    }

    @Override
    public Usuario obtener(String id) {
        return jpa.findUsuario(id);
    }
    
}
