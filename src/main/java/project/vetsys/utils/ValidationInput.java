package project.vetsys.utils;

import java.util.regex.*;
import javax.swing.*;
import javax.swing.text.*;


public class ValidationInput {
    
    // -------------------------
    // PATRONES PREDEFINIDOS
    // -------------------------
    public static final String EMAIL =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static final String CEDULA =
            "^[0-9]{6,12}$";

    public static final String TELEFONO =
            "^[0-9]{7,10}$";
    
    // Opcion para capturar fechas
     public static final String FECHA =
            "^\\d{4}-\\d{2}-\\d{2}$";
     
    
    private static void inputFilter(JTextField field, DocumentFilter filter){
        ((AbstractDocument) field.getDocument()).setDocumentFilter(filter);
    }
    
    
    public static void maxLength(JTextField field, int max){
        inputFilter(field, new maxLength(max));
    }
    
    public static void numbers(JTextField field){
        inputFilter(field, new numbersFilter(-1));
    }
    
    public static void numbers(JTextField field, int max){
        inputFilter(field, new numbersFilter(max));
    }
    
    public static void text(JTextField field){
        inputFilter(field, new textFilter(-1));
    }
    
    public static void text(JTextField field, int max){
        inputFilter(field, new textFilter(max));
    }
    // FECHA (DD/MM/AAAA) + LIMITE AUTOMÁTICO 10
    public static void date(JTextField field){
        inputFilter(field, new dateFilter());
    }
    
    public static void regex(JTextField field, String regex, int max){
        inputFilter(field, new regexFilter(regex, max));
    }
    
    
    public static class maxLength extends DocumentFilter {

        private final int max;

        public maxLength(int max){
            this.max = max;
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if(text == null) return;

            int current = fb.getDocument().getLength();
            int newLength = current - length + text.length();

            if(newLength <= max){
                super.replace(fb, offset, length, text, attrs);
            }
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
            if(text == null) return;

            int current = fb.getDocument().getLength();
            if(current + text.length() <= max){
                super.insertString(fb, offset, text, attrs);
            }
        }
    }
    
    public static class numbersFilter extends DocumentFilter {
        
        private final int max;
        
        public numbersFilter(int max){
            this.max = max;
        }
        
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            ///condicion adicional para que se identifiquen los campos vacíos o nulos
            ///esto para que se puedan limpiar los campos cuando se requiera
            ///se agregan tambien en los otros metodos de valicación
            // if(string == null || string.isEmpty()|| string.matches("\\d+"))
            //    super.insertString(fb, offset, string, attr);
            if(string == null || !string.matches("\\d*")) return;

            if(max > 0 && fb.getDocument().getLength() + string.length() > max) return;

            super.insertString(fb, offset, string, attr);
        }
        
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            //if (text == null|| text.isEmpty() || text.matches("\\d+"))
            //    super.replace(fb, offset, length, text, attrs);
            if(text != null && !text.matches("\\d*")) return;

            if(max > 0){
                int current = fb.getDocument().getLength();
                int newLength = current - length + (text == null ? 0 : text.length());
                if(newLength > max) return;
            }

            super.replace(fb, offset, length, text, attrs);
            
        }
    }
    
    public static class textFilter extends DocumentFilter {
        private final Pattern pattern = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
        
        private final int max;
        
        public textFilter(int max){
            this.max = max;
        }
        

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attr)
                throws BadLocationException {
            
            //if (text == null || text.isEmpty() || pattern.matcher(text).matches())
            //    super.replace(fb, offset, length, text, attr);
            
             if(text != null && !pattern.matcher(text).matches()) return;

            if(max > 0){
                int current = fb.getDocument().getLength();
                int newLength = current - length + (text == null ? 0 : text.length());
                if(newLength > max) return;
            }

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

            if (nuevo.matches(regex) && nuevo.length() <= 10 || nuevo.isEmpty())
                super.replace(fb, offset, length, text, attrs);
        }
    }
    
    
    // ------ Patrón Regex ------
    public static class regexFilter extends DocumentFilter {
        private final Pattern pattern;
        private final int max;

        public regexFilter(String regex, int max){
            this.pattern = Pattern.compile(regex);
            this.max = max;
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attr)
                throws BadLocationException {

            String actual = fb.getDocument().getText(0, fb.getDocument().getLength());
            String nuevo = actual.substring(0, offset) + text + actual.substring(offset + length);

            if(max > 0 && nuevo.length() > max) return;
            if(!nuevo.isEmpty() && !pattern.matcher(nuevo).matches()) return;

            super.replace(fb, offset, length, text, attr);
        }
    }
}
