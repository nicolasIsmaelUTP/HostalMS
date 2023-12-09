package com.nicolas.hostal.vista.pagos;

import com.nicolas.hostal.modelo.Pago;
import com.nicolas.hostal.servicios.PagoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PagosTableModel extends AbstractTableModel{
    
    private final PagoServicio servicio;
    
    private List<Pago> datos = new ArrayList<>();
    
    public PagosTableModel(){
        this.servicio = new PagoServicio();
    }
    
    public void updateModel(){
        datos = servicio.obtenerTodosPagos();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Monto";
            case 2 -> "Método";
            case 3 -> "Fecha";
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
        Pago preguntado = datos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> preguntado.getId();
            case 1 -> preguntado.getMonto();
            case 2 -> preguntado.getMetodoPago().getNombre();
            case 3 -> preguntado.getFecha();
            default -> "";
        };
    }
}
