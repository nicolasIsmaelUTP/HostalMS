package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Producto;
//import com.nicolas.hostal.util.Correo;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoServicio {

    ProductoDAO productos;

    // String correo_destino = "u21221601@utp.edu.pe";

    public ProductoServicio() {
        this.productos = MySQLDaoManager.getInstance().getProductoDAO();
    }

    // CRUD
    public void registrarProducto(Producto p) {
        productos.insertar(p);

        // String asunto = "Nuevo producto registrado: " + p.getNombre();
        // String mensaje = "Se ha registrado un nuevo producto: " + p.getNombre() + "<br>"
        //         + "Precio: " + p.getPrecio_unitario() + "<br>"
        //         + "Stock: " + p.getCantidad() + "<br>"
        //         + "Categoria: " + p.getCategoria() + "<br>"
        //         + "Activo: " + p.isActivo() + "<br>";
        // Correo c = new Correo(correo_destino, asunto, mensaje);
        // c.enviar();
    }

    public void modificarProducto(Producto p) {
        productos.modificar(p);

        // String asunto = "Producto modificado: " + p.getNombre();
        // String mensaje = "Se ha modificado un producto: " + p.getNombre() + "<br>"
        //         + "Precio: " + p.getPrecio_unitario() + "<br>"
        //         + "Stock: " + p.getCantidad() + "<br>"
        //         + "Categoria: " + p.getCategoria() + "<br>"
        //         + "Activo: " + p.isActivo() + "<br>";
        // Correo c = new Correo(correo_destino, asunto, mensaje);
        // c.enviar();
    }

    public void borrarProducto(Producto p) {
        productos.eliminar(p);

        // String asunto = "Producto eliminado: " + p.getNombre();
        // String mensaje = "Se ha eliminado un producto: " + p.getNombre() + "<br>"
        //         + "Precio: " + p.getPrecio_unitario() + "<br>"
        //         + "Stock: " + p.getCantidad() + "<br>"
        //         + "Categoria: " + p.getCategoria() + "<br>"
        //         + "Activo: " + p.isActivo() + "<br>";
        // Correo c = new Correo(correo_destino, asunto, mensaje);
        // c.enviar();
    }

    public List<Producto> obtenerTodosProductos() {
        return productos.obtenerTodos();
    }

    public List<Producto> obtenerTodosProductosActivos() {
        return productos.obtenerTodos().stream()
                .filter(p -> p.isActivo())
                .collect(Collectors.toList());
    }

    public Producto obtenerProducto(int id) {
        return productos.obtener(id);
    }

    // Otros metodos

    /**
     * Obtiene una lista de categorías distintas de los productos activos.
     * 
     * @return una lista de categorías distintas de los productos activos
     */
    public List<String> obtenerCategorias() {
        List<String> distinctCategorias = obtenerTodosProductosActivos().stream()
                .map(p -> p.getCategoria())
                .distinct()
                .collect(Collectors.toList());
        return distinctCategorias;
    }

    /**
     * Obtiene una lista de productos por categoría.
     * 
     * @param categoria La categoría de los productos a obtener.
     * @return Una lista de productos que pertenecen a la categoría especificada.
     */
    public List<Producto> obtenerProductosPorCategoria(String categoria) {
        List<Producto> productosPorCategoria = obtenerTodosProductosActivos().stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .collect(Collectors.toList());
        return productosPorCategoria;
    }

    /**
     * Verifica si existe una entrada de producto para el producto dado.
     * 
     * @param p el producto para el cual se desea verificar la existencia de una entrada
     * @return true si existe una entrada de producto para el producto dado, false de lo contrario
     */
    public boolean existeEntradaProducto(Producto p) {
        return new ProductoEntranteServicio().obtenerIdsProductosConEntradas().contains(p.getId());
    }
}
