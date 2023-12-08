package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.ReservaDAO;
import com.nicolas.hostal.modelo.Reserva;
import com.nicolas.hostal.persistencia.ReservaJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLResevaDAO implements ReservaDAO{
    
    ReservaJpaController jpa;
    
    MySQLResevaDAO(EntityManagerFactory emf){
        this.jpa = new ReservaJpaController(emf);
    }

    @Override
    public void insertar(Reserva a) {
        jpa.create(a);
    }

    @Override
    public void modificar(Reserva a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLResevaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Reserva a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLResevaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reserva> obtenerTodos() {
        return jpa.findReservaEntities();
    }

    @Override
    public Reserva obtener(Integer id) {
        return jpa.findReserva(id);
    }
    
}
