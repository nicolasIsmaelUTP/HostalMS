package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.Producto_entranteDAO;
import com.nicolas.hostal.modelo.Producto_entrante;
import com.nicolas.hostal.persistencia.Producto_entranteJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLProductoEntranteDAO implements Producto_entranteDAO{

    Producto_entranteJpaController jpa;
    
    MySQLProductoEntranteDAO(EntityManagerFactory emf){
        this.jpa = new Producto_entranteJpaController(emf);
    }
    
    @Override
    public void insertar(Producto_entrante a) {
        jpa.create(a);
    }

    @Override
    public void modificar(Producto_entrante a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLProductoEntranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Producto_entrante a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLProductoEntranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Producto_entrante> obtenerTodos() {
        return jpa.findProducto_entranteEntities();
    }

    @Override
    public Producto_entrante obtener(Integer id) {
        return jpa.findProducto_entrante(id);
    }
    
}
