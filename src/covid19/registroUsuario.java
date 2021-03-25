
package covid19;


import Controladores.HospitalJpaController;
import Controladores.PacienteJpaController;
import Controladores.UsuariosJpaController;
import Controladores.VacunasJpaController;
import Controladores.exceptions.NonexistentEntityException;
import Entidades.Paciente;

import Entidades.Usuarios;
import Entidades.Vacunas;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class registroUsuario extends javax.swing.JFrame {


    public registroUsuario() {
        initComponents();
        cargaTabla();
        limpiar();
    }
//    public void cargaCombo(){
//        
//        VacunasJpaController pc = new VacunasJpaController();
//        HospitalJpaController oscar = new HospitalJpaController();
//        List<Paciente> listap = oscar.F
//        List<Vacunas> lista = pc.findVacunasEntities();
//        ComboItem item;
//        for(Vacunas p:lista){
//            item = new ComboItem(p.getId(), p.getNombreDeVacuna());
//            jComboBox1.addItem(item);
//        }
//        for(Paciente p:listap){
//            item = new ComboItem(p.getId(), p.getNombre());
//            cmbPacientes.addItem(item);
//            
//        }
//   
//    }
   private void cargaTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nombre");
        dtm.addColumn("Contraseña");
        dtm.addColumn("Tipo de usuario");
        
       
        Object[] fila = new Object[4];
        UsuariosJpaController pc = new UsuariosJpaController();
        List<Usuarios> lista = pc.findUsuariosEntities();
        for(Usuarios p:lista){
            fila[0]= p.getId();
            fila[1]= p.getUsuario();
            fila[2]= p.getPassword();
            fila[3]= p.getUserId();
            
     
            dtm.addRow(fila);
            
        }
        tblUsuarios.setModel(dtm);
    }
//    
    private void limpiar(){
        txtNombreUsuarioRegistro.setText("");
        txttContraseñaUsuarioRegistro.setText("");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreUsuarioRegistro = new javax.swing.JTextField();
        txttContraseñaUsuarioRegistro = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegresarMenuPrinc = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        RBadministrador = new javax.swing.JRadioButton();
        RBpaciente = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1334, 844));
        getContentPane().setLayout(null);

        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUsuarios);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(230, 450, 970, 250);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 160, 74, 24);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Contraseña:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(460, 220, 107, 24);

        txtNombreUsuarioRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreUsuarioRegistro);
        txtNombreUsuarioRegistro.setBounds(590, 160, 246, 30);

        txttContraseñaUsuarioRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttContraseñaUsuarioRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(txttContraseñaUsuarioRegistro);
        txttContraseñaUsuarioRegistro.setBounds(590, 220, 245, 30);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(680, 370, 130, 38);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(840, 370, 130, 38);

        jLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLimpiar.setText("limpiar campos");
        jLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jLimpiar);
        jLimpiar.setBounds(510, 370, 148, 38);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(310, 370, 170, 38);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(990, 370, 120, 38);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(560, 10, 300, 50);

        btnRegresarMenuPrinc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegresarMenuPrinc.setText("Regresar al menu principal");
        btnRegresarMenuPrinc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuPrincActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresarMenuPrinc);
        btnRegresarMenuPrinc.setBounds(530, 720, 310, 60);

        btnSalir1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir1);
        btnSalir1.setBounds(990, 370, 120, 38);

        RBadministrador.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(RBadministrador);
        RBadministrador.setText("Administrador");
        getContentPane().add(RBadministrador);
        RBadministrador.setBounds(590, 270, 120, 28);

        RBpaciente.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(RBpaciente);
        RBpaciente.setText("Usuario");
        getContentPane().add(RBpaciente);
        RBpaciente.setBounds(590, 300, 76, 28);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Tipo de usuario:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 280, 150, 24);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenFondo/imagenfONDO.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1334, 830);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
     int renglon = tblUsuarios.getSelectedRow();
        txtNombreUsuarioRegistro.setText(tblUsuarios.getValueAt(renglon, 1).toString());
        txttContraseñaUsuarioRegistro.setText(tblUsuarios.getValueAt(renglon, 2).toString());
        
       
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void txtNombreUsuarioRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioRegistroActionPerformed

    private void txttContraseñaUsuarioRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttContraseñaUsuarioRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttContraseñaUsuarioRegistroActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int renglon = tblUsuarios.getSelectedRow();
        int id =  (int)tblUsuarios.getValueAt(renglon, 0);
        Usuarios us = new Usuarios();
        us.setId(id);
        us.setUsuario(txtNombreUsuarioRegistro.getText());
        us.setPassword(txttContraseñaUsuarioRegistro.getText());
        int TipoAdmin;
        TipoAdmin = (RBadministrador.isSelected())?1:2;
        us.setUserId(TipoAdmin);
        UsuariosJpaController oscar = new UsuariosJpaController();
        try {
            oscar.edit(us);
            limpiar();
            cargaTabla();
            btnModificar.setEnabled(false); //se desactiva el btn
        } catch (Exception ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int renglon = tblUsuarios.getSelectedRow();
        int id =  (int)tblUsuarios.getValueAt(renglon, 0);
        UsuariosJpaController oscar = new UsuariosJpaController();
        try {
            oscar.destroy(id);
            limpiar();
            cargaTabla();
            btnEliminar.setEnabled(false); //desactivar el btn
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
//
        Usuarios us = new Usuarios();
        us.setUsuario(txtNombreUsuarioRegistro.getText());
        us.setPassword(txttContraseñaUsuarioRegistro.getText());
        int TipoAdmin;
        TipoAdmin = (RBadministrador.isSelected())?1:2;
        us.setUserId(TipoAdmin);
      Controladores.UsuariosJpaController Oscar = new Controladores.UsuariosJpaController();
      Oscar.create(us);
    JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente");
  cargaTabla();
  limpiar();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarMenuPrincActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuPrincActionPerformed
        inicioAdministrados pac = new  inicioAdministrados();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMenuPrincActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

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
            java.util.logging.Logger.getLogger(registroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBadministrador;
    private javax.swing.JRadioButton RBpaciente;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresarMenuPrinc;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jLimpiar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtNombreUsuarioRegistro;
    private javax.swing.JTextField txttContraseñaUsuarioRegistro;
    // End of variables declaration//GEN-END:variables
}
