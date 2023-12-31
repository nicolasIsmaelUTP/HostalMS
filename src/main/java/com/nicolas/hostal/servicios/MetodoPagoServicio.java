package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.MetodoPagoDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.MetodoPago;
import java.util.List;

public class MetodoPagoServicio {
    MetodoPagoDAO metodospago;
    
    public MetodoPagoServicio(){
        this.metodospago = MySQLDaoManager.getInstance().getMetodoPagoDAO();
    }
    
    // CRUD
    
    public void registrarMetodoPago(MetodoPago h){
        metodospago.insertar(h);
    }
    
    public void modificarMetodoPago(MetodoPago h){
        metodospago.modificar(h);
    }
    
    public void eliminarMetodoPago(MetodoPago h){
        metodospago.eliminar(h);
    }
    
    public List<MetodoPago> obtenerTodosMetodosPago(){
        return metodospago.obtenerTodos();
    }
    
    public MetodoPago obtenerMetodoPago(int id){
        return metodospago.obtener(id);
    }
}
