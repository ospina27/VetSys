package project.vetsys.view.manager;

import java.awt.Color;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import project.vetsys.model.User;
import javax.swing.JOptionPane;
import javax.swing.plaf.ComboBoxUI;
import project.vetsys.dao.PetDAO;
import project.vetsys.model.Pet;
import project.vetsys.view.Nimbus;
import project.vetsys.view.Utils;

public class CreatePet extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreatePet.class.getName());
    private User logUser;
    private Utils utils;
    String sexPet ="";

    public CreatePet() {
        initComponents();
        initListeners();
    }
    
    public CreatePet(User logUser){
        Nimbus.LookandFeel();
        this.logUser = logUser;
        utils = new Utils();
        initComponents();
        initListeners();
        Nimbus.styleAllLabelsExcept(this,CreatePet_lblTittle );
        Nimbus.styleAllTextFields(this);
        Nimbus.styleTitleLabel(CreatePet_lblSubTittle);
        setTitle("Gestion de mascotas");
        emptyFields();
        loadSpecies(cboxSpecies_pet,cboxBred_pet);
       
        CreatePet_lblTittle.setText(logUser.getClinic().getName_clinic());
        buttonGroupSexPet.add(sexMacho_Rbutton); ///añadir los rbutton al group 
        buttonGroupSexPet.add(sexHembra_Rbutton);
    }
    
    private void initListeners(){
        cboxSpecies_pet.addActionListener(evt ->speciesSelected(cboxSpecies_pet, cboxBred_pet));
    }

    private void emptyFields(){
        CreatePet_tetxNamePet.setText("");
        cboxBred_pet.setSelectedIndex(-1);
        cboxSpecies_pet.setSelectedIndex(-1);
        CreatePet_textColorPet.setText("");
        CreatePet_textDateBirthdayPet.setText("");
        CreatePet_textOwnerDocument.setText("");
        buttonGroupSexPet.clearSelection();
    }
    
    public void loadSpecies (JComboBox<String> cboxSpecies,JComboBox<String> cboxBred){
        ///cargar las especies, este metodo se reutiliza en SearchPet para cargar todo en los cbox
        List<String> listSpecies = new ArrayList<>(); 
        listSpecies.add("Canino");
        listSpecies.add("Felino");
        utils.fillComboBox(cboxSpecies, listSpecies,"");
        speciesSelected(cboxSpecies, cboxBred);
    }
    
    public void speciesSelected(JComboBox<String> cboxSpecies, JComboBox<String> cboxBred){
        String selectedSpecies = (String) cboxSpecies.getSelectedItem();
        if (selectedSpecies != null && !selectedSpecies.isEmpty()) {
            cboxBred.setEnabled(true); /// Habilitar el ComboBox de razas
            loadBred(selectedSpecies, cboxBred); ///Cargar las razas según la especie seleccionada
        } else {
            cboxBred.setEnabled(false); // Deshabilitar el cbox de razas si no hay especie seleccionada
        } 
    }
    
    ///cargar razas de Felino
    public void loadBredFelino(JComboBox<String> cboxBred){
        List<String> listBred = new ArrayList<>();
        listBred.add("No especificada");
        listBred.add("Persa");
        listBred.add("Siamés");
        listBred.add("Azul ruso");
        listBred.add("Angora turco");
        listBred.add("Siberiano");
        listBred.add("Maine Coon");
        listBred.add("Bengalí");
        utils.fillComboBox(cboxBred, listBred,"");
    }
    

    ///cargar razas de Canino
    public void loadBredCanino(JComboBox<String> cboxBred){
        List<String> listBred = new ArrayList<>();
        listBred.add("No especificada");
        listBred.add("Pitbull");
        listBred.add("Beagle");
        listBred.add("Labrador Retriever");
        listBred.add("Bulldog Francés");
        listBred.add("Pastor Alemán");
        listBred.add("Golden Retriever");
        listBred.add("Pug");
        listBred.add("Rottweiler");
        listBred.add("Chihuahua");
        listBred.add("Cocker Spaniel");
        utils.fillComboBox(cboxBred, listBred,"");
    }
    
    ///seleccionar que raza cargar dependiendo la especie que se haya seleccionado
    private void loadBred(String species, JComboBox<String> cboxBred){
        if(species == null || species.isEmpty()){return;}       
        
        if(species.equals("Canino")){
            loadBredCanino(cboxBred);
        }else if(species.equals("Felino")){
            loadBredFelino(cboxBred);
        }else{
           cboxBred.removeAllItems();
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSexPet = new javax.swing.ButtonGroup();
        CreatePet = new javax.swing.JPanel();
        Up = new javax.swing.JPanel();
        CreatePet_lblTittle = new javax.swing.JLabel();
        Down = new javax.swing.JPanel();
        CreatePet_lblSubTittle = new javax.swing.JLabel();
        CreatePet_lblNamePet = new javax.swing.JLabel();
        CreatePet_tetxNamePet = new javax.swing.JTextField();
        CreatePet_lblBreed = new javax.swing.JLabel();
        CreatePet_lblSpecies = new javax.swing.JLabel();
        CreatePet_lblColorPet = new javax.swing.JLabel();
        CreatePet_textColorPet = new javax.swing.JTextField();
        CreatePet_lblSexPet = new javax.swing.JLabel();
        CreatePet_lblDateBirthdayPet = new javax.swing.JLabel();
        CreatePet_textDateBirthdayPet = new javax.swing.JTextField();
        CreatePet_lblOwnerID = new javax.swing.JLabel();
        CreatePet_textOwnerDocument = new javax.swing.JTextField();
        sexHembra_Rbutton = new javax.swing.JRadioButton();
        sexMacho_Rbutton = new javax.swing.JRadioButton();
        btnCreatePet = new javax.swing.JButton();
        bttonEmptyFields_pet = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        cboxSpecies_pet = new javax.swing.JComboBox();
        cboxBred_pet = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        CreatePet.setBackground(new java.awt.Color(255, 255, 255));
        CreatePet.setMaximumSize(new java.awt.Dimension(800, 600));
        CreatePet.setMinimumSize(new java.awt.Dimension(800, 600));
        CreatePet.setPreferredSize(new java.awt.Dimension(800, 600));
        CreatePet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Up.setBackground(new java.awt.Color(0, 153, 153));
        Up.setMaximumSize(new java.awt.Dimension(1000, 100));
        Up.setMinimumSize(new java.awt.Dimension(1000, 100));
        Up.setPreferredSize(new java.awt.Dimension(800, 100));

        CreatePet_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreatePet_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        CreatePet_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreatePet_lblTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addComponent(CreatePet_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        CreatePet.add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        Down.setBackground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(800, 600));
        Down.setMinimumSize(new java.awt.Dimension(800, 600));
        Down.setName(""); // NOI18N
        Down.setPreferredSize(new java.awt.Dimension(800, 600));

        CreatePet_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        CreatePet_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreatePet_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        CreatePet_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreatePet_lblSubTittle.setText("Crear Mascota");

        CreatePet_lblNamePet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblNamePet.setText("Nombre*");

        CreatePet_tetxNamePet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_tetxNamePet.setForeground(java.awt.Color.gray);
        CreatePet_tetxNamePet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_tetxNamePet.setPreferredSize(new java.awt.Dimension(68, 26));

        CreatePet_lblBreed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblBreed.setText("Raza*");

        CreatePet_lblSpecies.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblSpecies.setText("Especie*");

        CreatePet_lblColorPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblColorPet.setText("Color*");

        CreatePet_textColorPet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textColorPet.setForeground(java.awt.Color.gray);
        CreatePet_textColorPet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textColorPet.setPreferredSize(new java.awt.Dimension(68, 26));

        CreatePet_lblSexPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblSexPet.setText("Sexo*");

        CreatePet_lblDateBirthdayPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblDateBirthdayPet.setText("Fecha de Nacimiento * yyyy-mm-dd");

        CreatePet_textDateBirthdayPet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textDateBirthdayPet.setForeground(java.awt.Color.gray);
        CreatePet_textDateBirthdayPet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textDateBirthdayPet.setPreferredSize(new java.awt.Dimension(68, 26));

        CreatePet_lblOwnerID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblOwnerID.setText("Cedula Propietario *");

        CreatePet_textOwnerDocument.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textOwnerDocument.setForeground(java.awt.Color.gray);
        CreatePet_textOwnerDocument.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textOwnerDocument.setPreferredSize(new java.awt.Dimension(68, 26));

        sexHembra_Rbutton.setText("Hembra");

        sexMacho_Rbutton.setText("Macho");
        sexMacho_Rbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexMacho_RbuttonActionPerformed(evt);
            }
        });

        btnCreatePet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCreatePet.setForeground(new java.awt.Color(0, 102, 102));
        btnCreatePet.setText("Crear");
        btnCreatePet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePetActionPerformed(evt);
            }
        });

        bttonEmptyFields_pet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bttonEmptyFields_pet.setForeground(new java.awt.Color(0, 102, 102));
        bttonEmptyFields_pet.setText("Limpiar");
        bttonEmptyFields_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttonEmptyFields_petActionPerformed(evt);
            }
        });

        btnExit1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExit1.setForeground(new java.awt.Color(0, 102, 102));
        btnExit1.setText("Salir");
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });

        cboxSpecies_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSpecies_petActionPerformed(evt);
            }
        });

        cboxBred_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxBred_petActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DownLayout = new javax.swing.GroupLayout(Down);
        Down.setLayout(DownLayout);
        DownLayout.setHorizontalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreatePet_lblSubTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreatePet_lblNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_lblBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_lblSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_lblColorPet, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnCreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CreatePet_tetxNamePet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(CreatePet_textColorPet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxSpecies_pet, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxBred_pet, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CreatePet_lblOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CreatePet_textDateBirthdayPet, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CreatePet_lblDateBirthdayPet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CreatePet_textOwnerDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CreatePet_lblSexPet, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DownLayout.createSequentialGroup()
                                .addComponent(sexMacho_Rbutton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sexHembra_Rbutton))
                            .addComponent(bttonEmptyFields_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addComponent(CreatePet_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreatePet_lblDateBirthdayPet)
                .addGap(4, 4, 4)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_tetxNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_textDateBirthdayPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_lblNamePet))
                .addGap(22, 22, 22)
                .addComponent(CreatePet_lblOwnerID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_textOwnerDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_lblSpecies)
                    .addComponent(cboxSpecies_pet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_lblSexPet)
                    .addComponent(sexHembra_Rbutton)
                    .addComponent(sexMacho_Rbutton)
                    .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CreatePet_lblBreed)
                        .addComponent(cboxBred_pet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_textColorPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_lblColorPet))
                .addGap(50, 50, 50)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit1)
                    .addComponent(bttonEmptyFields_pet)
                    .addComponent(btnCreatePet))
                .addGap(186, 186, 186))
        );

        CreatePet.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sexMacho_RbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexMacho_RbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexMacho_RbuttonActionPerformed

    private void btnCreatePetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePetActionPerformed
        
        String namePet = CreatePet_tetxNamePet.getText();
        String speciesPet = (String) cboxSpecies_pet.getSelectedItem();
        String bredPet = (String) cboxBred_pet.getSelectedItem();
        String colorPet = CreatePet_textColorPet.getText();
        
        if(sexMacho_Rbutton.isSelected())
        {
            sexPet = sexMacho_Rbutton.getText(); 
            
        }else if(sexHembra_Rbutton.isSelected())
        {
            sexPet = sexHembra_Rbutton.getText();
        }
        String datePet = CreatePet_textDateBirthdayPet.getText();
        String documentOwner = CreatePet_textOwnerDocument.getText();
        
        if (namePet.isEmpty() || documentOwner.isEmpty() || speciesPet.isEmpty() || bredPet.isEmpty() || bredPet.isEmpty()
                ||colorPet.isEmpty() ||  buttonGroupSexPet.getSelection() == null || datePet.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos obligatorios *",logUser.getClinic().getName_clinic()
                    ,JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Pet pet = new Pet();
        PetDAO petDao = new PetDAO();
        pet.setName_Pet(namePet);
        pet.setSpecies(speciesPet);
        pet.setBred(bredPet);
        pet.setColor(colorPet);
        pet.setSex(sexPet);
        //pet.setDate_of_birth(Date.valueOf(datePet));
        String dateText = CreatePet_textDateBirthdayPet.getText();
        try 
        {
            Date date = Date.valueOf(dateText);  // convierte si el formato es válido
            pet.setDate_of_birth(date);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this,
            "Formato de fecha incorrecto.\n Debe ser YYYY-MM-DD",logUser.getClinic().getName_clinic(),
             JOptionPane.ERROR_MESSAGE);
                return;
            }
        int document = petDao.searchIdOwner(documentOwner); ///pasar el documento para buscar el idCliente
        pet.setId_Client(document);
        pet.setId_Clinic(logUser.getId_clinic());
                
        boolean success = petDao.Create(pet, documentOwner);
        if(document == -1){
            JOptionPane.showMessageDialog(this, "No se encontro cliente con cedula "+documentOwner,logUser.getClinic().getName_clinic(),
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(success){
            javax.swing.JOptionPane.showMessageDialog(this, "Mascota creada correctamente",logUser.getClinic().getName_clinic(),JOptionPane.INFORMATION_MESSAGE);
            emptyFields();
        }else {
            javax.swing.JOptionPane.showMessageDialog(this, "Falló la creación de la mascota \n"+"Revise los datos ingresados",logUser.getClinic().getName_clinic(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreatePetActionPerformed

    private void bttonEmptyFields_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttonEmptyFields_petActionPerformed
        emptyFields();
    }//GEN-LAST:event_bttonEmptyFields_petActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        ///validar que no haya información en los campos antes de salir
        if(!CreatePet_tetxNamePet.getText().isEmpty() || cboxBred_pet.getSelectedItem() == "" || cboxSpecies_pet.getSelectedItem()== ""||
            !CreatePet_textColorPet.getText().isEmpty() || buttonGroupSexPet.getSelection()!= null || !CreatePet_textDateBirthdayPet.getText().isEmpty()
               || !CreatePet_textOwnerDocument.getText().isEmpty())
        {
            String messageConfirm = "¿Desea cancelar la creación de la mascota?";
            String title = logUser.getClinic().getName_clinic();
            if(utils.validation(messageConfirm, title)==1)
            {
                //siempre que se llame al MenuManager, hacerlo con el constructor con parametro de logUser
                PatientsMenu MenuManagerFrame = new PatientsMenu(logUser);  
                MenuManagerFrame.setVisible(true);
                MenuManagerFrame.pack();
                MenuManagerFrame.setLocationRelativeTo(null);
                this.dispose();
            }   
        }else
            {
                PatientsMenu MenuManagerFrame = new PatientsMenu(logUser);  
                MenuManagerFrame.setVisible(true);
                MenuManagerFrame.pack();
                MenuManagerFrame.setLocationRelativeTo(null);
                this.dispose();
            } 
    }//GEN-LAST:event_btnExit1ActionPerformed

    private void cboxSpecies_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSpecies_petActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxSpecies_petActionPerformed

    private void cboxBred_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxBred_petActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxBred_petActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CreatePet().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreatePet;
    private javax.swing.JLabel CreatePet_lblBreed;
    private javax.swing.JLabel CreatePet_lblColorPet;
    private javax.swing.JLabel CreatePet_lblDateBirthdayPet;
    private javax.swing.JLabel CreatePet_lblNamePet;
    private javax.swing.JLabel CreatePet_lblOwnerID;
    private javax.swing.JLabel CreatePet_lblSexPet;
    private javax.swing.JLabel CreatePet_lblSpecies;
    private javax.swing.JLabel CreatePet_lblSubTittle;
    private javax.swing.JLabel CreatePet_lblTittle;
    private javax.swing.JTextField CreatePet_tetxNamePet;
    private javax.swing.JTextField CreatePet_textColorPet;
    private javax.swing.JTextField CreatePet_textDateBirthdayPet;
    private javax.swing.JTextField CreatePet_textOwnerDocument;
    private javax.swing.JPanel Down;
    private javax.swing.JPanel Up;
    private javax.swing.JButton btnCreatePet;
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton bttonEmptyFields_pet;
    private javax.swing.ButtonGroup buttonGroupSexPet;
    private javax.swing.JComboBox cboxBred_pet;
    private javax.swing.JComboBox cboxSpecies_pet;
    private javax.swing.JRadioButton sexHembra_Rbutton;
    private javax.swing.JRadioButton sexMacho_Rbutton;
    // End of variables declaration//GEN-END:variables
}
