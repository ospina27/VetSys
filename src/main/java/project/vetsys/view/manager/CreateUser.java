package project.vetsys.view.manager;

import java.awt.Color;
import java.util.List;
import project.vetsys.view.security.LogIn;
import javax.swing.JOptionPane;
import project.vetsys.dao.RoleDAO;
import project.vetsys.dao.StatusDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.Role;
import project.vetsys.model.Status;
import project.vetsys.model.User;
import project.vetsys.utils.ValidationInput;
import project.vetsys.view.Nimbus;
import project.vetsys.utils.Utils;
import project.vetsys.view.manager.MenuManager;

public class CreateUser extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateUser.class.getName());
    private User logUser;
    private Utils utils;

    public CreateUser() {
        initComponents();
        aplicarAccesibilidad();
    }
    
    public CreateUser(User logUser) {
        Nimbus.LookandFeel();
        this.logUser = logUser;  
        this.utils = new Utils();
        initComponents();
        aplicarAccesibilidad();
        Nimbus.styleAllTextFields(this);
        setTitle("Gestión de Usuarios");
        CreateUser_lblTittle.setText(logUser.getClinic().getName_clinic());
        Nimbus.styleAllLabelsExcept(this,CreateUser_lblTittle);
        Nimbus.styleTitleLabel(CreateUser_lblSubTittle);
        loadRolesStatus();
        
        // Validaciones en entrada de campos de textos
        ValidationInput.text(nameUser_field, 30);
        ValidationInput.text(lastNameUser_field, 35);
        ValidationInput.numbers(phoneUser_field, 10);
        ValidationInput.numbers(documentUser_field, 11);
        ValidationInput.regex(emailUser_field, ValidationInput.EMAIL, 60);
        ValidationInput.maxLength(usernameUser_field, 20);
        ValidationInput.maxLength(passwordUser_psfield, 20);
    }
      
    private void emptyFields(){
         nameUser_field.setText("");
         lastNameUser_field.setText("");
         phoneUser_field.setText("");
         documentUser_field.setText("");
         emailUser_field.setText("");
         usernameUser_field.setText("");
         passwordUser_psfield.setText("");
         cboxRoleUser.setSelectedIndex(-1);
         cboxStatusUser.setSelectedIndex(-1);
     }
    
    
    ///cargar los combobox
    private void loadRolesStatus() {
            RoleDAO roleDAO = new RoleDAO();
            StatusDAO statusDAO = new StatusDAO();

            List<Role> roles = roleDAO.getAllRole(logUser);
            List<Status> status = statusDAO.getAllStatus(logUser);

            /// mostrar todos los roles
            Role defaultRole = new Role(0,"Todos");
            Status defaulStatus = new Status(0,"");
            utils.fillComboBox(cboxRoleUser, roles, defaultRole);
            utils.fillComboBox(cboxStatusUser, status, defaulStatus);
            cboxRoleUser.setSelectedIndex(-1);

            ///verificar en consola que usuarios se estan cargando
            System.out.println("Roles cargados en el combo:");
            for (int i = 0; i < cboxRoleUser.getItemCount(); i++) {
                Object item = cboxRoleUser.getItemAt(i);
                System.out.println("   - " + item + " (" + item.getClass().getSimpleName() + ")");
            }
            System.out.println("Estados cargados en el combo:");
            for (int i = 0; i < cboxStatusUser.getItemCount(); i++) {
            Object item = cboxStatusUser.getItemAt(i);
            System.out.println("   - " + item + " (" + item.getClass().getSimpleName() + ")");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CreateUserPanel = new javax.swing.JPanel();
        Up = new javax.swing.JPanel();
        CreateUser_lblTittle = new javax.swing.JLabel();
        Down = new javax.swing.JPanel();
        CreateUser_lblSubTittle = new javax.swing.JLabel();
        CreateUser_lblName = new javax.swing.JLabel();
        nameUser_field = new javax.swing.JTextField();
        CreateUser_LastName = new javax.swing.JLabel();
        lastNameUser_field = new javax.swing.JTextField();
        CreateUser_lblPhone = new javax.swing.JLabel();
        phoneUser_field = new javax.swing.JTextField();
        CreateUser_lbl_ID = new javax.swing.JLabel();
        documentUser_field = new javax.swing.JTextField();
        CreateUser_lblEmail = new javax.swing.JLabel();
        emailUser_field = new javax.swing.JTextField();
        CreateUser_lblUsername = new javax.swing.JLabel();
        usernameUser_field = new javax.swing.JTextField();
        CreateUser_lblPassword = new javax.swing.JLabel();
        passwordUser_psfield = new javax.swing.JPasswordField();
        CreateUser_lblRol = new javax.swing.JLabel();
        cboxRoleUser = new javax.swing.JComboBox<>();
        CreateUser_lblStatus = new javax.swing.JLabel();
        cboxStatusUser = new javax.swing.JComboBox<>();
        btnCreateUser = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        bttonEmptyFields_pet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        CreateUserPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        CreateUserPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        CreateUserPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        CreateUserPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Up.setBackground(new java.awt.Color(0, 153, 153));
        Up.setMaximumSize(new java.awt.Dimension(1000, 100));
        Up.setMinimumSize(new java.awt.Dimension(1000, 100));
        Up.setPreferredSize(new java.awt.Dimension(1000, 100));

        CreateUser_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreateUser_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        CreateUser_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addComponent(CreateUser_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 205, Short.MAX_VALUE))
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addComponent(CreateUser_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CreateUser_lblTittle.getAccessibleContext().setAccessibleName("VetSys");

        CreateUserPanel.add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        Down.setBackground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(800, 600));
        Down.setMinimumSize(new java.awt.Dimension(800, 600));
        Down.setPreferredSize(new java.awt.Dimension(800, 600));

        CreateUser_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        CreateUser_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreateUser_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        CreateUser_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblSubTittle.setText("Crear Usuario");

        CreateUser_lblName.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_lblName.setText("Nombres *");

        nameUser_field.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nameUser_field.setForeground(java.awt.Color.gray);
        nameUser_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameUser_field.setMinimumSize(new java.awt.Dimension(68, 26));
        nameUser_field.setPreferredSize(new java.awt.Dimension(68, 26));

        CreateUser_LastName.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_LastName.setText("Apellidos *");

        lastNameUser_field.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lastNameUser_field.setForeground(java.awt.Color.gray);
        lastNameUser_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastNameUser_field.setMinimumSize(new java.awt.Dimension(68, 26));
        lastNameUser_field.setName(""); // NOI18N
        lastNameUser_field.setPreferredSize(new java.awt.Dimension(68, 26));

        CreateUser_lblPhone.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_lblPhone.setText("Telefono");

        phoneUser_field.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        phoneUser_field.setForeground(java.awt.Color.gray);
        phoneUser_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneUser_field.setMinimumSize(new java.awt.Dimension(68, 26));
        phoneUser_field.setPreferredSize(new java.awt.Dimension(68, 26));

        CreateUser_lbl_ID.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_lbl_ID.setText("Documento *");

        documentUser_field.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        documentUser_field.setForeground(java.awt.Color.gray);
        documentUser_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        documentUser_field.setMinimumSize(new java.awt.Dimension(68, 26));
        documentUser_field.setPreferredSize(new java.awt.Dimension(68, 26));

        CreateUser_lblEmail.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_lblEmail.setText("Correo electronico *");

        emailUser_field.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        emailUser_field.setForeground(java.awt.Color.gray);
        emailUser_field.setMinimumSize(new java.awt.Dimension(68, 26));
        emailUser_field.setPreferredSize(new java.awt.Dimension(68, 26));

        CreateUser_lblUsername.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblUsername.setText("Usuario *");

        usernameUser_field.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        usernameUser_field.setForeground(java.awt.Color.gray);
        usernameUser_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameUser_field.setMinimumSize(new java.awt.Dimension(68, 26));
        usernameUser_field.setPreferredSize(new java.awt.Dimension(68, 26));

        CreateUser_lblPassword.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblPassword.setText("Contraseña *");

        passwordUser_psfield.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        passwordUser_psfield.setForeground(java.awt.Color.gray);

        CreateUser_lblRol.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblRol.setText("Rol *");

        cboxRoleUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRoleUserActionPerformed(evt);
            }
        });

        CreateUser_lblStatus.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CreateUser_lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateUser_lblStatus.setText("Estado *");

        btnCreateUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCreateUser.setForeground(new java.awt.Color(0, 153, 153));
        btnCreateUser.setText("Crear");
        btnCreateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 153, 153));
        btnExit.setText("Salir");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        bttonEmptyFields_pet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bttonEmptyFields_pet.setForeground(new java.awt.Color(0, 153, 153));
        bttonEmptyFields_pet.setText("Limpiar");
        bttonEmptyFields_pet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttonEmptyFields_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttonEmptyFields_petActionPerformed(evt);
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
                        .addGap(59, 59, 59)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CreateUser_LastName)
                            .addComponent(CreateUser_lblPhone)
                            .addComponent(CreateUser_lbl_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreateUser_lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CreateUser_lblEmail)
                        .addGap(13, 13, 13)))
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(documentUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateUser_lblPassword)
                            .addComponent(CreateUser_lblUsername)
                            .addComponent(CreateUser_lblStatus)
                            .addComponent(CreateUser_lblRol))
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DownLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cboxStatusUser, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboxRoleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(passwordUser_psfield, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(usernameUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(btnCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttonEmptyFields_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addComponent(CreateUser_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateUser_lblName)
                            .addComponent(nameUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateUser_LastName)
                            .addComponent(lastNameUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreateUser_lblPhone)))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateUser_lblUsername)
                            .addComponent(usernameUser_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateUser_lblPassword)
                            .addComponent(passwordUser_psfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateUser_lblStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboxStatusUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(documentUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateUser_lbl_ID)
                    .addComponent(CreateUser_lblRol)
                    .addComponent(cboxRoleUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateUser_lblEmail))
                .addGap(108, 108, 108)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateUser)
                    .addComponent(btnExit)
                    .addComponent(bttonEmptyFields_pet))
                .addGap(229, 229, 229))
        );

        CreateUser_lblName.getAccessibleContext().setAccessibleDescription("lblName");

        CreateUserPanel.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 540));

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
                .addComponent(CreateUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxRoleUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRoleUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxRoleUserActionPerformed
    
    
    ///btn crear usuario
    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        String name_user = nameUser_field.getText();
        String last_name = lastNameUser_field.getText();
        String phone = phoneUser_field.getText();
        String document = documentUser_field.getText();
        String email = emailUser_field.getText();
        String username = usernameUser_field.getText();
        String password = passwordUser_psfield.getText();
        
        Role r = (Role) cboxRoleUser.getSelectedItem();
        Status s = (Status) cboxStatusUser.getSelectedItem();
        
        // Validaciones de campos obligatorios
        if (name_user.isEmpty() || document.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() ||
            cboxRoleUser.getSelectedIndex()== -1 || cboxStatusUser.getSelectedIndex() == -1) 
        {
            JOptionPane.showMessageDialog(this, "Completa los campos obligatorios *",logUser.getClinic().getName_clinic()
                    ,JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(passwordUser_psfield.getText().length() < 6)
        {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 6 caracteres",logUser.getClinic().getName_clinic()
                    ,JOptionPane.WARNING_MESSAGE);
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
        
        ///Validación del formato de correo
        if (!Utils.validationEmail(emailUser_field, this, logUser.getClinic().getName_clinic())) {
            return;
        }
        
        UserDAO userDAO = new project.vetsys.dao.UserDAO();
        boolean success = userDAO.Create(user);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario creado correctamente",
                    logUser.getClinic().getName_clinic(),JOptionPane.INFORMATION_MESSAGE);
            emptyFields();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al crear el usuario. \nRevisa los datos"
            ,logUser.getClinic().getName_clinic(),JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateUserActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        ///validar si hay campos con información antes de salir
        if(!nameUser_field.getText().isEmpty() || !lastNameUser_field.getText().isEmpty()|| !documentUser_field.getText().isEmpty() ||
            !emailUser_field.getText().isEmpty() || !usernameUser_field.getText().isEmpty() || !passwordUser_psfield.getText().isEmpty()){
            String messageConfirm = "¿Desea cancelar la creación del usuario?";
            String title = "CONFIRMACIÓN";
            int confirm = utils.validation(messageConfirm, title);
            if(confirm ==1){
                //siempre que se llame al MenuManager, hacerlo con el constructor con parametro de logUser
                UsersMenu MenuManagerFrame = new UsersMenu(logUser);  
                MenuManagerFrame.setVisible(true);
                MenuManagerFrame.pack();
                MenuManagerFrame.setLocationRelativeTo(null);
                this.dispose();
            }   
        }else
        {
            UsersMenu MenuManagerFrame = new UsersMenu(logUser);  
            MenuManagerFrame.setVisible(true);
            MenuManagerFrame.pack();
            MenuManagerFrame.setLocationRelativeTo(null);
            this.dispose();
        }   
    }//GEN-LAST:event_btnExitActionPerformed

    private void bttonEmptyFields_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttonEmptyFields_petActionPerformed
        emptyFields();
    }//GEN-LAST:event_bttonEmptyFields_petActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CreateUser().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreateUserPanel;
    private javax.swing.JLabel CreateUser_LastName;
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
    private javax.swing.JPanel Down;
    private javax.swing.JPanel Up;
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton bttonEmptyFields_pet;
    private javax.swing.JComboBox<Role> cboxRoleUser;
    private javax.swing.JComboBox<Status> cboxStatusUser;
    private javax.swing.JTextField documentUser_field;
    private javax.swing.JTextField emailUser_field;
    private javax.swing.JTextField lastNameUser_field;
    private javax.swing.JTextField nameUser_field;
    private javax.swing.JPasswordField passwordUser_psfield;
    private javax.swing.JTextField phoneUser_field;
    private javax.swing.JTextField usernameUser_field;
    // End of variables declaration//GEN-END:variables

    private void aplicarAccesibilidad() {

    // ===========================
    //  TÍTULO Y PANEL PRINCIPAL
    // ===========================
    CreateUserPanel.setFocusable(true);
    Up.setFocusable(true);
    Down.setFocusable(true);

    CreateUser_lblTittle.getAccessibleContext().setAccessibleName("Título principal: gestión de usuarios");
    CreateUser_lblTittle.getAccessibleContext().setAccessibleDescription("Indica la gestión de usuarios de la clínica");

    CreateUser_lblSubTittle.getAccessibleContext().setAccessibleName("Subtítulo crear usuario");
    CreateUser_lblSubTittle.getAccessibleContext().setAccessibleDescription("Indica el formulario para crear usuario");

    // ===========================
    //  LABELS (setLabelFor + Mnemonics)
    // ===========================

    // Nombres
    CreateUser_lblName.setLabelFor(nameUser_field);
    CreateUser_lblName.setDisplayedMnemonic('N'); // Alt+N
    CreateUser_lblName.setToolTipText("Campo nombres (Alt+N)");
    CreateUser_lblName.getAccessibleContext().setAccessibleName("Etiqueta nombres");
    CreateUser_lblName.getAccessibleContext().setAccessibleDescription("Etiqueta del campo nombres");

    // Apellidos
    CreateUser_LastName.setLabelFor(lastNameUser_field);
    CreateUser_LastName.setDisplayedMnemonic('A'); // Alt+A
    CreateUser_LastName.setToolTipText("Campo apellidos (Alt+A)");
    CreateUser_LastName.getAccessibleContext().setAccessibleName("Etiqueta apellidos");
    CreateUser_LastName.getAccessibleContext().setAccessibleDescription("Etiqueta del campo apellidos");

    // Teléfono
    CreateUser_lblPhone.setLabelFor(phoneUser_field);
    CreateUser_lblPhone.setDisplayedMnemonic('T'); // Alt+T
    CreateUser_lblPhone.setToolTipText("Campo teléfono (Alt+T)");
    CreateUser_lblPhone.getAccessibleContext().setAccessibleName("Etiqueta teléfono");
    CreateUser_lblPhone.getAccessibleContext().setAccessibleDescription("Etiqueta del campo teléfono");

    // Documento
    CreateUser_lbl_ID.setLabelFor(documentUser_field);
    CreateUser_lbl_ID.setDisplayedMnemonic('D'); // Alt+D
    CreateUser_lbl_ID.setToolTipText("Campo documento (Alt+D)");
    CreateUser_lbl_ID.getAccessibleContext().setAccessibleName("Etiqueta documento");
    CreateUser_lbl_ID.getAccessibleContext().setAccessibleDescription("Etiqueta del campo documento");

    // Email
    CreateUser_lblEmail.setLabelFor(emailUser_field);
    CreateUser_lblEmail.setDisplayedMnemonic('E'); // Alt+E
    CreateUser_lblEmail.setToolTipText("Campo correo electrónico (Alt+E)");
    CreateUser_lblEmail.getAccessibleContext().setAccessibleName("Etiqueta correo electrónico");
    CreateUser_lblEmail.getAccessibleContext().setAccessibleDescription("Etiqueta del campo correo electrónico");

    // Usuario
    CreateUser_lblUsername.setLabelFor(usernameUser_field);
    CreateUser_lblUsername.setDisplayedMnemonic('U'); // Alt+U
    CreateUser_lblUsername.setToolTipText("Campo usuario (Alt+U)");
    CreateUser_lblUsername.getAccessibleContext().setAccessibleName("Etiqueta usuario");
    CreateUser_lblUsername.getAccessibleContext().setAccessibleDescription("Etiqueta del campo nombre de usuario");

    // Contraseña
    CreateUser_lblPassword.setLabelFor(passwordUser_psfield);
    CreateUser_lblPassword.setDisplayedMnemonic('C'); // Alt+C
    CreateUser_lblPassword.setToolTipText("Campo contraseña (Alt+C)");
    CreateUser_lblPassword.getAccessibleContext().setAccessibleName("Etiqueta contraseña");
    CreateUser_lblPassword.getAccessibleContext().setAccessibleDescription("Etiqueta del campo contraseña");

    // Rol
    CreateUser_lblRol.setLabelFor(cboxRoleUser);
    CreateUser_lblRol.setDisplayedMnemonic('R'); // Alt+R
    CreateUser_lblRol.setToolTipText("Seleccionar rol (Alt+R)");
    CreateUser_lblRol.getAccessibleContext().setAccessibleName("Etiqueta rol de usuario");
    CreateUser_lblRol.getAccessibleContext().setAccessibleDescription("Etiqueta del campo roles");

    // Estado
    CreateUser_lblStatus.setLabelFor(cboxStatusUser);
    CreateUser_lblStatus.setDisplayedMnemonic('S'); // Alt+S
    CreateUser_lblStatus.setToolTipText("Seleccionar estado (Alt+S)");
    CreateUser_lblStatus.getAccessibleContext().setAccessibleName("Etiqueta estado del usuario");
    CreateUser_lblStatus.getAccessibleContext().setAccessibleDescription("Etiqueta del campo estados");

    // ===========================
    //  CAMPOS DE TEXTO ACCESSIBLE
    // ===========================

    nameUser_field.getAccessibleContext().setAccessibleName("Campo nombres");
    nameUser_field.getAccessibleContext().setAccessibleDescription("Ingrese los nombres del usuario");

    lastNameUser_field.getAccessibleContext().setAccessibleName("Campo apellidos");
    lastNameUser_field.getAccessibleContext().setAccessibleDescription("Ingrese los apellidos del usuario");

    phoneUser_field.getAccessibleContext().setAccessibleName("Campo teléfono");
    phoneUser_field.getAccessibleContext().setAccessibleDescription("Ingrese el número de teléfono");

    documentUser_field.getAccessibleContext().setAccessibleName("Campo documento");
    documentUser_field.getAccessibleContext().setAccessibleDescription("Ingrese el número de documento");

    emailUser_field.getAccessibleContext().setAccessibleName("Campo correo electrónico");
    emailUser_field.getAccessibleContext().setAccessibleDescription("Ingrese un correo electrónico válido");

    usernameUser_field.getAccessibleContext().setAccessibleName("Campo usuario");
    usernameUser_field.getAccessibleContext().setAccessibleDescription("Ingrese el nombre de usuario");

    passwordUser_psfield.getAccessibleContext().setAccessibleName("Campo contraseña");
    passwordUser_psfield.getAccessibleContext().setAccessibleDescription("Ingrese la contraseña del usuario");

    cboxRoleUser.getAccessibleContext().setAccessibleName("Combo rol");
    cboxRoleUser.getAccessibleContext().setAccessibleDescription("Seleccione el rol del usuario");

    cboxStatusUser.getAccessibleContext().setAccessibleName("Combo estado");
    cboxStatusUser.getAccessibleContext().setAccessibleDescription("Seleccione el estado del usuario");

    // ===========================
    //  BOTONES + mnemonics
    // ===========================

    btnCreateUser.setMnemonic('G'); // Alt+G (Guardar/Crear)
    btnCreateUser.setToolTipText("Crear usuario (Alt+G)");
    btnCreateUser.getAccessibleContext().setAccessibleName("Botón crear usuario");

    btnExit.setMnemonic('L'); // Alt+L (Salir)
    btnExit.setToolTipText("Salir (Alt+L)");
    btnExit.getAccessibleContext().setAccessibleName("Botón salir");

    bttonEmptyFields_pet.setMnemonic('M'); // Alt+M (Limpiar)
    bttonEmptyFields_pet.setToolTipText("Limpiar formulario (Alt+M)");
    bttonEmptyFields_pet.getAccessibleContext().setAccessibleName("Botón limpiar campos");

    // ===========================
    //   TAB ORDER PRINCIPAL
    // ===========================
    nameUser_field.setNextFocusableComponent(lastNameUser_field);
    lastNameUser_field.setNextFocusableComponent(phoneUser_field);
    phoneUser_field.setNextFocusableComponent(documentUser_field);
    documentUser_field.setNextFocusableComponent(emailUser_field);
    emailUser_field.setNextFocusableComponent(usernameUser_field);
    usernameUser_field.setNextFocusableComponent(passwordUser_psfield);
    passwordUser_psfield.setNextFocusableComponent(cboxStatusUser);
    cboxStatusUser.setNextFocusableComponent(cboxRoleUser);
    cboxRoleUser.setNextFocusableComponent(btnCreateUser);
    btnCreateUser.setNextFocusableComponent(btnExit);
    btnExit.setNextFocusableComponent(bttonEmptyFields_pet);

    // ===========================
    //   ATAJOS ALT (rootPane)
    // ===========================
    javax.swing.InputMap im = getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
    javax.swing.ActionMap am = getRootPane().getActionMap();

    // Crear usuario → Alt+G
    im.put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_crear");
    am.put("accion_crear", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnCreateUser.doClick();
        }
    });

    // Salir → Alt+L
    im.put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_salir");
    am.put("accion_salir", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnExit.doClick();
        }
    });

    // Limpiar → Alt+M
    im.put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_limpiar");
    am.put("accion_limpiar", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            bttonEmptyFields_pet.doClick();
        }
    });
}

}
