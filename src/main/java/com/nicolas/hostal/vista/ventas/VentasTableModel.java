/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolas.hostal.vista.ventas;

import com.nicolas.hostal.modelo.Venta;
import java.util.List;  
import java.util.ArrayList;
import com.nicolas.hostal.servicios.ServManager;
import com.nicolas.hostal.servicios.VentaServicio;
import javax.swing.table.AbstractTableModel;

/**
 *
 * author NICOLAS
 */
public class VentasTableModel extends AbstractTableModel {

    private VentaServicio servicio;

    private List<Venta> datos = new ArrayList<>();

    public VentasTableModel() {
        this.servicio = new VentaServicio()
    }

    public void updateModel() {
        datos = servicio.obtenerTodasVentas();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            default: return "[no]";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venta preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return preguntado.getId();
            default: return "";
        }
    }
}

