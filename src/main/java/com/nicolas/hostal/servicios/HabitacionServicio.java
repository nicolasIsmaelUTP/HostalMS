package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.HabitacionDAO;
import com.nicolas.hostal.dao.TipoHabitacionDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Habitacion;
import com.nicolas.hostal.modelo.TipoHabitacion;

import java.util.List;

public class HabitacionServicio {
    
    HabitacionDAO habitaciones;
    TipoHabitacionDAO tiposHabitaciones;

    public HabitacionServicio(){
        this.habitaciones = MySQLDaoManager.getInstance().getHabitacionDAO();
        this.tiposHabitaciones = MySQLDaoManager.getInstance().getTipoHabitacionDAO();
    }
    
    // CRUD
    
    public void registrarHabitacion(Habitacion h){
        habitaciones.insertar(h);
    }
    
    public void modificarHabitacion(Habitacion h){
        habitaciones.modificar(h);
    }
    
    public void eliminarHabitacion(Habitacion h){
        habitaciones.eliminar(h);
    }
    
    public List<Habitacion> obtenerTodasHabitaciones(){
        return habitaciones.obtenerTodos();
    }
    
    public Habitacion obtenerHabitacion(String id){
        return habitaciones.obtener(id);
    }

    // Obteniendo objeto asociado
    public TipoHabitacion obtenerTipoHabitacion(Habitacion h){
        return tiposHabitaciones.obtener(h.getTipoHabitacionId());
    }
}
