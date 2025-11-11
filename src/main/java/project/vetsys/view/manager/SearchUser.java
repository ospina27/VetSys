package project.vetsys.view.manager;

import java.awt.Color;
import project.vetsys.view.manager.CreateUser;
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
import project.vetsys.view.ComboBox;

public class SearchUser extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchUser.class.getName());
    private User logUser; //user que inicio sesion
    private boolean filters;
    
    // Constructor que recibe el usuario logueado
    public SearchUser(User logUser) {
        initComponents();
        this.logUser = logUser;
        loadAllUsers(logUser);
        loadRolesStatus(); 
        
        //validacion del rol, para que no pueda modificar usuarios si no es administrador
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role())){
            SearchUser_BttnUpdate.setVisible(false);
            SearchUser_BttnDelete.setVisible(false);
        }
        SearchUser_textClinic.setEditable(false); ///no editar la clinica ni el id 
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
    SearchUser_ComboBoxRoleRight.removeAllItems();
    
    /// mostrar todos los roles
    Role defaultRole = new Role(0, "Todos", "Mostrar todos los roles");
    ComboBox.fillComboBox(SearchUser_ComboBoxRoleRight, roles, defaultRole);
    ComboBox.fillComboBox(SearchUser_ComboBoxRole, roles, null);
    ComboBox.fillComboBox(SearchUser_ComboBoxStatus, status, null);
    
    ///verificar en consola que usuarios se estan cargando
    System.out.println("Roles cargados en el combo:");
    for (int i = 0; i < SearchUser_ComboBoxRoleRight.getItemCount(); i++) {
        Object item = SearchUser_ComboBoxRoleRight.getItemAt(i);
        System.out.println("   - " + item + " (" + item.getClass().getSimpleName() + ")");
    }
    System.out.println("Estados cargados en el combo:");
    for (int i = 0; i < SearchUser_ComboBoxStatus.getItemCount(); i++) {
        Object item = SearchUser_ComboBoxStatus.getItemAt(i);
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

    Object sel = SearchUser_ComboBoxRoleRight.getSelectedItem();     /// Obtener rol seleccionado
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
        SearchUser_ComboBoxRoleRight.addActionListener(e -> loadUsersByClinicandRole(logUser));
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
            SearchUser_textName.setText(user.getName_user());
            SearchUser_textLastName.setText(user.getLast_name());
            
            ///FALTA AGREGAR ESTADO EN UN CBOBOX
            /// 
            ///se muestra en el cbox el rol del usuario clickeado
            for(int i= 0;i < SearchUser_ComboBoxRole.getItemCount(); i++)
            {
                Role r = (Role) SearchUser_ComboBoxRole.getItemAt(i);
                if(r.getId() == user.getId_role())
                {
                    SearchUser_ComboBoxRole.setSelectedIndex(i);
                    break;
                }
            }
             for(int i= 0;i < SearchUser_ComboBoxStatus.getItemCount(); i++)
            {
                Status s = (Status) SearchUser_ComboBoxStatus.getItemAt(i);
                if(s.getId()== user.getId_status())
                {
                    SearchUser_ComboBoxStatus.setSelectedIndex(i);
                    break;
                }
            }
            
            SearchUser_textUsername.setText(user.getUsername());
            //StatusField.setText(user.getName_status());
            SearchUser_textUsername.setText(user.getUsername());
            SearchUser_textClinic.setText(user.getName_clinic());
            SearhcUser_textID.setText(user.getDocument());
            SearchUser_textPhone.setText(user.getPhone());
            SearchUser_textEmail.setText(user.getEmail());
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

        SearchUserPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        SearchUser_lblName = new javax.swing.JLabel();
        SearchUser_textName = new javax.swing.JTextField();
        SearchUser_lblLastName = new javax.swing.JLabel();
        SearchUser_textLastName = new javax.swing.JTextField();
        SearchUser_lblRole = new javax.swing.JLabel();
        SearchUser_ComboBoxRole = new javax.swing.JComboBox<>();
        SearchUser_lblStatus = new javax.swing.JLabel();
        SearchUser_ComboBoxStatus = new javax.swing.JComboBox<>();
        SearchUser_lblUsername = new javax.swing.JLabel();
        SearchUser_textUsername = new javax.swing.JTextField();
        SearchUser_lblClinic = new javax.swing.JLabel();
        SearchUser_textClinic = new javax.swing.JTextField();
        SearchUser_lblID = new javax.swing.JLabel();
        SearhcUser_textID = new javax.swing.JTextField();
        SearchUser_lblPhone = new javax.swing.JLabel();
        SearchUser_textPhone = new javax.swing.JTextField();
        SearchUser_lblEmail = new javax.swing.JLabel();
        SearchUser_textEmail = new javax.swing.JTextField();
        usernameField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        idUserField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        SearchUser_lblRoleRight = new javax.swing.JLabel();
        SearchUser_ComboBoxRoleRight = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        SearchUser_BttnUpdate = new javax.swing.JPanel();
        SearchUser_lblBttnUpdate = new javax.swing.JLabel();
        SearchUser_BttnDelete = new javax.swing.JPanel();
        SearchUser_lblBttnDelete = new javax.swing.JLabel();
        SearchUser_BttnBack = new javax.swing.JPanel();
        SearchUser_lblBttnBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        SearchUserPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        SearchUserPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        SearchUserPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        SearchUserPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(350, 800));
        Left.setMinimumSize(new java.awt.Dimension(350, 800));
        Left.setPreferredSize(new java.awt.Dimension(350, 800));

        SearchUser_lblName.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblName.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblName.setText("Nombres");

        SearchUser_textName.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SearchUser_textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_textNameActionPerformed(evt);
            }
        });

        SearchUser_lblLastName.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblLastName.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblLastName.setText("Apellidos");

        SearchUser_textLastName.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SearchUser_textLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_textLastNameActionPerformed(evt);
            }
        });

        SearchUser_lblRole.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblRole.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblRole.setText("Rol");

        SearchUser_ComboBoxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_ComboBoxRoleActionPerformed(evt);
            }
        });

        SearchUser_lblStatus.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblStatus.setText("Estado");

        SearchUser_ComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_ComboBoxStatusActionPerformed(evt);
            }
        });

        SearchUser_lblUsername.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblUsername.setText("Usuario");

        SearchUser_textUsername.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SearchUser_textUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_textUsernameActionPerformed(evt);
            }
        });

        SearchUser_lblClinic.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblClinic.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblClinic.setText("Clinica");

        SearchUser_textClinic.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SearchUser_textClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_textClinicActionPerformed(evt);
            }
        });

        SearchUser_lblID.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblID.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblID.setText("Documento");

        SearhcUser_textID.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SearhcUser_textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearhcUser_textIDActionPerformed(evt);
            }
        });

        SearchUser_lblPhone.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblPhone.setText("Telefono");

        SearchUser_textPhone.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SearchUser_textPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_textPhoneActionPerformed(evt);
            }
        });

        SearchUser_lblEmail.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SearchUser_lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblEmail.setText("Correo");

        SearchUser_textEmail.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        SearchUser_textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_textEmailActionPerformed(evt);
            }
        });

        usernameField3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        usernameField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameField3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Crear Cuenta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchUser_ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchUser_lblUsername)
                    .addComponent(SearchUser_textClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchUser_lblEmail)
                    .addComponent(SearchUser_lblPhone)
                    .addComponent(SearchUser_textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchUser_lblID)
                    .addComponent(SearchUser_lblLastName)
                    .addComponent(SearchUser_lblName)
                    .addComponent(SearchUser_textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(usernameField3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearhcUser_textID, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchUser_textName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchUser_textPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchUser_lblClinic)
                    .addComponent(SearchUser_textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchUser_ComboBoxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchUser_lblRole)
                            .addComponent(SearchUser_lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(idUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchUser_lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_textName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_lblLastName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchUser_lblRole)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchUser_ComboBoxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(SearchUser_lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(SearchUser_lblUsername)
                .addGap(4, 4, 4)
                .addComponent(SearchUser_textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_lblClinic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_textClinic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearhcUser_textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(SearchUser_lblPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_textPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(usernameField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(103, 103, 103))
        );

        SearchUserPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setAutoscrolls(true);
        Right.setMaximumSize(new java.awt.Dimension(650, 800));
        Right.setMinimumSize(new java.awt.Dimension(650, 800));
        Right.setName(""); // NOI18N
        Right.setPreferredSize(new java.awt.Dimension(650, 800));

        SearchUser_lblRoleRight.setText("Rol");

        SearchUser_ComboBoxRoleRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUser_ComboBoxRoleRightActionPerformed(evt);
            }
        });

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

        SearchUser_BttnUpdate.setBackground(new java.awt.Color(0, 153, 153));
        SearchUser_BttnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SearchUser_lblBttnUpdate.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        SearchUser_lblBttnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblBttnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchUser_lblBttnUpdate.setText("Actualizar");
        SearchUser_lblBttnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchUser_lblBttnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnUpdateMouseExited(evt);
            }
        });
        SearchUser_lblBttnUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchUser_lblBttnUpdateKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout SearchUser_BttnUpdateLayout = new javax.swing.GroupLayout(SearchUser_BttnUpdate);
        SearchUser_BttnUpdate.setLayout(SearchUser_BttnUpdateLayout);
        SearchUser_BttnUpdateLayout.setHorizontalGroup(
            SearchUser_BttnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchUser_lblBttnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        SearchUser_BttnUpdateLayout.setVerticalGroup(
            SearchUser_BttnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchUser_lblBttnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        SearchUser_BttnDelete.setBackground(new java.awt.Color(0, 153, 153));
        SearchUser_BttnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SearchUser_lblBttnDelete.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        SearchUser_lblBttnDelete.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblBttnDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchUser_lblBttnDelete.setText("Eliminar");
        SearchUser_lblBttnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchUser_lblBttnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnDeleteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SearchUser_BttnDeleteLayout = new javax.swing.GroupLayout(SearchUser_BttnDelete);
        SearchUser_BttnDelete.setLayout(SearchUser_BttnDeleteLayout);
        SearchUser_BttnDeleteLayout.setHorizontalGroup(
            SearchUser_BttnDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchUser_lblBttnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        SearchUser_BttnDeleteLayout.setVerticalGroup(
            SearchUser_BttnDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchUser_lblBttnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        SearchUser_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        SearchUser_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SearchUser_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        SearchUser_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        SearchUser_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchUser_lblBttnBack.setText("Salir");
        SearchUser_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchUser_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchUser_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SearchUser_BttnBackLayout = new javax.swing.GroupLayout(SearchUser_BttnBack);
        SearchUser_BttnBack.setLayout(SearchUser_BttnBackLayout);
        SearchUser_BttnBackLayout.setHorizontalGroup(
            SearchUser_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchUser_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        SearchUser_BttnBackLayout.setVerticalGroup(
            SearchUser_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchUser_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SearchUser_ComboBoxRoleRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SearchUser_lblRoleRight)))
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addGap(12, 12, 12)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(RightLayout.createSequentialGroup()
                                        .addComponent(SearchUser_BttnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(SearchUser_BttnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(RightLayout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(SearchUser_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchUser_lblRoleRight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchUser_ComboBoxRoleRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(SearchUser_BttnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(SearchUser_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SearchUser_BttnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        SearchUser_ComboBoxRoleRight.getAccessibleContext().setAccessibleDescription("");

        SearchUserPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 440, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchUser_textLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_textLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_textLastNameActionPerformed

    private void SearchUser_textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_textNameActionPerformed

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
               
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void SearhcUser_textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearhcUser_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearhcUser_textIDActionPerformed

    private void SearchUser_ComboBoxRoleRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_ComboBoxRoleRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_ComboBoxRoleRightActionPerformed

    private void SearchUser_textPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_textPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_textPhoneActionPerformed

    private void SearchUser_textClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_textClinicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_textClinicActionPerformed

    private void SearchUser_textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_textEmailActionPerformed

    private void SearchUser_textUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_textUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_textUsernameActionPerformed

    private void SearchUser_ComboBoxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_ComboBoxRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_ComboBoxRoleActionPerformed

    private void idUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUserFieldActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void SearchUser_ComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUser_ComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchUser_ComboBoxStatusActionPerformed

    private void SearchUser_lblBttnUpdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnUpdateKeyPressed
        
    }//GEN-LAST:event_SearchUser_lblBttnUpdateKeyPressed

    private void SearchUser_lblBttnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnUpdateMouseClicked
        try {
            int idUser = Integer.parseInt(idUserField.getText().trim());
            String username = SearchUser_textUsername.getText().trim();
            

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario no puede estar vacío.");
                return;
            }
            
            
            Role r = (Role) SearchUser_ComboBoxRole.getSelectedItem();
            if(r == null)
            {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un rol");  
               
                return;
            }
            Status s = (Status) SearchUser_ComboBoxStatus.getSelectedItem();
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
    }//GEN-LAST:event_SearchUser_lblBttnUpdateMouseClicked

    private void SearchUser_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnBackMouseClicked
        UsersMenu MenuManagerFrame = new UsersMenu(logUser);
        MenuManagerFrame.setVisible(true);
        MenuManagerFrame.pack();
        MenuManagerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_SearchUser_lblBttnBackMouseClicked

    private void SearchUser_lblBttnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnDeleteMouseEntered
        SearchUser_BttnDelete.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SearchUser_lblBttnDeleteMouseEntered

    private void SearchUser_lblBttnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnDeleteMouseExited
        SearchUser_BttnDelete.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_SearchUser_lblBttnDeleteMouseExited

    private void SearchUser_lblBttnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnUpdateMouseEntered
        SearchUser_BttnUpdate.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SearchUser_lblBttnUpdateMouseEntered

    private void SearchUser_lblBttnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnUpdateMouseExited
        SearchUser_BttnUpdate.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_SearchUser_lblBttnUpdateMouseExited

    private void SearchUser_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnBackMouseEntered
        SearchUser_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SearchUser_lblBttnBackMouseEntered

    private void SearchUser_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnBackMouseExited
        SearchUser_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_SearchUser_lblBttnBackMouseExited

    private void SearchUser_lblBttnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchUser_lblBttnDeleteMouseClicked
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
    }//GEN-LAST:event_SearchUser_lblBttnDeleteMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SearchUser().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel SearchUserPanel;
    private javax.swing.JPanel SearchUser_BttnBack;
    private javax.swing.JPanel SearchUser_BttnDelete;
    private javax.swing.JPanel SearchUser_BttnUpdate;
    private javax.swing.JComboBox<Role> SearchUser_ComboBoxRole;
    private javax.swing.JComboBox<Role> SearchUser_ComboBoxRoleRight;
    private javax.swing.JComboBox<Status> SearchUser_ComboBoxStatus;
    private javax.swing.JLabel SearchUser_lblBttnBack;
    private javax.swing.JLabel SearchUser_lblBttnDelete;
    private javax.swing.JLabel SearchUser_lblBttnUpdate;
    private javax.swing.JLabel SearchUser_lblClinic;
    private javax.swing.JLabel SearchUser_lblEmail;
    private javax.swing.JLabel SearchUser_lblID;
    private javax.swing.JLabel SearchUser_lblLastName;
    private javax.swing.JLabel SearchUser_lblName;
    private javax.swing.JLabel SearchUser_lblPhone;
    private javax.swing.JLabel SearchUser_lblRole;
    private javax.swing.JLabel SearchUser_lblRoleRight;
    private javax.swing.JLabel SearchUser_lblStatus;
    private javax.swing.JLabel SearchUser_lblUsername;
    private javax.swing.JTextField SearchUser_textClinic;
    private javax.swing.JTextField SearchUser_textEmail;
    private javax.swing.JTextField SearchUser_textLastName;
    private javax.swing.JTextField SearchUser_textName;
    private javax.swing.JTextField SearchUser_textPhone;
    private javax.swing.JTextField SearchUser_textUsername;
    private javax.swing.JTextField SearhcUser_textID;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField idUserField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable userTable;
    private javax.swing.JTextField usernameField3;
    // End of variables declaration//GEN-END:variables
}
