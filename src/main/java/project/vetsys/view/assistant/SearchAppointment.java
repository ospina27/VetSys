/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.vetsys.view.assistant;

import java.awt.Color;
import project.vetsys.model.User;
import project.vetsys.view.manager.Menu_Appointment;

/**
 *
 * @author San
 */
public class SearchAppointment extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SearchAppointment.class.getName());
    private User logUser;
    
    public SearchAppointment() {
        initComponents();
    }

    public SearchAppointment(User logUser){
        initComponents();
        this.logUser = logUser;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchAppointmentPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        SearchAppointment_lblTitle = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        SearchAppointment_lblClientID = new javax.swing.JLabel();
        SearchAppointment_textIDClient = new javax.swing.JTextField();
        SearchAppointment_lblPet = new javax.swing.JLabel();
        SearchAppointment_ComboBoxPet = new javax.swing.JComboBox<>();
        SearchAppointment_lblVet = new javax.swing.JLabel();
        SearchAppointment_textVet = new javax.swing.JTextField();
        SearchAppointment_lblDate = new javax.swing.JLabel();
        SearchAppointment_textDate = new javax.swing.JTextField();
        SearchAppointment_lblStatus = new javax.swing.JLabel();
        SearchAppointment_textStatus = new javax.swing.JTextField();
        SearchAppointment_BttnBack = new javax.swing.JPanel();
        SearchAppointment_lblBttnBack = new javax.swing.JLabel();
        SearchAppointment_BttnSearch = new javax.swing.JPanel();
        SearchAppointment_lblBttnSearch = new javax.swing.JLabel();
        SearchAppointment_BttnUpdate = new javax.swing.JPanel();
        SearchAppointment_lblBttnUpdate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setSize(new java.awt.Dimension(1000, 800));

        SearchAppointmentPanel.setBackground(new java.awt.Color(255, 255, 255));
        SearchAppointmentPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        SearchAppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(500, 800));
        Left.setMinimumSize(new java.awt.Dimension(500, 800));

        SearchAppointment_lblTitle.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        SearchAppointment_lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        SearchAppointment_lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchAppointment_lblTitle.setText("VetSys");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchAppointment_lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchAppointment_lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        SearchAppointmentPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(500, 800));
        Right.setMinimumSize(new java.awt.Dimension(500, 800));
        Right.setPreferredSize(new java.awt.Dimension(500, 800));

        SearchAppointment_lblClientID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblClientID.setText("Documento Identidad Cliente");

        SearchAppointment_textIDClient.setText("jTextField1");
        SearchAppointment_textIDClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchAppointment_textIDClientActionPerformed(evt);
            }
        });

        SearchAppointment_lblPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblPet.setText("Mascota");

        SearchAppointment_ComboBoxPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SearchAppointment_lblVet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblVet.setText("Veterinario");

        SearchAppointment_textVet.setText("jTextField2");
        SearchAppointment_textVet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchAppointment_textVetActionPerformed(evt);
            }
        });

        SearchAppointment_lblDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblDate.setText("Fecha");

        SearchAppointment_textDate.setText("jTextField3");

        SearchAppointment_lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchAppointment_lblStatus.setText("Estado");

        SearchAppointment_textStatus.setText("jTextField4");

        SearchAppointment_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        SearchAppointment_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        SearchAppointment_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        SearchAppointment_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        SearchAppointment_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchAppointment_lblBttnBack.setText("Regresar");
        SearchAppointment_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SearchAppointment_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SearchAppointment_BttnBackLayout = new javax.swing.GroupLayout(SearchAppointment_BttnBack);
        SearchAppointment_BttnBack.setLayout(SearchAppointment_BttnBackLayout);
        SearchAppointment_BttnBackLayout.setHorizontalGroup(
            SearchAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchAppointment_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        SearchAppointment_BttnBackLayout.setVerticalGroup(
            SearchAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchAppointment_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SearchAppointment_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SearchAppointment_BttnSearch.setBackground(new java.awt.Color(0, 153, 153));
        SearchAppointment_BttnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        SearchAppointment_lblBttnSearch.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        SearchAppointment_lblBttnSearch.setForeground(new java.awt.Color(255, 255, 255));
        SearchAppointment_lblBttnSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchAppointment_lblBttnSearch.setText("Consultar");
        SearchAppointment_lblBttnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SearchAppointment_lblBttnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnSearchMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SearchAppointment_BttnSearchLayout = new javax.swing.GroupLayout(SearchAppointment_BttnSearch);
        SearchAppointment_BttnSearch.setLayout(SearchAppointment_BttnSearchLayout);
        SearchAppointment_BttnSearchLayout.setHorizontalGroup(
            SearchAppointment_BttnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchAppointment_lblBttnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        SearchAppointment_BttnSearchLayout.setVerticalGroup(
            SearchAppointment_BttnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchAppointment_BttnSearchLayout.createSequentialGroup()
                .addComponent(SearchAppointment_lblBttnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        SearchAppointment_BttnUpdate.setBackground(new java.awt.Color(0, 153, 153));
        SearchAppointment_BttnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        SearchAppointment_lblBttnUpdate.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        SearchAppointment_lblBttnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        SearchAppointment_lblBttnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SearchAppointment_lblBttnUpdate.setText("Modificar");
        SearchAppointment_lblBttnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SearchAppointment_lblBttnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchAppointment_lblBttnUpdateMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SearchAppointment_BttnUpdateLayout = new javax.swing.GroupLayout(SearchAppointment_BttnUpdate);
        SearchAppointment_BttnUpdate.setLayout(SearchAppointment_BttnUpdateLayout);
        SearchAppointment_BttnUpdateLayout.setHorizontalGroup(
            SearchAppointment_BttnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchAppointment_lblBttnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        SearchAppointment_BttnUpdateLayout.setVerticalGroup(
            SearchAppointment_BttnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchAppointment_BttnUpdateLayout.createSequentialGroup()
                .addComponent(SearchAppointment_lblBttnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SearchAppointment_lblClientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SearchAppointment_textIDClient)
                            .addComponent(SearchAppointment_ComboBoxPet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SearchAppointment_textVet)
                            .addComponent(SearchAppointment_lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SearchAppointment_lblVet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SearchAppointment_lblPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SearchAppointment_textDate)
                            .addComponent(SearchAppointment_lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SearchAppointment_textStatus)))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(SearchAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(SearchAppointment_BttnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(SearchAppointment_BttnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(SearchAppointment_lblClientID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchAppointment_textIDClient, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchAppointment_lblPet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchAppointment_ComboBoxPet, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchAppointment_lblVet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchAppointment_textVet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchAppointment_lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchAppointment_textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchAppointment_lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchAppointment_textStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchAppointment_BttnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(SearchAppointment_BttnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        SearchAppointmentPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SearchAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SearchAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchAppointment_textIDClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchAppointment_textIDClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchAppointment_textIDClientActionPerformed

    private void SearchAppointment_textVetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchAppointment_textVetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchAppointment_textVetActionPerformed

    private void SearchAppointment_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnBackMouseClicked
        Menu_Appointment MenuAppointmentFrame = new Menu_Appointment(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_SearchAppointment_lblBttnBackMouseClicked

    private void SearchAppointment_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnBackMouseEntered
        SearchAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SearchAppointment_lblBttnBackMouseEntered

    private void SearchAppointment_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnBackMouseExited
        SearchAppointment_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_SearchAppointment_lblBttnBackMouseExited

    private void SearchAppointment_lblBttnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnSearchMouseClicked
        // Consulta SQL de Busqueda
    }//GEN-LAST:event_SearchAppointment_lblBttnSearchMouseClicked

    private void SearchAppointment_lblBttnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnSearchMouseEntered
        SearchAppointment_BttnSearch.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SearchAppointment_lblBttnSearchMouseEntered

    private void SearchAppointment_lblBttnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnSearchMouseExited
        SearchAppointment_BttnSearch.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_SearchAppointment_lblBttnSearchMouseExited

    private void SearchAppointment_lblBttnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchAppointment_lblBttnUpdateMouseClicked

    private void SearchAppointment_lblBttnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnUpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchAppointment_lblBttnUpdateMouseEntered

    private void SearchAppointment_lblBttnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAppointment_lblBttnUpdateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchAppointment_lblBttnUpdateMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SearchAppointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel SearchAppointmentPanel;
    private javax.swing.JPanel SearchAppointment_BttnBack;
    private javax.swing.JPanel SearchAppointment_BttnSearch;
    private javax.swing.JPanel SearchAppointment_BttnUpdate;
    private javax.swing.JComboBox<String> SearchAppointment_ComboBoxPet;
    private javax.swing.JLabel SearchAppointment_lblBttnBack;
    private javax.swing.JLabel SearchAppointment_lblBttnSearch;
    private javax.swing.JLabel SearchAppointment_lblBttnUpdate;
    private javax.swing.JLabel SearchAppointment_lblClientID;
    private javax.swing.JLabel SearchAppointment_lblDate;
    private javax.swing.JLabel SearchAppointment_lblPet;
    private javax.swing.JLabel SearchAppointment_lblStatus;
    private javax.swing.JLabel SearchAppointment_lblTitle;
    private javax.swing.JLabel SearchAppointment_lblVet;
    private javax.swing.JTextField SearchAppointment_textDate;
    private javax.swing.JTextField SearchAppointment_textIDClient;
    private javax.swing.JTextField SearchAppointment_textStatus;
    private javax.swing.JTextField SearchAppointment_textVet;
    // End of variables declaration//GEN-END:variables
}
