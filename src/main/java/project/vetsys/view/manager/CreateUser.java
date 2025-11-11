package project.vetsys.view.manager;

import java.awt.Color;
import java.util.List;
import project.vetsys.view.security.LogIn;
import javax.swing.JOptionPane;
import project.vetsys.dao.RoleDAO;
import project.vetsys.dao.StatusDAO;
import project.vetsys.model.Role;
import project.vetsys.model.Status;
import project.vetsys.model.User;
import project.vetsys.view.ComboBox;
import project.vetsys.view.manager.MenuManager;

public class CreateUser extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateUser.class.getName());
    private User logUser;

    public CreateUser() {
        initComponents();
        initListeners();
    }
    
    public CreateUser(User logUser) {
        this.logUser = logUser;
        initComponents();
        loadRolesStatus();
        initListeners();
       
    }
    
     private void initListeners() {
        //cboxRoleCreate.addActionListener(e -> loadRolesStatus());
        //cboxStatusCreate.addActionListener(e-> loadRolesStatus());
    }
    
    
    private void loadRolesStatus() {
            RoleDAO roleDAO = new RoleDAO();
            StatusDAO statusDAO = new StatusDAO();

            List<Role> roles = roleDAO.getAllRole(logUser);
            List<Status> status = statusDAO.getAllStatus(logUser);
            //cboxRoleCreate.removeAllItems();

            /// mostrar todos los roles
            Role defaultRole = new Role(0, "Todos", "Mostrar todos los roles");
            ComboBox.fillComboBox(CreateUser_comboBoxRol, roles, defaultRole);
            ComboBox.fillComboBox(CreateUser_comboBoxStatus, status, null);


            ///verificar en consola que usuarios se estan cargando
            System.out.println("Roles cargados en el combo:");
            for (int i = 0; i < CreateUser_comboBoxRol.getItemCount(); i++) {
                Object item = CreateUser_comboBoxRol.getItemAt(i);
                System.out.println("   - " + item + " (" + item.getClass().getSimpleName() + ")");
            }
            System.out.println("Estados cargados en el combo:");
            for (int i = 0; i < CreateUser_comboBoxStatus.getItemCount(); i++) {
            Object item = CreateUser_comboBoxStatus.getItemAt(i);
            System.out.println("   - " + item + " (" + item.getClass().getSimpleName() + ")");
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
        CreateUser_textName = new javax.swing.JTextField();
        CreateUser_LastName = new javax.swing.JLabel();
        CreateUser_textLastName = new javax.swing.JTextField();
        CreateUser_lblPhone = new javax.swing.JLabel();
        CreateUser_textPhone = new javax.swing.JTextField();
        CreateUser_lbl_ID = new javax.swing.JLabel();
        CreateUser_textID = new javax.swing.JTextField();
        CreateUser_lblEmail = new javax.swing.JLabel();
        CreateUser_textEmail = new javax.swing.JTextField();
        CreateUser_lblUsername = new javax.swing.JLabel();
        CreateUser_textUsername = new javax.swing.JTextField();
        CreateUser_lblPassword = new javax.swing.JLabel();
        CreateUser_textPassword = new javax.swing.JPasswordField();
        CreateUser_lblRol = new javax.swing.JLabel();
        CreateUser_comboBoxRol = new javax.swing.JComboBox<>();
        CreateUser_lblStatus = new javax.swing.JLabel();
        CreateUser_comboBoxStatus = new javax.swing.JComboBox<>();
        CreateUser_BttnBack = new javax.swing.JPanel();
        CreateUser_lblBttnBack = new javax.swing.JLabel();
        CreateUser_BttnAdd = new javax.swing.JPanel();
        CreateUser_lblBttnAdd = new javax.swing.JLabel();

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

        CreateUser_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        CreateUser_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreateUser_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        CreateUser_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblSubTittle.setText("Crear Usuario");

        CreateUser_lblName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblName.setText("Nombre");

        CreateUser_textName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreateUser_textName.setForeground(java.awt.Color.gray);
        CreateUser_textName.setText("Ingrese su Nombre");
        CreateUser_textName.setMinimumSize(new java.awt.Dimension(68, 26));
        CreateUser_textName.setPreferredSize(new java.awt.Dimension(68, 26));
        CreateUser_textName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreateUser_textNameMousePressed(evt);
            }
        });
        CreateUser_textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUser_textNameActionPerformed(evt);
            }
        });

        CreateUser_LastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_LastName.setText("Apellidos");

        CreateUser_textLastName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreateUser_textLastName.setForeground(java.awt.Color.gray);
        CreateUser_textLastName.setText("Ingrese su Apellido");
        CreateUser_textLastName.setMinimumSize(new java.awt.Dimension(68, 26));
        CreateUser_textLastName.setPreferredSize(new java.awt.Dimension(68, 26));
        CreateUser_textLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreateUser_textLastNameMousePressed(evt);
            }
        });
        CreateUser_textLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUser_textLastNameActionPerformed(evt);
            }
        });

        CreateUser_lblPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblPhone.setText("Telefono");

        CreateUser_textPhone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreateUser_textPhone.setForeground(java.awt.Color.gray);
        CreateUser_textPhone.setText("Ingrese su Numero de Telefono");
        CreateUser_textPhone.setMinimumSize(new java.awt.Dimension(68, 26));
        CreateUser_textPhone.setPreferredSize(new java.awt.Dimension(68, 26));
        CreateUser_textPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreateUser_textPhoneMousePressed(evt);
            }
        });
        CreateUser_textPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUser_textPhoneActionPerformed(evt);
            }
        });

        CreateUser_lbl_ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lbl_ID.setText("Documento");

        CreateUser_textID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreateUser_textID.setForeground(java.awt.Color.gray);
        CreateUser_textID.setText("Ingrese su Numero de Identificacion");
        CreateUser_textID.setMinimumSize(new java.awt.Dimension(68, 26));
        CreateUser_textID.setPreferredSize(new java.awt.Dimension(68, 26));
        CreateUser_textID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreateUser_textIDMousePressed(evt);
            }
        });
        CreateUser_textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUser_textIDActionPerformed(evt);
            }
        });

        CreateUser_lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblEmail.setText("Correo electronico");

        CreateUser_textEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreateUser_textEmail.setForeground(java.awt.Color.gray);
        CreateUser_textEmail.setText("Ingrese su Direccion de Correo Electronico");
        CreateUser_textEmail.setMinimumSize(new java.awt.Dimension(68, 26));
        CreateUser_textEmail.setPreferredSize(new java.awt.Dimension(68, 26));
        CreateUser_textEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreateUser_textEmailMousePressed(evt);
            }
        });
        CreateUser_textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUser_textEmailActionPerformed(evt);
            }
        });

        CreateUser_lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblUsername.setText("Usuario");

        CreateUser_textUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreateUser_textUsername.setForeground(java.awt.Color.gray);
        CreateUser_textUsername.setText("Nombre de Usuario");
        CreateUser_textUsername.setMinimumSize(new java.awt.Dimension(68, 26));
        CreateUser_textUsername.setPreferredSize(new java.awt.Dimension(68, 26));
        CreateUser_textUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreateUser_textUsernameMousePressed(evt);
            }
        });
        CreateUser_textUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUser_textUsernameActionPerformed(evt);
            }
        });

        CreateUser_lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblPassword.setText("Contraseña");

        CreateUser_textPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreateUser_textPassword.setForeground(java.awt.Color.gray);
        CreateUser_textPassword.setText("**********");
        CreateUser_textPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreateUser_textPasswordMousePressed(evt);
            }
        });

        CreateUser_lblRol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblRol.setText("Rol");

        CreateUser_comboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUser_comboBoxRolActionPerformed(evt);
            }
        });

        CreateUser_lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreateUser_lblStatus.setText("Estado");

        CreateUser_comboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUser_comboBoxStatusActionPerformed(evt);
            }
        });

        CreateUser_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        CreateUser_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CreateUser_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        CreateUser_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        CreateUser_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblBttnBack.setText("Regresar");
        CreateUser_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CreateUser_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateUser_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateUser_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreateUser_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout CreateUser_BttnBackLayout = new javax.swing.GroupLayout(CreateUser_BttnBack);
        CreateUser_BttnBack.setLayout(CreateUser_BttnBackLayout);
        CreateUser_BttnBackLayout.setHorizontalGroup(
            CreateUser_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateUser_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        CreateUser_BttnBackLayout.setVerticalGroup(
            CreateUser_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateUser_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CreateUser_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CreateUser_BttnAdd.setBackground(new java.awt.Color(0, 153, 153));
        CreateUser_BttnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CreateUser_lblBttnAdd.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        CreateUser_lblBttnAdd.setForeground(new java.awt.Color(255, 255, 255));
        CreateUser_lblBttnAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblBttnAdd.setText("Crear");
        CreateUser_lblBttnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CreateUser_lblBttnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateUser_lblBttnAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateUser_lblBttnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreateUser_lblBttnAddMouseExited(evt);
            }
        });

        javax.swing.GroupLayout CreateUser_BttnAddLayout = new javax.swing.GroupLayout(CreateUser_BttnAdd);
        CreateUser_BttnAdd.setLayout(CreateUser_BttnAddLayout);
        CreateUser_BttnAddLayout.setHorizontalGroup(
            CreateUser_BttnAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateUser_lblBttnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        CreateUser_BttnAddLayout.setVerticalGroup(
            CreateUser_BttnAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateUser_BttnAddLayout.createSequentialGroup()
                .addComponent(CreateUser_lblBttnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DownLayout = new javax.swing.GroupLayout(Down);
        Down.setLayout(DownLayout);
        DownLayout.setHorizontalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(CreateUser_textName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CreateUser_textLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CreateUser_textPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CreateUser_textID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CreateUser_textEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateUser_lblPhone)
                            .addComponent(CreateUser_lbl_ID)
                            .addComponent(CreateUser_lblName)
                            .addComponent(CreateUser_LastName)
                            .addComponent(CreateUser_lblEmail))
                        .addGap(565, 565, 565)))
                .addGap(41, 41, 41)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateUser_lblUsername)
                    .addComponent(CreateUser_lblPassword)
                    .addComponent(CreateUser_lblStatus)
                    .addComponent(CreateUser_lblRol)
                    .addComponent(CreateUser_textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateUser_textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateUser_comboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateUser_comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
            .addComponent(CreateUser_lblSubTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DownLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(CreateUser_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(CreateUser_BttnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addComponent(CreateUser_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DownLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(CreateUser_textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DownLayout.createSequentialGroup()
                                .addComponent(CreateUser_lblUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CreateUser_textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CreateUser_lblPassword)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_lblRol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_comboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(CreateUser_lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_LastName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_lblPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_textPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_lbl_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateUser_lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CreateUser_textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateUser_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateUser_BttnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
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

    private void CreateUser_textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUser_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUser_textEmailActionPerformed

    private void CreateUser_textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUser_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUser_textIDActionPerformed

    private void CreateUser_textPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUser_textPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUser_textPhoneActionPerformed

    private void CreateUser_textLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUser_textLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUser_textLastNameActionPerformed

    private void CreateUser_textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUser_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUser_textNameActionPerformed

    private void CreateUser_textUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUser_textUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUser_textUsernameActionPerformed

    private void CreateUser_comboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUser_comboBoxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUser_comboBoxRolActionPerformed

    private void CreateUser_comboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUser_comboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateUser_comboBoxStatusActionPerformed

    private void CreateUser_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_lblBttnBackMouseEntered
        CreateUser_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CreateUser_lblBttnBackMouseEntered

    private void CreateUser_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_lblBttnBackMouseExited
        CreateUser_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_CreateUser_lblBttnBackMouseExited

    private void CreateUser_lblBttnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_lblBttnAddMouseEntered
        CreateUser_BttnAdd.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CreateUser_lblBttnAddMouseEntered

    private void CreateUser_lblBttnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_lblBttnAddMouseExited
        CreateUser_BttnAdd.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_CreateUser_lblBttnAddMouseExited

    private void CreateUser_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_lblBttnBackMouseClicked
        //siempre que se llame al MenuManager, hacerlo con el constructor con parametro de logUser
        UsersMenu MenuManagerFrame = new UsersMenu(logUser);  
        MenuManagerFrame.setVisible(true);
        MenuManagerFrame.pack();
        MenuManagerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_CreateUser_lblBttnBackMouseClicked

    private void CreateUser_lblBttnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_lblBttnAddMouseClicked
        String name_user = CreateUser_textName.getText();
        String last_name = CreateUser_textLastName.getText();
        String phone = CreateUser_textPhone.getText();
        String document = CreateUser_textID.getText();
        String email = CreateUser_textEmail.getText();
        String username = CreateUser_textUsername.getText();
        String password = CreateUser_textPassword.getText();
        
        Role r = (Role) CreateUser_comboBoxRol.getSelectedItem();
        if(r == null){JOptionPane.showMessageDialog(this, "Debe seleccionar un rol");return;}
                     
        Status s = (Status) CreateUser_comboBoxStatus.getSelectedItem();
        if(s == null){JOptionPane.showMessageDialog(this, "Debe seleccionar un estado");return;}
        
        // Validaciones simples
        if (name_user.isEmpty() || last_name.isEmpty() || document.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos obligatorios");
            return;
        }
        
        User user = new User();
        user.setName_user(name_user);
        user.setLast_name(last_name);
        user.setPhone(phone);
        user.setDocument(document);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setId_role(r.getId());   ///se actualizan los roles con el id y el nombre en el combobox
        user.setName_role(r.getName());
        user.setId_status(s.getId());
        user.setName_status(s.getName());
        user.setId_clinic(logUser.getId_clinic());
        
       
        // Llamar al DAO
        project.vetsys.dao.UserDAO userDAO = new project.vetsys.dao.UserDAO();
        boolean success = userDAO.Create(user);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario creado correctamente");
            CreateUser_textUsername.setText("");
            CreateUser_textPassword.setText("");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al crear el usuario. Revisa los datos o la conexión.");
        }
    }//GEN-LAST:event_CreateUser_lblBttnAddMouseClicked

    private void CreateUser_textUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_textUsernameMousePressed
        if (CreateUser_textUsername.getText().equals("Nombre de Usuario")){
            CreateUser_textUsername.setText("");
            CreateUser_textUsername.setForeground(Color.black);
        }
        if (CreateUser_textName.getText().isEmpty()){
            CreateUser_textName.setText("Ingrese su Nombre");
            CreateUser_textName.setForeground(Color.gray);
        }
        if (CreateUser_textLastName.getText().isEmpty()){
            CreateUser_textLastName.setText("Ingrese su Apellido");
            CreateUser_textLastName.setForeground(Color.gray);
        }
        if (CreateUser_textPhone.getText().isEmpty()){
            CreateUser_textPhone.setText("Ingrese su Numero de Telefono");
            CreateUser_textPhone.setForeground(Color.gray);
        }
        if (CreateUser_textID.getText().isEmpty()){
            CreateUser_textID.setText("Ingrese su Numero de Identificacion");
            CreateUser_textID.setForeground(Color.gray);
        }
        if (CreateUser_textEmail.getText().isEmpty()){
            CreateUser_textEmail.setText("Ingrese su Direccion de Correo Electronico");
            CreateUser_textEmail.setForeground(Color.gray);
        }
        if (String.valueOf(CreateUser_textPassword.getPassword()).isEmpty()){
            CreateUser_textPassword.setText("**********");
            CreateUser_textPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_CreateUser_textUsernameMousePressed

    private void CreateUser_textEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_textEmailMousePressed
        if (CreateUser_textEmail.getText().equals("Ingrese su Direccion de Correo Electronico")){
            CreateUser_textEmail.setText("");
            CreateUser_textEmail.setForeground(Color.black);
        }
        if (CreateUser_textName.getText().isEmpty()){
            CreateUser_textName.setText("Ingrese su Nombre");
            CreateUser_textName.setForeground(Color.gray);
        }
        if (CreateUser_textLastName.getText().isEmpty()){
            CreateUser_textLastName.setText("Ingrese su Apellido");
            CreateUser_textLastName.setForeground(Color.gray);
        }
        if (CreateUser_textPhone.getText().isEmpty()){
            CreateUser_textPhone.setText("Ingrese su Numero de Telefono");
            CreateUser_textPhone.setForeground(Color.gray);
        }
        if (CreateUser_textID.getText().isEmpty()){
            CreateUser_textID.setText("Ingrese su Numero de Identificacion");
            CreateUser_textID.setForeground(Color.gray);
        }
        if (CreateUser_textUsername.getText().isEmpty()){
            CreateUser_textUsername.setText("Nombre de Usuario");
            CreateUser_textUsername.setForeground(Color.gray);
        }
        if (String.valueOf(CreateUser_textPassword.getPassword()).isEmpty()){
            CreateUser_textPassword.setText("**********");
            CreateUser_textPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_CreateUser_textEmailMousePressed

    private void CreateUser_textIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_textIDMousePressed
        if (CreateUser_textID.getText().equals("Ingrese su Numero de Identificacion")){
            CreateUser_textID.setText("");
            CreateUser_textID.setForeground(Color.black);
        }
        if (CreateUser_textName.getText().isEmpty()){
            CreateUser_textName.setText("Ingrese su Nombre");
            CreateUser_textName.setForeground(Color.gray);
        }
        if (CreateUser_textLastName.getText().isEmpty()){
            CreateUser_textLastName.setText("Ingrese su Apellido");
            CreateUser_textLastName.setForeground(Color.gray);
        }
        if (CreateUser_textPhone.getText().isEmpty()){
            CreateUser_textPhone.setText("Ingrese su Numero de Telefono");
            CreateUser_textPhone.setForeground(Color.gray);
        }
        if (CreateUser_textEmail.getText().isEmpty()){
            CreateUser_textEmail.setText("Ingrese su Direccion de Correo Electronico");
            CreateUser_textEmail.setForeground(Color.gray);
        }
        if (CreateUser_textUsername.getText().isEmpty()){
            CreateUser_textUsername.setText("Nombre de Usuario");
            CreateUser_textUsername.setForeground(Color.gray);
        }
        if (String.valueOf(CreateUser_textPassword.getPassword()).isEmpty()){
            CreateUser_textPassword.setText("**********");
            CreateUser_textPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_CreateUser_textIDMousePressed

    private void CreateUser_textPhoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_textPhoneMousePressed
        if (CreateUser_textPhone.getText().equals("Ingrese su Numero de Telefono")){
            CreateUser_textPhone.setText("");
            CreateUser_textPhone.setForeground(Color.black);
        }
        if (CreateUser_textName.getText().isEmpty()){
            CreateUser_textName.setText("Ingrese su Nombre");
            CreateUser_textName.setForeground(Color.gray);
        }
        if (CreateUser_textLastName.getText().isEmpty()){
            CreateUser_textLastName.setText("Ingrese su Apellido");
            CreateUser_textLastName.setForeground(Color.gray);
        }
        if (CreateUser_textID.getText().isEmpty()){
            CreateUser_textID.setText("Ingrese su Numero de Identificacion");
            CreateUser_textID.setForeground(Color.gray);
        }
        if (CreateUser_textEmail.getText().isEmpty()){
            CreateUser_textEmail.setText("Ingrese su Direccion de Correo Electronico");
            CreateUser_textEmail.setForeground(Color.gray);
        }
        if (CreateUser_textUsername.getText().isEmpty()){
            CreateUser_textUsername.setText("Nombre de Usuario");
            CreateUser_textUsername.setForeground(Color.gray);
        }
        if (String.valueOf(CreateUser_textPassword.getPassword()).isEmpty()){
            CreateUser_textPassword.setText("**********");
            CreateUser_textPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_CreateUser_textPhoneMousePressed

    private void CreateUser_textLastNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_textLastNameMousePressed
        if (CreateUser_textLastName.getText().equals("Ingrese su Apellido")){
            CreateUser_textLastName.setText("");
            CreateUser_textLastName.setForeground(Color.black);
        }
        if (CreateUser_textName.getText().isEmpty()){
            CreateUser_textName.setText("Ingrese su Nombre");
            CreateUser_textName.setForeground(Color.gray);
        }
        if (CreateUser_textPhone.getText().isEmpty()){
            CreateUser_textPhone.setText("Ingrese su Numero de Telefono");
            CreateUser_textPhone.setForeground(Color.gray);
        }
        if (CreateUser_textID.getText().isEmpty()){
            CreateUser_textID.setText("Ingrese su Numero de Identificacion");
            CreateUser_textID.setForeground(Color.gray);
        }
        if (CreateUser_textEmail.getText().isEmpty()){
            CreateUser_textEmail.setText("Ingrese su Direccion de Correo Electronico");
            CreateUser_textEmail.setForeground(Color.gray);
        }
        if (CreateUser_textUsername.getText().isEmpty()){
            CreateUser_textUsername.setText("Nombre de Usuario");
            CreateUser_textUsername.setForeground(Color.gray);
        }
        if (String.valueOf(CreateUser_textPassword.getPassword()).isEmpty()){
            CreateUser_textPassword.setText("**********");
            CreateUser_textPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_CreateUser_textLastNameMousePressed

    private void CreateUser_textNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_textNameMousePressed
        if (CreateUser_textName.getText().equals("Ingrese su Nombre")){
            CreateUser_textName.setText("");
            CreateUser_textName.setForeground(Color.black);
        }
        if (CreateUser_textLastName.getText().isEmpty()){
            CreateUser_textLastName.setText("Ingrese su Apellido");
            CreateUser_textLastName.setForeground(Color.gray);
        }
        if (CreateUser_textPhone.getText().isEmpty()){
            CreateUser_textPhone.setText("Ingrese su Numero de Telefono");
            CreateUser_textPhone.setForeground(Color.gray);
        }
        if (CreateUser_textID.getText().isEmpty()){
            CreateUser_textID.setText("Ingrese su Numero de Identificacion");
            CreateUser_textID.setForeground(Color.gray);
        }
        if (CreateUser_textEmail.getText().isEmpty()){
            CreateUser_textEmail.setText("Ingrese su Direccion de Correo Electronico");
            CreateUser_textEmail.setForeground(Color.gray);
        }
        if (CreateUser_textUsername.getText().isEmpty()){
            CreateUser_textUsername.setText("Nombre de Usuario");
            CreateUser_textUsername.setForeground(Color.gray);
        }
        if (String.valueOf(CreateUser_textPassword.getPassword()).isEmpty()){
            CreateUser_textPassword.setText("**********");
            CreateUser_textPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_CreateUser_textNameMousePressed

    private void CreateUser_textPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateUser_textPasswordMousePressed
        if (String.valueOf(CreateUser_textPassword.getPassword()).equals("**********")){
            CreateUser_textPassword.setText("");
            CreateUser_textPassword.setForeground(Color.black);
        }
        if (CreateUser_textName.getText().isEmpty()){
            CreateUser_textName.setText("Ingrese su Nombre");
            CreateUser_textName.setForeground(Color.gray);
        }
        if (CreateUser_textLastName.getText().isEmpty()){
            CreateUser_textLastName.setText("Ingrese su Apellido");
            CreateUser_textLastName.setForeground(Color.gray);
        }
        if (CreateUser_textPhone.getText().isEmpty()){
            CreateUser_textPhone.setText("Ingrese su Numero de Telefono");
            CreateUser_textPhone.setForeground(Color.gray);
        }
        if (CreateUser_textID.getText().isEmpty()){
            CreateUser_textID.setText("Ingrese su Numero de Identificacion");
            CreateUser_textID.setForeground(Color.gray);
        }
        if (CreateUser_textEmail.getText().isEmpty()){
            CreateUser_textEmail.setText("Ingrese su Direccion de Correo Electronico");
            CreateUser_textEmail.setForeground(Color.gray);
        }
        if (CreateUser_textUsername.getText().isEmpty()){
            CreateUser_textUsername.setText("Nombre de Usuario");
            CreateUser_textUsername.setForeground(Color.gray);
        }
    }//GEN-LAST:event_CreateUser_textPasswordMousePressed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CreateUser().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreateUserPanel;
    private javax.swing.JPanel CreateUser_BttnAdd;
    private javax.swing.JPanel CreateUser_BttnBack;
    private javax.swing.JLabel CreateUser_LastName;
    private javax.swing.JComboBox<Role> CreateUser_comboBoxRol;
    private javax.swing.JComboBox<Status> CreateUser_comboBoxStatus;
    private javax.swing.JLabel CreateUser_lblBttnAdd;
    private javax.swing.JLabel CreateUser_lblBttnBack;
    private javax.swing.JLabel CreateUser_lblEmail;
    private javax.swing.JLabel CreateUser_lblName;
    private javax.swing.JLabel CreateUser_lblPassword;
    private javax.swing.JLabel CreateUser_lblPhone;
    private javax.swing.JLabel CreateUser_lblRol;
    private javax.swing.JLabel CreateUser_lblStatus;
    private javax.swing.JLabel CreateUser_lblSubTittle;
    private javax.swing.JLabel CreateUser_lblTittle;
    private javax.swing.JLabel CreateUser_lblUsername;
    private javax.swing.JLabel CreateUser_lbl_ID;
    private javax.swing.JTextField CreateUser_textEmail;
    private javax.swing.JTextField CreateUser_textID;
    private javax.swing.JTextField CreateUser_textLastName;
    private javax.swing.JTextField CreateUser_textName;
    private javax.swing.JPasswordField CreateUser_textPassword;
    private javax.swing.JTextField CreateUser_textPhone;
    private javax.swing.JTextField CreateUser_textUsername;
    private javax.swing.JPanel Down;
    private javax.swing.JPanel Up;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}
