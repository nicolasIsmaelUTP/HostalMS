package com.nicolas.hostal.vista.ventas;

public class ListVentasFrame extends javax.swing.JFrame {

    public ListVentasFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_registrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        tf_dni = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btn_imprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        estado = new javax.swing.JLabel();
        detalle = new com.nicolas.hostal.vista.ventas.DetalleVentaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btn_nuevo.setText("Nuevo");
        btn_nuevo.setFocusable(false);
        btn_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_nuevo);
        jToolBar1.add(jSeparator1);

        btn_borrar.setText("Borrar");
        btn_borrar.setFocusable(false);
        btn_borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_borrar);
        jToolBar1.add(jSeparator2);

        btn_registrar.setText("Registrar");
        btn_registrar.setFocusable(false);
        btn_registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_registrar);
        jToolBar1.add(jSeparator3);

        jLabel2.setText("DNI cliente:  ");
        jToolBar1.add(jLabel2);
        jToolBar1.add(tf_dni);
        jToolBar1.add(jSeparator4);

        btn_imprimir.setText("Imprimir");
        btn_imprimir.setFocusable(false);
        btn_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_imprimir);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        estado.setText("jLabel1");
        getContentPane().add(estado, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(detalle, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListVentasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_registrar;
    private com.nicolas.hostal.vista.ventas.DetalleVentaPanel detalle;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tf_dni;
    // End of variables declaration//GEN-END:variables
}
