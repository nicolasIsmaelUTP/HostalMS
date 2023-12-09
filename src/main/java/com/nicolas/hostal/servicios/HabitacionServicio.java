package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.HabitacionDAO;
import com.nicolas.hostal.dao.TipoHabitacionDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Habitacion;
import com.nicolas.hostal.modelo.TipoHabitacion;

import java.util.List;
import java.util.stream.Collectors;

public class HabitacionServicio {

    HabitacionDAO habitaciones;
    TipoHabitacionDAO tiposHabitaciones;

    public HabitacionServicio() {
        this.habitaciones = MySQLDaoManager.getInstance().getHabitacionDAO();
        this.tiposHabitaciones = MySQLDaoManager.getInstance().getTipoHabitacionDAO();
    }

    // CRUD

    public void registrarHabitacion(Habitacion h) {
        habitaciones.insertar(h);
    }

    public void modificarHabitacion(Habitacion h) {
        habitaciones.modificar(h);
    }

    public void eliminarHabitacion(Habitacion h) {
        habitaciones.eliminar(h);
    }

    public List<Habitacion> obtenerTodasHabitaciones() {
        return habitaciones.obtenerTodos();
    }

    public Habitacion obtenerHabitacion(String id) {
        return habitaciones.obtener(id);
    }

    /**
        * Obtiene el tipo de habitación asociado a una habitación.
        * 
        * @param h la habitación de la cual se desea obtener el tipo de habitación
        * @return el tipo de habitación asociado a la habitación
        */
    public TipoHabitacion obtenerTipoHabitacion(Habitacion h) {
        return tiposHabitaciones.obtener(h.getTipoHabitacionId());
    }

    /**
     * Obtiene una lista de habitaciones disponibles.
     * 
     * @return Una lista de habitaciones disponibles.
     */
    public List<Habitacion> obtenerHabitacionesDisponibles() {
        List<Habitacion> habitaciones = obtenerTodasHabitaciones();
        return habitaciones.stream()
                .filter(Habitacion::isDisponibilidad)
                .collect(Collectors.toList());
    }
}
