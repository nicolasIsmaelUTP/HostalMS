package com.nicolas.hostal.vista.habitaciones;

import com.nicolas.hostal.modelo.Habitacion;
import com.nicolas.hostal.modelo.TipoHabitacion;

public class DetalleHabitacionPanel extends javax.swing.JPanel {

    private Habitacion habitacion;

    private boolean editable;

    private TiposHabitacionComboModel model;

    public DetalleHabitacionPanel() {
        initComponents();
        this.model = new TiposHabitacionComboModel();
    }

    public TiposHabitacionComboModel getModel() {
        return model;
    }

    public void setModel(TiposHabitacionComboModel model) {
        this.model = model;
        model.update();
        cb_tipo.setModel(model);
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        cb_tipo.setEnabled(editable);
        tf_numero.setEditable(editable);
        tf_piso.setEditable(editable);
        ta_observaciones.setEditable(editable);
        check_disponibilidad.setEnabled(editable);
    }

    public void loadData() {
        if (habitacion != null) {

            for (int i = 0; i < cb_tipo.getItemCount(); i++) {
                TipoHabitacion p = cb_tipo.getItemAt(i);
                if (p.getId() == habitacion.getTipoHabitacionId()) {
                    cb_tipo.setSelectedIndex(i);
                    break;
                }
            }

            tf_numero.setText(habitacion.getNumero());
            tf_piso.setText(habitacion.getPiso());
            ta_observaciones.setText(habitacion.getObservaciones());
            check_disponibilidad.setSelected(habitacion.isDisponibilidad());
        } else {
            tf_numero.setText("");
            tf_piso.setText("");
            ta_observaciones.setText("");
            check_disponibilidad.setSelected(false);
        }
    }

    public void saveData() {
        if (habitacion == null) {
            habitacion = new Habitacion();
        }

        // Manejando el tipo de habitacion
        TipoHabitacion th = (TipoHabitacion) model.getSelectedItem();
        habitacion.setTipoHabitacionId(th.getId());

        habitacion.setNumero(tf_numero.getText());
        habitacion.setPiso(tf_piso.getText());
        habitacion.setObservaciones(ta_observaciones.getText());
        habitacion.setDisponibilidad(check_disponibilidad.isSelected());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_numero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_piso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_observaciones = new javax.swing.JTextArea();
        check_disponibilidad = new javax.swing.JCheckBox();

        jLabel1.setText("Numero:");

        jLabel2.setText("Piso:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Observaciones:");

        ta_observaciones.setColumns(20);
        ta_observaciones.setRows(5);
        jScrollPane1.setViewportView(ta_observaciones);

        check_disponibilidad.setText("Disponibilidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_numero)
                            .addComponent(tf_piso)
                            .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(check_disponibilidad)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_piso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_disponibilidad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<TipoHabitacion> cb_tipo;
    private javax.swing.JCheckBox check_disponibilidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_observaciones;
    protected javax.swing.JTextField tf_numero;
    private javax.swing.JTextField tf_piso;
    // End of variables declaration//GEN-END:variables
}
