/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nicolas.hostal.vista.clientes;

import com.nicolas.hostal.modelo.Cliente;
import com.nicolas.hostal.servicios.ClienteServicio;
import com.nicolas.hostal.servicios.ServManager;
import javax.swing.JOptionPane;

/**
 *
 * @author NICOLAS
 */
public class ListClientesFrame extends javax.swing.JFrame {

    private ClienteServicio servicio;
    
    private ClientesTableModel model;
    
    public ListClientesFrame(ServManager manager) {
        initComponents();
        setTitle("Gestionar clientes");
        
        this.servicio = manager.getClienteServicio();
        this.model = new ClientesTableModel(manager);
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
        txt_estado.setText(model.getRowCount()+" productos visibles");
    }
    
     private Cliente getClienteSeleccionado() {
        String dni = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
        return servicio.obtenerClientePorDni(dni);
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
        detalle = new com.nicolas.hostal.vista.clientes.DetalleClientePanel();
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
        detalle.setCliente(null);
        detalle.loadData();
        detalle.setEditable(true);
        btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        Cliente cliente = getClienteSeleccionado();
        detalle.setCliente(cliente);
        detalle.setEditable(true);
        detalle.loadData();
        btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(
                rootPane,
                "¿Seguro que quieres eliminar este cliente?",
                "Borrar cliente",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            Cliente cliente = getClienteSeleccionado();
            servicio.eliminarCliente(cliente);
            
            obtenerDatos();
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        detalle.saveData();
        Cliente cliente = detalle.getCliente();
        if (!servicio.existeCliente(cliente.getNumDoc())) {
            servicio.registrarCliente(cliente);
        } else {
            servicio.modificarCliente(cliente);
        }
        // Limpiar detalle
        detalle.setCliente(null);
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
        ServManager manager = new ServManager();
        java.awt.EventQueue.invokeLater(() -> {
            new ListClientesFrame(manager).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private com.nicolas.hostal.vista.clientes.DetalleClientePanel detalle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txt_estado;
    // End of variables declaration//GEN-END:variables
}
