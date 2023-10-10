package com.nicolas.hostal.dao.mysql;

import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.modelo.Producto;
import java.sql.Connection;
import java.util.List;

public class MySQLProductoDAO implements ProductoDAO{
    
    final String INSERT="...";
    final String UPDATE="...";
    final String DELETE="...";
    final String GETALL="...";
    final String GETONE="...";
    
    private Connection conn;

    public MySQLProductoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Producto a) {
        // PreparedStatement...
    }

    @Override
    public void modificar(Producto a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Producto a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
