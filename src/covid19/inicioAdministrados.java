/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19;

/**
 *
 * @author oscar
 */
public class inicioAdministrados extends javax.swing.JFrame {

    /**
     * Creates new form inicioAdministrados
     */
    public inicioAdministrados() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistroPaciente = new javax.swing.JToggleButton();
        btnRegistroVacuna = new javax.swing.JToggleButton();
        btnRegistroFarmacia = new javax.swing.JToggleButton();
        btnRegistroAdministrador = new javax.swing.JToggleButton();
        btnSalir = new javax.swing.JButton();
        btnRegresarMenuPrinc = new javax.swing.JButton();
        btnRegistroMedicamentos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRegistroHospital = new javax.swing.JButton();
        btnVIstaAdministrador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1290, 900));
        getContentPane().setLayout(null);

        btnRegistroPaciente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistroPaciente.setText("Registro paciente");
        btnRegistroPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroPacienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistroPaciente);
        btnRegistroPaciente.setBounds(520, 120, 212, 62);

        btnRegistroVacuna.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistroVacuna.setText("Registro vacunas");
        btnRegistroVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroVacunaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistroVacuna);
        btnRegistroVacuna.setBounds(520, 280, 212, 61);

        btnRegistroFarmacia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistroFarmacia.setText("Registro farmacias");
        btnRegistroFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroFarmaciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistroFarmacia);
        btnRegistroFarmacia.setBounds(520, 200, 212, 60);

        btnRegistroAdministrador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistroAdministrador.setText("Registro usuario");
        btnRegistroAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistroAdministrador);
        btnRegistroAdministrador.setBounds(520, 360, 212, 60);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(670, 720, 260, 38);

        btnRegresarMenuPrinc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegresarMenuPrinc.setText("Regresar al menu principal");
        btnRegresarMenuPrinc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuPrincActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresarMenuPrinc);
        btnRegresarMenuPrinc.setBounds(280, 720, 260, 38);

        btnRegistroMedicamentos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistroMedicamentos.setText("Registro medicamentos");
        btnRegistroMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroMedicamentosActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistroMedicamentos);
        btnRegistroMedicamentos.setBounds(510, 520, 230, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(590, 0, 60, 70);

        btnRegistroHospital.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistroHospital.setText("Registro hospitales");
        btnRegistroHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroHospitalActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistroHospital);
        btnRegistroHospital.setBounds(520, 440, 210, 60);

        btnVIstaAdministrador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVIstaAdministrador.setText("Ver vacunas, medicamentos y hospitales asignados");
        btnVIstaAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVIstaAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(btnVIstaAdministrador);
        btnVIstaAdministrador.setBounds(360, 590, 510, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenFondo/imagenfONDO.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1250, 830);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroPacienteActionPerformed
       pacienteRegistro pac = new  pacienteRegistro();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroPacienteActionPerformed

    private void btnRegistroVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroVacunaActionPerformed
     registroVacuna vacunaRegistro = new registroVacuna();
     vacunaRegistro.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btnRegistroVacunaActionPerformed

    private void btnRegistroFarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroFarmaciaActionPerformed
        registroFarmacia pac = new  registroFarmacia();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroFarmaciaActionPerformed

    private void btnRegistroAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroAdministradorActionPerformed
        registroUsuario pac = new  registroUsuario();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroAdministradorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarMenuPrincActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuPrincActionPerformed
        Ingreso pac = new  Ingreso();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMenuPrincActionPerformed

    private void btnRegistroMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroMedicamentosActionPerformed
        registroMedicamentos vac = new  registroMedicamentos();
        vac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroMedicamentosActionPerformed

    private void btnRegistroHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroHospitalActionPerformed
        registroHospitales vac = new  registroHospitales();
        vac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroHospitalActionPerformed

    private void btnVIstaAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVIstaAdministradorActionPerformed
         pacienteVacunaAsignada vac = new  pacienteVacunaAsignada();
        vac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVIstaAdministradorActionPerformed

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
            java.util.logging.Logger.getLogger(inicioAdministrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicioAdministrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicioAdministrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicioAdministrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicioAdministrados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnRegistroAdministrador;
    private javax.swing.JToggleButton btnRegistroFarmacia;
    private javax.swing.JButton btnRegistroHospital;
    private javax.swing.JButton btnRegistroMedicamentos;
    private javax.swing.JToggleButton btnRegistroPaciente;
    private javax.swing.JToggleButton btnRegistroVacuna;
    private javax.swing.JButton btnRegresarMenuPrinc;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVIstaAdministrador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
