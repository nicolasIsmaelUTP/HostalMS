package com.nicolas.hostal.modelo;
        
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProductoEntrante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int producto_id;
    private int cantidad;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_entrada;

    public ProductoEntrante() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
 
    @Override
    public String toString() {
        return "Producto_entrante{" + "id=" + id + ", producto_id=" + producto_id + ", cantidad=" + cantidad + ", fecha_entrada=" + fecha_entrada + '}';
    }
    
}
