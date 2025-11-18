package project.vetsys.utils;

import java.util.regex.*;
import javax.swing.*;
import javax.swing.text.*;


public class ValidationInput {
    
    private static void inputFilter(JTextField field, DocumentFilter filter){
        ((AbstractDocument) field.getDocument()).setDocumentFilter(filter);
    }
    
    public static void numbers(JTextField field){
        inputFilter(field, new numbersFilter());
    }
    
    public static void text(JTextField field){
        inputFilter(field, new textFilter());
    }
    
    public static void date(JTextField field){
        inputFilter(field, new dateFilter());
    }
    
    public static class numbersFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if(string.matches("\\d+"))
                super.insertString(fb, offset, string, attr);
        }
        
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("\\d+"))
                super.replace(fb, offset, length, text, attrs);
        }
    }
    
    public static class textFilter extends DocumentFilter {
        private final Pattern pattern = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attr)
                throws BadLocationException {

            if (pattern.matcher(text).matches())
                super.replace(fb, offset, length, text, attr);
        }
    }
    
    public static class dateFilter extends DocumentFilter {
        private final String regex = "[0-9/]*";

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {

            String actual = fb.getDocument().getText(0, fb.getDocument().getLength());
            String nuevo = actual.substring(0, offset) + text + actual.substring(offset + length);

            if (nuevo.matches(regex) && nuevo.length() <= 10)
                super.replace(fb, offset, length, text, attrs);
        }
    }
    
}
