package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.ItemProductoDAO;
import com.nicolas.hostal.modelo.ItemProducto;
import com.nicolas.hostal.persistencia.ItemProductoJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLItemProductoDAO implements ItemProductoDAO{
    
    ItemProductoJpaController jpa;
    
    MySQLItemProductoDAO(EntityManagerFactory emf) {
        this.jpa = new ItemProductoJpaController(emf);
    }
    
    @Override
    public void insertar(ItemProducto a) {
        jpa.create(a);
    }

    @Override
    public void modificar(ItemProducto a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLItemProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(ItemProducto a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLItemProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ItemProducto> obtenerTodos() {
        return jpa.findItemProductoEntities();
    }

    @Override
    public ItemProducto obtener(Integer id) {
        return jpa.findItemProducto(id);
    }
    
}
