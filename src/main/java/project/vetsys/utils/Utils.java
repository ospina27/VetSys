package project.vetsys.utils;

import java.awt.Component;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import project.vetsys.model.User;

public class Utils {
    
    ///metodo para llenar los combobox
    public static <T> void fillComboBox(JComboBox<T> comboBox, List<T> items, T defaultItem) {
        comboBox.removeAllItems();
        if (defaultItem != null) {
            comboBox.addItem(defaultItem);
        }

        if (items != null && !items.isEmpty()) {
            for (T item : items) {
                if (item != null) {
                    comboBox.addItem(item);
                }
            }
        }
    }
    
    /// cuadro de validación, con opcion "si o no"
    public int validation(String message, String title){
        
        int messageResult =  JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(messageResult == JOptionPane.YES_OPTION){
            return 1;    
        }else {
            return 0;
        }   
    }
    
    ///validación para el formato del correo
    public static boolean EmailFormatValid(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        // Patrón estándar y robusto
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean validationEmail(JTextField textField, Component parent, String title) {
        String email = textField.getText().trim();
        // Si el campo no está vacío, se valida el formato
        if (!email.isEmpty() && !EmailFormatValid(email)) {
            JOptionPane.showMessageDialog(parent, 
                    "El formato del correo electrónico no es válido.\nEjemplo: usuario@dominio.com", 
                    title, 
                    JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    
    
    
}
