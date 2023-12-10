package com.nicolas.hostal.servicios;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

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

    /**
     * Valida una reserva verificando si cumple con ciertas condiciones.
     * 
     * @param reserva la reserva a validar
     * @return true si la reserva es válida, false de lo contrario
     */
    public boolean validarReserva(Reserva reserva) {
        boolean validacion = true;
        if (reserva.getNumero_personas() <=0 || reserva.getNumero_personas() > 3) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "El numero de personas debe ser entre 1 y 3");
        }
        if (reserva.getHora_prevista_llegada().after(reserva.getHora_prevista_salida())) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "La hora de llegada debe ser anterior a la de salida");
        }
        return validacion;
    }
}
