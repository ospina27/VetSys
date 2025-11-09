/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.view;

/**
 *
 * @author User
 */

import javax.swing.JComboBox;
import java.util.List;

///Metodo para crear combobox en las vistas
public class ComboBox {
    
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
}
