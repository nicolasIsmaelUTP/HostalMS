package com.nicolas.hostal.vista.ventas;

import com.nicolas.hostal.modelo.ItemProducto;
import com.nicolas.hostal.modelo.Producto;
import com.nicolas.hostal.vista.inventario.ProductosComboModel;

public class DetalleVentaPanel extends javax.swing.JPanel {

    private ItemProducto item;
    private boolean editable;
    private ProductosComboModel model;

    public DetalleVentaPanel() {
        initComponents();
        model = new ProductosComboModel();
    }

    public ProductosComboModel getModel() {
        return model;
    }

    public void setModel(ProductosComboModel model) {
        this.model = model;
        model.update();
        cb_producto.setModel(model);
    }

    public ItemProducto getItem() {
        return item;
    }

    public void setItem(ItemProducto item) {
        this.item = item;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        cb_producto.setEnabled(editable);
        tf_cantidad.setEditable(editable);
    }

    public void loadData() {
        if(item != null) {
            // Aqui se carga la informacion del objeto en los componentes
            for (int i = 0; i < cb_producto.getItemCount(); i++) {
                Producto product = cb_producto.getItemAt(i);
                if (product.getId() == item.getProducto().getId()) {
                    cb_producto.setSelectedIndex(i);
                    break;
                }
            }

            tf_cantidad.setText(String.valueOf(item.getCantidad()));
        } else {
            // Aqui se limpian los componentes
            cb_producto.setSelectedIndex(0);
            tf_cantidad.setText("");
        }
    }

    public void saveData() {
        if(item == null) {
            item = new ItemProducto();
        }

        // Manejando el producto
        Producto product = (Producto) cb_producto.getSelectedItem();

        item.setProducto(product);
        item.setCantidad(Integer.parseInt(tf_cantidad.getText()));
        item.setPrecio_unitario(product.getPrecio_unitario());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cb_producto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tf_cantidad = new javax.swing.JTextField();

        jLabel2.setText("Producto:");

        jLabel3.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cb_producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(tf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Producto> cb_producto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tf_cantidad;
    // End of variables declaration//GEN-END:variables
}
