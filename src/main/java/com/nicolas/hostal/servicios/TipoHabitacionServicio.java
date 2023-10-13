package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.TarifaDAO;
import com.nicolas.hostal.dao.TipoHabitacionDAO;
import com.nicolas.hostal.modelo.Tarifa;
import com.nicolas.hostal.modelo.TipoHabitacion;
import java.util.List;

public class TipoHabitacionServicio {
    TipoHabitacionDAO tiposHabitacion;
    TarifaDAO tarifas;
    
    public TipoHabitacionServicio(DAOManager manager){
        this.tiposHabitacion = manager.getTipoHabitacionDAO();
        this.tarifas = manager.getTarifaDAO();
    }
    
    // CRUD
    
    public void crearTipoHabitacion(TipoHabitacion th){
        tiposHabitacion.insertar(th);
    }
    
    public void modificarTipoHabitacion(TipoHabitacion th){
        tiposHabitacion.modificar(th);
    }
    
    public void eliminarTipoHabitacion(TipoHabitacion th){
        tiposHabitacion.eliminar(th);
    }
    
    public List<TipoHabitacion> obtenerTodosTiposHabitacion(){
        return tiposHabitacion.obtenerTodos();
    } 
    
    public TipoHabitacion obtenerTipoHabitacion(int id){
        return tiposHabitacion.obtener(id);
    }
    
    // Tarifas
    
    public void agregarTarifa(TipoHabitacion th, Tarifa tarifa){
        th.getTarifas().add(tarifa);
        tiposHabitacion.modificar(th);
    }
    
    public void eliminarTarifa(TipoHabitacion th, Tarifa tarifa){
        th.getTarifas().remove(tarifa);
        tiposHabitacion.modificar(th);
    }
}
