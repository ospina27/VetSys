package project.vetsys.view.assistant;

import java.awt.Color;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import project.vetsys.dao.CitaDAO;
import project.vetsys.dao.ClienteDAO;
import project.vetsys.dao.HistoriaClinicaDAO;
import project.vetsys.dao.PetDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.ClienteModel;
import project.vetsys.model.HistoriaClinicaDetalle;
import project.vetsys.model.Pet;
import project.vetsys.model.User;
import project.vetsys.utils.ValidationInput;
import project.vetsys.view.manager.Appointment_Menu;


public class SearchHistory extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchHistory.class.getName());
    private User logUser;
    private CitaDAO citaDAO = new CitaDAO();
    private HistoriaClinicaDAO hcDAO = new HistoriaClinicaDAO();
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
    
    public SearchHistory() {
        initComponents();
    }

    public SearchHistory(User logUser){
        initComponents();
        this.logUser = logUser;
        cargarColumnasTabla();
        cargarHistorialClinico();
        cargarVeterinarios();
        btnVerDetalle.setEnabled(false);
        
        // Validaciones en entrada de campos de textos
        ValidationInput.numbers(txtDocumentoCliente, 11);
    }
    
    
    private void cargarTabla(List<HistoriaClinicaDetalle> historial) {

        DefaultTableModel model = (DefaultTableModel) tablaHistorial.getModel();
        model.setRowCount(0);
        for (HistoriaClinicaDetalle hc : historial) {
            model.addRow(new Object[]{
                hc.getIdHistoria(),
                hc.getFechaRegistro(),
                hc.getNombreMascota(),
                hc.getEspecie(),
                hc.getRaza(),
                hc.getNombreCliente(),
                hc.getDocumentoCliente(),
                hc.getNombreVeterinario(),
                hc.getDiagnostico()
            });
        }
    }
    

    private void cargarColumnasTabla() {
        
        DefaultTableModel model = (DefaultTableModel) tablaHistorial.getModel();
        model.addColumn("ID de registro");              // 0
        model.addColumn("Fecha");                       // 1
        model.addColumn("Mascota");                     // 2
        model.addColumn("Especie");                     // 3
        model.addColumn("Raza");                        // 4
        model.addColumn("Cliente");                     // 5
        model.addColumn("Documento");                   // 6
        model.addColumn("Veterinario");                 // 7 
        model.addColumn("Diagnóstico");                 // 8
        tablaHistorial.setModel(model);
    }

    
    private void cargarHistorialClinico() {
        
        List<HistoriaClinicaDetalle> lista = hcDAO.listarDetallesPorClinica(logUser.getId_clinic());
        cargarTabla(lista);
    }
    
    
    private void cargarVeterinarios() {
        UserDAO dao = new UserDAO();
        int rolVeterinario = 2;
        List<User> veterinarios = dao.ReadByClinicAndRole(logUser.getId_clinic(), rolVeterinario);
        comboVeterinario.removeAllItems();
        comboVeterinario.addItem("Todos");
        for (User vet : veterinarios) {
            comboVeterinario.addItem(vet.getId_user() + " - " + vet.getName_user() + " " + vet.getLast_name());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchAppointmentPanel = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        SearchAppointment_BttnBack = new javax.swing.JPanel();
        lblBttnBack = new javax.swing.JLabel();
        SearchAppointment_lblClientID = new javax.swing.JLabel();
        txtDocumentoCliente = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnVerDetalle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        Up = new javax.swing.JPanel();
        ScheduleAppointment_lblTittle = new javax.swing.JLabel();
        ScheduleAppointment_lblSubTittle = new javax.swing.JLabel();
        comboVeterinario = new javax.swing.JComboBox<>();
        SearchAppointment_lblClientID2 = new javax.swing.JLabel();
        SearchAppointment_lblClientID3 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        btnLimpiarFecha = new javax.swing.JButton();

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
        SearchAppointment_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblBttnBack.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBttnBack.setText("Salir");
        lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SearchAppointment_BttnBackLayout = new javax.swing.GroupLayout(SearchAppointment_BttnBack);
        SearchAppointment_BttnBack.setLayout(SearchAppointment_BttnBackLayout);
        SearchAppointment_BttnBackLayout.setHorizontalGroup(
            SearchAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBttnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        SearchAppointment_BttnBackLayout.setVerticalGroup(
            SearchAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchAppointment_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SearchAppointment_lblClientID.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        SearchAppointment_lblClientID.setText("Documento Cliente");

        txtDocumentoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoClienteActionPerformed(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(0, 153, 153));
        btnConsultar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(null);
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnVerDetalle.setBackground(new java.awt.Color(0, 153, 153));
        btnVerDetalle.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnVerDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnVerDetalle.setText("Ver detalle");
        btnVerDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaHistorialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaHistorial);

        Up.setBackground(new java.awt.Color(0, 153, 153));
        Up.setMaximumSize(new java.awt.Dimension(1000, 100));
        Up.setMinimumSize(new java.awt.Dimension(1000, 100));

        ScheduleAppointment_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
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
            .addComponent(ScheduleAppointment_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        ScheduleAppointment_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ScheduleAppointment_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblSubTittle.setText("Historial Clínico");

        comboVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVeterinarioActionPerformed(evt);
            }
        });

        SearchAppointment_lblClientID2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        SearchAppointment_lblClientID2.setText("Veterinario");

        SearchAppointment_lblClientID3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        SearchAppointment_lblClientID3.setText("Fecha");

        dateChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateChooserMouseClicked(evt);
            }
        });
        dateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserPropertyChange(evt);
            }
        });

        btnLimpiarFecha.setBackground(new java.awt.Color(204, 204, 204));
        btnLimpiarFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLimpiarFecha.setForeground(new java.awt.Color(0, 153, 153));
        btnLimpiarFecha.setText("Limpiar");
        btnLimpiarFecha.setBorder(null);
        btnLimpiarFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ScheduleAppointment_lblSubTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpiarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(SearchAppointment_lblClientID)
                                .addGap(18, 18, 18)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(122, 122, 122)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SearchAppointment_lblClientID2)
                                    .addComponent(SearchAppointment_lblClientID3))
                                .addGap(33, 33, 33)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(comboVeterinario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(btnVerDetalle)
                        .addGap(293, 293, 293)
                        .addComponent(SearchAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(Up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ScheduleAppointment_lblSubTittle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchAppointment_lblClientID)
                            .addComponent(comboVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchAppointment_lblClientID2))
                        .addGap(28, 28, 28)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SearchAppointment_lblClientID3)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))))
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

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
        int fila = tablaHistorial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un registro", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idHistoria = Integer.parseInt(tablaHistorial.getValueAt(fila, 0).toString());

        HistoriaClinicaDAO dao = new HistoriaClinicaDAO();
        HistoriaClinicaDetalle detalle = dao.obtenerDetallePorId(idHistoria);
        DetailedHistory dialog = new DetailedHistory((java.awt.Frame) SwingUtilities.getWindowAncestor(this), true, detalle);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        
        String doc = txtDocumentoCliente.getText().trim();
        List<HistoriaClinicaDetalle> lista;
        if (doc.isEmpty()) {
            lista = hcDAO.listarDetallesPorClinica(logUser.getId_clinic());
        } else {
            lista = hcDAO.filtrarPorDocumento(logUser.getId_clinic(), doc);
            if (lista == null || lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron registros de historia clínica.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
                txtDocumentoCliente.setText("");
                lista = hcDAO.listarDetallesPorClinica(logUser.getId_clinic());
            }
        }
        cargarTabla(lista);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtDocumentoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoClienteActionPerformed

    private void lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBttnBackMouseExited
        SearchAppointment_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_lblBttnBackMouseExited

    private void lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBttnBackMouseEntered
        SearchAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lblBttnBackMouseEntered

    private void lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBttnBackMouseClicked
        Appointment_Menu MenuAppointmentFrame = new Appointment_Menu(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblBttnBackMouseClicked

    private void tablaHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHistorialMouseClicked
        
        int fila = tablaHistorial.getSelectedRow();
        if (fila >= 0) {
            int idHistoria = Integer.parseInt(tablaHistorial.getValueAt(fila, 0).toString());
            // opcional: obtener detalle completo si lo necesitas para previsualizar
            // HistoriaClinicaDetalle detalle = hcDAO.obtenerDetallePorId(idHistoria);
            btnVerDetalle.setEnabled(true);
        }
    }//GEN-LAST:event_tablaHistorialMouseClicked

    private void comboVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVeterinarioActionPerformed
        Object selected = comboVeterinario.getSelectedItem();
        if (selected == null || selected.equals("Todos")) {
            cargarHistorialClinico();
            return;
        }
        int idVet = Integer.parseInt(selected.toString().split(" - ")[0]);
        HistoriaClinicaDAO hcDAO = new HistoriaClinicaDAO();
        List<HistoriaClinicaDetalle> filtrado = hcDAO.filtrarPorVeterinario(logUser.getId_clinic(), idVet);
        cargarTabla(filtrado);
    }//GEN-LAST:event_comboVeterinarioActionPerformed

    private void dateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateChooserMouseClicked
        
    }//GEN-LAST:event_dateChooserMouseClicked

    private void dateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserPropertyChange
        Date fechaSeleccionada = dateChooser.getDate();
        if (fechaSeleccionada == null) {
            return;
        }
        Timestamp fecha = new Timestamp(fechaSeleccionada.getTime());
        HistoriaClinicaDAO dao = new HistoriaClinicaDAO();
        List<HistoriaClinicaDetalle> lista = dao.filtrarPorFecha(logUser.getId_clinic(), fecha);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron registros para la fecha seleccionada.",
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE);
            lista = dao.listarDetallesPorClinica(logUser.getId_clinic());
        }
        cargarTabla(lista);
    }//GEN-LAST:event_dateChooserPropertyChange

    private void btnLimpiarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFechaActionPerformed
        dateChooser.setDate(null);
        HistoriaClinicaDAO dao = new HistoriaClinicaDAO();
        List<HistoriaClinicaDetalle> lista = dao.listarDetallesPorClinica(logUser.getId_clinic());
        cargarTabla(lista);
        btnVerDetalle.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarFechaActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SearchHistory().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Right;
    private javax.swing.JLabel ScheduleAppointment_lblSubTittle;
    private javax.swing.JLabel ScheduleAppointment_lblTittle;
    private javax.swing.JPanel SearchAppointmentPanel;
    private javax.swing.JPanel SearchAppointment_BttnBack;
    private javax.swing.JLabel SearchAppointment_lblClientID;
    private javax.swing.JLabel SearchAppointment_lblClientID2;
    private javax.swing.JLabel SearchAppointment_lblClientID3;
    private javax.swing.JPanel Up;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLimpiarFecha;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JComboBox<String> comboVeterinario;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBttnBack;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JTextField txtDocumentoCliente;
    // End of variables declaration//GEN-END:variables
}
