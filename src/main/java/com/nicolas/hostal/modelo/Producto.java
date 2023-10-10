package com.nicolas.hostal.modelo;

public class Producto {
    private int id;
    private String nombre;
    private double precio_unitario;
    private String categoria;
    private boolean activo;

    public Producto(String nombre, double precio_unitario, String categoria, boolean activo) {
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
        this.categoria = categoria;
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

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio_unitario=" + precio_unitario + ", categoria=" + categoria + ", activo=" + activo + '}';
    }
    
    
}
