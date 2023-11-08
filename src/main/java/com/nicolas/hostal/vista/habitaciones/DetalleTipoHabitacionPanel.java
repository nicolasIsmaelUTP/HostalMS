package com.nicolas.hostal.vista.habitaciones;

import com.nicolas.hostal.modelo.TipoHabitacion;

public class DetalleTipoHabitacionPanel extends javax.swing.JPanel {

    private TipoHabitacion tipoHabitacion;
    private boolean editable;
    
    public DetalleTipoHabitacionPanel() {
        initComponents();
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        tf_denominacion.setEditable(editable);
        tf_precio.setEditable(editable);
        tf_camas.setEditable(editable);
    }
    
    public void loadData(){
        if(tipoHabitacion != null){
            tf_denominacion.setText(tipoHabitacion.getDenominacion());
            tf_precio.setText(String.valueOf(tipoHabitacion.getPrecio()));
            tf_camas.setText(String.valueOf(tipoHabitacion.getNumCamas()));
        } else{
            tf_denominacion.setText("");
            tf_precio.setText("");
            tf_camas.setText("");
        }
        tf_denominacion.requestFocus();
    }
    
    public void saveData(){
        if (tipoHabitacion == null){
            tipoHabitacion = new TipoHabitacion();
        }
        tipoHabitacion.setDenominacion(tf_denominacion.getText());
        tipoHabitacion.setPrecio(Float.parseFloat(tf_precio.getText()));
        tipoHabitacion.setNumCamas(Integer.parseInt(tf_camas.getText()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_denominacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_precio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_camas = new javax.swing.JTextField();

        jLabel1.setText("Denominación:");

        jLabel2.setText("Precio:");

        jLabel3.setText("Num de camas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_denominacion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_camas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_denominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_camas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tf_camas;
    private javax.swing.JTextField tf_denominacion;
    private javax.swing.JTextField tf_precio;
    // End of variables declaration//GEN-END:variables
}
