package com.nicolas.hostal.vista.ventas;

import java.util.Date;

import javax.swing.JOptionPane;

import com.nicolas.hostal.modelo.Cliente;
import com.nicolas.hostal.modelo.ItemProducto;
import com.nicolas.hostal.modelo.Venta;
import com.nicolas.hostal.servicios.ClienteServicio;
import com.nicolas.hostal.servicios.ItemProductoServicio;
import com.nicolas.hostal.servicios.VentaServicio;
import com.nicolas.hostal.util.Pdf;
import com.nicolas.hostal.vista.inventario.ProductosComboModel;

public class VenderFrame extends javax.swing.JFrame {

    private final VentaServicio ventaServicio;
    private final ItemProductoServicio itemServicio;
    private final ClienteServicio clienteServicio;

    private final VentasTableModel model;

    // Instancia de venta
    private final Venta venta = new Venta();

    public VenderFrame() {
        initComponents();
        setTitle("Registrar venta");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        this.ventaServicio = new VentaServicio();
        this.itemServicio = new ItemProductoServicio();
        this.clienteServicio = new ClienteServicio();

        this.model = new VentasTableModel();

        // Copiar y pegar
        obtenerDatos();
        this.tabla.setModel(model);
        this.detalle.setEditable(false);
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (tabla.getSelectedRow() != -1);
            btn_borrar.setEnabled(seleccionValida);
        });
        //

        // ComboModel
        this.detalle.setModel(new ProductosComboModel());
    }

    private void obtenerDatos() {
        estado.setText("Actualizando modelo...");
        model.updateModel();
        estado.setText("Total: " + totalVenta());
    }

    private double totalVenta() {
        double total = 0;
        for (ItemProducto item : itemServicio.obtenerItemsProductoTemporales()) {
            total += item.getTotal();
        }
        return total;
    }

    private ItemProducto getItemSeleccionado() {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return itemServicio.obtenerItemProducto(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_agregar = new javax.swing.JButton();
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
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_nuevo);
        jToolBar1.add(jSeparator1);

        btn_borrar.setText("Borrar");
        btn_borrar.setEnabled(false);
        btn_borrar.setFocusable(false);
        btn_borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_borrar);
        jToolBar1.add(jSeparator2);

        btn_agregar.setText("Agregar");
        btn_agregar.setEnabled(false);
        btn_agregar.setFocusable(false);
        btn_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_agregar);
        jToolBar1.add(jSeparator3);

        jLabel2.setText("DNI cliente:  ");
        jToolBar1.add(jLabel2);
        jToolBar1.add(tf_dni);
        jToolBar1.add(jSeparator4);

        btn_imprimir.setText("Imprimir");
        btn_imprimir.setFocusable(false);
        btn_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
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

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_nuevoActionPerformed
        detalle.setItem(null);
        detalle.loadData();
        detalle.setEditable(true);
        btn_agregar.setEnabled(true);
    }// GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_borrarActionPerformed
        if (JOptionPane.showConfirmDialog(
                rootPane,
                "¿Seguro que quieres eliminar este item de venta?",
                "Borrar item de venta",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            ItemProducto item = getItemSeleccionado();
            itemServicio.eliminarItemProducto(item);
            // venta.quitarItem(item);

            obtenerDatos();
            model.fireTableDataChanged();
        }
    }// GEN-LAST:event_btn_borrarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_registrarActionPerformed
        detalle.saveData();
        ItemProducto item = detalle.getItem();
        if (item.getId() == 0) {
            itemServicio.registrarItemProducto(item);
            venta.agregarItem(item);
        }
        // Limpiar detalle
        detalle.setItem(null);
        detalle.setEditable(false);
        detalle.loadData();
        // Opciones
        btn_agregar.setEnabled(false);
        // Tabla
        tabla.clearSelection();
        obtenerDatos();
        model.fireTableDataChanged();
    }// GEN-LAST:event_btn_registrarActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_imprimirActionPerformed
        // imprimir
        String dniCliente = tf_dni.getText();
        Cliente c = clienteServicio.obtenerClientePorDni(dniCliente);

        if (itemServicio.obtenerItemsProductoTemporales().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No has agregado ningún producto");
        } else if (c == null) {
            JOptionPane.showMessageDialog(null, "El cliente no existe");
        } else {
            venta.setCliente(c);
            venta.setFecha_venta(new Date());

            venta.vaciar();
            for (ItemProducto i : itemServicio.obtenerItemsProductoTemporales()) {
                venta.agregarItem(i);
            }

            // Generar PDF
            Pdf pdf = new Pdf();
            pdf.exportarAPdf(boleta());

            ventaServicio.registrarVenta(this.venta);
            itemServicio.eliminarItemsProductoTemporales();

            String mensaje = "Venta registrada con éxito para el cliente: " + c.getApellidoPaterno() + " "
                    + c.getApellidoMaterno() + ", " + c.getPrimerNombre() + " " + c.getSegundoNombre();
            JOptionPane.showMessageDialog(null, mensaje);
            dispose();
        }
    }

    public String boleta() {
        String boleta = "";
        boleta += "Hostal Los Delfines\n";
        boleta += "Ruc: 76.123.456-7\n";
        boleta += "Direccion: Av. Siempre Viva 123\n";
        boleta += "Fecha: " + new Date() + "\n";
        boleta += "Cliente: " + venta.getCliente().getApellidoPaterno() + " " + venta.getCliente().getApellidoMaterno()
                + ", " + venta.getCliente().getPrimerNombre() + " " + venta.getCliente().getSegundoNombre() + "\n";
        boleta += "--------------------------------\n";
        boleta += "Detalle de venta\n";
        boleta += "--------------------------------\n";
        boleta += "Producto  -  Cantidad  -  Total\n";
        for (ItemProducto item : itemServicio.obtenerItemsProductoTemporales()) {
            boleta += item.getProducto().getNombre() + "  -  " + item.getCantidad() + "  -  " + item.getTotal() + "\n";
        }
        boleta += "--------------------------------\n";
        boleta += "Total: " + totalVenta() + "\n";
        boleta += "--------------------------------\n";
        return boleta;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_nuevo;
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
