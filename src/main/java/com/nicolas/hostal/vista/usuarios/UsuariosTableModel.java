package com.nicolas.hostal.vista.usuarios;

import com.nicolas.hostal.modelo.Usuario;
import com.nicolas.hostal.servicios.ServManager;
import com.nicolas.hostal.servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuariosTableModel extends AbstractTableModel{
    
    private UsuarioServicio servicio;

    private List<Usuario> datos = new ArrayList<>();
    
    public UsuariosTableModel(ServManager manager) {
        this.servicio = manager.getUsuarioServicio();
    }

    public void updateModel() {
        datos = servicio.obtenerTodosUsuarios();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "Username";
            case 1 ->
                "Password";
            case 2 ->
                "Nombre";
            case 3 ->
                "Registro";
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario preguntado = datos.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                preguntado.getUsername();
            case 1 ->
                preguntado.getPassword();
            case 2 ->
                preguntado.getNombre();
            case 3 ->
                preguntado.getFechaRegistro();
            default ->
                "";
        };
    }
    
}
