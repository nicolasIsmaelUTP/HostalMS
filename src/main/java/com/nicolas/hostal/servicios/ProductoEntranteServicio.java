package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.dao.Producto_entranteDAO;
import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.modelo.Producto_entrante;
import java.util.List;

public class ProductoEntranteServicio {

    Producto_entranteDAO entrantes;
    ProductoDAO productos;

    public ProductoEntranteServicio(DAOManager manager) {
        this.entrantes = manager.getProducto_entranteDAO();
        this.productos = manager.getProductoDAO();
    }

    public void registrarEntradaProducto(Producto_entrante pe) {
        // Aumentar la cantidad del producto
        Producto producto = productos.obtener(pe.getProducto_id());
        int cant = pe.getCantidad();
        producto.setCantidad(producto.getCantidad() + cant);
        productos.modificar(producto);

        entrantes.insertar(pe);
    }

    public void modificarEntradaProducto(Producto_entrante pe) {
        // Calcular diferencia de la edicion
        int cantEntranteInicial = entrantes.obtener(pe.getId()).getCantidad();
        int cantEntranteFinal = pe.getCantidad();
        int diferencia = cantEntranteFinal - cantEntranteInicial;

        // Disminuir o aumentar segun modificacion
        Producto producto = productos.obtener(pe.getProducto_id());
        producto.setCantidad(producto.getCantidad() + diferencia);
        productos.modificar(producto);

        entrantes.modificar(pe);
    }

    public void borrarEntradaProducto(Producto_entrante pe) {
        // Disminuir la cantidad del producto
        Producto producto = productos.obtener(pe.getProducto_id());
        int cant = pe.getCantidad();
        producto.setCantidad(producto.getCantidad() - cant);
        productos.modificar(producto);

        entrantes.eliminar(pe);
    }

    public List<Producto_entrante> obtenerTodasEntradasProducto() {
        return entrantes.obtenerTodos();
    }
    
    public Producto_entrante obtenerEntradaProducto(int id){
        return entrantes.obtener(id);
    }
}
