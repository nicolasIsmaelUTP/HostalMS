package com.nicolas.hostal.vista;

import com.nicolas.hostal.dao.Producto_entranteDAO;
import com.nicolas.hostal.modelo.Producto_entrante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductosEntrantesTableModel extends AbstractTableModel{

    private Producto_entranteDAO entrantes;
    
    private List<Producto_entrante> datos = new ArrayList<>();
    
    public ProductosEntrantesTableModel(Producto_entranteDAO entrantes){
        this.entrantes = entrantes;
    }
    
    public void updateModel(){
        datos = entrantes.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Producto";
            case 2: return "Cantidad";
            case 3: return "Fecha";
            default: return "[no]";
        }
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
        Producto_entrante preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return preguntado.getId();
            case 1: return preguntado.getProducto_id();
            case 2: return preguntado.getCantidad();
            case 3: return preguntado.getFecha_entrada();
            default: return "";
        }
    }
}
