/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package project.vetsys;

import project.vetsys.utils.AccessPanel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;


public class VetSys {

    public static void main(String[] args) {
        Enumeration<Object> UIkeys = UIManager.getDefaults().keys();
        FontUIResource f = new FontUIResource(new Font("Arial", Font.PLAIN, 14));
        while (UIkeys.hasMoreElements()) {
            Object key = UIkeys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
        AccessPanel.changeContent("Welcome");
    }
}
