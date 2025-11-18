package project.vetsys.view.manager;

import java.awt.Color;
import project.vetsys.model.User;
import project.vetsys.view.assistant.DeleteAppointment;
import project.vetsys.view.assistant.SearchAppointment;


public class Appointment_Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Appointment_Menu.class.getName());
    private User logUser;

       public Appointment_Menu() {
        initComponents();
    }
       
       public Appointment_Menu(User logUser){
            initComponents();
            this.logUser = logUser;
       }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_AppointmentPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuAppointment_ImgVetSys = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuAppointment_BttnScheduleAppointment = new javax.swing.JButton();
        MenuAppointment_BttnSearchAppointment = new javax.swing.JButton();
        MenuAppointment_BttnDeleteAppointment = new javax.swing.JButton();
        MenuAppointment_BttnBacks = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Appointment_Menu");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        Menu_AppointmentPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        Menu_AppointmentPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        Menu_AppointmentPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        Menu_AppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(400, 600));
        Left.setMinimumSize(new java.awt.Dimension(400, 600));
        Left.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuAppointment_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuAppointment_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAppointment_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_ImgVetSys, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        Menu_AppointmentPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Left.getAccessibleContext().setAccessibleName("");

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(400, 600));
        Right.setMinimumSize(new java.awt.Dimension(400, 600));
        Right.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuAppointment_BttnScheduleAppointment.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_BttnScheduleAppointment.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuAppointment_BttnScheduleAppointment.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_BttnScheduleAppointment.setText("Agendar Cita");
        MenuAppointment_BttnScheduleAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAppointment_BttnScheduleAppointment.setFocusPainted(false);
        MenuAppointment_BttnScheduleAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnScheduleAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnScheduleAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnScheduleAppointmentMouseExited(evt);
            }
        });

        MenuAppointment_BttnSearchAppointment.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_BttnSearchAppointment.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuAppointment_BttnSearchAppointment.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_BttnSearchAppointment.setText("Consultar Cita");
        MenuAppointment_BttnSearchAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAppointment_BttnSearchAppointment.setFocusPainted(false);
        MenuAppointment_BttnSearchAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnSearchAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnSearchAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnSearchAppointmentMouseExited(evt);
            }
        });

        MenuAppointment_BttnDeleteAppointment.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_BttnDeleteAppointment.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuAppointment_BttnDeleteAppointment.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_BttnDeleteAppointment.setText("Eliminar Cita");
        MenuAppointment_BttnDeleteAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAppointment_BttnDeleteAppointment.setFocusPainted(false);
        MenuAppointment_BttnDeleteAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnDeleteAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnDeleteAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnDeleteAppointmentMouseExited(evt);
            }
        });

        MenuAppointment_BttnBacks.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_BttnBacks.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuAppointment_BttnBacks.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_BttnBacks.setText("Regresar");
        MenuAppointment_BttnBacks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAppointment_BttnBacks.setFocusPainted(false);
        MenuAppointment_BttnBacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnBacksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnBacksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnBacksMouseExited(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MenuAppointment_BttnBacks, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuAppointment_BttnDeleteAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuAppointment_BttnSearchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuAppointment_BttnScheduleAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(MenuAppointment_BttnScheduleAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(MenuAppointment_BttnSearchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(MenuAppointment_BttnDeleteAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(MenuAppointment_BttnBacks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        Menu_AppointmentPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu_AppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu_AppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAppointment_BttnScheduleAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnScheduleAppointmentMouseClicked
        UsersMenu MenuUserFrame = new UsersMenu(logUser);
        MenuUserFrame.setVisible(true);
        MenuUserFrame.pack();
        MenuUserFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAppointment_BttnScheduleAppointmentMouseClicked

    private void MenuAppointment_BttnScheduleAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnScheduleAppointmentMouseEntered
        MenuAppointment_BttnScheduleAppointment.setBackground(Color.LIGHT_GRAY);
        MenuAppointment_BttnScheduleAppointment.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuAppointment_BttnScheduleAppointmentMouseEntered

    private void MenuAppointment_BttnScheduleAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnScheduleAppointmentMouseExited
        MenuAppointment_BttnScheduleAppointment.setBackground(new Color(0,153,153));
        MenuAppointment_BttnScheduleAppointment.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuAppointment_BttnScheduleAppointmentMouseExited

    private void MenuAppointment_BttnSearchAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnSearchAppointmentMouseClicked
        SearchAppointment SearchAppointment = new SearchAppointment(logUser);
        SearchAppointment.setVisible(true);
        SearchAppointment.pack();
        SearchAppointment.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAppointment_BttnSearchAppointmentMouseClicked

    private void MenuAppointment_BttnSearchAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnSearchAppointmentMouseEntered
        MenuAppointment_BttnSearchAppointment.setBackground(Color.LIGHT_GRAY);
        MenuAppointment_BttnSearchAppointment.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuAppointment_BttnSearchAppointmentMouseEntered

    private void MenuAppointment_BttnSearchAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnSearchAppointmentMouseExited
        MenuAppointment_BttnSearchAppointment.setBackground(new Color(0,153,153));
        MenuAppointment_BttnSearchAppointment.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuAppointment_BttnSearchAppointmentMouseExited

    private void MenuAppointment_BttnDeleteAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnDeleteAppointmentMouseClicked
        DeleteAppointment DeleteAppointment = new DeleteAppointment(logUser);
        DeleteAppointment.setVisible(true);
        DeleteAppointment.pack();
        DeleteAppointment.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAppointment_BttnDeleteAppointmentMouseClicked

    private void MenuAppointment_BttnDeleteAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnDeleteAppointmentMouseEntered
        MenuAppointment_BttnDeleteAppointment.setBackground(Color.LIGHT_GRAY);
        MenuAppointment_BttnDeleteAppointment.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuAppointment_BttnDeleteAppointmentMouseEntered

    private void MenuAppointment_BttnDeleteAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnDeleteAppointmentMouseExited
        MenuAppointment_BttnDeleteAppointment.setBackground(new Color(0,153,153));
        MenuAppointment_BttnDeleteAppointment.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuAppointment_BttnDeleteAppointmentMouseExited

    private void MenuAppointment_BttnBacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnBacksMouseClicked
        MenuManager menuManager = new MenuManager(logUser);
        menuManager.setVisible(true);
        menuManager.pack();
        menuManager.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAppointment_BttnBacksMouseClicked

    private void MenuAppointment_BttnBacksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnBacksMouseEntered
        MenuAppointment_BttnBacks.setBackground(Color.LIGHT_GRAY);
        MenuAppointment_BttnBacks.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuAppointment_BttnBacksMouseEntered

    private void MenuAppointment_BttnBacksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnBacksMouseExited
        MenuAppointment_BttnBacks.setBackground(new Color(0,153,153));
        MenuAppointment_BttnBacks.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuAppointment_BttnBacksMouseExited

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Appointment_Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton MenuAppointment_BttnBacks;
    private javax.swing.JButton MenuAppointment_BttnDeleteAppointment;
    private javax.swing.JButton MenuAppointment_BttnScheduleAppointment;
    private javax.swing.JButton MenuAppointment_BttnSearchAppointment;
    private javax.swing.JLabel MenuAppointment_ImgVetSys;
    private javax.swing.JPanel Menu_AppointmentPanel;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables
}
