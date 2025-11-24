package project.vetsys.view.assistant;

import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import project.vetsys.dao.CitaDAO;
import project.vetsys.model.Cita;
import project.vetsys.model.User;
import project.vetsys.view.manager.MenuManager;

public class NotificationPanel extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NotificationPanel.class.getName());
    private User logUser;

    public NotificationPanel() {
        initComponents();
        cargarColumnasTabla();
        cargarTodasLasCitas();
    }
        
    public NotificationPanel(User logUser){
        initComponents();
        this.logUser = logUser;
        cargarColumnasTabla();
        cargarTodasLasCitas();
    }  
    
    private void ocultarColumnaVeterinario() {
        // La columna 7 contiene id veterinario
        NotificationPanel_Table.getColumnModel().getColumn(7).setMinWidth(0);
        NotificationPanel_Table.getColumnModel().getColumn(7).setMaxWidth(0);
        NotificationPanel_Table.getColumnModel().getColumn(7).setWidth(0);
    }
    
    private void cargarColumnasTabla() {
        
        DefaultTableModel model = (DefaultTableModel) NotificationPanel_Table.getModel();
        model.addColumn("ID Cita");         // 0
        model.addColumn("Cliente");         // 1
        model.addColumn("Mascota");         // 2
        model.addColumn("Veterinario");     // 3
        model.addColumn("Fecha");           // 4
        model.addColumn("Hora");            // 5
        model.addColumn("Estado");          // 6
        model.addColumn("ID_Vet");  // columna oculta
        NotificationPanel_Table.setModel(model);
        ocultarColumnaVeterinario();
    }

    private void cargarTodasLasCitas() {
        CitaDAO dao = new CitaDAO();
        DefaultTableModel model = (DefaultTableModel) NotificationPanel_Table.getModel();
        List<Cita> citas = dao.listarCitasPorClinicaAndFecha(logUser.getId_clinic());
        model.setRowCount(0);

        for (Cita cita : citas) {
            model.addRow(new Object[]{
                cita.getIdCita(),
                cita.getNombreCliente(),
                cita.getNombreMascota(),
                cita.getNombreVeterinario(),
                cita.getFechaSeparada(),     // yyyy-MM-dd
                cita.getHoraSeparada(),      // HH:mm
                cita.getEstado(),
                cita.getIdVeterinario()
            });
        }
        ocultarColumnaVeterinario();
    }     
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NotificationPanel = new javax.swing.JPanel();
        Up_NotificationPanel = new javax.swing.JPanel();
        NotificationPanel_lblTittle = new javax.swing.JLabel();
        Down_NotificationPanel = new javax.swing.JPanel();
        NotificationPanel_ImgVetSys = new javax.swing.JLabel();
        NotificationPanel_ScrollPanel = new javax.swing.JScrollPane();
        NotificationPanel_Table = new javax.swing.JTable();
        NotificationPanel_BttnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        NotificationPanel.setBackground(new java.awt.Color(255, 255, 255));
        NotificationPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        NotificationPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        NotificationPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        NotificationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Up_NotificationPanel.setBackground(new java.awt.Color(0, 153, 153));
        Up_NotificationPanel.setMaximumSize(new java.awt.Dimension(800, 100));
        Up_NotificationPanel.setMinimumSize(new java.awt.Dimension(800, 100));
        Up_NotificationPanel.setPreferredSize(new java.awt.Dimension(800, 100));

        NotificationPanel_lblTittle.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        NotificationPanel_lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        NotificationPanel_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NotificationPanel_lblTittle.setText("Notificaciones");

        javax.swing.GroupLayout Up_NotificationPanelLayout = new javax.swing.GroupLayout(Up_NotificationPanel);
        Up_NotificationPanel.setLayout(Up_NotificationPanelLayout);
        Up_NotificationPanelLayout.setHorizontalGroup(
            Up_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NotificationPanel_lblTittle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        Up_NotificationPanelLayout.setVerticalGroup(
            Up_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NotificationPanel_lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        NotificationPanel.add(Up_NotificationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Down_NotificationPanel.setBackground(new java.awt.Color(255, 255, 255));
        Down_NotificationPanel.setMaximumSize(new java.awt.Dimension(800, 500));
        Down_NotificationPanel.setMinimumSize(new java.awt.Dimension(800, 500));
        Down_NotificationPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        NotificationPanel_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        NotificationPanel_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        NotificationPanel_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NotificationPanel_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N
        NotificationPanel_ImgVetSys.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        NotificationPanel_ScrollPanel.setViewportView(NotificationPanel_Table);

        NotificationPanel_BttnBack.setBackground(new java.awt.Color(0, 153, 153));
        NotificationPanel_BttnBack.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        NotificationPanel_BttnBack.setForeground(new java.awt.Color(255, 255, 255));
        NotificationPanel_BttnBack.setText("Regresar");
        NotificationPanel_BttnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NotificationPanel_BttnBack.setFocusPainted(false);
        NotificationPanel_BttnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NotificationPanel_BttnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NotificationPanel_BttnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NotificationPanel_BttnBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Down_NotificationPanelLayout = new javax.swing.GroupLayout(Down_NotificationPanel);
        Down_NotificationPanel.setLayout(Down_NotificationPanelLayout);
        Down_NotificationPanelLayout.setHorizontalGroup(
            Down_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Down_NotificationPanelLayout.createSequentialGroup()
                .addComponent(NotificationPanel_ImgVetSys, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Down_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Down_NotificationPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NotificationPanel_ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
                    .addGroup(Down_NotificationPanelLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(NotificationPanel_BttnBack)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        Down_NotificationPanelLayout.setVerticalGroup(
            Down_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NotificationPanel_ImgVetSys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Down_NotificationPanelLayout.createSequentialGroup()
                .addComponent(NotificationPanel_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NotificationPanel_BttnBack)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        NotificationPanel.add(Down_NotificationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NotificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NotificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NotificationPanel_BttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationPanel_BttnBackMouseClicked
        MenuManager menuManager = new MenuManager(logUser);
        menuManager.setVisible(true);
        menuManager.pack();
        menuManager.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_NotificationPanel_BttnBackMouseClicked

    private void NotificationPanel_BttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationPanel_BttnBackMouseEntered
        NotificationPanel_BttnBack.setBackground(Color.LIGHT_GRAY);
        NotificationPanel_BttnBack.setForeground(Color.BLACK);
    }//GEN-LAST:event_NotificationPanel_BttnBackMouseEntered

    private void NotificationPanel_BttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationPanel_BttnBackMouseExited
        NotificationPanel_BttnBack.setBackground(new Color(0,153,153));
        NotificationPanel_BttnBack.setForeground(Color.WHITE);
    }//GEN-LAST:event_NotificationPanel_BttnBackMouseExited

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new NotificationPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Down_NotificationPanel;
    private javax.swing.JPanel NotificationPanel;
    private javax.swing.JButton NotificationPanel_BttnBack;
    private javax.swing.JLabel NotificationPanel_ImgVetSys;
    private javax.swing.JScrollPane NotificationPanel_ScrollPanel;
    private javax.swing.JTable NotificationPanel_Table;
    private javax.swing.JLabel NotificationPanel_lblTittle;
    private javax.swing.JPanel Up_NotificationPanel;
    // End of variables declaration//GEN-END:variables
}
