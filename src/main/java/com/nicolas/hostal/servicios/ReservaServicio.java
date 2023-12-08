package com.nicolas.hostal.servicios;

import java.util.List;

import com.nicolas.hostal.dao.ReservaDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Reserva;

public class ReservaServicio {
    ReservaDAO reservas;

    public ReservaServicio() {
        this.reservas = MySQLDaoManager.getInstance().getReservaDAO();
    }

    // CRUD

    public void crearReserva(Reserva reserva) {
        reservas.insertar(reserva);
    }

    public void modificarReserva(Reserva reserva) {
        reservas.modificar(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.eliminar(reserva);
    }

    public List<Reserva> obtenerTodasReservas() {
        return reservas.obtenerTodos();
    }

    public Reserva obtenerReservaPorId(int id) {
        return reservas.obtener(id);
    }
}
