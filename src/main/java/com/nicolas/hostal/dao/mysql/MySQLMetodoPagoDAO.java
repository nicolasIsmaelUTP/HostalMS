package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.MetodoPagoDAO;
import com.nicolas.hostal.modelo.MetodoPago;
import com.nicolas.hostal.persistencia.MetodoPagoJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLMetodoPagoDAO implements MetodoPagoDAO{
    
    MetodoPagoJpaController jpa;
    
    MySQLMetodoPagoDAO(EntityManagerFactory emf){
        this.jpa = new MetodoPagoJpaController(emf);
    }

    @Override
    public void insertar(MetodoPago a) {
        jpa.create(a);
    }

    @Override
    public void modificar(MetodoPago a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLMetodoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(MetodoPago a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLMetodoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<MetodoPago> obtenerTodos() {
        return jpa.findMetodoPagoEntities();
    }

    @Override
    public MetodoPago obtener(Integer id) {
        return jpa.findMetodoPago(id);
    }
    
}
