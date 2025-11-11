package project.vetsys.view.security;

import project.vetsys.view.security.LogIn;
import java.awt.Color;
import javax.swing.JOptionPane;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.User;
import project.vetsys.security.PasswordUtil;

public class PasswordRecovery extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PasswordRecovery.class.getName());
    private User user = null;
    
    public PasswordRecovery() {
        initComponents();
       
        PassRec_textNewPassword.setVisible(false);
        PassRec_textNewPasswordOK.setVisible(false);
        PassRec_BttnSavePassword.setVisible(false);
        PassRec_lblBttnSavePassword.setVisible(false);
        
        PassRec_lblNewPassword.setVisible(false);
        PassRec_lblNewPasswordOK.setVisible(false);
        jSeparator4.setVisible(false);
        jSeparator5.setVisible(false);
        
        PassRec_textNewPassword.setEnabled(false);
        PassRec_textNewPasswordOK.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PasswordRecoveryPanel = new javax.swing.JPanel();
        Left_PasswordRecovery = new javax.swing.JPanel();
        LogInPanel_lblTittle = new javax.swing.JLabel();
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
        PassRec_BttnCheckCredentials = new javax.swing.JPanel();
        PassRec_lblBttnCheckCredentials = new javax.swing.JLabel();
        PassRec_BttnSavePassword = new javax.swing.JPanel();
        PassRec_lblBttnSavePassword = new javax.swing.JLabel();
        PassRec_BttnBack = new javax.swing.JPanel();
        PassRec_lblBttnBack = new javax.swing.JLabel();

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

        LogInPanel_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        LogInPanel_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        LogInPanel_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogInPanel_lblTittle.setText("VetSys");
        LogInPanel_lblTittle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Left_PasswordRecoveryLayout = new javax.swing.GroupLayout(Left_PasswordRecovery);
        Left_PasswordRecovery.setLayout(Left_PasswordRecoveryLayout);
        Left_PasswordRecoveryLayout.setHorizontalGroup(
            Left_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel_lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        Left_PasswordRecoveryLayout.setVerticalGroup(
            Left_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel_lblTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
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
        PassRec_textUser.setText("Ingrese su nombre");
        PassRec_textUser.setBorder(null);
        PassRec_textUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PassRec_textUserMousePressed(evt);
            }
        });
        PassRec_textUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassRec_textUserActionPerformed(evt);
            }
        });

        PassRec_textID.setForeground(java.awt.Color.gray);
        PassRec_textID.setText("Ingrese numero de cedula");
        PassRec_textID.setBorder(null);
        PassRec_textID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PassRec_textIDMousePressed(evt);
            }
        });

        PassRec_textNewPassword.setForeground(java.awt.Color.gray);
        PassRec_textNewPassword.setText("**********");
        PassRec_textNewPassword.setBorder(null);
        PassRec_textNewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PassRec_textNewPasswordMousePressed(evt);
            }
        });

        PassRec_textNewPasswordOK.setForeground(java.awt.Color.gray);
        PassRec_textNewPasswordOK.setText("**********");
        PassRec_textNewPasswordOK.setBorder(null);
        PassRec_textNewPasswordOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PassRec_textNewPasswordOKMousePressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        PassRec_BttnCheckCredentials.setBackground(new java.awt.Color(0, 153, 153));
        PassRec_BttnCheckCredentials.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PassRec_lblBttnCheckCredentials.setFont(new java.awt.Font("Arial Black", 1, 21)); // NOI18N
        PassRec_lblBttnCheckCredentials.setForeground(new java.awt.Color(255, 255, 255));
        PassRec_lblBttnCheckCredentials.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PassRec_lblBttnCheckCredentials.setText("Verificar");
        PassRec_lblBttnCheckCredentials.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PassRec_lblBttnCheckCredentials.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnCheckCredentialsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnCheckCredentialsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnCheckCredentialsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PassRec_BttnCheckCredentialsLayout = new javax.swing.GroupLayout(PassRec_BttnCheckCredentials);
        PassRec_BttnCheckCredentials.setLayout(PassRec_BttnCheckCredentialsLayout);
        PassRec_BttnCheckCredentialsLayout.setHorizontalGroup(
            PassRec_BttnCheckCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PassRec_lblBttnCheckCredentials, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        );
        PassRec_BttnCheckCredentialsLayout.setVerticalGroup(
            PassRec_BttnCheckCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PassRec_lblBttnCheckCredentials, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PassRec_BttnSavePassword.setBackground(new java.awt.Color(0, 153, 153));
        PassRec_BttnSavePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PassRec_lblBttnSavePassword.setFont(new java.awt.Font("Arial Black", 1, 21)); // NOI18N
        PassRec_lblBttnSavePassword.setForeground(new java.awt.Color(255, 255, 255));
        PassRec_lblBttnSavePassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PassRec_lblBttnSavePassword.setText("Guardar");
        PassRec_lblBttnSavePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PassRec_lblBttnSavePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnSavePasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnSavePasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnSavePasswordMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PassRec_BttnSavePasswordLayout = new javax.swing.GroupLayout(PassRec_BttnSavePassword);
        PassRec_BttnSavePassword.setLayout(PassRec_BttnSavePasswordLayout);
        PassRec_BttnSavePasswordLayout.setHorizontalGroup(
            PassRec_BttnSavePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
            .addGroup(PassRec_BttnSavePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PassRec_lblBttnSavePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        );
        PassRec_BttnSavePasswordLayout.setVerticalGroup(
            PassRec_BttnSavePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(PassRec_BttnSavePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PassRec_lblBttnSavePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        PassRec_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        PassRec_BttnBack.setMaximumSize(new java.awt.Dimension(111, 35));
        PassRec_BttnBack.setMinimumSize(new java.awt.Dimension(111, 35));
        PassRec_BttnBack.setPreferredSize(new java.awt.Dimension(155, 35));

        PassRec_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 21)); // NOI18N
        PassRec_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        PassRec_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PassRec_lblBttnBack.setText("Cancelar");
        PassRec_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PassRec_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PassRec_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PassRec_BttnBackLayout = new javax.swing.GroupLayout(PassRec_BttnBack);
        PassRec_BttnBack.setLayout(PassRec_BttnBackLayout);
        PassRec_BttnBackLayout.setHorizontalGroup(
            PassRec_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PassRec_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        PassRec_BttnBackLayout.setVerticalGroup(
            PassRec_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PassRec_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Right_PasswordRecoveryLayout = new javax.swing.GroupLayout(Right_PasswordRecovery);
        Right_PasswordRecovery.setLayout(Right_PasswordRecoveryLayout);
        Right_PasswordRecoveryLayout.setHorizontalGroup(
            Right_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(PassRec_BttnCheckCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PassRec_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Right_PasswordRecoveryLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(PassRec_BttnSavePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
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
                .addGap(97, 97, 97)
                .addGroup(Right_PasswordRecoveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PassRec_BttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PassRec_BttnCheckCredentials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
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
                .addGap(32, 32, 32)
                .addComponent(PassRec_BttnSavePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
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

    private void PassRec_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnBackMouseExited
        PassRec_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_PassRec_lblBttnBackMouseExited

    private void PassRec_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnBackMouseEntered
        PassRec_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_PassRec_lblBttnBackMouseEntered

    private void PassRec_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnBackMouseClicked
        LogIn LogInFrame = new LogIn();
        LogInFrame.setVisible(true);
        LogInFrame.pack();
        LogInFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_PassRec_lblBttnBackMouseClicked

    private void PassRec_lblBttnSavePasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnSavePasswordMouseExited
        PassRec_BttnSavePassword.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_PassRec_lblBttnSavePasswordMouseExited

    private void PassRec_lblBttnSavePasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnSavePasswordMouseEntered
        PassRec_BttnSavePassword.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_PassRec_lblBttnSavePasswordMouseEntered

    ///guarda la contraseña nueva
    private void PassRec_lblBttnSavePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnSavePasswordMouseClicked

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
    }//GEN-LAST:event_PassRec_lblBttnSavePasswordMouseClicked

    private void PassRec_lblBttnCheckCredentialsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnCheckCredentialsMouseExited
        PassRec_BttnCheckCredentials.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_PassRec_lblBttnCheckCredentialsMouseExited

    private void PassRec_lblBttnCheckCredentialsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnCheckCredentialsMouseEntered
        PassRec_BttnCheckCredentials.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_PassRec_lblBttnCheckCredentialsMouseEntered

    private void PassRec_lblBttnCheckCredentialsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_lblBttnCheckCredentialsMouseClicked
        // TODO add your handling code here:

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
            PassRec_lblBttnSavePassword.setVisible(true);

            PassRec_textNewPassword.setEnabled(true);
            PassRec_textNewPasswordOK.setEnabled(true);
            System.out.println(user.getUsername());

        }else {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuario Inactivo.");
        }
    }//GEN-LAST:event_PassRec_lblBttnCheckCredentialsMouseClicked

    private void PassRec_textNewPasswordOKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_textNewPasswordOKMousePressed
        if (String.valueOf(PassRec_textNewPasswordOK.getPassword()).equals("**********")){
            PassRec_textNewPasswordOK.setText("");
            PassRec_textNewPasswordOK.setForeground(Color.black);
        }
        if (String.valueOf(PassRec_textNewPassword.getPassword()).isEmpty()){
            PassRec_textNewPassword.setText("**********");
            PassRec_textNewPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_PassRec_textNewPasswordOKMousePressed

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

    private void PassRec_textIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_textIDMousePressed
        if (PassRec_textID.getText().equals("Ingrese numero de cedula")){
            PassRec_textID.setText("");
            PassRec_textID.setForeground(Color.black);
        }
        if (PassRec_textUser.getText().isEmpty()){
            PassRec_textUser.setText("Ingrese su nombre");
            PassRec_textUser.setForeground(Color.gray);
        }
    }//GEN-LAST:event_PassRec_textIDMousePressed

    private void PassRec_textUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassRec_textUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassRec_textUserActionPerformed

    private void PassRec_textUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassRec_textUserMousePressed
        if(PassRec_textUser.getText().equals("Ingrese su nombre")){
            PassRec_textUser.setText("");
            PassRec_textUser.setForeground(Color.black);
        }
        if(PassRec_textID.getText().isEmpty()){
            PassRec_textID.setText("Ingrese numero de cedula");
            PassRec_textID.setForeground(Color.gray);
        }
    }//GEN-LAST:event_PassRec_textUserMousePressed

    
   
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PasswordRecovery().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left_PasswordRecovery;
    private javax.swing.JLabel LogInPanel_lblTittle;
    private javax.swing.JPanel PassRec_BttnBack;
    private javax.swing.JPanel PassRec_BttnCheckCredentials;
    private javax.swing.JPanel PassRec_BttnSavePassword;
    private javax.swing.JLabel PassRec_lblBttnBack;
    private javax.swing.JLabel PassRec_lblBttnCheckCredentials;
    private javax.swing.JLabel PassRec_lblBttnSavePassword;
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
