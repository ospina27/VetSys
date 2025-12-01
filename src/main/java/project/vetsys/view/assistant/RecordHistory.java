package project.vetsys.view.assistant;

import java.awt.Color;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import project.vetsys.dao.HistoriaClinicaDAO;
import project.vetsys.model.HistoriaClinica;
import project.vetsys.model.User;
import project.vetsys.utils.ValidationInput;
import project.vetsys.view.manager.Appointment_Menu;


public class RecordHistory extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RecordHistory.class.getName());
    private User logUser;
    private HistoriaClinicaDAO historialDAO = new HistoriaClinicaDAO();

    private int idClinica;
    private int idCita;
    private int idMascota;
    private int idCliente;
    private int idVeterinario;
    private String clienteNombre;
    private String clienteDocumento;
    private String mascotaNombre;
    private String especie;
    private String raza;
    private String sexo;
    private String fechaNacimiento;


    
    public RecordHistory() {
        initComponents();
    }
    
    public RecordHistory(int idClinica, int idCita, int idMascota, int idCliente, String clienteNombre, String clienteDocumento, 
                        String mascotaNombre, String especie, String raza, String sexo, String fechaNacimiento, User logUser) {

        this.idClinica = idClinica;
        this.idCita = idCita;
        this.idMascota = idMascota;
        this.idCliente = idCliente;
        this.idVeterinario = logUser.getId_user();
        this.clienteNombre = clienteNombre;
        this.clienteDocumento = clienteDocumento;
        this.mascotaNombre = mascotaNombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.logUser = logUser;
        initComponents();
        cargarDatos();
        
        // Validaciones en entrada de campos de textos
        ValidationInput.numbers(txtPeso, 3);
    }
    
    private void cargarDatos() {

        txtNombreCliente.setText(clienteNombre);
        txtDocumentoCliente.setText(clienteDocumento);
        txtMascota.setText(mascotaNombre);
        txtEspecie.setText(especie);
        txtRaza.setText(raza);
        txtSexo.setText(sexo);
        txtFechaNacimiento.setText(fechaNacimiento);
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
        ScheduleAppointment_lblPet = new javax.swing.JLabel();
        ScheduleAppointment_BttnBack = new javax.swing.JPanel();
        ScheduleAppointment_lblBttnBack = new javax.swing.JLabel();
        ScheduleAppointment_BttnSchedule = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtMascota = new javax.swing.JTextField();
        ScheduleAppointment_lblPet1 = new javax.swing.JLabel();
        ScheduleAppointment_lblPet2 = new javax.swing.JLabel();
        ScheduleAppointment_lblPet3 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JTextField();
        txtEspecie = new javax.swing.JTextField();
        txtRaza = new javax.swing.JTextField();
        ScheduleAppointment_lblPet4 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        ScheduleAppointment_lblVet1 = new javax.swing.JLabel();
        ScheduleAppointment_lblClientDocument1 = new javax.swing.JLabel();
        txtDocumentoCliente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextMotivo = new javax.swing.JTextPane();
        ScheduleAppointment_lblVet2 = new javax.swing.JLabel();
        ScheduleAppointment_lblVet3 = new javax.swing.JLabel();
        txtDiagnostico = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextTratamiento = new javax.swing.JTextPane();
        ScheduleAppointment_lblVet4 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

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

        ScheduleAppointment_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 34)); // NOI18N
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
                .addComponent(ScheduleAppointment_lblTittle)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        ScheduleAppointmentPanel.add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        Down.setBackground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(1000, 700));
        Down.setMinimumSize(new java.awt.Dimension(1000, 700));

        ScheduleAppointment_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ScheduleAppointment_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblSubTittle.setText("Historia Clínica");

        ScheduleAppointment_lblClientDocument.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ScheduleAppointment_lblClientDocument.setText("Cliente");

        ScheduleAppointment_lblPet.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ScheduleAppointment_lblPet.setText("Mascota");

        ScheduleAppointment_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ScheduleAppointment_BttnBack.setPreferredSize(new java.awt.Dimension(260, 50));

        ScheduleAppointment_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
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
            .addComponent(ScheduleAppointment_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        ScheduleAppointment_BttnBackLayout.setVerticalGroup(
            ScheduleAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScheduleAppointment_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ScheduleAppointment_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ScheduleAppointment_BttnSchedule.setBackground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_BttnSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnGuardar.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ScheduleAppointment_BttnScheduleLayout = new javax.swing.GroupLayout(ScheduleAppointment_BttnSchedule);
        ScheduleAppointment_BttnSchedule.setLayout(ScheduleAppointment_BttnScheduleLayout);
        ScheduleAppointment_BttnScheduleLayout.setHorizontalGroup(
            ScheduleAppointment_BttnScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScheduleAppointment_BttnScheduleLayout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ScheduleAppointment_BttnScheduleLayout.setVerticalGroup(
            ScheduleAppointment_BttnScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScheduleAppointment_BttnScheduleLayout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreCliente.setBorder(null);
        txtNombreCliente.setFocusable(false);

        txtMascota.setEditable(false);
        txtMascota.setBackground(new java.awt.Color(255, 255, 255));
        txtMascota.setBorder(null);
        txtMascota.setFocusable(false);

        ScheduleAppointment_lblPet1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ScheduleAppointment_lblPet1.setText("Sexo");

        ScheduleAppointment_lblPet2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ScheduleAppointment_lblPet2.setText("Especie");

        ScheduleAppointment_lblPet3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ScheduleAppointment_lblPet3.setText("Raza");

        txtSexo.setEditable(false);
        txtSexo.setBackground(new java.awt.Color(255, 255, 255));
        txtSexo.setBorder(null);
        txtSexo.setFocusable(false);

        txtEspecie.setEditable(false);
        txtEspecie.setBackground(new java.awt.Color(255, 255, 255));
        txtEspecie.setBorder(null);
        txtEspecie.setFocusable(false);

        txtRaza.setEditable(false);
        txtRaza.setBackground(new java.awt.Color(255, 255, 255));
        txtRaza.setBorder(null);
        txtRaza.setFocusable(false);

        ScheduleAppointment_lblPet4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ScheduleAppointment_lblPet4.setText("Fecha de nacimiento");

        txtFechaNacimiento.setEditable(false);
        txtFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaNacimiento.setBorder(null);
        txtFechaNacimiento.setFocusable(false);

        ScheduleAppointment_lblVet1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ScheduleAppointment_lblVet1.setText("Motivo de consulta");

        ScheduleAppointment_lblClientDocument1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ScheduleAppointment_lblClientDocument1.setText("Documento");

        txtDocumentoCliente.setEditable(false);
        txtDocumentoCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtDocumentoCliente.setBorder(null);
        txtDocumentoCliente.setFocusable(false);

        jScrollPane1.setViewportView(jTextMotivo);

        ScheduleAppointment_lblVet2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ScheduleAppointment_lblVet2.setText("Diagnóstico");
        ScheduleAppointment_lblVet2.setToolTipText("");

        ScheduleAppointment_lblVet3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ScheduleAppointment_lblVet3.setText("Tratamiento");

        jScrollPane2.setViewportView(jTextTratamiento);

        ScheduleAppointment_lblVet4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ScheduleAppointment_lblVet4.setText("Peso (kg)");

        javax.swing.GroupLayout DownLayout = new javax.swing.GroupLayout(Down);
        Down.setLayout(DownLayout);
        DownLayout.setHorizontalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScheduleAppointment_lblSubTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ScheduleAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(ScheduleAppointment_BttnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
            .addGroup(DownLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblPet4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblPet2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ScheduleAppointment_lblPet3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRaza))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblPet, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblPet1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(149, 149, 149)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblClientDocument1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumentoCliente))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblClientDocument)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(DownLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ScheduleAppointment_lblVet4)
                            .addComponent(ScheduleAppointment_lblVet1)
                            .addComponent(ScheduleAppointment_lblVet2)
                            .addComponent(ScheduleAppointment_lblVet3))
                        .addGap(32, 32, 32)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ScheduleAppointment_lblSubTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleAppointment_lblPet)
                    .addComponent(txtMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleAppointment_lblClientDocument)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleAppointment_lblPet1)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleAppointment_lblClientDocument1)
                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleAppointment_lblPet2)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleAppointment_lblPet3)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleAppointment_lblPet4)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleAppointment_lblVet4)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScheduleAppointment_lblVet1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleAppointment_lblVet2))
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScheduleAppointment_lblVet3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScheduleAppointment_BttnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        ScheduleAppointmentPanel.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 750));

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

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        ScheduleAppointment_BttnSchedule.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        ScheduleAppointment_BttnSchedule.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        try {
            HistoriaClinica hc = new HistoriaClinica();

            hc.setIdClinica(idClinica);
            hc.setIdMascota(idMascota);
            hc.setIdVeterinario(idVeterinario);
            hc.setIdCita(idCita);
            hc.setMotivoConsulta(jTextMotivo.getText());
            hc.setDiagnostico(txtDiagnostico.getText());
            hc.setTratamiento(jTextTratamiento.getText());
            hc.setPeso(new BigDecimal(txtPeso.getText()));

            boolean ok = historialDAO.registrarAtencion(hc);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Historia clínica guardada correctamente.");
                AttendAppointment ventana = new AttendAppointment(logUser);
                ventana.setVisible(true);
                ventana.pack();
                ventana.setLocationRelativeTo(null);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar historia clínica.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos o incompletos.");
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void ScheduleAppointment_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseExited
        ScheduleAppointment_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseExited

    private void ScheduleAppointment_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseEntered
        ScheduleAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseEntered

    private void ScheduleAppointment_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseClicked
        AttendAppointment AttendAppointmentFrame = new AttendAppointment(logUser);
        AttendAppointmentFrame.setVisible(true);
        AttendAppointmentFrame.pack();
        AttendAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new RecordHistory().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Down;
    private javax.swing.JPanel ScheduleAppointmentPanel;
    private javax.swing.JPanel ScheduleAppointment_BttnBack;
    private javax.swing.JPanel ScheduleAppointment_BttnSchedule;
    private javax.swing.JLabel ScheduleAppointment_lblBttnBack;
    private javax.swing.JLabel ScheduleAppointment_lblClientDocument;
    private javax.swing.JLabel ScheduleAppointment_lblClientDocument1;
    private javax.swing.JLabel ScheduleAppointment_lblPet;
    private javax.swing.JLabel ScheduleAppointment_lblPet1;
    private javax.swing.JLabel ScheduleAppointment_lblPet2;
    private javax.swing.JLabel ScheduleAppointment_lblPet3;
    private javax.swing.JLabel ScheduleAppointment_lblPet4;
    private javax.swing.JLabel ScheduleAppointment_lblSubTittle;
    private javax.swing.JLabel ScheduleAppointment_lblTittle;
    private javax.swing.JLabel ScheduleAppointment_lblVet1;
    private javax.swing.JLabel ScheduleAppointment_lblVet2;
    private javax.swing.JLabel ScheduleAppointment_lblVet3;
    private javax.swing.JLabel ScheduleAppointment_lblVet4;
    private javax.swing.JPanel Up;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane jTextMotivo;
    private javax.swing.JTextPane jTextTratamiento;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtDocumentoCliente;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtMascota;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRaza;
    private javax.swing.JTextField txtSexo;
    // End of variables declaration//GEN-END:variables
}
