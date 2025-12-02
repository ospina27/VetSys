package project.vetsys.view.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import project.vetsys.model.User;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import project.vetsys.dao.PetDAO;
import project.vetsys.model.Pet;
import project.vetsys.utils.ValidationInput;
import project.vetsys.view.Nimbus;
import project.vetsys.utils.Utils;

public class CreatePet extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreatePet.class.getName());
    private User logUser;
    private Utils utils;
    String sexPet ="";

    public CreatePet() {
        initComponents();
        aplicarAccesibilidad();
        initListeners();
    }
    
    public CreatePet(User logUser){
        Nimbus.LookandFeel();
        this.logUser = logUser;
        utils = new Utils();
        initComponents();
        aplicarAccesibilidad();
        initListeners();
        configurarFechaNacimiento();
        Nimbus.styleAllLabelsExcept(this,CreatePet_lblTittle );
        //Nimbus.styleTitleLabel(CreatePet_lblTittle );
        Nimbus.styleAllTextFields(this);
        Nimbus.styleTitleLabel(CreatePet_lblSubTittle);
        setTitle("Gestión de Mascotas");
        emptyFields();
        loadSpecies(cboxSpecies_pet,cboxBred_pet);
        
       
        CreatePet_lblTittle.setText(logUser.getClinic().getName_clinic());
        buttonGroupSexPet.add(sexMacho_Rbutton); ///añadir los rbutton al group 
        buttonGroupSexPet.add(sexHembra_Rbutton);
        
        // Validaciones en entrada de campos de textos
        ValidationInput.text(CreatePet_tetxNamePet, 30);
        ValidationInput.text(CreatePet_textColorPet, 25);
        ValidationInput.numbers(CreatePet_textOwnerDocument, 11);
    }
    
    private void initListeners(){
        cboxSpecies_pet.addActionListener(evt ->speciesSelected(cboxSpecies_pet, cboxBred_pet));
    }
    
    private void configurarFechaNacimiento() {
        
        ((JTextField) jDateChooserFecha.getDateEditor().getUiComponent()).setEditable(false);
        jDateChooserFecha.setMaxSelectableDate(new Date());
        
    }

    private void emptyFields(){
        CreatePet_tetxNamePet.setText("");
        cboxBred_pet.setSelectedIndex(-1);
        cboxSpecies_pet.setSelectedIndex(-1);
        CreatePet_textColorPet.setText("");
        jDateChooserFecha.setDate(null);
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
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        CreatePet_tetxNamePet = new javax.swing.JTextField();
        btnCreatePet = new javax.swing.JButton();
        sexHembra_Rbutton = new javax.swing.JRadioButton();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        sexMacho_Rbutton = new javax.swing.JRadioButton();
        CreatePet_lblSexPet = new javax.swing.JLabel();
        bttonEmptyFields_pet = new javax.swing.JButton();
        cboxSpecies_pet = new javax.swing.JComboBox();
        CreatePet_textOwnerDocument = new javax.swing.JTextField();
        CreatePet_lblSubTittle = new javax.swing.JLabel();
        CreatePet_textColorPet = new javax.swing.JTextField();
        CreatePet_lblBreed = new javax.swing.JLabel();
        CreatePet_lblNamePet = new javax.swing.JLabel();
        cboxBred_pet = new javax.swing.JComboBox();
        btnExit1 = new javax.swing.JButton();
        CreatePet_lblOwnerID = new javax.swing.JLabel();
        CreatePet_lblDateBirthdayPet = new javax.swing.JLabel();
        CreatePet_lblSpecies = new javax.swing.JLabel();
        CreatePet_lblColorPet = new javax.swing.JLabel();
        CreatePet_lblTittle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.control);
        setMinimumSize(getMinimumSize());
        setResizable(false);
        setState(getCursorType());

        jDesktopPane2.setBackground(java.awt.SystemColor.control);
        jDesktopPane2.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jDesktopPane2.setMinimumSize(new java.awt.Dimension(800, 600));
        jDesktopPane2.setPreferredSize(new java.awt.Dimension(800, 565));

        CreatePet_tetxNamePet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_tetxNamePet.setForeground(java.awt.Color.gray);
        CreatePet_tetxNamePet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_tetxNamePet.setPreferredSize(new java.awt.Dimension(68, 26));

        btnCreatePet.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnCreatePet.setForeground(new java.awt.Color(0, 153, 153));
        btnCreatePet.setText("Crear");
        btnCreatePet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreatePet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePetActionPerformed(evt);
            }
        });

        sexHembra_Rbutton.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        sexHembra_Rbutton.setText("Hembra");
        sexHembra_Rbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        sexMacho_Rbutton.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        sexMacho_Rbutton.setText("Macho");
        sexMacho_Rbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sexMacho_Rbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexMacho_RbuttonActionPerformed(evt);
            }
        });

        CreatePet_lblSexPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblSexPet.setText("Sexo*");

        bttonEmptyFields_pet.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        bttonEmptyFields_pet.setForeground(new java.awt.Color(0, 153, 153));
        bttonEmptyFields_pet.setText("Limpiar");
        bttonEmptyFields_pet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttonEmptyFields_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttonEmptyFields_petActionPerformed(evt);
            }
        });

        cboxSpecies_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSpecies_petActionPerformed(evt);
            }
        });

        CreatePet_textOwnerDocument.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textOwnerDocument.setForeground(java.awt.Color.gray);
        CreatePet_textOwnerDocument.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textOwnerDocument.setPreferredSize(new java.awt.Dimension(68, 26));

        CreatePet_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        CreatePet_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        CreatePet_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        CreatePet_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreatePet_lblSubTittle.setText("Crear Mascota");

        CreatePet_textColorPet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textColorPet.setForeground(java.awt.Color.gray);
        CreatePet_textColorPet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textColorPet.setPreferredSize(new java.awt.Dimension(68, 26));

        CreatePet_lblBreed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblBreed.setText("Raza*");

        CreatePet_lblNamePet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblNamePet.setText("Nombre*");

        cboxBred_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxBred_petActionPerformed(evt);
            }
        });

        btnExit1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnExit1.setForeground(new java.awt.Color(0, 153, 153));
        btnExit1.setText("Salir");
        btnExit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });

        CreatePet_lblOwnerID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblOwnerID.setText("Cedula Propietario *");

        CreatePet_lblDateBirthdayPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblDateBirthdayPet.setText("Fecha de Nacimiento *");

        CreatePet_lblSpecies.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblSpecies.setText("Especie*");

        CreatePet_lblColorPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblColorPet.setText("Color*");

        CreatePet_lblTittle.setFont(new java.awt.Font("Bookman Old Style", 3, 24)); // NOI18N
        CreatePet_lblTittle.setForeground(java.awt.SystemColor.activeCaption);
        CreatePet_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jDesktopPane2.setLayer(CreatePet_tetxNamePet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btnCreatePet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(sexHembra_Rbutton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jDateChooserFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(sexMacho_Rbutton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblSexPet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bttonEmptyFields_pet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(cboxSpecies_pet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_textOwnerDocument, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblSubTittle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_textColorPet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblBreed, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblNamePet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(cboxBred_pet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btnExit1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblOwnerID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblDateBirthdayPet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblSpecies, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblColorPet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(CreatePet_lblTittle, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addComponent(CreatePet_lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxSpecies_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreatePet_lblSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxBred_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CreatePet_textColorPet, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CreatePet_lblColorPet, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(138, 138, 138)
                                .addComponent(bttonEmptyFields_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CreatePet_tetxNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CreatePet_lblNamePet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CreatePet_lblBreed, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(btnCreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                        .addGap(284, 284, 284)
                                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CreatePet_textOwnerDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                                .addComponent(CreatePet_lblSexPet, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(sexMacho_Rbutton)
                                                    .addComponent(sexHembra_Rbutton)))
                                            .addComponent(CreatePet_lblOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CreatePet_lblDateBirthdayPet, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(CreatePet_lblSubTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addComponent(CreatePet_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreatePet_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_lblNamePet)
                    .addComponent(CreatePet_lblDateBirthdayPet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CreatePet_tetxNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_lblSpecies)
                    .addComponent(CreatePet_lblOwnerID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxSpecies_pet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_textOwnerDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_lblBreed)
                    .addComponent(CreatePet_lblSexPet)
                    .addComponent(sexHembra_Rbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxBred_pet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexMacho_Rbutton))
                .addGap(18, 18, 18)
                .addComponent(CreatePet_lblColorPet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreatePet_textColorPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttonEmptyFields_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        ///validar que no haya información en los campos antes de salir
        if(!CreatePet_tetxNamePet.getText().isEmpty() || cboxBred_pet.getSelectedItem() == "" || cboxSpecies_pet.getSelectedItem()== ""||
            !CreatePet_textColorPet.getText().isEmpty() || buttonGroupSexPet.getSelection()!= null || jDateChooserFecha.getDate() == null
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

    private void cboxBred_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxBred_petActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxBred_petActionPerformed

    private void cboxSpecies_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSpecies_petActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxSpecies_petActionPerformed

    private void bttonEmptyFields_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttonEmptyFields_petActionPerformed
        emptyFields();
    }//GEN-LAST:event_bttonEmptyFields_petActionPerformed

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
        java.util.Date datePet = jDateChooserFecha.getDate();
        String documentOwner = CreatePet_textOwnerDocument.getText();

        if (namePet.isEmpty() || documentOwner.isEmpty() || speciesPet.isEmpty() || bredPet.isEmpty() || bredPet.isEmpty()
            ||colorPet.isEmpty() ||  buttonGroupSexPet.getSelection() == null || datePet == null)
        {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos obligatorios *",logUser.getClinic().getName_clinic()
                ,JOptionPane.WARNING_MESSAGE);
            return;
        }

        // restringir fechas futuras
        if (datePet.after(new java.util.Date())) {
            JOptionPane.showMessageDialog(this,
                "La fecha de nacimiento no puede ser futura.",
                logUser.getClinic().getName_clinic(),
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        // Convertir a java.sql.Date
        java.sql.Date birthdayDate = new java.sql.Date(datePet.getTime());

        Pet pet = new Pet();
        PetDAO petDao = new PetDAO();

        pet.setName_Pet(namePet);
        pet.setSpecies(speciesPet);
        pet.setBred(bredPet);
        pet.setColor(colorPet);
        pet.setSex(sexPet);
        pet.setDate_of_birth(birthdayDate);
        pet.setId_Clinic(logUser.getId_clinic());
        int document = petDao.searchIdOwner(documentOwner); ///pasar el documento para buscar el idCliente
        if(document == -1){
            JOptionPane.showMessageDialog(this, "No se encontro cliente con cedula "+documentOwner,logUser.getClinic().getName_clinic(),
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        pet.setId_Client(document);

        boolean success = petDao.Create(pet, documentOwner);

        if(success){
            javax.swing.JOptionPane.showMessageDialog(this, "Mascota creada correctamente",logUser.getClinic().getName_clinic(),JOptionPane.INFORMATION_MESSAGE);
            emptyFields();
        }else {
            javax.swing.JOptionPane.showMessageDialog(this, "Falló la creación de la mascota \n"+"Revise los datos ingresados",logUser.getClinic().getName_clinic(),
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreatePetActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CreatePet().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTextField CreatePet_textOwnerDocument;
    private javax.swing.JButton btnCreatePet;
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton bttonEmptyFields_pet;
    private javax.swing.ButtonGroup buttonGroupSexPet;
    private javax.swing.JComboBox cboxBred_pet;
    private javax.swing.JComboBox cboxSpecies_pet;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton sexHembra_Rbutton;
    private javax.swing.JRadioButton sexMacho_Rbutton;
    // End of variables declaration//GEN-END:variables

    private void aplicarAccesibilidad() {

    // ---------------------- TÍTULOS ----------------------
    CreatePet_lblTittle.getAccessibleContext().setAccessibleName("Título de la ventana");
    CreatePet_lblTittle.getAccessibleContext().setAccessibleDescription("Nombre de la clínica");

    CreatePet_lblSubTittle.getAccessibleContext().setAccessibleName("Subtítulo Crear Mascota");
    CreatePet_lblSubTittle.getAccessibleContext().setAccessibleDescription("Indica que se está creando una mascota");

    // ---------------------- LABELS ----------------------
    CreatePet_lblNamePet.setLabelFor(CreatePet_tetxNamePet);
    CreatePet_lblNamePet.setDisplayedMnemonic('N');
    CreatePet_lblNamePet.setToolTipText("Nombre de la mascota (Alt+N)");
    CreatePet_lblNamePet.getAccessibleContext().setAccessibleName("Etiqueta Nombre Mascota");
    CreatePet_lblNamePet.getAccessibleContext().setAccessibleDescription("Etiqueta que indica el campo nombre de la mascota");

    CreatePet_lblSpecies.setLabelFor(cboxSpecies_pet);
    CreatePet_lblSpecies.setDisplayedMnemonic('E');
    CreatePet_lblSpecies.setToolTipText("Seleccionar especie (Alt+E)");
    CreatePet_lblSpecies.getAccessibleContext().setAccessibleName("Etiqueta Especie Mascota");
    CreatePet_lblSpecies.getAccessibleContext().setAccessibleDescription("Etiqueta para seleccionar especie");

    CreatePet_lblBreed.setLabelFor(cboxBred_pet);
    CreatePet_lblBreed.setDisplayedMnemonic('R');
    CreatePet_lblBreed.setToolTipText("Seleccionar raza (Alt+R)");
    CreatePet_lblBreed.getAccessibleContext().setAccessibleName("Etiqueta Raza Mascota");
    CreatePet_lblBreed.getAccessibleContext().setAccessibleDescription("Etiqueta que indica la raza de la mascota");

    CreatePet_lblColorPet.setLabelFor(CreatePet_textColorPet);
    CreatePet_lblColorPet.setDisplayedMnemonic('C');
    CreatePet_lblColorPet.setToolTipText("Color de la mascota (Alt+C)");
    CreatePet_lblColorPet.getAccessibleContext().setAccessibleName("Etiqueta Color Mascota");
    CreatePet_lblColorPet.getAccessibleContext().setAccessibleDescription("Etiqueta color de la mascota");

    CreatePet_lblSexPet.setDisplayedMnemonic('S');
    CreatePet_lblSexPet.setLabelFor(sexMacho_Rbutton);
    CreatePet_lblSexPet.setToolTipText("Seleccionar sexo (Alt+S)");
    CreatePet_lblSexPet.getAccessibleContext().setAccessibleName("Etiqueta Sexo Mascota");
    CreatePet_lblSexPet.getAccessibleContext().setAccessibleDescription("Etiqueta sexo de la mascota");

    CreatePet_lblDateBirthdayPet.setLabelFor(CreatePet_lblDateBirthdayPet);
    CreatePet_lblDateBirthdayPet.setDisplayedMnemonic('F');
    CreatePet_lblDateBirthdayPet.setToolTipText("Fecha de nacimiento (Alt+F)");
    CreatePet_lblDateBirthdayPet.getAccessibleContext().setAccessibleName("Etiqueta Fecha de Nacimiento");
    CreatePet_lblDateBirthdayPet.getAccessibleContext().setAccessibleDescription("Etiqueta fecha de nacimiento de la mascota");

    CreatePet_lblOwnerID.setLabelFor(CreatePet_textOwnerDocument);
    CreatePet_lblOwnerID.setDisplayedMnemonic('O');
    CreatePet_lblOwnerID.setToolTipText("Documento del propietario (Alt+O)");
    CreatePet_lblOwnerID.getAccessibleContext().setAccessibleName("Etiqueta Documento Propietario");
    CreatePet_lblOwnerID.getAccessibleContext().setAccessibleDescription("Etiqueta documento del propietario");

    // ---------------------- CAMPOS ----------------------
    CreatePet_tetxNamePet.getAccessibleContext().setAccessibleName("Campo Nombre Mascota");
    CreatePet_tetxNamePet.getAccessibleContext().setAccessibleDescription("Ingrese el nombre de la mascota");

    cboxSpecies_pet.getAccessibleContext().setAccessibleName("Combo Especie Mascota");
    cboxSpecies_pet.getAccessibleContext().setAccessibleDescription("Lista desplegable para elegir la especie");

    cboxBred_pet.getAccessibleContext().setAccessibleName("Combo Raza Mascota");
    cboxBred_pet.getAccessibleContext().setAccessibleDescription("Lista desplegable para elegir la raza");

    CreatePet_textColorPet.getAccessibleContext().setAccessibleName("Campo Color Mascota");
    CreatePet_textColorPet.getAccessibleContext().setAccessibleDescription("Ingrese el color de la mascota");

    CreatePet_lblDateBirthdayPet.getAccessibleContext().setAccessibleName("Campo Fecha de nacimiento");
    CreatePet_lblDateBirthdayPet.getAccessibleContext().setAccessibleDescription("Ingrese fecha formateada YYYY-MM-DD");

    CreatePet_textOwnerDocument.getAccessibleContext().setAccessibleName("Campo Documento Propietario");
    CreatePet_textOwnerDocument.getAccessibleContext().setAccessibleDescription("Ingrese el documento del propietario");

    sexMacho_Rbutton.getAccessibleContext().setAccessibleName("Radio botón Macho");
    sexHembra_Rbutton.getAccessibleContext().setAccessibleName("Radio botón Hembra");

    // ---------------------- BOTONES ----------------------
    btnCreatePet.setMnemonic('G'); // Crear (Guardar)
    btnCreatePet.setToolTipText("Crear mascota (Alt+G)");
    btnCreatePet.getAccessibleContext().setAccessibleName("Botón Crear Mascota");

    bttonEmptyFields_pet.setMnemonic('L'); // Limpiar
    bttonEmptyFields_pet.setToolTipText("Limpiar campos (Alt+L)");
    bttonEmptyFields_pet.getAccessibleContext().setAccessibleName("Botón Limpiar Campos");

    btnExit1.setMnemonic('S'); // Salir
    btnExit1.setToolTipText("Salir (Alt+S)");
    btnExit1.getAccessibleContext().setAccessibleName("Botón Salir");

    // ---------------------- TAB ORDER ----------------------
    CreatePet_tetxNamePet.setNextFocusableComponent(cboxSpecies_pet);
    cboxSpecies_pet.setNextFocusableComponent(cboxBred_pet);
    cboxBred_pet.setNextFocusableComponent(CreatePet_textColorPet);
    CreatePet_textColorPet.setNextFocusableComponent(CreatePet_lblDateBirthdayPet);
    CreatePet_lblDateBirthdayPet.setNextFocusableComponent(CreatePet_textOwnerDocument);
    CreatePet_textOwnerDocument.setNextFocusableComponent(sexMacho_Rbutton);
    sexMacho_Rbutton.setNextFocusableComponent(sexHembra_Rbutton);
    sexHembra_Rbutton.setNextFocusableComponent(btnCreatePet);

    // ---------------------- FOCUSABLE EN PANELS ----------------------
    //CreatePet.setFocusable(true);
    //Down.setFocusable(true);
    //Up.setFocusable(true);

    // ---------------------- ATAJOS ALT GLOBALES ----------------------
    javax.swing.InputMap im = getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
    javax.swing.ActionMap am = getRootPane().getActionMap();

    im.put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_crear");
    am.put("accion_crear", new javax.swing.AbstractAction() {
        @Override public void actionPerformed(java.awt.event.ActionEvent e) { btnCreatePet.doClick(); }
    });

    im.put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_limpiar");
    am.put("accion_limpiar", new javax.swing.AbstractAction() {
        @Override public void actionPerformed(java.awt.event.ActionEvent e) { bttonEmptyFields_pet.doClick(); }
    });

    im.put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK), "accion_salir");
    am.put("accion_salir", new javax.swing.AbstractAction() {
        @Override public void actionPerformed(java.awt.event.ActionEvent e) { btnExit1.doClick(); }
    });
}


}
