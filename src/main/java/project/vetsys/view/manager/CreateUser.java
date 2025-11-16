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
import project.vetsys.view.Nimbus;
import project.vetsys.view.Utils;
import project.vetsys.view.manager.MenuManager;

public class CreateUser extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateUser.class.getName());
    private User logUser;
    private Utils utils;

    public CreateUser() {
        initComponents();
    }
    
    public CreateUser(User logUser) {
        Nimbus.LookandFeel();
        this.logUser = logUser;  
        this.utils = new Utils();
        initComponents();
        Nimbus.styleAllTextFields(this);
        setTitle("Gestion de usuarios");
        CreateUser_lblTittle.setText("Usuarios "+ logUser.getClinic().getName_clinic());
        Nimbus.styleTitleLabel(CreateUser_lblTittle);
        Nimbus.styleAllLabelsExcept(this,CreateUser_lblTittle);
        loadRolesStatus();
       
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        btnCreateUser.setForeground(new java.awt.Color(0, 102, 102));
        btnCreateUser.setText("Crear");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 102, 102));
        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
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
                                .addComponent(usernameUser_field, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(btnCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(216, Short.MAX_VALUE))
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
                    .addComponent(btnExit))
                .addGap(229, 229, 229))
        );

        CreateUser_lblName.getAccessibleContext().setAccessibleDescription("lblName");

        CreateUserPanel.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 510));

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
                .addGap(0, 6, Short.MAX_VALUE))
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
            JOptionPane.showMessageDialog(this, "Completa los campos obligatorios *","ATENCIÓN",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(passwordUser_psfield.getText().length() < 6)
        {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 6 caracteres","ATENCIÓN",JOptionPane.WARNING_MESSAGE);
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
        
        project.vetsys.dao.UserDAO userDAO = new project.vetsys.dao.UserDAO();
        boolean success = userDAO.Create(user);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario creado correctamente");
            emptyFields();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al crear el usuario. Revisa los datos o la conexión.");
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
}
