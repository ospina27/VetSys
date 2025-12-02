package project.vetsys.view.assistant;

import javax.swing.JDialog;
import project.vetsys.model.HistoriaClinicaDetalle;


public class DetailedHistory extends javax.swing.JDialog {
    
    private HistoriaClinicaDetalle detalle;
    private String emptyIfNull(String s) { return s == null ? "" : s; }


    public DetailedHistory() {
        initComponents();
    }
    
  
    
    public DetailedHistory(java.awt.Frame parent, boolean modal, HistoriaClinicaDetalle detalle) {
        super(parent, modal);
        initComponents();
        this.detalle = detalle;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        cargarDatos();
        
    }

    
    private void cargarDatos() {
                
        lblNombreMascota.setText(emptyIfNull(detalle.getNombreMascota()));
        lblEspecie.setText(emptyIfNull(detalle.getEspecie()));
        lblRaza.setText(emptyIfNull(detalle.getRaza()));
        lblColor.setText(emptyIfNull(detalle.getColor()));
        lblSexo.setText(emptyIfNull(detalle.getSexo()));
        lblPeso.setText(emptyIfNull(detalle.getPeso()));
        lblFechaNacimiento.setText(detalle.getFechaNacimiento() != null ? detalle.getFechaNacimiento().toString() : "");

        lblCliente.setText(emptyIfNull(detalle.getNombreCliente()));
        lblDocumento.setText(emptyIfNull(detalle.getDocumentoCliente()));
        lblTelefono.setText(emptyIfNull(detalle.getTelefonoCliente()));
        lblCorreo.setText(emptyIfNull(detalle.getCorreoCliente()));

        lblFechaR.setText(detalle.getFechaRegistro() != null ? detalle.getFechaRegistro().toString() : "");
        lblNombreVet.setText(emptyIfNull(detalle.getNombreVeterinario()));

        txtAreaMotivo.setText(emptyIfNull(detalle.getMotivo()));
        txtDiagnostico.setText(emptyIfNull(detalle.getDiagnostico()));
        txtAreaTratamiento.setText(emptyIfNull(detalle.getTratamiento()));
        
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        SearchAppointment_lblClientID40 = new javax.swing.JLabel();
        SearchAppointment_lblClientID41 = new javax.swing.JLabel();
        SearchAppointment_lblClientID42 = new javax.swing.JLabel();
        SearchAppointment_lblClientID43 = new javax.swing.JLabel();
        SearchAppointment_lblClientID44 = new javax.swing.JLabel();
        SearchAppointment_lblClientID45 = new javax.swing.JLabel();
        lblNombreMascota = new javax.swing.JLabel();
        lblEspecie = new javax.swing.JLabel();
        lblRaza = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        SearchAppointment_lblClientID46 = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblFechaRegistro = new javax.swing.JLabel();
        lblFechaR = new javax.swing.JLabel();
        lblVet = new javax.swing.JLabel();
        lblNombreVet = new javax.swing.JLabel();
        lblMotivoConsulta = new javax.swing.JLabel();
        lblDiagnostico = new javax.swing.JLabel();
        txtDiagnostico = new javax.swing.JTextField();
        lblTratamiento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMotivo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaTratamiento = new javax.swing.JTextArea();
        ScheduleAppointment_lblTittle = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        SearchAppointment_lblClientID84 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        SearchAppointment_lblClientID86 = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        SearchAppointment_lblClientID88 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        SearchAppointment_lblClientID90 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mascota", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        SearchAppointment_lblClientID40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID40.setText("Nombre:");

        SearchAppointment_lblClientID41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID41.setText("Raza:");

        SearchAppointment_lblClientID42.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID42.setText("Especie:");

        SearchAppointment_lblClientID43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID43.setText("Fecha de nacimiento:");

        SearchAppointment_lblClientID44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID44.setText("Color:");

        SearchAppointment_lblClientID45.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID45.setText("Sexo:");

        lblNombreMascota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombreMascota.setText("Mascota");

        lblEspecie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEspecie.setText("Especie");

        lblRaza.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRaza.setText("Raza");

        lblColor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblColor.setText("Color");

        lblSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSexo.setText("Sexo");

        lblFechaNacimiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFechaNacimiento.setText("Fecha");

        SearchAppointment_lblClientID46.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID46.setText("Peso:");

        lblPeso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPeso.setText("Peso");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombreMascota))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEspecie))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRaza))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblColor)
                        .addGap(29, 29, 29)
                        .addComponent(SearchAppointment_lblClientID45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSexo))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFechaNacimiento))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPeso)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID40)
                    .addComponent(lblNombreMascota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEspecie)
                    .addComponent(SearchAppointment_lblClientID42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID41)
                    .addComponent(lblRaza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID44)
                    .addComponent(lblColor)
                    .addComponent(SearchAppointment_lblClientID45)
                    .addComponent(lblSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID46)
                    .addComponent(lblPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID43)
                    .addComponent(lblFechaNacimiento))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información clínica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        lblFechaRegistro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFechaRegistro.setText("Fecha de registro:");

        lblFechaR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFechaR.setText("Fecha");

        lblVet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblVet.setText("Veterinario:");

        lblNombreVet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombreVet.setText("Veterinario");

        lblMotivoConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMotivoConsulta.setText("Motivo de consulta");

        lblDiagnostico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDiagnostico.setText("Diagnóstico");

        txtDiagnostico.setEditable(false);

        lblTratamiento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTratamiento.setText("Tratamiento");

        txtAreaMotivo.setEditable(false);
        txtAreaMotivo.setColumns(20);
        txtAreaMotivo.setRows(5);
        txtAreaMotivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(txtAreaMotivo);

        txtAreaTratamiento.setEditable(false);
        txtAreaTratamiento.setColumns(20);
        txtAreaTratamiento.setRows(5);
        jScrollPane2.setViewportView(txtAreaTratamiento);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiagnostico)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblFechaRegistro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFechaR))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblVet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombreVet))
                            .addComponent(lblMotivoConsulta)
                            .addComponent(lblTratamiento)
                            .addComponent(lblDiagnostico))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaRegistro)
                    .addComponent(lblFechaR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVet)
                    .addComponent(lblNombreVet))
                .addGap(27, 27, 27)
                .addComponent(lblMotivoConsulta)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDiagnostico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTratamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        ScheduleAppointment_lblTittle.setBackground(new java.awt.Color(255, 255, 255));
        ScheduleAppointment_lblTittle.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        ScheduleAppointment_lblTittle.setForeground(new java.awt.Color(0, 153, 153));
        ScheduleAppointment_lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScheduleAppointment_lblTittle.setText("Detalle Historia Clínica");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        SearchAppointment_lblClientID84.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID84.setText("Nombre:");

        lblCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCliente.setText("Cliente");

        SearchAppointment_lblClientID86.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID86.setText("Documento:");
        SearchAppointment_lblClientID86.setToolTipText("");

        lblDocumento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDocumento.setText("Documento");

        SearchAppointment_lblClientID88.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID88.setText("Teléfono:");
        SearchAppointment_lblClientID88.setToolTipText("");

        lblTelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTelefono.setText("Telefono");

        SearchAppointment_lblClientID90.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchAppointment_lblClientID90.setText("Correo:");
        SearchAppointment_lblClientID90.setToolTipText("");

        lblCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCorreo.setText("Correo");
        lblCorreo.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCliente))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDocumento))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTelefono))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(SearchAppointment_lblClientID90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCorreo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID84)
                    .addComponent(lblCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID86)
                    .addComponent(lblDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID88)
                    .addComponent(lblTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAppointment_lblClientID90)
                    .addComponent(lblCorreo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addComponent(ScheduleAppointment_lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(ScheduleAppointment_lblTittle)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new DetailedHistory().setVisible(true));
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ScheduleAppointment_lblTittle;
    private javax.swing.JLabel SearchAppointment_lblClientID40;
    private javax.swing.JLabel SearchAppointment_lblClientID41;
    private javax.swing.JLabel SearchAppointment_lblClientID42;
    private javax.swing.JLabel SearchAppointment_lblClientID43;
    private javax.swing.JLabel SearchAppointment_lblClientID44;
    private javax.swing.JLabel SearchAppointment_lblClientID45;
    private javax.swing.JLabel SearchAppointment_lblClientID46;
    private javax.swing.JLabel SearchAppointment_lblClientID84;
    private javax.swing.JLabel SearchAppointment_lblClientID86;
    private javax.swing.JLabel SearchAppointment_lblClientID88;
    private javax.swing.JLabel SearchAppointment_lblClientID90;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFechaR;
    private javax.swing.JLabel lblFechaRegistro;
    private javax.swing.JLabel lblMotivoConsulta;
    private javax.swing.JLabel lblNombreMascota;
    private javax.swing.JLabel lblNombreVet;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblRaza;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTratamiento;
    private javax.swing.JLabel lblVet;
    private javax.swing.JTextArea txtAreaMotivo;
    private javax.swing.JTextArea txtAreaTratamiento;
    private javax.swing.JTextField txtDiagnostico;
    // End of variables declaration//GEN-END:variables
}
