package project.vetsys.view.manager;


import project.vetsys.view.manager.CreateUser;
import java.util.ArrayList;
import project.vetsys.view.manager.MenuManager;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import project.vetsys.dao.ClinicDAO;
import project.vetsys.dao.RoleDAO;
import project.vetsys.dao.StatusDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.Clinic;
import project.vetsys.model.Role;
import project.vetsys.model.Status;
import project.vetsys.model.User;
import project.vetsys.view.Nimbus;
import project.vetsys.view.Utils;


public class SearchUser extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchUser.class.getName());
    private User logUser; //user que inicio sesion
    private boolean filters; ///variable para validar los filtros seleccionados
    private Utils utils;

    // Constructor que recibe el usuario logueado
    public SearchUser(User logUser) {
        Nimbus.LookandFeel(); ///implementación de nimbus para la visualización
        initComponents();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Nimbus.styleAllTextFields(this); ///estilo para todos los textfield
        Nimbus.styleTable(userTable); ///estilo de la tabla
        modelTable();
        loadRolesStatus(); 
        this.utils = new Utils();
        this.logUser = logUser;
        setTitle("Gestion de Usuarios");
        jLabelTitleClinic_users.setText(logUser.getClinic().getName_clinic());  ///mostrar nombre de la clinica
        Nimbus.styleAllLabelsExcept(this,jLabelTitleClinic_users);  ///implementar estilos para lbl
        
        emptyFields();
        hideField(false);
        
        //validacion del rol, para que no pueda modificar usuarios si no es administrador
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role())){
            btnActualizar.setVisible(false);
            btnDelete.setVisible(false);
        }
        //ClinicField.setEditable(false); ///no editar la clinica ni el id 
        idUserField.setEditable(false);
        
        System.out.println("Usuario logueado recibido: " + logUser.getUsername()); //prueba en consola
        initListeners(); 
    }
    
    // Constructor sin parámetros 
    public SearchUser() {
        Nimbus.LookandFeel();
        initComponents();
        setTitle(logUser.getName_clinic());
        initListeners();
        modelTable();
    }
   
      
    private void modelTable(){
        DefaultTableModel modelTable = new DefaultTableModel(new Object[]{"ID","Nombres","Apellidos","Documento", 
            "Rol","Estado"},0);
        userTable.setModel(modelTable);
    }
    
    public void loadUsersTable(JTable tabla, List<User> listaUsuarios) {

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // La tabla no permite edición
            }
        };
        model.addColumn("ID");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Documento");
        model.addColumn("Rol");
        model.addColumn("Estado");
        
        for (User u : listaUsuarios) {
            model.addRow(new Object[]{
                u.getId_user(),
                u.getName_user(),
                u.getLast_name(),
                u.getDocument(),
                u.getName_role(),
                u.getName_status()
            });
        }
        tabla.setModel(model);
        tabla.setRowHeight(28); 
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

        
    ///vaciar los campos        
    private void emptyFields(){
        name_userField.setText("");
        LastNameField.setText("");
        cboxRole.setSelectedIndex(-1);
        cboxRoleEdit.setSelectedIndex(-1);
        cboxStatusEdit.setSelectedIndex(-1);
        idUserField.setText("");
        usernameField.setText("");
        DocumentField.setText("");
        PhoneField.setText("");
        EmailField.setText("");
    }
    
    ///ocultar textfield, cbox, lbls del panel de información
    private void hideField(boolean active)
    {
        name_userField.setVisible(active);
        LastNameField.setVisible(active);
        cboxRoleEdit.setVisible(active);
        cboxStatusEdit.setVisible(active);
        idUserField.setVisible(active);
        usernameField.setVisible(active);
        DocumentField.setVisible(active);
        PhoneField.setVisible(active);
        EmailField.setVisible(active);
        jLabel2.setVisible(active);
        jLabel3.setVisible(active);
        jLabel4.setVisible(active);
        jLabel5.setVisible(active);
        jLabel7.setVisible(active);
        jLabel9.setVisible(active);
        jLabel10.setVisible(active);
        jLabel12.setVisible(active);
        jLabel13.setVisible(active);
    }
    

   
    ///cargar roles y estado al combobox
    private void loadRolesStatus() {
   
    RoleDAO roleDAO = new RoleDAO();
    StatusDAO statusDAO = new StatusDAO();
    List<Role> roles = roleDAO.getAllRole(logUser);
    List<Status> status = statusDAO.getAllStatus(logUser);
    cboxRole.removeAllItems();
    
    /// mostrar todos los roles
    Role defaultRole = new Role(0, "Todos");
    Role defaultRoleEdit = new Role(0,"");
    Status defaultStatus = new Status(0,"");
    utils.fillComboBox(cboxRole, roles, defaultRole);
    utils.fillComboBox(cboxRoleEdit, roles, defaultRoleEdit);
    utils.fillComboBox(cboxStatusEdit, status, defaultStatus);
    cboxRole.setSelectedIndex(-1);  
    //cboxRoleEdit.setSelectedIndex(-1);
    //cboxStatusEdit.setSelectedIndex(-1);
    
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
        loadUsersTable(userTable, userDAO.ReadAll(logUser));
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
        
        if(!users.isEmpty()){
            loadUsersTable(userTable, users);
            emptyFields();
            cboxRole.setSelectedItem(sel);
            hideField(false);
        }else
        {
            if(!filters)
            {
              // Si no hay usuarios, se deja la tabla vacía
              JOptionPane.showMessageDialog(this,"No hay usuarios registrados", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
              hideField(false);
              modelTable();
            } 
        }
}

  
    // Listener para el filtro por rol
    private void initListeners() {
        cboxRole.addActionListener(e -> loadUsersByClinicandRole(logUser));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            userTableMouseClicked(evt);
        }});
    }

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {    
        
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            int idUser = (int) userTable.getValueAt(selectedRow, 0); //obtener el id usuario seleccionado
            UserDAO userDAO = new UserDAO();
            User user = userDAO.ReadById(idUser);
            if (user != null) {
                //Asignar los datos a los campos de texto
                hideField(true); ///no mostrar texfield ni combobox en los datos antes de cliclekar en la tabla
                idUserField.setText(String.valueOf(user.getId_user()));
                DocumentField.setText(user.getDocument());
                name_userField.setText(user.getName_user());
                LastNameField.setText(user.getLast_name());
                PhoneField.setText(user.getPhone());
                EmailField.setText(user.getEmail());
                usernameField.setText(user.getUsername());                               
                
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
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo obtener la información del usuario seleccionado.");
            }
        } 
    }
       
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2_Info = new javax.swing.JPanel();
        jPanel_titleClinic = new javax.swing.JPanel();
        jLabelTitleClinic_users = new javax.swing.JLabel();
        cboxStatusEdit = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        LastNameField = new javax.swing.JTextField();
        name_userField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DocumentField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        cboxRoleEdit = new javax.swing.JComboBox<>();
        idUserField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cboxRole = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        searchDocument_field = new javax.swing.JTextField();
        btnSearchDocument = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2_Info.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2_Info.setMinimumSize(new java.awt.Dimension(300, 600));
        jPanel2_Info.setPreferredSize(new java.awt.Dimension(288, 470));

        jPanel_titleClinic.setBackground(new java.awt.Color(0, 102, 102));

        jLabelTitleClinic_users.setFont(new java.awt.Font("Bookman Old Style", 3, 24)); // NOI18N
        jLabelTitleClinic_users.setForeground(java.awt.SystemColor.activeCaption);
        jLabelTitleClinic_users.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitleClinic_users.setToolTipText("");

        javax.swing.GroupLayout jPanel_titleClinicLayout = new javax.swing.GroupLayout(jPanel_titleClinic);
        jPanel_titleClinic.setLayout(jPanel_titleClinicLayout);
        jPanel_titleClinicLayout.setHorizontalGroup(
            jPanel_titleClinicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
            .addGroup(jPanel_titleClinicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_titleClinicLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jLabelTitleClinic_users, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel_titleClinicLayout.setVerticalGroup(
            jPanel_titleClinicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
            .addGroup(jPanel_titleClinicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_titleClinicLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelTitleClinic_users, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.control);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombres*");
        jLabel2.setToolTipText("");

        LastNameField.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        name_userField.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(java.awt.SystemColor.control);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.control);
        jLabel5.setText("Rol");

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuario*");

        DocumentField.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        PhoneField.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Documento*");

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Telefono");

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Correo");

        EmailField.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        usernameField.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        idUserField.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.disabledText"));
        idUserField.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        idUserField.setForeground(java.awt.SystemColor.activeCaption);
        idUserField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idUserField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.gray, null, null));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAutoscrolls(true);
        jPanel3.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 800));

        jLabel6.setText("Ingrese documento");

        userTable.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
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

        btnSearchDocument.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSearchDocument.setForeground(new java.awt.Color(0, 102, 102));
        btnSearchDocument.setText("Buscar");
        btnSearchDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDocumentActionPerformed(evt);
            }
        });

        jLabel8.setText("Busqueda por Rol");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(cboxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(searchDocument_field, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchDocument))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(12, 12, 12)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchDocument_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchDocument)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir)
                    .addComponent(btnDelete))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        cboxRole.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel2_InfoLayout = new javax.swing.GroupLayout(jPanel2_Info);
        jPanel2_Info.setLayout(jPanel2_InfoLayout);
        jPanel2_InfoLayout.setHorizontalGroup(
            jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7)))
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(DocumentField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(LastNameField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(name_userField)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5))
                            .addComponent(jLabel4))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxStatusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxRoleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel_titleClinic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2_InfoLayout.setVerticalGroup(
            jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2_InfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel_titleClinic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DocumentField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(name_userField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboxRoleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxStatusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2_Info, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDocumentActionPerformed

        ///buscar el usuario por documento
        String documentUser = searchDocument_field.getText().trim();
        if(!documentUser.isEmpty())
        {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.SearchUserDocument(documentUser,logUser.getId_clinic());
            if(user != null)
            {
                searchDocument_field.setText("");
                List<User> listUsers = new ArrayList<>();
                listUsers.add(user);
                loadUsersTable(userTable,listUsers);
            }else
            {
                JOptionPane.showMessageDialog(this,"Usuario no existe","ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        }else
        {
            JOptionPane.showMessageDialog(this,"Ingrese el documento", "CAMPOS VACÍOS", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchDocumentActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int idUser = Integer.parseInt(idUserField.getText().trim());

            User user = new User();
            user.setId_user(idUser);

            UserDAO userDAO = new UserDAO();
            String message = "¿Seguro que desea eliminar el usuario?";
            String title = "Confirmar eliminación";
            int confirm = utils.validation(message, title);
            if(confirm == 1)
            {
                boolean delete = userDAO.Delete(user, logUser);
                if(delete)
                {
                    JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.","CAMBIOS EXITOSOS",JOptionPane.INFORMATION_MESSAGE);
                    loadUsersByClinicandRole(logUser);
                    loadRolesStatus();
                    hideField(false);
                    //emptyFields();
                }else
                {
                    JOptionPane.showMessageDialog(this,"No fue posible eliminar el usuario.\n" +
                        "Puede que no pertenezca a su clínica o no exista", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
                }
            }
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario","ERORR",JOptionPane.ERROR_MESSAGE);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error al eliminar","ERROR ",JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        UsersMenu MenuManagerFrame = new UsersMenu(logUser);
        MenuManagerFrame.setVisible(true);
        MenuManagerFrame.pack();
        MenuManagerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        try {
            int idUser = Integer.parseInt(idUserField.getText().trim());
            Role r = (Role) cboxRoleEdit.getSelectedItem();
            Status s = (Status) cboxStatusEdit.getSelectedItem();

            User user = new User();
            user.setId_user(idUser);
            user.setUsername(usernameField.getText());
            user.setId_role(r.getId());   ///se actualizan los roles con el id
            user.setName_role(r.getName()); ///y el nombre en el combobox
            user.setId_status(s.getId());
            user.setName_status(s.getName());
            user.setName_user(name_userField.getText());
            user.setLast_name(LastNameField.getText());
            user.setDocument(DocumentField.getText());
            user.setEmail(EmailField.getText());
            user.setPhone(PhoneField.getText());
            user.setId_clinic(logUser.getId_clinic()); ///mismo id de clínica

            UserDAO userDAO = new UserDAO();

            ///validar campos obligatorios
            if(name_userField.getText().isEmpty()|| LastNameField.getText().isEmpty()||
                usernameField.getText().isEmpty()|| DocumentField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Complete los campos obligatorios *", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            }else
            {
                String message = "¿Desea confirmar la actualización?";
                String title = "Confirmación";
                int confirm = utils.validation(message, title);
                if(confirm==1){
                    boolean updated = userDAO.Update(user, logUser);
                    if (updated)
                    {
                        JOptionPane.showMessageDialog(this, "El usuario se ha actualizado correctamente","MODIFICACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);
                        cboxRole.getSelectedItem();
                        Nimbus.styleTable(userTable);
                        loadUsersByClinicandRole(logUser); // refrescar tabla
                        hideField(false);
                        //emptyFields();
                    } else
                    {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar el usuario. Verifica permisos o datos.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario","ERORR",JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
    private javax.swing.JTextField DocumentField;
    private javax.swing.JTextField EmailField;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSearchDocument;
    private javax.swing.JComboBox<Role> cboxRole;
    private javax.swing.JComboBox<Role> cboxRoleEdit;
    private javax.swing.JComboBox<Status> cboxStatusEdit;
    private javax.swing.JTextField idUserField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTitleClinic_users;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2_Info;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_titleClinic;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name_userField;
    private javax.swing.JTextField searchDocument_field;
    private javax.swing.JTable userTable;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
