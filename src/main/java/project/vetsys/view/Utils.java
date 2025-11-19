package project.vetsys.view;

import java.awt.Component;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
    
    
    
    
}
