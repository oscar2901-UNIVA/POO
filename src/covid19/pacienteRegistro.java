
package covid19;



import Controladores.HospitalJpaController;
import Controladores.MedicamentosJpaController;
import Controladores.PacienteJpaController;
import Controladores.VacunasJpaController;
import Controladores.exceptions.NonexistentEntityException;
import Entidades.Hospital;
import Entidades.Medicamentos;
import Entidades.Paciente;
import Entidades.Vacunas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class pacienteRegistro extends javax.swing.JFrame {

    /**
     * Creates new form paciente
     */
    public pacienteRegistro() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargaTabla();
        cargaCombo();
        
       
    }
    
    
    private void cargaTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nombre");
        dtm.addColumn("AP");
        dtm.addColumn("AM");
        dtm.addColumn("Genero");
        dtm.addColumn("FN");
        dtm.addColumn("CURP");
        dtm.addColumn("CD");
        dtm.addColumn("CP");
        dtm.addColumn("Vacuna");
        dtm.addColumn("Hospital");
        dtm.addColumn("Medicamento");
       
        Object[] fila = new Object[12];
        PacienteJpaController pc = new PacienteJpaController();
        List<Paciente> lista = pc.findPacienteEntities();
        System.out.println(lista.get(0).getIdVacunaPaciente().getId());
//        for(Paciente p:lista){
//            fila[0]= p.getId();
//            fila[1]= p.getNombre();
//            fila[2]= p.getApellidoPaterno();
//            fila[3]= p.getApellidoMaterno();
//            fila[4]= p.getGenero();
//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            String fecha = formatter.format(p.getFechaNacimiento());
//            fila[5]= fecha;
//            fila[6]= p.getCurp();
//            fila[7]= p.getCiudad();
//            fila[8]= p.getCodigoPostal();
//            fila[9]= p.getIdVacunaPaciente().getNombreDeVacuna();
//            fila[10]= p.getIdHospitales().getNombreHospital();
//            dtm.addRow(fila);
//            
//        }
        for (int i = 0; i < lista.size(); i++) {
            fila[0]= lista.get(i).getId();
            fila[1]= lista.get(i).getNombre();
            fila[2]= lista.get(i).getApellidoPaterno();
            fila[3]= lista.get(i).getApellidoMaterno();
            fila[4]= lista.get(i).getGenero();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = formatter.format(lista.get(i).getFechaNacimiento());
            fila[5]= fecha;
            fila[6]= lista.get(i).getCurp();
            fila[7]= lista.get(i).getCiudad();
            fila[8]= lista.get(i).getCodigoPostal();
            fila[9]= lista.get(i).getIdVacunaPaciente().getNombreDeVacuna();
            fila[10]= lista.get(i).getIdHospitales().getNombreHospital();
            fila[11]= lista.get(i).getIdMedicamento().getNombreDeMedicamento();
//            fila[11]= lista.get(i).getIdMedicamentoa();
            dtm.addRow(fila);
            
        }
        tblPaciente.setModel(dtm);
    }
    
    private void limpiar(){
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtFechaDeNacimiento.setText("");
        txtCiudad.setText("");
        txtCodigoPostal.setText("");
        txtCurp.setText("");
        txtNombre.requestFocus();
        buttonGroup1.clearSelection();
       comboBoxHospital.setSelectedIndex(0);
       comboBoxVacuna.setSelectedIndex(0);
        cmbMedicamentos.setSelectedIndex(0);
    }
    
    
     public void cargaCombo(){
        comboBoxVacuna.removeAllItems();
        comboBoxHospital.removeAllItems();
        cmbMedicamentos.removeAllItems();
        VacunasJpaController pc = new VacunasJpaController();
        HospitalJpaController oscar = new HospitalJpaController();
         MedicamentosJpaController medi = new MedicamentosJpaController();
        List<Hospital> listap = oscar.findHospitalEntities();
        List<Vacunas> lista = pc.findVacunasEntities();
        List<Medicamentos> listam = medi.findMedicamentosEntities();
        ComboItem item;
        
        for(Vacunas p:lista){
            
            item = new ComboItem(p.getId(), p.getNombreDeVacuna());
            if (p.getCantidad()==0) {
 
            }else{
                comboBoxVacuna.addItem(item);
            }
        }
        for(Hospital p:listap){
            item = new ComboItem(p.getId(), p.getNombreHospital());
            if (p.getOcupacion().equals("Alta")) {
 
            }else{
                comboBoxHospital.addItem(item);
            }
            
            
        }
        for(Medicamentos p:listam){
            item = new ComboItem(p.getId(), p.getNombreDeMedicamento());
            if (p.getCantidad()==0) {
                
            } else {
                cmbMedicamentos.addItem(item);
            }
            
        }
       
       
    }
    
    
 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnRegresarMenuPrinc = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtFechaDeNacimiento = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCurp = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Rfemenino = new javax.swing.JRadioButton();
        btnModificar = new javax.swing.JButton();
        Rmasculino = new javax.swing.JRadioButton();
        btnEliminar = new javax.swing.JButton();
        jLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        comboBoxVacuna = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxHospital = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbMedicamentos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresarMenuPrinc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegresarMenuPrinc.setText("Regresar al menu principal");
        btnRegresarMenuPrinc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuPrincActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresarMenuPrinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 680, 310, 60));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Genero:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, 70, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("CURP:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Apellido paterno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Fecha de nacimiento: (DD/MM/YYYY)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 163, 300, -1));

        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 160, -1));

        txtFechaDeNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaDeNacimientoActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechaDeNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 170, -1));

        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 160, -1));
        getContentPane().add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 140, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Apellido materno:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 140, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, -1));
        getContentPane().add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 150, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Nombre:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, -1));

        tblPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPaciente);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 1290, 290));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro paciente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 280, 60));

        Rfemenino.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Rfemenino);
        Rfemenino.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Rfemenino.setText("F");
        Rfemenino.setToolTipText("");
        Rfemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RfemeninoActionPerformed(evt);
            }
        });
        getContentPane().add(Rfemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 100, -1, -1));

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 140, -1));

        Rmasculino.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Rmasculino);
        Rmasculino.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Rmasculino.setText("M");
        getContentPane().add(Rmasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, 60, 23));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 110, -1));

        jLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLimpiar.setText("limpiar campos");
        jLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Ciudad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Codigo postal:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, 20));

        txtCodigoPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPostalActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 160, -1));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 120, -1));

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 100, -1));

        comboBoxVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxVacunaActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxVacuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 120, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Vacuna:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 70, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Hospital:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, -1, -1));

        comboBoxHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxHospitalActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxHospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 200, 110, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenFondo/imagenfONDO.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 970, 840));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Medicamento:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 200, -1, -1));

        cmbMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedicamentosActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 200, 120, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/covid19/imagenfONDO.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void RfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RfemeninoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RfemeninoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
          
        int renglon = tblPaciente.getSelectedRow();
        int id =  (int)tblPaciente.getValueAt(renglon, 0);
        Paciente pac = new Paciente();
        pac.setId(id);
        pac.setNombre(txtNombre.getText());
        pac.setApellidoPaterno(txtApellidoPaterno.getText());
        pac.setApellidoMaterno(txtApellidoMaterno.getText());
        char genero;
        genero = (Rfemenino.isSelected())?'F':'M';
        pac.setGenero(genero);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        try {
            pac.setFechaNacimiento(formatter.parse(txtFechaDeNacimiento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        pac.setCurp(txtCurp.getText());
        pac.setCiudad(txtCiudad.getText());
        pac.setCodigoPostal(Integer.parseInt(txtCodigoPostal.getText()));
        
        int numero = comboBoxVacuna.getSelectedIndex();
        switch(numero){
            case 0: pac.setIdVacunaPaciente(new Vacunas(1));
                    break; 
            case 1: pac.setIdVacunaPaciente(new Vacunas(2));
                    break;
            case 2: pac.setIdVacunaPaciente(new Vacunas(3));
                    break;
            case 3: pac.setIdVacunaPaciente(new Vacunas(4));
                    break;
            case 4: pac.setIdVacunaPaciente(new Vacunas(5));
                    break;
            case 5: pac.setIdVacunaPaciente(new Vacunas(6));
                    break;
            case 6: pac.setIdVacunaPaciente(new Vacunas(7));
                    break;
            case 7: pac.setIdVacunaPaciente(new Vacunas(8));
                    break;
            case 8: pac.setIdVacunaPaciente(new Vacunas(9));
                    break;
            case 9: pac.setIdVacunaPaciente(new Vacunas(10));
                    break;
            default: break;
        }
     
    
        int numero2 = comboBoxHospital.getSelectedIndex();
        switch(numero2){
            case 0: pac.setIdHospitales(new Hospital(1));
                    break; 
            case 1: pac.setIdHospitales(new Hospital(2));
                    break;
            case 2: pac.setIdHospitales(new Hospital(3));
                    break;
            case 3: pac.setIdHospitales(new Hospital(4));
                    break;
            case 4: pac.setIdHospitales(new Hospital(5));
                    break;
            case 5: pac.setIdHospitales(new Hospital(6));
                    break;
            case 6: pac.setIdHospitales(new Hospital(7));
                    break;
            case 7: pac.setIdHospitales(new Hospital(8));
                    break;
            case 8: pac.setIdHospitales(new Hospital(9));
                    break;      
            case 9: pac.setIdHospitales(new Hospital(10));
                    break;
            case 10: pac.setIdHospitales(new Hospital(11));
                    break;       
            case 11: pac.setIdHospitales(new Hospital(12));
                    break;        
            case 12: pac.setIdHospitales(new Hospital(13));
                    break;
            default: break;
        }
        
        int numero3 = cmbMedicamentos.getSelectedIndex();
        switch(numero3){
            case 0: pac.setIdMedicamento(new Medicamentos(1));
                    break; 
            case 1: pac.setIdMedicamento(new Medicamentos(2));
                    break;
            case 2: pac.setIdMedicamento(new Medicamentos(3));
                    break;
            case 3: pac.setIdMedicamento(new Medicamentos(4));
                    break;
            case 4: pac.setIdMedicamento(new Medicamentos(5));
                    break;
            case 5: pac.setIdMedicamento(new Medicamentos(6));
                    break;
            case 6: pac.setIdMedicamento(new Medicamentos(7));
                    break;
            case 7: pac.setIdMedicamento(new Medicamentos(8));
                    break;
            case 8: pac.setIdMedicamento(new Medicamentos(9));
                    break;
            case 9: pac.setIdMedicamento(new Medicamentos(10));
                    break;
                    
                    
                    
            default: break;
        }
        
      PacienteJpaController oscar = new PacienteJpaController();
        try {
            oscar.edit(pac);
            limpiar();
            cargaTabla();
            btnModificar.setEnabled(false); 
        } catch (Exception ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        pac.setIdVacunaPaciente((Vacunas) comboBoxVacuna.getSelectedItem());
//        pac.setIdHospitales((Hospital) comboBoxHospital.getSelectedItem());
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtCodigoPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPostalActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
        Paciente pac = new Paciente();
        pac.setNombre(txtNombre.getText());
        pac.setApellidoPaterno(txtApellidoPaterno.getText());
        pac.setApellidoMaterno(txtApellidoMaterno.getText());
        char genero;
        genero = (Rfemenino.isSelected())?'F':'M';
        pac.setGenero(genero);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            pac.setFechaNacimiento(formatter.parse(txtFechaDeNacimiento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        pac.setCurp(txtCurp.getText());
        pac.setCiudad(txtCiudad.getText());
        pac.setCodigoPostal(Integer.parseInt(txtCodigoPostal.getText()));
        int numero = comboBoxVacuna.getSelectedIndex();
        switch(numero){
            case 0: pac.setIdVacunaPaciente(new Vacunas(1));
                    break; 
            case 1: pac.setIdVacunaPaciente(new Vacunas(2));
                    break;
            case 2: pac.setIdVacunaPaciente(new Vacunas(3));
                    break;
            case 3: pac.setIdVacunaPaciente(new Vacunas(4));
                    break;
            case 4: pac.setIdVacunaPaciente(new Vacunas(5));
                    break;
            case 5: pac.setIdVacunaPaciente(new Vacunas(6));
                    break;
            case 6: pac.setIdVacunaPaciente(new Vacunas(7));
                    break;
            case 7: pac.setIdVacunaPaciente(new Vacunas(8));
                    break;
            case 8: pac.setIdVacunaPaciente(new Vacunas(9));
                    break;
            case 9: pac.setIdVacunaPaciente(new Vacunas(10));
                    break;
            default: break;
        }
        int numero2 = comboBoxHospital.getSelectedIndex();
        switch(numero2){
            case 0: pac.setIdHospitales(new Hospital(1));
                    break; 
            case 1: pac.setIdHospitales(new Hospital(2));
                    break;
            case 2: pac.setIdHospitales(new Hospital(3));
                    break;
            case 3: pac.setIdHospitales(new Hospital(4));
                    break;
            case 4: pac.setIdHospitales(new Hospital(5));
                    break;
            case 5: pac.setIdHospitales(new Hospital(6));
                    break;
            case 6: pac.setIdHospitales(new Hospital(7));
                    break;
            case 7: pac.setIdHospitales(new Hospital(8));
                    break;
            case 8: pac.setIdHospitales(new Hospital(9));
                    break;      
            case 9: pac.setIdHospitales(new Hospital(10));
                    break;
            case 10: pac.setIdHospitales(new Hospital(11));
                    break;       
            case 11: pac.setIdHospitales(new Hospital(12));
                    break;        
            case 12: pac.setIdHospitales(new Hospital(13));
                    break;
            default: break;
        }
        int numero3 = cmbMedicamentos.getSelectedIndex();
        switch(numero3){
            case 0: pac.setIdMedicamento(new Medicamentos(1));
                    break; 
            case 1: pac.setIdMedicamento(new Medicamentos(2));
                    break;
            case 2: pac.setIdMedicamento(new Medicamentos(3));
                    break;
            case 3: pac.setIdMedicamento(new Medicamentos(4));
                    break;
            case 4: pac.setIdMedicamento(new Medicamentos(5));
                    break;
            case 5: pac.setIdMedicamento(new Medicamentos(6));
                    break;
            case 6: pac.setIdMedicamento(new Medicamentos(7));
                    break;
            case 7: pac.setIdMedicamento(new Medicamentos(8));
                    break;
            case 8: pac.setIdMedicamento(new Medicamentos(9));
                    break;
            case 9: pac.setIdMedicamento(new Medicamentos(10));
                    break;
                    
                    
                    
            default: break;
        }
          
        Controladores.PacienteJpaController Oscar = new Controladores.PacienteJpaController();
        Oscar.create(pac);
  
        Vacunas vac = new VacunasJpaController().findVacunas(numero+1);
        int cantidad = vac.getCantidad()-1;
        vac.setCantidad(cantidad);
        try {
            new VacunasJpaController().edit(vac);
        } catch (Exception ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Medicamentos med = new MedicamentosJpaController().findMedicamentos(numero+1);
        int cantidadMed = med.getCantidad()-1;
        med.setCantidad(cantidadMed);
        try {
            new MedicamentosJpaController().edit(med);
        } catch (Exception ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        
        JOptionPane.showMessageDialog(this, "Paciente agragado exitosamente");
        cargaTabla();
        limpiar();
        cargaCombo();
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jLimpiarActionPerformed

    private void tblPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacienteMouseClicked
        int renglon = tblPaciente.getSelectedRow();
        txtNombre.setText(tblPaciente.getValueAt(renglon, 1).toString());
        txtApellidoPaterno.setText(tblPaciente.getValueAt(renglon, 2).toString());
        txtApellidoMaterno.setText(tblPaciente.getValueAt(renglon, 3).toString());
        
        //checar
        if(tblPaciente.getValueAt(renglon, 4).equals('M')){
            Rmasculino.setSelected(true);
        }else{
            Rfemenino.setSelected(true);
        }
       
        txtFechaDeNacimiento.setText(tblPaciente.getValueAt(renglon, 5).toString());
        txtCurp.setText(tblPaciente.getValueAt(renglon, 6).toString());
        
        txtCiudad.setText(tblPaciente.getValueAt(renglon, 7).toString());
        txtCodigoPostal.setText(tblPaciente.getValueAt(renglon, 8).toString());

//        revisarlos
        comboBoxVacuna.setSelectedItem(tblPaciente.getValueAt(renglon, 9).toString());
        comboBoxHospital.setSelectedItem(tblPaciente.getValueAt(renglon, 10).toString());
        
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblPacienteMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     
        
        int renglon = tblPaciente.getSelectedRow();
        int id =  (int)tblPaciente.getValueAt(renglon, 0);
        PacienteJpaController oscar = new PacienteJpaController();
        try {
            oscar.destroy(id);
            limpiar();
            cargaTabla();
            btnEliminar.setEnabled(false); //desactivar el btn
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(pacienteRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        
        
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtFechaDeNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaDeNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDeNacimientoActionPerformed

    private void btnRegresarMenuPrincActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuPrincActionPerformed
            inicioAdministrados m = new inicioAdministrados();
           m.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_btnRegresarMenuPrincActionPerformed

    private void comboBoxHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxHospitalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxHospitalActionPerformed

    private void comboBoxVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxVacunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxVacunaActionPerformed

    private void cmbMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedicamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedicamentosActionPerformed

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
            java.util.logging.Logger.getLogger(pacienteRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pacienteRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pacienteRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pacienteRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pacienteRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Rfemenino;
    private javax.swing.JRadioButton Rmasculino;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresarMenuPrinc;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<ComboItem> cmbMedicamentos;
    private javax.swing.JComboBox<ComboItem> comboBoxHospital;
    private javax.swing.JComboBox<ComboItem> comboBoxVacuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLimpiar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblPaciente;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtFechaDeNacimiento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
