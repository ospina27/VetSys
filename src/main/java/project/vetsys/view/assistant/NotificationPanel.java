package project.vetsys.view.assistant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import project.vetsys.dao.CitaDAO;
import project.vetsys.model.Cita;
import project.vetsys.model.User;
import project.vetsys.view.Nimbus;
import project.vetsys.view.manager.MenuManager;

public class NotificationPanel extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NotificationPanel.class.getName());
    private User logUser;

    
    public NotificationPanel() {
        initComponents();
    }
        
    public NotificationPanel(User logUser){
        Nimbus.LookandFeel();
        initComponents();
        this.logUser = logUser;
        setTitle("Citas programadas - "+ logUser.getClinic().getName_clinic());
        verificarAlertasHoy();
    }  
    
    
    private void verificarAlertasHoy() {
        CitaDAO citaDAO = new CitaDAO();
        jScrollPaneNotifications.setViewportView(Down_NotificationPanel);
        Down_NotificationPanel.setLayout(new BoxLayout(Down_NotificationPanel, BoxLayout.Y_AXIS));

        List<Cita> citas = citaDAO.obtenerCitasProgramadas(logUser.getId_clinic());
        if (!citas.isEmpty()) {
            mostrarAlertasDeCitas(citas);
        } else {
            agregarMensajeSinAlertas();
        }
    }
    
    private void agregarMensajeSinAlertas() {
        JLabel label = new JLabel("No hay citas programadas para mañana.");
        label.setFont(new Font("Arial black", Font.PLAIN, 16));
        Down_NotificationPanel.add(label);
        Down_NotificationPanel.revalidate();
    }

    private void mostrarAlertasDeCitas(List<Cita> citasHoy) {

        for (Cita c : citasHoy) {
            JPanel card = crearTarjeta(c);
            Down_NotificationPanel.add(card);
        }
        Down_NotificationPanel.revalidate();
    }
    
    
    private JPanel crearTarjeta(Cita c) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        card.setBackground(new Color(240, 248, 255));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblMascota = new JLabel("Mascota: " + c.getNombreMascota());
        JLabel lblCliente = new JLabel("Cliente: " + c.getNombreCliente());
        JLabel lblTelefonoCliente = new JLabel("Telefono: " + c.getTelefonoCliente());
        JLabel lblVet = new JLabel("Veterinario: " + c.getNombreVeterinario());
        JLabel lblFecha = new JLabel("Fecha: " + c.getFechaSeparada());
        JLabel lblHora = new JLabel("Hora: " + c.getHoraSeparada());

        lblMascota.setFont(new Font("Arial", Font.BOLD, 16));

        card.add(lblMascota);
        card.add(lblCliente);
        card.add(lblTelefonoCliente);
        card.add(lblVet);
        card.add(lblHora);
        card.add(lblFecha);

        return card;
    }
    
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NotificationPanel = new javax.swing.JPanel();
        Up_NotificationPanel = new javax.swing.JPanel();
        NotificationPanel_ImgVetSys = new javax.swing.JLabel();
        CreatePet_lblSubTittle1 = new javax.swing.JLabel();
        jScrollPaneNotifications = new javax.swing.JScrollPane();
        Down_NotificationPanel = new javax.swing.JPanel();
        NotificationPanel_BttnBack = new javax.swing.JButton();
        CreatePet_lblSubTittle2 = new javax.swing.JLabel();
        CreatePet_lblSubTittle3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        NotificationPanel_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        NotificationPanel_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        NotificationPanel_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NotificationPanel_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N
        NotificationPanel_ImgVetSys.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        CreatePet_lblSubTittle1.setBackground(new java.awt.Color(255, 255, 255));
        CreatePet_lblSubTittle1.setFont(new java.awt.Font("Arial Black", 1, 26)); // NOI18N
        CreatePet_lblSubTittle1.setForeground(new java.awt.Color(255, 255, 255));
        CreatePet_lblSubTittle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreatePet_lblSubTittle1.setText("Citas programadas para mañana");

        javax.swing.GroupLayout Up_NotificationPanelLayout = new javax.swing.GroupLayout(Up_NotificationPanel);
        Up_NotificationPanel.setLayout(Up_NotificationPanelLayout);
        Up_NotificationPanelLayout.setHorizontalGroup(
            Up_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Up_NotificationPanelLayout.createSequentialGroup()
                .addComponent(NotificationPanel_ImgVetSys, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreatePet_lblSubTittle1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        Up_NotificationPanelLayout.setVerticalGroup(
            Up_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Up_NotificationPanelLayout.createSequentialGroup()
                .addGroup(Up_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NotificationPanel_ImgVetSys, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePet_lblSubTittle1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        NotificationPanel.add(Up_NotificationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPaneNotifications.setBackground(new java.awt.Color(255, 255, 255));

        Down_NotificationPanel.setBackground(new java.awt.Color(255, 255, 255));
        Down_NotificationPanel.setMaximumSize(new java.awt.Dimension(800, 500));
        Down_NotificationPanel.setMinimumSize(new java.awt.Dimension(800, 500));
        Down_NotificationPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        javax.swing.GroupLayout Down_NotificationPanelLayout = new javax.swing.GroupLayout(Down_NotificationPanel);
        Down_NotificationPanel.setLayout(Down_NotificationPanelLayout);
        Down_NotificationPanelLayout.setHorizontalGroup(
            Down_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        Down_NotificationPanelLayout.setVerticalGroup(
            Down_NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jScrollPaneNotifications.setViewportView(Down_NotificationPanel);

        NotificationPanel.add(jScrollPaneNotifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 120, 780, 350));

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
        NotificationPanel.add(NotificationPanel_BttnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, -1, -1));

        CreatePet_lblSubTittle2.setBackground(new java.awt.Color(255, 255, 255));
        CreatePet_lblSubTittle2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_lblSubTittle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CreatePet_lblSubTittle2.setText("Se recomienda contactar al cliente");
        NotificationPanel.add(CreatePet_lblSubTittle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 503, 300, -1));

        CreatePet_lblSubTittle3.setBackground(new java.awt.Color(255, 255, 255));
        CreatePet_lblSubTittle3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CreatePet_lblSubTittle3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CreatePet_lblSubTittle3.setText("y recordar la cita programada de su mascota.");
        NotificationPanel.add(CreatePet_lblSubTittle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 300, 20));

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

    private void NotificationPanel_BttnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationPanel_BttnBackMouseExited
        NotificationPanel_BttnBack.setBackground(new Color(0,153,153));
        NotificationPanel_BttnBack.setForeground(Color.WHITE);
    }//GEN-LAST:event_NotificationPanel_BttnBackMouseExited

    private void NotificationPanel_BttnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationPanel_BttnBackMouseEntered
        NotificationPanel_BttnBack.setBackground(Color.LIGHT_GRAY);
        NotificationPanel_BttnBack.setForeground(Color.BLACK);
    }//GEN-LAST:event_NotificationPanel_BttnBackMouseEntered

    private void NotificationPanel_BttnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationPanel_BttnBackMouseClicked
        MenuManager menuManager = new MenuManager(logUser);
        menuManager.setVisible(true);
        menuManager.pack();
        menuManager.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_NotificationPanel_BttnBackMouseClicked

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new NotificationPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreatePet_lblSubTittle1;
    private javax.swing.JLabel CreatePet_lblSubTittle2;
    private javax.swing.JLabel CreatePet_lblSubTittle3;
    private javax.swing.JPanel Down_NotificationPanel;
    private javax.swing.JPanel NotificationPanel;
    private javax.swing.JButton NotificationPanel_BttnBack;
    private javax.swing.JLabel NotificationPanel_ImgVetSys;
    private javax.swing.JPanel Up_NotificationPanel;
    private javax.swing.JScrollPane jScrollPaneNotifications;
    // End of variables declaration//GEN-END:variables
}
