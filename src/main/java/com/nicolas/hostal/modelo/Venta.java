package com.nicolas.hostal.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_venta;
    @OneToMany
    private List<ItemProducto> items;

    public Venta() {
    }

    public Venta(List<ItemProducto> items) {
        this.items = items;
        this.fecha_venta = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public List<ItemProducto> getItems() {
        return items;
    }

    public void setItems(List<ItemProducto> items) {
        this.items = items;
    }
    
    // Metodos
    public ItemProducto agregarItem(ItemProducto item) {
        this.items.add(item);
        return item;
    }

    public ItemProducto quitarItem(ItemProducto item) {
        this.items.remove(item);
        return item;
    }
}
