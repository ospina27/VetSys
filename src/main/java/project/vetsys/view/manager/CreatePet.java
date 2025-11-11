package project.vetsys.view.manager;

import java.awt.Color;
import java.sql.Date;
import project.vetsys.model.User;
import javax.swing.JOptionPane;
import project.vetsys.dao.PetDAO;
import project.vetsys.model.Pet;

public class CreatePet extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreatePet.class.getName());
    private User logUser;

    public CreatePet() {
        initComponents();
    }
    
    public CreatePet(User logUser){
        initComponents();
        this.logUser = logUser;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CreatePet = new javax.swing.JPanel();
        Up = new javax.swing.JPanel();
        CreatePet_lblTittle = new javax.swing.JLabel();
        Down = new javax.swing.JPanel();
        CreatePet_lblSubTittle = new javax.swing.JLabel();
        CreatePet_lblNamePet = new javax.swing.JLabel();
        CreatePet_tetxNamePet = new javax.swing.JTextField();
        CreatePet_lblBreed = new javax.swing.JLabel();
        CreatePet_textBreed = new javax.swing.JTextField();
        CreatePet_lblSpecies = new javax.swing.JLabel();
        CreatePet_textSpecies = new javax.swing.JTextField();
        CreatePet_lblColorPet = new javax.swing.JLabel();
        CreatePet_textColorPet = new javax.swing.JTextField();
        CreatePet_lblSexPet = new javax.swing.JLabel();
        CreatePet_textSexPet = new javax.swing.JTextField();
        CreatePet_lblDateBirthdayPet = new javax.swing.JLabel();
        CreatePet_textDateBirthdayPet = new javax.swing.JTextField();
        CreatePet_lblOwnerID = new javax.swing.JLabel();
        CreatePet_textOwnerID = new javax.swing.JTextField();
        CreatePet_BttnBack = new javax.swing.JPanel();
        CreatePet_lblBttnBack = new javax.swing.JLabel();
        CreatePet_BttnAdd = new javax.swing.JPanel();
        CreatePet_lblBttnAdd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));

        CreatePet.setBackground(new java.awt.Color(255, 255, 255));
        CreatePet.setMaximumSize(new java.awt.Dimension(1000, 800));
        CreatePet.setMinimumSize(new java.awt.Dimension(1000, 800));
        CreatePet.setPreferredSize(new java.awt.Dimension(1000, 800));
        CreatePet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Up.setBackground(new java.awt.Color(0, 153, 153));
        Up.setMaximumSize(new java.awt.Dimension(1000, 100));
        Up.setMinimumSize(new java.awt.Dimension(1000, 100));
        Up.setPreferredSize(new java.awt.Dimension(1000, 100));

        CreatePet_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreatePet_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        CreatePet_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreatePet_lblTittle.setText("VetSys");

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreatePet_lblTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreatePet_lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        CreatePet.add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Down.setBackground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(1000, 700));
        Down.setMinimumSize(new java.awt.Dimension(1000, 700));

        CreatePet_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        CreatePet_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        CreatePet_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        CreatePet_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreatePet_lblSubTittle.setText("Crear Mascota");

        CreatePet_lblNamePet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblNamePet.setText("Nombre");

        CreatePet_tetxNamePet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_tetxNamePet.setForeground(java.awt.Color.gray);
        CreatePet_tetxNamePet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_tetxNamePet.setPreferredSize(new java.awt.Dimension(68, 26));
        CreatePet_tetxNamePet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreatePet_tetxNamePetMousePressed(evt);
            }
        });
        CreatePet_tetxNamePet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePet_tetxNamePetActionPerformed(evt);
            }
        });

        CreatePet_lblBreed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblBreed.setText("Raza");

        CreatePet_textBreed.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textBreed.setForeground(java.awt.Color.gray);
        CreatePet_textBreed.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textBreed.setPreferredSize(new java.awt.Dimension(68, 26));
        CreatePet_textBreed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreatePet_textBreedMousePressed(evt);
            }
        });
        CreatePet_textBreed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePet_textBreedActionPerformed(evt);
            }
        });

        CreatePet_lblSpecies.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblSpecies.setText("Especie");

        CreatePet_textSpecies.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textSpecies.setForeground(java.awt.Color.gray);
        CreatePet_textSpecies.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textSpecies.setPreferredSize(new java.awt.Dimension(68, 26));
        CreatePet_textSpecies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreatePet_textSpeciesMousePressed(evt);
            }
        });
        CreatePet_textSpecies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePet_textSpeciesActionPerformed(evt);
            }
        });

        CreatePet_lblColorPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblColorPet.setText("Color");

        CreatePet_textColorPet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textColorPet.setForeground(java.awt.Color.gray);
        CreatePet_textColorPet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textColorPet.setPreferredSize(new java.awt.Dimension(68, 26));
        CreatePet_textColorPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreatePet_textColorPetMousePressed(evt);
            }
        });
        CreatePet_textColorPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePet_textColorPetActionPerformed(evt);
            }
        });

        CreatePet_lblSexPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblSexPet.setText("Sexo");

        CreatePet_textSexPet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textSexPet.setForeground(java.awt.Color.gray);
        CreatePet_textSexPet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textSexPet.setPreferredSize(new java.awt.Dimension(68, 26));
        CreatePet_textSexPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreatePet_textSexPetMousePressed(evt);
            }
        });
        CreatePet_textSexPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePet_textSexPetActionPerformed(evt);
            }
        });

        CreatePet_lblDateBirthdayPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblDateBirthdayPet.setText("Fecha de Nacimiento");

        CreatePet_textDateBirthdayPet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textDateBirthdayPet.setForeground(java.awt.Color.gray);
        CreatePet_textDateBirthdayPet.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textDateBirthdayPet.setPreferredSize(new java.awt.Dimension(68, 26));
        CreatePet_textDateBirthdayPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreatePet_textDateBirthdayPetMousePressed(evt);
            }
        });
        CreatePet_textDateBirthdayPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePet_textDateBirthdayPetActionPerformed(evt);
            }
        });

        CreatePet_lblOwnerID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreatePet_lblOwnerID.setText("Cedula Propietario");

        CreatePet_textOwnerID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_textOwnerID.setForeground(java.awt.Color.gray);
        CreatePet_textOwnerID.setMinimumSize(new java.awt.Dimension(68, 26));
        CreatePet_textOwnerID.setPreferredSize(new java.awt.Dimension(68, 26));
        CreatePet_textOwnerID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreatePet_textOwnerIDMousePressed(evt);
            }
        });
        CreatePet_textOwnerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePet_textOwnerIDActionPerformed(evt);
            }
        });

        CreatePet_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        CreatePet_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CreatePet_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        CreatePet_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        CreatePet_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreatePet_lblBttnBack.setText("Regresar");
        CreatePet_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CreatePet_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreatePet_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreatePet_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreatePet_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout CreatePet_BttnBackLayout = new javax.swing.GroupLayout(CreatePet_BttnBack);
        CreatePet_BttnBack.setLayout(CreatePet_BttnBackLayout);
        CreatePet_BttnBackLayout.setHorizontalGroup(
            CreatePet_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreatePet_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        CreatePet_BttnBackLayout.setVerticalGroup(
            CreatePet_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreatePet_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CreatePet_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CreatePet_BttnAdd.setBackground(new java.awt.Color(0, 153, 153));
        CreatePet_BttnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CreatePet_lblBttnAdd.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        CreatePet_lblBttnAdd.setForeground(new java.awt.Color(255, 255, 255));
        CreatePet_lblBttnAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreatePet_lblBttnAdd.setText("Crear");
        CreatePet_lblBttnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CreatePet_lblBttnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreatePet_lblBttnAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreatePet_lblBttnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreatePet_lblBttnAddMouseExited(evt);
            }
        });

        javax.swing.GroupLayout CreatePet_BttnAddLayout = new javax.swing.GroupLayout(CreatePet_BttnAdd);
        CreatePet_BttnAdd.setLayout(CreatePet_BttnAddLayout);
        CreatePet_BttnAddLayout.setHorizontalGroup(
            CreatePet_BttnAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreatePet_lblBttnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        CreatePet_BttnAddLayout.setVerticalGroup(
            CreatePet_BttnAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePet_BttnAddLayout.createSequentialGroup()
                .addComponent(CreatePet_lblBttnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DownLayout = new javax.swing.GroupLayout(Down);
        Down.setLayout(DownLayout);
        DownLayout.setHorizontalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreatePet_lblSubTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DownLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CreatePet_tetxNamePet, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(CreatePet_lblNamePet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreatePet_textBreed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreatePet_lblBreed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreatePet_textSpecies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreatePet_lblSpecies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreatePet_lblColorPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreatePet_textColorPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreatePet_lblSexPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreatePet_textSexPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CreatePet_lblOwnerID, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(CreatePet_textDateBirthdayPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(CreatePet_lblDateBirthdayPet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_textOwnerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(192, 192, 192))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(CreatePet_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(CreatePet_BttnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addComponent(CreatePet_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_lblNamePet)
                    .addComponent(CreatePet_lblDateBirthdayPet))
                .addGap(6, 6, 6)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_tetxNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_textDateBirthdayPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_lblBreed)
                    .addComponent(CreatePet_lblOwnerID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePet_textBreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_textOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CreatePet_lblSpecies)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreatePet_textSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CreatePet_lblColorPet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreatePet_textColorPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CreatePet_lblSexPet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreatePet_textSexPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreatePet_BttnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );

        CreatePet.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreatePet_textOwnerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePet_textOwnerIDActionPerformed
        
    }//GEN-LAST:event_CreatePet_textOwnerIDActionPerformed

    private void CreatePet_textOwnerIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_textOwnerIDMousePressed
        
    }//GEN-LAST:event_CreatePet_textOwnerIDMousePressed

    private void CreatePet_textDateBirthdayPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePet_textDateBirthdayPetActionPerformed
        
    }//GEN-LAST:event_CreatePet_textDateBirthdayPetActionPerformed

    private void CreatePet_textDateBirthdayPetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_textDateBirthdayPetMousePressed
       /* if (CreatePet_DateOfBirthField.getText().equals("YYYY-MM-DD")){
            CreatePet_DateOfBirthField.setText("");
            CreatePet_DateOfBirthField.setForeground(Color.black);
        }
        if (CreatePet_NameField.getText().isEmpty()){
            CreatePet_NameField.setText("Ingrese Nombre");
            CreatePet_NameField.setForeground(Color.gray);
        }
        if (CreatePet_SpeciesFiel.getText().isEmpty()){
            CreatePet_SpeciesFiel.setText("Ingrese Especie");
            CreatePet_SpeciesFiel.setForeground(Color.gray);
        }
        if (CreatePet_BredField.getText().isEmpty()){
            CreatePet_BredField.setText("Ingrese Raza");
            CreatePet_BredField.setForeground(Color.gray);
        }
        if (CreatePet_ColorField.getText().isEmpty()){
            CreatePet_ColorField.setText("Ingrese Color");
            CreatePet_ColorField.setForeground(Color.gray);
        }
        if (CreatePet_SexField.getText().isEmpty()){
            CreatePet_SexField.setText("Ingrese Sexo");
            CreatePet_SexField.setForeground(Color.gray);
        }*/
       
    }//GEN-LAST:event_CreatePet_textDateBirthdayPetMousePressed

    private void CreatePet_textSexPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePet_textSexPetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreatePet_textSexPetActionPerformed

    private void CreatePet_textSexPetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_textSexPetMousePressed
        /*if (CreatePet_SexField.getText().equals("Ingrese sexo")){
            CreatePet_SexField.setText("");
            CreatePet_SexField.setForeground(Color.black);
        }
        if (CreatePet_NameField.getText().isEmpty()){
            CreatePet_NameField.setText("Ingrese Nombre");
            CreatePet_NameField.setForeground(Color.gray);
        }
        if (CreatePet_SpeciesFiel.getText().isEmpty()){
            CreatePet_SpeciesFiel.setText("Ingrese Especie");
            CreatePet_SpeciesFiel.setForeground(Color.gray);
        }
        if (CreatePet_BredField.getText().isEmpty()){
            CreatePet_BredField.setText("Ingrese Raza");
            CreatePet_BredField.setForeground(Color.gray);
        }
        if (CreatePet_ColorField.getText().isEmpty()){
            CreatePet_ColorField.setText("Ingrese Color");
            CreatePet_ColorField.setForeground(Color.gray);
        }
        if (CreatePet_DateOfBirthField.getText().isEmpty()){
            CreatePet_DateOfBirthField.setText("YYYY-MM-DD");
            CreatePet_DateOfBirthField.setForeground(Color.gray);
        }*/
       
    }//GEN-LAST:event_CreatePet_textSexPetMousePressed

    private void CreatePet_textColorPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePet_textColorPetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreatePet_textColorPetActionPerformed

    private void CreatePet_textColorPetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_textColorPetMousePressed
        /*if (CreatePet_ColorField.getText().equals("Ingrese Color")){
            CreatePet_ColorField.setText("");
            CreatePet_ColorField.setForeground(Color.black);
        }
        if (CreatePet_NameField.getText().isEmpty()){
            CreatePet_NameField.setText("Ingrese Nombre");
            CreatePet_NameField.setForeground(Color.gray);
        }
        if (CreatePet_SpeciesFiel.getText().isEmpty()){
            CreatePet_SpeciesFiel.setText("Ingrese Especie");
            CreatePet_SpeciesFiel.setForeground(Color.gray);
        }
        if (CreatePet_BredField.getText().isEmpty()){
            CreatePet_BredField.setText("Ingrese Raza");
            CreatePet_BredField.setForeground(Color.gray);
        }
        if (CreatePet_SexField.getText().isEmpty()){
            CreatePet_SexField.setText("Ingrese Sexo");
            CreatePet_SexField.setForeground(Color.gray);
        }
        if (CreatePet_DateOfBirthField.getText().isEmpty()){
            CreatePet_DateOfBirthField.setText("YYYY-MM-DD");
            CreatePet_DateOfBirthField.setForeground(Color.gray);
        }*/
      
    }//GEN-LAST:event_CreatePet_textColorPetMousePressed

    private void CreatePet_textBreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePet_textBreedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreatePet_textBreedActionPerformed

    private void CreatePet_textBreedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_textBreedMousePressed
        /*if (CreatePet_BredField.getText().equals("Ingrese Raza")){
            CreatePet_BredField.setText("");
            CreatePet_BredField.setForeground(Color.black);
        }
        if (CreatePet_NameField.getText().isEmpty()){
            CreatePet_NameField.setText("Ingrese Nombre");
            CreatePet_NameField.setForeground(Color.gray);
        }
        if (CreatePet_SpeciesFiel.getText().isEmpty()){
            CreatePet_SpeciesFiel.setText("Ingrese Especie");
            CreatePet_SpeciesFiel.setForeground(Color.gray);
        }
        if (CreatePet_ColorField.getText().isEmpty()){
            CreatePet_ColorField.setText("Ingrese Color");
            CreatePet_ColorField.setForeground(Color.gray);
        }
        if (CreatePet_SexField.getText().isEmpty()){
            CreatePet_SexField.setText("Ingrese Sexo");
            CreatePet_SexField.setForeground(Color.gray);
        }
        if (CreatePet_DateOfBirthField.getText().isEmpty()){
            CreatePet_DateOfBirthField.setText("YYYY-MM-DD");
            CreatePet_DateOfBirthField.setForeground(Color.gray);
        }*/
    }//GEN-LAST:event_CreatePet_textBreedMousePressed

    private void CreatePet_textSpeciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePet_textSpeciesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreatePet_textSpeciesActionPerformed

    private void CreatePet_textSpeciesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_textSpeciesMousePressed
        /*if (CreatePet_SpeciesFiel.getText().equals("Ingrese su Apellido")){
            CreatePet_SpeciesFiel.setText("");
            CreatePet_SpeciesFiel.setForeground(Color.black);
        }
        if (CreatePet_NameField.getText().equals("Ingrese Nombre")){
            CreatePet_NameField.setText("");
            CreatePet_NameField.setForeground(Color.black);
        }
        if (CreatePet_BredField.getText().isEmpty()){
            CreatePet_BredField.setText("Ingrese Raza");
            CreatePet_BredField.setForeground(Color.gray);
        }
        if (CreatePet_ColorField.getText().isEmpty()){
            CreatePet_ColorField.setText("Ingrese Color");
            CreatePet_ColorField.setForeground(Color.gray);
        }
        if (CreatePet_SexField.getText().isEmpty()){
            CreatePet_SexField.setText("Ingrese Sexo");
            CreatePet_SexField.setForeground(Color.gray);
        }
        if (CreatePet_DateOfBirthField.getText().isEmpty()){
            CreatePet_DateOfBirthField.setText("YYYY-MM-DD");
            CreatePet_DateOfBirthField.setForeground(Color.gray);
        }
        */
    }//GEN-LAST:event_CreatePet_textSpeciesMousePressed

    private void CreatePet_tetxNamePetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePet_tetxNamePetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreatePet_tetxNamePetActionPerformed

    private void CreatePet_tetxNamePetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_tetxNamePetMousePressed
        /*if (CreatePet_NameField.getText().equals("Ingrese Nombre")){
            CreatePet_NameField.setText("");
            CreatePet_NameField.setForeground(Color.black);
        }
        if (CreatePet_SpeciesFiel.getText().isEmpty()){
            CreatePet_SpeciesFiel.setText("Ingrese Especie");
            CreatePet_SpeciesFiel.setForeground(Color.gray);
        }
        if (CreatePet_BredField.getText().isEmpty()){
            CreatePet_BredField.setText("Ingrese Raza");
            CreatePet_BredField.setForeground(Color.gray);
        }
        if (CreatePet_ColorField.getText().isEmpty()){
            CreatePet_ColorField.setText("Ingrese Color");
            CreatePet_ColorField.setForeground(Color.gray);
        }
        if (CreatePet_SexField.getText().isEmpty()){
            CreatePet_SexField.setText("Ingrese Sexo");
            CreatePet_SexField.setForeground(Color.gray);
        }
        if (CreatePet_DateOfBirthField.getText().isEmpty()){
            CreatePet_DateOfBirthField.setText("YYYY-MM-DD");
            CreatePet_DateOfBirthField.setForeground(Color.gray);
        }
      */
    }//GEN-LAST:event_CreatePet_tetxNamePetMousePressed

    private void CreatePet_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_lblBttnBackMouseClicked
        //siempre que se llame al MenuManager, hacerlo con el constructor con parametro de logUser
        UsersMenu MenuManagerFrame = new UsersMenu(logUser);
        MenuManagerFrame.setVisible(true);
        MenuManagerFrame.pack();
        MenuManagerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_CreatePet_lblBttnBackMouseClicked

    private void CreatePet_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_lblBttnBackMouseEntered
        CreatePet_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CreatePet_lblBttnBackMouseEntered

    private void CreatePet_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_lblBttnBackMouseExited
        CreatePet_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_CreatePet_lblBttnBackMouseExited

    private void CreatePet_lblBttnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_lblBttnAddMouseClicked
        String namePet = CreatePet_tetxNamePet.getText();
        String speciesPet = CreatePet_textSpecies.getText();
        String bredPet = CreatePet_textBreed.getText();
        String colorPet = CreatePet_textColorPet.getText();
        String sexPet = CreatePet_textSexPet.getText();
        String datePet = CreatePet_textDateBirthdayPet.getText();
        String documentOwner = CreatePet_textOwnerID.getText();
        
        if (namePet.isEmpty() || documentOwner.isEmpty() || speciesPet.isEmpty() || bredPet.isEmpty() 
                ||colorPet.isEmpty() || sexPet.isEmpty() || datePet.isEmpty()  ) 
        {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos obligatorios");
            return;
        }
        
        Pet pet = new Pet();
        PetDAO petDao = new PetDAO();
        pet.setName_Pet(namePet);
        pet.setSpecies(speciesPet);
        pet.setBred(bredPet);
        pet.setColor(colorPet);
        pet.setSex(sexPet);
        pet.setDate_of_birth(Date.valueOf(datePet));
        int document = petDao.searchIdOwner(documentOwner); ///pasar el documento para buscar el idCliente
        pet.setId_Client(document);
        pet.setId_Clinic(logUser.getId_clinic());
        
        boolean success = petDao.Create(pet, documentOwner);
        
        if(success){
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario creado correctamente");
        }else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al crear el usuario. Revisa los datos o la conexión.");
        }
    }//GEN-LAST:event_CreatePet_lblBttnAddMouseClicked

    private void CreatePet_lblBttnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_lblBttnAddMouseEntered
        CreatePet_BttnAdd.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CreatePet_lblBttnAddMouseEntered

    private void CreatePet_lblBttnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePet_lblBttnAddMouseExited
        CreatePet_BttnAdd.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_CreatePet_lblBttnAddMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CreatePet().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreatePet;
    private javax.swing.JPanel CreatePet_BttnAdd;
    private javax.swing.JPanel CreatePet_BttnBack;
    private javax.swing.JLabel CreatePet_lblBreed;
    private javax.swing.JLabel CreatePet_lblBttnAdd;
    private javax.swing.JLabel CreatePet_lblBttnBack;
    private javax.swing.JLabel CreatePet_lblColorPet;
    private javax.swing.JLabel CreatePet_lblDateBirthdayPet;
    private javax.swing.JLabel CreatePet_lblNamePet;
    private javax.swing.JLabel CreatePet_lblOwnerID;
    private javax.swing.JLabel CreatePet_lblSexPet;
    private javax.swing.JLabel CreatePet_lblSpecies;
    private javax.swing.JLabel CreatePet_lblSubTittle;
    private javax.swing.JLabel CreatePet_lblTittle;
    private javax.swing.JTextField CreatePet_tetxNamePet;
    private javax.swing.JTextField CreatePet_textBreed;
    private javax.swing.JTextField CreatePet_textColorPet;
    private javax.swing.JTextField CreatePet_textDateBirthdayPet;
    private javax.swing.JTextField CreatePet_textOwnerID;
    private javax.swing.JTextField CreatePet_textSexPet;
    private javax.swing.JTextField CreatePet_textSpecies;
    private javax.swing.JPanel Down;
    private javax.swing.JPanel Up;
    // End of variables declaration//GEN-END:variables
}
