package com.nicolas.hostal.vista;

import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductosTableModel extends AbstractTableModel{
    
    private ProductoDAO productos;
    
    private List<Producto> datos = new ArrayList<>();
    
    public ProductosTableModel(ProductoDAO productos){
        this.productos = productos;
    }
    
    public void updateModel(){
        datos = productos.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Precio";
            case 3: return "Categoria";
            case 4: return "Activo";
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
        Producto preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return preguntado.getId();
            case 1: return preguntado.getNombre();
            case 2: return preguntado.getPrecio_unitario();
            case 3: return preguntado.getCategoria();
            case 4: return preguntado.isActivo();
            default: return "";
        }
    }
}
