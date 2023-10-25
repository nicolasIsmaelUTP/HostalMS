/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nicolas.hostal.vista.clientes;

import com.nicolas.hostal.modelo.Cliente;

/**
 *
 * @author NICOLAS
 */
public class DetalleClientePanel extends javax.swing.JPanel {

    private Cliente cliente;
    private boolean editable;
    
    public DetalleClientePanel() {
        initComponents();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        tf_dni.setEditable(editable);
        tf_primerNombre.setEditable(editable);
        tf_segundoNombre.setEditable(editable);
        tf_apellidoPaterno.setEditable(editable);
        tf_apellidoMaterno.setEditable(editable);
    }
    
    public void loadData(){
        if(cliente != null){
            tf_dni.setText(cliente.getNumDoc());
            tf_primerNombre.setText(cliente.getPrimerNombre());
            tf_segundoNombre.setText(cliente.getSegundoNombre());
            tf_apellidoPaterno.setText(cliente.getApellidoPaterno());
            tf_apellidoMaterno.setText(cliente.getApellidoMaterno());
        } else{
            tf_dni.setText("");
            tf_primerNombre.setText("");
            tf_segundoNombre.setText("");
            tf_apellidoPaterno.setText("");
            tf_apellidoMaterno.setText("");
        }
        tf_dni.requestFocus();
    }
    
    public void saveData(){
        if (cliente == null){
            cliente = new Cliente();
        }
        cliente.setNumDoc(tf_dni.getText());
        cliente.setPrimerNombre(tf_primerNombre.getText());
        cliente.setSegundoNombre(tf_segundoNombre.getText());
        cliente.setApellidoPaterno(tf_apellidoPaterno.getText());
        cliente.setApellidoMaterno(tf_apellidoMaterno.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_dni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_primerNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_segundoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_apellidoPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_apellidoMaterno = new javax.swing.JTextField();

        jLabel1.setText("DNI:");

        jLabel2.setText("Primer nombre:");

        jLabel3.setText("Segundo nombre:");

        jLabel4.setText("Apellido paterno:");

        jLabel5.setText("Apellido materno:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_dni)
                    .addComponent(tf_primerNombre)
                    .addComponent(tf_segundoNombre)
                    .addComponent(tf_apellidoPaterno)
                    .addComponent(tf_apellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tf_primerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tf_segundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tf_apellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tf_apellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tf_apellidoMaterno;
    private javax.swing.JTextField tf_apellidoPaterno;
    private javax.swing.JTextField tf_dni;
    private javax.swing.JTextField tf_primerNombre;
    private javax.swing.JTextField tf_segundoNombre;
    // End of variables declaration//GEN-END:variables
}
