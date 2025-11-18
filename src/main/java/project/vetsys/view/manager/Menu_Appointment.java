package project.vetsys.view.manager;

import java.awt.Color;
import project.vetsys.model.User;
import project.vetsys.view.assistant.DeleteAppointment;
import project.vetsys.view.assistant.ScheduleAppointment;
import project.vetsys.view.assistant.SearchAppointment;


public class Menu_Appointment extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu_Appointment.class.getName());
    private User logUser;

       public Menu_Appointment() {
        initComponents();
    }
       
       public Menu_Appointment(User logUser){
            initComponents();
            this.logUser = logUser;
       }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_AppointmentPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuAppointment_lblTitle = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuAppointment_BttnAddAppointment = new javax.swing.JPanel();
        MenuAppointment_lblBttnAddAppointment = new javax.swing.JLabel();
        MenuAppointment_BttnSearchAppointment = new javax.swing.JPanel();
        MenuAppointment_lblBttnSearchAppointment = new javax.swing.JLabel();
        MenuAppointment_BttnDeleteAppointment = new javax.swing.JPanel();
        MenuAppointment_lblBttnDeleteAppointment = new javax.swing.JLabel();
        MenuAppointment_BttnBack = new javax.swing.JPanel();
        MenuAppointment_lblBttnBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Appointment_Menu");
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        Menu_AppointmentPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        Menu_AppointmentPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        Menu_AppointmentPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        Menu_AppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(500, 800));
        Left.setMinimumSize(new java.awt.Dimension(500, 800));
        Left.setPreferredSize(new java.awt.Dimension(500, 800));

        MenuAppointment_lblTitle.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuAppointment_lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAppointment_lblTitle.setText("VetSys");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addComponent(MenuAppointment_lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 144, Short.MAX_VALUE))
        );

        Menu_AppointmentPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Left.getAccessibleContext().setAccessibleName("");

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(500, 800));
        Right.setMinimumSize(new java.awt.Dimension(500, 800));
        Right.setPreferredSize(new java.awt.Dimension(500, 800));

        MenuAppointment_BttnAddAppointment.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_BttnAddAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        MenuAppointment_lblBttnAddAppointment.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuAppointment_lblBttnAddAppointment.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_lblBttnAddAppointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAppointment_lblBttnAddAppointment.setText("Crear Cita");
        MenuAppointment_lblBttnAddAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAppointment_lblBttnAddAppointment.setPreferredSize(new java.awt.Dimension(250, 60));
        MenuAppointment_lblBttnAddAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnAddAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnAddAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnAddAppointmentMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuAppointment_BttnAddAppointmentLayout = new javax.swing.GroupLayout(MenuAppointment_BttnAddAppointment);
        MenuAppointment_BttnAddAppointment.setLayout(MenuAppointment_BttnAddAppointmentLayout);
        MenuAppointment_BttnAddAppointmentLayout.setHorizontalGroup(
            MenuAppointment_BttnAddAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblBttnAddAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        MenuAppointment_BttnAddAppointmentLayout.setVerticalGroup(
            MenuAppointment_BttnAddAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblBttnAddAppointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuAppointment_BttnSearchAppointment.setBackground(new java.awt.Color(0, 153, 153));

        MenuAppointment_lblBttnSearchAppointment.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuAppointment_lblBttnSearchAppointment.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_lblBttnSearchAppointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAppointment_lblBttnSearchAppointment.setText("Consultar Cita");
        MenuAppointment_lblBttnSearchAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAppointment_lblBttnSearchAppointment.setPreferredSize(new java.awt.Dimension(250, 60));
        MenuAppointment_lblBttnSearchAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnSearchAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnSearchAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnSearchAppointmentMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuAppointment_BttnSearchAppointmentLayout = new javax.swing.GroupLayout(MenuAppointment_BttnSearchAppointment);
        MenuAppointment_BttnSearchAppointment.setLayout(MenuAppointment_BttnSearchAppointmentLayout);
        MenuAppointment_BttnSearchAppointmentLayout.setHorizontalGroup(
            MenuAppointment_BttnSearchAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblBttnSearchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        MenuAppointment_BttnSearchAppointmentLayout.setVerticalGroup(
            MenuAppointment_BttnSearchAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblBttnSearchAppointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuAppointment_BttnDeleteAppointment.setBackground(new java.awt.Color(0, 153, 153));

        MenuAppointment_lblBttnDeleteAppointment.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuAppointment_lblBttnDeleteAppointment.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_lblBttnDeleteAppointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAppointment_lblBttnDeleteAppointment.setText("Eliminar Cita");
        MenuAppointment_lblBttnDeleteAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAppointment_lblBttnDeleteAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnDeleteAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnDeleteAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnDeleteAppointmentMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuAppointment_BttnDeleteAppointmentLayout = new javax.swing.GroupLayout(MenuAppointment_BttnDeleteAppointment);
        MenuAppointment_BttnDeleteAppointment.setLayout(MenuAppointment_BttnDeleteAppointmentLayout);
        MenuAppointment_BttnDeleteAppointmentLayout.setHorizontalGroup(
            MenuAppointment_BttnDeleteAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblBttnDeleteAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuAppointment_BttnDeleteAppointmentLayout.setVerticalGroup(
            MenuAppointment_BttnDeleteAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblBttnDeleteAppointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuAppointment_BttnBack.setBackground(new java.awt.Color(0, 153, 153));

        MenuAppointment_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MenuAppointment_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAppointment_lblBttnBack.setText("Regresar");
        MenuAppointment_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAppointment_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuAppointment_BttnBackLayout = new javax.swing.GroupLayout(MenuAppointment_BttnBack);
        MenuAppointment_BttnBack.setLayout(MenuAppointment_BttnBackLayout);
        MenuAppointment_BttnBackLayout.setHorizontalGroup(
            MenuAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblBttnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuAppointment_BttnBackLayout.setVerticalGroup(
            MenuAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_lblBttnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MenuAppointment_BttnDeleteAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuAppointment_BttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuAppointment_BttnSearchAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuAppointment_BttnAddAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuAppointment_BttnAddAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(MenuAppointment_BttnSearchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(MenuAppointment_BttnDeleteAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(MenuAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );

        Menu_AppointmentPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 300, 610));

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

    private void MenuAppointment_lblBttnAddAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnAddAppointmentMouseEntered
        MenuAppointment_BttnAddAppointment.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuAppointment_lblBttnAddAppointmentMouseEntered

    private void MenuAppointment_lblBttnAddAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnAddAppointmentMouseExited
        MenuAppointment_BttnAddAppointment.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuAppointment_lblBttnAddAppointmentMouseExited

    private void MenuAppointment_lblBttnSearchAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnSearchAppointmentMouseEntered
        MenuAppointment_BttnSearchAppointment.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuAppointment_lblBttnSearchAppointmentMouseEntered

    private void MenuAppointment_lblBttnSearchAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnSearchAppointmentMouseExited
        MenuAppointment_BttnSearchAppointment.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuAppointment_lblBttnSearchAppointmentMouseExited

    private void MenuAppointment_lblBttnDeleteAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnDeleteAppointmentMouseEntered
        MenuAppointment_BttnDeleteAppointment.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuAppointment_lblBttnDeleteAppointmentMouseEntered

    private void MenuAppointment_lblBttnDeleteAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnDeleteAppointmentMouseExited
        MenuAppointment_BttnDeleteAppointment.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuAppointment_lblBttnDeleteAppointmentMouseExited

    private void MenuAppointment_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnBackMouseEntered
        MenuAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuAppointment_lblBttnBackMouseEntered

    private void MenuAppointment_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnBackMouseExited
        MenuAppointment_BttnBack.setBackground(new Color(0,153,153));
        UsersMenu MenuManagerFrame = new UsersMenu(logUser);
    }//GEN-LAST:event_MenuAppointment_lblBttnBackMouseExited

    private void MenuAppointment_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnBackMouseClicked
        // TODO add your handling code here:
        MenuManager menuManager = new MenuManager(logUser);
        menuManager.setVisible(true);
        menuManager.pack();
        menuManager.setLocationRelativeTo(null);
        this.dispose();    
    }//GEN-LAST:event_MenuAppointment_lblBttnBackMouseClicked

    private void MenuAppointment_lblBttnSearchAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnSearchAppointmentMouseClicked
        SearchAppointment SearchAppointment = new SearchAppointment(logUser);
        SearchAppointment.setVisible(true);
        SearchAppointment.pack();
        SearchAppointment.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAppointment_lblBttnSearchAppointmentMouseClicked

    private void MenuAppointment_lblBttnDeleteAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnDeleteAppointmentMouseClicked
        DeleteAppointment DeleteAppointment = new DeleteAppointment(logUser);
        DeleteAppointment.setVisible(true);
        DeleteAppointment.pack();
        DeleteAppointment.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAppointment_lblBttnDeleteAppointmentMouseClicked

    private void MenuAppointment_lblBttnAddAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_lblBttnAddAppointmentMouseClicked
        ScheduleAppointment ScheduleAppointment = new ScheduleAppointment(logUser);
        ScheduleAppointment.setVisible(true);
        ScheduleAppointment.pack();
        ScheduleAppointment.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAppointment_lblBttnAddAppointmentMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Menu_Appointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel MenuAppointment_BttnAddAppointment;
    private javax.swing.JPanel MenuAppointment_BttnBack;
    private javax.swing.JPanel MenuAppointment_BttnDeleteAppointment;
    private javax.swing.JPanel MenuAppointment_BttnSearchAppointment;
    private javax.swing.JLabel MenuAppointment_lblBttnAddAppointment;
    private javax.swing.JLabel MenuAppointment_lblBttnBack;
    private javax.swing.JLabel MenuAppointment_lblBttnDeleteAppointment;
    private javax.swing.JLabel MenuAppointment_lblBttnSearchAppointment;
    private javax.swing.JLabel MenuAppointment_lblTitle;
    private javax.swing.JPanel Menu_AppointmentPanel;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables
}
