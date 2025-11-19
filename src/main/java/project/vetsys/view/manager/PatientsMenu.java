package project.vetsys.view.manager;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import project.vetsys.model.User;

public class PatientsMenu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PatientsMenu.class.getName());
    private User logUser;
    
    public PatientsMenu(User logUser) {
        initComponents();
        aplicarAccesibilidad();
        this.logUser = logUser;
        System.out.println("Usuario logueado en MenuManager: " + logUser.getUsername());
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role()))
        {
            MenuPatients_BttnCreatePatient.setVisible(false);
        }
        setTitle(logUser.getClinic().getName_clinic());
    }

    public PatientsMenu() {
        initComponents();
        aplicarAccesibilidad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPatientsPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuPatients_ImgVetSys = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuPatients_BttnCreatePatient = new javax.swing.JButton();
        MenuPatients_BttnSearchPatient = new javax.swing.JButton();
        MenuPatients_BttnCreatePet = new javax.swing.JButton();
        MenuPatients_BttnSearchPet = new javax.swing.JButton();
        MenuPatients_BttnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        MenuPatientsPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        MenuPatientsPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        MenuPatientsPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        MenuPatientsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(400, 600));
        Left.setMinimumSize(new java.awt.Dimension(400, 600));
        Left.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuPatients_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuPatients_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        MenuPatients_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuPatients_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPatients_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPatients_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        MenuPatientsPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(400, 600));
        Right.setMinimumSize(new java.awt.Dimension(400, 600));
        Right.setPreferredSize(new java.awt.Dimension(500, 600));

        MenuPatients_BttnCreatePatient.setBackground(new java.awt.Color(0, 153, 153));
        MenuPatients_BttnCreatePatient.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuPatients_BttnCreatePatient.setForeground(new java.awt.Color(255, 255, 255));
        MenuPatients_BttnCreatePatient.setText("Registrar Cliente");
        MenuPatients_BttnCreatePatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuPatients_BttnCreatePatient.setFocusPainted(false);
        MenuPatients_BttnCreatePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnCreatePatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnCreatePatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnCreatePatientMouseExited(evt);
            }
        });

        MenuPatients_BttnSearchPatient.setBackground(new java.awt.Color(0, 153, 153));
        MenuPatients_BttnSearchPatient.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuPatients_BttnSearchPatient.setForeground(new java.awt.Color(255, 255, 255));
        MenuPatients_BttnSearchPatient.setText("Consultar Cliente");
        MenuPatients_BttnSearchPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuPatients_BttnSearchPatient.setFocusPainted(false);
        MenuPatients_BttnSearchPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnSearchPatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnSearchPatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnSearchPatientMouseExited(evt);
            }
        });

        MenuPatients_BttnCreatePet.setBackground(new java.awt.Color(0, 153, 153));
        MenuPatients_BttnCreatePet.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuPatients_BttnCreatePet.setForeground(new java.awt.Color(255, 255, 255));
        MenuPatients_BttnCreatePet.setText("Registrar Mascota");
        MenuPatients_BttnCreatePet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuPatients_BttnCreatePet.setFocusPainted(false);
        MenuPatients_BttnCreatePet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnCreatePetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnCreatePetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnCreatePetMouseExited(evt);
            }
        });

        MenuPatients_BttnSearchPet.setBackground(new java.awt.Color(0, 153, 153));
        MenuPatients_BttnSearchPet.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuPatients_BttnSearchPet.setForeground(new java.awt.Color(255, 255, 255));
        MenuPatients_BttnSearchPet.setText("Consultar Mascota");
        MenuPatients_BttnSearchPet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuPatients_BttnSearchPet.setFocusPainted(false);
        MenuPatients_BttnSearchPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnSearchPetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnSearchPetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnSearchPetMouseExited(evt);
            }
        });

        MenuPatients_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        MenuPatients_BttnBack.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuPatients_BttnBack.setForeground(new java.awt.Color(255, 255, 255));
        MenuPatients_BttnBack.setText("Regresar");
        MenuPatients_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuPatients_BttnBack.setFocusPainted(false);
        MenuPatients_BttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuPatients_BttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuPatients_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuPatients_BttnSearchPet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuPatients_BttnCreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuPatients_BttnCreatePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuPatients_BttnSearchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(MenuPatients_BttnCreatePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(MenuPatients_BttnSearchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(MenuPatients_BttnCreatePet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(MenuPatients_BttnSearchPet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(MenuPatients_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        MenuPatientsPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPatientsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPatientsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuPatients_BttnCreatePatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnCreatePatientMouseClicked
        // boton registrar cliente
        System.out.println("MenuManager -> logUser: " +
            (logUser != null ? logUser.getUsername() + " id_clinic=" + logUser.getId_clinic() + " role=" + logUser.getName_role() : "logUser es null"));
        CreateClient CreateClientFrame = new CreateClient(logUser); ///usar constructor con logUser, para no perder la sesión y evitar logUser = null
        CreateClientFrame.setVisible(true);
        CreateClientFrame.pack();
        CreateClientFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuPatients_BttnCreatePatientMouseClicked

    private void MenuPatients_BttnCreatePatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnCreatePatientMouseEntered
        MenuPatients_BttnCreatePatient.setBackground(Color.LIGHT_GRAY);
        MenuPatients_BttnCreatePatient.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuPatients_BttnCreatePatientMouseEntered

    private void MenuPatients_BttnCreatePatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnCreatePatientMouseExited
        MenuPatients_BttnCreatePatient.setBackground(new Color(0,153,153));
        MenuPatients_BttnCreatePatient.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuPatients_BttnCreatePatientMouseExited

    private void MenuPatients_BttnSearchPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnSearchPatientMouseClicked
        //Boton buscar cliente
        System.out.println("MenuManager -> logUser: " +
            (logUser != null ? logUser.getUsername() + " id_clinic=" + logUser.getId_clinic() + " role=" + logUser.getName_role() : "logUser es null"));
        SearchClient SearchClientFrame = new SearchClient(logUser);
        SearchClientFrame.setVisible(true);
        SearchClientFrame.pack();
        SearchClientFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuPatients_BttnSearchPatientMouseClicked

    private void MenuPatients_BttnSearchPatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnSearchPatientMouseEntered
        MenuPatients_BttnSearchPatient.setBackground(Color.LIGHT_GRAY);
        MenuPatients_BttnSearchPatient.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuPatients_BttnSearchPatientMouseEntered

    private void MenuPatients_BttnSearchPatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnSearchPatientMouseExited
        MenuPatients_BttnSearchPatient.setBackground(new Color(0,153,153));
        MenuPatients_BttnSearchPatient.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuPatients_BttnSearchPatientMouseExited

    private void MenuPatients_BttnCreatePetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnCreatePetMouseClicked
        CreatePet createPetFrame = new CreatePet(logUser);
        createPetFrame.setVisible(true);
        createPetFrame.pack();
        createPetFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuPatients_BttnCreatePetMouseClicked

    private void MenuPatients_BttnCreatePetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnCreatePetMouseEntered
        MenuPatients_BttnCreatePet.setBackground(Color.LIGHT_GRAY);
        MenuPatients_BttnCreatePet.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuPatients_BttnCreatePetMouseEntered

    private void MenuPatients_BttnCreatePetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnCreatePetMouseExited
        MenuPatients_BttnCreatePet.setBackground(new Color(0,153,153));
        MenuPatients_BttnCreatePet.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuPatients_BttnCreatePetMouseExited

    private void MenuPatients_BttnSearchPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnSearchPetMouseClicked
        SearchPet searchPetFrame = new SearchPet(logUser);
        searchPetFrame.setVisible(true);
        searchPetFrame.pack();
        searchPetFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuPatients_BttnSearchPetMouseClicked

    private void MenuPatients_BttnSearchPetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnSearchPetMouseEntered
        MenuPatients_BttnSearchPet.setBackground(Color.LIGHT_GRAY);
        MenuPatients_BttnSearchPet.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuPatients_BttnSearchPetMouseEntered

    private void MenuPatients_BttnSearchPetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnSearchPetMouseExited
        MenuPatients_BttnSearchPet.setBackground(new Color(0,153,153));
        MenuPatients_BttnSearchPet.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuPatients_BttnSearchPetMouseExited

    private void MenuPatients_BttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnBackMouseClicked
        MenuManager managerFrame = new MenuManager(logUser);
        managerFrame.setVisible(true);
        managerFrame.pack();
        managerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuPatients_BttnBackMouseClicked

    private void MenuPatients_BttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnBackMouseEntered
        MenuPatients_BttnBack.setBackground(Color.LIGHT_GRAY);
        MenuPatients_BttnBack.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuPatients_BttnBackMouseEntered

    private void MenuPatients_BttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPatients_BttnBackMouseExited
        MenuPatients_BttnBack.setBackground(new Color(0,153,153));
        MenuPatients_BttnBack.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuPatients_BttnBackMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PatientsMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel MenuPatientsPanel;
    private javax.swing.JButton MenuPatients_BttnBack;
    private javax.swing.JButton MenuPatients_BttnCreatePatient;
    private javax.swing.JButton MenuPatients_BttnCreatePet;
    private javax.swing.JButton MenuPatients_BttnSearchPatient;
    private javax.swing.JButton MenuPatients_BttnSearchPet;
    private javax.swing.JLabel MenuPatients_ImgVetSys;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables

        private void aplicarAccesibilidad() {

        // ---------------------------------------------------
        // ------------------ ACCESIBILIDAD ------------------
        // ---------------------------------------------------

        // ===================== PANEL =======================
        MenuPatientsPanel.setFocusable(true);
        Left.setFocusable(true);
        Right.setFocusable(true);

        // ===================== BOTONES =====================

        // --- Registrar Cliente ---
        MenuPatients_BttnCreatePatient.getAccessibleContext().setAccessibleName("Registrar Cliente");
        MenuPatients_BttnCreatePatient.getAccessibleContext().setAccessibleDescription("Abre el formulario para registrar un cliente");
        MenuPatients_BttnCreatePatient.setMnemonic('R'); // Alt + R
        MenuPatients_BttnCreatePatient.setToolTipText("Registrar Cliente (Alt+R)");
        MenuPatients_BttnCreatePatient.setFocusable(true);

        // --- Consultar Cliente ---
        MenuPatients_BttnSearchPatient.getAccessibleContext().setAccessibleName("Consultar Cliente");
        MenuPatients_BttnSearchPatient.getAccessibleContext().setAccessibleDescription("Abre el formulario para consultar clientes");
        MenuPatients_BttnSearchPatient.setMnemonic('C'); // Alt + C
        MenuPatients_BttnSearchPatient.setToolTipText("Consultar Cliente (Alt+C)");
        MenuPatients_BttnSearchPatient.setFocusable(true);

        // --- Registrar Mascota ---
        MenuPatients_BttnCreatePet.getAccessibleContext().setAccessibleName("Registrar Mascota");
        MenuPatients_BttnCreatePet.getAccessibleContext().setAccessibleDescription("Abre el formulario para registrar mascotas");
        MenuPatients_BttnCreatePet.setMnemonic('M'); // Alt + M
        MenuPatients_BttnCreatePet.setToolTipText("Registrar Mascota (Alt+M)");
        MenuPatients_BttnCreatePet.setFocusable(true);

        // --- Consultar Mascota ---
        MenuPatients_BttnSearchPet.getAccessibleContext().setAccessibleName("Consultar Mascota");
        MenuPatients_BttnSearchPet.getAccessibleContext().setAccessibleDescription("Abre el formulario para consultar mascotas");
        MenuPatients_BttnSearchPet.setMnemonic('S'); // Alt + S
        MenuPatients_BttnSearchPet.setToolTipText("Consultar Mascota (Alt+S)");
        MenuPatients_BttnSearchPet.setFocusable(true);

        // --- Regresar ---
        MenuPatients_BttnBack.getAccessibleContext().setAccessibleName("Regresar");
        MenuPatients_BttnBack.getAccessibleContext().setAccessibleDescription("Regresa al menú anterior");
        MenuPatients_BttnBack.setMnemonic('V'); // Alt + V
        MenuPatients_BttnBack.setToolTipText("Regresar (Alt+V)");
        MenuPatients_BttnBack.setFocusable(true);

        // ================= TAB ORDER ======================
        MenuPatients_BttnCreatePatient.setNextFocusableComponent(MenuPatients_BttnSearchPatient);
        MenuPatients_BttnSearchPatient.setNextFocusableComponent(MenuPatients_BttnCreatePet);
        MenuPatients_BttnCreatePet.setNextFocusableComponent(MenuPatients_BttnSearchPet);
        MenuPatients_BttnSearchPet.setNextFocusableComponent(MenuPatients_BttnBack);
        MenuPatients_BttnBack.setNextFocusableComponent(MenuPatients_BttnCreatePatient);

        // ================ ATAJOS GLOBALES ALT ==============
        javax.swing.InputMap inputMap = getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        javax.swing.ActionMap actionMap = getRootPane().getActionMap();

        // --- Registrar Cliente (ALT + R) ---
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.ALT_DOWN_MASK), "registrar_cliente");
        actionMap.put("registrar_cliente", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuPatients_BttnCreatePatient.doClick();
            }
        });

        // --- Consultar Cliente (ALT + C) ---
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.ALT_DOWN_MASK), "consultar_cliente");
        actionMap.put("consultar_cliente", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuPatients_BttnSearchPatient.doClick();
            }
        });

        // --- Registrar Mascota (ALT + M) ---
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.ALT_DOWN_MASK), "registrar_mascota");
        actionMap.put("registrar_mascota", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuPatients_BttnCreatePet.doClick();
            }
        });

        // --- Consultar Mascota (ALT + S) ---
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.ALT_DOWN_MASK), "consultar_mascota");
        actionMap.put("consultar_mascota", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuPatients_BttnSearchPet.doClick();
            }
        });

        // --- Regresar (ALT + V) ---
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.ALT_DOWN_MASK), "regresar");
        actionMap.put("regresar", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuPatients_BttnBack.doClick();
            }
        });
    }


}
