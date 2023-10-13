package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.HabitacionDAO;
import com.nicolas.hostal.modelo.Habitacion;
import com.nicolas.hostal.persistencia.HabitacionJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLHabitacionDAO implements HabitacionDAO{
    
    HabitacionJpaController jpa;
    
    MySQLHabitacionDAO(EntityManagerFactory emf) {
        this.jpa = new HabitacionJpaController(emf);
    }
    
    @Override
    public void insertar(Habitacion a) {
        try {
            jpa.create(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLHabitacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Habitacion a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLHabitacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Habitacion a) {
        try {
            jpa.destroy(a.getNumero());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLHabitacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Habitacion> obtenerTodos() {
        return jpa.findHabitacionEntities();
    }

    @Override
    public Habitacion obtener(String id) {
        return jpa.findHabitacion(id);
    }
    
}
