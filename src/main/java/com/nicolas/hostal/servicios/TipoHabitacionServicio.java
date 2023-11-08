package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.TipoHabitacionDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.TipoHabitacion;
import java.util.List;

public class TipoHabitacionServicio {

    TipoHabitacionDAO tiposHabitacion;

    public TipoHabitacionServicio() {
        this.tiposHabitacion = MySQLDaoManager.getInstance().getTipoHabitacionDAO();
    }

    // CRUD
    public void crearTipoHabitacion(TipoHabitacion th) {
        tiposHabitacion.insertar(th);
    }

    public void modificarTipoHabitacion(TipoHabitacion th) {
        tiposHabitacion.modificar(th);
    }

    public void eliminarTipoHabitacion(TipoHabitacion th) {
        tiposHabitacion.eliminar(th);
    }

    public List<TipoHabitacion> obtenerTodosTiposHabitacion() {
        return tiposHabitacion.obtenerTodos();
    }

    public TipoHabitacion obtenerTipoHabitacion(int id) {
        return tiposHabitacion.obtener(id);
    }

}
