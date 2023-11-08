package com.nicolas.hostal.vista.habitaciones;

import com.nicolas.hostal.modelo.TipoHabitacion;
import com.nicolas.hostal.servicios.TipoHabitacionServicio;
import javax.swing.JOptionPane;

public class ListTiposHabitacionFrame extends javax.swing.JFrame {

    private final TipoHabitacionServicio servicio;

    private final TiposHabitacionTableModel model;

    private ListTiposHabitacionFrame() {
        initComponents();
        setTitle("Gestionar tipos de habitacion y tarifas");

        this.servicio = new TipoHabitacionServicio();
        this.model = new TiposHabitacionTableModel();
        obtenerDatos();
        this.tabla.setModel(model);

        this.detalle.setEditable(false);

        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            editar.setEnabled(seleccionValida);
            borrar.setEnabled(seleccionValida);
        });
    }

    final void obtenerDatos() {
        estado.setText("Actualizando modelo...");
        model.updateModel();
        estado.setText(model.getRowCount() + " tipos de habitación visibles");
    }

    private TipoHabitacion getTipoHabitacionSeleccionado() {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return servicio.obtenerTipoHabitacion(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new com.nicolas.hostal.vista.habitaciones.DetalleTipoHabitacionPanel();
        estado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        nuevo.setText("Nuevo");
        nuevo.setFocusable(false);
        nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(nuevo);
        jToolBar1.add(jSeparator1);

        editar.setText("Editar");
        editar.setEnabled(false);
        editar.setFocusable(false);
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jToolBar1.add(editar);

        borrar.setText("Borrar");
        borrar.setEnabled(false);
        borrar.setFocusable(false);
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jToolBar1.add(borrar);
        jToolBar1.add(jSeparator2);

        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(guardar);

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

        estado.setText("0 registros visibles");
        getContentPane().add(estado, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        detalle.setTipoHabitacion(null);
        detalle.loadData();
        detalle.setEditable(true);
        guardar.setEnabled(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        TipoHabitacion tipoHabitacion = getTipoHabitacionSeleccionado();
        detalle.setTipoHabitacion(tipoHabitacion);
        detalle.setEditable(true);
        detalle.loadData();
        guardar.setEnabled(true);
    }//GEN-LAST:event_editarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(
                rootPane,
                "¿Seguro que quieres eliminar este tipo de habitacion?",
                "Borrar tipo de habitacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            TipoHabitacion tipoHabitacion = getTipoHabitacionSeleccionado();
            servicio.eliminarTipoHabitacion(tipoHabitacion);

            obtenerDatos();
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        detalle.saveData();
        TipoHabitacion tipoHabitacion = detalle.getTipoHabitacion();
        if (tipoHabitacion.getId() == 0) {
            servicio.crearTipoHabitacion(tipoHabitacion);
        } else {
            servicio.modificarTipoHabitacion(tipoHabitacion);
        }
        // Limpiar detalle
        detalle.setTipoHabitacion(null);
        detalle.setEditable(false);
        detalle.loadData();
        // Opciones
        guardar.setEnabled(false);
        // Tabla
        tabla.clearSelection();
        obtenerDatos();
        model.fireTableDataChanged();
    }//GEN-LAST:event_guardarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new ListTiposHabitacionFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private com.nicolas.hostal.vista.habitaciones.DetalleTipoHabitacionPanel detalle;
    private javax.swing.JButton editar;
    private javax.swing.JLabel estado;
    private javax.swing.JButton guardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
