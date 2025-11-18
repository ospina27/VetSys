package project.vetsys.view;

import project.vetsys.view.security.LogIn;
import java.awt.Color;


public class InitPanel extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InitPanel.class.getName());

    /**
     * Creates new form InitPanel
     */
    public InitPanel() {
        initComponents();
        background.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(javax.swing.KeyStroke.getKeyStroke("ENTER"), "enterPressed");

        background.getActionMap().put("enterPressed", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            // Simula el clic en el botón "Empezar"
                InitPanel_BttnEnterMouseEntered(null);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        InitPanel_ImgVetSys = new javax.swing.JLabel();
        InitPanel_BttnEnter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMaximumSize(new java.awt.Dimension(800, 600));
        background.setMinimumSize(new java.awt.Dimension(800, 600));
        background.setPreferredSize(new java.awt.Dimension(800, 600));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InitPanel_ImgVetSys.setBackground(new java.awt.Color(255, 255, 255));
        InitPanel_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InitPanel_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N
        background.add(InitPanel_ImgVetSys, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 460));

        InitPanel_BttnEnter.setBackground(new java.awt.Color(0, 153, 153));
        InitPanel_BttnEnter.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        InitPanel_BttnEnter.setForeground(new java.awt.Color(255, 255, 255));
        InitPanel_BttnEnter.setText("Empezar");
        InitPanel_BttnEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InitPanel_BttnEnter.setFocusPainted(false);
        InitPanel_BttnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InitPanel_BttnEnterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InitPanel_BttnEnterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InitPanel_BttnEnterMouseExited(evt);
            }
        });
        background.add(InitPanel_BttnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        background.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InitPanel_BttnEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InitPanel_BttnEnterMouseClicked
        LogIn LogInFrame = new LogIn();
        LogInFrame.setVisible(true);
        LogInFrame.pack();
        LogInFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_InitPanel_BttnEnterMouseClicked

    private void InitPanel_BttnEnterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InitPanel_BttnEnterMouseEntered
        InitPanel_BttnEnter.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_InitPanel_BttnEnterMouseEntered

    private void InitPanel_BttnEnterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InitPanel_BttnEnterMouseExited
        InitPanel_BttnEnter.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_InitPanel_BttnEnterMouseExited

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new InitPanel().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InitPanel_BttnEnter;
    private javax.swing.JLabel InitPanel_ImgVetSys;
    private javax.swing.JPanel background;
    // End of variables declaration//GEN-END:variables
}
