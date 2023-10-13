package com.nicolas.hostal.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TipoHabitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private int numMaxOcupantes;
    private int numCamas;
    @OneToMany
    @JoinColumn(name = "TipoHabitacionId")
    private ArrayList<Tarifa> tarifas;

    public TipoHabitacion() {
    }

    public TipoHabitacion(String descripcion, int numMaxOcupantes, int numCamas) {
        this.descripcion = descripcion;
        this.numMaxOcupantes = numMaxOcupantes;
        this.numCamas = numCamas;
        this.tarifas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumMaxOcupantes() {
        return numMaxOcupantes;
    }

    public void setNumMaxOcupantes(int numMaxOcupantes) {
        this.numMaxOcupantes = numMaxOcupantes;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    @Override
    public String toString() {
        return descripcion;
    }
   
}
