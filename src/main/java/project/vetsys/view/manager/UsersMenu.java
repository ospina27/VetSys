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
            MenuUsers_BttnCreateUser.setVisible(false);
        }
        setTitle("Gestión de Usuarios "+logUser.getClinic().getName_clinic());
    }

    public UsersMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuUsersPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuUsers_ImgVetSys = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuUsers_BttnCreateUser = new javax.swing.JButton();
        MenuUsers_BttnSearchUser = new javax.swing.JButton();
        MenuUsers_BttnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        MenuUsersPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        MenuUsersPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        MenuUsersPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        MenuUsersPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(400, 600));
        Left.setMinimumSize(new java.awt.Dimension(400, 600));
        Left.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuUsers_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuUsers_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuUsers_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N
        MenuUsers_ImgVetSys.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsers_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsers_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        MenuUsersPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(400, 600));
        Right.setMinimumSize(new java.awt.Dimension(400, 600));
        Right.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuUsers_BttnCreateUser.setBackground(new java.awt.Color(0, 153, 153));
        MenuUsers_BttnCreateUser.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuUsers_BttnCreateUser.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_BttnCreateUser.setText("Crear Usuario");
        MenuUsers_BttnCreateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuUsers_BttnCreateUser.setFocusPainted(false);
        MenuUsers_BttnCreateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnCreateUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnCreateUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnCreateUserMouseExited(evt);
            }
        });

        MenuUsers_BttnSearchUser.setBackground(new java.awt.Color(0, 153, 153));
        MenuUsers_BttnSearchUser.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuUsers_BttnSearchUser.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_BttnSearchUser.setText("Buscar Usuario");
        MenuUsers_BttnSearchUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuUsers_BttnSearchUser.setFocusPainted(false);
        MenuUsers_BttnSearchUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnSearchUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnSearchUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnSearchUserMouseExited(evt);
            }
        });

        MenuUsers_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        MenuUsers_BttnBack.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        MenuUsers_BttnBack.setForeground(new java.awt.Color(255, 255, 255));
        MenuUsers_BttnBack.setText("Regresar");
        MenuUsers_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuUsers_BttnBack.setFocusPainted(false);
        MenuUsers_BttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuUsers_BttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MenuUsers_BttnSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuUsers_BttnCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(MenuUsers_BttnBack)
                        .addGap(129, 129, 129))))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(MenuUsers_BttnCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(MenuUsers_BttnSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(MenuUsers_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        MenuUsersPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuUsers_BttnCreateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnCreateUserMouseClicked
        System.out.println("MenuManager -> logUser: " +
        (logUser != null ? logUser.getUsername() + " id_clinic=" + logUser.getId_clinic() + " role=" + logUser.getName_role() : "logUser es null"));
        CreateUser CreateUserFrame = new CreateUser(logUser); ///usar constructor con logUser, para no perder la sesión y evitar logUser = null
        CreateUserFrame.setVisible(true);
        CreateUserFrame.pack();
        CreateUserFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuUsers_BttnCreateUserMouseClicked

    private void MenuUsers_BttnCreateUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnCreateUserMouseEntered
        MenuUsers_BttnCreateUser.setBackground(Color.LIGHT_GRAY);
        MenuUsers_BttnCreateUser.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuUsers_BttnCreateUserMouseEntered

    private void MenuUsers_BttnCreateUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnCreateUserMouseExited
        MenuUsers_BttnCreateUser.setBackground(new Color(0,153,153));
        MenuUsers_BttnCreateUser.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuUsers_BttnCreateUserMouseExited

    private void MenuUsers_BttnSearchUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnSearchUserMouseClicked
        //Buscar puede ser el mismo SearchUser quitando el boton de actualizar
        System.out.println("MenuManager -> logUser: " +
        (logUser != null ? logUser.getUsername() + " id_clinic=" + logUser.getId_clinic() + " role=" + logUser.getName_role() : "logUser es null"));
        SearchUser SearchUserFrame = new SearchUser(logUser);
        SearchUserFrame.setVisible(true);
        SearchUserFrame.pack();
        SearchUserFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuUsers_BttnSearchUserMouseClicked

    private void MenuUsers_BttnSearchUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnSearchUserMouseEntered
        MenuUsers_BttnSearchUser.setBackground(Color.LIGHT_GRAY);
        MenuUsers_BttnSearchUser.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuUsers_BttnSearchUserMouseEntered

    private void MenuUsers_BttnSearchUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnSearchUserMouseExited
        MenuUsers_BttnSearchUser.setBackground(new Color(0,153,153));
        MenuUsers_BttnSearchUser.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuUsers_BttnSearchUserMouseExited

    private void MenuUsers_BttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnBackMouseClicked
        MenuManager menuManager = new MenuManager(logUser);
        menuManager.setVisible(true);
        menuManager.pack();
        menuManager.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuUsers_BttnBackMouseClicked

    private void MenuUsers_BttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnBackMouseEntered
        MenuUsers_BttnBack.setBackground(Color.LIGHT_GRAY);
        MenuUsers_BttnBack.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuUsers_BttnBackMouseEntered

    private void MenuUsers_BttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUsers_BttnBackMouseExited
        MenuUsers_BttnBack.setBackground(new Color(0,153,153));
        MenuUsers_BttnBack.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuUsers_BttnBackMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UsersMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel MenuUsersPanel;
    private javax.swing.JButton MenuUsers_BttnBack;
    private javax.swing.JButton MenuUsers_BttnCreateUser;
    private javax.swing.JButton MenuUsers_BttnSearchUser;
    private javax.swing.JLabel MenuUsers_ImgVetSys;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables
}
