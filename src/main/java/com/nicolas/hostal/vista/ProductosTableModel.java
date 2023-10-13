package com.nicolas.hostal.vista;

import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.servicios.ProductoServicio;
import com.nicolas.hostal.servicios.ServManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductosTableModel extends AbstractTableModel{
    
    private ProductoServicio servicio;
    
    private List<Producto> datos = new ArrayList<>();
    
    public ProductosTableModel(ServManager manager){
        this.servicio = manager.getProductoServicio();
    }
    
    public void updateModel(){
        datos = servicio.obtenerTodosProductos();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Precio";
            case 3: return "Cantidad";
            case 4: return "Categoria";
            case 5: return "Activo";
            default: return "[no]";
        }
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
        Producto preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return preguntado.getId();
            case 1: return preguntado.getNombre();
            case 2: return preguntado.getPrecio_unitario();
            case 3: return preguntado.getCantidad();
            case 4: return preguntado.getCategoria();
            case 5: return preguntado.isActivo();
            default: return "";
        }
    }
}
