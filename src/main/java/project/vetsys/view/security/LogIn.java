package project.vetsys.view.security;

import java.awt.Color;
import javax.swing.JOptionPane;
import project.vetsys.dao.UserDAO;
import project.vetsys.model.User;
import java.awt.event.KeyEvent;
import project.vetsys.view.Nimbus;
import project.vetsys.view.manager.MenuManager;



public class LogIn extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LogIn.class.getName());

    public LogIn() {
        Nimbus.LookandFeel();
        initComponents();
        aplicarAccesibilidad();
        conectarAccionesBotones();

        Nimbus.styleAllTextFields(this);
        Nimbus.styleLabel(LogInPanel_lblUsername);
        Nimbus.styleLabel(LogInPanel_lblPassword);
        setTitle("VET SYS");
        //Nimbus.styleAllLabelsExcept(this, LogInPanel_lblTittle);
        //ValidationInput.numbers(LogInPanel_txtPassword);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogInPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        LogInPanel_ImgVetSys = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        LogInPanel_lblLogin = new javax.swing.JLabel();
        LogInPanel_lblUsername = new javax.swing.JLabel();
        LogInPanel_txtUsername = new javax.swing.JTextField();
        LogInPanel_lblPassword = new javax.swing.JLabel();
        LogInPanel_lblResetPassword = new javax.swing.JLabel();
        LogInPanel_BttnResetPassword = new javax.swing.JLabel();
        LogInPanel_txtPassword = new javax.swing.JPasswordField();
        LogInPanel_BttnLogin = new javax.swing.JButton();

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

        LogInPanel_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        LogInPanel_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        LogInPanel_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogInPanel_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N
        LogInPanel_ImgVetSys.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
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
        LogInPanel_txtUsername.setForeground(java.awt.Color.gray);
        LogInPanel_txtUsername.setToolTipText("");
        LogInPanel_txtUsername.setAlignmentY(0.0F);
        LogInPanel_txtUsername.setBorder(null);

        LogInPanel_lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LogInPanel_lblPassword.setText("Contraseña");

        LogInPanel_lblResetPassword.setBackground(new java.awt.Color(255, 255, 255));
        LogInPanel_lblResetPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LogInPanel_lblResetPassword.setText("Olvidaste la contraseña?");

        LogInPanel_BttnResetPassword.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LogInPanel_BttnResetPassword.setForeground(new java.awt.Color(0, 153, 153));
        LogInPanel_BttnResetPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogInPanel_BttnResetPassword.setText("Click Aquí");
        LogInPanel_BttnResetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        LogInPanel_txtPassword.setForeground(java.awt.Color.gray);
        LogInPanel_txtPassword.setBorder(null);

        LogInPanel_BttnLogin.setBackground(new java.awt.Color(0, 153, 153));
        LogInPanel_BttnLogin.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        LogInPanel_BttnLogin.setForeground(new java.awt.Color(255, 255, 255));
        LogInPanel_BttnLogin.setText("Ingresar");
        LogInPanel_BttnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LogInPanel_BttnLogin.setFocusPainted(false);
        LogInPanel_BttnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInPanel_BttnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogInPanel_BttnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogInPanel_BttnLoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addComponent(LogInPanel_lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 400, Short.MAX_VALUE))
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LogInPanel_lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogInPanel_txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LogInPanel_txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(LogInPanel_lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(RightLayout.createSequentialGroup()
                                    .addComponent(LogInPanel_lblResetPassword)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LogInPanel_BttnResetPassword)))))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(LogInPanel_BttnLogin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(52, 52, 52)
                .addComponent(LogInPanel_lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogInPanel_txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(LogInPanel_BttnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
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

    private void LogInPanel_BttnResetPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_BttnResetPasswordMouseEntered
        LogInPanel_BttnResetPassword.setForeground(Color.blue);
    }//GEN-LAST:event_LogInPanel_BttnResetPasswordMouseEntered

    private void LogInPanel_BttnResetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_BttnResetPasswordMouseExited
        LogInPanel_BttnResetPassword.setForeground(new Color(0,153,153));
    }//GEN-LAST:event_LogInPanel_BttnResetPasswordMouseExited

    private void LogInPanel_BttnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_BttnLoginMouseClicked
        boolean flag = true;
        
        String username = LogInPanel_txtUsername.getText().trim();
        String password = new String(LogInPanel_txtPassword.getPassword());

        // Validar que no estén vacíos
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese usuario y contraseña.", "Vet Sys", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.login(username, password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error de conexión" + ex.getMessage(), 
                                          "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (user != null) {
            
            // Credenciales correctas
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso. Bienvenido " + user.getUsername(),
                    user.getClinic().getName_clinic(),JOptionPane.INFORMATION_MESSAGE);
            
            MenuManager MenuManagerFrame = new MenuManager(user);
            MenuManagerFrame.setVisible(true);
            MenuManagerFrame.pack();
            MenuManagerFrame.setLocationRelativeTo(null);
            this.dispose(); // Cierra la ventana de login

        } else {
        // Usuario o contraseña incorrectos
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LogInPanel_BttnLoginMouseClicked

    private void LogInPanel_BttnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_BttnLoginMouseEntered
        LogInPanel_BttnLogin.setBackground(Color.LIGHT_GRAY);
        LogInPanel_BttnLogin.setForeground(Color.BLACK);
    }//GEN-LAST:event_LogInPanel_BttnLoginMouseEntered

    private void LogInPanel_BttnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInPanel_BttnLoginMouseExited
        LogInPanel_BttnLogin.setBackground(new Color(0,153,153));
        LogInPanel_BttnLogin.setForeground(Color.WHITE);
    }//GEN-LAST:event_LogInPanel_BttnLoginMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel LogInPanel;
    private javax.swing.JButton LogInPanel_BttnLogin;
    private javax.swing.JLabel LogInPanel_BttnResetPassword;
    private javax.swing.JLabel LogInPanel_ImgVetSys;
    private javax.swing.JLabel LogInPanel_lblLogin;
    private javax.swing.JLabel LogInPanel_lblPassword;
    private javax.swing.JLabel LogInPanel_lblResetPassword;
    private javax.swing.JLabel LogInPanel_lblUsername;
    private javax.swing.JPasswordField LogInPanel_txtPassword;
    private javax.swing.JTextField LogInPanel_txtUsername;
    private javax.swing.JPanel Right;
    // End of variables declaration//GEN-END:variables

    private void aplicarAccesibilidad() {
    // ============================================================
    //  TITULO
    // ============================================================
    LogInPanel_lblLogin.getAccessibleContext().setAccessibleName("Título Login");
    LogInPanel_lblLogin.getAccessibleContext().setAccessibleDescription("Pantalla de inicio de sesión del sistema Vet Sys");

    // ============================================================
    //  LABELS
    // ============================================================
    // Usuario
    LogInPanel_lblUsername.setLabelFor(LogInPanel_txtUsername);
    LogInPanel_lblUsername.setDisplayedMnemonic('U'); 
    LogInPanel_lblUsername.setToolTipText("Campo de usuario (Alt+U)");
    LogInPanel_lblUsername.getAccessibleContext().setAccessibleName("Etiqueta Usuario");
    LogInPanel_lblUsername.getAccessibleContext().setAccessibleDescription("Etiqueta del campo para ingresar el nombre de usuario");

    // Contraseña
    LogInPanel_lblPassword.setLabelFor(LogInPanel_txtPassword);
    LogInPanel_lblPassword.setDisplayedMnemonic('C'); 
    LogInPanel_lblPassword.setToolTipText("Campo de contraseña (Alt+C)");
    LogInPanel_lblPassword.getAccessibleContext().setAccessibleName("Etiqueta Contraseña");
    LogInPanel_lblPassword.getAccessibleContext().setAccessibleDescription("Etiqueta del campo para ingresar la contraseña");

    // Olvidaste contraseña
    LogInPanel_lblResetPassword.getAccessibleContext().setAccessibleName("Texto recuperar contraseña");
    LogInPanel_lblResetPassword.getAccessibleContext().setAccessibleDescription("Texto informativo sobre recuperación de contraseña");
    LogInPanel_BttnResetPassword.getAccessibleContext().setAccessibleName("Botón recuperar contraseña");
    LogInPanel_BttnResetPassword.getAccessibleContext().setAccessibleDescription("Haz clic para recuperar contraseña");
    LogInPanel_BttnResetPassword.setToolTipText("Recuperar contraseña (Alt+R)");

    // ============================================================
    //  CAMPOS
    // ============================================================
    LogInPanel_txtUsername.getAccessibleContext().setAccessibleName("Campo Usuario");
    LogInPanel_txtUsername.getAccessibleContext().setAccessibleDescription("Ingrese aquí su nombre de usuario");
    LogInPanel_txtUsername.setToolTipText("Ingrese su nombre de usuario (Alt+U)");

    LogInPanel_txtPassword.getAccessibleContext().setAccessibleName("Campo Contraseña");
    LogInPanel_txtPassword.getAccessibleContext().setAccessibleDescription("Ingrese aquí su contraseña");
    LogInPanel_txtPassword.setToolTipText("Ingrese su contraseña (Alt+C)");

    // ============================================================
    //  BOTÓN LOGIN
    // ============================================================
    LogInPanel_BttnLogin.setMnemonic('G'); // G de "Ingresar"
    LogInPanel_BttnLogin.setToolTipText("Ingresar (Alt+G)");
    LogInPanel_BttnLogin.getAccessibleContext().setAccessibleName("Botón Ingresar");
    LogInPanel_BttnLogin.getAccessibleContext().setAccessibleDescription("Botón para iniciar sesión en el sistema");

    // ============================================================
    //  TAB ORDER
    // ============================================================
    LogInPanel_txtUsername.setNextFocusableComponent(LogInPanel_txtPassword);
    LogInPanel_txtPassword.setNextFocusableComponent(LogInPanel_BttnLogin);
    LogInPanel_BttnLogin.setNextFocusableComponent(LogInPanel_BttnResetPassword);

    // Paneles enfocable si se usan para navegación
    Left.setFocusable(true);
    Right.setFocusable(true);

    // ============================================================
    //  ATAJOS GLOBALS ALT (InputMap / ActionMap)
    // ============================================================
    javax.swing.InputMap im = getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
    javax.swing.ActionMap am = getRootPane().getActionMap();

    // ALT+U → Foco usuario
    im.put(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.ALT_DOWN_MASK), "foco_usuario");
    am.put("foco_usuario", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            LogInPanel_txtUsername.requestFocusInWindow();
        }
    });

    // ALT+C → Foco contraseña
    im.put(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.ALT_DOWN_MASK), "foco_contra");
    am.put("foco_contra", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            LogInPanel_txtPassword.requestFocusInWindow();
        }
    });

    // ALT+G → Ejecutar Ingresar
    im.put(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.ALT_DOWN_MASK), "accion_ingresar");
    am.put("accion_ingresar", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            LogInPanel_BttnLogin.doClick();
        }
    });

    // ALT+R → Recuperar contraseña
    im.put(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.ALT_DOWN_MASK), "accion_recuperar");
    am.put("accion_recuperar", new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            LogInPanel_BttnResetPasswordMouseClicked(null);
        }
    });

}

        private void conectarAccionesBotones() {

            LogInPanel_BttnLogin.addActionListener(e -> {

                String username = LogInPanel_txtUsername.getText().trim();
                String password = new String(LogInPanel_txtPassword.getPassword());

                // Validar vacíos
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor ingrese usuario y contraseña.", 
                                                  "Vet Sys", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                UserDAO userDAO = new UserDAO();
                User user = null;

                try {
                    user = userDAO.login(username, password);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Error de conexión" + ex.getMessage(),
                                                  "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (user != null) {
                    JOptionPane.showMessageDialog(this, 
                            "Inicio de sesión exitoso. Bienvenido " + user.getUsername(),
                            user.getClinic().getName_clinic(), 
                            JOptionPane.INFORMATION_MESSAGE);

                    MenuManager MenuManagerFrame = new MenuManager(user);
                    MenuManagerFrame.setVisible(true);
                    MenuManagerFrame.pack();
                    MenuManagerFrame.setLocationRelativeTo(null);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(this,
                            "Usuario o contraseña incorrectos.",
                            "Error de inicio de sesión",
                            JOptionPane.ERROR_MESSAGE);
                }
            });

            LogInPanel_BttnResetPassword.addMouseListener(new java.awt.event.MouseAdapter() {}); 
            LogInPanel_BttnResetPassword.addPropertyChangeListener(evt -> {
            });

            // Acción accesible (teclado/lectores pantalla)
            LogInPanel_BttnResetPassword.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                        LogInPanel_BttnResetPasswordMouseClicked(null);
                    }
                }
            });
        }

}



