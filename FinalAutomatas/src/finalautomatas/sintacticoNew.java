package finalautomatas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JTextArea;

public class sintacticoNew {
     
    JTextArea txtEntrada;
    JTextArea txtLexico, txtSintactico, txtError;
  
    public sintacticoNew() {
        txtEntrada = Sintactico.txtEntrada;
        txtLexico = Sintactico.txtLexico;
        txtSintactico = Sintactico.txtSintactico;
        txtError = Sintactico.txtError;
    }
     
    //DEFINICIONES
    public String cadena ;
    char[] CA;
    int i, temp;
    int columna, estado;
    String conca = "";
    String mensaje;
     
    public void Analizar(String cadena) {
        cadena= txtEntrada.getText();
        CA = cadena.toCharArray();
        i = 0;
        while (i < cadena.length()) {
            temp = i;
           // columna = Relaciona(CA[i]);
            conca = conca + CA[i];

            if (estado < 99) {

            }
            
            i++;
        }
    }

}
