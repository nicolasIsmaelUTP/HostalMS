package com.nicolas.hostal.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double monto;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @ManyToOne
    private MetodoPago metodoPago;
    @ManyToOne
    private Reserva reserva;

    public Pago() {
    }

    public Pago(double monto, MetodoPago metodoPago) {
        this.monto = monto;
        this.fecha = new Date();
        this.metodoPago = metodoPago;
    }

    public Pago(double monto, Date fecha, MetodoPago metodoPago) {
        this.monto = monto;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}