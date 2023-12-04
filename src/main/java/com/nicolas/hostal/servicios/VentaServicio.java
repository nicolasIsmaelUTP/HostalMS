package com.nicolas.hostal.servicios;

import java.util.List;

import com.nicolas.hostal.dao.VentaDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Venta;

public class VentaServicio {
    VentaDAO ventas;

    public VentaServicio(){
        this.ventas = MySQLDaoManager.getInstance().getVentaDAO();
    }

    // CRUD

    public void registrarVenta(Venta v){
        ventas.insertar(v);
    }

    public void modificarVenta(Venta v){
        ventas.modificar(v);
    }

    public void eliminarVenta(Venta v){
        ventas.eliminar(v);
    }

    public List<Venta> obtenerTodasVentas(){
        return ventas.obtenerTodos();
    }

    public Venta obtenerVenta(int id){
        return ventas.obtener(id);
    }
}
