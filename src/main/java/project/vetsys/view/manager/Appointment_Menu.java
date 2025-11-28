package project.vetsys.view.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import project.vetsys.model.User;
import project.vetsys.utils.BarGraph;
import project.vetsys.view.assistant.AttendAppointment;
import project.vetsys.view.assistant.ScheduleAppointment;
import project.vetsys.view.assistant.SearchAppointment;
import project.vetsys.view.assistant.SearchHistory;


public class Appointment_Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Appointment_Menu.class.getName());
    private User logUser;
    
    

    public Appointment_Menu() {
        initComponents();
    }
       
    public Appointment_Menu(User logUser){
        initComponents();
        this.logUser = logUser;
        aplicarPermisosPorRol();
           if(!"Administrador".equalsIgnoreCase(logUser.getName_role())){
                MenuAppointment_Reports.setVisible(false);
            }
            setTitle("Gestión de Citas "+logUser.getClinic().getName_clinic());
    }
    
    
    private void aplicarPermisosPorRol() {

        if (logUser == null) return;

        String rol = logUser.getName_role();

        if (rol.equalsIgnoreCase("Veterinario")) {
            MenuAppointment_BttnScheduleAppointment.setVisible(false);
            MenuAppointment_BttnSearchAppointment.setVisible(false);
            btnAtenderCita.setVisible(true);
            btnConsultarHistorial.setVisible(true);

        } else if (rol.equalsIgnoreCase("Asistente")) {
            btnAtenderCita.setVisible(false);
            btnConsultarHistorial.setVisible(true);
            MenuAppointment_BttnScheduleAppointment.setVisible(true);
            MenuAppointment_BttnSearchAppointment.setVisible(true);

        } else {
            btnAtenderCita.setVisible(true);
            btnConsultarHistorial.setVisible(true);
            MenuAppointment_BttnScheduleAppointment.setVisible(true);
            MenuAppointment_BttnSearchAppointment.setVisible(true);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_AppointmentPanel = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        MenuAppointment_ImgVetSys = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        MenuAppointment_BttnScheduleAppointment = new javax.swing.JButton();
        MenuAppointment_BttnSearchAppointment = new javax.swing.JButton();
        MenuAppointment_BttnBacks = new javax.swing.JButton();
        MenuAppointment_Reports = new javax.swing.JButton();
        btnAtenderCita = new javax.swing.JButton();
        btnConsultarHistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Appointment_Menu");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        Menu_AppointmentPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        Menu_AppointmentPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        Menu_AppointmentPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        Menu_AppointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Left.setBackground(new java.awt.Color(0, 153, 153));
        Left.setMaximumSize(new java.awt.Dimension(400, 600));
        Left.setMinimumSize(new java.awt.Dimension(400, 600));
        Left.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuAppointment_ImgVetSys.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        MenuAppointment_ImgVetSys.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_ImgVetSys.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAppointment_ImgVetSys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vetSysBg.png"))); // NOI18N

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addComponent(MenuAppointment_ImgVetSys, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAppointment_ImgVetSys, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        Menu_AppointmentPanel.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, -1));
        Left.getAccessibleContext().setAccessibleName("");

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setMaximumSize(new java.awt.Dimension(400, 600));
        Right.setMinimumSize(new java.awt.Dimension(400, 600));
        Right.setPreferredSize(new java.awt.Dimension(400, 600));

        MenuAppointment_BttnScheduleAppointment.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_BttnScheduleAppointment.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuAppointment_BttnScheduleAppointment.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_BttnScheduleAppointment.setText("Agendar Cita");
        MenuAppointment_BttnScheduleAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAppointment_BttnScheduleAppointment.setFocusPainted(false);
        MenuAppointment_BttnScheduleAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnScheduleAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnScheduleAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnScheduleAppointmentMouseExited(evt);
            }
        });

        MenuAppointment_BttnSearchAppointment.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_BttnSearchAppointment.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuAppointment_BttnSearchAppointment.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_BttnSearchAppointment.setText("Consultar Cita");
        MenuAppointment_BttnSearchAppointment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAppointment_BttnSearchAppointment.setFocusPainted(false);
        MenuAppointment_BttnSearchAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnSearchAppointmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnSearchAppointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnSearchAppointmentMouseExited(evt);
            }
        });

        MenuAppointment_BttnBacks.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_BttnBacks.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        MenuAppointment_BttnBacks.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_BttnBacks.setText("Regresar");
        MenuAppointment_BttnBacks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAppointment_BttnBacks.setFocusPainted(false);
        MenuAppointment_BttnBacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnBacksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnBacksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_BttnBacksMouseExited(evt);
            }
        });

        MenuAppointment_Reports.setBackground(new java.awt.Color(0, 153, 153));
        MenuAppointment_Reports.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        MenuAppointment_Reports.setForeground(new java.awt.Color(255, 255, 255));
        MenuAppointment_Reports.setText("Reportes");
        MenuAppointment_Reports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuAppointment_Reports.setFocusPainted(false);
        MenuAppointment_Reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAppointment_ReportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAppointment_ReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuAppointment_ReportsMouseExited(evt);
            }
        });

        btnAtenderCita.setBackground(new java.awt.Color(0, 153, 153));
        btnAtenderCita.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnAtenderCita.setForeground(new java.awt.Color(255, 255, 255));
        btnAtenderCita.setText("Atender Cita");
        btnAtenderCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtenderCita.setFocusPainted(false);
        btnAtenderCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtenderCitaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtenderCitaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtenderCitaMouseExited(evt);
            }
        });
        btnAtenderCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderCitaActionPerformed(evt);
            }
        });

        btnConsultarHistorial.setBackground(new java.awt.Color(0, 153, 153));
        btnConsultarHistorial.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnConsultarHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarHistorial.setText("Historial Clinico");
        btnConsultarHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarHistorial.setFocusPainted(false);
        btnConsultarHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarHistorialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultarHistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultarHistorialMouseExited(evt);
            }
        });
        btnConsultarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtenderCita, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultarHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuAppointment_BttnScheduleAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuAppointment_BttnSearchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuAppointment_Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(MenuAppointment_BttnBacks)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(MenuAppointment_BttnScheduleAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(MenuAppointment_BttnSearchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(MenuAppointment_Reports, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnConsultarHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnAtenderCita, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(MenuAppointment_BttnBacks, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        Menu_AppointmentPanel.add(Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 450, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu_AppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu_AppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAppointment_BttnScheduleAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnScheduleAppointmentMouseClicked
        ScheduleAppointment ScheduleAppointmentFrame = new ScheduleAppointment(logUser);
        ScheduleAppointmentFrame.setVisible(true);
        ScheduleAppointmentFrame.pack();
        ScheduleAppointmentFrame.setLocationRelativeTo(null);
            this.dispose();
    }//GEN-LAST:event_MenuAppointment_BttnScheduleAppointmentMouseClicked

    private void MenuAppointment_BttnScheduleAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnScheduleAppointmentMouseEntered
        MenuAppointment_BttnScheduleAppointment.setBackground(Color.LIGHT_GRAY);
        MenuAppointment_BttnScheduleAppointment.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuAppointment_BttnScheduleAppointmentMouseEntered

    private void MenuAppointment_BttnScheduleAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnScheduleAppointmentMouseExited
        MenuAppointment_BttnScheduleAppointment.setBackground(new Color(0,153,153));
        MenuAppointment_BttnScheduleAppointment.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuAppointment_BttnScheduleAppointmentMouseExited

    private void MenuAppointment_BttnSearchAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnSearchAppointmentMouseClicked
        SearchAppointment SearchAppointment = new SearchAppointment(logUser);
        SearchAppointment.setVisible(true);
        SearchAppointment.pack();
        SearchAppointment.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuAppointment_BttnSearchAppointmentMouseClicked

    private void MenuAppointment_BttnSearchAppointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnSearchAppointmentMouseEntered
        MenuAppointment_BttnSearchAppointment.setBackground(Color.LIGHT_GRAY);
        MenuAppointment_BttnSearchAppointment.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuAppointment_BttnSearchAppointmentMouseEntered

    private void MenuAppointment_BttnSearchAppointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnSearchAppointmentMouseExited
        MenuAppointment_BttnSearchAppointment.setBackground(new Color(0,153,153));
        MenuAppointment_BttnSearchAppointment.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuAppointment_BttnSearchAppointmentMouseExited

    private void MenuAppointment_BttnBacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnBacksMouseClicked
        MenuManager menuManager = new MenuManager(logUser);
        menuManager.setVisible(true);
        menuManager.pack();
        menuManager.setLocationRelativeTo(null);
         this.dispose();
    }//GEN-LAST:event_MenuAppointment_BttnBacksMouseClicked

    private void MenuAppointment_BttnBacksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnBacksMouseEntered
        MenuAppointment_BttnBacks.setBackground(Color.LIGHT_GRAY);
        MenuAppointment_BttnBacks.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuAppointment_BttnBacksMouseEntered

    private void MenuAppointment_BttnBacksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_BttnBacksMouseExited
        MenuAppointment_BttnBacks.setBackground(new Color(0,153,153));
        MenuAppointment_BttnBacks.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuAppointment_BttnBacksMouseExited

    private void MenuAppointment_ReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_ReportsMouseClicked
        if (logUser != null) {
                ///Definir las opciones de reportes disponibles
                String[] options = {
                    "Citas por Veterinario", 
                    "Estado de Citas", 
                    "Horarios más frecuentes", 
                    "Retención de Clientes",
                    "Demografía de Pacientes",
                    "Distribución de Membresías",
                    "Tendencia en Citas",
                    "Top de Clientes"
                };

              ///definir un dialogo para preguntar que grafico desea ver
            String selection = (String) JOptionPane.showInputDialog(
                null, 
                "Seleccione el tipo de reporte que desea visualizar:", 
                "Generador de Reportes", 
                javax.swing.JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            if (selection != null) {
                org.jfree.chart.ChartPanel chartPanel = null;

                ///Generar el panel según la opción
                switch (selection) {
                    case "Citas por Veterinario":
                        chartPanel = project.vetsys.utils.BarGraph.getChartPanel(logUser.getId_clinic());
                        break;
                    case "Estado de Citas":
                        chartPanel = project.vetsys.utils.BarGraph.createReport(1, logUser.getId_clinic());
                        break;
                    case "Horarios más frecuentes":
                        chartPanel = project.vetsys.utils.BarGraph.createReport(2, logUser.getId_clinic());
                        break;
                    case "Retención de Clientes":
                        chartPanel = project.vetsys.utils.BarGraph.createReport(3, logUser.getId_clinic());
                        break;
                    case "Demografía de Pacientes":
                        chartPanel = project.vetsys.utils.BarGraph.createReport(4, logUser.getId_clinic());
                        break;
                    case "Distribución de Membresías":
                        chartPanel = project.vetsys.utils.BarGraph.createReport(5, logUser.getId_clinic());
                        break;
                    case "Tendencia en Citas":
                        chartPanel = project.vetsys.utils.BarGraph.createReport(6, logUser.getId_clinic());
                        break;
                    case "Top de Clientes":
                        chartPanel = project.vetsys.utils.BarGraph.createReport(7, logUser.getId_clinic());
                        break;
                }
                ///abrir ventana con el grafico
                if (chartPanel != null) {
                    javax.swing.JFrame ventanaReporte = new javax.swing.JFrame("Reporte: " + selection);
                    ventanaReporte.setContentPane(chartPanel);
                    ventanaReporte.setSize(800, 600);
                    ventanaReporte.setLocationRelativeTo(null);
                    ventanaReporte.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                    ventanaReporte.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_MenuAppointment_ReportsMouseClicked

    private void MenuAppointment_ReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_ReportsMouseEntered
        MenuAppointment_Reports.setBackground(Color.LIGHT_GRAY);
        MenuAppointment_Reports.setForeground(Color.BLACK);
    }//GEN-LAST:event_MenuAppointment_ReportsMouseEntered

    private void MenuAppointment_ReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAppointment_ReportsMouseExited
        MenuAppointment_Reports.setBackground(new Color(0,153,153));
        MenuAppointment_Reports.setForeground(Color.WHITE);
    }//GEN-LAST:event_MenuAppointment_ReportsMouseExited

    private void btnAtenderCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtenderCitaMouseClicked
        AttendAppointment AttendAppointmentFrame = new AttendAppointment(logUser);
        AttendAppointmentFrame.setVisible(true);
        AttendAppointmentFrame.pack();
        AttendAppointmentFrame.setLocationRelativeTo(null);
          this.dispose();
    }//GEN-LAST:event_btnAtenderCitaMouseClicked

    private void btnAtenderCitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtenderCitaMouseEntered
        btnAtenderCita.setBackground(Color.LIGHT_GRAY);
        btnAtenderCita.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAtenderCitaMouseEntered

    private void btnAtenderCitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtenderCitaMouseExited
        btnAtenderCita.setBackground(new Color(0,153,153));
        btnAtenderCita.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnAtenderCitaMouseExited

    private void btnConsultarHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarHistorialMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarHistorialMouseClicked

    private void btnConsultarHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarHistorialMouseEntered
        btnConsultarHistorial.setBackground(Color.LIGHT_GRAY);
        btnConsultarHistorial.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnConsultarHistorialMouseEntered

    private void btnConsultarHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarHistorialMouseExited
        btnConsultarHistorial.setBackground(new Color(0,153,153));
        btnConsultarHistorial.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnConsultarHistorialMouseExited

    private void btnAtenderCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderCitaActionPerformed
       
    }//GEN-LAST:event_btnAtenderCitaActionPerformed

    private void btnConsultarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarHistorialActionPerformed
        SearchHistory Historyframe = new SearchHistory(logUser);
        Historyframe.setVisible(true);
        Historyframe.pack();
        Historyframe.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnConsultarHistorialActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Appointment_Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton MenuAppointment_BttnBacks;
    private javax.swing.JButton MenuAppointment_BttnScheduleAppointment;
    private javax.swing.JButton MenuAppointment_BttnSearchAppointment;
    private javax.swing.JLabel MenuAppointment_ImgVetSys;
    private javax.swing.JButton MenuAppointment_Reports;
    private javax.swing.JPanel Menu_AppointmentPanel;
    private javax.swing.JPanel Right;
    private javax.swing.JButton btnAtenderCita;
    private javax.swing.JButton btnConsultarHistorial;
    // End of variables declaration//GEN-END:variables
}
