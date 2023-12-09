package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.PagoDAO;
import com.nicolas.hostal.modelo.Pago;
import com.nicolas.hostal.persistencia.PagoJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLPagoDAO implements PagoDAO{
    
    PagoJpaController jpa;
    
    MySQLPagoDAO(EntityManagerFactory emf) {
        this.jpa = new PagoJpaController(emf);
    }
    
    @Override
    public void insertar(Pago a) {
        jpa.create(a);
    }

    @Override
    public void modificar(Pago a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Pago a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pago> obtenerTodos() {
        return jpa.findPagoEntities();
    }

    @Override
    public Pago obtener(Integer id) {
        return jpa.findPago(id);
    }
    
}
