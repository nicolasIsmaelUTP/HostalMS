package com.nicolas.hostal.vista.reservas;

import com.nicolas.hostal.modelo.Habitacion;
import com.nicolas.hostal.servicios.HabitacionServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class HabitacionesComboModel extends DefaultComboBoxModel<Habitacion> {

    private final HabitacionServicio servicio;

    private List<Habitacion> lista;

    public HabitacionesComboModel() {
        this.servicio = new HabitacionServicio();
        this.lista = new ArrayList<>();
    }

    public void update() {
        if (servicio != null) {
            removeAllElements();

            lista = servicio.obtenerTodasHabitaciones();
            for (Habitacion h : lista) {
                addElement(h);
            }
        }
    }

}
