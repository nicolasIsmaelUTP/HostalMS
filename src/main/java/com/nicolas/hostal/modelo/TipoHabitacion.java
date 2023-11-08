package com.nicolas.hostal.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoHabitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String denominacion;
    private float precio;
    private int numCamas;

    public TipoHabitacion() {
    }

    public TipoHabitacion(String denominacion, float precio, int numCamas) {
        this.denominacion = denominacion;
        this.precio = precio;
        this.numCamas = numCamas;
    }

    public TipoHabitacion(String denominacion, float precio) {
        this.denominacion = denominacion;
        this.precio = precio;
        this.numCamas = 1;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    @Override
    public String toString() {
        return denominacion;
    }
   
}
