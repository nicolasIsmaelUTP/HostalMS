package com.nicolas.hostal.vista.reservas;

import com.nicolas.hostal.modelo.Cliente;
import com.nicolas.hostal.modelo.EstadoReserva;
import com.nicolas.hostal.modelo.Habitacion;
import com.nicolas.hostal.modelo.Reserva;
import com.nicolas.hostal.servicios.ClienteServicio;
import com.nicolas.hostal.servicios.ReservaServicio;
import com.nicolas.hostal.vista.pagos.PagarFrame;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class ReservarFrame extends javax.swing.JFrame {

    private final ReservaServicio reservaServicio;
    private final ClienteServicio clienteServicio;

    private final Reserva reserva = new Reserva();

    public ReservarFrame() {
        initComponents();
        setTitle("Reservar");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        this.reservaServicio = new ReservaServicio();
        this.clienteServicio = new ClienteServicio();

        // Cargando las habitaciones al combobox
        HabitacionesComboModel model = new HabitacionesComboModel();
        model.update();
        cb_habitaciones.setModel(model);

        // Manejando las fechas
        Calendar a = new GregorianCalendar();
        a.add(Calendar.MINUTE, 5);
        date_ingreso.setCalendar(a);
        date_salida.setCalendar(a);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_dni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cb_habitaciones = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date_ingreso = new com.toedter.calendar.JDateChooser();
        date_salida = new com.toedter.calendar.JDateChooser();
        btn_tres = new javax.swing.JButton();
        btn_veinticuatro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        sp_num_personas = new javax.swing.JSpinner();
        btn_reservar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DNI del cliente:");

        jLabel2.setText("Habitación:");

        jLabel3.setText("Hora de ingreso:");

        jLabel4.setText("Hora de salida:");

        date_ingreso.setDateFormatString("dd/MM/yyyy HH:mm");

        date_salida.setDateFormatString("dd/MM/yyyy HH:mm");

        btn_tres.setText("+ 3 horas");
        btn_tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tresActionPerformed(evt);
            }
        });

        btn_veinticuatro.setText("+ 24 horas");
        btn_veinticuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_veinticuatroActionPerformed(evt);
            }
        });

        jLabel5.setText("N°de personas:");

        btn_reservar.setText("Reservar");
        btn_reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_habitaciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(date_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(tf_dni))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_tres, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_veinticuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sp_num_personas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_reservar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_habitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tres)
                    .addComponent(btn_veinticuatro))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(date_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sp_num_personas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btn_reservar)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_reservarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_reservarActionPerformed
        Habitacion habitacion = (Habitacion) cb_habitaciones.getSelectedItem();
        Date fechaIngreso = date_ingreso.getDate();
        Date fechaSalida = date_salida.getDate();
        int numPersonas = (int) sp_num_personas.getValue();
        Cliente cliente = clienteServicio.obtenerClientePorDni(tf_dni.getText());
        // Si el cliente no existe, se crea uno nuevo
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setNumDoc(tf_dni.getText());
            // Validando el cliente
            if (!clienteServicio.validarClienteSoloNumDoc(cliente)) {
                return;
            }
            clienteServicio.registrarCliente(cliente);
        }
        // Creando la reserva
        this.reserva.setHora_prevista_llegada(fechaIngreso);
        this.reserva.setHora_prevista_salida(fechaSalida);
        this.reserva.setNumero_personas(numPersonas);
        this.reserva.setEstado(EstadoReserva.PENDIENTE);
        this.reserva.setCliente(cliente);
        this.reserva.setHabitacion(habitacion);

        // Validando la reserva
        if (!reservaServicio.validarReserva(reserva)) {
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Vas a pagar: $"+reservaServicio.calcularTotal(reserva));
        
        // Guardando la reserva
        reservaServicio.crearReserva(reserva);
        JOptionPane.showMessageDialog(this, "Reserva creada para el cliente " + cliente.getPrimerNombre() + " "
                + cliente.getApellidoPaterno() + " en la habitación " + habitacion.getNumero(), "Reserva creada",
                JOptionPane.INFORMATION_MESSAGE);

        // Preguntar si se desea registrar pagos para confirmar la reserva
        int confirmarPagos = JOptionPane.showConfirmDialog(this, "¿Deseas registrar pagos para esta reserva y confirmarla?",
                "Confirmar reserva", JOptionPane.YES_NO_OPTION);
        if (confirmarPagos == JOptionPane.YES_OPTION) {
            PagarFrame pagarFrame = new PagarFrame(reserva);
            pagarFrame.setVisible(true);
        } 
            dispose();
    }// GEN-LAST:event_btn_reservarActionPerformed

    private void btn_tresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_tresActionPerformed
        try {
            // Obtener la fecha seleccionada
            Calendar selectedDate = date_ingreso.getCalendar();

            // Obtener la fecha actual
            Calendar currentDate = new GregorianCalendar();

            // Comparar la fecha seleccionada con la fecha actual
            if (selectedDate.after(currentDate)) {
                // Agregar 3 horas a la fecha seleccionada
                selectedDate.add(Calendar.HOUR_OF_DAY, 3);

                // Establecer la fecha actualizada como fecha de salida
                date_salida.setCalendar(selectedDate);
            } else {
                // Automáticamente la fecha de ingreso es la actual más 5 minutos
                selectedDate = new GregorianCalendar();
                selectedDate.add(Calendar.MINUTE, 5);
                date_ingreso.setCalendar(selectedDate);

                // Sumarle 3 horas a la fecha de salida
                selectedDate.add(Calendar.HOUR_OF_DAY, 3);

                // Establecer la fecha de salida
                date_salida.setCalendar(selectedDate);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fecha de ingreso inválida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btn_tresActionPerformed

    private void btn_veinticuatroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_veinticuatroActionPerformed
        try {
            // Obtener la fecha seleccionada
            Calendar selectedDate = date_ingreso.getCalendar();

            // Obtener la fecha actual
            Calendar currentDate = new GregorianCalendar();

            // Comparar la fecha seleccionada con la fecha actual
            if (selectedDate.after(currentDate)) {
                // Agregar 24 horas a la fecha seleccionada
                selectedDate.add(Calendar.HOUR_OF_DAY, 24);

                // Establecer la fecha actualizada como fecha de salida
                date_salida.setCalendar(selectedDate);
            } else {
                // Automáticamente la fecha de ingreso es la actual más 5 minutos
                selectedDate = new GregorianCalendar();
                selectedDate.add(Calendar.MINUTE, 5);
                date_ingreso.setCalendar(selectedDate);

                // Sumarle 24 horas a la fecha de salida
                selectedDate.add(Calendar.HOUR_OF_DAY, 24);

                // Establecer la fecha de salida
                date_salida.setCalendar(selectedDate);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fecha de ingreso inválida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btn_veinticuatroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reservar;
    private javax.swing.JButton btn_tres;
    private javax.swing.JButton btn_veinticuatro;
    private javax.swing.JComboBox<Habitacion> cb_habitaciones;
    private com.toedter.calendar.JDateChooser date_ingreso;
    private com.toedter.calendar.JDateChooser date_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner sp_num_personas;
    private javax.swing.JTextField tf_dni;
    // End of variables declaration//GEN-END:variables
}
