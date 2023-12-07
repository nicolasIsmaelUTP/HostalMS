package com.nicolas.hostal.vista;

import com.nicolas.hostal.modelo.MetodoPago;
import com.nicolas.hostal.servicios.MetodoPagoServicio;
import javax.swing.JOptionPane;

public class ListMetodosPagoFrame extends javax.swing.JFrame {

    private final MetodoPagoServicio servicio;
    
    private final MetodosPagoTableModel model;
    
    public ListMetodosPagoFrame() {
        initComponents();
        setTitle("Gestionar metodos de pago");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        
        this.servicio = new MetodoPagoServicio();
        this.model = new MetodosPagoTableModel();
        obtenerDatos();
        this.tabla.setModel(model);
        
        this.detalle.setEditable(false);
        
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            btn_editar.setEnabled(seleccionValida);
            btn_borrar.setEnabled(seleccionValida);
        });
    }

    final void obtenerDatos(){
        txt_estado.setText("Actualizando modelo...");
        model.updateModel();
        txt_estado.setText(model.getRowCount()+" metodos de pago visibles");
    }
    
     private MetodoPago getMetodoPagoSeleccionado() {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return servicio.obtenerMetodoPago(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_editar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new com.nicolas.hostal.vista.DetalleMetodoPagoPanel();
        txt_estado = new javax.swing.JLabel();

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

        btn_editar.setText("Editar");
        btn_editar.setEnabled(false);
        btn_editar.setFocusable(false);
        btn_editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_editar);

        btn_borrar.setText("Borrar");
        btn_borrar.setEnabled(false);
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

        btn_guardar.setText("Guardar");
        btn_guardar.setEnabled(false);
        btn_guardar.setFocusable(false);
        btn_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_guardar);

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
        getContentPane().add(detalle, java.awt.BorderLayout.LINE_END);

        txt_estado.setText("0 registros visibles");
        getContentPane().add(txt_estado, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        detalle.setMetodoPago(null);
        detalle.loadData();
        detalle.setEditable(true);
        btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        MetodoPago metodoPago = getMetodoPagoSeleccionado();
        detalle.setMetodoPago(metodoPago);
        detalle.setEditable(true);
        detalle.loadData();
        btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(
                rootPane,
                "¿Seguro que quieres eliminar este metodo de pago?",
                "Borrar metodo de pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            MetodoPago metodoPago = getMetodoPagoSeleccionado();
            servicio.eliminarMetodoPago(metodoPago);
            
            obtenerDatos();
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        detalle.saveData();
        MetodoPago metodoPago = detalle.getMetodoPago();
        if (metodoPago.getId() == 0) {
            servicio.registrarMetodoPago(metodoPago);
        } else {
            servicio.modificarMetodoPago(metodoPago);
        }
        // Limpiar detalle
        detalle.setMetodoPago(null);
        detalle.setEditable(false);
        detalle.loadData();
        // Opciones
        btn_guardar.setEnabled(false);
        // Tabla
        tabla.clearSelection();
        obtenerDatos();
        model.fireTableDataChanged();
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private com.nicolas.hostal.vista.DetalleMetodoPagoPanel detalle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txt_estado;
    // End of variables declaration//GEN-END:variables
}
