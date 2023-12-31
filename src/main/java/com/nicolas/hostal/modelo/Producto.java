package com.nicolas.hostal.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double precio_unitario;
    private String categoria;
    private int cantidad;
    private boolean activo;

    public Producto() {
    }

    public Producto(String nombre, double precio_unitario, String categoria) {
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
        this.categoria = categoria;
        this.cantidad = 0;
        this.activo = true;
    }

    public Producto(String nombre, double precio_unitario, String categoria, int cantidad, boolean activo) {
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.activo = activo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
