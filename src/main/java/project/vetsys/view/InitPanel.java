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
                InitPanel_lblBttnEnterMouseClicked(null);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        InitPanel_lblTittle = new javax.swing.JLabel();
        InitPanel_BttnEnter = new javax.swing.JPanel();
        InitPanel_lblBttnEnter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        background.setBackground(new java.awt.Color(204, 204, 255));
        background.setMaximumSize(new java.awt.Dimension(800, 600));
        background.setMinimumSize(new java.awt.Dimension(800, 600));
        background.setPreferredSize(new java.awt.Dimension(800, 600));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InitPanel_lblTittle.setBackground(new java.awt.Color(0, 255, 255));
        InitPanel_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 72)); // NOI18N
        InitPanel_lblTittle.setForeground(new java.awt.Color(0, 153, 153));
        InitPanel_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InitPanel_lblTittle.setText("VetSys");
        background.add(InitPanel_lblTittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 140));

        InitPanel_BttnEnter.setBackground(new java.awt.Color(0, 153, 153));

        InitPanel_lblBttnEnter.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        InitPanel_lblBttnEnter.setForeground(new java.awt.Color(255, 255, 255));
        InitPanel_lblBttnEnter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InitPanel_lblBttnEnter.setText("Empezar");
        InitPanel_lblBttnEnter.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        InitPanel_lblBttnEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InitPanel_lblBttnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InitPanel_lblBttnEnterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InitPanel_lblBttnEnterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InitPanel_lblBttnEnterMouseExited(evt);
            }
        });

        javax.swing.GroupLayout InitPanel_BttnEnterLayout = new javax.swing.GroupLayout(InitPanel_BttnEnter);
        InitPanel_BttnEnter.setLayout(InitPanel_BttnEnterLayout);
        InitPanel_BttnEnterLayout.setHorizontalGroup(
            InitPanel_BttnEnterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InitPanel_lblBttnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 194, Short.MAX_VALUE)
        );
        InitPanel_BttnEnterLayout.setVerticalGroup(
            InitPanel_BttnEnterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InitPanel_lblBttnEnter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, Short.MAX_VALUE)
        );

        background.add(InitPanel_BttnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 290, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        background.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InitPanel_lblBttnEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InitPanel_lblBttnEnterMouseClicked
        LogIn LogInFrame = new LogIn();
        LogInFrame.setVisible(true);
        LogInFrame.pack();
        LogInFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_InitPanel_lblBttnEnterMouseClicked

    private void InitPanel_lblBttnEnterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InitPanel_lblBttnEnterMouseEntered
        InitPanel_BttnEnter.setBackground(Color.LIGHT_GRAY);
        
    }//GEN-LAST:event_InitPanel_lblBttnEnterMouseEntered

    private void InitPanel_lblBttnEnterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InitPanel_lblBttnEnterMouseExited
        InitPanel_BttnEnter.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_InitPanel_lblBttnEnterMouseExited

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new InitPanel().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InitPanel_BttnEnter;
    private javax.swing.JLabel InitPanel_lblBttnEnter;
    private javax.swing.JLabel InitPanel_lblTittle;
    private javax.swing.JPanel background;
    // End of variables declaration//GEN-END:variables
}
