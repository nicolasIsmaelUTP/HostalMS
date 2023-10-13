package com.nicolas.hostal.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Habitacion implements Serializable {
    @Id
    private String numero;
    private String descripcion;
    private String piso;
    private int tipoHabitacionId;
    private boolean disponibilidad;

    public Habitacion() {
    }

    public Habitacion(String numero, String descripcion, String piso, int tipoHabitacionId) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.piso = piso;
        this.tipoHabitacionId = tipoHabitacionId;
        this.disponibilidad = true;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(int tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }
    
    @Override
    public String toString() {
        return numero;
    }
}
