package project.vetsys.view.manager;

import java.awt.Color;
import project.vetsys.model.User;

public class UsersMenu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UsersMenu.class.getName());
    private User logUser;
    
    public UsersMenu(User logUser) {
        initComponents();
        this.logUser = logUser;
        System.out.println("Usuario logueado en MenuManager: " + logUser.getUsername());
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role()))
        {
            MenuUsers_BttnAddUsers.setVisible(false);
        }
        setTitle(logUser.getClinic().getName_clinic());
    }

    public UsersMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuUsersPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuUsers_lblTitle = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuUsers_BttnAddUsers = new javax.swing.JPanel();
        MenuUsers_lblBttnAddUsers = new javax.swing.JLabel();
        MenuUsers_BttnSearchUsers = new javax.swing.JPanel();
        MenuUsers_lblBttnSearchUsers = new javax.swing.JLabel();
        MenuUsers_BttnBack = new javax.swing.JPanel();
        MenuUsers_lblBttnBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        MenuUsersPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        MenuUsersPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        MenuUsersPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        MenuUsersPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(500, 800));
        Left.setMinimumSize(new java.awt.Dimension(500, 800));

        MenuUsers_lblTitle.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuUsers_lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuUsers_lblTitle.setText("VetSys");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsers_lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addComponent(MenuUsers_lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MenuUsersPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(500, 800));
        Right.setMinimumSize(new java.awt.Dimension(500, 800));

        MenuUsers_BttnAddUsers.setBackground(new java.awt.Color(0, 153, 153));
        MenuUsers_BttnAddUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuUsers_BttnAddUsers.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuUsers_BttnAddUsers.setMinimumSize(new java.awt.Dimension(140, 40));
        MenuUsers_BttnAddUsers.setPreferredSize(new java.awt.Dimension(140, 40));

        MenuUsers_lblBttnAddUsers.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        MenuUsers_lblBttnAddUsers.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_lblBttnAddUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuUsers_lblBttnAddUsers.setText("Crear Usuario");
        MenuUsers_lblBttnAddUsers.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuUsers_lblBttnAddUsers.setMinimumSize(new java.awt.Dimension(140, 40));
        MenuUsers_lblBttnAddUsers.setPreferredSize(new java.awt.Dimension(140, 40));
        MenuUsers_lblBttnAddUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnAddUsersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnAddUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnAddUsersMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuUsers_BttnAddUsersLayout = new javax.swing.GroupLayout(MenuUsers_BttnAddUsers);
        MenuUsers_BttnAddUsers.setLayout(MenuUsers_BttnAddUsersLayout);
        MenuUsers_BttnAddUsersLayout.setHorizontalGroup(
            MenuUsers_BttnAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsers_lblBttnAddUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        MenuUsers_BttnAddUsersLayout.setVerticalGroup(
            MenuUsers_BttnAddUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsers_lblBttnAddUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuUsers_BttnSearchUsers.setBackground(new java.awt.Color(0, 153, 153));
        MenuUsers_BttnSearchUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuUsers_BttnSearchUsers.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuUsers_BttnSearchUsers.setMinimumSize(new java.awt.Dimension(140, 40));
        MenuUsers_BttnSearchUsers.setPreferredSize(new java.awt.Dimension(140, 40));

        MenuUsers_lblBttnSearchUsers.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        MenuUsers_lblBttnSearchUsers.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_lblBttnSearchUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuUsers_lblBttnSearchUsers.setText("Buscar Usuario");
        MenuUsers_lblBttnSearchUsers.setMaximumSize(new java.awt.Dimension(140, 40));
        MenuUsers_lblBttnSearchUsers.setMinimumSize(new java.awt.Dimension(140, 40));
        MenuUsers_lblBttnSearchUsers.setPreferredSize(new java.awt.Dimension(140, 40));
        MenuUsers_lblBttnSearchUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnSearchUsersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnSearchUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnSearchUsersMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuUsers_BttnSearchUsersLayout = new javax.swing.GroupLayout(MenuUsers_BttnSearchUsers);
        MenuUsers_BttnSearchUsers.setLayout(MenuUsers_BttnSearchUsersLayout);
        MenuUsers_BttnSearchUsersLayout.setHorizontalGroup(
            MenuUsers_BttnSearchUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuUsers_BttnSearchUsersLayout.createSequentialGroup()
                .addComponent(MenuUsers_lblBttnSearchUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MenuUsers_BttnSearchUsersLayout.setVerticalGroup(
            MenuUsers_BttnSearchUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsers_lblBttnSearchUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MenuUsers_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        MenuUsers_BttnBack.setPreferredSize(new java.awt.Dimension(126, 35));

        MenuUsers_lblBttnBack.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        MenuUsers_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuUsers_lblBttnBack.setText("Regresar");
        MenuUsers_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuUsers_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuUsers_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuUsers_BttnBackLayout = new javax.swing.GroupLayout(MenuUsers_BttnBack);
        MenuUsers_BttnBack.setLayout(MenuUsers_BttnBackLayout);
        MenuUsers_BttnBackLayout.setHorizontalGroup(
            MenuUsers_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuUsers_BttnBackLayout.createSequentialGroup()
                .addComponent(MenuUsers_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MenuUsers_BttnBackLayout.setVerticalGroup(
            MenuUsers_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsers_lblBttnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuUsers_BttnAddUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(MenuUsers_BttnSearchUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(MenuUsers_BttnBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(MenuUsers_BttnAddUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(MenuUsers_BttnSearchUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(MenuUsers_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );

        MenuUsersPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 380, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuUsers_lblBttnAddUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnAddUsersMouseEntered
        MenuUsers_BttnAddUsers.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuUsers_lblBttnAddUsersMouseEntered

    private void MenuUsers_lblBttnAddUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnAddUsersMouseExited
        MenuUsers_BttnAddUsers.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuUsers_lblBttnAddUsersMouseExited

    private void MenuUsers_lblBttnSearchUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnSearchUsersMouseEntered
        MenuUsers_BttnSearchUsers.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuUsers_lblBttnSearchUsersMouseEntered

    private void MenuUsers_lblBttnSearchUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnSearchUsersMouseExited
        MenuUsers_BttnSearchUsers.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuUsers_lblBttnSearchUsersMouseExited

    private void MenuUsers_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnBackMouseEntered
        MenuUsers_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_MenuUsers_lblBttnBackMouseEntered

    private void MenuUsers_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnBackMouseExited
        MenuUsers_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_MenuUsers_lblBttnBackMouseExited

    private void MenuUsers_lblBttnAddUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnAddUsersMouseClicked
        System.out.println("MenuManager -> logUser: " +
        (logUser != null ? logUser.getUsername() + " id_clinic=" + logUser.getId_clinic() + " role=" + logUser.getName_role() : "logUser es null"));
        CreateUser CreateUserFrame = new CreateUser(logUser); ///usar constructor con logUser, para no perder la sesión y evitar logUser = null
        CreateUserFrame.setVisible(true);
        CreateUserFrame.pack();
        CreateUserFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuUsers_lblBttnAddUsersMouseClicked

    private void MenuUsers_lblBttnSearchUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnSearchUsersMouseClicked
        //Buscar puede ser el mismo SearchUser quitando el boton de actualizar
        System.out.println("MenuManager -> logUser: " +
        (logUser != null ? logUser.getUsername() + " id_clinic=" + logUser.getId_clinic() + " role=" + logUser.getName_role() : "logUser es null"));
        SearchUser SearchUserFrame = new SearchUser(logUser);
        SearchUserFrame.setVisible(true);
        SearchUserFrame.pack();
        SearchUserFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuUsers_lblBttnSearchUsersMouseClicked

    private void MenuUsers_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_lblBttnBackMouseClicked
        // TODO add your handling code here:
        MenuManager menuManager = new MenuManager(logUser);
        menuManager.setVisible(true);
        menuManager.pack();
        menuManager.setLocationRelativeTo(null);
        this.dispose();
          
    }//GEN-LAST:event_MenuUsers_lblBttnBackMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UsersMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel MenuUsersPanel;
    private javax.swing.JPanel MenuUsers_BttnAddUsers;
    private javax.swing.JPanel MenuUsers_BttnBack;
    private javax.swing.JPanel MenuUsers_BttnSearchUsers;
    private javax.swing.JLabel MenuUsers_lblBttnAddUsers;
    private javax.swing.JLabel MenuUsers_lblBttnBack;
    private javax.swing.JLabel MenuUsers_lblBttnSearchUsers;
    private javax.swing.JLabel MenuUsers_lblTitle;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables
}
