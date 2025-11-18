
package project.vetsys.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
        
public class Nimbus {
    
    public static void LookandFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("No se pudo aplicar el estilo Nimbus: " + e.getMessage());
        }
    }
       
    
    ///estilo para las tablas
    public static void styleTable(JTable table) {
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setForeground(Color.BLACK);
        table.setBackground(Color.WHITE);
        table.setSelectionBackground(new Color(57, 105, 172));
        table.setSelectionForeground(Color.LIGHT_GRAY);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setBorder(BorderFactory.createEmptyBorder());
        table.setFocusable(false);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(235, 235, 235));
        header.setForeground(new Color(50, 50, 50));
        header.setReorderingAllowed(false);
        header.setOpaque(true);
        header.setBorder(BorderFactory.createEmptyBorder());

        ///Estilo zebra (filas alternadas)
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus,
                    int row, int column) 
            {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(250, 250, 250) : Color.WHITE);
                }
                setHorizontalAlignment(LEFT);
                setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); 
                return c;
            }
        });
        
        if (table.getParent() != null && table.getParent().getParent() instanceof JScrollPane scrollPane)
            {
            scrollPane.getViewport().setBackground(Color.WHITE);
            scrollPane.setBackground(Color.WHITE);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
        }
        
        resizeColumnWidths(table);
        
    }
    
     ///aplicar el estilo para todos los texfield en la vista
    public static void styleAllTextFields(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextField) 
            {
                styleTextField((JTextField) comp);
            } else if (comp instanceof Container) 
            {
                styleAllTextFields((Container) comp);
            }
        }
    }  
    
    
    
    ///estilo para los text field
    public static void styleTextField(JTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 12)); //fuente
        textField.setPreferredSize(new Dimension(160, 30)); 
        textField.setBackground(new Color(250, 250, 250)); ///fondo suave 
        textField.setForeground(new Color(32, 32, 32)); ///color del texto 
        textField.setCaretColor(new Color(0, 120, 215)); // color del cursor
        textField.setBorder(BorderFactory.createCompoundBorder(  ///bordes 
        BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true),
        BorderFactory.createEmptyBorder(6, 10, 6, 10)));
        ///color de seleccion
        textField.setSelectionColor(new Color(0, 120, 215, 60));
        textField.setSelectedTextColor(new Color(20, 20, 20));
        ///efecto windows 11
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215), 2, true), ///azul windows
                BorderFactory.createEmptyBorder(5, 9, 5, 9)
            ));
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
            ));
        }
    });
    }
    

    
    
    ///organizar las tablas
   private static void resizeColumnWidths(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++)
        {
            int width = 70; // ancho mínimo
            for (int row = 0; row < table.getRowCount(); row++) 
            {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 10, width);
            }
            if (width > 300) width = 300; // ancho máximo por columna (ajústalo si quieres)
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
 
   
   
   ///metodos para los labels 
   public static void styleLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 12));      /// Fuente
        label.setForeground(new Color(30,30,30));              
        label.setOpaque(false);                                   /// Fondo transparente
        label.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        label.setVerticalAlignment(SwingConstants.CENTER);
    }
   
   public static void styleTitleLabel(JLabel label) {
    label.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
    label.setForeground(new Color(245, 245, 245));
    label.setOpaque(false);
}
   

    public static void styleAllLabelsExcept(Container container, JLabel exception) {
        for (Component comp : container.getComponents()) {

            if (comp instanceof JLabel && comp != exception) {
                styleLabel((JLabel) comp);
            }

            if (comp instanceof Container) {
                styleAllLabelsExcept((Container) comp, exception);
            }
        }
    }
   
   


}
