package com.nicolas.hostal.servicios;

import java.util.Date;
import java.util.List;

import com.nicolas.hostal.dao.HabitacionDAO;
import com.nicolas.hostal.dao.ReservaDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Reserva;

public class ReservaServicio {
    ReservaDAO reservas;
    HabitacionDAO habitaciones;

    public ReservaServicio() {
        this.reservas = MySQLDaoManager.getInstance().getReservaDAO();
        this.habitaciones = MySQLDaoManager.getInstance().getHabitacionDAO();
    }

    // CRUD

    public void crearReserva(Reserva reserva) {
        reserva.getHabitacion().setDisponibilidad(false);
        reservas.insertar(reserva);
        habitaciones.modificar(reserva.getHabitacion());
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

    // Checkout
    public void checkout(Reserva reserva) {
        reserva.getHabitacion().setDisponibilidad(true);
        reserva.setCheckout(new Date());
        reservas.modificar(reserva);
        habitaciones.modificar(reserva.getHabitacion());
    }
}
