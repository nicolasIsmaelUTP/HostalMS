package com.nicolas.hostal.vista.usuarios;

import com.nicolas.hostal.modelo.Rol;
import com.nicolas.hostal.modelo.Usuario;
import com.nicolas.hostal.servicios.ServManager;
import com.nicolas.hostal.servicios.UsuarioServicio;

public class DetalleUsuarioPanel extends javax.swing.JPanel {

    private Usuario usuario;

    private UsuarioServicio usuarios;

    private boolean editable;

    private RolesDisponiblesListModel modeloDisp;
    private RolesAsignadosListModel modeloAsig;

    public DetalleUsuarioPanel() {
        initComponents();
        this.modeloDisp = new RolesDisponiblesListModel(null);
    }

    public void setServiceManager(ServManager manager){
        this.usuarios = manager.getUsuarioServicio();
    }

    public void setModeloDisp(RolesDisponiblesListModel modeloDisp) {
        this.modeloDisp = modeloDisp;
    }

    public void setModeloAsig(RolesAsignadosListModel modeloAsig) {
        this.modeloAsig = modeloAsig;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        tf_username.setEditable(editable);
        tf_password.setEditable(editable);
        tf_nombre.setEditable(editable);
    }

    public void loadData() {
        if (usuario != null) {
            tf_username.setText(usuario.getUsername());
            tf_password.setText(usuario.getPassword());
            tf_nombre.setText(usuario.getNombre());
        } else {
            tf_username.setText("");
            tf_password.setText("");
            tf_nombre.setText("");
        }
        // Lista roles disponibles
        modeloDisp.setUsuario(usuario);
        modeloDisp.update();
        lst_rolesDisponibles.setModel(modeloDisp);

        // Lista roles asignados
        modeloAsig.setUsuario(usuario);
        modeloAsig.update();
        lst_rolesAsignados.setModel(modeloAsig);

        tf_username.requestFocus();
    }

    public void saveData() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        usuario.setUsername(tf_username.getText());
        usuario.setPassword(tf_password.getText());
        usuario.setNombre(tf_nombre.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        tf_password = new javax.swing.JTextField();
        tf_nombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_rolesDisponibles = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btn_asignar = new javax.swing.JButton();
        btn_quitar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_rolesAsignados = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        jLabel3.setText("Nombre:");

        jScrollPane1.setViewportView(lst_rolesDisponibles);

        jLabel4.setText("Todos los roles (disponibles):");

        btn_asignar.setText("↑ Asignar rol ↑");
        btn_asignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asignarActionPerformed(evt);
            }
        });

        btn_quitar.setText("↓ Quitar rol ↓");
        btn_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lst_rolesAsignados);

        jLabel5.setText("Roles asignados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btn_asignar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_password)
                                        .addComponent(tf_username, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(tf_nombre))))
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_quitar)
                    .addComponent(btn_asignar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_asignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asignarActionPerformed
        Rol rolSeleccionado = lst_rolesDisponibles.getSelectedValue();
        usuarios.agregarRol(usuario, rolSeleccionado);
        loadData();
    }//GEN-LAST:event_btn_asignarActionPerformed

    private void btn_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarActionPerformed
        Rol rolSeleccionado = lst_rolesAsignados.getSelectedValue();
        usuarios.quitarRol(usuario, rolSeleccionado);
        loadData();
    }//GEN-LAST:event_btn_quitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_asignar;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Rol> lst_rolesAsignados;
    private javax.swing.JList<Rol> lst_rolesDisponibles;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
