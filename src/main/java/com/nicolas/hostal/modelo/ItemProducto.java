package com.nicolas.hostal.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    private double precio_unitario;
    
    // Relaciones
    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Venta venta;

    public ItemProducto() {
    }

    public ItemProducto(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.precio_unitario = producto.getPrecio_unitario();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    // Total
    public double getTotal(){
        return this.cantidad * this.precio_unitario;
    }
}
