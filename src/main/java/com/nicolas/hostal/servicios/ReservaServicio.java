package com.nicolas.hostal.servicios;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.nicolas.hostal.dao.HabitacionDAO;
import com.nicolas.hostal.dao.ReservaDAO;
import com.nicolas.hostal.dao.TipoHabitacionDAO;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Reserva;
import com.nicolas.hostal.modelo.TipoHabitacion;

public class ReservaServicio {
    ReservaDAO reservas;
    HabitacionDAO habitaciones;
    TipoHabitacionDAO tiposHabitacion;

    public ReservaServicio() {
        this.reservas = MySQLDaoManager.getInstance().getReservaDAO();
        this.habitaciones = MySQLDaoManager.getInstance().getHabitacionDAO();
        this.tiposHabitacion = MySQLDaoManager.getInstance().getTipoHabitacionDAO();
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

    /**
     * Realiza el proceso de checkout para una reserva.
     * 
     * @param reserva La reserva para la cual se realizará el checkout.
     */
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
        if (calcularHoras(reserva) < 3){
            validacion = false;
            JOptionPane.showMessageDialog(null, "La estadía mínima es de 3 horas");
        }
        if (reserva.getNumero_personas() <= 0 || reserva.getNumero_personas() > 3) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "El numero de personas debe ser entre 1 y 3");
        }
        if (reserva.getHora_prevista_llegada().after(reserva.getHora_prevista_salida())) {
            validacion = false;
            JOptionPane.showMessageDialog(null, "La hora de llegada debe ser anterior a la de salida");
        }
        return validacion;
    }

    /**
     * Calcula la cantidad de horas entre la hora prevista de llegada y la hora
     * prevista de salida de una reserva.
     * 
     * @param reserva la reserva para la cual se desea calcular las horas
     * @return la cantidad de horas entre la hora prevista de llegada y la hora
     *         prevista de salida
     */
    public int calcularHoras(Reserva reserva) {
        long diferencia = reserva.getHora_prevista_salida().getTime() - reserva.getHora_prevista_llegada().getTime();
        int minutos = (int) (diferencia / (1000 * 60));
        int horas = (int) Math.ceil(minutos / 60.0);
        return horas;
    }

    /**
     * Calcula el total de la reserva en función de las horas de estadía y el tipo de habitación.
     * 
     * @param reserva la reserva para la cual se calculará el total
     * @return el total de la reserva
     */
    public double calcularTotal(Reserva reserva) {
        double total = 0;
        int horas = calcularHoras(reserva);
        TipoHabitacion th = tiposHabitacion.obtener(reserva.getHabitacion().getTipoHabitacionId());

        if (horas == 3) {
            total = th.getPrecio();
        } else if (horas >= 4 && horas < 6) {
            total = th.getPrecio() + (horas - 3) * 10;
        } else if (horas >= 6 && horas <= 24) {
            total = th.getPrecio() * 2;
        } else if (horas > 24) {
            total = th.getPrecio() * 2 * (int) Math.ceil(horas / 24.0);
        } else {
            JOptionPane.showMessageDialog(null, "Error al calcular el total");
        }

        return total;
    }
}
