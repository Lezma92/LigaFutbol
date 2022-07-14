package Frames;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Administracion_clientes extends javax.swing.JDialog {

    private static Socket copia;
    static String categorias, equipos;
    private BufferedReader entrada;
    private PrintStream salida;
    private String mensaje, recibir;
    FormularioEqui form;
    DefaultTableModel ModeloAdmin;

    public Administracion_clientes(java.awt.Frame parent, boolean modal, Socket soc, String equi, String cat) {
        super(parent, modal);
        initComponents();
        categorias = cat;
        equipos = equi;
        System.out.println(categorias + "----" + equipos);
        copia = soc;
        try {
            copia = soc;
            entrada = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            salida = new PrintStream(soc.getOutputStream());

        } catch (Exception e) {
            System.out.println("error al cargar flujos en Administracio_Jugadores()");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Label_Principal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cate = new javax.swing.JLabel();
        LblNom_Categoria = new javax.swing.JLabel();
        LblNom_Equipo = new javax.swing.JLabel();
        equipo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Btn_agregar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Admin = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Label_Principal.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        Label_Principal.setForeground(new java.awt.Color(0, 0, 0));
        Label_Principal.setText("Administración de clientes");

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("Volver");
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
                .addGap(61, 61, 61)
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

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        Btn_agregar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        Btn_agregar.setText("Crear  UsuarioCliente");
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

        Tabla_Admin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tabla_Admin.setModel(ModeloAdmin);
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
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(Btn_agregar)
                        .addGap(33, 33, 33)
                        .addComponent(Btn_Eliminar)
                        .addGap(33, 33, 33)
                        .addComponent(btn_modificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblNom_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblNom_Equipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(equipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_agregarActionPerformed
//        FormularioJug form = new FormularioJug(null, true);
//        form.getDatos(mandar(0), 0);
//        form.setVisible(true);
//        boolean esperar = form.isShowing();
//        while (esperar) {
//            esperar = form.isShowing();
//        }

        Tabla_Admin.removeAll();
        ModeloAdmin.getDataVector().clear();
        llenarTabla();
    }//GEN-LAST:event_Btn_agregarActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        int fila = Tabla_Admin.getSelectedRow();
        String vec[] = new String[2];
        if (fila >= 0) {

            int opc = JOptionPane.showConfirmDialog(rootPane, "Está seguro de que desea eliminar este  Jugador ?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.OK_OPTION) {
                vec[0] = "EliminarJugador";
                vec[1] = String.valueOf(Tabla_Admin.getValueAt(fila, 0));
                for (int i = 0; i < vec.length; i++) {
                    salida.println(vec[i]);
                }
                try {
                    recibir = entrada.readLine();
                    if (recibir.equals("Eliminado")) {
                        JOptionPane.showMessageDialog(this, "Jugador eliminado correctamente");
                        llenarTabla();
                    } else if (recibir.equals("Error")) {
                        JOptionPane.showMessageDialog(this, "Error al intentar eliminar");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
//        FormularioJug form = new FormularioJug(null, true, copia);
//        int fila = Tabla_Admin.getSelectedRow();
//        if (fila >= 0) {
//            form.btn_Guardar.setText("Actualizar");
//            form.Lab_Actualizar.setText("Actualizar Datos");
//            form.getDatos(getActualizar(), 1);
//            form.setVisible(true);
//            boolean esperar = form.isShowing();
//            while (esperar) {
//                esperar = form.isShowing();
//            }
//
//            Tabla_Admin.removeAll();
//            ModeloAdmin.getDataVector().clear();
//            llenarTabla();
//
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Seleccione un Jugador");
//        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Tabla_Admin.removeAll();
        ModeloAdmin.getDataVector().clear();
        llenarTabla();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Administracion_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administracion_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administracion_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administracion_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Administracion_clientes dialog = new Administracion_clientes(new javax.swing.JFrame(), true, copia, categorias, equipos);
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
        String vector[] = new String[3];
        vector[0] = "MostrarUsuarios";
        vector[1] = categorias;
        vector[2] = equipos;
        for (int i = 0; i < vector.length; i++) {
            salida.println(vector[i]);
        }

        ModeloAdmin.getDataVector().clear();
        try {
            int nuf = Integer.parseInt(recibir = entrada.readLine());
            System.out.println("Yo Recibi Esto: " + nuf);
            String datos[][] = new String[nuf][4];
            for (int e = 0; e < nuf; e++) {
                for (int j = 0; j < 4; j++) {
                    datos[e][j] = entrada.readLine();
                    System.out.println(datos[e][j]);
                }
                ModeloAdmin.addRow(datos[e]);
            }
        } catch (Exception erro) {
            erro.printStackTrace();
        }
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

    public void titulos() {
        String titulos[] = {"Nombre de usuario, equipo, categoria"};

        ModeloAdmin = new DefaultTableModel(null, titulos);
    }
}
