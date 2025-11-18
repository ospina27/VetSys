package project.vetsys.view.assistant;

import java.awt.Color;
import project.vetsys.model.User;
import project.vetsys.view.manager.Menu_Appointment;
import project.vetsys.view.manager.PatientsMenu;
import project.vetsys.view.security.LogIn;

public class MenuAssistant extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuAssistant.class.getName());
    private User logUser;
    
    public MenuAssistant() {
        initComponents();
    }
    
    public MenuAssistant(User logUser){
        initComponents();
        this.logUser = logUser;
        System.out.println("Usuario logueado en MenuAssistant: " + logUser.getUsername());
        if(!"Asistente".equalsIgnoreCase(logUser.getName_role()))
        {
           //btnCreate.setVisible(false);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuAssistantPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuAssistant_lblTitle = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuAssistant_BttnAppointments = new javax.swing.JPanel();
        MenuAssistant_lblBttnAppointments = new javax.swing.JLabel();
        MenuAssistant_BttnPatient = new javax.swing.JPanel();
        MenuAssistant_lblBttnPatient = new javax.swing.JLabel();
        MenuAssistant_BttnLogOut = new javax.swing.JPanel();
        MenuAssistant_lblBttnLogOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        MenuAssistantPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        MenuAssistantPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        MenuAssistantPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        MenuAssistantPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(500, 800));
        Left.setMinimumSize(new java.awt.Dimension(500, 800));
        Left.setPreferredSize(new java.awt.Dimension(500, 800));

        MenuAssistant_lblTitle.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuAssistant_lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        MenuAssistant_lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAssistant_lblTitle.setText("VetSys");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAssistant_lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAssistant_lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        MenuAssistantPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(500, 800));
        Right.setMinimumSize(new java.awt.Dimension(500, 800));

        MenuAssistant_BttnAppointments.setBackground(new java.awt.Color(0, 153, 153));
        MenuAssistant_BttnAppointments.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAssistant_BttnAppointments.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuAssistant_BttnAppointments.setMinimumSize(new java.awt.Dimension(140, 40));

        MenuAssistant_lblBttnAppointments.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuAssistant_lblBttnAppointments.setForeground(new java.awt.Color(255, 255, 255));
        MenuAssistant_lblBttnAppointments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAssistant_lblBttnAppointments.setText("Citas");
        MenuAssistant_lblBttnAppointments.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAssistant_lblBttnAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnAppointmentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnAppointmentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnAppointmentsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuAssistant_BttnAppointmentsLayout = new javax.swing.GroupLayout(MenuAssistant_BttnAppointments);
        MenuAssistant_BttnAppointments.setLayout(MenuAssistant_BttnAppointmentsLayout);
        MenuAssistant_BttnAppointmentsLayout.setHorizontalGroup(
            MenuAssistant_BttnAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAssistant_lblBttnAppointments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        MenuAssistant_BttnAppointmentsLayout.setVerticalGroup(
            MenuAssistant_BttnAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAssistant_lblBttnAppointments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuAssistant_BttnPatient.setBackground(new java.awt.Color(0, 153, 153));
        MenuAssistant_BttnPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAssistant_BttnPatient.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuAssistant_BttnPatient.setMinimumSize(new java.awt.Dimension(140, 40));

        MenuAssistant_lblBttnPatient.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuAssistant_lblBttnPatient.setForeground(new java.awt.Color(255, 255, 255));
        MenuAssistant_lblBttnPatient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAssistant_lblBttnPatient.setText("Pacientes");
        MenuAssistant_lblBttnPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAssistant_lblBttnPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnPatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnPatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnPatientMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuAssistant_BttnPatientLayout = new javax.swing.GroupLayout(MenuAssistant_BttnPatient);
        MenuAssistant_BttnPatient.setLayout(MenuAssistant_BttnPatientLayout);
        MenuAssistant_BttnPatientLayout.setHorizontalGroup(
            MenuAssistant_BttnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAssistant_lblBttnPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        MenuAssistant_BttnPatientLayout.setVerticalGroup(
            MenuAssistant_BttnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAssistant_lblBttnPatient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuAssistant_BttnLogOut.setBackground(new java.awt.Color(0, 153, 153));
        MenuAssistant_BttnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAssistant_BttnLogOut.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuAssistant_BttnLogOut.setMinimumSize(new java.awt.Dimension(140, 40));

        MenuAssistant_lblBttnLogOut.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuAssistant_lblBttnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        MenuAssistant_lblBttnLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAssistant_lblBttnLogOut.setText("Cerrar Sesion");
        MenuAssistant_lblBttnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAssistant_lblBttnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAssistant_lblBttnLogOutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuAssistant_BttnLogOutLayout = new javax.swing.GroupLayout(MenuAssistant_BttnLogOut);
        MenuAssistant_BttnLogOut.setLayout(MenuAssistant_BttnLogOutLayout);
        MenuAssistant_BttnLogOutLayout.setHorizontalGroup(
            MenuAssistant_BttnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAssistant_lblBttnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        MenuAssistant_BttnLogOutLayout.setVerticalGroup(
            MenuAssistant_BttnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAssistant_lblBttnLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MenuAssistant_BttnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuAssistant_BttnAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuAssistant_BttnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(MenuAssistant_BttnAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(MenuAssistant_BttnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(MenuAssistant_BttnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );

        MenuAssistantPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuAssistantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuAssistantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAssistant_lblBttnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnLogOutMouseClicked
        LogIn LogInFrame = new LogIn();
        LogInFrame.setVisible(true);
        LogInFrame.pack();
        LogInFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAssistant_lblBttnLogOutMouseClicked

    private void MenuAssistant_lblBttnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnLogOutMouseEntered
        MenuAssistant_BttnLogOut.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuAssistant_lblBttnLogOutMouseEntered

    private void MenuAssistant_lblBttnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnLogOutMouseExited
        MenuAssistant_BttnLogOut.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuAssistant_lblBttnLogOutMouseExited

    private void MenuAssistant_lblBttnAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnAppointmentsMouseClicked
        Menu_Appointment MenuAppointmentFrame = new Menu_Appointment(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAssistant_lblBttnAppointmentsMouseClicked

    private void MenuAssistant_lblBttnAppointmentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnAppointmentsMouseEntered
        MenuAssistant_BttnAppointments.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuAssistant_lblBttnAppointmentsMouseEntered

    private void MenuAssistant_lblBttnAppointmentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnAppointmentsMouseExited
        MenuAssistant_BttnAppointments.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuAssistant_lblBttnAppointmentsMouseExited

    private void MenuAssistant_lblBttnPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnPatientMouseClicked

        //JOptionPane.showMessageDialog(this, "Proximo Sprint");
        PatientsMenu petFrame = new PatientsMenu(logUser);
        petFrame.setVisible(true);
        petFrame.pack();
        petFrame.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_MenuAssistant_lblBttnPatientMouseClicked

    private void MenuAssistant_lblBttnPatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnPatientMouseEntered
        MenuAssistant_BttnPatient.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuAssistant_lblBttnPatientMouseEntered

    private void MenuAssistant_lblBttnPatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAssistant_lblBttnPatientMouseExited
        MenuAssistant_BttnPatient.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuAssistant_lblBttnPatientMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MenuAssistant().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel MenuAssistantPanel;
    private javax.swing.JPanel MenuAssistant_BttnAppointments;
    private javax.swing.JPanel MenuAssistant_BttnLogOut;
    private javax.swing.JPanel MenuAssistant_BttnPatient;
    private javax.swing.JLabel MenuAssistant_lblBttnAppointments;
    private javax.swing.JLabel MenuAssistant_lblBttnLogOut;
    private javax.swing.JLabel MenuAssistant_lblBttnPatient;
    private javax.swing.JLabel MenuAssistant_lblTitle;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables
}
