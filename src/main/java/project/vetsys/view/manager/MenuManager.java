package project.vetsys.view.manager;

import java.awt.Color;
import javax.swing.JOptionPane;
import project.vetsys.view.security.LogIn;

import project.vetsys.model.User;


public class MenuManager extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuManager.class.getName());
    private User logUser;
    
    
    public MenuManager(User logUser) {
        initComponents();
        this.logUser = logUser;
        System.out.println("Usuario logueado en MenuManager: " + logUser.getUsername());
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role()))
        {
           //btnCreate.setVisible(false);
        }
    }
    
    public MenuManager() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuManagerPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuManager_lblTitle = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuManager_BttnUsers = new javax.swing.JPanel();
        MenuManager_lblBttnUsers = new javax.swing.JLabel();
        MenuManager_BttnAppointments = new javax.swing.JPanel();
        MenuManager_lblBttnAppointments = new javax.swing.JLabel();
        MenuManager_BttnPatient = new javax.swing.JPanel();
        MenuManager_lblBttnPatient = new javax.swing.JLabel();
        MenuManager_BttnLogOut = new javax.swing.JPanel();
        MenuManager_lblBttnLogOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        MenuManagerPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        MenuManagerPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        MenuManagerPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        MenuManagerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(500, 800));
        Left.setMinimumSize(new java.awt.Dimension(500, 800));
        Left.setPreferredSize(new java.awt.Dimension(500, 800));

        MenuManager_lblTitle.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuManager_lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuManager_lblTitle.setText("VetSys");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addComponent(MenuManager_lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addComponent(MenuManager_lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 273, Short.MAX_VALUE))
        );

        MenuManagerPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 600));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(500, 800));
        Right.setMinimumSize(new java.awt.Dimension(500, 800));
        Right.setPreferredSize(new java.awt.Dimension(500, 800));

        MenuManager_BttnUsers.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuManager_BttnUsers.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuManager_BttnUsers.setMinimumSize(new java.awt.Dimension(140, 40));
        MenuManager_BttnUsers.setPreferredSize(new java.awt.Dimension(140, 40));

        MenuManager_lblBttnUsers.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuManager_lblBttnUsers.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_lblBttnUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuManager_lblBttnUsers.setText("Usuarios");
        MenuManager_lblBttnUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuManager_lblBttnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnUsersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnUsersMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuManager_BttnUsersLayout = new javax.swing.GroupLayout(MenuManager_BttnUsers);
        MenuManager_BttnUsers.setLayout(MenuManager_BttnUsersLayout);
        MenuManager_BttnUsersLayout.setHorizontalGroup(
            MenuManager_BttnUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_lblBttnUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        MenuManager_BttnUsersLayout.setVerticalGroup(
            MenuManager_BttnUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_lblBttnUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuManager_BttnAppointments.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnAppointments.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuManager_BttnAppointments.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuManager_BttnAppointments.setMinimumSize(new java.awt.Dimension(140, 40));
        MenuManager_BttnAppointments.setPreferredSize(new java.awt.Dimension(140, 40));

        MenuManager_lblBttnAppointments.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuManager_lblBttnAppointments.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_lblBttnAppointments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuManager_lblBttnAppointments.setText("Citas");
        MenuManager_lblBttnAppointments.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuManager_lblBttnAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnAppointmentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnAppointmentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnAppointmentsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuManager_BttnAppointmentsLayout = new javax.swing.GroupLayout(MenuManager_BttnAppointments);
        MenuManager_BttnAppointments.setLayout(MenuManager_BttnAppointmentsLayout);
        MenuManager_BttnAppointmentsLayout.setHorizontalGroup(
            MenuManager_BttnAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_lblBttnAppointments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        MenuManager_BttnAppointmentsLayout.setVerticalGroup(
            MenuManager_BttnAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_lblBttnAppointments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuManager_BttnPatient.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuManager_BttnPatient.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuManager_BttnPatient.setMinimumSize(new java.awt.Dimension(140, 40));
        MenuManager_BttnPatient.setPreferredSize(new java.awt.Dimension(140, 40));

        MenuManager_lblBttnPatient.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuManager_lblBttnPatient.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_lblBttnPatient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuManager_lblBttnPatient.setText("Pacientes");
        MenuManager_lblBttnPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuManager_lblBttnPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnPatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnPatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnPatientMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuManager_BttnPatientLayout = new javax.swing.GroupLayout(MenuManager_BttnPatient);
        MenuManager_BttnPatient.setLayout(MenuManager_BttnPatientLayout);
        MenuManager_BttnPatientLayout.setHorizontalGroup(
            MenuManager_BttnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_lblBttnPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        MenuManager_BttnPatientLayout.setVerticalGroup(
            MenuManager_BttnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_lblBttnPatient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuManager_BttnLogOut.setBackground(new java.awt.Color(0, 153, 153));
        MenuManager_BttnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuManager_BttnLogOut.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuManager_BttnLogOut.setMinimumSize(new java.awt.Dimension(140, 40));

        MenuManager_lblBttnLogOut.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuManager_lblBttnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        MenuManager_lblBttnLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuManager_lblBttnLogOut.setText("Cerrar Sesion");
        MenuManager_lblBttnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuManager_lblBttnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuManager_lblBttnLogOutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuManager_BttnLogOutLayout = new javax.swing.GroupLayout(MenuManager_BttnLogOut);
        MenuManager_BttnLogOut.setLayout(MenuManager_BttnLogOutLayout);
        MenuManager_BttnLogOutLayout.setHorizontalGroup(
            MenuManager_BttnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_lblBttnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        MenuManager_BttnLogOutLayout.setVerticalGroup(
            MenuManager_BttnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuManager_lblBttnLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuManager_BttnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuManager_BttnAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuManager_BttnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuManager_BttnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(MenuManager_BttnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(MenuManager_BttnAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(MenuManager_BttnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(MenuManager_BttnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(470, 470, 470))
        );

        MenuManagerPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 330, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuManagerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuManagerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuManager_lblBttnAppointmentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnAppointmentsMouseEntered
        MenuManager_BttnAppointments.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuManager_lblBttnAppointmentsMouseEntered

    private void MenuManager_lblBttnAppointmentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnAppointmentsMouseExited
        MenuManager_BttnAppointments.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuManager_lblBttnAppointmentsMouseExited

    private void MenuManager_lblBttnUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnUsersMouseEntered
        MenuManager_BttnUsers.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuManager_lblBttnUsersMouseEntered

    private void MenuManager_lblBttnUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnUsersMouseExited
        MenuManager_BttnUsers.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuManager_lblBttnUsersMouseExited

    private void MenuManager_lblBttnPatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnPatientMouseEntered
        MenuManager_BttnPatient.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuManager_lblBttnPatientMouseEntered

    private void MenuManager_lblBttnPatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnPatientMouseExited
        MenuManager_BttnPatient.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuManager_lblBttnPatientMouseExited

    private void MenuManager_lblBttnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnLogOutMouseEntered
        MenuManager_BttnLogOut.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuManager_lblBttnLogOutMouseEntered

    private void MenuManager_lblBttnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnLogOutMouseExited
        MenuManager_BttnLogOut.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuManager_lblBttnLogOutMouseExited

    private void MenuManager_lblBttnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnLogOutMouseClicked
        LogIn LogInFrame = new LogIn();
        LogInFrame.setVisible(true);
        LogInFrame.pack();
        LogInFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuManager_lblBttnLogOutMouseClicked

    private void MenuManager_lblBttnPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnPatientMouseClicked
        PatientsMenu patientFrame = new PatientsMenu(logUser);
        patientFrame.setVisible(true);
        patientFrame.pack();
        patientFrame.setLocationRelativeTo(null);
        this.dispose();        
    }//GEN-LAST:event_MenuManager_lblBttnPatientMouseClicked

    private void MenuManager_lblBttnAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnAppointmentsMouseClicked
        Menu_Appointment MenuAppointmentFrame = new Menu_Appointment(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuManager_lblBttnAppointmentsMouseClicked

    private void MenuManager_lblBttnUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuManager_lblBttnUsersMouseClicked
        UsersMenu MenuUserFrame = new UsersMenu(logUser);
        MenuUserFrame.setVisible(true);
        MenuUserFrame.pack();
        MenuUserFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuManager_lblBttnUsersMouseClicked

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MenuManager().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel MenuManagerPanel;
    private javax.swing.JPanel MenuManager_BttnAppointments;
    private javax.swing.JPanel MenuManager_BttnLogOut;
    private javax.swing.JPanel MenuManager_BttnPatient;
    private javax.swing.JPanel MenuManager_BttnUsers;
    private javax.swing.JLabel MenuManager_lblBttnAppointments;
    private javax.swing.JLabel MenuManager_lblBttnLogOut;
    private javax.swing.JLabel MenuManager_lblBttnPatient;
    private javax.swing.JLabel MenuManager_lblBttnUsers;
    private javax.swing.JLabel MenuManager_lblTitle;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables
}
