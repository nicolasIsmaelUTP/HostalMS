package com.nicolas.hostal.vista.pagos;

import com.nicolas.hostal.modelo.Pago;
import com.nicolas.hostal.servicios.PagoServicio;
import javax.swing.JOptionPane;

public class PagarFrame extends javax.swing.JFrame {

    private final PagoServicio servicio;
    
    private final PagosTableModel model;
    
    public PagarFrame() {
        initComponents();
        //setTitle("");
        setResizable(false);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        this.servicio = new PagoServicio();
        
        // Tabla
        this.model = new PagosTableModel();

        // Copiar y pegar
        obtenerDatos();
        this.tabla.setModel(model);
        this.detalle.setEditable(false);
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            btn_editar.setEnabled(seleccionValida);
            btn_borrar.setEnabled(seleccionValida);
        });
        //

        // ComboModel
        this.detalle.setModel(new MetodosPagoComboModel());
    }
    
    private void obtenerDatos() {
        estado.setText("Actualizando modelo...");
        model.updateModel();
        estado.setText(model.getRowCount() + " pagos visibles");
    }

    private Pago getPagoSeleccionado() {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return servicio.obtenerPagoPorId(id);
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
        estado = new javax.swing.JLabel();
        detalle = new com.nicolas.hostal.vista.pagos.DetallePagoPanel();

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

        estado.setText("jLabel1");
        getContentPane().add(estado, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(detalle, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        detalle.setPago(null);
        detalle.loadData();
        detalle.setEditable(true);
        btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
Pago pago = getPagoSeleccionado();
        detalle.setPago(pago);
        detalle.setEditable(true);
        detalle.loadData();
        btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(
                rootPane,
                "¿Seguro que quieres eliminar este pago?",
                "Borrar pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            Pago pago = getPagoSeleccionado();
            servicio.eliminarPago(pago);

            obtenerDatos();
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        detalle.saveData();
        Pago pago = detalle.getPago();
        if (pago.getId() == 0) {
            servicio.registrarPago(pago);
        } else {
            servicio.modificarPago(pago);
        }
        // Limpiar detalle
        detalle.setPago(null);
        detalle.setEditable(false);
        detalle.loadData();
        // Opciones
        btn_guardar.setEnabled(false);
        // Tabla
        tabla.clearSelection();
        obtenerDatos();
        model.fireTableDataChanged();
    }//GEN-LAST:event_btn_guardarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagarFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private com.nicolas.hostal.vista.pagos.DetallePagoPanel detalle;
    private javax.swing.JLabel estado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
