package project.vetsys.view.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import project.vetsys.view.security.LogIn;

import project.vetsys.model.User;
import project.vetsys.view.assistant.NotificationPanel;
import project.vetsys.utils.Utils;


public class MenuManager extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuManager.class.getName());
    private User logUser;
    private Utils utils;
    
    
    public MenuManager(User logUser) {
        initComponents();
        aplicarAccesibilidad();
        conectarAccionesBotones();
        this.logUser = logUser;
        utils = new Utils();
        System.out.println("Usuario logueado en MenuManager: " + logUser.getUsername());
        setTitle("Gestión Veterinaria "+logUser.getClinic().getName_clinic());
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role()))
        {
           //btnCreate.setVisible(false);
        }
    }
    
    public MenuManager() {
        initComponents();
        aplicarAccesibilidad();
        conectarAccionesBotones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuManagerPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuManager_ImgVetSys = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuManager_BttnUsers = new javax.swing.JButton();
        MenuManager_BttnAppointments = new javax.swing.JButton();
        MenuManager_BttnPatients = new javax.swing.JButton();
        MenuManager_BttnNotifications = new javax.swing.JButton();
        MenuManager_BttnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setMinimumSize(new java.awt.Dimension(800, 600));

        MenuManagerPanel.setMaximumSize(getMaximumSize());
        MenuManagerPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        MenuManagerPanel.setPreferredSize(getMaximumSize());
        MenuManagerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(400, 600));
        Left.setMinimumSize(new java.awt.Dimension(400, 600));
        Left.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuManager_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuManager_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuManager_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        MenuManagerPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(400, 600));
        Right.setMinimumSize(new java.awt.Dimension(400, 600));
        Right.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuManager_BttnUsers.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnUsers.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuManager_BttnUsers.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_BttnUsers.setText("Usuarios");
        MenuManager_BttnUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuManager_BttnUsers.setFocusPainted(false);
        MenuManager_BttnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_BttnUsersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_BttnUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_BttnUsersMouseExited(evt);
            }
        });

        MenuManager_BttnAppointments.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnAppointments.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuManager_BttnAppointments.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_BttnAppointments.setText("Citas");
        MenuManager_BttnAppointments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuManager_BttnAppointments.setFocusPainted(false);
        MenuManager_BttnAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_BttnAppointmentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_BttnAppointmentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_BttnAppointmentsMouseExited(evt);
            }
        });

        MenuManager_BttnPatients.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnPatients.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuManager_BttnPatients.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_BttnPatients.setText("Pacientes");
        MenuManager_BttnPatients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuManager_BttnPatients.setFocusPainted(false);
        MenuManager_BttnPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_BttnPatientsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_BttnPatientsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_BttnPatientsMouseExited(evt);
            }
        });

        MenuManager_BttnNotifications.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnNotifications.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuManager_BttnNotifications.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_BttnNotifications.setText("Pendientes");
        MenuManager_BttnNotifications.setToolTipText("");
        MenuManager_BttnNotifications.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuManager_BttnNotifications.setFocusPainted(false);
        MenuManager_BttnNotifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_BttnNotificationsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_BttnNotificationsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_BttnNotificationsMouseExited(evt);
            }
        });

        MenuManager_BttnLogOut.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnLogOut.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MenuManager_BttnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_BttnLogOut.setText("Cerrar Sesion");
        MenuManager_BttnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuManager_BttnLogOut.setFocusPainted(false);
        MenuManager_BttnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_BttnLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_BttnLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_BttnLogOutMouseExited(evt);
            }
        });
        MenuManager_BttnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuManager_BttnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuManager_BttnNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuManager_BttnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuManager_BttnAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuManager_BttnPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuManager_BttnLogOut)
                .addGap(112, 112, 112))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(MenuManager_BttnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(MenuManager_BttnAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(MenuManager_BttnPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(MenuManager_BttnNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(MenuManager_BttnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        MenuManagerPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuManager_BttnUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnUsersMouseClicked
        UsersMenu MenuUserFrame = new UsersMenu(logUser);
        MenuUserFrame.setVisible(true);
        MenuUserFrame.pack();
        MenuUserFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuManager_BttnUsersMouseClicked

    private void MenuManager_BttnUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnUsersMouseEntered
        MenuManager_BttnUsers.setBackground(Color.LIGHT_GRAY);
        MenuManager_BttnUsers.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuManager_BttnUsersMouseEntered

    private void MenuManager_BttnUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnUsersMouseExited
        MenuManager_BttnUsers.setBackground(new Color(0,153,153));
        MenuManager_BttnUsers.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuManager_BttnUsersMouseExited

    private void MenuManager_BttnAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnAppointmentsMouseClicked
        Appointment_Menu MenuAppointmentFrame = new Appointment_Menu(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuManager_BttnAppointmentsMouseClicked

    private void MenuManager_BttnAppointmentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnAppointmentsMouseEntered
        MenuManager_BttnAppointments.setBackground(Color.LIGHT_GRAY);
        MenuManager_BttnAppointments.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuManager_BttnAppointmentsMouseEntered

    private void MenuManager_BttnAppointmentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnAppointmentsMouseExited
        MenuManager_BttnAppointments.setBackground(new Color(0,153,153));
        MenuManager_BttnAppointments.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuManager_BttnAppointmentsMouseExited

    private void MenuManager_BttnPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnPatientsMouseClicked
        PatientsMenu patientFrame = new PatientsMenu(logUser);
        patientFrame.setVisible(true);
        patientFrame.pack();
        patientFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuManager_BttnPatientsMouseClicked

    private void MenuManager_BttnPatientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnPatientsMouseEntered
        MenuManager_BttnPatients.setBackground(Color.LIGHT_GRAY);
        MenuManager_BttnPatients.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuManager_BttnPatientsMouseEntered

    private void MenuManager_BttnPatientsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnPatientsMouseExited
        MenuManager_BttnPatients.setBackground(new Color(0,153,153));
        MenuManager_BttnPatients.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuManager_BttnPatientsMouseExited

    private void MenuManager_BttnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnLogOutMouseClicked
    }//GEN-LAST:event_MenuManager_BttnLogOutMouseClicked

    private void MenuManager_BttnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnLogOutMouseEntered
        MenuManager_BttnLogOut.setBackground(Color.LIGHT_GRAY);
        MenuManager_BttnLogOut.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuManager_BttnLogOutMouseEntered

    private void MenuManager_BttnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnLogOutMouseExited
        MenuManager_BttnLogOut.setBackground(new Color(0,153,153));
        MenuManager_BttnLogOut.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuManager_BttnLogOutMouseExited

    private void MenuManager_BttnNotificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnNotificationsMouseClicked
        NotificationPanel NotificationFrame = new NotificationPanel(logUser);
        NotificationFrame.setVisible(true);
        NotificationFrame.pack();
        NotificationFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuManager_BttnNotificationsMouseClicked

    private void MenuManager_BttnNotificationsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnNotificationsMouseEntered
        MenuManager_BttnNotifications.setBackground(Color.LIGHT_GRAY);
        MenuManager_BttnNotifications.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuManager_BttnNotificationsMouseEntered

    private void MenuManager_BttnNotificationsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_BttnNotificationsMouseExited
        MenuManager_BttnNotifications.setBackground(new Color(0,153,153));
        MenuManager_BttnNotifications.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuManager_BttnNotificationsMouseExited

    private void MenuManager_BttnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuManager_BttnLogOutActionPerformed

    }//GEN-LAST:event_MenuManager_BttnLogOutActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MenuManager().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel MenuManagerPanel;
    private javax.swing.JButton MenuManager_BttnAppointments;
    private javax.swing.JButton MenuManager_BttnLogOut;
    private javax.swing.JButton MenuManager_BttnNotifications;
    private javax.swing.JButton MenuManager_BttnPatients;
    private javax.swing.JButton MenuManager_BttnUsers;
    private javax.swing.JLabel MenuManager_ImgVetSys;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables

        private void aplicarAccesibilidad() {

        // ===================== PANELS ======================
        MenuManagerPanel.setFocusable(true);
        Left.setFocusable(true);
        Right.setFocusable(true);

        // ===================== BOTONES =====================

        // --- Usuarios ---
        MenuManager_BttnUsers.getAccessibleContext().setAccessibleName("Botón Usuarios");
        MenuManager_BttnUsers.getAccessibleContext().setAccessibleDescription("Abrir el menú de gestión de usuarios");
        MenuManager_BttnUsers.setMnemonic('U'); // Alt + U
        MenuManager_BttnUsers.setToolTipText("Usuarios (Alt+U)");
        MenuManager_BttnUsers.setFocusable(true);

        // --- Citas ---
        MenuManager_BttnAppointments.getAccessibleContext().setAccessibleName("Botón Citas");
        MenuManager_BttnAppointments.getAccessibleContext().setAccessibleDescription("Abrir el menú de gestión de citas");
        MenuManager_BttnAppointments.setMnemonic('C'); // Alt + C
        MenuManager_BttnAppointments.setToolTipText("Citas (Alt+C)");
        MenuManager_BttnAppointments.setFocusable(true);

        // --- Pacientes ---
        MenuManager_BttnPatients.getAccessibleContext().setAccessibleName("Botón Pacientes");
        MenuManager_BttnPatients.getAccessibleContext().setAccessibleDescription("Abrir el menú de pacientes");
        MenuManager_BttnPatients.setMnemonic('P'); // Alt + P
        MenuManager_BttnPatients.setToolTipText("Pacientes (Alt+P)");
        MenuManager_BttnPatients.setFocusable(true);

        // --- Cerrar Sesión ---
        MenuManager_BttnLogOut.getAccessibleContext().setAccessibleName("Botón Cerrar Sesión");
        MenuManager_BttnLogOut.getAccessibleContext().setAccessibleDescription("Cerrar sesión y volver al inicio");
        MenuManager_BttnLogOut.setMnemonic('S'); // Alt + S
        MenuManager_BttnLogOut.setToolTipText("Cerrar sesión (Alt+S)");
        MenuManager_BttnLogOut.setFocusable(true);

        // ================= TAB ORDER ======================
        MenuManager_BttnUsers.setNextFocusableComponent(MenuManager_BttnAppointments);
        MenuManager_BttnAppointments.setNextFocusableComponent(MenuManager_BttnPatients);
        MenuManager_BttnPatients.setNextFocusableComponent(MenuManager_BttnLogOut);
        MenuManager_BttnLogOut.setNextFocusableComponent(MenuManager_BttnUsers);

        // ================ ATAJOS GLOBALES ALT ==============

        javax.swing.InputMap inputMap = getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        javax.swing.ActionMap actionMap = getRootPane().getActionMap();

        // --- ALT + U → Usuarios ---
        inputMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK), "open_users");
        actionMap.put("open_users", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuManager_BttnUsers.doClick();
            }
        });

        // --- ALT + C → Citas ---
        inputMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK), "open_appointments");
        actionMap.put("open_appointments", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuManager_BttnAppointments.doClick();
            }
        });

        // --- ALT + P → Pacientes ---
        inputMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK), "open_patients");
        actionMap.put("open_patients", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuManager_BttnPatients.doClick();
            }
        });

        // --- ALT + S → Cerrar sesión ---
        inputMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK), "logout");
        actionMap.put("logout", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                MenuManager_BttnLogOut.doClick();
            }
        });

    }
        private void conectarAccionesBotones() {

        // --- Usuarios ---
        MenuManager_BttnUsers.addActionListener(e -> {
            UsersMenu MenuUserFrame = new UsersMenu(logUser);
            MenuUserFrame.setVisible(true);
            MenuUserFrame.pack();
            MenuUserFrame.setLocationRelativeTo(null);
            this.dispose();
        });

        // --- Citas ---
        MenuManager_BttnAppointments.addActionListener(e -> {
            Appointment_Menu MenuAppointmentFrame = new Appointment_Menu(logUser);
            MenuAppointmentFrame.setVisible(true);
            MenuAppointmentFrame.pack();
            MenuAppointmentFrame.setLocationRelativeTo(null);
            this.dispose();
        });

        // --- Pacientes ---
        MenuManager_BttnPatients.addActionListener(e -> {
            PatientsMenu patientFrame = new PatientsMenu(logUser);
            patientFrame.setVisible(true);
            patientFrame.pack();
            patientFrame.setLocationRelativeTo(null);
            this.dispose();
        });

        // --- Cerrar sesión ---
        MenuManager_BttnLogOut.addActionListener(e -> {
        String messageConfirm = "¿Estas seguro de cerrar serión?";
        String title = logUser.getClinic().getName_clinic();
        if(utils.validation(messageConfirm, title) ==1){
            LogIn LogInFrame = new LogIn();
            LogInFrame.setVisible(true);
            LogInFrame.pack();
            LogInFrame.setLocationRelativeTo(null);
            this.dispose();
        }
        });
    }


}
