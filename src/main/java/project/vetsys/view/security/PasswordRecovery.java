package project.vetsys.view.security;

import project.vetsys.view.security.LogIn;
import java.awt.Color;
import javax.swing.JOptionPane;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.User;
import project.vetsys.security.PasswordUtil;
import project.vetsys.view.Nimbus;

public class PasswordRecovery extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PasswordRecovery.class.getName());
    private User user = null;
    
    
    public PasswordRecovery() {
        initComponents();
        Nimbus.LookandFeel();
        Nimbus.styleAllTextFields(this);
        Nimbus.styleAllLabelsExcept(this,Left_PassRec_ImgVetSys);
        PassRec_textNewPassword.setVisible(false);
        PassRec_textNewPasswordOK.setVisible(false);
        PassRec_BttnSavePassword.setVisible(false);
        Left_PassRec_ImgPassword.setVisible(false);
        
        PassRec_lblNewPassword.setVisible(false);
        PassRec_lblNewPasswordOK.setVisible(false);
        jSeparator4.setVisible(false);
        jSeparator5.setVisible(false);
        
        PassRec_textNewPassword.setEnabled(false);
        PassRec_textNewPasswordOK.setEnabled(false);
        setTitle("Recuperar contraseña");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PasswordRecoveryPanel = new javax.swing.JPanel();
        Left_PasswordRecovery = new javax.swing.JPanel();
        Left_PassRec_ImgVetSys = new javax.swing.JLabel();
        Left_PassRec_ImgPassword = new javax.swing.JLabel();
        Right_PasswordRecovery = new javax.swing.JPanel();
        PassRec_lblUser = new javax.swing.JLabel();
        PassRec_lblID = new javax.swing.JLabel();
        PassRec_lblNewPassword = new javax.swing.JLabel();
        PassRec_lblNewPasswordOK = new javax.swing.JLabel();
        PassRec_textUser = new javax.swing.JTextField();
        PassRec_textID = new javax.swing.JTextField();
        PassRec_textNewPassword = new javax.swing.JPasswordField();
        PassRec_textNewPasswordOK = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        PassRec_BttnCheckCredential = new javax.swing.JButton();
        PassRec_BttnBack = new javax.swing.JButton();
        PassRec_BttnSavePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PasswordRecovery");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        PasswordRecoveryPanel.setBackground(new java.awt.Color(255, 255, 255));
        PasswordRecoveryPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        PasswordRecoveryPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        PasswordRecoveryPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        PasswordRecoveryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left_PasswordRecovery.setBackground(new java.awt.Color(0, 153, 153));
        Left_PasswordRecovery.setMaximumSize(new java.awt.Dimension(400, 600));
        Left_PasswordRecovery.setMinimumSize(new java.awt.Dimension(400, 600));
        Left_PasswordRecovery.setPreferredSize(new java.awt.Dimension(400, 600));

        Left_PassRec_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        Left_PassRec_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        Left_PassRec_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Left_PassRec_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N
        Left_PassRec_ImgVetSys.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Left_PassRec_ImgVetSys.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Left_PassRec_ImgPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Left_PassRec_ImgPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/password.png"))); // NOI18N

        javax.swing.GroupLayout Left_PasswordRecoveryLayout = new javax.swing.GroupLayout(Left_PasswordRecovery);
        Left_PasswordRecovery.setLayout(Left_PasswordRecoveryLayout);
        Left_PasswordRecoveryLayout.setHorizontalGroup(
            Left_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Left_PassRec_ImgVetSys, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Left_PassRec_ImgPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Left_PasswordRecoveryLayout.setVerticalGroup(
            Left_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Left_PasswordRecoveryLayout.createSequentialGroup()
                .addComponent(Left_PassRec_ImgVetSys, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Left_PassRec_ImgPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PasswordRecoveryPanel.add(Left_PasswordRecovery, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Right_PasswordRecovery.setBackground(new java.awt.Color(255, 255, 255));
        Right_PasswordRecovery.setMaximumSize(new java.awt.Dimension(400, 600));
        Right_PasswordRecovery.setMinimumSize(new java.awt.Dimension(400, 600));
        Right_PasswordRecovery.setPreferredSize(new java.awt.Dimension(400, 600));

        PassRec_lblUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PassRec_lblUser.setText("Nombre");

        PassRec_lblID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PassRec_lblID.setText("Numero de Identificación");

        PassRec_lblNewPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PassRec_lblNewPassword.setText("Contraseña Nueva");

        PassRec_lblNewPasswordOK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PassRec_lblNewPasswordOK.setText("Confirmar Contraseña");

        PassRec_textUser.setForeground(java.awt.Color.gray);
        PassRec_textUser.setBorder(null);

        PassRec_textID.setForeground(java.awt.Color.gray);
        PassRec_textID.setToolTipText("");
        PassRec_textID.setBorder(null);

        PassRec_textNewPassword.setForeground(java.awt.Color.gray);
        PassRec_textNewPassword.setBorder(null);
        PassRec_textNewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PassRec_textNewPasswordMousePressed(evt);
            }
        });

        PassRec_textNewPasswordOK.setForeground(java.awt.Color.gray);
        PassRec_textNewPasswordOK.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        PassRec_BttnCheckCredential.setBackground(new java.awt.Color(0, 153, 153));
        PassRec_BttnCheckCredential.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        PassRec_BttnCheckCredential.setForeground(new java.awt.Color(255, 255, 255));
        PassRec_BttnCheckCredential.setText("Verificar");
        PassRec_BttnCheckCredential.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PassRec_BttnCheckCredential.setFocusPainted(false);
        PassRec_BttnCheckCredential.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassRec_BttnCheckCredentialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PassRec_BttnCheckCredentialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PassRec_BttnCheckCredentialMouseExited(evt);
            }
        });

        PassRec_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        PassRec_BttnBack.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        PassRec_BttnBack.setForeground(new java.awt.Color(255, 255, 255));
        PassRec_BttnBack.setText("Cancelar");
        PassRec_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PassRec_BttnBack.setFocusPainted(false);
        PassRec_BttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassRec_BttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PassRec_BttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PassRec_BttnBackMouseExited(evt);
            }
        });

        PassRec_BttnSavePassword.setBackground(new java.awt.Color(0, 153, 153));
        PassRec_BttnSavePassword.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        PassRec_BttnSavePassword.setForeground(new java.awt.Color(255, 255, 255));
        PassRec_BttnSavePassword.setText("Guardar");
        PassRec_BttnSavePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PassRec_BttnSavePassword.setFocusPainted(false);
        PassRec_BttnSavePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassRec_BttnSavePasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PassRec_BttnSavePasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PassRec_BttnSavePasswordMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Right_PasswordRecoveryLayout = new javax.swing.GroupLayout(Right_PasswordRecovery);
        Right_PasswordRecovery.setLayout(Right_PasswordRecoveryLayout);
        Right_PasswordRecoveryLayout.setHorizontalGroup(
            Right_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Right_PasswordRecoveryLayout.createSequentialGroup()
                .addGroup(Right_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Right_PasswordRecoveryLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(Right_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Right_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                .addComponent(PassRec_textUser)
                                .addComponent(PassRec_lblNewPasswordOK)
                                .addComponent(PassRec_lblNewPassword)
                                .addComponent(PassRec_lblUser)
                                .addComponent(PassRec_textID)
                                .addComponent(PassRec_lblID)
                                .addComponent(jSeparator1)
                                .addComponent(PassRec_textNewPassword)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                .addComponent(PassRec_textNewPasswordOK))
                            .addGroup(Right_PasswordRecoveryLayout.createSequentialGroup()
                                .addComponent(PassRec_BttnCheckCredential)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PassRec_BttnBack))))
                    .addGroup(Right_PasswordRecoveryLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(PassRec_BttnSavePassword)))
                .addGap(42, 42, 42))
        );
        Right_PasswordRecoveryLayout.setVerticalGroup(
            Right_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Right_PasswordRecoveryLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(PassRec_lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassRec_textUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PassRec_lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassRec_textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(Right_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PassRec_BttnBack)
                    .addComponent(PassRec_BttnCheckCredential, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(PassRec_lblNewPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassRec_textNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(PassRec_lblNewPasswordOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassRec_textNewPasswordOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(PassRec_BttnSavePassword)
                .addGap(63, 63, 63))
        );

        PasswordRecoveryPanel.add(Right_PasswordRecovery, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 600));
        Right_PasswordRecovery.getAccessibleContext().setAccessibleName("Recuperar Contraseña");
        Right_PasswordRecovery.getAccessibleContext().setAccessibleDescription("Recuperar Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PasswordRecoveryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PasswordRecoveryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PassRec_textNewPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_textNewPasswordMousePressed
        if (String.valueOf(PassRec_textNewPassword.getPassword()).equals("**********")){
            PassRec_textNewPassword.setText("");
            PassRec_textNewPassword.setForeground(Color.black);
        }
        if (String.valueOf(PassRec_textNewPasswordOK.getPassword()).isEmpty()){
            PassRec_textNewPasswordOK.setText("**********");
            PassRec_textNewPasswordOK.setForeground(Color.gray);
        }
    }//GEN-LAST:event_PassRec_textNewPasswordMousePressed

    private void PassRec_BttnCheckCredentialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnCheckCredentialMouseClicked
        String name = PassRec_textUser.getText().trim();
        String document = PassRec_textID.getText().trim();

        if(name.isEmpty() || document.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Complete todos los campos", "CAMPOS OBLIGATORIOS", HEIGHT);
            System.out.println("Complete todos los campos");
            return;
        }

        UserDAO userDao = new UserDAO();

        ///validar que el usuario exista
        boolean userExists = userDao.userExists(name, document);
        if(!userExists)
        {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            return;
        }
        ///se valida que el usuario este activo
        user = userDao.searchUserPass(name, document);

        if(user != null){
            PassRec_lblNewPassword.setVisible(true);
            PassRec_textNewPassword.setVisible(true);
            jSeparator4.setVisible(true);
            PassRec_lblNewPasswordOK.setVisible(true);
            PassRec_textNewPasswordOK.setVisible(true);
            jSeparator5.setVisible(true);
            PassRec_BttnSavePassword.setVisible(true);
            Left_PassRec_ImgPassword.setVisible(true);

            PassRec_textNewPassword.setEnabled(true);
            PassRec_textNewPasswordOK.setEnabled(true);
            System.out.println(user.getUsername());

        }else {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario Inactivo.");
        }
    }//GEN-LAST:event_PassRec_BttnCheckCredentialMouseClicked

    private void PassRec_BttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnBackMouseClicked
        LogIn LogInFrame = new LogIn();
        LogInFrame.setVisible(true);
        LogInFrame.pack();
        LogInFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_PassRec_BttnBackMouseClicked

    private void PassRec_BttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnBackMouseEntered
        PassRec_BttnBack.setBackground(Color.LIGHT_GRAY);
        PassRec_BttnBack.setForeground(Color.BLACK);
    }//GEN-LAST:event_PassRec_BttnBackMouseEntered

    private void PassRec_BttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnBackMouseExited
        PassRec_BttnBack.setBackground(new Color(0,153,153));
        PassRec_BttnBack.setForeground(Color.WHITE);
    }//GEN-LAST:event_PassRec_BttnBackMouseExited

    private void PassRec_BttnCheckCredentialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnCheckCredentialMouseEntered
        PassRec_BttnCheckCredential.setBackground(Color.LIGHT_GRAY);
        PassRec_BttnCheckCredential.setForeground(Color.BLACK);
    }//GEN-LAST:event_PassRec_BttnCheckCredentialMouseEntered

    private void PassRec_BttnCheckCredentialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnCheckCredentialMouseExited
        PassRec_BttnCheckCredential.setBackground(new Color(0,153,153));
        PassRec_BttnCheckCredential.setForeground(Color.WHITE);
    }//GEN-LAST:event_PassRec_BttnCheckCredentialMouseExited

    private void PassRec_BttnSavePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnSavePasswordMouseClicked
        if (user == null)
        {
            JOptionPane.showMessageDialog(this, "Verifique las credenciales.");
            return;
        }
        String passNew = String.valueOf(PassRec_textNewPassword.getPassword());
        String passConfirm = String.valueOf(PassRec_textNewPasswordOK.getPassword());

        ///verificar que ambas contraseñas sean iguales)
        if (!passNew.equals(passConfirm)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            PassRec_textNewPassword.setText("");
            PassRec_textNewPasswordOK.setText("");
            return;
        }

        if (passNew.length() < 6) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener mínimo 6 caracteres.");
            return;
        }

        UserDAO dao = new UserDAO();
        boolean updated = dao.updatePassword(user.getId_user(), passNew);

        if (updated) {
            JOptionPane.showMessageDialog(this, "Contraseña actualizada correctamente.");
            this.dispose();
            new LogIn().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar contraseña.");
        }
    }//GEN-LAST:event_PassRec_BttnSavePasswordMouseClicked

    private void PassRec_BttnSavePasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnSavePasswordMouseEntered
        PassRec_BttnSavePassword.setBackground(Color.LIGHT_GRAY);
        PassRec_BttnCheckCredential.setForeground(Color.BLACK);
    }//GEN-LAST:event_PassRec_BttnSavePasswordMouseEntered

    private void PassRec_BttnSavePasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_BttnSavePasswordMouseExited
        PassRec_BttnSavePassword.setBackground(new Color(0,153,153));
        PassRec_BttnCheckCredential.setForeground(Color.WHITE);
    }//GEN-LAST:event_PassRec_BttnSavePasswordMouseExited

    
   
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PasswordRecovery().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Left_PassRec_ImgPassword;
    private javax.swing.JLabel Left_PassRec_ImgVetSys;
    private javax.swing.JPanel Left_PasswordRecovery;
    private javax.swing.JButton PassRec_BttnBack;
    private javax.swing.JButton PassRec_BttnCheckCredential;
    private javax.swing.JButton PassRec_BttnSavePassword;
    private javax.swing.JLabel PassRec_lblID;
    private javax.swing.JLabel PassRec_lblNewPassword;
    private javax.swing.JLabel PassRec_lblNewPasswordOK;
    private javax.swing.JLabel PassRec_lblUser;
    private javax.swing.JTextField PassRec_textID;
    private javax.swing.JPasswordField PassRec_textNewPassword;
    private javax.swing.JPasswordField PassRec_textNewPasswordOK;
    private javax.swing.JTextField PassRec_textUser;
    private javax.swing.JPanel PasswordRecoveryPanel;
    private javax.swing.JPanel Right_PasswordRecovery;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
