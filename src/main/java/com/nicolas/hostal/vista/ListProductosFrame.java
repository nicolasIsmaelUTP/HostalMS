package com.nicolas.hostal.vista;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Producto;
import javax.swing.JOptionPane;

public class ListProductosFrame extends javax.swing.JFrame {

    private DAOManager manager;
    private ProductosTableModel model;

    private ListProductosFrame(DAOManager manager) {
        initComponents();
        this.manager = manager;
        this.model = new ProductosTableModel(manager.getProductoDAO());
        obtenerDatos();
        this.tabla.setModel(model);
        this.detalle.setEditable(false);
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            editar.setEnabled(seleccionValida);
            borrar.setEnabled(seleccionValida);
        });
    }

    final void obtenerDatos(){
        estado.setText("Actualizando modelo...");
        model.updateModel();
        estado.setText(model.getRowCount()+" productos visibles");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JToolBar();
        nuevo = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new com.nicolas.hostal.vista.DetalleProductoPanel();
        estado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolbar.setRollover(true);

        nuevo.setText("Nuevo");
        nuevo.setFocusable(false);
        nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        toolbar.add(nuevo);

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
        toolbar.add(editar);

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
        toolbar.add(borrar);

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
        toolbar.add(guardar);

        getContentPane().add(toolbar, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel1.add(detalle, java.awt.BorderLayout.LINE_END);

        estado.setText("0 registros visibles");
        jPanel1.add(estado, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Producto getProductoSeleccionado() {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return manager.getProductoDAO().obtener(id);
    }

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        Producto producto = getProductoSeleccionado();
        detalle.setProducto(producto);
        detalle.setEditable(true);
        detalle.loadData();
        guardar.setEnabled(true);
    }//GEN-LAST:event_editarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        detalle.setProducto(null);
        detalle.loadData();
        detalle.setEditable(true);
        guardar.setEnabled(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        detalle.saveData();
        Producto producto = detalle.getProducto();
        if (producto.getId() == 0) {
            manager.getProductoDAO().insertar(producto);
        } else {
            manager.getProductoDAO().modificar(producto);
        }
        // Limpiar detalle
        detalle.setProducto(null);
        detalle.setEditable(false);
        detalle.loadData();
        // Opciones
        guardar.setEnabled(false);
        // Tabla
        tabla.clearSelection();
        obtenerDatos();
        model.fireTableDataChanged();
    }//GEN-LAST:event_guardarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(
                rootPane,
                "¿Seguro que quieres eliminar este producto?",
                "Borrar producto",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            Producto producto = getProductoSeleccionado();
            manager.getProductoDAO().eliminar(producto);

            obtenerDatos();
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_borrarActionPerformed

    public static void main(String args[]) {
        DAOManager manager = new MySQLDaoManager();
        java.awt.EventQueue.invokeLater(() -> {
            new ListProductosFrame(manager).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private com.nicolas.hostal.vista.DetalleProductoPanel detalle;
    private javax.swing.JButton editar;
    private javax.swing.JLabel estado;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tabla;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables
}
