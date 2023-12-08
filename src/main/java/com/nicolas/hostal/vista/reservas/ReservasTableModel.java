package com.nicolas.hostal.vista.reservas;

import com.nicolas.hostal.modelo.Reserva;
import com.nicolas.hostal.servicios.ReservaServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ReservasTableModel extends AbstractTableModel{
    
    private final ReservaServicio servicio;
    
    private List<Reserva> datos = new ArrayList<>();
    
    public ReservasTableModel(){
        this.servicio = new ReservaServicio();
    }
    
    public void updateModel(){
        datos = servicio.obtenerTodasReservas();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Habitación";
            case 2 -> "Hora prevista de llegada";
            case 3 -> "Hora prevista de salida";
            case 4 -> "Estado";
            case 5 -> "Cliente";
            default -> "[no]";
        };
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva preguntado = datos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> preguntado.getId();
            case 1 -> preguntado.getHabitacion().getNumero();
            case 2 -> preguntado.getHora_prevista_llegada();
            case 3 -> preguntado.getHora_prevista_salida();
            case 4 -> preguntado.getEstado();
            case 5 -> preguntado.getCliente().getNumDoc();
            default -> "";
        };
    }
}
