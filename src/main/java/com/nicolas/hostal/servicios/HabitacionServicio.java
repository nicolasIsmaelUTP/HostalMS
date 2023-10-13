package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.HabitacionDAO;
import com.nicolas.hostal.modelo.Habitacion;
import java.util.List;

public class HabitacionServicio {
    
    HabitacionDAO habitaciones;

    public HabitacionServicio(DAOManager manager){
        this.habitaciones = manager.getHabitacionDAO();
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
}
