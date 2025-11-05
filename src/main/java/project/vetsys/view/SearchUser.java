/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.vetsys.view;

import java.util.ArrayList;
import project.vetsys.view.manager.MenuManager;
import java.util.List;
import javax.swing.JOptionPane;
import project.vetsys.dao.ClinicDAO;
import project.vetsys.dao.RoleDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.Clinic;
import project.vetsys.model.Role;
import project.vetsys.model.User;

/**
 *
 * @author San
 */
public class SearchUser extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchUser.class.getName());
    private User logUser; //user que inicio sesion
    private boolean filters;

    /**
     * Creates new form SearchUser
     * @param logUser
     */
    
    // Constructor que recibe el usuario logueado
    public SearchUser(User logUser) {
        initComponents();
        this.logUser = logUser;
        loadAllUsers(logUser);
        loadRoles();   ///mostrar usuarios por rol
        
        //validacion del rol, para que no pueda modificar usuarios si no es administrador
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role())){
            btnActualizar.setEnabled(false);
        }
        System.out.println("Usuario logueado recibido: " + logUser.getUsername()); //prueba en consola
        initListeners();
        
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            userTableMouseClicked(evt);
        }});
        
    }

    // Constructor sin parámetros 
    public SearchUser() {
        initComponents();
        initListeners();  
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            userTableMouseClicked(evt);
            }
        });
    }
    
    //cargar roles al combobox loadRolesForClinic
    private void loadRoles() {
    RoleDAO roleDAO = new RoleDAO();
    List<Role> roles = roleDAO.getAllRole(logUser);
    cboxRole.removeAllItems();
    
    /// mostrar todos los roles
    cboxRole.addItem(new Role(0, "Todos", "Mostrar todos los roles"));
    if (roles != null && !roles.isEmpty()) {
        for (Role r : roles) {
            if (r != null && r.getId() > 0 && r.getName() != null) {
                cboxRole.addItem(r); /// agrega el objeto Role completo
                filters = true;
            }
        }
    } 
    cboxRole.addActionListener(e -> {
        loadUsersByClinicandRole(logUser);
    });
    
    
    ///verificar en consola que usuarios se estan cargando
    System.out.println("Roles cargados en el combo:");
    for (int i = 0; i < cboxRole.getItemCount(); i++) {
        Object item = cboxRole.getItemAt(i);
        System.out.println("   - " + item + " (" + item.getClass().getSimpleName() + ")");
    }
}

    
    ///todos los usuarios sin filtro al hacer la consulta
    private void loadAllUsers(User logUser) {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.ReadAll(logUser); //cargar todos a latbla

        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Usuario");
        model.addColumn("Rol");
        model.addColumn("Estado");
        model.addColumn("Clínica");

        for (User user : users) {
            model.addRow(new Object[]{
                user.getId_user(),
                user.getUsername(),
                user.getName_role(),
                user.getName_status(),
                user.getName_clinic()
            });
        }
        userTable.setModel(model);
    }
    
    
    /// Filtro por clínica seleccionada y por rol en el filtro de combobox 
    private void loadUsersByClinicandRole(User logUser) {

    Object sel = cboxRole.getSelectedItem();     /// Obtener rol seleccionado
    Integer idRole = null;
    if (sel instanceof Role) {
        Role selectedRole = (Role) sel;
        if (selectedRole.getId() > 0) {
            idRole = selectedRole.getId();
        }
    } else {
        System.out.println("El combo no contiene objetos Role: " + sel); ///validación en consola de que el combobox tiene objetos
    }
    int idClinic = logUser.getId_clinic();

    System.out.println("Buscando usuarios-> clinicId: " + idClinic + ", roleId: " + idRole); ///validar en consola que se esta buscando en la base de datos

    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.ReadByClinicAndRole(idClinic, idRole);
    
    if (users == null)
        users = new ArrayList<>();
    
    System.out.println("Usuarios devueltos por DAO: " + users.size()); ///verificar por consola que se esta devolviendo de la base de datos  y que no sea null
 
    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    model.addColumn("ID");
    model.addColumn("Usuario");
    model.addColumn("Rol");
    model.addColumn("Estado");
    model.addColumn("Clínica");

    if (!users.isEmpty()) {
        for (User user : users) {
            model.addRow(new Object[]{
                user.getId_user(),
                user.getUsername(),
                user.getName_role(),
                user.getName_status(),
                user.getName_clinic()
            });
        }
    } else {
        if(filters){
          // Si no hay usuarios, dejamos la tabla vacía
          //JOptionPane.showMessageDialog(this,"No se encontraron usuarios en la clínica con el filtro seleccionado");
          System.out.println("Sin resultados para el filtro.");   
        }
       
    }

    userTable.setModel(model);
}

  
    // Listener para el filtro por rol
    private void initListeners() {
        cboxRole.addActionListener(e -> loadUsersByClinicandRole(logUser));
    }

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {    
        
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            int idUser = (int) userTable.getValueAt(selectedRow, 0); //obtener el id usuario seleccionado
            //consultar datos del usuario
            UserDAO userDAO = new UserDAO();
            User user = userDAO.ReadById(idUser);
            //String username = (String) userTable.getValueAt(selectedRow, 1);

            //IDField.setText(username);
            //asignar los valores de rol, estado, etc. a sus ComboBox
            //Se hace condicional donde el 1 sea la clinica que corresponde y
            //asi mismo con los demas, o sino, colocarlos en un combobox
            if (user != null) {
            // Asignar los datos a los campos de texto
            IDField.setText(String.valueOf(user.getId_user()));
            usernameField.setText(user.getUsername());
            RoleField.setText(user.getName_role());
            StatusField.setText(user.getName_status());
            ClinicField.setText(user.getName_clinic());
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo obtener la información del usuario seleccionado.");
            }
            
        }
    }
    
    private int getRoleIdByName(String roleName) {
        return switch (roleName.toLowerCase()) {
            case "administrador" -> 1;
            case "asistente" -> 2;
            case "veterinario" -> 3;
            default -> 0;
        };
    }

    private int getStatusIdByName(String statusName) {
        switch (statusName.toLowerCase()) {
            case "activo": return 1;
            case "inactivo": return 2;
            default: return 0;
        }
    }
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        IDField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        RoleField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        usernameField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        StatusField = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ClinicField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cboxRole = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 600));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");

        IDField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        IDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDFieldActionPerformed(evt);
            }
        });

        usernameField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID");

        RoleField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        RoleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Status");

        usernameField3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        usernameField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameField3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rol");

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Crear Cuenta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        StatusField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        StatusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusFieldActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 102, 102));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 102));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Clinica");

        ClinicField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ClinicField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClinicFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StatusField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(RoleField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jButton2)
                            .addComponent(usernameField3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(ClinicField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(117, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RoleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(StatusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(ClinicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnActualizar)
                .addGap(34, 34, 34)
                .addComponent(btnSalir)
                .addGap(132, 132, 132)
                .addComponent(usernameField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(103, 103, 103))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(630, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 600);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 600));

        cboxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRoleActionPerformed(evt);
            }
        });

        jLabel6.setText("Rol");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(userTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );

        cboxRole.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void RoleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleFieldActionPerformed

    private void usernameField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CreateUser CreateUserFrame = new CreateUser();
        CreateUserFrame.setVisible(true);
        CreateUserFrame.pack();
        CreateUserFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void StatusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusFieldActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
        try {
            int idUser = Integer.parseInt(IDField.getText().trim());
            String username = usernameField.getText().trim();
            String roleName = RoleField.getText().trim();
            String statusName = StatusField.getText().trim();

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario no puede estar vacío.");
                return;
            }

            // Crear usuario a actualizar
            User user = new User();
            user.setId_user(idUser);
            user.setUsername(username);
            user.setName_role(roleName);
            user.setName_status(statusName);
            user.setId_clinic(logUser.getId_clinic()); // mismo id de clínica

            // Asignar IDs a partir de nombres (si tus combos devuelven IDs, puedes usar esos directamente)
            user.setId_role(getRoleIdByName(roleName));
            user.setId_status(getStatusIdByName(statusName));

            // Llamar al DAO
            UserDAO userDAO = new UserDAO();
            boolean updated = userDAO.Update(user, logUser);

            if (updated) {
                JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
                loadUsersByClinicandRole(logUser); // refrescar tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el usuario. Verifica permisos o datos.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: ID de usuario inválido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        MenuManager MenuManagerFrame = new MenuManager();
        MenuManagerFrame.setVisible(true);
        MenuManagerFrame.pack();
        MenuManagerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ClinicFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClinicFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClinicFieldActionPerformed

    private void cboxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxRoleActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new SearchUser().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClinicField;
    private javax.swing.JTextField IDField;
    private javax.swing.JTextField RoleField;
    private javax.swing.JTextField StatusField;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Role> cboxRole;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userTable;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextField usernameField3;
    // End of variables declaration//GEN-END:variables
}
