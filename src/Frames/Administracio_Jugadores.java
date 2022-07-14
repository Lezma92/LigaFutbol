package Frames;

import DB.connectionSql;
import Logica.clasejugadores;
import MVC.EquiposMVC;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Administracio_Jugadores extends javax.swing.JDialog {

    static String equipos, categorias, recibir;
    String mensaje;
    ImportarTxt txt;
    DefaultTableModel ModeloAdmin;
    connectionSql c = new connectionSql();
    private clasejugadores clsj = new clasejugadores();
    FormularioJug form;

    public Administracio_Jugadores(java.awt.Frame parent, boolean modal, String cat, String equi) {
        super(parent, modal);
        String datos[][] = {};
        String titulos[] = {"Id", "Nombre Jugador", "Edad", "Fecha Nacimiento"};
        ModeloAdmin = new DefaultTableModel(datos, titulos);
        initComponents();
        categorias = cat;
        equipos = equi;
        System.out.println(categorias + "----" + equipos);
        LblNom_Equipo.setText(equipos);
        LblNom_Categoria.setText(categorias);
        this.getContentPane().setBackground(Color.blue);
        this.setLocationRelativeTo(null);
        llenarTabla();
        setSize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Label_Principal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Btn_agregar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Admin = new javax.swing.JTable();
        importar = new javax.swing.JButton();
        generarReporte = new javax.swing.JButton();
        cate = new javax.swing.JLabel();
        LblNom_Categoria = new javax.swing.JLabel();
        LblNom_Equipo = new javax.swing.JLabel();
        equipo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Label_Principal.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        Label_Principal.setForeground(new java.awt.Color(0, 0, 0));
        Label_Principal.setText("Administración de Jugadores");

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("Volver");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(104, 104, 104)
                .addComponent(Label_Principal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Principal)
                    .addComponent(jButton1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        Btn_agregar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        Btn_agregar.setText("Agregar Jugador");
        Btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_agregarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        Btn_Eliminar.setText("Eliminar  Jugador");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_modificar.setText("Modificar Jugador");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton7.setText("Actualizar Tabla");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Tabla_Admin.setBackground(new java.awt.Color(153, 255, 255));
        Tabla_Admin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tabla_Admin.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Tabla_Admin.setForeground(new java.awt.Color(0, 0, 0));
        Tabla_Admin.setModel(ModeloAdmin);
        Tabla_Admin.setSelectionBackground(new java.awt.Color(255, 255, 102));
        Tabla_Admin.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(Tabla_Admin);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );

        importar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        importar.setText("Importar Lista");
        importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarActionPerformed(evt);
            }
        });

        generarReporte.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        generarReporte.setText("Generar reporte");
        generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_Eliminar)
                    .addComponent(Btn_agregar)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(importar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generarReporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(Btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(importar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(generarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        cate.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cate.setForeground(new java.awt.Color(255, 255, 255));
        cate.setText("Categoría: ");

        LblNom_Categoria.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        LblNom_Categoria.setForeground(new java.awt.Color(255, 255, 255));

        LblNom_Equipo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        LblNom_Equipo.setForeground(new java.awt.Color(255, 255, 255));

        equipo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        equipo.setForeground(new java.awt.Color(255, 255, 255));
        equipo.setText("Equipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(equipo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblNom_Equipo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblNom_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cate, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(LblNom_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblNom_Equipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(equipo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_agregarActionPerformed
        form = new FormularioJug(null, true, categorias, equipos);
        form.setVisible(true);
        boolean esperar = form.isShowing();
        while (esperar) {
            esperar = form.isShowing();
        }
        llenarTabla();

    }//GEN-LAST:event_Btn_agregarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Tabla_Admin.removeAll();
        ModeloAdmin.getDataVector().clear();
        llenarTabla();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        int fila = Tabla_Admin.getSelectedRow();

        if (fila >= 0) {
            int opc = JOptionPane.showConfirmDialog(rootPane, "Está seguro de que desea eliminar este  Jugador ?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION);
            String dato = String.valueOf(Tabla_Admin.getValueAt(fila, 0));
            if (opc == JOptionPane.OK_OPTION) {
                if (clsj.eliminarJugadorCliente(Integer.parseInt(dato)) == true) {
                    JOptionPane.showMessageDialog(rootPane, "Jugador eliminado correctamente");
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Error: no se puedo eliminar jugador");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operacion cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Para continuar es necesario seleccionar \n       "
                    + "      un jugador");
        }
    }//GEN-LAST:event_Btn_EliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        form = new FormularioJug(null, true, categorias, equipos);
        int fila = Tabla_Admin.getSelectedRow();
        if (fila >= 0) {
            form.btn_Guardar.setText("Actualizar");
            form.Lab_Actualizar.setText("Actualizar Datos");
            form.getDatos(getActualizar(), 1);
            form.setVisible(true);
            boolean esperar = form.isShowing();
            while (esperar) {
                esperar = form.isShowing();
            }

            Tabla_Admin.removeAll();
            ModeloAdmin.getDataVector().clear();
            llenarTabla();

        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Jugador");
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void importarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarActionPerformed
        txt = new ImportarTxt(null, true,equipos, categorias);
        txt.setVisible(true);
        boolean esperar = txt.isShowing();
        while (esperar) {
            esperar = txt.isShowing();
        }

        Tabla_Admin.removeAll();
        ModeloAdmin.getDataVector().clear();
        llenarTabla();

    }//GEN-LAST:event_importarActionPerformed

    private void generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteActionPerformed
        try {
            String dir = System.getProperty("user.dir") + "//src//Frames//reporte.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(dir);
            Map dd = new HashMap();
            dd.put("nombcat", categorias);
            dd.put("nombeq", equipos);
            JasperPrint p = JasperFillManager.fillReport(reporte, dd, c.getConexion());
            JasperViewer view = new JasperViewer(p, false);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al  generar reporte");
            e.printStackTrace();
        }

    }//GEN-LAST:event_generarReporteActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administracio_Jugadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administracio_Jugadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administracio_Jugadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administracio_Jugadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Administracio_Jugadores dialog = new Administracio_Jugadores(new javax.swing.JFrame(), true, categorias, equipos);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton Btn_Eliminar;
    protected javax.swing.JButton Btn_agregar;
    private javax.swing.JLabel Label_Principal;
    private javax.swing.JLabel LblNom_Categoria;
    private javax.swing.JLabel LblNom_Equipo;
    public javax.swing.JTable Tabla_Admin;
    protected javax.swing.JButton btn_modificar;
    private javax.swing.JLabel cate;
    private javax.swing.JLabel equipo;
    private javax.swing.JButton generarReporte;
    private javax.swing.JButton importar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void datos(Object dat[]) {
        equipo.setText("Equipo: ");
        LblNom_Equipo.setText("" + dat[0]);
        cate.setText("Categoria:");
        LblNom_Categoria.setText("" + dat[1]);

    }

    public String[] mandar(int opc) {
        int fila = Tabla_Admin.getSelectedRow();
        String vec[] = new String[5];
        vec[0] = LblNom_Categoria.getText();
        vec[1] = LblNom_Equipo.getText();
        if (opc == 1) {
            Object nom = Tabla_Admin.getValueAt(fila, 1);
            Object edad = Tabla_Admin.getValueAt(fila, 2);
            Object FN = Tabla_Admin.getValueAt(fila, 3);
            vec[2] = String.valueOf(nom);
            vec[3] = String.valueOf(edad);
            //vec[4] = String.valueOf(FN);
        }
        return vec;

    }

    public String[] getActualizar() {
        int fila = Tabla_Admin.getSelectedRow();
        String vec[] = new String[5];
        Object nom = Tabla_Admin.getValueAt(fila, 1);
        Object edad = Tabla_Admin.getValueAt(fila, 2);
        Object id = Tabla_Admin.getValueAt(fila, 0);
        vec[0] = LblNom_Categoria.getText();
        vec[1] = LblNom_Equipo.getText();
        vec[2] = String.valueOf(nom);
        vec[3] = String.valueOf(edad);
        vec[4] = String.valueOf(id);

        return vec;

    }

    public DefaultTableModel NuevoModelo() {
        EquiposMVC equi = new EquiposMVC();
        String vec[] = new String[2];
        vec[0] = LblNom_Equipo.getText();
        vec[1] = LblNom_Categoria.getText();
        //equi.Llenar_Equipos(ModeloAdmin, vec, 2);
        return ModeloAdmin;
    }

    public DefaultTableModel setModelo() {
        return ModeloAdmin;
    }

    private void llenarTabla() {
        clsj.MostrarJugadores(equipos, categorias, ModeloAdmin);
    }

    public void setSize() {
        TableColumn col1, col2, col3, col4;
        col1 = Tabla_Admin.getColumnModel().getColumn(0);
        col1.setMaxWidth(50);
        col2 = Tabla_Admin.getColumnModel().getColumn(1);
        col2.setMaxWidth(300);
        col3 = Tabla_Admin.getColumnModel().getColumn(2);
        col3.setMaxWidth(80);
        col4 = Tabla_Admin.getColumnModel().getColumn(3);
        col4.setMaxWidth(150);
    }
}
