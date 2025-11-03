package project.vetsys.view;

import java.awt.Color;
import javax.swing.JOptionPane;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.User;


public class LogIn extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LogIn.class.getName());

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogInPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        LogInPanel_lblTittle = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        LogInPanel_lblLogin = new javax.swing.JLabel();
        LogInPanel_lblUsername = new javax.swing.JLabel();
        LogInPanel_txtUsername = new javax.swing.JTextField();
        LogInPanel_lblPassword = new javax.swing.JLabel();
        LogInPanel_lblResetPassword = new javax.swing.JLabel();
        LogInPanel_BttnResetPassword = new javax.swing.JLabel();
        LogInPanel_txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        LogInPanel_BttnLogin = new javax.swing.JPanel();
        LogInPanel_lblBttnLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        LogInPanel.setBackground(new java.awt.Color(255, 255, 255));
        LogInPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        LogInPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        LogInPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        LogInPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setPreferredSize(new java.awt.Dimension(400, 600));

        LogInPanel_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        LogInPanel_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        LogInPanel_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogInPanel_lblTittle.setText("VetSys");
        LogInPanel_lblTittle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel_lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel_lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        LogInPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(800, 600));
        Right.setMinimumSize(new java.awt.Dimension(800, 600));
        Right.setPreferredSize(new java.awt.Dimension(800, 600));

        LogInPanel_lblLogin.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        LogInPanel_lblLogin.setForeground(new java.awt.Color(0, 153, 153));
        LogInPanel_lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogInPanel_lblLogin.setText("LOGIN");
        LogInPanel_lblLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        LogInPanel_lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LogInPanel_lblUsername.setText("Usuario");

        LogInPanel_txtUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LogInPanel_txtUsername.setForeground(new java.awt.Color(204, 204, 204));
        LogInPanel_txtUsername.setText("Ingrese su nombre de usuario");
        LogInPanel_txtUsername.setToolTipText("");
        LogInPanel_txtUsername.setAlignmentY(0.0F);
        LogInPanel_txtUsername.setBorder(null);
        LogInPanel_txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogInPanel_txtUsernameMousePressed(evt);
            }
        });
        LogInPanel_txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInPanel_txtUsernameActionPerformed(evt);
            }
        });

        LogInPanel_lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LogInPanel_lblPassword.setText("Contraseña");

        LogInPanel_lblResetPassword.setBackground(new java.awt.Color(255, 255, 255));
        LogInPanel_lblResetPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LogInPanel_lblResetPassword.setText("Olvidaste la contraseña?");

        LogInPanel_BttnResetPassword.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LogInPanel_BttnResetPassword.setForeground(new java.awt.Color(0, 153, 153));
        LogInPanel_BttnResetPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogInPanel_BttnResetPassword.setText("Click Aquí");
        LogInPanel_BttnResetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogInPanel_BttnResetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInPanel_BttnResetPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogInPanel_BttnResetPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogInPanel_BttnResetPasswordMouseExited(evt);
            }
        });

        LogInPanel_txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        LogInPanel_txtPassword.setText("**********");
        LogInPanel_txtPassword.setBorder(null);
        LogInPanel_txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogInPanel_txtPasswordMousePressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        LogInPanel_BttnLogin.setBackground(new java.awt.Color(0, 153, 153));
        LogInPanel_BttnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LogInPanel_lblBttnLogin.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        LogInPanel_lblBttnLogin.setForeground(new java.awt.Color(255, 255, 255));
        LogInPanel_lblBttnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogInPanel_lblBttnLogin.setText("Ingresar");
        LogInPanel_lblBttnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInPanel_lblBttnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogInPanel_lblBttnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogInPanel_lblBttnLoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout LogInPanel_BttnLoginLayout = new javax.swing.GroupLayout(LogInPanel_BttnLogin);
        LogInPanel_BttnLogin.setLayout(LogInPanel_BttnLoginLayout);
        LogInPanel_BttnLoginLayout.setHorizontalGroup(
            LogInPanel_BttnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
            .addGroup(LogInPanel_BttnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LogInPanel_lblBttnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );
        LogInPanel_BttnLoginLayout.setVerticalGroup(
            LogInPanel_BttnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(LogInPanel_BttnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LogInPanel_lblBttnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addComponent(LogInPanel_lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 400, Short.MAX_VALUE))
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogInPanel_lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogInPanel_txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RightLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(RightLayout.createSequentialGroup()
                                    .addComponent(LogInPanel_lblResetPassword)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LogInPanel_BttnResetPassword))
                                .addComponent(LogInPanel_txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(LogInPanel_lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(RightLayout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addComponent(LogInPanel_BttnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(495, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(LogInPanel_lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(LogInPanel_lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogInPanel_txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(LogInPanel_lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogInPanel_txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(LogInPanel_BttnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogInPanel_lblResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogInPanel_BttnResetPassword))
                .addGap(33, 33, 33))
        );

        LogInPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInPanel_BttnResetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_BttnResetPasswordMouseClicked
        PasswordRecovery PasswordRecoveryPanel = new PasswordRecovery();
        PasswordRecoveryPanel.setVisible(true);
        PasswordRecoveryPanel.pack();
        PasswordRecoveryPanel.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LogInPanel_BttnResetPasswordMouseClicked

    private void LogInPanel_txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInPanel_txtUsernameActionPerformed

    }//GEN-LAST:event_LogInPanel_txtUsernameActionPerformed

    private void LogInPanel_lblBttnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_lblBttnLoginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInPanel_lblBttnLoginMouseClicked

    private void LogInPanel_lblBttnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_lblBttnLoginMouseEntered
        LogInPanel_BttnLogin.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_LogInPanel_lblBttnLoginMouseEntered

    private void LogInPanel_lblBttnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_lblBttnLoginMouseExited
        LogInPanel_BttnLogin.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_LogInPanel_lblBttnLoginMouseExited

    private void LogInPanel_BttnResetPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_BttnResetPasswordMouseEntered
        LogInPanel_BttnResetPassword.setForeground(Color.blue);
    }//GEN-LAST:event_LogInPanel_BttnResetPasswordMouseEntered

    private void LogInPanel_BttnResetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_BttnResetPasswordMouseExited
        LogInPanel_BttnResetPassword.setForeground(new Color(0,153,153));
    }//GEN-LAST:event_LogInPanel_BttnResetPasswordMouseExited

    private void LogInPanel_txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_txtPasswordMousePressed
        if (String.valueOf(LogInPanel_txtPassword.getPassword()).equals("**********")){
            LogInPanel_txtPassword.setText("");
            LogInPanel_txtPassword.setForeground(Color.black);
        }
        if (LogInPanel_txtUsername.getText().isEmpty()){
            LogInPanel_txtUsername.setText("Ingrese su nombre de usuario");
            LogInPanel_txtUsername.setForeground(Color.gray);
        }
    }//GEN-LAST:event_LogInPanel_txtPasswordMousePressed

    private void LogInPanel_txtUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_txtUsernameMousePressed
        if (LogInPanel_txtUsername.getText().equals("Ingrese su nombre de usuario")){
            LogInPanel_txtUsername.setText("");
            LogInPanel_txtUsername.setForeground(Color.black);
        }
        if (String.valueOf(LogInPanel_txtPassword.getPassword()).isEmpty()){
            LogInPanel_txtPassword.setText("**********");
            LogInPanel_txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_LogInPanel_txtUsernameMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel LogInPanel;
    private javax.swing.JPanel LogInPanel_BttnLogin;
    private javax.swing.JLabel LogInPanel_BttnResetPassword;
    private javax.swing.JLabel LogInPanel_lblBttnLogin;
    private javax.swing.JLabel LogInPanel_lblLogin;
    private javax.swing.JLabel LogInPanel_lblPassword;
    private javax.swing.JLabel LogInPanel_lblResetPassword;
    private javax.swing.JLabel LogInPanel_lblTittle;
    private javax.swing.JLabel LogInPanel_lblUsername;
    private javax.swing.JPasswordField LogInPanel_txtPassword;
    private javax.swing.JTextField LogInPanel_txtUsername;
    private javax.swing.JPanel Right;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
