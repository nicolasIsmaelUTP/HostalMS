package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.dao.Producto_entranteDAO;
import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.modelo.Producto_entrante;

public class ProductoEntranteServicio {
    Producto_entranteDAO entrantes;
    ProductoDAO productos;

    public ProductoEntranteServicio(Producto_entranteDAO entrantes, ProductoDAO productos) {
        this.entrantes = entrantes;
        this.productos = productos;
    }
    
    public void registrarEntradaProducto(Producto_entrante pe){
        entrantes.insertar(pe);
        
        // Aumentar la cantidad del producto
        Producto producto = productos.obtener(pe.getProducto_id());
        int cant = pe.getCantidad();
        producto.setCantidad(producto.getCantidad()+cant);
        productos.modificar(producto);
    }
    
}
