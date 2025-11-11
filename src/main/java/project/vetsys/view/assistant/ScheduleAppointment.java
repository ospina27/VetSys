package project.vetsys.view.assistant;

import java.awt.Color;
import project.vetsys.model.User;
import project.vetsys.view.manager.Menu_Appointment;

public class ScheduleAppointment extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ScheduleAppointment.class.getName());
    private User logUser;
    
    public ScheduleAppointment() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScheduleAppointmentPanel = new javax.swing.JPanel();
        Up = new javax.swing.JPanel();
        ScheduleAppointment_lblTittle = new javax.swing.JLabel();
        Down = new javax.swing.JPanel();
        ScheduleAppointment_lblSubTittle = new javax.swing.JLabel();
        ScheduleAppointment_lblClientID = new javax.swing.JLabel();
        ScheduleAppointment_textIDClient = new javax.swing.JTextField();
        ScheduleAppointment_lblPet = new javax.swing.JLabel();
        ScheduleAppointment_ComboBoxPet = new javax.swing.JComboBox<>();
        ScheduleAppointment_lblVet = new javax.swing.JLabel();
        ScheduleAppointment_ComboBoxVet = new javax.swing.JComboBox<>();
        ScheduleAppointment_lblDayMonth = new javax.swing.JLabel();
        ScheduleAppointment_ComboBoxDayMonth = new javax.swing.JComboBox<>();
        ScheduleAppointment_lblDayMonth1 = new javax.swing.JLabel();
        ScheduleAppointment_ComboBoxDayMonth1 = new javax.swing.JComboBox<>();
        ScheduleAppointment_lblDayMonth2 = new javax.swing.JLabel();
        ScheduleAppointment_ComboBoxDayMonth2 = new javax.swing.JComboBox<>();
        ScheduleAppointment_BttnBack = new javax.swing.JPanel();
        ScheduleAppointment_lblBttnBack = new javax.swing.JLabel();
        ScheduleAppointment_BttnSchedule = new javax.swing.JPanel();
        ScheduleAppointment_lblBttnSchedule = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setSize(new java.awt.Dimension(1000, 800));

        ScheduleAppointmentPanel.setMaximumSize(new java.awt.Dimension(1000, 800));
        ScheduleAppointmentPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        ScheduleAppointmentPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        ScheduleAppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Up.setBackground(new java.awt.Color(0, 153, 153));
        Up.setMaximumSize(new java.awt.Dimension(1000, 100));
        Up.setMinimumSize(new java.awt.Dimension(1000, 100));

        ScheduleAppointment_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ScheduleAppointment_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblTittle.setText("VetSys");

        javax.swing.GroupLayout UpLayout = new javax.swing.GroupLayout(Up);
        Up.setLayout(UpLayout);
        UpLayout.setHorizontalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScheduleAppointment_lblTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        UpLayout.setVerticalGroup(
            UpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpLayout.createSequentialGroup()
                .addComponent(ScheduleAppointment_lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ScheduleAppointmentPanel.add(Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Down.setBackground(new java.awt.Color(255, 255, 255));
        Down.setMaximumSize(new java.awt.Dimension(1000, 700));
        Down.setMinimumSize(new java.awt.Dimension(1000, 700));

        ScheduleAppointment_lblSubTittle.setBackground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblSubTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ScheduleAppointment_lblSubTittle.setForeground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_lblSubTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblSubTittle.setText("Agendar Cita");

        ScheduleAppointment_lblClientID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblClientID.setText("Documento de Identidad");

        ScheduleAppointment_lblPet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblPet.setText("Mascota");

        ScheduleAppointment_ComboBoxPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ScheduleAppointment_lblVet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblVet.setText("Veterinario");

        ScheduleAppointment_ComboBoxVet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ScheduleAppointment_lblDayMonth.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblDayMonth.setText("Mes-Año");

        ScheduleAppointment_ComboBoxDayMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ScheduleAppointment_lblDayMonth1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblDayMonth1.setText("Dia");

        ScheduleAppointment_ComboBoxDayMonth1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ScheduleAppointment_lblDayMonth2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ScheduleAppointment_lblDayMonth2.setText("Hora");

        ScheduleAppointment_ComboBoxDayMonth2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ScheduleAppointment_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ScheduleAppointment_BttnBack.setPreferredSize(new java.awt.Dimension(260, 50));

        ScheduleAppointment_lblBttnBack.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ScheduleAppointment_lblBttnBack.setForeground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblBttnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblBttnBack.setText("Regresar");
        ScheduleAppointment_lblBttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ScheduleAppointment_lblBttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ScheduleAppointment_BttnBackLayout = new javax.swing.GroupLayout(ScheduleAppointment_BttnBack);
        ScheduleAppointment_BttnBack.setLayout(ScheduleAppointment_BttnBackLayout);
        ScheduleAppointment_BttnBackLayout.setHorizontalGroup(
            ScheduleAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScheduleAppointment_lblBttnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        ScheduleAppointment_BttnBackLayout.setVerticalGroup(
            ScheduleAppointment_BttnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScheduleAppointment_BttnBackLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ScheduleAppointment_lblBttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ScheduleAppointment_BttnSchedule.setBackground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_BttnSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ScheduleAppointment_lblBttnSchedule.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ScheduleAppointment_lblBttnSchedule.setForeground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblBttnSchedule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblBttnSchedule.setText("Agendar");
        ScheduleAppointment_lblBttnSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ScheduleAppointment_lblBttnSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnScheduleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnScheduleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScheduleAppointment_lblBttnScheduleMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ScheduleAppointment_BttnScheduleLayout = new javax.swing.GroupLayout(ScheduleAppointment_BttnSchedule);
        ScheduleAppointment_BttnSchedule.setLayout(ScheduleAppointment_BttnScheduleLayout);
        ScheduleAppointment_BttnScheduleLayout.setHorizontalGroup(
            ScheduleAppointment_BttnScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScheduleAppointment_lblBttnSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        ScheduleAppointment_BttnScheduleLayout.setVerticalGroup(
            ScheduleAppointment_BttnScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScheduleAppointment_BttnScheduleLayout.createSequentialGroup()
                .addComponent(ScheduleAppointment_lblBttnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DownLayout = new javax.swing.GroupLayout(Down);
        Down.setLayout(DownLayout);
        DownLayout.setHorizontalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ScheduleAppointment_lblClientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_ComboBoxVet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_textIDClient)
                            .addComponent(ScheduleAppointment_ComboBoxDayMonth1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_lblVet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_lblDayMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156)
                        .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ScheduleAppointment_ComboBoxPet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_ComboBoxDayMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_ComboBoxDayMonth2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_lblDayMonth2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_lblDayMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScheduleAppointment_lblPet, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addComponent(ScheduleAppointment_BttnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))))
            .addComponent(ScheduleAppointment_lblSubTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DownLayout.setVerticalGroup(
            DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownLayout.createSequentialGroup()
                .addComponent(ScheduleAppointment_lblSubTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblClientID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScheduleAppointment_textIDClient, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblPet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScheduleAppointment_ComboBoxPet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleAppointment_lblVet)
                    .addComponent(ScheduleAppointment_lblDayMonth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleAppointment_ComboBoxVet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleAppointment_ComboBoxDayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblDayMonth1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScheduleAppointment_ComboBoxDayMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DownLayout.createSequentialGroup()
                        .addComponent(ScheduleAppointment_lblDayMonth2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScheduleAppointment_ComboBoxDayMonth2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82)
                .addGroup(DownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScheduleAppointment_BttnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleAppointment_BttnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        ScheduleAppointmentPanel.add(Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ScheduleAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScheduleAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ScheduleAppointment_lblBttnScheduleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnScheduleMouseExited
        ScheduleAppointment_BttnSchedule.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_ScheduleAppointment_lblBttnScheduleMouseExited

    private void ScheduleAppointment_lblBttnScheduleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnScheduleMouseEntered
        ScheduleAppointment_BttnSchedule.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ScheduleAppointment_lblBttnScheduleMouseEntered

    private void ScheduleAppointment_lblBttnScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnScheduleMouseClicked
        // Consulta SQL para agendar cita
    }//GEN-LAST:event_ScheduleAppointment_lblBttnScheduleMouseClicked

    private void ScheduleAppointment_lblBttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseExited
        ScheduleAppointment_BttnBack.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseExited

    private void ScheduleAppointment_lblBttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseEntered
        ScheduleAppointment_BttnBack.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseEntered

    private void ScheduleAppointment_lblBttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleAppointment_lblBttnBackMouseClicked
        Menu_Appointment MenuAppointmentFrame = new Menu_Appointment(logUser);
        MenuAppointmentFrame.setVisible(true);
        MenuAppointmentFrame.pack();
        MenuAppointmentFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ScheduleAppointment_lblBttnBackMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ScheduleAppointment().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Down;
    private javax.swing.JPanel ScheduleAppointmentPanel;
    private javax.swing.JPanel ScheduleAppointment_BttnBack;
    private javax.swing.JPanel ScheduleAppointment_BttnSchedule;
    private javax.swing.JComboBox<String> ScheduleAppointment_ComboBoxDayMonth;
    private javax.swing.JComboBox<String> ScheduleAppointment_ComboBoxDayMonth1;
    private javax.swing.JComboBox<String> ScheduleAppointment_ComboBoxDayMonth2;
    private javax.swing.JComboBox<String> ScheduleAppointment_ComboBoxPet;
    private javax.swing.JComboBox<String> ScheduleAppointment_ComboBoxVet;
    private javax.swing.JLabel ScheduleAppointment_lblBttnBack;
    private javax.swing.JLabel ScheduleAppointment_lblBttnSchedule;
    private javax.swing.JLabel ScheduleAppointment_lblClientID;
    private javax.swing.JLabel ScheduleAppointment_lblDayMonth;
    private javax.swing.JLabel ScheduleAppointment_lblDayMonth1;
    private javax.swing.JLabel ScheduleAppointment_lblDayMonth2;
    private javax.swing.JLabel ScheduleAppointment_lblPet;
    private javax.swing.JLabel ScheduleAppointment_lblSubTittle;
    private javax.swing.JLabel ScheduleAppointment_lblTittle;
    private javax.swing.JLabel ScheduleAppointment_lblVet;
    private javax.swing.JTextField ScheduleAppointment_textIDClient;
    private javax.swing.JPanel Up;
    // End of variables declaration//GEN-END:variables
}
