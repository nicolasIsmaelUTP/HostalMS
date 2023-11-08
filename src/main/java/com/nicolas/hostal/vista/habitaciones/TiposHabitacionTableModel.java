package com.nicolas.hostal.vista.habitaciones;

import com.nicolas.hostal.modelo.TipoHabitacion;
import com.nicolas.hostal.servicios.TipoHabitacionServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TiposHabitacionTableModel extends AbstractTableModel{
        
    private final TipoHabitacionServicio servicio;
    
    private List<TipoHabitacion> datos = new ArrayList<>();
    
    public TiposHabitacionTableModel(){
        this.servicio = new TipoHabitacionServicio();
    }
    
    public void updateModel(){
        datos = servicio.obtenerTodosTiposHabitacion();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Denominacion";
            case 2 -> "Precio";
            case 3 -> "Num camas";
            default -> "[no]";
        };
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoHabitacion preguntado = datos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> preguntado.getId();
            case 1 -> preguntado.getDenominacion();
            case 2 -> preguntado.getPrecio();
            case 3 -> preguntado.getNumCamas();
            default -> "";
        };
    }
}
