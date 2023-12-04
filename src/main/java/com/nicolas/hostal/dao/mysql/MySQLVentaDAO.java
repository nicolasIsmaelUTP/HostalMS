package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.VentaDAO;
import com.nicolas.hostal.modelo.Venta;
import com.nicolas.hostal.persistencia.VentaJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLVentaDAO implements VentaDAO{
    
    VentaJpaController jpa;
    
    MySQLVentaDAO(EntityManagerFactory emf) {
        this.jpa = new VentaJpaController(emf);
    }
    
    @Override
    public void insertar(Venta a) {
        jpa.create(a);
    }

    @Override
    public void modificar(Venta a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Venta a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Venta> obtenerTodos() {
        return jpa.findVentaEntities();
    }

    @Override
    public Venta obtener(Integer id) {
        return jpa.findVenta(id);
    }
    
}
