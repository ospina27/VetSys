package project.vetsys.view.assistant;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.vetsys.dao.CitaDAO;
import project.vetsys.dao.ClienteDAO;
import project.vetsys.dao.PetDAO;
import project.vetsys.model.Cita;
import project.vetsys.model.ClienteModel;
import project.vetsys.model.Pet;
import project.vetsys.model.User;
import project.vetsys.view.manager.Appointment_Menu;


public class AttendAppointment extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AttendAppointment.class.getName());
    private User logUser;
    private CitaDAO citaDAO = new CitaDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private PetDAO mascotaDAO = new PetDAO();
    private int idCitaSeleccionada = -1;
    private int idMascota;
    private int idCliente;
    private String clienteNombre;
    private String clienteDocumento;
    private String mascotaNombre;
    private String especie;
    private String raza;
    private String sexo;
    private String fechaNacimiento;
    
    public AttendAppointment() {
        initComponents();
    }

    public AttendAppointment(User logUser){
        initComponents();
        this.logUser = logUser;
        cargarColumnasTabla();
        cargarCitasPendientes();
        btnRegistrarHC.setEnabled(false);
    }
    
    
    private void cargarTabla(List<Cita> citas) {

        DefaultTableModel model = (DefaultTableModel) tableCitas.getModel();
        model.setRowCount(0);

        for (Cita cita : citas) {
            model.addRow(new Object[]{
                cita.getIdCita(),              // 0
                cita.getFechaSeparada(),       // 1
                cita.getHoraSeparada(),        // 2
                cita.getNombreCliente(),       // 3
                cita.getNombreMascota(),       // 4
                cita.getEstado(),              // 5
                cita.getIdCliente(),           // 6 oculto
                cita.getIdMascota(),           // 7 oculto
                cita.getIdVeterinario()        // 8 oculto
            });
        }
        ocultarColumnas();
    }
    

    private void cargarColumnasTabla() {
        
        DefaultTableModel model = (DefaultTableModel) tableCitas.getModel();
        model.addColumn("ID Cita");         // 0
        model.addColumn("Fecha");           // 1
        model.addColumn("Hora");            // 2
        model.addColumn("Cliente");         // 3
        model.addColumn("Mascota");         // 4
        model.addColumn("Estado");          // 5
        model.addColumn("ID Cliente");      // 6 oculto
        model.addColumn("ID Mascota");      // 7 oculto
        model.addColumn("ID Veterinario");  // 8oculto
        tableCitas.setModel(model);
        ocultarColumnas();
    }
    
    
    private void ocultarColumnas() {
        
        tableCitas.getColumnModel().getColumn(6).setMinWidth(0);
        tableCitas.getColumnModel().getColumn(6).setMaxWidth(0);
        tableCitas.getColumnModel().getColumn(6).setPreferredWidth(0);

        tableCitas.getColumnModel().getColumn(7).setMinWidth(0);
        tableCitas.getColumnModel().getColumn(7).setMaxWidth(0);
        tableCitas.getColumnModel().getColumn(7).setPreferredWidth(0);

        tableCitas.getColumnModel().getColumn(8).setMinWidth(0);
        tableCitas.getColumnModel().getColumn(8).setMaxWidth(0);
        tableCitas.getColumnModel().getColumn(8).setPreferredWidth(0);

    }

    
    private void cargarCitasPendientes() {
        List<Cita> lista = citaDAO.listarCitasPendientes(
                logUser.getId_clinic(), logUser.getId_user()
        );
        cargarTabla(lista);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchAppointmentPanel = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        SearchAppointment_BttnBack = new javax.swing.JPanel();
        SearchAppointment_lblBttnBack = new javax.swing.JLabel();
        SearchAppointment_lblClientID = new javax.swing.JLabel();
        txtDocumentoCliente = new javax.swing.JTextField();
        btnConsultarCitas = new javax.swing.JButton();
        btnRegistrarHC = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCitas = new javax.swing.JTable();
        SearchAppointment_lblClientID1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Up = new javax.swing.JPanel();
        ScheduleAppointment_lblTittle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setSize(new java.awt.Dimension(1000, 800));

        SearchAppointmentPanel.setBackground(new java.awt.Color(255, 255, 255));
        SearchAppointmentPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(500, 800));
        Right.setMinimumSize(new java.awt.Dimension(500, 800));
        Right.setPreferredSize(new java.awt.Dimension(500, 800));

        SearchAppointment_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        SearchAppointment_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        SearchAppointment_lblBttnBack.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SearchAppointment_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        SearchAppointment_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchAppointment_lblBttnBack.setText("Salir");
        SearchAppointment_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchAppointment_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SearchAppointment_BttnBackLayout = new javax.swing.GroupLayout(SearchAppointment_BttnBack);
        SearchAppointment_BttnBack.setLayout(SearchAppointment_BttnBackLayout);
        SearchAppointment_BttnBackLayout.setHorizontalGroup(
            SearchAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchAppointment_lblBttnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        SearchAppointment_BttnBackLayout.setVerticalGroup(
            SearchAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchAppointment_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SearchAppointment_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SearchAppointment_lblClientID.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        SearchAppointment_lblClientID.setText("Documento Cliente");

        txtDocumentoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoClienteActionPerformed(evt);
            }
        });

        btnConsultarCitas.setBackground(new java.awt.Color(0, 153, 153));
        btnConsultarCitas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnConsultarCitas.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarCitas.setText("Consultar");
        btnConsultarCitas.setBorder(null);
        btnConsultarCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCitasActionPerformed(evt);
            }
        });

        btnRegistrarHC.setBackground(new java.awt.Color(0, 153, 153));
        btnRegistrarHC.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnRegistrarHC.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarHC.setText("Registrar Historia Clinica");
        btnRegistrarHC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarHCActionPerformed(evt);
            }
        });

        tableCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCitasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCitas);

        SearchAppointment_lblClientID1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SearchAppointment_lblClientID1.setText("Búsqueda personalizada");

        Up.setBackground(new java.awt.Color(0, 153, 153));
        Up.setMaximumSize(new java.awt.Dimension(1000, 100));
        Up.setMinimumSize(new java.awt.Dimension(1000, 100));

        ScheduleAppointment_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ScheduleAppointment_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblTittle.setText("VetSys");

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScheduleAppointment_lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addComponent(ScheduleAppointment_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(SearchAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(btnRegistrarHC)
                        .addGap(348, 348, 348))))
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchAppointment_lblClientID1)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnConsultarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SearchAppointment_lblClientID)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
            .addComponent(Up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addComponent(Up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(SearchAppointment_lblClientID1)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(SearchAppointment_lblClientID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnRegistrarHC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SearchAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        SearchAppointmentPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SearchAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SearchAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarHCActionPerformed
        if (idCitaSeleccionada > 0) {
            RecordHistory RecordHistoryFrame = new RecordHistory(logUser.getId_clinic(), idCitaSeleccionada,idMascota,idCliente, clienteNombre, clienteDocumento, 
                        mascotaNombre, especie, raza, sexo, fechaNacimiento, logUser);
            RecordHistoryFrame.setVisible(true);
            RecordHistoryFrame.pack();
            RecordHistoryFrame.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarHCActionPerformed

    
    private void btnConsultarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCitasActionPerformed
        String doc = txtDocumentoCliente.getText().trim();

        List<Cita> lista;
        if (doc.isEmpty()) {
            lista = citaDAO.listarCitasPendientes(logUser.getId_clinic(), logUser.getId_user());
        } else {
            lista = citaDAO.buscarCitasPendientesPorDocumento(logUser.getId_clinic(), logUser.getId_user(), doc);
            if (lista == null || lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron citas programadas.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
                txtDocumentoCliente.setText(""); 
                lista = citaDAO.listarCitasPendientes(logUser.getId_clinic(), logUser.getId_user());
            }
        }
        cargarTabla(lista);
        btnRegistrarHC.setEnabled(false);
        idCitaSeleccionada = -1;
    }//GEN-LAST:event_btnConsultarCitasActionPerformed

    private void txtDocumentoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoClienteActionPerformed

    private void SearchAppointment_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnBackMouseExited
        SearchAppointment_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_SearchAppointment_lblBttnBackMouseExited

    private void SearchAppointment_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnBackMouseEntered
        SearchAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SearchAppointment_lblBttnBackMouseEntered

    private void SearchAppointment_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnBackMouseClicked
        Appointment_Menu MenuAppointmentFrame = new Appointment_Menu(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_SearchAppointment_lblBttnBackMouseClicked

    private void tableCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCitasMouseClicked
        
        int fila = tableCitas.getSelectedRow();
        
        if (fila >= 0) {
            idCitaSeleccionada = Integer.parseInt(tableCitas.getValueAt(fila, 0).toString());
            
            clienteNombre = tableCitas.getValueAt(fila, 3).toString();
            mascotaNombre = tableCitas.getValueAt(fila, 4).toString();
            idCliente = Integer.parseInt(tableCitas.getValueAt(fila, 6).toString());
            idMascota = Integer.parseInt(tableCitas.getValueAt(fila, 7).toString());
            
            ClienteModel cliente = clienteDAO.ReadId(idCliente);
            if (cliente != null) {
                clienteDocumento = cliente.getDocumento();
                clienteNombre = cliente.getNombres() + " " + cliente.getApellidos();
            }

            Pet mascota = mascotaDAO.ReadId(idMascota);
            if (mascota != null) {
                especie = mascota.getSpecies();
                raza = mascota.getBred();
                sexo = mascota.getSex();
                fechaNacimiento = mascota.getDate_of_birth().toString();
            }
            btnRegistrarHC.setEnabled(true);
        }
    }//GEN-LAST:event_tableCitasMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AttendAppointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Right;
    private javax.swing.JLabel ScheduleAppointment_lblTittle;
    private javax.swing.JPanel SearchAppointmentPanel;
    private javax.swing.JPanel SearchAppointment_BttnBack;
    private javax.swing.JLabel SearchAppointment_lblBttnBack;
    private javax.swing.JLabel SearchAppointment_lblClientID;
    private javax.swing.JLabel SearchAppointment_lblClientID1;
    private javax.swing.JPanel Up;
    private javax.swing.JButton btnConsultarCitas;
    private javax.swing.JButton btnRegistrarHC;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableCitas;
    private javax.swing.JTextField txtDocumentoCliente;
    // End of variables declaration//GEN-END:variables
}
