/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19;

//import Controladores.UsuariosJpaController;

import Controladores.UsuariosJpaController;
import Entidades.Usuarios;
import java.util.List;
import javax.swing.JOptionPane;


public class Ingreso extends javax.swing.JFrame {

    
    public Ingreso() {
        initComponents();
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRegistrarme = new javax.swing.JButton();
        txtPasswordFild = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1334, 844));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(510, 250, 100, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(480, 350, 140, 30);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(610, 250, 161, 30);

        btnIngresar.setBackground(new java.awt.Color(204, 204, 204));
        btnIngresar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(380, 620, 240, 40);

        btnSalir.setBackground(new java.awt.Color(204, 204, 204));
        btnSalir.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(850, 620, 230, 40);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingreso");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(620, 20, 127, 50);

        btnRegistrarme.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRegistrarme.setText("Registrarme");
        btnRegistrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarmeActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarme);
        btnRegistrarme.setBounds(640, 620, 190, 37);
        getContentPane().add(txtPasswordFild);
        txtPasswordFild.setBounds(610, 350, 170, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenFondo/imagenfONDO.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1340, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        Usuarios usuario = new Usuarios();
        UsuariosJpaController usu = new UsuariosJpaController();
        List<Usuarios> datos = usu.findUsuariosEntities();
        String nombreusuario = txtUsuario.getText();
        String contra = txtPasswordFild.getText();
        
        boolean resultado1 = false;
        int tipoUsu = 0;
        
        for(Usuarios fila:datos){
                if(fila.getUsuario().equals(nombreusuario)&&fila.getPassword().equals(contra)){
                    resultado1 = true;
                    tipoUsu = fila.getUserId();
                    break;
        }     
        }
        
        if(resultado1){
            JOptionPane.showMessageDialog(this, "Bienvenido "+ nombreusuario);
             
            if (tipoUsu == 1) {
            this.dispose();
            new inicioAdministrados().setVisible(true);  
            }else{
            this.dispose();
            new pacienteVista().setVisible(true);  
            }
        }else{
            JOptionPane.showMessageDialog(this, "Nombre o usuario incorrecto" );
        
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnRegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarmeActionPerformed
        registroUsuariosPacienteAdministrador adm = new registroUsuariosPacienteAdministrador();
        adm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarmeActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
         Inicio adm = new Inicio();
        adm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrarme;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField txtPasswordFild;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
