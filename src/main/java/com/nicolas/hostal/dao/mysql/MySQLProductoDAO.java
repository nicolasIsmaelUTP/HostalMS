package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.persistencia.ProductoJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLProductoDAO implements ProductoDAO{
    
    ProductoJpaController productojpa;

    MySQLProductoDAO(EntityManagerFactory emf) {
        this.productojpa = new ProductoJpaController(emf);
    }

    @Override
    public void insertar(Producto a) {
        productojpa.create(a);
    }

    @Override
    public void modificar(Producto a) {
          try {
              productojpa.edit(a);
          } catch (Exception ex) {
              Logger.getLogger(MySQLProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void eliminar(Producto a) {
          try {
              productojpa.destroy(a.getId());
          } catch (NonexistentEntityException ex) {
              Logger.getLogger(MySQLProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productojpa.findProductoEntities();
    }

    @Override
    public Producto obtener(Integer id) {
        return productojpa.findProducto(id);
    }
    
}
