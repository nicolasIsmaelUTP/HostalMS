package com.nicolas.hostal.servicios;

import java.util.List;

import com.nicolas.hostal.dao.PagoDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Pago;

public class PagoServicio {
    
    PagoDAO pagos;
    
    public PagoServicio(){
        this.pagos = MySQLDaoManager.getInstance().getPagoDAO();
    }

    // CRUD

    public void registrarPago(Pago p){
        pagos.insertar(p);
    }

    public void modificarPago(Pago p){
        pagos.modificar(p);
    }

    public void eliminarPago(Pago p){
        pagos.eliminar(p);
    }

    public List<Pago> obtenerTodosPagos(){
        return pagos.obtenerTodos();
    }

    public Pago obtenerPagoPorId(int id){
        return pagos.obtener(id);
    }

}
