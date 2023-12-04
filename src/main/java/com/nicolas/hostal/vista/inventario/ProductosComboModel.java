package com.nicolas.hostal.vista.inventario;

import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.servicios.ProductoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class ProductosComboModel extends DefaultComboBoxModel<Producto>{
    
    private ProductoServicio servicio;
    
    private List<Producto> lista;

    public ProductosComboModel() {
        this.lista = new ArrayList<>();
    }
    
    public void update(){
        this.servicio = new ProductoServicio();
        if (servicio != null){
            removeAllElements();
            
            lista = servicio.obtenerTodosProductosActivos();
            for (Producto p : lista) {
                addElement(p);
            }
        }
    }
    
}
