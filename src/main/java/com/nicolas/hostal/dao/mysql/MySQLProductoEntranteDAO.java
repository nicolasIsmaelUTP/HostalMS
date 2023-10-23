package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.Producto_entranteDAO;
import com.nicolas.hostal.modelo.ProductoEntrante;
import com.nicolas.hostal.persistencia.ProductoEntranteJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLProductoEntranteDAO implements Producto_entranteDAO{

    ProductoEntranteJpaController jpa;
    
    MySQLProductoEntranteDAO(EntityManagerFactory emf){
        this.jpa = new ProductoEntranteJpaController(emf);
    }
    
    @Override
    public void insertar(ProductoEntrante a) {
        jpa.create(a);
    }

    @Override
    public void modificar(ProductoEntrante a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLProductoEntranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(ProductoEntrante a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLProductoEntranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ProductoEntrante> obtenerTodos() {
        return jpa.findProductoEntranteEntities();
    }

    @Override
    public ProductoEntrante obtener(Integer id) {
        return jpa.findProductoEntrante(id);
    }
    
}
