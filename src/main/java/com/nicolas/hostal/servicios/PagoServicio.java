package com.nicolas.hostal.servicios;

import java.util.List;

import com.nicolas.hostal.dao.PagoDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Pago;
import com.nicolas.hostal.modelo.Reserva;
import java.util.stream.Collectors;

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

    /**
     * Obtiene una lista de pagos asociados a una reserva específica.
     * 
     * @param reserva La reserva para la cual se desean obtener los pagos.
     * @return Una lista de pagos asociados a la reserva especificada.
     */
    public List<Pago> obtenerPagosPorReserva(Reserva reserva){
        List<Pago> lista = obtenerTodosPagos().stream()
                .filter(p -> p.getReserva().getId() == reserva.getId())
                .collect(Collectors.toList());
        return lista;
    }

}
