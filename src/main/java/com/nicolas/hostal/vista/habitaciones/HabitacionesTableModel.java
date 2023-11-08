package com.nicolas.hostal.vista.habitaciones;

import com.nicolas.hostal.modelo.Habitacion;
import com.nicolas.hostal.servicios.HabitacionServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class HabitacionesTableModel extends AbstractTableModel {

    private final HabitacionServicio servicio;

    private List<Habitacion> datos = new ArrayList<>();

    public HabitacionesTableModel() {
        this.servicio = new HabitacionServicio();
    }

    public void updateModel() {
        datos = servicio.obtenerTodasHabitaciones();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "Numero";
            case 1 ->
                "Tipo de habitacion";
            case 2 ->
                "Disponibilidad";
            default ->
                "[no]";
        };
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Habitacion preguntado = datos.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                preguntado.getNumero();
            case 1 ->
                servicio.obtenerTipoHabitacion(preguntado).getDenominacion();
            case 2 ->
                preguntado.isDisponibilidad();
            default ->
                "";
        };
    }
}
