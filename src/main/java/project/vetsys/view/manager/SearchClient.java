/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.vetsys.view.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import project.vetsys.view.manager.CreateUser;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.vetsys.dao.ClienteDAO;
import project.vetsys.database.DBConnection;
import project.vetsys.model.ClienteModel;
import project.vetsys.model.User;
import project.vetsys.view.Nimbus;
import project.vetsys.utils.ValidationInput;
import project.vetsys.utils.Utils;

/**
 *
 * @author San
 */
public class SearchClient extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchClient.class.getName());
    private User logUser; //user que inicio sesion
    private ClienteDAO clienteDAO = new ClienteDAO();
    private DefaultTableModel modeloTabla;
    private Utils utils;

    /**
     * Creates new form SearchUser
     * @param logUser
     */
    
    // Constructor que recibe el usuario logueado
    public SearchClient(User logUser) {
        Nimbus.LookandFeel();
        this.logUser = logUser;
        utils = new Utils();
        initComponents();
        aplicarAccesibilidad();
        configurarTabla();
        cargarClientes();
        cargarMembresias();
        Nimbus.styleAllTextFields(this);
       
        Nimbus.styleTitleLabel(jLabel4);
        Nimbus.styleAllLabelsExcept(this, jLabel4);
        jLabel4.setText(obtenerNombreClinica(logUser.getId_clinic()));
        Nimbus.styleTable(tablaClientes);
        
        //validacion del rol, para que no pueda modificar clientes si no es administrador
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role())){
            btnActualizar.setVisible(false);
            btnEliminar.setVisible(false);
        } 
        setTitle("Gestión de Clientes");
        //txtClinica.setEditable(false); ///no editar la clinica
                
        System.out.println("Usuario logueado recibido: " + logUser.getUsername()); //prueba en consola
        
        ValidationInput.numbers(txtDocumentoIngresado);
        ValidationInput.numbers(txtDocumento);
        
    }

    // Constructor sin parámetros 
    public SearchClient() {
        initComponents();
        aplicarAccesibilidad();
        configurarTabla();
        cargarClientes();
        cargarMembresias();
        //txtClinica.setText(obtenerNombreClinica(logUser.getId_clinic()));
    }
    
    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(new Object[]{"Id","Nombres", "Apellidos", "Documento", "Teléfono", "Correo", "Dirección", "Membresía","Inicio", "Fin"}, 0);
        tablaClientes.setModel(modeloTabla);
        // Ocultar las columnas 8 y 9
        tablaClientes.getColumnModel().getColumn(8).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(8).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(8).setWidth(0);

        tablaClientes.getColumnModel().getColumn(9).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(9).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(9).setWidth(0);
    }
    
    // Obtener nombre de la clinica usuario logueado
    private String obtenerNombreClinica(int idClinica) {
        String nombre = "";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT nombre FROM clinica WHERE id_clinica = ?")) {
            stmt.setInt(1, idClinica);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) nombre = rs.getString("nombre");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error obteniendo clínica: " + e.getMessage());
        }
        return nombre;
    }
    
    private void cargarMembresias() {
        cmboxMembresias.removeAllItems();
        cmboxMembresias.addItem("Sin membresía");
        
        String sql = "SELECT id_membresia, nombre FROM membresia WHERE id_clinica = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, logUser.getId_clinic());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_membresia");
                String nombre = rs.getString("nombre");
                cmboxMembresias.addItem(id + " - " + nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error cargando membresías: " + e.getMessage());
        }
    }
    
    private void cargarClientes() {
        modeloTabla.setRowCount(0);
        List<ClienteModel> listaClientes = clienteDAO.listarClientes(logUser.getId_clinic());
        for (ClienteModel cliente : listaClientes) {
            modeloTabla.addRow(new Object[]{
               
                cliente.getIdCliente(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getDocumento(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getDireccion(),
                cliente.getNombreMembresia() != null ? cliente.getNombreMembresia() : "Sin membresía",
                cliente.getFechaInicio(),
                cliente.getFechaVigencia()}
            );
        }
    }
    
    // Buscar por documento
    private void buscarPorDocumento(String doc) {
        
        ClienteModel cliente = clienteDAO.buscarClientesPorDocumento(doc, logUser.getId_clinic());
        modeloTabla.setRowCount(0);
        if (cliente != null) {
            txtDocumentoIngresado.setText("");
            modeloTabla.addRow(new Object[]{
                cliente.getIdCliente(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getDocumento(),
                cliente.getTelefono(),
                cliente.getCorreo(), 
                cliente.getDireccion(),
                cliente.getNombreMembresia() != null ? cliente.getNombreMembresia() : "Sin membresía",
                cliente.getFechaInicio(), 
                cliente.getFechaVigencia()
            });
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            cargarClientes();
        }
    }
    
    private void limpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        cmboxMembresias.setSelectedIndex(0);
        jDateChooserFechaInicio.setDate(null);
        jDateChooserFechaFin.setDate(null);
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cmboxMembresias = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        lbl_IdCliente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtDocumentoIngresado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnConsultaCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 600));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidos.setBorder(null);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        txtNombres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombres.setBorder(null);
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos");

        txtDocumento.setEditable(false);
        txtDocumento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDocumento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDocumento.setBorder(null);
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefono.setBorder(null);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Documento");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Telefono");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dirección");

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCorreo.setBorder(null);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Membresía");

        cmboxMembresias.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmboxMembresias.setBorder(null);
        cmboxMembresias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxMembresiasActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha inicio");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha fin");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Correo");

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDireccion.setBorder(null);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Id");

        lbl_IdCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_IdCliente.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_IdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17)
                        .addComponent(jLabel16)
                        .addComponent(jLabel15)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)
                        .addComponent(jLabel10)
                        .addComponent(jLabel3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmboxMembresias, javax.swing.GroupLayout.Alignment.LEADING, 0, 187, Short.MAX_VALUE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(198, 198, 198)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(lbl_IdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmboxMembresias, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 230, 600);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAutoscrolls(true);
        jPanel3.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 800));

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 102, 102));
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Atrás");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 102, 102));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese el número de documento");

        tablaClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        btnConsultaCliente.setBackground(new java.awt.Color(0, 102, 102));
        btnConsultaCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnConsultaCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultaCliente.setText("Buscar");
        btnConsultaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDocumentoIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocumentoIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(230, 0, 570, 800);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            ClienteModel cliente = new ClienteModel();
            cliente.setIdCliente(Integer.parseInt(lbl_IdCliente.getText()));
            cliente.setNombres(txtNombres.getText());
            cliente.setApellidos(txtApellidos.getText());
            cliente.setDocumento(txtDocumento.getText());
            cliente.setTelefono(txtTelefono.getText());
            cliente.setCorreo(txtCorreo.getText());
            cliente.setDireccion(txtDireccion.getText());  
            
            String item = (String) cmboxMembresias.getSelectedItem();
            Integer idMembresia = null;
            
            if (item != null && item.contains(" - ")) {
                int idSel = Integer.parseInt(item.split(" - ")[0]);
                if (idSel != 0) { 
                    idMembresia = idSel;
                }
            } 
            cliente.setIdMembresia(idMembresia);
            
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
                String inicioStr = new SimpleDateFormat("yyyy-MM-dd").format(fechaInicio);
                String finStr = new SimpleDateFormat("yyyy-MM-dd").format(fechaFin);

                cliente.setFechaInicio(inicioStr);
                cliente.setFechaVigencia(finStr);
                cliente.setEstadoMembresia(1);
            } else {
                cliente.setFechaInicio(null);
                cliente.setFechaVigencia(null);
                cliente.setEstadoMembresia(0);
            }
            
            ///Validación del formato de correo
            if (!utils.validationEmail(txtCorreo, this, logUser.getClinic().getName_clinic())) {
                return;
            }
            
            boolean actualizado = clienteDAO.actualizarCliente(cliente);
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.");
                cargarClientes();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar cliente.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        PatientsMenu MenuPatientsFrame = new PatientsMenu(logUser);
        MenuPatientsFrame.setVisible(true);
        MenuPatientsFrame.pack();
        MenuPatientsFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int id = Integer.parseInt(lbl_IdCliente.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean eliminado = clienteDAO.eliminarCliente(id);
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Cliente eliminado.");
                    cargarClientes();
                    limpiarCampos();
                }else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, 
            "Error: " + e.getMessage());
            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaClienteActionPerformed
        String documento = txtDocumentoIngresado.getText().trim();
        System.out.println("Documento ingresado: '" + documento + "'");

        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de documento.");
            return;
        }
        buscarPorDocumento(documento);
    }//GEN-LAST:event_btnConsultaClienteActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void cmboxMembresiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxMembresiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxMembresiasActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int fila = tablaClientes.getSelectedRow();
        if (fila >= 0) {
            
            try {
                lbl_IdCliente.setText(modeloTabla.getValueAt(fila, 0).toString());
                //txtIdCliente.setEditable(false); 
                txtNombres.setText(modeloTabla.getValueAt(fila, 1).toString());
                txtApellidos.setText(modeloTabla.getValueAt(fila, 2).toString());
                txtDocumento.setText(modeloTabla.getValueAt(fila, 3).toString());
                txtDocumento.setEditable(false); 
                txtTelefono.setText(modeloTabla.getValueAt(fila, 4).toString());
                txtCorreo.setText(modeloTabla.getValueAt(fila, 5).toString());
                txtDireccion.setText(modeloTabla.getValueAt(fila, 6).toString());
                
                // --- Membresía ---
                Object nombreMembresiaObj = modeloTabla.getValueAt(fila, 7);
                String nombreMembresia = (nombreMembresiaObj != null) ? nombreMembresiaObj.toString() : "";

                if (nombreMembresia.equalsIgnoreCase("Sin membresía") || nombreMembresia.isEmpty()) {
                    cmboxMembresias.setSelectedIndex(0); 
                } else {
                    // Buscar membresia por nombre
                    for (int i = 0; i < cmboxMembresias.getItemCount(); i++) {
                        String item = cmboxMembresias.getItemAt(i);
                        if (item.contains(nombreMembresia)) {
                            cmboxMembresias.setSelectedIndex(i);
                            break;
                        }
                    }
                }
                
                Object fechaInicioObj = modeloTabla.getValueAt(fila, 8);
                Object fechaFinObj = modeloTabla.getValueAt(fila, 9);

                if (fechaInicioObj != null && !fechaInicioObj.toString().isEmpty()) {
                    Date fechaInicio = java.sql.Date.valueOf(fechaInicioObj.toString());
                    jDateChooserFechaInicio.setDate(fechaInicio);
                } else {
                    jDateChooserFechaInicio.setDate(null);
                }

                if (fechaFinObj != null && !fechaFinObj.toString().isEmpty()) {
                    Date fechaFin = java.sql.Date.valueOf(fechaFinObj.toString());
                    jDateChooserFechaFin.setDate(fechaFin);
                } else {
                    jDateChooserFechaFin.setDate(null);
                }

            } catch (Exception e) {
                System.out.println("Error al seleccionar cliente: " + e.getMessage());
            }
                
        } 
    }//GEN-LAST:event_tablaClientesMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new SearchClient().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConsultaCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmboxMembresias;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFin;
    private com.toedter.calendar.JDateChooser jDateChooserFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_IdCliente;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtDocumentoIngresado;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void aplicarAccesibilidad() {

    // --- PANEL PRINCIPAL ---
    jPanel1.setFocusable(true);
    jPanel2.setFocusable(true);
    jPanel3.setFocusable(true);
    // --- CAMPOS DE INFORMACIÓN DEL CLIENTE ---
    //txtClinica.getAccessibleContext().setAccessibleName("Nombre de la clínica");
    //txtClinica.getAccessibleContext().setAccessibleDescription("Nombre de la clínica asociada al usuario");
    //txtClinica.setToolTipText("Nombre de la clínica");
 
    //txtIdCliente.getAccessibleContext().setAccessibleName("ID del cliente");
    //txtIdCliente.getAccessibleContext().setAccessibleDescription("Identificador único del cliente");
    //txtIdCliente.setToolTipText("ID del cliente (Alt+I)");
    //txtIdCliente.setNextFocusableComponent(txtNombres);

    txtNombres.getAccessibleContext().setAccessibleName("Campo Nombres");
    txtNombres.getAccessibleContext().setAccessibleDescription("Ingrese los nombres del cliente");
    txtNombres.setToolTipText("Nombres del cliente (Alt+N)");
    txtNombres.setNextFocusableComponent(txtApellidos);

    txtApellidos.getAccessibleContext().setAccessibleName("Campo Apellidos");
    txtApellidos.getAccessibleContext().setAccessibleDescription("Ingrese los apellidos del cliente");
    txtApellidos.setToolTipText("Apellidos del cliente (Alt+A)");
    txtApellidos.setNextFocusableComponent(txtDocumento);

    txtDocumento.getAccessibleContext().setAccessibleName("Documento del cliente");
    txtDocumento.getAccessibleContext().setAccessibleDescription("Número de documento del cliente");
    txtDocumento.setToolTipText("Documento del cliente (Alt+D)");
    txtDocumento.setNextFocusableComponent(txtTelefono);

    txtTelefono.getAccessibleContext().setAccessibleName("Teléfono del cliente");
    txtTelefono.getAccessibleContext().setAccessibleDescription("Ingrese el teléfono del cliente");
    txtTelefono.setToolTipText("Teléfono del cliente (Alt+T)");
    txtTelefono.setNextFocusableComponent(txtCorreo);

    txtCorreo.getAccessibleContext().setAccessibleName("Correo del cliente");
    txtCorreo.getAccessibleContext().setAccessibleDescription("Ingrese el correo electrónico del cliente");
    txtCorreo.setToolTipText("Correo del cliente (Alt+O)");
    txtCorreo.setNextFocusableComponent(txtDireccion);

    txtDireccion.getAccessibleContext().setAccessibleName("Dirección del cliente");
    txtDireccion.getAccessibleContext().setAccessibleDescription("Ingrese la dirección del cliente");
    txtDireccion.setToolTipText("Dirección del cliente (Alt+R)");
    txtDireccion.setNextFocusableComponent(cmboxMembresias);

    // --- COMBOBOX MEMBRESÍAS ---
    cmboxMembresias.getAccessibleContext().setAccessibleName("Membresía");
    cmboxMembresias.getAccessibleContext().setAccessibleDescription("Seleccione la membresía del cliente");
    cmboxMembresias.setToolTipText("Seleccionar membresía (Alt+M)");
    cmboxMembresias.setNextFocusableComponent(jDateChooserFechaInicio);

    jDateChooserFechaInicio.getAccessibleContext().setAccessibleName("Fecha inicio membresía");
    jDateChooserFechaInicio.getAccessibleContext().setAccessibleDescription("Fecha de inicio de la membresía");
    jDateChooserFechaInicio.setToolTipText("Fecha inicio (yyyy/mm/dd) (Alt+F)");
    jDateChooserFechaInicio.setNextFocusableComponent(jDateChooserFechaFin);

    jDateChooserFechaFin.getAccessibleContext().setAccessibleName("Fecha fin membresía");
    jDateChooserFechaFin.getAccessibleContext().setAccessibleDescription("Fecha de finalización de la membresía");
    jDateChooserFechaFin.setToolTipText("Fecha fin (yyyy/mm/dd) (Alt+G)");
    jDateChooserFechaFin.setNextFocusableComponent(txtDocumentoIngresado);

    // --- CAMPO BÚSQUEDA ---
    txtDocumentoIngresado.getAccessibleContext().setAccessibleName("Documento a buscar");
    txtDocumentoIngresado.getAccessibleContext().setAccessibleDescription("Ingrese el número de documento del cliente a buscar");
    txtDocumentoIngresado.setToolTipText("Número de documento del cliente (Alt+B)");
    txtDocumentoIngresado.setNextFocusableComponent(btnConsultaCliente);

    // --- BOTONES ---
    btnConsultaCliente.getAccessibleContext().setAccessibleName("Buscar cliente");
    btnConsultaCliente.getAccessibleContext().setAccessibleDescription("Buscar cliente por documento");
    btnConsultaCliente.setToolTipText("Buscar cliente (Alt+B)");
    btnConsultaCliente.setMnemonic('B');
    btnConsultaCliente.setNextFocusableComponent(btnActualizar);

    btnActualizar.getAccessibleContext().setAccessibleName("Actualizar cliente");
    btnActualizar.getAccessibleContext().setAccessibleDescription("Actualizar los datos del cliente seleccionado");
    btnActualizar.setToolTipText("Actualizar cliente (Alt+U)");
    btnActualizar.setMnemonic('U');
    btnActualizar.setNextFocusableComponent(btnEliminar);

    btnEliminar.getAccessibleContext().setAccessibleName("Eliminar cliente");
    btnEliminar.getAccessibleContext().setAccessibleDescription("Eliminar el cliente seleccionado");
    btnEliminar.setToolTipText("Eliminar cliente (Alt+E)");
    btnEliminar.setMnemonic('E');
    btnEliminar.setNextFocusableComponent(btnSalir);

    btnSalir.getAccessibleContext().setAccessibleName("Atrás");
    btnSalir.getAccessibleContext().setAccessibleDescription("Volver al menú anterior");
    btnSalir.setToolTipText("Atrás (Alt+S)");
    btnSalir.setMnemonic('S');

    // --- TABLA ---
    tablaClientes.getAccessibleContext().setAccessibleName("Tabla de clientes");
    tablaClientes.getAccessibleContext().setAccessibleDescription("Listado de clientes con sus datos");

    // --- ATAJOS GLOBALES ALT ---
    getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_buscar");
    getRootPane().getActionMap().put("accion_buscar", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnConsultaCliente.doClick();
        }
    });

    getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_actualizar");
    getRootPane().getActionMap().put("accion_actualizar", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnActualizar.doClick();
        }
    });

    getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_eliminar");
    getRootPane().getActionMap().put("accion_eliminar", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnEliminar.doClick();
        }
    });

    getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_salir");
    getRootPane().getActionMap().put("accion_salir", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            btnSalir.doClick();
        }
    });
}


}
