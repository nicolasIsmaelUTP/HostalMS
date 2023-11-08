package com.nicolas.hostal.vista.habitaciones;

import com.nicolas.hostal.modelo.TipoHabitacion;
import com.nicolas.hostal.servicios.TipoHabitacionServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class TiposHabitacionComboModel extends DefaultComboBoxModel<TipoHabitacion>{
    private final TipoHabitacionServicio servicio;
    
    private List<TipoHabitacion> lista;

    public TiposHabitacionComboModel() {
        this.servicio = new TipoHabitacionServicio();
        this.lista = new ArrayList<>();
    }
    
    public void update(){
        if (servicio != null){
            removeAllElements();
            
            lista = servicio.obtenerTodosTiposHabitacion();
            for (TipoHabitacion th : lista) {
                addElement(th);
            }
        }
    }
}
