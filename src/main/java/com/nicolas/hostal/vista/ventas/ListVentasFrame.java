package com.nicolas.hostal.vista.ventas;

import javax.swing.JOptionPane;

import com.nicolas.hostal.modelo.ItemProducto;
import com.nicolas.hostal.modelo.ItemProducto;
import com.nicolas.hostal.servicios.ItemProductoServicio;
import com.nicolas.hostal.servicios.VentaServicio;
import com.nicolas.hostal.vista.inventario.ProductosComboModel;

public class ListVentasFrame extends javax.swing.JFrame {

    private VentaServicio ventaServicio;
    private ItemProductoServicio itemServicio;

    private VentasTableModel model;

    public ListVentasFrame() {
        initComponents();
        
        setTitle("Registrar venta");

        this.ventaServicio = new VentaServicio();
        this.itemServicio = new ItemProductoServicio();

        this.model = new VentasTableModel();

        // Copiar y pegar
        obtenerDatos();
        this.tabla.setModel(model);
        this.detalle.setEditable(false);
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            btn_borrar.setEnabled(seleccionValida);
        });
        //

        // ComboModel
        this.detalle.setModel(new ProductosComboModel());
    }

    private void obtenerDatos() {
        estado.setText("Actualizando modelo...");
        model.updateModel();
        estado.setText(model.getRowCount() + " entradas visibles");
    }

    private ItemProducto getItemSeleccionado() {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return itemServicio.obtenerItemProducto(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_registrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        tf_dni = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btn_imprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        estado = new javax.swing.JLabel();
        detalle = new com.nicolas.hostal.vista.ventas.DetalleVentaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btn_nuevo.setText("Nuevo");
        btn_nuevo.setFocusable(false);
        btn_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_nuevo);
        jToolBar1.add(jSeparator1);

        btn_borrar.setText("Borrar");
        btn_borrar.setFocusable(false);
        btn_borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_borrar);
        jToolBar1.add(jSeparator2);

        btn_registrar.setText("Registrar");
        btn_registrar.setFocusable(false);
        btn_registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_registrar);
        jToolBar1.add(jSeparator3);

        jLabel2.setText("DNI cliente:  ");
        jToolBar1.add(jLabel2);
        jToolBar1.add(tf_dni);
        jToolBar1.add(jSeparator4);

        btn_imprimir.setText("Imprimir");
        btn_imprimir.setFocusable(false);
        btn_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_imprimir);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        estado.setText("jLabel1");
        getContentPane().add(estado, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(detalle, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        detalle.setItem(null);
        detalle.loadData();
        detalle.setEditable(true);
        btn_registrar.setEnabled(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(
                rootPane,
                "¿Seguro que quieres eliminar este item de venta?",
                "Borrar item de venta",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            ItemProducto item = getItemSeleccionado();
            itemServicio.eliminarItemProducto(item);

            obtenerDatos();
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        detalle.saveData();
        ItemProducto item = detalle.getItem();
        if (item.getId() == 0) {
            itemServicio.registrarItemProducto(item);
        }
        // Limpiar detalle
        detalle.setItem(null);
        detalle.setEditable(false);
        detalle.loadData();
        // Opciones
        btn_registrar.setEnabled(false);
        // Tabla
        tabla.clearSelection();
        obtenerDatos();
        model.fireTableDataChanged();
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        // imprimir
    }//GEN-LAST:event_btn_imprimirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListVentasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_registrar;
    private com.nicolas.hostal.vista.ventas.DetalleVentaPanel detalle;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tf_dni;
    // End of variables declaration//GEN-END:variables
}
