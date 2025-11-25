package project.vetsys.view.manager;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import project.vetsys.model.User;
import project.vetsys.dao.ClienteDAO;
import project.vetsys.database.DBConnection;
import project.vetsys.model.ClienteModel;
import project.vetsys.view.Nimbus;


public class CreateClient extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateClient.class.getName());
    private User logUser;
    private final ClienteDAO clienteDAO = new ClienteDAO();
    
    /**
     * Creates new form SearchUser
     * @param logUser
     */
    
    public CreateClient() {
        initComponents();
    }
    
    public CreateClient(User logUser) {
        this.logUser = logUser;
        Nimbus.LookandFeel();
        initComponents();
        cargarMembresias();
        CreateUser_lblTittle.setText(logUser.getClinic().getName_clinic());
        Nimbus.styleAllLabelsExcept(this,CreateUser_lblTittle);
        Nimbus.styleAllTextFields(this);
        Nimbus.styleTitleLabel(CreateUser_lblSubTittle);
        setTitle("Gestión de Clientes");
    }
    
    private void limpiarCampos() {
        txtNombreCliente.setText("");
        txtApellidos.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        jDateChooserFechaInicio.setDate(null);
        jDateChooserFechaFin.setDate(null);
        jComboBoxMembresia.setSelectedIndex(0);
        txtDescripcionMembresia.setText("");
        txtPrecioMembresia.setText("");
    }
    
    private void cargarMembresias() {
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT id_membresia, nombre FROM membresia WHERE id_clinica = ?")) {

            stmt.setInt(1, logUser.getId_clinic());
            ResultSet rs = stmt.executeQuery();

            jComboBoxMembresia.removeAllItems();
            jComboBoxMembresia.addItem("Ninguna");
            while (rs.next()) {
                int id = rs.getInt("id_membresia");
                String nombre = rs.getString("nombre");
                jComboBoxMembresia.addItem(id + " - " + nombre);
            }
            jComboBoxMembresia.setSelectedIndex(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error cargando membresías: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarDetallesMembresia(int idMembresia) {

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT descripcion, precio FROM membresia WHERE id_membresia = ? AND id_clinica = ?")) {
            stmt.setInt(1, idMembresia);
            stmt.setInt(2, logUser.getId_clinic());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                txtDescripcionMembresia.setText(rs.getString("descripcion"));
                txtPrecioMembresia.setText("$" + rs.getDouble("precio"));
                txtDescripcionMembresia.setEditable(false);
                txtPrecioMembresia.setEditable(false);
            } else {
                txtDescripcionMembresia.setText("");
                txtPrecioMembresia.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo datos de membresía: " + e.getMessage());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        CreateUserPanel = new javax.swing.JPanel();
        Up = new javax.swing.JPanel();
        CreateUser_lblTittle = new javax.swing.JLabel();
        Down = new javax.swing.JPanel();
        CreateUser_lblSubTittle = new javax.swing.JLabel();
        CreateUser_lblName = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        CreateUser_LastName = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        CreateUser_lblPhone = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        CreateUser_lbl_ID = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        CreateUser_lblEmail = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        CreateUser_lblMembresia = new javax.swing.JLabel();
        CreateUser_lblFechaIni = new javax.swing.JLabel();
        CreateUser_lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        CreateUser_lblFechaFin = new javax.swing.JLabel();
        jComboBoxMembresia = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        txtDescripcionMembresia = new javax.swing.JTextField();
        txtPrecioMembresia = new javax.swing.JTextField();
        CreateUser_lblMembresia1 = new javax.swing.JLabel();
        CreateUser_lblMembresia2 = new javax.swing.JLabel();
        jDateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserFechaFin = new com.toedter.calendar.JDateChooser();
        btnSalir = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CreateUserPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        CreateUserPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        CreateUserPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        CreateUserPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Up.setBackground(new java.awt.Color(0, 153, 153));
        Up.setMaximumSize(new java.awt.Dimension(1000, 100));
        Up.setMinimumSize(new java.awt.Dimension(1000, 100));
        Up.setPreferredSize(new java.awt.Dimension(1000, 100));

        CreateUser_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreateUser_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        CreateUser_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblTittle.setText("VetSys");

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateUser_lblTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addComponent(CreateUser_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CreateUserPanel.add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        Down.setBackground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(1000, 700));
        Down.setMinimumSize(new java.awt.Dimension(1000, 700));
        Down.setPreferredSize(new java.awt.Dimension(1000, 700));

        CreateUser_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreateUser_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        CreateUser_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblSubTittle.setText("Registro de Cliente");

        CreateUser_lblName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblName.setText("Nombres");

        txtNombreCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreCliente.setForeground(java.awt.Color.gray);
        txtNombreCliente.setMinimumSize(new java.awt.Dimension(68, 26));
        txtNombreCliente.setPreferredSize(new java.awt.Dimension(68, 26));
        txtNombreCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreClienteMousePressed(evt);
            }
        });
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });

        CreateUser_LastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_LastName.setText("Apellidos");

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtApellidos.setForeground(java.awt.Color.gray);
        txtApellidos.setMinimumSize(new java.awt.Dimension(68, 26));
        txtApellidos.setPreferredSize(new java.awt.Dimension(68, 26));
        txtApellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidosMousePressed(evt);
            }
        });
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        CreateUser_lblPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblPhone.setText("Telefono");

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTelefono.setForeground(java.awt.Color.gray);
        txtTelefono.setMinimumSize(new java.awt.Dimension(68, 26));
        txtTelefono.setPreferredSize(new java.awt.Dimension(68, 26));
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        CreateUser_lbl_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lbl_ID.setText("Documento");

        txtDocumento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDocumento.setForeground(java.awt.Color.gray);
        txtDocumento.setMinimumSize(new java.awt.Dimension(68, 26));
        txtDocumento.setPreferredSize(new java.awt.Dimension(68, 26));
        txtDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDocumentoMousePressed(evt);
            }
        });
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        CreateUser_lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblEmail.setText("Correo electronico");

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCorreo.setForeground(java.awt.Color.gray);
        txtCorreo.setMinimumSize(new java.awt.Dimension(68, 26));
        txtCorreo.setPreferredSize(new java.awt.Dimension(68, 26));
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoMousePressed(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        CreateUser_lblMembresia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblMembresia.setText("Membresía");

        CreateUser_lblFechaIni.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblFechaIni.setText("Fecha de inicio");

        CreateUser_lblDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblDireccion.setText("Dirección");

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDireccion.setForeground(java.awt.Color.gray);
        txtDireccion.setMinimumSize(new java.awt.Dimension(68, 26));
        txtDireccion.setPreferredSize(new java.awt.Dimension(68, 26));
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDireccionMousePressed(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        CreateUser_lblFechaFin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblFechaFin.setText("Fecha de vigencia");

        jComboBoxMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMembresiaActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 159, 159));
        btnRegistrar.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtPrecioMembresia.setToolTipText("");

        CreateUser_lblMembresia1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblMembresia1.setText("Precio");

        CreateUser_lblMembresia2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblMembresia2.setText("Descripción");

        btnSalir.setBackground(new java.awt.Color(0, 159, 159));
        btnSalir.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DownLayout = new javax.swing.GroupLayout(Down);
        Down.setLayout(DownLayout);
        DownLayout.setHorizontalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateUser_lblSubTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DownLayout.createSequentialGroup()
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CreateUser_lblName)
                                .addComponent(CreateUser_LastName)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                                    .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(DownLayout.createSequentialGroup()
                                            .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(CreateUser_lbl_ID)
                                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                            .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(CreateUser_lblPhone)))
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(60, 60, 60)))
                            .addComponent(CreateUser_lblEmail)
                            .addComponent(CreateUser_lblDireccion))
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DownLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CreateUser_lblMembresia2)
                                    .addComponent(CreateUser_lblMembresia)
                                    .addComponent(txtDescripcionMembresia)
                                    .addComponent(jComboBoxMembresia, 0, 391, Short.MAX_VALUE)))
                            .addGroup(DownLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CreateUser_lblMembresia1)
                                    .addComponent(CreateUser_lblFechaFin)
                                    .addComponent(CreateUser_lblFechaIni)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecioMembresia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CreateUser_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateUser_lblName)
                    .addComponent(CreateUser_lblMembresia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateUser_LastName)
                    .addComponent(CreateUser_lblMembresia2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(txtDescripcionMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateUser_lbl_ID)
                    .addComponent(CreateUser_lblPhone)
                    .addComponent(CreateUser_lblMembresia1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateUser_lblEmail)
                    .addComponent(CreateUser_lblFechaIni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateUser_lblDireccion)
                    .addComponent(CreateUser_lblFechaFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        CreateUser_lblName.getAccessibleContext().setAccessibleDescription("lblName");

        CreateUserPanel.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreateUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreateUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        try {
            // Validar campos vacíos
            if (txtNombreCliente.getText().trim().isEmpty() ||
                txtApellidos.getText().trim().isEmpty() ||
                txtDocumento.getText().trim().isEmpty() ||
                txtTelefono.getText().trim().isEmpty() ||
                txtCorreo.getText().trim().isEmpty() ||
                txtDireccion.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                    "Por favor complete todos los campos.",
                    "Campos vacíos",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Obtener id de la membresía seleccionada
            String itemSeleccionado = (String) jComboBoxMembresia.getSelectedItem();
            Integer idMembresia = null;

            if (itemSeleccionado != null && itemSeleccionado.contains(" - ")) {
                int idSeleccionado = Integer.parseInt(itemSeleccionado.split(" - ")[0]);
                if (idSeleccionado != 0) { // Si no es null
                    idMembresia = idSeleccionado;
                }
            }
            // Crear objeto cliente
            ClienteModel cliente = new ClienteModel();
            cliente.setIdClinica(logUser.getId_clinic()); // desde el usuario logueado
            cliente.setNombres(txtNombreCliente.getText());
            cliente.setApellidos(txtApellidos.getText());
            cliente.setDocumento(txtDocumento.getText());
            cliente.setTelefono(txtTelefono.getText());
            cliente.setCorreo(txtCorreo.getText());
            cliente.setDireccion(txtDireccion.getText());
            cliente.setIdMembresia(idMembresia); // puede ser null

            // si membresia fue seleccionada
            if (idMembresia != null) {

                Date fechaInicio = jDateChooserFechaInicio.getDate();
                Date fechaFin = jDateChooserFechaFin.getDate();
                if (fechaInicio == null || fechaFin == null) {
                    JOptionPane.showMessageDialog(this,
                        "Debe seleccionar fecha de inicio y fin de la membresía.",
                        "Fechas requeridas",
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String fechaInicioStr = new SimpleDateFormat("yyyy-MM-dd").format(fechaInicio);
                String fechaFinStr = new SimpleDateFormat("yyyy-MM-dd").format(fechaFin);

                cliente.setFechaInicio(fechaInicioStr);
                cliente.setFechaVigencia(fechaFinStr);
                cliente.setEstadoMembresia(1);

            } else {
                cliente.setFechaInicio(null);
                cliente.setFechaVigencia(null);
                cliente.setEstadoMembresia(0);
            }

            // Insertar cliente DAO a la BD
            ClienteDAO clienteDAO = new ClienteDAO();
            boolean registrado = clienteDAO.insertarCliente(cliente);

            if (registrado) {
                JOptionPane.showMessageDialog(this,
                    "Cliente registrado correctamente",
                    "Exito",
                    JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this,
                    "No se pudo registrar el cliente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error al registrar el cliente: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jComboBoxMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMembresiaActionPerformed
        String itemSeleccionado = (String) jComboBoxMembresia.getSelectedItem();
        if (itemSeleccionado == null) return;
            if (itemSeleccionado.equals("Ninguna")) {
                txtDescripcionMembresia.setText("");
                txtPrecioMembresia.setText("");
                jDateChooserFechaInicio.setDate(null);
                jDateChooserFechaFin.setDate(null);
                return;
            }
            if (itemSeleccionado.contains(" - ")) {
                int idMembresia = Integer.parseInt(itemSeleccionado.split(" - ")[0]);
                mostrarDetallesMembresia(idMembresia);
            }
    }//GEN-LAST:event_jComboBoxMembresiaActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionMousePressed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMousePressed

    }//GEN-LAST:event_txtCorreoMousePressed

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtDocumentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDocumentoMousePressed

    }//GEN-LAST:event_txtDocumentoMousePressed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed

    }//GEN-LAST:event_txtTelefonoMousePressed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtApellidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosMousePressed

    }//GEN-LAST:event_txtApellidosMousePressed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtNombreClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreClienteMousePressed

    }//GEN-LAST:event_txtNombreClienteMousePressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        PatientsMenu MenuManagerFrame = new PatientsMenu(logUser);  
        MenuManagerFrame.setVisible(true);
        MenuManagerFrame.pack();
        MenuManagerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
        
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CreateClient().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreateUserPanel;
    private javax.swing.JLabel CreateUser_LastName;
    private javax.swing.JLabel CreateUser_lblDireccion;
    private javax.swing.JLabel CreateUser_lblEmail;
    private javax.swing.JLabel CreateUser_lblFechaFin;
    private javax.swing.JLabel CreateUser_lblFechaIni;
    private javax.swing.JLabel CreateUser_lblMembresia;
    private javax.swing.JLabel CreateUser_lblMembresia1;
    private javax.swing.JLabel CreateUser_lblMembresia2;
    private javax.swing.JLabel CreateUser_lblName;
    private javax.swing.JLabel CreateUser_lblPhone;
    private javax.swing.JLabel CreateUser_lblSubTittle;
    private javax.swing.JLabel CreateUser_lblTittle;
    private javax.swing.JLabel CreateUser_lbl_ID;
    private javax.swing.JPanel Down;
    private javax.swing.JPanel Up;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxMembresia;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFin;
    private com.toedter.calendar.JDateChooser jDateChooserFechaInicio;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcionMembresia;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPrecioMembresia;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
