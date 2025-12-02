
package project.vetsys.view.assistant;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.vetsys.dao.CitaDAO;
import project.vetsys.model.Cita;
import project.vetsys.model.User;
import project.vetsys.view.Nimbus;
import project.vetsys.utils.ValidationInput;
import project.vetsys.view.manager.Appointment_Menu;


public class SearchAppointment extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchAppointment.class.getName());
    private User logUser;
    
    public SearchAppointment() {
        initComponents();
    }

    public SearchAppointment(User logUser){
        initComponents();
        Nimbus.LookandFeel();
        this.logUser = logUser;
        cargarColumnasTabla();
        cargarEstadosCita();
        cargarTodasLasCitas();
        ValidationInput.numbers(txtDocumentoCliente);

        cmbHora.removeAllItems();
        btnEliminar.setVisible(false);
        setTitle("Gestión de citas");
        SearchAppoint_lblNameClinic.setText(logUser.getClinic().getName_clinic());
        Nimbus.styleAllTextFields(this);
        Nimbus.styleTable(tableCitas);
        
        // Validaciones en entrada de campos de textos
        ValidationInput.text(txtNombreCliente, 30);
        ValidationInput.text(txtNombreMascota, 30);
        ValidationInput.text(txtNombreVet, 30);
        ValidationInput.text(txtEstado, 30);
        ValidationInput.numbers(txtDocumentoCliente, 11);
    }
    
    
    private void cargarTabla(List<Cita> citas) {

        DefaultTableModel model = (DefaultTableModel) tableCitas.getModel();
        model.setRowCount(0);

        for (Cita cita : citas) {
            model.addRow(new Object[]{
                cita.getIdCita(),              // 0
                cita.getNombreCliente(),       // 1
                cita.getNombreMascota(),       // 2
                cita.getNombreVeterinario(),   // 3
                cita.getFechaSeparada(),       // 4
                cita.getHoraSeparada(),        // 5
                cita.getEstado(),              // 6
                cita.getIdVeterinario()        // 7 (columna oculta)
            });
        }

        ocultarColumnaVeterinario();
    }
    
    private void ocultarColumnaVeterinario() {
        // La columna 7 contiene id veterinario
        tableCitas.getColumnModel().getColumn(7).setMinWidth(0);
        tableCitas.getColumnModel().getColumn(7).setMaxWidth(0);
        tableCitas.getColumnModel().getColumn(7).setWidth(0);
    }
    
    private void cargarColumnasTabla() {
        
        DefaultTableModel model = (DefaultTableModel) tableCitas.getModel();
        model.addColumn("ID Cita");         // 0
        model.addColumn("Cliente");         // 1
        model.addColumn("Mascota");         // 2
        model.addColumn("Veterinario");     // 3
        model.addColumn("Fecha");           // 4
        model.addColumn("Hora");            // 5
        model.addColumn("Estado");          // 6
        model.addColumn("ID_Vet");  // columna oculta
        tableCitas.setModel(model);
        ocultarColumnaVeterinario();
    }

    private void cargarTodasLasCitas() {
        CitaDAO dao = new CitaDAO();
        DefaultTableModel model = (DefaultTableModel) tableCitas.getModel();
        List<Cita> citas = dao.listarCitasPorClinica(logUser.getId_clinic());
        model.setRowCount(0);

        for (Cita cita : citas) {
            model.addRow(new Object[]{
                cita.getIdCita(),
                cita.getNombreCliente(),
                cita.getNombreMascota(),
                cita.getNombreVeterinario(),
                cita.getFechaSeparada(),     // yyyy-MM-dd
                cita.getHoraSeparada(),      // HH:mm
                cita.getEstado(),
                cita.getIdVeterinario()
            });
        }
        ocultarColumnaVeterinario();
    }

    private void cargarHorasDisponiblesVeterinario(int idVet, String fecha, String horaActual) {
        // Reset combo
        cmbHora.removeAllItems();
        cmbHora.addItem("Seleccione una hora");

        // horas base desde el DAO
        String[] horasBase = CitaDAO.horasbase();
        for (String hora : horasBase) {
            cmbHora.addItem(hora);
        }
        // Consultar horas ocupadas
        CitaDAO dao = new CitaDAO();
        List<String> horasOcupadas = dao.veterinarioOcupado(idVet, fecha);

        // Eliminar horas ocupadas
        for (String hora : horasOcupadas) {
            if (!hora.equals(horaActual)) {
            cmbHora.removeItem(hora);
            }
        }
    }
    
    private void cargarEstadosCita() {
        cmbEstado.removeAllItems();
        cmbEstado.addItem("Todos");
        cmbEstado.addItem("Programada");
        cmbEstado.addItem("Realizada");
        cmbEstado.addItem("Cancelada");
        System.out.println("Estados cargados: " + cmbEstado.getItemCount());
        cmbEstado.setSelectedIndex(0);
    }


    private void limpiarCampos() {
        txtIdCita.setText("");
        txtDocumentoCliente.setText("");
        txtNombreCliente.setText("");
        txtNombreMascota.setText("");
        txtNombreVet.setText("");
        jDateChooserFecha.setDate(null);
        cmbHora.removeAllItems();
        txtEstado.setText("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchAppointmentPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        SearchAppointment_lblPet = new javax.swing.JLabel();
        SearchAppointment_lblVet = new javax.swing.JLabel();
        txtNombreVet = new javax.swing.JTextField();
        SearchAppointment_lblDate = new javax.swing.JLabel();
        SearchAppointment_lblStatus = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        SearchAppointment_lblDate1 = new javax.swing.JLabel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        txtNombreMascota = new javax.swing.JTextField();
        JLabelCliente = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        cmbHora = new javax.swing.JComboBox<>();
        txtIdCliente1 = new javax.swing.JLabel();
        txtIdCita = new javax.swing.JTextField();
        SearchAppoint_lblNameClinic = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        SearchAppointment_lblClientID = new javax.swing.JLabel();
        txtDocumentoCliente = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCitas = new javax.swing.JTable();
        SearchAppointment_lblClientID1 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        MenuUsers_BttnUpdateUser = new javax.swing.JButton();
        MenuUsers_BttnCancelUser = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        SearchAppointment_BttnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setSize(new java.awt.Dimension(1000, 800));

        SearchAppointmentPanel.setBackground(new java.awt.Color(255, 255, 255));
        SearchAppointmentPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(500, 800));
        Left.setMinimumSize(new java.awt.Dimension(500, 800));

        SearchAppointment_lblPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblPet.setText("Mascota");

        SearchAppointment_lblVet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblVet.setText("Veterinario");

        txtNombreVet.setEditable(false);

        SearchAppointment_lblDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblDate.setText("Fecha");

        SearchAppointment_lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblStatus.setText("Estado");

        txtEstado.setEditable(false);

        SearchAppointment_lblDate1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblDate1.setText("Hora");

        jDateChooserFecha.setMinimumSize(new java.awt.Dimension(64, 24));

        txtNombreMascota.setEditable(false);

        JLabelCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLabelCliente.setText("Cliente");

        txtNombreCliente.setEditable(false);

        txtIdCliente1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtIdCliente1.setText("ID Cita");

        txtIdCita.setEditable(false);
        txtIdCita.setBackground(new java.awt.Color(0, 153, 153));
        txtIdCita.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtIdCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdCita.setBorder(null);
        txtIdCita.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        SearchAppoint_lblNameClinic.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        SearchAppoint_lblNameClinic.setForeground(java.awt.SystemColor.activeCaption);
        SearchAppoint_lblNameClinic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LeftLayout.createSequentialGroup()
                                .addComponent(txtIdCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdCita, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(txtNombreVet)
                            .addComponent(txtNombreMascota)
                            .addComponent(txtNombreCliente)
                            .addComponent(txtEstado))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchAppointment_lblDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchAppointment_lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchAppointment_lblVet, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchAppointment_lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchAppointment_lblPet, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(252, 301, Short.MAX_VALUE))))
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchAppoint_lblNameClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(SearchAppoint_lblNameClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente1)
                    .addComponent(txtIdCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 46, Short.MAX_VALUE)
                .addComponent(JLabelCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(SearchAppointment_lblPet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(SearchAppointment_lblVet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreVet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchAppointment_lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchAppointment_lblDate1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(SearchAppointment_lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );

        SearchAppointmentPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 800));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(500, 800));
        Right.setMinimumSize(new java.awt.Dimension(500, 800));
        Right.setPreferredSize(new java.awt.Dimension(500, 800));

        SearchAppointment_lblClientID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        SearchAppointment_lblClientID.setText("Documento Cliente");

        btnConsultar.setBackground(new java.awt.Color(0, 153, 153));
        btnConsultar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(null);
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        tableCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCitas);

        SearchAppointment_lblClientID1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        SearchAppointment_lblClientID1.setText("Estado cita");

        cmbEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        MenuUsers_BttnUpdateUser.setBackground(new java.awt.Color(0, 153, 153));
        MenuUsers_BttnUpdateUser.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        MenuUsers_BttnUpdateUser.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_BttnUpdateUser.setText("Modificar");
        MenuUsers_BttnUpdateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuUsers_BttnUpdateUser.setFocusPainted(false);
        MenuUsers_BttnUpdateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnUpdateUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnUpdateUserMouseExited(evt);
            }
        });
        MenuUsers_BttnUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsers_BttnUpdateUserActionPerformed(evt);
            }
        });

        MenuUsers_BttnCancelUser.setBackground(new java.awt.Color(0, 153, 153));
        MenuUsers_BttnCancelUser.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        MenuUsers_BttnCancelUser.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_BttnCancelUser.setText("Cancelar");
        MenuUsers_BttnCancelUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuUsers_BttnCancelUser.setFocusPainted(false);
        MenuUsers_BttnCancelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnCancelUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnCancelUserMouseExited(evt);
            }
        });
        MenuUsers_BttnCancelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsers_BttnCancelUserActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 153, 153));
        btnEliminar.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        SearchAppointment_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        SearchAppointment_BttnBack.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        SearchAppointment_BttnBack.setForeground(new java.awt.Color(255, 255, 255));
        SearchAppointment_BttnBack.setText("Salir");
        SearchAppointment_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchAppointment_BttnBack.setFocusPainted(false);
        SearchAppointment_BttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchAppointment_BttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchAppointment_BttnBackMouseExited(evt);
            }
        });
        SearchAppointment_BttnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchAppointment_BttnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SearchAppointment_lblClientID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchAppointment_lblClientID1)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(MenuUsers_BttnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SearchAppointment_BttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MenuUsers_BttnCancelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(btnEliminar)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID)
                    .addComponent(SearchAppointment_lblClientID1))
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuUsers_BttnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuUsers_BttnCancelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SearchAppointment_BttnBack)
                .addGap(137, 137, 137))
        );

        SearchAppointmentPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 690, 730));

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
                .addComponent(SearchAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        cmbEstado.setSelectedItem("Todos");
        String doc = txtDocumentoCliente.getText().trim();
        CitaDAO dao = new CitaDAO();
        List<Cita> citasFiltradas;
        
        if (doc.isEmpty()) {
            cargarTodasLasCitas();
            return;
        } else {
            citasFiltradas = dao.buscarCitaPorDocumento(logUser.getId_clinic(), doc);
        }
        if (citasFiltradas == null || citasFiltradas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron citas.");
            limpiarCampos();
            cargarTodasLasCitas();
            return;
        }
        cargarTabla(citasFiltradas);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void tableCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCitasMouseClicked
        
        DefaultTableModel model = (DefaultTableModel) tableCitas.getModel();
        int fila = tableCitas.getSelectedRow();
        
        if (fila >= 0) {
            
            txtIdCita.setText(model.getValueAt(fila, 0).toString());  
            txtNombreCliente.setText(model.getValueAt(fila, 1).toString());  
            txtNombreMascota.setText(model.getValueAt(fila, 2).toString());  
            txtNombreVet.setText(model.getValueAt(fila, 3).toString());  
            String estado = model.getValueAt(fila, 6).toString();
            txtEstado.setText(estado);
            // ID vet
            int idVet = Integer.parseInt(model.getValueAt(fila, 7).toString());
            //bandera si esta cancelada no permite editar
            boolean cancelada = estado.equalsIgnoreCase("cancelada");
            jDateChooserFecha.setEnabled(!cancelada);
            cmbHora.setEnabled(!cancelada);
            btnEliminar.setVisible(cancelada);
            // FECHA
            String fechaStr = model.getValueAt(fila, 4).toString(); // yyyy-MM-dd
            java.util.Date fechaUtil = java.sql.Date.valueOf(fechaStr);
            jDateChooserFecha.setDate(fechaUtil);

            // HORA
            String horaActual = model.getValueAt(fila, 5).toString(); // HH:mm
            // Cargar horas disponibles
            cargarHorasDisponiblesVeterinario(idVet, fechaStr, horaActual);
            cmbHora.setSelectedItem(horaActual); // Seleccionar la hora actual
        }
    }//GEN-LAST:event_tableCitasMouseClicked

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        
        String estadoSeleccionado = (String) cmbEstado.getSelectedItem();
        if (estadoSeleccionado == null) return;

        boolean filtrarTodas = estadoSeleccionado.equalsIgnoreCase("Todos") || estadoSeleccionado.trim().isEmpty();
        String documento = txtDocumentoCliente.getText().trim();

        CitaDAO dao = new CitaDAO();
        List<Cita> resultados;

        try {
            if (filtrarTodas) {
                btnEliminar.setVisible(false);
                // Si hay documento: mostrar solo las citas de ese cliente
                if (!documento.isEmpty()) {
                    resultados = dao.buscarCitaPorDocumento(logUser.getId_clinic(), documento);
                } else {
                    resultados = dao.listarCitasPorClinica(logUser.getId_clinic());
                }
            } else {
                // combinar ambos filtros
                if (!documento.isEmpty()) {
                    resultados = dao.buscarCitaPorDocumentoYEstado(logUser.getId_clinic(), documento, estadoSeleccionado);
                } else {
                    resultados = dao.buscarCitasPorEstado(logUser.getId_clinic(), estadoSeleccionado);
                }
            }
            if (resultados == null || resultados.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) tableCitas.getModel();
                model.setRowCount(0);  // deja tabla vacía
                return;
            }
            cargarTabla(resultados);
            btnEliminar.setVisible(estadoSeleccionado.equalsIgnoreCase("Cancelada"));

        } catch (Exception e) {
            System.out.println("Error al filtrar por estado: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void MenuUsers_BttnUpdateUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnUpdateUserMouseEntered
        MenuUsers_BttnUpdateUser.setBackground(Color.LIGHT_GRAY);
        MenuUsers_BttnUpdateUser.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuUsers_BttnUpdateUserMouseEntered

    private void MenuUsers_BttnUpdateUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnUpdateUserMouseExited
        MenuUsers_BttnUpdateUser.setBackground(new Color(0,153,153));
        MenuUsers_BttnUpdateUser.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuUsers_BttnUpdateUserMouseExited

    private void MenuUsers_BttnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsers_BttnUpdateUserActionPerformed
                if (txtIdCita.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita.");
            return;
        }
        // Validar estado
        String estado = txtEstado.getText().trim();
        if (!estado.equalsIgnoreCase("programada")) {
            JOptionPane.showMessageDialog(this, "No se puede modificar una cita cancelada o realizada.");
            return;
        }
        int idCita = Integer.parseInt(txtIdCita.getText());
        java.util.Date utilFecha = jDateChooserFecha.getDate();
        String hora = cmbHora.getSelectedItem().toString();

        String fechaStr = new java.text.SimpleDateFormat("yyyy-MM-dd").format(utilFecha);
        String fechaHora = fechaStr + " " + hora + ":00";
        
        // Crear objeto Cita actualizado
        Cita cita = new Cita();
        cita.setIdCita(idCita);
        cita.setFecha(java.sql.Timestamp.valueOf(fechaHora));
        
        //  crear DAO Actualizar en DB
        CitaDAO dao = new CitaDAO();
        if (dao.actualizarCita(cita)) {
            JOptionPane.showMessageDialog(this, "Cita actualizada.");
            cargarTodasLasCitas();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar.");
        }
    }//GEN-LAST:event_MenuUsers_BttnUpdateUserActionPerformed

    private void MenuUsers_BttnCancelUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnCancelUserMouseEntered
        MenuUsers_BttnCancelUser.setBackground(Color.LIGHT_GRAY);
        MenuUsers_BttnCancelUser.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuUsers_BttnCancelUserMouseEntered

    private void MenuUsers_BttnCancelUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnCancelUserMouseExited
        MenuUsers_BttnCancelUser.setBackground(new Color(0,153,153));
        MenuUsers_BttnCancelUser.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuUsers_BttnCancelUserMouseExited

    private void MenuUsers_BttnCancelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsers_BttnCancelUserActionPerformed
                
        if (txtIdCita.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione una cita.");
        return;
        }
        int idCita = Integer.parseInt(txtIdCita.getText());
        CitaDAO dao = new CitaDAO();
        if (dao.cancelarCita(idCita)) {
            JOptionPane.showMessageDialog(this, "Cita cancelada.");
            cargarTodasLasCitas();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo cancelar.");
        }
    }//GEN-LAST:event_MenuUsers_BttnCancelUserActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(Color.LIGHT_GRAY);
        btnEliminar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new Color(0,153,153));
        btnEliminar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtIdCita.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una cita.");
            return;
        }
        String estado = txtEstado.getText().trim();
        if (!estado.equalsIgnoreCase("cancelada")) {
            JOptionPane.showMessageDialog(this, 
                "Solo se pueden eliminar las citas CANCELADAS",
                "No permitido",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas eliminar esta cita?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int idCita = Integer.parseInt(txtIdCita.getText());
        CitaDAO dao = new CitaDAO();

        if (dao.eliminarCita(idCita)) {
            JOptionPane.showMessageDialog(this, "Cita eliminada correctamente.");
            limpiarCampos();
            cargarTodasLasCitas();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar la cita.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void SearchAppointment_BttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_BttnBackMouseEntered
        SearchAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
        SearchAppointment_BttnBack.setForeground(Color.BLACK);
    }//GEN-LAST:event_SearchAppointment_BttnBackMouseEntered

    private void SearchAppointment_BttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_BttnBackMouseExited
        SearchAppointment_BttnBack.setBackground(new Color(0,153,153));
        SearchAppointment_BttnBack.setForeground(Color.WHITE);
    }//GEN-LAST:event_SearchAppointment_BttnBackMouseExited

    private void SearchAppointment_BttnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchAppointment_BttnBackActionPerformed
        Appointment_Menu MenuAppointmentFrame = new Appointment_Menu(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_SearchAppointment_BttnBackActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new SearchAppointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelCliente;
    private javax.swing.JPanel Left;
    private javax.swing.JButton MenuUsers_BttnCancelUser;
    private javax.swing.JButton MenuUsers_BttnUpdateUser;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel SearchAppoint_lblNameClinic;
    private javax.swing.JPanel SearchAppointmentPanel;
    private javax.swing.JButton SearchAppointment_BttnBack;
    private javax.swing.JLabel SearchAppointment_lblClientID;
    private javax.swing.JLabel SearchAppointment_lblClientID1;
    private javax.swing.JLabel SearchAppointment_lblDate;
    private javax.swing.JLabel SearchAppointment_lblDate1;
    private javax.swing.JLabel SearchAppointment_lblPet;
    private javax.swing.JLabel SearchAppointment_lblStatus;
    private javax.swing.JLabel SearchAppointment_lblVet;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbHora;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCitas;
    private javax.swing.JTextField txtDocumentoCliente;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdCita;
    private javax.swing.JLabel txtIdCliente1;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreMascota;
    private javax.swing.JTextField txtNombreVet;
    // End of variables declaration//GEN-END:variables
}
