/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19;

import Controladores.FarmaciaJpaController;
import Controladores.HospitalJpaController;
import Controladores.MedicamentosJpaController;
import Controladores.VacunasJpaController;
import Entidades.Farmacia;
import Entidades.Hospital;
import Entidades.Medicamentos;
import Entidades.Vacunas;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class pacienteVista extends javax.swing.JFrame {

    /**
     * Creates new form pacienteVista
     */
    public pacienteVista() {
        initComponents();
        cargaTablaFarmacia();
        cargaTablaHospitales();
        cargaTablaVacunas();
        cargaTablaMedicamentos();
    }

    private void cargaTablaFarmacia(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nombre farmacia");
        dtm.addColumn("Municipio");
        
        dtm.addColumn("Nombre vacuna");
        
       
        Object[] fila = new Object[5];
        FarmaciaJpaController pc = new FarmaciaJpaController();
        List<Farmacia> lista = pc.findFarmaciaEntities();
        for(Farmacia p:lista){
            fila[0]= p.getId();
            fila[1]= p.getNombreFarmacia();
            fila[2]= p.getMunicipio();
            
            fila[3]= p.getIdVacunaFarmacia().getNombreDeVacuna();
     
            dtm.addRow(fila);
            
        }
        tablaFarmacias.setModel(dtm);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     private void cargaTablaHospitales(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nombre del hospital");
        dtm.addColumn("Seguro de gatos medicos");
        dtm.addColumn("ocupacion");
        dtm.addColumn("Vacuna");
        
        
       
        Object[] fila = new Object[5];
        HospitalJpaController pc = new HospitalJpaController();
        List<Hospital> lista = pc.findHospitalEntities();
        for(Hospital p:lista){
            fila[0]= p.getId();
            fila[1]= p.getNombreHospital();
            fila[2]= p.getSeguroDeGatosMedicos();
            fila[3]= p.getOcupacion();
            fila[4]= p.getIdVacunaHospitales().getNombreDeVacuna();
            
     
            dtm.addRow(fila);
            
        }
        tablaHospitales1.setModel(dtm);
        
    }
     
     
     
     
     
      private void cargaTablaVacunas(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nombre de vacuna");
        dtm.addColumn("Cantidad");
        
       
        Object[] fila = new Object[3];
        VacunasJpaController pc = new VacunasJpaController();
        List<Vacunas> lista = pc.findVacunasEntities();
        for(Vacunas p:lista){
            fila[0]= p.getId();
            fila[1]= p.getNombreDeVacuna();
            fila[2]= p.getCantidad();
            
     
            dtm.addRow(fila);
            
        }
        tablasVacunas.setModel(dtm);
    }
      
      
      
       private void cargaTablaMedicamentos(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nombre del medicamento");
        dtm.addColumn("Precio");
        
       
        Object[] fila = new Object[3];
        MedicamentosJpaController pc = new MedicamentosJpaController();
        List<Medicamentos> lista = pc.findMedicamentosEntities();
        for(Medicamentos p:lista){
            fila[0]= p.getId();
            fila[1]= p.getNombreDeMedicamento();
            fila[2]= p.getPrecio();
            
     
            dtm.addRow(fila);
            
        }
        tblMedicamentos.setModel(dtm);
    }
      
      
      
      
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jMenu2 = new javax.swing.JMenu();
        tablaHospitales = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaFarmacias = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHospitales1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablasVacunas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMedicamentos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnaRegresarAlMenuPrincipal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1338, 900));
        getContentPane().setLayout(null);

        tablaHospitales.setToolTipText("");

        tablaFarmacias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tablaFarmacias);

        tablaHospitales.addTab("Farmacias", jScrollPane6);

        tablaHospitales1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaHospitales1);

        tablaHospitales.addTab("Hospitales", jScrollPane1);

        tablasVacunas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablasVacunas);

        tablaHospitales.addTab("Vacunas", jScrollPane3);

        tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMedicamentos);

        tablaHospitales.addTab("Medicamentos", jScrollPane2);

        getContentPane().add(tablaHospitales);
        tablaHospitales.setBounds(110, 90, 1140, 600);
        tablaHospitales.getAccessibleContext().setAccessibleName("Vacunas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vista Paciente");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(600, 20, 230, 50);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(810, 720, 173, 60);

        btnaRegresarAlMenuPrincipal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnaRegresarAlMenuPrincipal.setText("Regresar al menu principal");
        btnaRegresarAlMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaRegresarAlMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnaRegresarAlMenuPrincipal);
        btnaRegresarAlMenuPrincipal.setBounds(390, 720, 270, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenFondo/imagenfONDO.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1340, 840);

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 30, 34, 14);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnaRegresarAlMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaRegresarAlMenuPrincipalActionPerformed
        Inicio inc = new Inicio();
        inc.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_btnaRegresarAlMenuPrincipalActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pacienteVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnaRegresarAlMenuPrincipal;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tablaFarmacias;
    private javax.swing.JTabbedPane tablaHospitales;
    private javax.swing.JTable tablaHospitales1;
    private javax.swing.JTable tablasVacunas;
    private javax.swing.JTable tblMedicamentos;
    // End of variables declaration//GEN-END:variables
}
