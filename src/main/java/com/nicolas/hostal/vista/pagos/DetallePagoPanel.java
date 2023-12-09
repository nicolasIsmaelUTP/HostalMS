package com.nicolas.hostal.vista.pagos;

import java.util.Date;

import com.nicolas.hostal.modelo.MetodoPago;
import com.nicolas.hostal.modelo.Pago;

public class DetallePagoPanel extends javax.swing.JPanel {

    private Pago pago;

    private boolean editable;

    private MetodosPagoComboModel model;

    public DetallePagoPanel() {
        initComponents();
        model = new MetodosPagoComboModel();
    }

    public MetodosPagoComboModel getModel() {
        return model;
    }

    public void setModel(MetodosPagoComboModel model) {
        this.model = model;
        model.update();
        cb_metodo.setModel(model);
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        cb_metodo.setEnabled(editable);
        tf_monto.setEditable(editable);
        tf_fechahora.setEditable(editable);
    }

    public void loadData() {
        if (pago != null) {
            
            // Recorre el combo box para encontrar el metodo de pago
            for (int i = 0; i < cb_metodo.getItemCount(); i++) {
                MetodoPago mp = cb_metodo.getItemAt(i);
                if (mp.getId() == pago.getMetodoPago().getId()) {
                    cb_metodo.setSelectedIndex(i);
                    break;
                }
            }

            tf_monto.setText(String.valueOf(pago.getMonto()));
            tf_fechahora.setText(String.valueOf(pago.getFecha()));

        } else {
            tf_monto.setText("");
            tf_fechahora.setText("");
        }
    }

    public void saveData() {
        if (pago == null) {
            pago = new Pago();
        }

        // Manejando el metodo de pago
        MetodoPago mp = (MetodoPago) model.getSelectedItem();
        pago.setMetodoPago(mp);

        pago.setMonto(Double.parseDouble(tf_monto.getText()));
        pago.setFecha(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_monto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cb_metodo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tf_fechahora = new javax.swing.JTextField();

        jLabel1.setText("Monto (S/):");

        jLabel2.setText("Método:");

        jLabel3.setText("Fecha y hora:");

        tf_fechahora.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_metodo, 0, 125, Short.MAX_VALUE)
                    .addComponent(tf_monto)
                    .addComponent(tf_fechahora))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_metodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_fechahora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<MetodoPago> cb_metodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tf_fechahora;
    private javax.swing.JTextField tf_monto;
    // End of variables declaration//GEN-END:variables
}
