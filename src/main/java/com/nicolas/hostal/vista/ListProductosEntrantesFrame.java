package com.nicolas.hostal.vista;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.mysql.MySQLDaoManager;
import com.nicolas.hostal.modelo.Producto_entrante;
import com.nicolas.hostal.servicios.ProductoEntranteServicio;
import javax.swing.JOptionPane;

public class ListProductosEntrantesFrame extends javax.swing.JFrame {

    private DAOManager manager;
    private ProductoEntranteServicio servicio;
    
    private ProductosEntrantesTableModel model;
    

    public ListProductosEntrantesFrame(DAOManager manager) {
        initComponents();
        setTitle("Registrar entrada de producto");
        this.manager = manager;
        this.servicio = new ProductoEntranteServicio(
            manager.getProducto_entranteDAO(),
            manager.getProductoDAO());
        
        // Tabla
        this.model = new ProductosEntrantesTableModel(
                manager.getProducto_entranteDAO(),
                manager.getProductoDAO());

        // Copiar y pegar
        obtenerDatos();
        this.tabla.setModel(model);
        this.detalle.setEditable(false);
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            editar.setEnabled(seleccionValida);
            borrar.setEnabled(seleccionValida);
        });
        //

        // ComboModel
        this.detalle.setModel(new ProductosComboModel(manager.getProductoDAO()));
    }

    private void obtenerDatos() {
        estado.setText("Actualizando modelo...");
        model.updateModel();
        estado.setText(model.getRowCount() + " entradas visibles");
    }

    private Producto_entrante getEntradaSeleccionada() {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return manager.getProducto_entranteDAO().obtener(id);
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
        registrar = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new com.nicolas.hostal.vista.DetalleEntradaProductoPanel();

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

        registrar.setText("Registrar");
        registrar.setEnabled(false);
        registrar.setFocusable(false);
        registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        jToolBar1.add(registrar);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        estado.setText("0 registros visibles");
        getContentPane().add(estado, java.awt.BorderLayout.PAGE_END);

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

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        detalle.setEntrante(null);
        detalle.loadData();
        detalle.setEditable(true);
        registrar.setEnabled(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        detalle.saveData();
        Producto_entrante p_entrante = detalle.getEntrante();
        if (p_entrante.getId() == 0) {
            servicio.registrarEntradaProducto(p_entrante);
        } else {
            manager.getProducto_entranteDAO().modificar(p_entrante);
        }
        // Limpiar detalle
        detalle.setEntrante(null);
        detalle.setEditable(false);
        detalle.loadData();
        // Opciones
        registrar.setEnabled(false);
        // Tabla
        tabla.clearSelection();
        obtenerDatos();
        model.fireTableDataChanged();
    }//GEN-LAST:event_registrarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        Producto_entrante p_entrante = getEntradaSeleccionada();
        detalle.setEntrante(p_entrante);
        detalle.setEditable(true);
        detalle.loadData();
        registrar.setEnabled(true);
    }//GEN-LAST:event_editarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(
                rootPane,
                "¿Seguro que quieres eliminar este registro?",
                "Borrar registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            Producto_entrante p_entrante = getEntradaSeleccionada();
            manager.getProducto_entranteDAO().eliminar(p_entrante);

            obtenerDatos();
            model.fireTableDataChanged();
        }
    }//GEN-LAST:event_borrarActionPerformed

    public static void main(String args[]) {
        DAOManager manager = new MySQLDaoManager();
        java.awt.EventQueue.invokeLater(() -> {
            new ListProductosEntrantesFrame(manager).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private com.nicolas.hostal.vista.DetalleEntradaProductoPanel detalle;
    private javax.swing.JButton editar;
    private javax.swing.JLabel estado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton registrar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

}
