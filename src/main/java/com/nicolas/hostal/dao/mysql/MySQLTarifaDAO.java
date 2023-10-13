package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.TarifaDAO;
import com.nicolas.hostal.modelo.Tarifa;
import com.nicolas.hostal.persistencia.TarifaJpaController;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

public class MySQLTarifaDAO implements TarifaDAO{

    TarifaJpaController jpa;
    
    MySQLTarifaDAO(EntityManagerFactory emf){
        this.jpa = new TarifaJpaController(emf);
    }
    
    @Override
    public void insertar(Tarifa a) {
        jpa.create(a);
    }

    @Override
    public void modificar(Tarifa a) {
        try {
            jpa.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(MySQLTarifaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Tarifa a) {
        try {
            jpa.destroy(a.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MySQLTarifaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Tarifa> obtenerTodos() {
        return jpa.findTarifaEntities();
    }

    @Override
    public Tarifa obtener(Integer id) {
        return jpa.findTarifa(id);
    }
    
}
