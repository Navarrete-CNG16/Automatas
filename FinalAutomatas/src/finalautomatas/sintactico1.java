/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalautomatas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class sintactico1 {

    public int[][] matrizL = {
        //	l	L	N	.	_	"	/	*	{	}	=	<	>	+	-	(	)	[	]	,	;	:	/b	/t	/e      !=
        {1, 1, 3, 14, 500, 5, 6, 13, 9, 500, 10, 11, 12, 113, 114, 118, 119, 120, 121, 122, 124, 125, 0, 0, 0, 505},
        {1, 1, 1, 101, 2, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101},
        {1, 1, 1, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500},
        {103, 103, 3, 4, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103},
        {504, 504, 15, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504, 504},
        {5, 5, 5, 5, 5, 105, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 501, 5},
        {117, 117, 117, 117, 117, 117, 117, 7, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117},
        {7, 7, 7, 7, 7, 7, 7, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 502, 7},
        {8, 8, 8, 8, 8, 8, 106, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 502, 8},
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 127, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 502, 9},
        {107, 107, 107, 107, 107, 107, 107, 107, 107, 107, 108, 107, 107, 107, 107, 107, 107, 107, 107, 107, 107, 107, 107, 107, 107, 107},
        {109, 109, 109, 109, 109, 109, 109, 109, 109, 109, 110, 109, 109, 109, 109, 109, 109, 109, 109, 109, 109, 109, 109, 109, 109, 109},
        {111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 112, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111, 111},
        {115, 115, 115, 115, 115, 115, 115, 116, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115},
        {123, 123, 123, 126, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
        {104, 104, 15, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104}

    };

    JTextArea txtEntrada;
    JTextArea txtLexico, txtSintactico, txtError;
    JTextField txtOP,txtOpe;
    
    public sintactico1() {
        txtEntrada = Sintactico.txtEntrada;
        txtLexico = Sintactico.txtLexico;
        txtSintactico = Sintactico.txtSintactico;
        txtError = Sintactico.txtError;
        txtOP= Sintactico.txtOpe;
        txtOpe= Sintactico.txtOper;
    }

    public String cadena = "";
    char[] cA;
    int i, temp;
    int columna, estado;
    String conca = "";
    String mensaje;
    char[] ae = {89, 101, 78};
    String string = String.valueOf(ae);
    ArrayList<String> palres = new ArrayList<String>();
    ArrayList<String> comentarios = new ArrayList<String>();

    public void Analizar(String cadena) {
        cA = cadena.toCharArray();
        i = 0;
        while (i < cadena.length()) {
            temp = i;
            columna = Relaciona(cA[i]);
            conca = conca + cA[i];

            if (estado < 99) {

                estado = matrizL[estado][columna];

                if ((estado >= 100) && (estado <= 200)) {

                    mensaje = "";
                    Token(estado);
                    txtLexico.setText(txtLexico.getText() + mensaje + "\n");
                    estado = 0;
                    conca = "";

                } else if (estado >= 500) {
                    mensaje = "";
                    Error(estado);
                    txtLexico.setText(txtLexico.getText() + mensaje + "\n");
                    estado = 0;
                    conca = "";
                }

            }
            i++;
        }
    }

    private int Relaciona(char cAi) {
        if (cAi >= 'A' && cAi <= 'Z') {
            columna = 0;
        } else if (cAi >= 'a' && cAi <= 'z') {
            columna = 1;
        } else if (cAi >= '0' && cAi <= '9') {
            columna = 2;
        } else {

            switch (cAi) {
                case '.': {
                    columna = 3;
                    break;
                }
                case '_': {
                    columna = 4;
                    break;
                }
                case '"': {
                    columna = 5;
                    break;
                }
                case '/': {
                    columna = 6;
                    break;
                }
                case '*': {
                    columna = 7;
                    break;
                }
                case '{': {
                    columna = 8;
                    break;
                }
                case '}': {
                    columna = 9;
                    break;
                }
                case '=': {
                    columna = 10;
                    break;
                }
                case '<': {
                    columna = 11;
                    break;
                }
                case '>': {
                    columna = 12;
                    break;
                }
                case '+': {
                    columna = 13;
                    break;
                }
                case '-': {
                    columna = 14;
                    break;
                }
                case '(': {
                    columna = 15;
                    break;
                }
                case ')': {
                    columna = 16;
                    break;
                }
                case '[': {
                    columna = 17;
                    break;
                }
                case ']': {
                    columna = 18;
                    break;
                }
                case ',': {
                    columna = 19;
                    break;
                }
                case ';': {
                    columna = 20;
                    break;
                }
                case ':': {
                    columna = 21;
                    break;
                }
                case ' ': {
                    columna = 22;
                    break;
                }
                case 0x09: {
                    columna = 23;
                    break;
                }
                case '\n': {
                    columna = 24;
                    break;
                }
                default: {
                    columna = 25;
                    break;
                }

            }
        }

        return columna;
    }
    String st = String.valueOf(0x59 + 0x65 + 0x4E);

    private String Token(int token) {
        String comparar = conca.substring(0, conca.length() - 1).trim();
        if (token == 101 || token == 103 || token == 104 || token == 107 || token == 109 || token == 111 || token == 115 || token == 117 || token == 123) {
            i--;
        }
        switch (token) {
            case 100:
                break;
                //101 Palabras Reservadas 
            case 101:
                if (comparar.equalsIgnoreCase("Array")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Else")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Repeat")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("To")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Char")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("If")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("endif")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Return")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Until")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("False")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("String")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Div")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("ElseIf")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Mod")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("While")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Do")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("Then")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("String")) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "Palabra reservada: " + comparar;
                    break;
                }
                if (comparar.equals(string)) {
                    mensaje = comparar;
                    palres.add(mensaje);
                    mensaje = "";
                    mensaje = "creado Por: " + comparar;
                    break;
                }
                //Operadores Logicos
                if (comparar.equalsIgnoreCase("or")) {
                    mensaje = "Operador Logico: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("and")) {
                    mensaje = "Operador Logico: " + comparar;
                    break;
                }
                if (comparar.equalsIgnoreCase("not")) {
                    mensaje = "Operador Logico: " + comparar;
                    break;
                } else {
                    estado = 0;
                    Token(102);
                }
                break;
                //Identificadores se almacenan en el 102
            case 102:
                estado = 0;
                mensaje = "Identificador: " + comparar;

                break;
            case 103:
                mensaje = "Numero Entero: " + comparar;
                break;
            case 104:
                mensaje = "Numero Real: " + comparar;
                break;
            case 105:
                String letrero = conca.substring(1, conca.length() - 1);
                mensaje = "Letrero " + letrero;
                break;
            case 106:
                String comentario = conca.substring(2, conca.length() - 2).trim();
                mensaje = "Comentario: " + comentario;
                comentarios.add(comentario);
                break;
            case 107:
                mensaje = "Asignacion: " + comparar;
                break;
            case 108:
                mensaje = "Comparacion: " + conca;
                break;
            case 109:
                mensaje = "Menor que: " + comparar;
                break;
            case 110:
                mensaje = "Menor igual que: " + conca;
                break;
            case 111:
                mensaje = "Mayor que: " + comparar;
                break;
            case 112:
                mensaje = "Mayor igual que : " + conca;
                break;
            case 113:
                mensaje = "Suma: " + conca;
                break;
            case 114:
                mensaje = "Resta: " + conca;
                break;
            case 115:
                mensaje = "Multiplicacion: " + comparar;
                break;
            case 116:
                mensaje = "Potencia: " + conca;
                break;
            case 117:
                mensaje = "Division: " + comparar;
                break;
            case 118:
                mensaje = "Delimitador: " + conca;
                break;
            case 119:
                mensaje = "Delimitador: " + conca;
                break;
            case 120:
                mensaje = "Delimitador: " + conca;
                break;
            case 121:
                mensaje = "Delimitador: " + conca;
                break;
            case 122:
                mensaje = ">Delimitador: " + conca;
                break;
            case 123:
                mensaje = "Delimitador: " + comparar;
                break;
            case 124:
                mensaje = "Delimitador: " + conca;
                break;
            case 125:
                mensaje = "Delimitador: " + conca;
                break;
            case 126:
                mensaje = "Delimitador: " + conca.trim();
                break;
            case 127:
                String comentario2 = conca.substring(1, conca.length() - 1).trim();
                mensaje = "Comentario: " + comentario2;
                comentarios.add(comentario2);
                break;

        }
        return mensaje;
    }

    private String Error(int error) {
        String comet = conca.substring(1, conca.length()).trim();
        switch (error) {
            case 500:
                txtError.setText("Error 500. Identificador mal formado: \n");
                break;
            case 501:
                txtError.setText("Error 501. Letrero trunco: \n" + comet);
                i--;
                break;
            case 502:
                i--;
                if (conca.contains("/*")) {
                    txtError.setText("Error 502.Comentario trunco: \n" + comet.substring(1, comet.length()));
                } else {
                    txtError.setText("Error 502.Comentario trunco: \n" + comet);
                }
                break;

            case 503:
                txtError.setText("Error 503. Caracter no valido: \n" + conca);
                break;

            case 504:
                txtError.setText("Error 504. Numero mal formado: \n" + comet);
                i--;
                break;
            case 505:
                txtError.setText("Error 505. Simbolo desconocido: \n" + conca);
        }

        return mensaje;
    }

    Vector minusculas = new Vector();
    Vector mayusculas = new Vector();
    Vector numeros = new Vector();
    Vector operadores = new Vector();

    public void semantico(String s) {

        int i = 0;
        char[] cad = s.toCharArray();
        while (i < cad.length) {
            char caracter = cad[i];
            if (Character.isLowerCase(caracter)) {
                minusculas.add(Character.toString(caracter));
            } else if (Character.isUpperCase(caracter)) {
                mayusculas.addElement(caracter);
            } else if (Character.isDigit(caracter)) {
                numeros.addElement(caracter);
            } else if (Character.toString(caracter).contains("+") || Character.toString(caracter).contains("-")
                    || Character.toString(caracter).contains("*") || Character.toString(caracter).contains("/")) {
                operadores.addElement(caracter);
            }
            i++;
        }
        Collections.sort(minusculas);
        Collections.reverse(minusculas);
        Collections.sort(mayusculas);
        Collections.reverse(mayusculas);
        Collections.sort(numeros);
        Collections.reverse(numeros);
        Collections.sort(palres);
        Collections.sort(operadores);

        Collections.replaceAll(palres, null, "");

        txtSintactico.setText(/*minusculas.toString().substring(1, minusculas.toString().length() - 1) + "\n"
                + mayusculas.toString().substring(1, mayusculas.toString().length() - 1) + "\n"
                +*/ numeros.toString().substring(1, numeros.toString().length() - 1) + "\n"
                + palres.toString().substring(1, palres.toString().length() - 1) + "\n"
                + operadores.toString().substring(1, operadores.toString().length() - 1) + "\n"
                + comentarios.toString().substring(1, comentarios.toString().length() - 1));
    }

    public void Analizar() {
        estado = 0;
        txtLexico.setText("");
        txtSintactico.setText("");
        minusculas.removeAll(minusculas);
        mayusculas.removeAll(mayusculas);
        numeros.removeAll(numeros);
        palres.removeAll(palres);
        operadores.removeAll(operadores);
        comentarios.removeAll(comentarios);
        Analizar(txtEntrada.getText().toString() + "\n");
        semantico(txtEntrada.getText().toString());
        txtOP.setText(operadores.toString());
       
        txtOpe.setText(" "+ mayusculas.toString()+ " "+ numeros.toString()+ " " );
    }

    public static void main(String[] args) {
        Sintactico i = new Sintactico();
        sintactico1 s = new sintactico1();
        i.setVisible(true);
    }
}
