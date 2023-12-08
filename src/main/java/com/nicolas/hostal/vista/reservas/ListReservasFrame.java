package com.nicolas.hostal.vista.reservas;

import com.nicolas.hostal.modelo.EstadoReserva;
import com.nicolas.hostal.modelo.Reserva;
import com.nicolas.hostal.servicios.ReservaServicio;

public class ListReservasFrame extends javax.swing.JFrame {

    private final ReservaServicio servicio;

    private final ReservasTableModel model;

    public ListReservasFrame() {
        initComponents();
        setTitle("Listado de reservas");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        this.servicio = new ReservaServicio();
        this.model = new ReservasTableModel();
        obtenerDatos();
        this.tabla.setModel(model);

        this.detalle.setEditable(false);

        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (tabla.getSelectedRow() != -1) {
                Reserva reserva = getReservaSeleccionada();
                detalle.setReserva(reserva);
                detalle.setEditable(true);
                detalle.loadData();
                btn_guardar.setEnabled(true);
            }
        });
    }

    final void obtenerDatos() {
        estado.setText("Actualizando modelo...");
        model.updateModel();
        estado.setText(model.getRowCount() + " reservas visibles");
    }

    private Reserva getReservaSeleccionada() {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return servicio.obtenerReservaPorId(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new com.nicolas.hostal.vista.reservas.DetalleReservaPanel();
        estado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btn_cancelar.setText("Cancelar reserva");
        btn_cancelar.setFocusable(false);
        btn_cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_cancelar);

        btn_guardar.setText("Guardar");
        btn_guardar.setFocusable(false);
        btn_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_guardar);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        getContentPane().add(detalle, java.awt.BorderLayout.LINE_END);

        estado.setText("jLabel1");
        getContentPane().add(estado, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_cancelarActionPerformed
        Reserva r = getReservaSeleccionada();
        r.setEstado(EstadoReserva.CANCELADA);
        servicio.modificarReserva(r);

        // Limpiar detalle
        detalle.setReserva(null);
        detalle.setEditable(false);
        detalle.loadData();

        // Actualizar modelo
        obtenerDatos();
        btn_guardar.setEnabled(false);
        model.fireTableDataChanged();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private com.nicolas.hostal.vista.reservas.DetalleReservaPanel detalle;
    private javax.swing.JLabel estado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
