package com.nicolas.hostal.vista.inventario;

import java.io.FileOutputStream;
import java.util.List;

import com.nicolas.hostal.modelo.Producto;

import com.nicolas.hostal.servicios.ProductoServicio;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class excel_inventario extends javax.swing.JFrame {

    ProductoServicio productoServicio = new ProductoServicio();

    public excel_inventario() {
        initComponents();
        cargarCategorias();
    }

    /**
     * Carga las categorías disponibles en el sistema y las agrega al ComboBox de categorías.
     */
    public void cargarCategorias() {
        cb_categoria.removeAllItems();
        for (String categoria : productoServicio.obtenerCategorias()) {
            cb_categoria.addItem(categoria);
        }
    }

    public void exportarExcel() {
        // Obtener la categoría seleccionada del ComboBox
        String categoria = cb_categoria.getSelectedItem().toString();
        
        // Obtener la lista de productos por categoría
        List<Producto> productos = productoServicio.obtenerProductosPorCategoria(categoria);

        // Crear un nuevo libro de Excel
        XSSFWorkbook libro = new XSSFWorkbook();
        
        // Crear una nueva hoja en el libro de Excel
        XSSFSheet hoja = libro.createSheet("Inventario");

        // Definir los encabezados de las columnas
        String[] header = new String[]{"ID", "Nombre", "Precio", "Stock"};
        
        // Crear una nueva fila en la hoja y escribir los encabezados
        hoja.createRow(0);
        for (int i = 0; i < header.length; i++) {
            hoja.getRow(0).createCell(i).setCellValue(header[i]);
        }

        // Recorrer la lista de productos y escribir los datos en la hoja
        for (int i = 0; i < productos.size(); i++) {
            hoja.createRow(i + 1).createCell(0).setCellValue(productos.get(i).getId());
            hoja.getRow(i + 1).createCell(1).setCellValue(productos.get(i).getNombre());
            hoja.getRow(i + 1).createCell(2).setCellValue(productos.get(i).getPrecio_unitario());
            hoja.getRow(i + 1).createCell(3).setCellValue(productos.get(i).getCantidad());
        }

        // Obtener la marca de tiempo actual
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Crear el nombre de archivo con el formato "Inventario_CATEGORIA_TIMESTAMP.xlsx"
        String filePath = "Inventario_" + categoria + "_" + timestamp + ".xlsx";

        // Guardar el libro de Excel en el archivo
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            libro.write(fileOut);
            System.out.println("Archivo creado para la categoría " + categoria);
        } catch (IOException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cb_categoria = new javax.swing.JComboBox<>();
        btn_exportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Exportar inventario de una categoría de producto");

        btn_exportar.setText("Exportar");
        btn_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_exportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exportarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        exportarExcel();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new excel_inventario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exportar;
    private javax.swing.JComboBox<String> cb_categoria;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
