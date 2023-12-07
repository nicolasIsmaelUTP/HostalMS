package com.nicolas.hostal.vista;

import com.nicolas.hostal.vista.clientes.ListClientesFrame;
import com.nicolas.hostal.vista.habitaciones.ListHabitacionesFrame;
import com.nicolas.hostal.vista.habitaciones.ListTiposHabitacionFrame;
import com.nicolas.hostal.vista.inventario.ListProductosEntrantesFrame;
import com.nicolas.hostal.vista.inventario.ListProductosFrame;
import com.nicolas.hostal.vista.inventario.excel_inventario;
import com.nicolas.hostal.vista.usuarios.ListUsuariosFrame;
import com.nicolas.hostal.vista.ventas.VenderFrame;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        this.setTitle("Hostal Los Delfines Management System");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menu_inicio = new javax.swing.JMenu();
        menu_recepcion = new javax.swing.JMenu();
        i_gestionar_clientes = new javax.swing.JMenuItem();
        menu_habitaciones = new javax.swing.JMenu();
        i_gestionar_habitaciones = new javax.swing.JMenuItem();
        i_gestionar_tipos = new javax.swing.JMenuItem();
        menu_inventario = new javax.swing.JMenu();
        i_gestionar_productos = new javax.swing.JMenuItem();
        i_registrar_entradas = new javax.swing.JMenuItem();
        i_exportar_inventario = new javax.swing.JMenuItem();
        menu_ventas = new javax.swing.JMenu();
        i_realizar_venta = new javax.swing.JMenuItem();
        menu_admin = new javax.swing.JMenu();
        i_gestionar_usuarios = new javax.swing.JMenuItem();
        i_gestionar_metodos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu_inicio.setText("Inicio");
        jMenuBar1.add(menu_inicio);

        menu_recepcion.setText("Recepción");

        i_gestionar_clientes.setText("Gestionar clientes");
        i_gestionar_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_gestionar_clientesActionPerformed(evt);
            }
        });
        menu_recepcion.add(i_gestionar_clientes);

        jMenuBar1.add(menu_recepcion);

        menu_habitaciones.setText("Habitaciones");

        i_gestionar_habitaciones.setText("Gestionar habitaciones");
        i_gestionar_habitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_gestionar_habitacionesActionPerformed(evt);
            }
        });
        menu_habitaciones.add(i_gestionar_habitaciones);

        i_gestionar_tipos.setText("Gestionar tipos de habitación");
        i_gestionar_tipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_gestionar_tiposActionPerformed(evt);
            }
        });
        menu_habitaciones.add(i_gestionar_tipos);

        jMenuBar1.add(menu_habitaciones);

        menu_inventario.setText("Inventario");

        i_gestionar_productos.setText("Gestionar productos");
        i_gestionar_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_gestionar_productosActionPerformed(evt);
            }
        });
        menu_inventario.add(i_gestionar_productos);

        i_registrar_entradas.setText("Registrar entradas");
        i_registrar_entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_registrar_entradasActionPerformed(evt);
            }
        });
        menu_inventario.add(i_registrar_entradas);

        i_exportar_inventario.setText("Exportar inventario");
        i_exportar_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_exportar_inventarioActionPerformed(evt);
            }
        });
        menu_inventario.add(i_exportar_inventario);

        jMenuBar1.add(menu_inventario);

        menu_ventas.setText("Ventas");

        i_realizar_venta.setText("Realizar venta");
        i_realizar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_realizar_ventaActionPerformed(evt);
            }
        });
        menu_ventas.add(i_realizar_venta);

        jMenuBar1.add(menu_ventas);

        menu_admin.setText("Admin");

        i_gestionar_usuarios.setText("Gestionar usuarios");
        i_gestionar_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_gestionar_usuariosActionPerformed(evt);
            }
        });
        menu_admin.add(i_gestionar_usuarios);

        i_gestionar_metodos.setText("Gestionar métodos de pago");
        i_gestionar_metodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_gestionar_metodosActionPerformed(evt);
            }
        });
        menu_admin.add(i_gestionar_metodos);

        jMenuBar1.add(menu_admin);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void i_gestionar_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_gestionar_productosActionPerformed
        ListProductosFrame listProductosFrame = new ListProductosFrame();
        listProductosFrame.setVisible(true);
    }//GEN-LAST:event_i_gestionar_productosActionPerformed

    private void i_registrar_entradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_registrar_entradasActionPerformed
        ListProductosEntrantesFrame listProductosEntrantesFrame = new ListProductosEntrantesFrame();
        listProductosEntrantesFrame.setVisible(true);
    }//GEN-LAST:event_i_registrar_entradasActionPerformed

    private void i_exportar_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_exportar_inventarioActionPerformed
        excel_inventario excel_inventario = new excel_inventario();
        excel_inventario.setVisible(true);
    }//GEN-LAST:event_i_exportar_inventarioActionPerformed

    private void i_gestionar_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_gestionar_clientesActionPerformed
        ListClientesFrame listClientesFrame = new ListClientesFrame();
        listClientesFrame.setVisible(true);
    }//GEN-LAST:event_i_gestionar_clientesActionPerformed

    private void i_gestionar_tiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_gestionar_tiposActionPerformed
        ListTiposHabitacionFrame listTiposHabitacionFrame = new ListTiposHabitacionFrame();
        listTiposHabitacionFrame.setVisible(true);
    }//GEN-LAST:event_i_gestionar_tiposActionPerformed

    private void i_gestionar_habitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_gestionar_habitacionesActionPerformed
        ListHabitacionesFrame listHabitacionesFrame = new ListHabitacionesFrame();
        listHabitacionesFrame.setVisible(true);
    }//GEN-LAST:event_i_gestionar_habitacionesActionPerformed

    private void i_realizar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_realizar_ventaActionPerformed
        VenderFrame venderFrame = new VenderFrame();
        venderFrame.setVisible(true);
    }//GEN-LAST:event_i_realizar_ventaActionPerformed

    private void i_gestionar_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_gestionar_usuariosActionPerformed
        ListUsuariosFrame listUsuariosFrame = new ListUsuariosFrame();
        listUsuariosFrame.setVisible(true);
    }//GEN-LAST:event_i_gestionar_usuariosActionPerformed

    private void i_gestionar_metodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_gestionar_metodosActionPerformed
        ListMetodosPagoFrame listMetodosPagoFrame = new ListMetodosPagoFrame();
        listMetodosPagoFrame.setVisible(true);
    }//GEN-LAST:event_i_gestionar_metodosActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem i_exportar_inventario;
    private javax.swing.JMenuItem i_gestionar_clientes;
    private javax.swing.JMenuItem i_gestionar_habitaciones;
    private javax.swing.JMenuItem i_gestionar_metodos;
    private javax.swing.JMenuItem i_gestionar_productos;
    private javax.swing.JMenuItem i_gestionar_tipos;
    private javax.swing.JMenuItem i_gestionar_usuarios;
    private javax.swing.JMenuItem i_realizar_venta;
    private javax.swing.JMenuItem i_registrar_entradas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu_admin;
    private javax.swing.JMenu menu_habitaciones;
    private javax.swing.JMenu menu_inicio;
    private javax.swing.JMenu menu_inventario;
    private javax.swing.JMenu menu_recepcion;
    private javax.swing.JMenu menu_ventas;
    // End of variables declaration//GEN-END:variables
}
