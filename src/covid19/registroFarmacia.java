/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19;

import Controladores.FarmaciaJpaController;
import Controladores.exceptions.NonexistentEntityException;
import Entidades.Farmacia;
import Entidades.Hospital;
import Entidades.Vacunas;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controladores.VacunasJpaController;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class registroFarmacia extends javax.swing.JFrame {

    /**
     * Creates new form registroFarmacia
     */
    public registroFarmacia() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargaTabla();
        limpiar();
        cargaCombo();
    }
    
    private void cargaTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nombre farmacia");
        dtm.addColumn("Municipio");
       
        dtm.addColumn("Nombre vacuna");
         dtm.addColumn("cantidad vacuna");
       
        Object[] fila = new Object[5];
        FarmaciaJpaController pc = new FarmaciaJpaController();
        List<Farmacia> lista = pc.findFarmaciaEntities();
        for(Farmacia p:lista){
            fila[0]= p.getId();
            fila[1]= p.getNombreFarmacia();
            fila[2]= p.getMunicipio();
            fila[3]= p.getIdVacunaFarmacia().getNombreDeVacuna();
            fila[4]= p.getIdVacunaFarmacia().getCantidad();
     
            dtm.addRow(fila);
            
        }
        tblFarmacia.setModel(dtm);
    }
    
        public void cargaCombo(){
        VacunasJpaController pc = new VacunasJpaController();
        List<Vacunas> lista = pc.findVacunasEntities();
        ComboItem item;
//        ComboItem cantidad;
        
        for(Vacunas p:lista){
            item = new ComboItem(p.getId(), p.getNombreDeVacuna());
//            cantidad = new ComboItem(p.getId(),Integer.toString(p.getCantidad()));
            if (p.getCantidad()==0) {
 
            }else{
                cmbVacuna.addItem(item);
//                cmbCantidadVacuna.add(cantidad);
            }
        }
        
    }
    private void limpiar(){
        txtNombreFarmacia.setText("");
        
        cmbMunicipio.setSelectedIndex(0);
        
        
        
        buttonGroup1.clearSelection();
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFarmacia = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNombreFarmacia = new javax.swing.JTextField();
        btnRegresarMenuPrinc1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbMunicipio = new javax.swing.JComboBox<>();
        cmbVacuna = new javax.swing.JComboBox<>();
        txtCantidadVacuna = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1334, 844));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre de farmacia:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 160, 180, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Municipio:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(520, 240, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registro farmacias");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(440, 0, 320, 80);

        tblFarmacia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFarmaciaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblFarmacia);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(260, 460, 960, 250);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(690, 420, 130, 38);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(830, 420, 130, 38);

        jLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLimpiar.setText("limpiar campos");
        jLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jLimpiar);
        jLimpiar.setBounds(520, 420, 148, 38);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(320, 420, 170, 38);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(990, 420, 120, 38);
        getContentPane().add(txtNombreFarmacia);
        txtNombreFarmacia.setBounds(620, 170, 190, 30);

        btnRegresarMenuPrinc1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegresarMenuPrinc1.setText("Regresar al menu principal");
        btnRegresarMenuPrinc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuPrinc1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresarMenuPrinc1);
        btnRegresarMenuPrinc1.setBounds(610, 720, 310, 60);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Vacunas:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(520, 310, 71, 30);

        cmbMunicipio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:", "Zapopan", "Guadalajara", "Tlaquepaque", "El salto", "Ixtlahuacan", "Tlajomulco de zuñiga", "Juanacatlan", "Tonala", "Zapotlanejo" }));
        getContentPane().add(cmbMunicipio);
        cmbMunicipio.setBounds(620, 240, 130, 30);

        getContentPane().add(cmbVacuna);
        cmbVacuna.setBounds(620, 310, 130, 30);
        getContentPane().add(txtCantidadVacuna);
        txtCantidadVacuna.setBounds(760, 310, 60, 30);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(540, 330, 0, 0);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenFondo/imagenfONDO.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1330, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFarmaciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFarmaciaMouseClicked
        int renglon = tblFarmacia.getSelectedRow();
        txtNombreFarmacia.setText(tblFarmacia.getValueAt(renglon, 1).toString());
        cmbMunicipio.setSelectedItem(tblFarmacia.getValueAt(renglon, 2).toString());
        
        cmbVacuna.setSelectedItem(tblFarmacia.getValueAt(renglon, 3).toString());
        
        
        
        
        
        txtCantidadVacuna.setText(tblFarmacia.getValueAt(renglon, 4).toString());
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblFarmaciaMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int renglon = tblFarmacia.getSelectedRow();
        int id =  (int)tblFarmacia.getValueAt(renglon, 0);
        Farmacia far = new Farmacia();
        far.setId(id);
        far.setNombreFarmacia(txtNombreFarmacia.getText());
        far.setMunicipio(cmbMunicipio.getSelectedItem().toString());
        char Svacuna;
        
        int numero = cmbVacuna.getSelectedIndex();
        switch(numero){
            case 0: far.setIdVacunaFarmacia(new Vacunas(1));
                    break; 
            case 1: far.setIdVacunaFarmacia(new Vacunas(2));
                    break;
            case 2: far.setIdVacunaFarmacia(new Vacunas(3));
                    break;
            default: break;
        }
        Controladores.FarmaciaJpaController farma = new Controladores.FarmaciaJpaController();
         Vacunas vac = new VacunasJpaController().findVacunas(numero+1);
        int cantidad;
        cantidad = (Integer.parseInt(txtCantidadVacuna.getText()));
        cantidad = vac.getCantidad()- cantidad;
        vac.setCantidad(cantidad);
        try {
            new VacunasJpaController().edit(vac);
        } catch (Exception ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            farma.edit(far);
            limpiar();
            cargaTabla();
            btnModificar.setEnabled(false); 
        } catch (Exception ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int renglon = tblFarmacia.getSelectedRow();
        int id =  (int)tblFarmacia.getValueAt(renglon, 0);
        FarmaciaJpaController oscar = new FarmaciaJpaController();
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

        Farmacia far = new Farmacia();
        far.setNombreFarmacia(txtNombreFarmacia.getText());
        far.setMunicipio(cmbMunicipio.getSelectedItem().toString());
        char Svacuna;
       
        
        int numero = cmbVacuna.getSelectedIndex();
        switch(numero){
            case 0: far.setIdVacunaFarmacia(new Vacunas(1));
                    break; 
            case 1: far.setIdVacunaFarmacia(new Vacunas(2));
                    break;
            case 2: far.setIdVacunaFarmacia(new Vacunas(3));
                    break;
            default: break;
        }
        Controladores.FarmaciaJpaController farma = new Controladores.FarmaciaJpaController();
        farma.create(far);
        
        Vacunas vac = new VacunasJpaController().findVacunas(numero+1);
        int cantidad;
        cantidad = (Integer.parseInt(txtCantidadVacuna.getText()));
        cantidad = vac.getCantidad()- cantidad;
        vac.setCantidad(cantidad);
        
        
        if (vac.getCantidad()< cantidad) {
            JOptionPane.showMessageDialog(this, "La canidad seleccionada es insuficiente");
        } else {
        }
        
        try {
            new VacunasJpaController().edit(vac);
        } catch (Exception ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        JOptionPane.showMessageDialog(this, "Farmacia agregada exitosamente");
        cargaTabla();
        limpiar();
        cargaCombo();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarMenuPrinc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuPrinc1ActionPerformed
        inicioAdministrados pac = new  inicioAdministrados();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMenuPrinc1ActionPerformed

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
            java.util.logging.Logger.getLogger(registroFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroFarmacia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresarMenuPrinc1;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cmbMunicipio;
    private javax.swing.JComboBox<ComboItem> cmbVacuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLimpiar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblFarmacia;
    private javax.swing.JTextField txtCantidadVacuna;
    private javax.swing.JTextField txtNombreFarmacia;
    // End of variables declaration//GEN-END:variables
}
