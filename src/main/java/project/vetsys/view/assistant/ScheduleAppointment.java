package project.vetsys.view.assistant;

import java.awt.Color;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import project.vetsys.dao.CitaDAO;
import project.vetsys.dao.ClienteDAO;
import project.vetsys.dao.PetDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.Cita;
import project.vetsys.model.ClienteModel;
import project.vetsys.model.Pet;
import project.vetsys.model.User;
import project.vetsys.view.Nimbus;
import project.vetsys.utils.ValidationInput;
import project.vetsys.view.manager.Appointment_Menu;


public class ScheduleAppointment extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ScheduleAppointment.class.getName());
    private User logUser;

    
    public ScheduleAppointment() {
        initComponents();
    }
    
    public ScheduleAppointment(User logUser) {
        this.logUser = logUser;
        Nimbus.LookandFeel();
        initComponents();
        cargarVeterinarios();
        setTitle("Gestion de Citas");
        ScheduleAppointment_lblTittle.setText(logUser.getClinic().getName_clinic());
        Nimbus.styleTitleLabel(ScheduleAppointment_lblSubTittle);
        Nimbus.styleAllTextFields(this);
        cargarHorasDisponiblesVeterinario();
        
        // Validaciones en entrada de campos de textos
        ValidationInput.numbers(txtDocumentoCliente, 11);
        ValidationInput.text(txtNombresCliente, 30);
        ValidationInput.text(txtApellidosCliente, 35);
       
    }
    
    private void cargarHorasDisponiblesVeterinario() {
        
        cmbHora.removeAllItems();
        cmbHora.addItem("Seleccione una hora");

        User vet = (User) cmbVeterinarios.getSelectedItem();
        if (vet == null || vet.getId_user() == 0) return;
        if (jDateChooserFecha.getDate() == null) return;
        int idVet = vet.getId_user();
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooserFecha.getDate());
        // horas base
        String[] horasBase = CitaDAO.horasbase();
        
        CitaDAO dao = new CitaDAO();
        List<String> ocupadas = dao.veterinarioOcupado(idVet, fecha);
        //cargar solo las horas disponibles
        for (String hora : horasBase) {
            if (!ocupadas.contains(hora)) {
                cmbHora.addItem(hora);
            }
        }
    }

    private void cargarVeterinarios() {
        try {
            UserDAO userDAO = new UserDAO();
            List<User> veterinarios = userDAO.ReadByClinicAndRole(logUser.getId_clinic(), 2);
            cmbVeterinarios.removeAllItems();
            
            User placeholder = new User();
            placeholder.setId_user(0);
            placeholder.setName_user("Seleccione un veterinario");
            placeholder.setLast_name("");
            cmbVeterinarios.addItem(placeholder);
            for (User vet : veterinarios) {
                cmbVeterinarios.addItem(vet);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando veterinarios: " + e.getMessage());
        }
    }
    
    private void cargarMascotas(int idCliente) {
        try {
            PetDAO petDAO = new PetDAO();
            List<Pet> mascotas = petDAO.ReadForClient(idCliente, logUser);
            cmbMascotas.removeAllItems();
            cmbMascotas.addItem("Seleccione una mascota");
            for (Pet mascota : mascotas) {
                cmbMascotas.addItem(mascota.getId_pet() + " - " + mascota.getName_Pet());
            }
        } catch (Exception e) {
            System.out.println("Error cargando mascotas: " + e.getMessage());
        }
    }
    
    private boolean validarCampos() {

        if (txtIdCliente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe buscar y seleccionar un cliente.");
            return false;
        }
        if (cmbMascotas.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una mascota.");
            return false;
        }
        User veterinario = (User) cmbVeterinarios.getSelectedItem();
        if (veterinario == null || veterinario.getId_user() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un veterinario.");
            return false;
        }
        if (jDateChooserFecha.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione la fecha de la cita.");
        return false;
        }
        if (cmbHora.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione la hora de la cita.");
            return false;
        }
        return true;
    }
    
    private void limpiarCampos() {
        txtDocumentoCliente.setText("");
        txtIdCliente.setText("");
        txtNombresCliente.setText("");
        txtApellidosCliente.setText("");
        cmbMascotas.removeAllItems();
        cmbVeterinarios.setSelectedIndex(0);
        cmbHora.setSelectedIndex(0);
        jDateChooserFecha.setDate(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScheduleAppointmentPanel = new javax.swing.JPanel();
        Up = new javax.swing.JPanel();
        ScheduleAppointment_lblTittle = new javax.swing.JLabel();
        Down = new javax.swing.JPanel();
        ScheduleAppointment_lblSubTittle = new javax.swing.JLabel();
        ScheduleAppointment_lblClientDocument = new javax.swing.JLabel();
        txtDocumentoCliente = new javax.swing.JTextField();
        ScheduleAppointment_lblPet = new javax.swing.JLabel();
        cmbMascotas = new javax.swing.JComboBox<>();
        ScheduleAppointment_lblVet = new javax.swing.JLabel();
        cmbVeterinarios = new javax.swing.JComboBox<>();
        ScheduleAppointment_lblDayMonth1 = new javax.swing.JLabel();
        ScheduleAppointment_lblDayMonth2 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        ScheduleAppointment_BttnBack = new javax.swing.JPanel();
        ScheduleAppointment_lblBttnBack = new javax.swing.JLabel();
        ScheduleAppointment_BttnSchedule = new javax.swing.JPanel();
        ScheduleAppointment_lblBttnSchedule = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombresCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidosCliente = new javax.swing.JTextField();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setSize(new java.awt.Dimension(1000, 800));

        ScheduleAppointmentPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        ScheduleAppointmentPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        ScheduleAppointmentPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        ScheduleAppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addComponent(ScheduleAppointment_lblTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addComponent(ScheduleAppointment_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ScheduleAppointmentPanel.add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Down.setBackground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(1000, 700));
        Down.setMinimumSize(new java.awt.Dimension(1000, 700));

        ScheduleAppointment_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ScheduleAppointment_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblSubTittle.setText("Agendar Cita");

        ScheduleAppointment_lblClientDocument.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblClientDocument.setText("Documento cliente");

        ScheduleAppointment_lblPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblPet.setText("Mascota");

        cmbMascotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMascotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ScheduleAppointment_lblVet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblVet.setText("Veterinario");

        cmbVeterinarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVeterinariosActionPerformed(evt);
            }
        });

        ScheduleAppointment_lblDayMonth1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblDayMonth1.setText("Fecha de la cita");

        ScheduleAppointment_lblDayMonth2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblDayMonth2.setText("Hora");

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbHora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ScheduleAppointment_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ScheduleAppointment_BttnBack.setPreferredSize(new java.awt.Dimension(260, 50));

        ScheduleAppointment_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ScheduleAppointment_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblBttnBack.setText("Regresar");
        ScheduleAppointment_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ScheduleAppointment_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ScheduleAppointment_BttnBackLayout = new javax.swing.GroupLayout(ScheduleAppointment_BttnBack);
        ScheduleAppointment_BttnBack.setLayout(ScheduleAppointment_BttnBackLayout);
        ScheduleAppointment_BttnBackLayout.setHorizontalGroup(
            ScheduleAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScheduleAppointment_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        ScheduleAppointment_BttnBackLayout.setVerticalGroup(
            ScheduleAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScheduleAppointment_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ScheduleAppointment_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ScheduleAppointment_BttnSchedule.setBackground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_BttnSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ScheduleAppointment_lblBttnSchedule.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ScheduleAppointment_lblBttnSchedule.setForeground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblBttnSchedule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblBttnSchedule.setText("Agendar");
        ScheduleAppointment_lblBttnSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ScheduleAppointment_lblBttnSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnScheduleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnScheduleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnScheduleMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ScheduleAppointment_BttnScheduleLayout = new javax.swing.GroupLayout(ScheduleAppointment_BttnSchedule);
        ScheduleAppointment_BttnSchedule.setLayout(ScheduleAppointment_BttnScheduleLayout);
        ScheduleAppointment_BttnScheduleLayout.setHorizontalGroup(
            ScheduleAppointment_BttnScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScheduleAppointment_lblBttnSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        ScheduleAppointment_BttnScheduleLayout.setVerticalGroup(
            ScheduleAppointment_BttnScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScheduleAppointment_BttnScheduleLayout.createSequentialGroup()
                .addComponent(ScheduleAppointment_lblBttnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnBuscarCliente.setBackground(new java.awt.Color(0, 153, 153));
        btnBuscarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Apellidos");

        jDateChooserFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFechaPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout DownLayout = new javax.swing.GroupLayout(Down);
        Down.setLayout(DownLayout);
        DownLayout.setHorizontalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScheduleAppointment_lblSubTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ScheduleAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(ScheduleAppointment_BttnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(DownLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(cmbMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DownLayout.createSequentialGroup()
                                .addComponent(ScheduleAppointment_lblClientDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(DownLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DownLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombresCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnBuscarCliente))
                                .addGap(176, 176, 176))
                            .addGroup(DownLayout.createSequentialGroup()
                                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(DownLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ScheduleAppointment_lblPet, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScheduleAppointment_lblVet, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScheduleAppointment_lblDayMonth2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScheduleAppointment_lblDayMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScheduleAppointment_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ScheduleAppointment_lblClientDocument)
                            .addComponent(ScheduleAppointment_lblVet))
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DownLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(DownLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(ScheduleAppointment_lblDayMonth1)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ScheduleAppointment_lblDayMonth2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScheduleAppointment_lblPet)))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombresCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)))
                .addComponent(cmbMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScheduleAppointment_BttnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        ScheduleAppointmentPanel.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ScheduleAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScheduleAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ScheduleAppointment_lblBttnScheduleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnScheduleMouseExited
        ScheduleAppointment_BttnSchedule.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_ScheduleAppointment_lblBttnScheduleMouseExited

    private void ScheduleAppointment_lblBttnScheduleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnScheduleMouseEntered
        ScheduleAppointment_BttnSchedule.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ScheduleAppointment_lblBttnScheduleMouseEntered

    private void ScheduleAppointment_lblBttnScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnScheduleMouseClicked
        try {
            // validaciones
            if (!validarCampos()) {
                return;
            }
            Cita cita = new Cita();
            CitaDAO citaDAO = new CitaDAO();
            
            cita.setIdClinica(logUser.getId_clinic());
            cita.setIdCliente(Integer.parseInt(txtIdCliente.getText()));

            String itemMascota = (String) cmbMascotas.getSelectedItem();
            cita.setIdMascota(Integer.parseInt(itemMascota.split(" - ")[0]));

            User vet = (User) cmbVeterinarios.getSelectedItem();
            int idVeterinario = vet.getId_user();
            cita.setIdVeterinario(idVeterinario);
            // fecha desde jDateChooser
            java.util.Date utilFecha = jDateChooserFecha.getDate();
            if (utilFecha == null) {
                JOptionPane.showMessageDialog(this, "Seleccione la fecha.");
                return;
            }
            // Hora desde ComboBox HH:mm
            String horaSeleccionada = (String) cmbHora.getSelectedItem();
            if (horaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Seleccione la hora.");
                return;
            }
            // Validar disponibilidad al guardar
            String fechaSQL = new SimpleDateFormat("yyyy-MM-dd").format(utilFecha);
            List<String> ocupadas = citaDAO.veterinarioOcupado(idVeterinario, fechaSQL);
            if (ocupadas.contains(horaSeleccionada)) {
                JOptionPane.showMessageDialog(this, 
                    "El veterinario ya tiene una cita en ese horario.");
                return;
            }
            // Convertir a DATETIME fecha y hora (Timestamp)
            String fechaStr = new java.text.SimpleDateFormat("yyyy-MM-dd").format(utilFecha);
            String fechaHoraStr = fechaStr + " " + horaSeleccionada + ":00";
            java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(fechaHoraStr);
            cita.setFecha(timestamp);

            cita.setEstado("programada");

            // Llamar al DAO
            boolean ok = citaDAO.registrarCita(cita);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Cita programada correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo programar la cita.");
            }

        } catch (Exception ex) {
            System.out.println("Error programando cita: " + ex.getMessage());
        }
    }//GEN-LAST:event_ScheduleAppointment_lblBttnScheduleMouseClicked

    private void ScheduleAppointment_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseExited
        ScheduleAppointment_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseExited

    private void ScheduleAppointment_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseEntered
        ScheduleAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseEntered

    private void ScheduleAppointment_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseClicked
        Appointment_Menu MenuAppointmentFrame = new Appointment_Menu(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseClicked

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        String documento = txtDocumentoCliente.getText().trim();

        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un documento.");
            return;
        }
        ClienteDAO clienteDAO = new ClienteDAO();
        
        ClienteModel cliente = clienteDAO.buscarClientesPorDocumento(documento, logUser.getId_clinic());

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            txtDocumentoCliente.setText("");
            txtIdCliente.setText("");
            txtNombresCliente.setText("");
            txtApellidosCliente.setText("");
            return;
        }
        
        // Cargar datos del cliente
        txtIdCliente.setText(String.valueOf(cliente.getIdCliente()));
        txtNombresCliente.setText(cliente.getNombres());
        txtApellidosCliente.setText(cliente.getApellidos());

        // Cargar mascotas
        cargarMascotas(cliente.getIdCliente());
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void cmbVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVeterinariosActionPerformed
        cargarHorasDisponiblesVeterinario();
    }//GEN-LAST:event_cmbVeterinariosActionPerformed

    private void jDateChooserFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFechaPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            cargarHorasDisponiblesVeterinario();
        }
    }//GEN-LAST:event_jDateChooserFechaPropertyChange

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ScheduleAppointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Down;
    private javax.swing.JPanel ScheduleAppointmentPanel;
    private javax.swing.JPanel ScheduleAppointment_BttnBack;
    private javax.swing.JPanel ScheduleAppointment_BttnSchedule;
    private javax.swing.JLabel ScheduleAppointment_lblBttnBack;
    private javax.swing.JLabel ScheduleAppointment_lblBttnSchedule;
    private javax.swing.JLabel ScheduleAppointment_lblClientDocument;
    private javax.swing.JLabel ScheduleAppointment_lblDayMonth1;
    private javax.swing.JLabel ScheduleAppointment_lblDayMonth2;
    private javax.swing.JLabel ScheduleAppointment_lblPet;
    private javax.swing.JLabel ScheduleAppointment_lblSubTittle;
    private javax.swing.JLabel ScheduleAppointment_lblTittle;
    private javax.swing.JLabel ScheduleAppointment_lblVet;
    private javax.swing.JPanel Up;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbMascotas;
    private javax.swing.JComboBox<User> cmbVeterinarios;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtApellidosCliente;
    private javax.swing.JTextField txtDocumentoCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombresCliente;
    // End of variables declaration//GEN-END:variables
}
