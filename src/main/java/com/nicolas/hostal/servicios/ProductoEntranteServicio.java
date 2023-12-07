package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.dao.Producto_entranteDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.modelo.ProductoEntrante;
import java.util.List;

public class ProductoEntranteServicio {

    Producto_entranteDAO entrantes;
    ProductoDAO productos;

    public ProductoEntranteServicio() {
        this.entrantes = MySQLDaoManager.getInstance().getProducto_entranteDAO();
        this.productos = MySQLDaoManager.getInstance().getProductoDAO();
    }
    
    // CRUD

    public void registrarEntradaProducto(ProductoEntrante pe) {
        // Aumentar la cantidad del producto
        Producto producto = productos.obtener(pe.getProducto_id());
        int cant = pe.getCantidad();
        producto.setCantidad(producto.getCantidad() + cant);
        productos.modificar(producto);

        entrantes.insertar(pe);
    }

    public void modificarEntradaProducto(ProductoEntrante pe) {
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

    public void borrarEntradaProducto(ProductoEntrante pe) {
        // Disminuir la cantidad del producto
        Producto producto = productos.obtener(pe.getProducto_id());
        int cant = pe.getCantidad();
        producto.setCantidad(producto.getCantidad() - cant);
        productos.modificar(producto);

        entrantes.eliminar(pe);
    }

    public List<ProductoEntrante> obtenerTodasEntradasProducto() {
        return entrantes.obtenerTodos();
    }
    
    public ProductoEntrante obtenerEntradaProducto(int id){
        return entrantes.obtener(id);
    }
    
    // Obteniendo objetos asociados
    
    public Producto obtenerProducto(ProductoEntrante pe){
        return productos.obtener(pe.getProducto_id());
    }
}
