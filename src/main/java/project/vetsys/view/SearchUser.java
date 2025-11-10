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
import project.vetsys.dao.StatusDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.Clinic;
import project.vetsys.model.Role;
import project.vetsys.model.Status;
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
        loadRolesStatus(); 
        
        //validacion del rol, para que no pueda modificar usuarios si no es administrador
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role())){
            btnActualizar.setVisible(false);
            btnDelete.setVisible(false);
        }
        ClinicField3.setEditable(false); ///no editar la clinica ni el id 
        idUserField.setEditable(false);
        
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
    
    ///cargar roles y estado al combobox
    private void loadRolesStatus() {
    RoleDAO roleDAO = new RoleDAO();
    StatusDAO statusDAO = new StatusDAO();
    List<Role> roles = roleDAO.getAllRole(logUser);
    List<Status> status = statusDAO.getAllStatus(logUser);
    cboxRole.removeAllItems();
    
    /// mostrar todos los roles
    Role defaultRole = new Role(0, "Todos", "Mostrar todos los roles");
    ComboBox.fillComboBox(cboxRole, roles, defaultRole);
    ComboBox.fillComboBox(cboxRoleEdit, roles, null);
    ComboBox.fillComboBox(cboxStatusEdit, status, null);
    
    ///verificar en consola que usuarios se estan cargando
    System.out.println("Roles cargados en el combo:");
    for (int i = 0; i < cboxRole.getItemCount(); i++) {
        Object item = cboxRole.getItemAt(i);
        System.out.println("   - " + item + " (" + item.getClass().getSimpleName() + ")");
    }
    System.out.println("Estados cargados en el combo:");
    for (int i = 0; i < cboxStatusEdit.getItemCount(); i++) {
        Object item = cboxStatusEdit.getItemAt(i);
        System.out.println("   - " + item + " (" + item.getClass().getSimpleName() + ")");
    }
}

    
    ///todos los usuarios sin filtro al hacer la consulta
    private void loadAllUsers(User logUser) {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.ReadAll(logUser); //cargar todos a latbla

        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Documento");
        model.addColumn("Telefono");
        model.addColumn("Correo");
        model.addColumn("Usuario");
        model.addColumn("Rol");
        model.addColumn("Estado");
        model.addColumn("Clínica");

        for (User user : users) {
            model.addRow(new Object[]{
                user.getId_user(),
                user.getName_user(),
                user.getLast_name(),
                user.getDocument(),
                user.getPhone(),
                user.getEmail(),
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
    model.addColumn("Nombres");
    model.addColumn("Apellidos");
    model.addColumn("Documento");
    model.addColumn("Telefono");
    model.addColumn("Correo");
    model.addColumn("Usuario");
    model.addColumn("Rol");
    model.addColumn("Estado");
    model.addColumn("Clínica");

    if (!users.isEmpty()) {
        for (User user : users) {
            model.addRow(new Object[]{
                user.getId_user(),
                user.getName_user(),
                user.getLast_name(),
                user.getDocument(),
                user.getPhone(),
                user.getEmail(),
                user.getUsername(),
                user.getName_role(),
                user.getName_status(),
                user.getName_clinic()
            });
        }
    } else {
        if(filters){
          // Si no hay usuarios, dejamos la tabla vacía
          //JOptionPane.showMessageDialog(this,"No hay usuarios registrados en esta clínica.","Sin resultados",JOptionPane.INFORMATION_MESSAGE);
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
        
            //asignar los valores de rol, estado, etc. a sus ComboBox
            //Se hace condicional donde el 1 sea la clinica que corresponde y
            //asi mismo con los demas, o sino, colocarlos en un combobox
            if (user != null) {
            // Asignar los datos a los campos de texto
            idUserField.setText(String.valueOf(user.getId_user()));
            name_userField.setText(user.getName_user());
            LastNameField.setText(user.getLast_name());
            
            
            ///FALTA AGREGAR ESTADO EN UN CBOBOX
            /// 
            ///se muestra en el cbox el rol del usuario clickeado
            for(int i= 0;i < cboxRoleEdit.getItemCount(); i++)
            {
                Role r = (Role) cboxRoleEdit.getItemAt(i);
                if(r.getId() == user.getId_role())
                {
                    cboxRoleEdit.setSelectedIndex(i);
                    break;
                }
            }
             for(int i= 0;i < cboxStatusEdit.getItemCount(); i++)
            {
                Status s = (Status) cboxStatusEdit.getItemAt(i);
                if(s.getId()== user.getId_status())
                {
                    cboxStatusEdit.setSelectedIndex(i);
                    break;
                }
            }
            
            usernameField.setText(user.getUsername());
            //StatusField.setText(user.getName_status());
            usernameField.setText(user.getUsername());
            ClinicField3.setText(user.getName_clinic());
            DocumentField.setText(user.getDocument());
            PhoneField.setText(user.getPhone());
            EmailField.setText(user.getEmail());
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
        LastNameField = new javax.swing.JTextField();
        name_userField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        DocumentField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        ClinicField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboxRoleEdit = new javax.swing.JComboBox<>();
        idUserField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboxStatusEdit = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        cboxRole = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 600));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");

        LastNameField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        LastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameFieldActionPerformed(evt);
            }
        });

        name_userField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        name_userField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_userFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado");

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

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuario");

        DocumentField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        DocumentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentFieldActionPerformed(evt);
            }
        });

        PhoneField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        PhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneFieldActionPerformed(evt);
            }
        });

        ClinicField3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ClinicField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClinicField3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Documento");

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Telefono");

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Correo");

        EmailField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });

        usernameField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Clinica");

        cboxRoleEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRoleEditActionPerformed(evt);
            }
        });

        idUserField.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        idUserField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUserFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID");

        cboxStatusEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxStatusEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxStatusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(ClinicField3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(usernameField3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DocumentField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_userField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxRoleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(idUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name_userField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxRoleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxStatusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClinicField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DocumentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(usernameField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(103, 103, 103))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 300, 600);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAutoscrolls(true);
        jPanel3.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 800));

        cboxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRoleActionPerformed(evt);
            }
        });

        jLabel6.setText("Rol");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title  9", "Title 10"
            }
        ));
        jScrollPane2.setViewportView(userTable);

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

        btnDelete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 102, 102));
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addGap(12, 12, 12)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir)
                    .addComponent(btnDelete))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        cboxRole.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jPanel3);
        jPanel3.setBounds(300, 0, 500, 800);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameFieldActionPerformed

    private void name_userFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_userFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_userFieldActionPerformed

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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
        try {
            int idUser = Integer.parseInt(idUserField.getText().trim());
            String username = usernameField.getText().trim();
            

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario no puede estar vacío.");
                return;
            }
            
            
            Role r = (Role) cboxRoleEdit.getSelectedItem();
            if(r == null)
            {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un rol");  
               
                return;
            }
            Status s = (Status) cboxStatusEdit.getSelectedItem();
            if(s == null)
            {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un estado");
                return;
            }
            
            // Crear usuario a actualizar
            User user = new User();
            user.setId_user(idUser);
            user.setUsername(username); 
            user.setId_role(r.getId());   ///se actualizan los roles con el id y el nombre en el combobox
            user.setName_role(r.getName());
            user.setId_status(s.getId());
            user.setName_status(s.getName());
            user.setId_clinic(logUser.getId_clinic()); // mismo id de clínica

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
        MenuManager MenuManagerFrame = new MenuManager(logUser);
        MenuManagerFrame.setVisible(true);
        MenuManagerFrame.pack();
        MenuManagerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void DocumentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocumentFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DocumentFieldActionPerformed

    private void cboxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxRoleActionPerformed

    private void PhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneFieldActionPerformed

    private void ClinicField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClinicField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClinicField3ActionPerformed

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void cboxRoleEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRoleEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxRoleEditActionPerformed

    private void idUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUserFieldActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int idUser = Integer.parseInt(idUserField.getText().trim());
            
            User user = new User();
            user.setId_user(idUser);

            UserDAO userDAO = new UserDAO();
            boolean delete = userDAO.Delete(user, logUser);
            
            if(delete)
            {
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
            }else 
            {
                JOptionPane.showMessageDialog(this,"No fue posible eliminar el usuario.\n" +
                "Puede que no pertenezca a su clínica o no exista.");
            }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, 
            "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cboxStatusEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxStatusEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxStatusEditActionPerformed

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
    private javax.swing.JTextField ClinicField3;
    private javax.swing.JTextField DocumentField;
    private javax.swing.JTextField EmailField;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Role> cboxRole;
    private javax.swing.JComboBox<Role> cboxRoleEdit;
    private javax.swing.JComboBox<Status> cboxStatusEdit;
    private javax.swing.JTextField idUserField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name_userField;
    private javax.swing.JTable userTable;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextField usernameField3;
    // End of variables declaration//GEN-END:variables
}
