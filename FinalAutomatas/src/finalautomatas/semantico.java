/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalautomatas;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.StringTokenizer;

import static finalautomatas.Sintactico.txtEntrada;
import static finalautomatas.Sintactico.txtError;
import static finalautomatas.Sintactico.txtLexico;
import static finalautomatas.Sintactico.txtSemanticaCorrecta;
import static finalautomatas.Sintactico.txtSintactico;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static finalautomatas.Sintactico.txtOpe;


public class semantico {

    
    
    public String semantico() {
        txtError.setText("");
        String Error = "";
        String Cadena = txtEntrada.getText();
       // String OP= txtOpe.getText();
        //Listas de Arreglos donde se almacenaran las mayusc-minusc, num, operadores, palabras reservadas y comentarios
        ArrayList<Character> mayusculas = new ArrayList<Character>();
        ArrayList<Character> minusculas = new ArrayList<Character>();
        ArrayList<Character> numeros = new ArrayList<Character>();
        ArrayList<String> oplogicos = new ArrayList<String>();
        ArrayList<String> palReservadas = new ArrayList<String>();
        ArrayList<String> opasignacion = new ArrayList<String>();
        ArrayList<String> oprelacional = new ArrayList<String>();
        ArrayList<String> oparitmeticos = new ArrayList<String>();
          int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = Cadena.indexOf("or");
        int posicion1, contador1 = 0;
        //se busca la primera vez que aparece
        posicion1 = Cadena.indexOf("and");
         int posicion2, contador2 = 0;
        //se busca la primera vez que aparece
        posicion2 = Cadena.indexOf("not");
        //Palabras Reservadas extras
        int posicion3 = Cadena.indexOf("array"), contador3 = 0;
        int posicion6 = Cadena.indexOf("exit"), contador6 = 0;
        int posicion9 = Cadena.indexOf("true"), contador9 = 0;
        int posicion10 = Cadena.indexOf("char"), contador10 = 0;
        int posicion11 = Cadena.indexOf("begin"), contador11 = 0;
        int posicion14 = Cadena.indexOf("not"), contador14 = 0;
        int posicion15 = Cadena.indexOf("return"), contador15 = 0;
        int posicion17 = Cadena.indexOf("false"), contador17 = 0;
        int posicion18 = Cadena.indexOf("string"), contador18 = 0;
        int posicion24 = Cadena.indexOf("var"), contador24 = 0;
        int posicion25 = Cadena.indexOf("div"), contador25 = 0;
        int posicion27 = Cadena.indexOf("const"), contador27 = 0;
        int posicion30 = Cadena.indexOf("mod"), contador30 = 0;
        int posicion34 = Cadena.indexOf("boolean"), contador34 = 0;
        //Identificar REPEAT
        int posicion7 = Cadena.indexOf("repeat"), contador7 = 0;
        int posicion16 = Cadena.indexOf("until"), contador16 = 0;
        //identificar IF
        int posicion4 = Cadena.indexOf("else"), contador4 = 0;
        int posicion8 = Cadena.indexOf("endif"), contador8 = 0;
        int posicion13 = Cadena.indexOf("if"), contador13 = 0;
        int posicion39 = Cadena.indexOf("then"), contador39 = 0;
        int posicion28 = Cadena.indexOf("elseif"), contador28 = 0;
        //Asignacion 
        int posicion42 = Cadena.indexOf(":"), contador42 = 0;
        int posicion43 = Cadena.indexOf("="), contador43 = 0;
        int posicion44 = Cadena.indexOf("<"), contador44 = 0;
        int posicion45 = Cadena.indexOf(">"), contador45 = 0;
        int posicion46 = Cadena.indexOf("+"), contador46 = 0;
        int posicion47 = Cadena.indexOf("-"), contador47 = 0;
        int posicion48 = Cadena.indexOf("*"), contador48 = 0;
        int posicion49 = Cadena.indexOf("/"), contador49 = 0;
        int posicion50 = Cadena.indexOf("**"), contador50 = 0;
        int posicion51 = Cadena.indexOf("%"), contador51 = 0; 
        
        //Obtener identificadores
        for (int i = 0; i < Cadena.length(); i++) {
            if (Character.isLetter(Cadena.charAt(0))) {
                if (Character.isUpperCase(Cadena.charAt(i))) {//MAYÚSCULAS
                    mayusculas.add(Cadena.charAt(i));
                } else if (Character.isLowerCase(Cadena.charAt(i))) {//MINÚSCULAS
                    minusculas.add(Cadena.charAt(i));
                } else if (Character.isDigit(Cadena.charAt(i))) {//NÚMEROS
                    numeros.add(Cadena.charAt(i));
                }
        //OPERADORES LÓGICOS
       
        if (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada                                 
            posicion = Cadena.indexOf("or", posicion + 1);
            if (contador > 0) {
                oplogicos.add("or");
            }
        }
       
        if (posicion1 != -1) { //mientras se encuentre el caracter
            contador1++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada                                 
            posicion1 = Cadena.indexOf("and", posicion1 + 1);
            if (contador1 > 0) {
                oplogicos.add("and");
            }
        }
       
        if (posicion2 != -1) { //mientras se encuentre el caracter
            contador2++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada                                 
            posicion2 = Cadena.indexOf("not", posicion2 + 1);
            if (contador2 > 0) {
                oplogicos.add("not");
            }
        }
        //PALABRAS RESERVADAS
        
        if (posicion3 != -1) {//Mientras se encuentra el caracter
            contador3++;//Se cuenta
            posicion3 = Cadena.indexOf("array", posicion3 + 1);//Sigue buscando a partir de la posición siguiente a la encontrada  
            if (contador3 > 0) {
                palReservadas.add("array");
            }
        }
        
        if (posicion4 != -1) {
            contador4++;//Se cuenta
            posicion4 = Cadena.indexOf("else", posicion4 + 1);//Sigue buscando a partir de la posición siguiente a la encontrada  
            if (contador4 > 0) {
                palReservadas.add("else");
            }
        }
        if (posicion6 != -1) {
            contador6++;//Se cuenta
            posicion6 = Cadena.indexOf("exit", posicion6 + 1);//Sigue buscando a partir de la posición siguiente a la encontrada  
            if (contador6 > 0) {
                palReservadas.add("exit");
            }
        }
        
        if (posicion7 != -1) {
            contador7++;//Se cuenta
            posicion7 = Cadena.indexOf("repeat", posicion7 + 1);//Sigue buscando a partir de la posición siguiente a la encontrada  
            if (contador7 > 0) {
                palReservadas.add("repeat");
            }
        }
        if (posicion8 != -1) {
            contador8++;//Se cuenta
            posicion8 = Cadena.indexOf("endif", posicion8 + 1);//Sigue buscando a partir de la posición siguiente a la encontrada  
            if (contador8 > 0) {
                palReservadas.add("endif");
            }
        }
        
        if (posicion9 != -1) {
            contador9++;
            posicion9 = Cadena.indexOf("true", posicion9 + 1);
            if (contador9 > 0) {
                palReservadas.add("true");
            }
        }
       
        if (posicion10 != -1) {
            contador10++;
            posicion10 = Cadena.indexOf("char", posicion10 + 1);
            if (contador10 > 0) {
                palReservadas.add("char");
            }
        }
        
        if (posicion11 != -1) {
            contador11++;
            posicion11 = Cadena.indexOf("begin", posicion11 + 1);
            if (contador11 > 0) {
                palReservadas.add("begin");
            }
        }
        
        
         
        if (posicion13 != -1) {
            contador13++;
            posicion13 = Cadena.indexOf("if", posicion13 + 1);
            if (contador13 > 0) {
                palReservadas.add("if");
            }
        }
        
        if (posicion14 != -1) {
            contador14++;
            posicion14 = Cadena.indexOf("not", posicion14 + 1);
            if (contador14 > 0) {
                palReservadas.add("not");
            }
        }
        
        if (posicion15 != -1) {
            contador15++;
            posicion15 = Cadena.indexOf("return", posicion15 + 1);
            if (contador15 > 0) {
                palReservadas.add("return");
            }
        }
        
        if (posicion16 != -1) {
            contador16++;
            posicion16 = Cadena.indexOf("until", posicion16 + 1);
            if (contador16 > 0) {
                palReservadas.add("until");
            }
        }
        
        if (posicion17 != -1) {
            contador17++;
            posicion17 = Cadena.indexOf("false", posicion17 + 1);
            if (contador17 > 0) {
                palReservadas.add("false");
            }
        }
        
        if (posicion18 != -1) {
            contador18++;
            posicion18 = Cadena.indexOf("string", posicion18 + 1);
            if (contador18 > 0) {
                palReservadas.add("string");
            }
        }
       if (posicion24 != -1) {
            contador24++;
            posicion24 = Cadena.indexOf("var", posicion24 + 1);
            if (contador24 > 0) {
                palReservadas.add("var");
            }
        }
        
        if (posicion25 != -1) {
            contador25++;
            posicion25 = Cadena.indexOf("div", posicion25 + 1);
            if (contador25 > 0) {
                palReservadas.add("div");
            }
        }
       
        if (posicion27 != -1) {
            contador27++;
            posicion27 = Cadena.indexOf("const", posicion27 + 1);
            if (contador27 > 0) {
                palReservadas.add("const");
            }
        }
        
        if (posicion28 != -1) {
            contador28++;
            posicion28 = Cadena.indexOf("elseif", posicion28 + 1);
            if (contador28 > 0) {
                palReservadas.add("elseif");
            }
        }
        
       
        if (posicion30 != -1) {
            contador30++;
            posicion30 = Cadena.indexOf("mod", posicion30 + 1);
            if (contador30 > 0) {
                palReservadas.add("mod");
            }
        }
        
       if (posicion34 != -1) {
            contador34++;
            posicion34 = Cadena.indexOf("boolean", posicion34 + 1);
            if (contador34 > 0) {
                palReservadas.add("boolean");
            }
        }
        
        if (posicion39 != -1) {
            contador39++;
            posicion39 = Cadena.indexOf("then", posicion39 + 1);
            if (contador39 > 0) {
                palReservadas.add("then");
            }
        }
        
        //OPERADORES ASIGNACION
        
        if (posicion42 != -1) {
            contador42++;
            posicion42 = Cadena.indexOf(":", posicion42 + 1);
            if (contador42 > 0) {
                opasignacion.add(":");
            }
        }
        
        if (posicion43 != -1) {
            contador43++;
            posicion43 = Cadena.indexOf("=", posicion43 + 1);
            if (contador43 > 0) {
                opasignacion.add("=");//OPERADORES DE ASIGNASION
                oprelacional.add("=");//OPERADORES RELACIONALES
            }
        }
        //OPERADORES RELACIONALES
        
        if (posicion44 != -1) {
            contador44++;
            posicion44 = Cadena.indexOf("<", posicion44 + 1);
            if (contador44 > 0) {
                oprelacional.add("<");
            }
        }
        
        if (posicion45 != -1) {
            contador45++;
            posicion45 = Cadena.indexOf(">", posicion45 + 1);
            if (contador45 > 0) {
                oprelacional.add(">");
            }
        }
        //OPERADORES ARITMÉTICOS
        
        if (posicion46 != -1) {
            contador46++;
            posicion46 = Cadena.indexOf("+", posicion46 + 1);
            if (contador46 > 0) {
                oparitmeticos.add("+");
            }
        }
        
        if (posicion47 != -1) {
            contador47++;
            posicion47 = Cadena.indexOf("-", posicion47 + 1);
            if (contador47 > 0) {
                oparitmeticos.add("-");
            }
        }
        
        if (posicion48 != -1) {
            contador48++;
            posicion48 = Cadena.indexOf("*", posicion48 + 1);
            if (contador48 > 0) {
                oparitmeticos.add("*");
            }
        }
        
        if (posicion49 != -1) {
            contador49++;
            posicion49 = Cadena.indexOf("/", posicion49 + 1);
            if (contador49 > 0) {
                oparitmeticos.add("/");

            }
        }
        
        if (posicion50 != -1) {
            contador50++;
            posicion50 = Cadena.indexOf("**", posicion50 + 1);
            if (contador50 > 0) {
                oparitmeticos.add("**");
            }
        }
        
        if (posicion51 != -1) {
            contador51++;
            posicion51 = Cadena.indexOf("%", posicion51 + 1);
            if (contador51 > 0) {
                oparitmeticos.add("%");
            }
        }

       

                //sort ordena las cadenas
                Collections.sort(minusculas);
                Collections.sort(mayusculas);
                Collections.sort(numeros);
                Collections.reverse(numeros);
                Collections.sort(oplogicos);
                Collections.sort(palReservadas);
                Collections.sort(opasignacion);
                Collections.sort(oprelacional);
                Collections.sort(oparitmeticos);

                Collections.replaceAll(palReservadas, null, "");

                txtSemanticaCorrecta.setText(minusculas.toString().substring(1, minusculas.toString().length() -1)
                        + " | " + mayusculas.toString().substring(1, mayusculas.toString().length() - 1) 
                        + " | " + numeros.toString().substring(1, numeros.toString().length() - 1)
                        + " | " + oplogicos.toString().substring(1, oplogicos.toString().length() - 1)
                        + " | " + palReservadas.toString().substring(1, palReservadas.toString().length() - 1)
                        + " | " + opasignacion.toString().substring(1, opasignacion.toString().length() - 1)
                        + " | " + oprelacional.toString().substring(1, oprelacional.toString().length() - 1)
                        + " | " + oparitmeticos.toString().substring(1, oparitmeticos.toString().length() - 1));

                
                //ERRORES
                if (Cadena.endsWith("_")) {
                    txtError.setText("LA CADENA TERMINA CON UN GUION");
                    txtLexico.setText("");
                    txtSintactico.setText("");
                    txtSemanticaCorrecta.setText("");
                }
                else if(Cadena.charAt(Cadena.length() - 1) != ';'){
                    txtError.setText("FALTA EL DELIMITADOR");
                    txtLexico.setText("");
                    txtSintactico.setText("");
                    txtSemanticaCorrecta.setText("");
                }
                else if(Cadena.charAt(Cadena.length() - 2) != 'f' ){
                    txtError.setText("FALTA ENDIF");
                    txtLexico.setText("");
                    txtSintactico.setText("");
                    txtSemanticaCorrecta.setText("");
                }
                
                
                //Tablas
              String con="";
              char buf[] = new char[2];  
              Cadena.getChars(0, 1, buf, 0);
              String primero="";
              primero=buf.toString();
              String conE="";
              if(primero.equals(posicion13)){
                   con+=primero;
                   conE+="PRIMERO DEBE IR 'IF' \n";
                char buf2[] = new char[1];  
                Cadena.getChars(5, 0, buf, 0);
                String seg="";
                seg=buf2.toString();
                    if(seg.equals(posicion44) || seg.equals(posicion45) ){
                    con+=seg;
                    conE+="Solo se aceptan '< o >' \n";
                    }
                  txtSemanticaCorrecta.setText(conE);
                  txtOpe.setText(""+oparitmeticos+" "+opasignacion);
                  
              }/*else{
                  
                  txtSemanticaCorrecta.setText(conE);
                  txtError.setText("NO HA COMENZADO CON UNA LETRA");
                  txtLexico.setText("");
                  txtSintactico.setText("");
                  }*/
                

            } else {
                txtError.setText("NO HA COMENZADO CON UNA LETRA");
                txtLexico.setText("");
                txtSintactico.setText("");
                txtSemanticaCorrecta.setText("");
            }
        }
        return Error;
    }
}
