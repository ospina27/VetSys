package project.vetsys.view.manager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import project.vetsys.dao.PetDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.Pet;
import project.vetsys.model.User;
import project.vetsys.view.Nimbus;
import project.vetsys.view.Utils;

public class SearchPet extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchPet.class.getName());
    private User logUser;
    private Utils utils;

    public SearchPet() {
            initComponents();
            initListeners();              
       }
    
    public SearchPet(User logUser){
        Nimbus.LookandFeel();
        initComponents();
        initListeners();
        setTitle("Gestion de mascotas");
        Nimbus.styleAllTextFields(this);
        Nimbus.styleTable(petTable);
        modelTable();
        noEditableFields();
        this.logUser = logUser;
        this.utils = new  Utils();
        loadAllPets(logUser);
        loadSpecies();
        emptyFiels();
        hideField(false);
        jLabelTitleClinic_pets.setText(logUser.getClinic().getName_clinic());
        Nimbus.styleAllLabelsExcept(this,jLabelTitleClinic_pets); 
    }
    
    private void initListeners(){
        petTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petTableMouseClicked(evt);
                }
        });
    }
    
    private void modelTable(){
        DefaultTableModel modelTable = new DefaultTableModel(new Object[]{"ID","Nombre Mascota","Propietario","Cedula Propietario"},0);
        petTable.setModel(modelTable);
        petTable.setModel(modelTable);
        petTable.setRowHeight(30); 
        petTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    private void emptyFiels(){
        idPet_Field.setText("");
        namePet_Field.setText("");
        bredPet_Field.setText("");
        colorPet_Field.setText("");
        sexPet_Field.setText("");
        nameOwner_field.setText("");
        documentOwner_field.setText("");
        emailOwner_field.setText("");
        phoneOwner_field.setText("");
        dateOfBirthPet_field.setText("");
        cboxSpecies_pet.setSelectedIndex(-1);
    }
    
    ///no dejar que los campos de texto del propietario 
    ///sexo y el ID de la mascota se puedan modificar
    private void noEditableFields(){
        nameOwner_field.setEditable(false);
        documentOwner_field.setEditable(false);
        emailOwner_field.setEditable(false);
        phoneOwner_field.setEditable(false);
        idPet_Field.setEditable(false);
        sexPet_Field.setEditable(false);
    }
    
     private void hideField(boolean active)
    {
        idPet_Field.setVisible(active);
        namePet_Field.setVisible(active);
        cboxSpecies_pet.setVisible(active);
        bredPet_Field.setVisible(active);
        colorPet_Field.setVisible(active);
        sexPet_Field.setVisible(active);
        dateOfBirthPet_field.setVisible(active);
        documentOwner_field.setVisible(active);
        nameOwner_field.setVisible(active);
        emailOwner_field.setVisible(active);
        phoneOwner_field.setVisible(active);
        
        namePet_lbl.setVisible(active);
        idPet_lbl.setVisible(active);
        nameOwner_lbl.setVisible(active);
        speciesPet_lbl.setVisible(active);
        bredPet_lbl.setVisible(active);
        colorPet_lbl.setVisible(active);
        sexPet_lbl.setVisible(active);
        dateBirthPet_lbl.setVisible(active);
        documentOwner_lbl.setVisible(active);
        nameOwner_lbl.setVisible(active);
        emailOwner_lbl.setVisible(active);
        phoneOwner_lbl.setVisible(active);
    }
    
  
    private void loadPetTable(JTable table, List<Pet> listPets) {
  
        DefaultTableModel model = new DefaultTableModel() {
        @Override
            public boolean isCellEditable(int row, int column){
                return false; // La tabla no permite edición
            }
        };
        model.addColumn("ID");
        model.addColumn("Nombre mascota");
        model.addColumn("Propietario");
        model.addColumn("Cedula Propietario");

        for (Pet pet : listPets) {
            model.addRow(new Object[]{
                pet.getId_pet(),
                pet.getName_Pet(),
                pet.getClient().getNombres(),
                pet.getClient().getDocumento()
            });
        }
        table.setModel(model);
        
    }
    
    public void loadAllPets(User logUser){
        PetDAO petDAO = new PetDAO();
        List<Pet> pets = petDAO.ReadAllPets(logUser);
        loadPetTable(petTable, petDAO.ReadAllPets(logUser));
    }
    
    
    private void updateTableSelect(Pet pet) {

        int selectedRow = petTable.getSelectedRow();
        if (selectedRow == -1) {
            return; // No hay selección
        }
        DefaultTableModel model = (DefaultTableModel) petTable.getModel();
        model.setValueAt(pet.getId_pet(), selectedRow, 0);
        model.setValueAt(pet.getName_Pet(), selectedRow, 1);
        // Mantener la fila seleccionada
        petTable.setRowSelectionInterval(selectedRow, selectedRow);
    }

    
    
    
    ///cargar especies al cbox para filtrar
    private void loadSpecies (){
        List<String> listSpecies = new ArrayList<>();
        listSpecies.add("Canino");
        listSpecies.add("Felino");
        listSpecies.add("Equino");
        utils.fillComboBox(cboxSpecies_pet, listSpecies,"");
    }
    
    private void petTableMouseClicked(java.awt.event.MouseEvent evt){
        
        int selectedRow = petTable.getSelectedRow();
        if(selectedRow>=0){
            int idPet =Integer.parseInt(petTable.getValueAt(selectedRow, 0).toString());
            
            PetDAO petDao = new PetDAO();
            Pet pet = petDao.ReadId(idPet);            
                    
            if(pet != null){
                hideField(true);
                idPet_Field.setText(String.valueOf(pet.getId_pet()));
                namePet_Field.setText(pet.getName_Pet());
                for(int i= 0;i < cboxSpecies_pet.getItemCount(); i++){
                    String s = (String)cboxSpecies_pet.getItemAt(i);
                    if(s.equalsIgnoreCase(pet.getSpecies())){
                        cboxSpecies_pet.setSelectedIndex(i);
                        break;
                    }
                }
                bredPet_Field.setText(pet.getBred());
                colorPet_Field.setText(pet.getColor());
                sexPet_Field.setText(pet.getSex());
                dateOfBirthPet_field.setText(String.valueOf(pet.getDate_of_birth()));
      
                documentOwner_field.setText(pet.getClient().getDocumento());
                nameOwner_field.setText(pet.getClient().getNombres() + pet.getClient().getApellidos());
                emailOwner_field.setText(pet.getClient().getCorreo());
                phoneOwner_field.setText(pet.getClient().getTelefono());
            }
               
        }    
        
    }   
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        namePet_lbl = new javax.swing.JLabel();
        namePet_Field = new javax.swing.JTextField();
        speciesPet_lbl = new javax.swing.JLabel();
        bredPet_lbl = new javax.swing.JLabel();
        sexPet_Field = new javax.swing.JTextField();
        dateOfBirthPet_field = new javax.swing.JTextField();
        colorPet_Field = new javax.swing.JTextField();
        sexPet_lbl = new javax.swing.JLabel();
        dateBirthPet_lbl = new javax.swing.JLabel();
        bredPet_Field = new javax.swing.JTextField();
        colorPet_lbl = new javax.swing.JLabel();
        idPet_Field = new javax.swing.JTextField();
        idPet_lbl = new javax.swing.JLabel();
        documentOwner_field = new javax.swing.JTextField();
        documentOwner_lbl = new javax.swing.JLabel();
        nameOwner_field = new javax.swing.JTextField();
        nameOwner_lbl = new javax.swing.JLabel();
        phoneOwner_field = new javax.swing.JTextField();
        phoneOwner_lbl = new javax.swing.JLabel();
        emailOwner_field = new javax.swing.JTextField();
        emailOwner_lbl = new javax.swing.JLabel();
        cboxSpecies_pet = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        petTable = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        searchDocumentClient_field = new javax.swing.JTextField();
        btnSearchDocumet_client = new javax.swing.JButton();
        btnSearchDocumet_client1 = new javax.swing.JButton();
        jPanel_titleClinic = new javax.swing.JPanel();
        jLabelTitleClinic_pets = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 600));

        namePet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        namePet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        namePet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namePet_lbl.setText("Nombre");

        namePet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        speciesPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        speciesPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        speciesPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        speciesPet_lbl.setText("Especie");

        bredPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        bredPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        bredPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bredPet_lbl.setText("Raza");

        sexPet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        dateOfBirthPet_field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        colorPet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        sexPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        sexPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        sexPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sexPet_lbl.setText("Sexo");

        dateBirthPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        dateBirthPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        dateBirthPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateBirthPet_lbl.setText(" Fecha de nacimiento yyyy-mm-dd");

        bredPet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        colorPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        colorPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        colorPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorPet_lbl.setText("Color");

        idPet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        idPet_Field.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        idPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        idPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        idPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idPet_lbl.setText("ID");

        documentOwner_field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        documentOwner_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        documentOwner_lbl.setForeground(new java.awt.Color(255, 255, 255));
        documentOwner_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        documentOwner_lbl.setText("Documento del propietario");

        nameOwner_field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        nameOwner_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        nameOwner_lbl.setForeground(new java.awt.Color(255, 255, 255));
        nameOwner_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameOwner_lbl.setText("Propietario");

        phoneOwner_field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        phoneOwner_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        phoneOwner_lbl.setForeground(new java.awt.Color(255, 255, 255));
        phoneOwner_lbl.setText("Telefono");

        emailOwner_field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        emailOwner_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        emailOwner_lbl.setForeground(new java.awt.Color(255, 255, 255));
        emailOwner_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailOwner_lbl.setText("Correo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(dateOfBirthPet_field, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameOwner_lbl)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(phoneOwner_lbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                    .addComponent(phoneOwner_field, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(documentOwner_lbl, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(documentOwner_field, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameOwner_field, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailOwner_field, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(namePet_lbl)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(21, 21, 21)
                                                    .addComponent(idPet_lbl)))
                                            .addGap(48, 48, 48))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(bredPet_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(speciesPet_lbl)
                                                .addComponent(colorPet_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(35, 35, 35)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bredPet_Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                        .addComponent(colorPet_Field, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sexPet_Field, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cboxSpecies_pet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(namePet_Field)))))
                            .addComponent(emailOwner_lbl))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(sexPet_lbl))
                        .addComponent(dateBirthPet_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPet_lbl)
                    .addComponent(idPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namePet_lbl)
                    .addComponent(namePet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speciesPet_lbl)
                    .addComponent(cboxSpecies_pet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bredPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bredPet_lbl))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorPet_lbl)
                    .addComponent(colorPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexPet_lbl)
                    .addComponent(sexPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(dateBirthPet_lbl)
                .addGap(2, 2, 2)
                .addComponent(dateOfBirthPet_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(documentOwner_lbl)
                .addGap(12, 12, 12)
                .addComponent(documentOwner_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameOwner_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameOwner_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailOwner_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailOwner_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneOwner_lbl)
                    .addComponent(phoneOwner_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAutoscrolls(true);
        jPanel3.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 800));

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        petTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane2.setViewportView(petTable);

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

        jLabel13.setText("Ingrese documento");

        btnSearchDocumet_client.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSearchDocumet_client.setForeground(new java.awt.Color(0, 102, 102));
        btnSearchDocumet_client.setText("Buscar");
        btnSearchDocumet_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDocumet_clientActionPerformed(evt);
            }
        });

        btnSearchDocumet_client1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSearchDocumet_client1.setForeground(new java.awt.Color(0, 102, 102));
        btnSearchDocumet_client1.setText("Refrescar");
        btnSearchDocumet_client1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDocumet_client1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(12, 12, 12)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnSearchDocumet_client1)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(searchDocumentClient_field)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchDocumet_client)
                                .addGap(24, 24, 24)))))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(searchDocumentClient_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchDocumet_client1))
                    .addComponent(btnSearchDocumet_client))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir)
                    .addComponent(btnDelete))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel_titleClinic.setBackground(new java.awt.Color(0, 102, 102));

        jLabelTitleClinic_pets.setFont(new java.awt.Font("Bookman Old Style", 3, 24)); // NOI18N
        jLabelTitleClinic_pets.setForeground(java.awt.SystemColor.activeCaption);
        jLabelTitleClinic_pets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitleClinic_pets.setToolTipText("");

        javax.swing.GroupLayout jPanel_titleClinicLayout = new javax.swing.GroupLayout(jPanel_titleClinic);
        jPanel_titleClinic.setLayout(jPanel_titleClinicLayout);
        jPanel_titleClinicLayout.setHorizontalGroup(
            jPanel_titleClinicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitleClinic_pets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_titleClinicLayout.setVerticalGroup(
            jPanel_titleClinicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitleClinic_pets, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_titleClinic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_titleClinic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        try{
            int idPet = Integer.parseInt(idPet_Field.getText().trim());
            Pet pet = new Pet();
            String species = (String) cboxSpecies_pet.getSelectedItem(); ///asignar el texto del cbox de especie
            pet.setId_Client(pet.getId_Client());
            pet.setId_Clinic(logUser.getId_clinic());
            pet.setId_pet(idPet);
            pet.setName_Pet(namePet_Field.getText());
            pet.setSpecies(species);
            pet.setBred(bredPet_Field.getText());
            pet.setColor(colorPet_Field.getText());
            pet.setSex(sexPet_Field.getText());
            String dateText = dateOfBirthPet_field.getText();
            try {
                Date date = Date.valueOf(dateText);  // convierte si el formato es válido
                pet.setDate_of_birth(date);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this,
                    "Formato de fecha incorrecto.\n Debe ser YYYY-MM-DD",
                    logUser.getClinic().getName_clinic(),
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            PetDAO petDAO = new PetDAO();
            if(namePet_Field.getText().isEmpty() || bredPet_Field.getText().isEmpty()|| species.isEmpty()
                    || colorPet_Field.getText().isEmpty()|| sexPet_Field.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Complete los campos obligatorios *",logUser.getClinic().getName_clinic(), JOptionPane.WARNING_MESSAGE);
            }else {                
                String message = "¿Desea confirmar la actualización?";
                String title = "CONFIRMACIÓN";
                if(utils.validation(message, title)==1){
                    boolean updatePet = petDAO.Update(pet, logUser);
                    if(updatePet){
                        JOptionPane.showMessageDialog(this, "La mascota se ha actualizado correctamente",logUser.getClinic().getName_clinic(),
                                JOptionPane.INFORMATION_MESSAGE);
                        Nimbus.styleTable(petTable);
                        Pet newPet = petDAO.ReadId(idPet);
                        updateTableSelect(newPet);
                        emptyFiels();
                        hideField(false);
                    }else{
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar la mascota\nVerifica los datos",
                                logUser.getClinic().getName_clinic() , JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Seleccione una mascota",logUser.getClinic().getName_clinic(),JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error al actualizar", logUser.getClinic().getName_clinic(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
         
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        PatientsMenu patientsMenuFrame = new PatientsMenu(logUser);
        patientsMenuFrame.setVisible(true);
        patientsMenuFrame.pack();
        patientsMenuFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int idPet = Integer.parseInt(idPet_Field.getText().trim());
            Pet pet = new Pet();
            pet.setId_pet(idPet);
            
            PetDAO petDAO = new PetDAO();
            String message = "¿Seguro que desea eliminar la mascota?";
            String title = "Confirmar eliminación";
            if(utils.validation(message, title)==1)
            {
                boolean deletePet = petDAO.Delete(pet, logUser);
                if(deletePet){
                    JOptionPane.showMessageDialog(this, "Mascota eliminada correctamente.","CAMBIOS EXITOSOS",JOptionPane.INFORMATION_MESSAGE);
                    loadAllPets(logUser);
                    emptyFiels();
                    hideField(false);                    
                }else
                {
                    JOptionPane.showMessageDialog(this,"No fue posible eliminar la mascota.\n" +
                        "Puede que no pertenezca a su clínica o no exista",logUser.getClinic().getName_clinic(),
                        JOptionPane.WARNING_MESSAGE);
                    
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione una mascota",
                    logUser.getClinic().getName_clinic(),JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Error al eliminar",logUser.getClinic().getName_clinic(),JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void btnSearchDocumet_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDocumet_clientActionPerformed
        
        String documentClient = searchDocumentClient_field.getText();
        if(documentClient.isEmpty()){
            JOptionPane.showMessageDialog(this,"Por favor ingrese el documento del cliente"
                    + "", "CAMPOS VACÍOS", JOptionPane.WARNING_MESSAGE);
            loadAllPets(logUser);
            hideField(false);
            emptyFiels();
            return;
        }
        PetDAO petDAO = new PetDAO();
        int idClient = petDAO.searchIdOwner(documentClient);
        if(idClient == -1){
            JOptionPane.showMessageDialog(this,"Cliente no registrado",logUser.getClinic().getName_clinic(),
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Pet> pets = petDAO.ReadForClient(idClient, logUser);
        if(pets.isEmpty()){
            JOptionPane.showMessageDialog(this,"El cliente "+documentClient+" no tiene mascotas registradas en "
                    +logUser.getClinic().getName_clinic(),logUser.getClinic().getName_clinic() ,JOptionPane.INFORMATION_MESSAGE);
        }
        loadPetTable(petTable, pets);
    }//GEN-LAST:event_btnSearchDocumet_clientActionPerformed

    private void btnSearchDocumet_client1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDocumet_client1ActionPerformed
        loadAllPets(logUser);
        hideField(false);
    }//GEN-LAST:event_btnSearchDocumet_client1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new SearchPet().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bredPet_Field;
    private javax.swing.JLabel bredPet_lbl;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSearchDocumet_client;
    private javax.swing.JButton btnSearchDocumet_client1;
    private javax.swing.JComboBox cboxSpecies_pet;
    private javax.swing.JTextField colorPet_Field;
    private javax.swing.JLabel colorPet_lbl;
    private javax.swing.JLabel dateBirthPet_lbl;
    private javax.swing.JTextField dateOfBirthPet_field;
    private javax.swing.JTextField documentOwner_field;
    private javax.swing.JLabel documentOwner_lbl;
    private javax.swing.JTextField emailOwner_field;
    private javax.swing.JLabel emailOwner_lbl;
    private javax.swing.JTextField idPet_Field;
    private javax.swing.JLabel idPet_lbl;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabelTitleClinic_pets;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_titleClinic;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameOwner_field;
    private javax.swing.JLabel nameOwner_lbl;
    private javax.swing.JTextField namePet_Field;
    private javax.swing.JLabel namePet_lbl;
    private javax.swing.JTable petTable;
    private javax.swing.JTextField phoneOwner_field;
    private javax.swing.JLabel phoneOwner_lbl;
    private javax.swing.JTextField searchDocumentClient_field;
    private javax.swing.JTextField sexPet_Field;
    private javax.swing.JLabel sexPet_lbl;
    private javax.swing.JLabel speciesPet_lbl;
    // End of variables declaration//GEN-END:variables
}
