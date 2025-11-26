package project.vetsys.view.manager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import project.vetsys.dao.PetDAO;
import project.vetsys.model.Pet;
import project.vetsys.model.User;
import project.vetsys.utils.ValidationInput;
import project.vetsys.view.Nimbus;
import project.vetsys.utils.Utils;

public class SearchPet extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchPet.class.getName());
    private User logUser;
    private Utils utils;
    private CreatePet searchPet;  ///objeto de la vista create, para traer metodos que se reutilizan

    public SearchPet() {
            initComponents();
            aplicarAccesibilidad();
            initListeners();              
       }
    
    public SearchPet(User logUser){
        Nimbus.LookandFeel();
        initComponents();
        aplicarAccesibilidad();
        initListeners();
        setTitle(logUser.getClinic().getName_clinic());
        Nimbus.styleAllTextFields(this);
        Nimbus.styleTable(petTable);
        modelTable();
        noEditableFields();
        this.logUser = logUser;
        this.utils = new  Utils();
        this.searchPet = new CreatePet(logUser);
        loadAllPets(logUser);
        searchPet.loadSpecies(cboxSpecies_pet, cboxBred_pet);
        emptyFiels();
        hideField(false);
        jLabelTitleClinic_pets.setText(logUser.getClinic().getName_clinic());
        Nimbus.styleAllLabelsExcept(this,jLabelTitleClinic_pets); 
        setTitle("Gestión de Mascotas");
        
        ValidationInput.numbers(searchDocumentClient_field);
        ValidationInput.numbers(documentOwner_field);
    }
    
    private void initListeners(){
        petTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petTableMouseClicked(evt);
                }
        });
        
        cboxSpecies_pet.addActionListener(evt -> searchPet.speciesSelected(cboxSpecies_pet,cboxBred_pet));
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
        cboxBred_pet.setSelectedIndex(-1);
        colorPet_Field.setText("");
        sexPet_Field.setText("");
        nameOwner_field.setText("");
        documentOwner_field.setText("");
        jDateChooserFecha.setDate(null);
        cboxSpecies_pet.setSelectedIndex(-1);
    }
    
    ///no dejar que los campos de texto del propietario 
    ///sexo y el ID de la mascota se puedan modificar
    private void noEditableFields(){
        nameOwner_field.setEditable(false);
        documentOwner_field.setEditable(false);
        idPet_Field.setEditable(false);
        sexPet_Field.setEditable(false);
    }
    
     private void hideField(boolean active) {
        ///sub paneles para mostrar la información
        jDesktopPane1.setVisible(active);
        jDesktopPane2.setVisible(active);
        jDesktopPane4.setVisible(active);
        
        idPet_Field.setVisible(active);
        namePet_Field.setVisible(active);
        cboxSpecies_pet.setVisible(active);
        cboxBred_pet.setVisible(active);
        colorPet_Field.setVisible(active);
        sexPet_Field.setVisible(active);
        jDateChooserFecha.setVisible(active);
        documentOwner_field.setVisible(active);
        nameOwner_field.setVisible(active);
        OwnerTitle_petLbl.setVisible(active);
        
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
            ///mostrar toda la información de la amscota seleccionada
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
                searchPet.speciesSelected(cboxSpecies_pet,cboxBred_pet);
                for(int i= 0;i < cboxBred_pet.getItemCount(); i++){
                    String s = (String)cboxBred_pet.getItemAt(i);
                    if(s.equalsIgnoreCase(pet.getBred())){
                        cboxBred_pet.setSelectedIndex(i);
                        break;
                    }
                }
                colorPet_Field.setText(pet.getColor());
                sexPet_Field.setText(pet.getSex());
                java.sql.Date sqlDate = pet.getDate_of_birth();
                if (sqlDate != null) {
                    jDateChooserFecha.setDate(new java.util.Date(sqlDate.getTime()));
                } else {
                    jDateChooserFecha.setDate(null);
                }
                ///mostrar la información del propietario
                documentOwner_field.setText(pet.getClient().getDocumento());
                nameOwner_field.setText(pet.getClient().getNombres() + pet.getClient().getApellidos());
            }    
        }    
    }   
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        petTable = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        searchDocumentClient_field = new javax.swing.JTextField();
        btnSearchDocumet_client = new javax.swing.JButton();
        btnRefreshTable_pet = new javax.swing.JButton();
        jLabelTitleClinic_pets = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        speciesPet_lbl = new javax.swing.JLabel();
        idPet_Field = new javax.swing.JTextField();
        cboxSpecies_pet = new javax.swing.JComboBox();
        bredPet_lbl = new javax.swing.JLabel();
        namePet_lbl = new javax.swing.JLabel();
        namePet_Field = new javax.swing.JTextField();
        idPet_lbl = new javax.swing.JLabel();
        cboxBred_pet = new javax.swing.JComboBox();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        sexPet_lbl = new javax.swing.JLabel();
        colorPet_Field = new javax.swing.JTextField();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        dateBirthPet_lbl = new javax.swing.JLabel();
        colorPet_lbl = new javax.swing.JLabel();
        sexPet_Field = new javax.swing.JTextField();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        documentOwner_lbl = new javax.swing.JLabel();
        documentOwner_field = new javax.swing.JTextField();
        nameOwner_field = new javax.swing.JTextField();
        OwnerTitle_petLbl = new javax.swing.JLabel();
        nameOwner_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(getMinimumSize());
        setPreferredSize(getMaximumSize());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setAutoscrolls(true);
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 800));

        jScrollPane2.setMinimumSize(new java.awt.Dimension(800, 22));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(800, 406));
        jScrollPane2.setWheelScrollingEnabled(false);
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        petTable.setAutoCreateRowSorter(true);
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
        petTable.setToolTipText("");
        petTable.setMinimumSize(new java.awt.Dimension(120, 80));
        jScrollPane2.setViewportView(petTable);

        btnActualizar.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 102, 102));
        btnActualizar.setText("Actualizar");
        btnActualizar.setMaximumSize(new java.awt.Dimension(78, 23));
        btnActualizar.setMinimumSize(new java.awt.Dimension(78, 23));
        btnActualizar.setPreferredSize(new java.awt.Dimension(78, 23));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 102));
        btnSalir.setText("Salir");
        btnSalir.setMaximumSize(new java.awt.Dimension(78, 23));
        btnSalir.setMinimumSize(new java.awt.Dimension(78, 23));
        btnSalir.setPreferredSize(new java.awt.Dimension(78, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 102, 102));
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel13.setText("Ingrese documento");

        btnSearchDocumet_client.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnSearchDocumet_client.setForeground(new java.awt.Color(0, 102, 102));
        btnSearchDocumet_client.setText("Buscar");
        btnSearchDocumet_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDocumet_clientActionPerformed(evt);
            }
        });

        btnRefreshTable_pet.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnRefreshTable_pet.setForeground(new java.awt.Color(0, 102, 102));
        btnRefreshTable_pet.setText("Refrescar");
        btnRefreshTable_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTable_petActionPerformed(evt);
            }
        });

        jLabelTitleClinic_pets.setFont(new java.awt.Font("Bookman Old Style", 3, 24)); // NOI18N
        jLabelTitleClinic_pets.setForeground(java.awt.SystemColor.activeCaption);
        jLabelTitleClinic_pets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitleClinic_pets.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitleClinic_pets, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(39, 39, 39)
                                .addComponent(searchDocumentClient_field, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnSearchDocumet_client)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefreshTable_pet))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitleClinic_pets, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchDocumentClient_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchDocumet_client)
                    .addComponent(jLabel13)
                    .addComponent(btnRefreshTable_pet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setAlignmentX(1.0F);
        jPanel2.setAlignmentY(1.0F);
        jPanel2.setMaximumSize(getPreferredSize());
        jPanel2.setMinimumSize(new java.awt.Dimension(350, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 600));

        jDesktopPane1.setBackground(java.awt.SystemColor.control);
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(300, 180));

        speciesPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        speciesPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        speciesPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        speciesPet_lbl.setText("Especie");

        idPet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        idPet_Field.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cboxSpecies_pet.setPreferredSize(new java.awt.Dimension(64, 27));

        bredPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        bredPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        bredPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bredPet_lbl.setText("Raza");

        namePet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        namePet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        namePet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namePet_lbl.setText("Nombre");

        namePet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        idPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        idPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        idPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        idPet_lbl.setText("ID");

        cboxBred_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxBred_petActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(speciesPet_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(idPet_Field, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cboxSpecies_pet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(bredPet_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(namePet_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(namePet_Field, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(idPet_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cboxBred_pet, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namePet_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bredPet_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(speciesPet_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(idPet_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboxSpecies_pet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboxBred_pet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(namePet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(idPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPet_Field)
                    .addComponent(idPet_lbl))
                .addGap(6, 6, 6)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namePet_Field)
                    .addComponent(namePet_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speciesPet_lbl)
                    .addComponent(cboxSpecies_pet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bredPet_lbl)
                    .addComponent(cboxBred_pet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel2.add(jDesktopPane1);

        jDesktopPane2.setBackground(java.awt.SystemColor.control);

        sexPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        sexPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        sexPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sexPet_lbl.setText("Sexo");

        colorPet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        jDateChooserFecha.setMinimumSize(new java.awt.Dimension(64, 27));

        dateBirthPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        dateBirthPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        dateBirthPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dateBirthPet_lbl.setText(" Fecha de nacimiento");

        colorPet_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        colorPet_lbl.setForeground(new java.awt.Color(255, 255, 255));
        colorPet_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        colorPet_lbl.setText("Color");

        sexPet_Field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        jDesktopPane2.setLayer(sexPet_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(colorPet_Field, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jDateChooserFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(dateBirthPet_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(colorPet_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(sexPet_Field, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexPet_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorPet_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(135, 135, 135))
                    .addComponent(dateBirthPet_lbl)
                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colorPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorPet_lbl)
                    .addComponent(colorPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexPet_lbl)
                    .addComponent(sexPet_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dateBirthPet_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.add(jDesktopPane2);

        jDesktopPane4.setBackground(java.awt.SystemColor.control);

        documentOwner_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        documentOwner_lbl.setForeground(new java.awt.Color(255, 255, 255));
        documentOwner_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        documentOwner_lbl.setText("Documento");

        documentOwner_field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        nameOwner_field.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        OwnerTitle_petLbl.setText("PROPIETARIO");

        nameOwner_lbl.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        nameOwner_lbl.setForeground(new java.awt.Color(255, 255, 255));
        nameOwner_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameOwner_lbl.setText("Nombre");

        jDesktopPane4.setLayer(documentOwner_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(documentOwner_field, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(nameOwner_field, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(OwnerTitle_petLbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(nameOwner_lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane4Layout.createSequentialGroup()
                        .addComponent(documentOwner_lbl)
                        .addGap(191, 191, 191))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nameOwner_lbl, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OwnerTitle_petLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameOwner_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(documentOwner_field, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(17, 17, 17))))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(OwnerTitle_petLbl)
                .addGap(18, 18, 18)
                .addComponent(nameOwner_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameOwner_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(documentOwner_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(documentOwner_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.add(jDesktopPane4);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        try{
            int idPet = Integer.parseInt(idPet_Field.getText().trim());
            Pet pet = new Pet();
            PetDAO petDAO = new PetDAO();
            
            String species = (String) cboxSpecies_pet.getSelectedItem(); ///asignar el texto del cbox de especie
            String bred = (String) cboxBred_pet.getSelectedItem();
            
            pet.setId_Client(pet.getId_Client());
            pet.setId_Clinic(logUser.getId_clinic());
            pet.setId_pet(idPet);
            pet.setName_Pet(namePet_Field.getText());
            pet.setSpecies(species);
            pet.setBred(bred);
            pet.setColor(colorPet_Field.getText());
            pet.setSex(sexPet_Field.getText());
            java.util.Date utilDate = jDateChooserFecha.getDate();
            if (utilDate == null) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione la fecha de nacimiento.",
                        logUser.getClinic().getName_clinic(),
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (utilDate.after(new java.util.Date())) {
                JOptionPane.showMessageDialog(this,
                        "La fecha de nacimiento no puede ser futura.",
                        logUser.getClinic().getName_clinic(),
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pet.setDate_of_birth(sqlDate);
            
            if(namePet_Field.getText().isEmpty() || bred.isEmpty()|| species.isEmpty()
                    || colorPet_Field.getText().isEmpty()|| sexPet_Field.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Complete los campos obligatorios *",logUser.getClinic().getName_clinic(), JOptionPane.WARNING_MESSAGE);
            }else {                
                String message = "¿Desea confirmar la actualización?";
                String title = logUser.getClinic().getName_clinic();
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
                    + "", logUser.getClinic().getName_clinic(), JOptionPane.WARNING_MESSAGE);
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

    private void btnRefreshTable_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTable_petActionPerformed
        emptyFiels();
        loadAllPets(logUser);
        hideField(false);
    }//GEN-LAST:event_btnRefreshTable_petActionPerformed

    private void cboxBred_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxBred_petActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxBred_petActionPerformed

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
    private javax.swing.JLabel OwnerTitle_petLbl;
    private javax.swing.JLabel bredPet_lbl;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefreshTable_pet;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSearchDocumet_client;
    private javax.swing.JComboBox cboxBred_pet;
    private javax.swing.JComboBox cboxSpecies_pet;
    private javax.swing.JTextField colorPet_Field;
    private javax.swing.JLabel colorPet_lbl;
    private javax.swing.JLabel dateBirthPet_lbl;
    private javax.swing.JTextField documentOwner_field;
    private javax.swing.JLabel documentOwner_lbl;
    private javax.swing.JTextField idPet_Field;
    private javax.swing.JLabel idPet_lbl;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabelTitleClinic_pets;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameOwner_field;
    private javax.swing.JLabel nameOwner_lbl;
    private javax.swing.JTextField namePet_Field;
    private javax.swing.JLabel namePet_lbl;
    private javax.swing.JTable petTable;
    private javax.swing.JTextField searchDocumentClient_field;
    private javax.swing.JTextField sexPet_Field;
    private javax.swing.JLabel sexPet_lbl;
    private javax.swing.JLabel speciesPet_lbl;
    // End of variables declaration//GEN-END:variables

    private void aplicarAccesibilidad() {
    // --- Labels y campos ---
    idPet_lbl.setLabelFor(idPet_Field);
    idPet_lbl.setDisplayedMnemonic('I');
    idPet_Field.setToolTipText("ID de la mascota (no editable) (Alt + I)");
    idPet_Field.getAccessibleContext().setAccessibleName("ID de la mascota");
    idPet_Field.getAccessibleContext().setAccessibleDescription("Muestra el ID de la mascota, no editable");

    namePet_lbl.setLabelFor(namePet_Field);
    namePet_lbl.setDisplayedMnemonic('N');
    namePet_Field.setToolTipText("Nombre de la mascota (Alt + N)");
    namePet_Field.getAccessibleContext().setAccessibleName("Nombre de la mascota");
    namePet_Field.getAccessibleContext().setAccessibleDescription("Ingrese el nombre de la mascota");

    speciesPet_lbl.setLabelFor(cboxSpecies_pet);
    speciesPet_lbl.setDisplayedMnemonic('E');
    cboxSpecies_pet.setToolTipText("Seleccione la especie de la mascota (Alt + E)");
    cboxSpecies_pet.getAccessibleContext().setAccessibleName("Especie de la mascota");
    cboxSpecies_pet.getAccessibleContext().setAccessibleDescription("Seleccione la especie de la mascota");

    bredPet_lbl.setLabelFor(cboxBred_pet);
    bredPet_lbl.setDisplayedMnemonic('R');
    cboxBred_pet.setToolTipText("Raza de la mascota (Alt + R)");
    cboxBred_pet.getAccessibleContext().setAccessibleName("Raza de la mascota");
    cboxBred_pet.getAccessibleContext().setAccessibleDescription("Ingrese la raza de la mascota");

    colorPet_lbl.setLabelFor(colorPet_Field);
    colorPet_lbl.setDisplayedMnemonic('C');
    colorPet_Field.setToolTipText("Color de la mascota (Alt + C)");
    colorPet_Field.getAccessibleContext().setAccessibleName("Color de la mascota");
    colorPet_Field.getAccessibleContext().setAccessibleDescription("Ingrese el color de la mascota");

    sexPet_lbl.setLabelFor(sexPet_Field);
    sexPet_lbl.setDisplayedMnemonic('S');
    sexPet_Field.setToolTipText("Sexo de la mascota (no editable) (Alt + S)");
    sexPet_Field.getAccessibleContext().setAccessibleName("Sexo de la mascota");
    sexPet_Field.getAccessibleContext().setAccessibleDescription("Muestra el sexo de la mascota, no editable");

    dateBirthPet_lbl.setLabelFor(dateBirthPet_lbl);
    dateBirthPet_lbl.setDisplayedMnemonic('F');
    dateBirthPet_lbl.setToolTipText("Fecha de nacimiento de la mascota (yyyy-mm-dd) (Alt + F)");
    dateBirthPet_lbl.getAccessibleContext().setAccessibleName("Fecha de nacimiento");
    dateBirthPet_lbl.getAccessibleContext().setAccessibleDescription("Ingrese la fecha de nacimiento de la mascota en formato yyyy-mm-dd");

    documentOwner_lbl.setLabelFor(documentOwner_field);
    documentOwner_lbl.setDisplayedMnemonic('D');
    documentOwner_field.setToolTipText("Documento del propietario (no editable) (Alt + D)");
    documentOwner_field.getAccessibleContext().setAccessibleName("Documento del propietario");
    documentOwner_field.getAccessibleContext().setAccessibleDescription("Muestra el documento del propietario, no editable");

    nameOwner_lbl.setLabelFor(nameOwner_field);
    nameOwner_lbl.setDisplayedMnemonic('P');
    nameOwner_field.setToolTipText("Nombre del propietario (no editable) (Alt + P)");
    nameOwner_field.getAccessibleContext().setAccessibleName("Nombre del propietario");
    nameOwner_field.getAccessibleContext().setAccessibleDescription("Muestra el nombre completo del propietario, no editable");

    searchDocumentClient_field.setToolTipText("Ingrese el documento del cliente para buscar (Alt + B)");
    searchDocumentClient_field.getAccessibleContext().setAccessibleName("Buscar cliente por documento");
    searchDocumentClient_field.getAccessibleContext().setAccessibleDescription("Ingrese el documento del cliente para filtrar las mascotas");

    // --- Botones ---
    btnActualizar.setMnemonic('A'); // Alt + A
    btnActualizar.setToolTipText("Actualizar los datos de la mascota seleccionada (Alt + A)");
    btnActualizar.getAccessibleContext().setAccessibleName("Actualizar mascota");
    btnActualizar.getAccessibleContext().setAccessibleDescription("Actualizar la información de la mascota seleccionada");

    btnDelete.setMnemonic('E'); // Alt + E
    btnDelete.setToolTipText("Eliminar la mascota seleccionada (Alt + E)");
    btnDelete.getAccessibleContext().setAccessibleName("Eliminar mascota");
    btnDelete.getAccessibleContext().setAccessibleDescription("Eliminar la mascota seleccionada de la base de datos");

    btnSalir.setMnemonic('S'); // Alt + S
    btnSalir.setToolTipText("Salir del módulo de gestión de mascotas (Alt + S)");
    btnSalir.getAccessibleContext().setAccessibleName("Salir");
    btnSalir.getAccessibleContext().setAccessibleDescription("Salir del módulo de gestión de mascotas");

    btnSearchDocumet_client.setMnemonic('B'); // Alt + B
    btnSearchDocumet_client.setToolTipText("Buscar mascotas por documento del propietario (Alt + B)");
    btnSearchDocumet_client.getAccessibleContext().setAccessibleName("Buscar mascotas");
    btnSearchDocumet_client.getAccessibleContext().setAccessibleDescription("Buscar mascotas según el documento del propietario");

    btnRefreshTable_pet.setMnemonic('R'); // Alt + R
    btnRefreshTable_pet.setToolTipText("Refrescar la lista de mascotas (Alt + R)");
    btnRefreshTable_pet.getAccessibleContext().setAccessibleName("Refrescar tabla");
    btnRefreshTable_pet.getAccessibleContext().setAccessibleDescription("Refrescar la tabla de mascotas");

    // --- Tabla ---
    petTable.setToolTipText("Tabla con la lista de mascotas");
    petTable.getAccessibleContext().setAccessibleName("Tabla de mascotas");
    petTable.getAccessibleContext().setAccessibleDescription("Muestra todas las mascotas registradas para la clínica");

    // --- Panel título clínica ---
    jLabelTitleClinic_pets.setToolTipText("Nombre de la clínica");
    jLabelTitleClinic_pets.getAccessibleContext().setAccessibleName("Nombre de la clínica");
    jLabelTitleClinic_pets.getAccessibleContext().setAccessibleDescription("Muestra el nombre de la clínica del usuario logueado");
}

}
