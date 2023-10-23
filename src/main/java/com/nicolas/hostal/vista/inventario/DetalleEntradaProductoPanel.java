package com.nicolas.hostal.vista.inventario;

import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.modelo.ProductoEntrante;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DetalleEntradaProductoPanel extends javax.swing.JPanel {

    private ProductoEntrante p_entrante;

    private boolean editable;

    private ProductosComboModel model;

    // Se necesita un constructor vacio para enlazarlo con el JFrame Form
    public DetalleEntradaProductoPanel() {
        initComponents();
        model = new ProductosComboModel(null);
    }

//    public DetalleEntradaProductoPanel(ServManager manager) {
//        initComponents();
//        model = new ProductosComboModel(manager);
//        model.update();
//        cb_producto.setModel(model);
//    }

    public ProductosComboModel getModel() {
        return model;
    }

    public void setModel(ProductosComboModel model) {
        this.model = model;
        model.update();
        cb_producto.setModel(model);
    }

    public ProductoEntrante getEntrante() {
        return p_entrante;
    }

    public void setEntrante(ProductoEntrante p_entrante) {
        this.p_entrante = p_entrante;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        cb_producto.setEnabled(editable);
        tf_cantidad.setEditable(editable);
        tf_fecha.setEditable(editable);
    }

    public void loadData() {
        if (p_entrante != null) {
            // Combo
            tf_cantidad.setText(String.valueOf(p_entrante.getCantidad()));
            tf_fecha.setText(String.valueOf(p_entrante.getFecha_entrada()));
        } else {
            // Combo
            tf_cantidad.setText("");
            tf_fecha.setText("");
        }
    }

    public void saveData() {
        if (p_entrante == null) {
            p_entrante = new ProductoEntrante();
        }
        
        // Manejando el producto
        Producto p = (Producto) model.getSelectedItem();
        p_entrante.setProducto_id(p.getId());
        
        p_entrante.setCantidad(Integer.parseInt(tf_cantidad.getText()));

        // Manejando la fecha
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        p_entrante.setFecha_entrada(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_cantidad = new javax.swing.JTextField();
        cb_producto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tf_fecha = new javax.swing.JTextField();

        jLabel1.setText("Producto:");

        jLabel2.setText("Cantidad:");

        jLabel3.setText("Fecha:");

        tf_fecha.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cb_producto, 0, 208, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_cantidad)
                            .addComponent(tf_fecha))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Producto> cb_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tf_cantidad;
    private javax.swing.JTextField tf_fecha;
    // End of variables declaration//GEN-END:variables
}
