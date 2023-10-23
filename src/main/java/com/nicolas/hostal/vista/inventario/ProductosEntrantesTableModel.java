package com.nicolas.hostal.vista.inventario;

import com.nicolas.hostal.modelo.ProductoEntrante;
import com.nicolas.hostal.servicios.ProductoEntranteServicio;
import com.nicolas.hostal.servicios.ServManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductosEntrantesTableModel extends AbstractTableModel{

    private ProductoEntranteServicio servicio;
    
    private List<ProductoEntrante> datos = new ArrayList<>();
    
    public ProductosEntrantesTableModel(ServManager manager){
        this.servicio = manager.getProductoEntranteServicio();
    }
    
    public void updateModel(){
        datos = servicio.obtenerTodasEntradasProducto();
        Collections.reverse(datos);
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
        ProductoEntrante preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return preguntado.getId();
            case 1: return servicio.obtenerProducto(preguntado).getNombre();
            case 2: return preguntado.getCantidad();
            case 3: return preguntado.getFecha_entrada();
            default: return "";
        }
    }
}
