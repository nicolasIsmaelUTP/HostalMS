package com.nicolas.hostal.vista.reservas;

import javax.swing.JOptionPane;

import com.nicolas.hostal.modelo.Reserva;

public class DetalleReservaPanel extends javax.swing.JPanel {

    private Reserva reserva;
    private boolean editable;

    public DetalleReservaPanel() {
        initComponents();
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        tf_habitacion.setEditable(editable);
        tf_checkin.setEditable(editable);
        tf_checkout.setEditable(editable);
        tf_numpersonas.setEditable(editable);
        tf_cliente.setEditable(editable);
    }

    public void loadData() {
        if (reserva != null) {
            tf_id.setText(String.valueOf(reserva.getId()));
            tf_habitacion.setText(reserva.getHabitacion().getNumero());

            if (reserva.getCheckin() != null) {
                tf_checkin.setText(reserva.getCheckin().toString());
            } else {
                tf_checkin.setText("Aun no");
            }

            if (reserva.getCheckout() != null) {
                tf_checkout.setText(reserva.getCheckout().toString());
            } else {
                tf_checkout.setText("Aun no");
            }

            tf_numpersonas.setText(String.valueOf(reserva.getNumero_personas()));
            tf_cliente.setText(reserva.getCliente().getNumDoc());
        } else {
            tf_habitacion.setText("");
            tf_checkin.setText("");
            tf_checkout.setText("");
            tf_numpersonas.setText("");
            tf_cliente.setText("");
        }
        tf_habitacion.requestFocus();
    }

    // public void saveData(){
    // if (reserva == null){
    // reserva = new Reserva();
    // }
    // reserva.setHabitacion(tf_habitacion.getText());
    // reserva.setCheckin(tf_checkin.getText());
    // reserva.setCheckout(tf_checkout.getText());
    // reserva.setNumero_personas(Integer.parseInt(tf_numpersonas.getText()));
    // reserva.setCliente(tf_cliente.getText());
    // }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_habitacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_checkin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_checkout = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_numpersonas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_cliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        btn_setcheckin = new javax.swing.JButton();
        btn_setcheckout = new javax.swing.JButton();
        btn_show = new javax.swing.JButton();

        jLabel1.setText("Habitación:");

        jLabel2.setText("Check-in:");

        jLabel3.setText("Check-out:");

        jLabel4.setText("N° personas:");

        jLabel5.setText("Cliente:");

        jLabel6.setText("ID reserva:");

        btn_setcheckin.setText("Set");
        btn_setcheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setcheckinActionPerformed(evt);
            }
        });

        btn_setcheckout.setText("Set");
        btn_setcheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setcheckoutActionPerformed(evt);
            }
        });

        btn_show.setText("Show");
        btn_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_habitacion)
                                        .addComponent(tf_checkin)
                                        .addComponent(tf_checkout)
                                        .addComponent(tf_numpersonas)
                                        .addComponent(tf_cliente)
                                        .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 107,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_setcheckin, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_setcheckout, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_show, javax.swing.GroupLayout.DEFAULT_SIZE, 52,
                                                Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tf_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(tf_checkin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_setcheckin))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(tf_checkout, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_setcheckout))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(tf_numpersonas, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(tf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_show))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_setcheckinActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_setcheckinActionPerformed
        
    }// GEN-LAST:event_btn_setcheckinActionPerformed

    private void btn_setcheckoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_setcheckoutActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_setcheckoutActionPerformed

    private void btn_showActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_showActionPerformed
        // Mostrando la información del cliente
        JOptionPane.showMessageDialog(this, "Información del cliente:\n" +
                "DNI: " + reserva.getCliente().getNumDoc() + "\n" +
                "Primer nombre: " + reserva.getCliente().getPrimerNombre() + "\n" +
                "Segundo nombre: " + reserva.getCliente().getSegundoNombre() + "\n" +
                "Primer apellido: " + reserva.getCliente().getApellidoPaterno() + "\n" +
                "Segundo apellido: " + reserva.getCliente().getApellidoMaterno(), "Información del cliente",
                JOptionPane.INFORMATION_MESSAGE);
    }// GEN-LAST:event_btn_showActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_setcheckin;
    private javax.swing.JButton btn_setcheckout;
    private javax.swing.JButton btn_show;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tf_checkin;
    private javax.swing.JTextField tf_checkout;
    private javax.swing.JTextField tf_cliente;
    private javax.swing.JTextField tf_habitacion;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_numpersonas;
    // End of variables declaration//GEN-END:variables
}
