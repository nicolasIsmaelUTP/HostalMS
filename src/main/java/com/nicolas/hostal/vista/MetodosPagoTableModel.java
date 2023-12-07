package com.nicolas.hostal.vista;

import com.nicolas.hostal.modelo.MetodoPago;
import com.nicolas.hostal.servicios.MetodoPagoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MetodosPagoTableModel extends AbstractTableModel {

    private final MetodoPagoServicio servicio;

    private List<MetodoPago> datos = new ArrayList<>();
    
    public MetodosPagoTableModel() {
        this.servicio = new MetodoPagoServicio();
    }

    public void updateModel() {
        datos = servicio.obtenerTodosMetodosPago();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "ID";
            case 1 ->
                "Nombre";
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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MetodoPago preguntado = datos.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                preguntado.getId();
            case 1 ->
                preguntado.getNombre();
            default ->
                "";
        };
    }

}
