package com.nicolas.hostal.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora_prevista_llegada;
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora_prevista_salida;

    private int numero_personas;
    private EstadoReserva estado;

    // Checkin y checkout son null si la reserva no fue confirmada.
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkout;

    // Relaciones
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Habitacion habitacion;
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos;

    public Reserva() {
    }

    public Reserva(Date hora_prevista_llegada, Date hora_prevista_salida, int numero_personas, Cliente cliente,
            Habitacion habitacion) {
        this.hora_prevista_llegada = hora_prevista_llegada;
        this.hora_prevista_salida = hora_prevista_salida;
        this.numero_personas = numero_personas;
        this.estado = EstadoReserva.PENDIENTE;
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public Reserva(Date hora_prevista_llegada, Date hora_prevista_salida, int numero_personas, EstadoReserva estado,
            Cliente cliente, Habitacion habitacion) {
        this.hora_prevista_llegada = hora_prevista_llegada;
        this.hora_prevista_salida = hora_prevista_salida;
        this.numero_personas = numero_personas;
        this.estado = estado;
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHora_prevista_llegada() {
        return hora_prevista_llegada;
    }

    public void setHora_prevista_llegada(Date hora_prevista_llegada) {
        this.hora_prevista_llegada = hora_prevista_llegada;
    }

    public Date getHora_prevista_salida() {
        return hora_prevista_salida;
    }

    public void setHora_prevista_salida(Date hora_prevista_salida) {
        this.hora_prevista_salida = hora_prevista_salida;
    }

    public int getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(int numero_personas) {
        this.numero_personas = numero_personas;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    // Agregar un pago a la reserva
    public Pago agregarPago(Pago pago) {
        this.pagos.add(pago);
        pago.setReserva(this);
        return pago;
    }

    // Eliminar un pago de la reserva
    public void eliminarPago(Pago pago) {
        for (Pago p : this.pagos) {
            if (p.getId() == pago.getId()) {
                this.pagos.remove(p);
                break;
            }
        }
    }

    // Modificar un pago de la reserva
    public void modificarPago(Pago pago) {
        for (Pago p : this.pagos) {
            if (p.getId() == pago.getId()) {
                this.pagos.remove(p);
                this.pagos.add(pago);
                break;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        return this.id == other.id;
    }
}
