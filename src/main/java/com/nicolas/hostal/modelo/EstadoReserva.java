package com.nicolas.hostal.modelo;

public enum EstadoReserva {
    PENDIENTE, CONFIRMADA, CANCELADA
    // PENDIENTE: La reserva fue creada pero no se ha confirmado.
    // CONFIRMADA: La reserva fue confirmada con el pago.
    // CANCELADA: La reserva fue cancelada por el cliente.
}