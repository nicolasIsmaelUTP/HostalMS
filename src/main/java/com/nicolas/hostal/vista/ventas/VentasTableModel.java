package com.nicolas.hostal.vista.ventas;

import com.nicolas.hostal.modelo.ItemProducto;
import java.util.List;  
import java.util.ArrayList;
import com.nicolas.hostal.servicios.ItemProductoServicio;
import javax.swing.table.AbstractTableModel;


public class VentasTableModel extends AbstractTableModel {

    private final ItemProductoServicio servicio;

    private List<ItemProducto> datos = new ArrayList<>();

    public VentasTableModel() {
        this.servicio = new ItemProductoServicio();
    }

    public void updateModel() {
        datos = servicio.obtenerItemsProductoTemporales();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Cantidad";
            case 2: return "Producto";
            case 3: return "Precio Unitario";
            case 4: return "Total";
            default: return "[no]";
        }
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemProducto item = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getId();
            case 1: return item.getCantidad();
            case 2: return item.getProducto().getNombre();
            case 3: return item.getPrecio_unitario();
            case 4: return item.getTotal();
            default: return "";
        }
    }
}

