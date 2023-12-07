package com.nicolas.hostal.vista;

import com.nicolas.hostal.vista.inventario.ListProductosFrame;

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
        menu_inventario = new javax.swing.JMenu();
        i_gestionar_productos = new javax.swing.JMenuItem();
        i_registrar_entradas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu_inicio.setText("Inicio");
        jMenuBar1.add(menu_inicio);

        menu_inventario.setText("Inventario");

        i_gestionar_productos.setText("Gestionar productos");
        i_gestionar_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_gestionar_productosActionPerformed(evt);
            }
        });
        menu_inventario.add(i_gestionar_productos);

        i_registrar_entradas.setText("Registrar entradas");
        menu_inventario.add(i_registrar_entradas);

        jMenuBar1.add(menu_inventario);

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem i_gestionar_productos;
    private javax.swing.JMenuItem i_registrar_entradas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu_inicio;
    private javax.swing.JMenu menu_inventario;
    // End of variables declaration//GEN-END:variables
}
