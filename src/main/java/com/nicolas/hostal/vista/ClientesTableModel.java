package com.nicolas.hostal.vista;

import com.nicolas.hostal.modelo.Cliente;
import javax.swing.table.AbstractTableModel;
import com.nicolas.hostal.servicios.ClienteServicio;
import com.nicolas.hostal.servicios.ServManager;
import java.util.ArrayList;
import java.util.List;

public class ClientesTableModel extends AbstractTableModel {

    private ClienteServicio servicio;

    private List<Cliente> datos = new ArrayList<>();

    public ClientesTableModel(ServManager manager) {
        this.servicio = manager.getClienteServicio();
    }

    public void updateModel() {
        datos = servicio.obtenerTodosClientes();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "DNI";
            case 1: return "Apellido paterno";
            case 2: return "Apellido materno";
            case 3: return "Primero nombre";
            case 4: return "Segundo nombre";
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente preguntado = datos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> preguntado.getNumDoc();
            case 1 -> preguntado.getApellidoPaterno();
            case 2 -> preguntado.getApellidoMaterno();
            case 3 -> preguntado.getPrimerNombre();
            case 4 -> preguntado.getSegundoNombre();
            default -> "";
        };
    }

}
