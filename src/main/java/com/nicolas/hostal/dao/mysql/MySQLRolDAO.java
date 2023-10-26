package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.RolDAO;
import com.nicolas.hostal.modelo.Rol;
import com.nicolas.hostal.persistencia.RolJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLRolDAO implements RolDAO{

    RolJpaController jpa;
    
    MySQLRolDAO(EntityManagerFactory emf){
        this.jpa = new RolJpaController(emf);
    }
    
    @Override
    public void insertar(Rol a) {
        jpa.create(a);
    }

    @Override
    public void modificar(Rol a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLRolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Rol a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLRolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Rol> obtenerTodos() {
        return jpa.findRolEntities();
    }

    @Override
    public Rol obtener(Integer id) {
        return jpa.findRol(id);
    }
}
