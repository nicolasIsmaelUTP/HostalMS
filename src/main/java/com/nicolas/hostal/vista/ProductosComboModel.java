package com.nicolas.hostal.vista;

import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;

public class ProductosComboModel extends DefaultComboBoxModel<Producto>{
    private ProductoDAO productos;
    
    private List<Producto> lista;

    public ProductosComboModel(ProductoDAO productos) {
        this.productos = productos;
        this.lista = new ArrayList<>();
    }
    
    public void update(){
        if (productos != null){
            lista = productos.obtenerTodos().stream()
                    .filter(p -> p.isActivo())
                    .collect(Collectors.toList());
            removeAllElements();
            for (Producto p : lista) {
                addElement(p);
            }
        }
    }
    
}
