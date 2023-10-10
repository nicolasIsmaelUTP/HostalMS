package com.nicolas.hostal.modelo;
        
import java.util.Date;

public class Producto_entrante {
    private int id;
    private int producto_id;
    private Date fecha_entrada;

    public Producto_entrante(int producto_id, Date fecha_entrada) {
        this.producto_id = producto_id;
        this.fecha_entrada = fecha_entrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    @Override
    public String toString() {
        return "Producto_entrante{" + "id=" + id + ", producto_id=" + producto_id + ", fecha_entrada=" + fecha_entrada + '}';
    }
}
