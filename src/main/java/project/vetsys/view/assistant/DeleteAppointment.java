package project.vetsys.view.assistant;

import java.awt.Color;
import project.vetsys.model.User;
import project.vetsys.view.manager.Menu_Appointment;

public class DeleteAppointment extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DeleteAppointment.class.getName());
    private User logUser;
    
    public DeleteAppointment() {
        initComponents();
    }
    
    public DeleteAppointment(User logUser){
            initComponents();
            this.logUser = logUser;
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeleteAppointmentPanel = new javax.swing.JPanel();
        Up = new javax.swing.JPanel();
        DeleteAppointment_lblTittle = new javax.swing.JLabel();
        Down = new javax.swing.JPanel();
        DeleteAppointment_lblSubTittle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DeleteAppointment_BttnBack = new javax.swing.JPanel();
        DeleteAppointment_lblBttnBack = new javax.swing.JLabel();
        DeleteAppointment_BttnDelete = new javax.swing.JPanel();
        DeleteAppointment_lblBttnDelete = new javax.swing.JLabel();
        DeleteAppointment_lblClientID = new javax.swing.JLabel();
        DeleteAppointment_textIDClient = new javax.swing.JTextField();
        DeleteAppointment_lblPet = new javax.swing.JLabel();
        DeleteAppointment_ComboBoxPet = new javax.swing.JComboBox<>();
        DeleteAppointment_lblVet = new javax.swing.JLabel();
        DeleteAppointment_textVet = new javax.swing.JTextField();
        DeleteAppointment_lblDate = new javax.swing.JLabel();
        DeleteAppointment_textDate = new javax.swing.JTextField();
        DeleteAppointment_lblStatus = new javax.swing.JLabel();
        DeleteAppointment_textStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setSize(new java.awt.Dimension(1000, 800));

        DeleteAppointmentPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        DeleteAppointmentPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        DeleteAppointmentPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        DeleteAppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Up.setBackground(new java.awt.Color(0, 153, 153));
        Up.setMaximumSize(new java.awt.Dimension(1000, 100));
        Up.setMinimumSize(new java.awt.Dimension(1000, 100));

        DeleteAppointment_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        DeleteAppointment_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        DeleteAppointment_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeleteAppointment_lblTittle.setText("VetSys");

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteAppointment_lblTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addComponent(DeleteAppointment_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        DeleteAppointmentPanel.add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Down.setBackground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(1000, 700));
        Down.setMinimumSize(new java.awt.Dimension(1000, 700));

        DeleteAppointment_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        DeleteAppointment_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        DeleteAppointment_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        DeleteAppointment_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeleteAppointment_lblSubTittle.setText("Eliminar Cita");

        DeleteAppointment_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        DeleteAppointment_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DeleteAppointment_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        DeleteAppointment_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        DeleteAppointment_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeleteAppointment_lblBttnBack.setText("Regresar");
        DeleteAppointment_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteAppointment_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteAppointment_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteAppointment_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteAppointment_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout DeleteAppointment_BttnBackLayout = new javax.swing.GroupLayout(DeleteAppointment_BttnBack);
        DeleteAppointment_BttnBack.setLayout(DeleteAppointment_BttnBackLayout);
        DeleteAppointment_BttnBackLayout.setHorizontalGroup(
            DeleteAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteAppointment_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        DeleteAppointment_BttnBackLayout.setVerticalGroup(
            DeleteAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteAppointment_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(DeleteAppointment_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DeleteAppointment_BttnDelete.setBackground(new java.awt.Color(0, 153, 153));
        DeleteAppointment_BttnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DeleteAppointment_lblBttnDelete.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        DeleteAppointment_lblBttnDelete.setForeground(new java.awt.Color(255, 255, 255));
        DeleteAppointment_lblBttnDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeleteAppointment_lblBttnDelete.setText("Eliminar");
        DeleteAppointment_lblBttnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteAppointment_lblBttnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteAppointment_lblBttnDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteAppointment_lblBttnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteAppointment_lblBttnDeleteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout DeleteAppointment_BttnDeleteLayout = new javax.swing.GroupLayout(DeleteAppointment_BttnDelete);
        DeleteAppointment_BttnDelete.setLayout(DeleteAppointment_BttnDeleteLayout);
        DeleteAppointment_BttnDeleteLayout.setHorizontalGroup(
            DeleteAppointment_BttnDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteAppointment_lblBttnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        DeleteAppointment_BttnDeleteLayout.setVerticalGroup(
            DeleteAppointment_BttnDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteAppointment_BttnDeleteLayout.createSequentialGroup()
                .addComponent(DeleteAppointment_lblBttnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        DeleteAppointment_lblClientID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DeleteAppointment_lblClientID.setText("Documento Identidad Cliente");

        DeleteAppointment_textIDClient.setText("jTextField1");
        DeleteAppointment_textIDClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAppointment_textIDClientActionPerformed(evt);
            }
        });

        DeleteAppointment_lblPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DeleteAppointment_lblPet.setText("Mascota");

        DeleteAppointment_ComboBoxPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DeleteAppointment_lblVet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DeleteAppointment_lblVet.setText("Veterinario");

        DeleteAppointment_textVet.setText("jTextField2");
        DeleteAppointment_textVet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAppointment_textVetActionPerformed(evt);
            }
        });

        DeleteAppointment_lblDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DeleteAppointment_lblDate.setText("Fecha");

        DeleteAppointment_textDate.setText("jTextField3");

        DeleteAppointment_lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DeleteAppointment_lblStatus.setText("Estado");

        DeleteAppointment_textStatus.setText("jTextField4");

        javax.swing.GroupLayout DownLayout = new javax.swing.GroupLayout(Down);
        Down.setLayout(DownLayout);
        DownLayout.setHorizontalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(DeleteAppointment_BttnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(DeleteAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DownLayout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeleteAppointment_lblClientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteAppointment_textIDClient)
                    .addComponent(DeleteAppointment_ComboBoxPet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteAppointment_textVet)
                    .addComponent(DeleteAppointment_lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteAppointment_lblVet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteAppointment_lblPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteAppointment_textDate)
                    .addComponent(DeleteAppointment_lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteAppointment_textStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(161, 161, 161)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(401, 401, 401))
            .addGroup(DownLayout.createSequentialGroup()
                .addComponent(DeleteAppointment_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addComponent(DeleteAppointment_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(DeleteAppointment_lblClientID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteAppointment_textIDClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(DeleteAppointment_lblPet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteAppointment_ComboBoxPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(DeleteAppointment_lblVet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteAppointment_textVet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(DeleteAppointment_lblDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteAppointment_textDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(DeleteAppointment_lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteAppointment_textStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteAppointment_BttnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        DeleteAppointmentPanel.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DeleteAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DeleteAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteAppointment_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAppointment_lblBttnBackMouseClicked
        Menu_Appointment MenuAppointmentFrame = new Menu_Appointment(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_DeleteAppointment_lblBttnBackMouseClicked

    private void DeleteAppointment_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAppointment_lblBttnBackMouseEntered
        DeleteAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_DeleteAppointment_lblBttnBackMouseEntered

    private void DeleteAppointment_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAppointment_lblBttnBackMouseExited
        DeleteAppointment_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_DeleteAppointment_lblBttnBackMouseExited

    private void DeleteAppointment_lblBttnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAppointment_lblBttnDeleteMouseClicked
        //Consulta SQL que elimina
    }//GEN-LAST:event_DeleteAppointment_lblBttnDeleteMouseClicked

    private void DeleteAppointment_lblBttnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAppointment_lblBttnDeleteMouseEntered
        DeleteAppointment_BttnDelete.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_DeleteAppointment_lblBttnDeleteMouseEntered

    private void DeleteAppointment_lblBttnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAppointment_lblBttnDeleteMouseExited
        DeleteAppointment_BttnDelete.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_DeleteAppointment_lblBttnDeleteMouseExited

    private void DeleteAppointment_textIDClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAppointment_textIDClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteAppointment_textIDClientActionPerformed

    private void DeleteAppointment_textVetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAppointment_textVetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteAppointment_textVetActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new DeleteAppointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeleteAppointmentPanel;
    private javax.swing.JPanel DeleteAppointment_BttnBack;
    private javax.swing.JPanel DeleteAppointment_BttnDelete;
    private javax.swing.JComboBox<String> DeleteAppointment_ComboBoxPet;
    private javax.swing.JLabel DeleteAppointment_lblBttnBack;
    private javax.swing.JLabel DeleteAppointment_lblBttnDelete;
    private javax.swing.JLabel DeleteAppointment_lblClientID;
    private javax.swing.JLabel DeleteAppointment_lblDate;
    private javax.swing.JLabel DeleteAppointment_lblPet;
    private javax.swing.JLabel DeleteAppointment_lblStatus;
    private javax.swing.JLabel DeleteAppointment_lblSubTittle;
    private javax.swing.JLabel DeleteAppointment_lblTittle;
    private javax.swing.JLabel DeleteAppointment_lblVet;
    private javax.swing.JTextField DeleteAppointment_textDate;
    private javax.swing.JTextField DeleteAppointment_textIDClient;
    private javax.swing.JTextField DeleteAppointment_textStatus;
    private javax.swing.JTextField DeleteAppointment_textVet;
    private javax.swing.JPanel Down;
    private javax.swing.JPanel Up;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
