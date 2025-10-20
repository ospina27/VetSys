package project.vetsys.view;

import project.vetsys.utils.AccessPanel;
import project.vetsys.utils.PlaceHoldersAction;
import project.vetsys.utils.permissions.AuthenticationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class LogInPanel implements AccessPanel {


    private JPanel LogInPanelMain;
    private JLabel LogInPanel_lblTitle;
    private JButton LogInPanel_BttnEnter;
    private JPasswordField LogInPanel_PasswordField;
    private JTextField LogInPanel_UsernameField;

    public LogInPanel(){
        this.LogInPanel_UsernameField
                .addFocusListener(new PlaceHoldersAction(LogInPanel_UsernameField, "Usuario"));
        this.LogInPanel_PasswordField
                .addFocusListener(new PlaceHoldersAction(LogInPanel_PasswordField, "Contraseña"));
        this.LogInPanel_BttnEnter.addActionListener(e -> authAction());


        Action enterAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                authAction();
            }
        };
        InputMap inputMap = LogInPanelMain.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = LogInPanelMain.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "EnterCap");
        actionMap.put("EnterCap", enterAction);
    }

    private void authAction(){
        try{
            AuthenticationService authenticationService = new AuthenticationService();
            String rol = authenticationService.authenticate(LogInPanel_UsernameField.getText(), LogInPanel_PasswordField.getText());
            this.LogInPanel_UsernameField.setText("Usuario");
            this.LogInPanel_PasswordField.setText("Contraseña");
            switch(rol){
                case "admin" -> AccessPanel.changeContent("Welcome");
                case "asistente" -> AccessPanel.changeContent("Welcome");
                case "veterinario" -> AccessPanel.changeContent("Welcome");
                default ->  JOptionPane.showMessageDialog(null,
                        "Usuario o contraseña invalidos, intente nuevamente",
                        "Error al autenticar",
                        JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException | NullPointerException e ) {
            JOptionPane.showMessageDialog(null,
                    "Algo ha ido mal! verifica que los campos hayan sido rellenados correctamente solo se aceptan" +
                            " letras, espacios y numeros",
                    "Error al autenticar",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public JPanel getPanel() {
        return LogInPanelMain;
    }
}
