package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.TipoHabitacionDAO;
import com.nicolas.hostal.modelo.TipoHabitacion;
import com.nicolas.hostal.persistencia.TipoHabitacionJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLTipoHabitacionDAO implements TipoHabitacionDAO{

    TipoHabitacionJpaController jpa;
    
    MySQLTipoHabitacionDAO(EntityManagerFactory emf){
        this.jpa = new TipoHabitacionJpaController(emf);
    }
    
    @Override
    public void insertar(TipoHabitacion a) {
        jpa.create(a);
    }

    @Override
    public void modificar(TipoHabitacion a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLTipoHabitacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(TipoHabitacion a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLTipoHabitacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TipoHabitacion> obtenerTodos() {
        return jpa.findTipoHabitacionEntities();
    }

    @Override
    public TipoHabitacion obtener(Integer id) {
        return jpa.findTipoHabitacion(id);
    }
    
}
