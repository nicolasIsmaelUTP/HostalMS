package com.nicolas.hostal.vista;

import com.nicolas.hostal.dao.ProductoDAO;
import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.modelo.Producto_entrante;

public class DetalleEntradaProductoPanel extends javax.swing.JPanel {

    private Producto_entrante p_entrante;
    
    private boolean editable;
    
    private ProductosComboModel model;
        
    // Se necesita un constructor vacio para enlazarlo con el JFrame Form
    public DetalleEntradaProductoPanel() {
        initComponents();
        model = new ProductosComboModel(null);
    }
    
    public DetalleEntradaProductoPanel(ProductoDAO dao) {
        initComponents();
        model = new ProductosComboModel(dao);
        model.update();
        cb_producto.setModel(model);
    }

    public ProductosComboModel getModel() {
        return model;
    }

    public void setModel(ProductosComboModel model) {
        this.model = model;
        model.update();
        cb_producto.setModel(model);
    }

    public Producto_entrante getEntrante() {
        return p_entrante;
    }

    public void setEntrante(Producto_entrante p_entrante) {
        this.p_entrante = p_entrante;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        cb_producto.setEnabled(editable);
        tf_cantidad.setEditable(editable);
    }

    public void loadData(){
        if(p_entrante != null){
            // Combo
            tf_cantidad.setText(String.valueOf(p_entrante.getCantidad()));
        } else{
            // Combo
            tf_cantidad.setText("");
        }
    }
    
    public void saveData(){
        if (p_entrante == null){
            p_entrante = new Producto_entrante();
        }
        // p_entrante.setProducto_id(1);
        p_entrante.setCantidad(Integer.parseInt(tf_cantidad.getText()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_cantidad = new javax.swing.JTextField();
        cb_producto = new javax.swing.JComboBox<>();

        jLabel1.setText("Producto:");

        jLabel2.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tf_cantidad))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cb_producto, 0, 208, Short.MAX_VALUE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Producto> cb_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tf_cantidad;
    // End of variables declaration//GEN-END:variables
}
