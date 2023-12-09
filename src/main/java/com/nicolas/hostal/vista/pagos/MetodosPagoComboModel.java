package com.nicolas.hostal.vista.pagos;

import com.nicolas.hostal.modelo.MetodoPago;
import com.nicolas.hostal.servicios.MetodoPagoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class MetodosPagoComboModel extends DefaultComboBoxModel<MetodoPago>{
    private MetodoPagoServicio servicio;
    
    private List<MetodoPago> lista;

    public MetodosPagoComboModel() {
        this.lista = new ArrayList<>();
    }
    
    public void update(){
        this.servicio = new MetodoPagoServicio();
        if (servicio != null){
            removeAllElements();
            
            lista = servicio.obtenerTodosMetodosPago();
            for (MetodoPago m : lista) {
                addElement(m);
            }
        }
    }
}
