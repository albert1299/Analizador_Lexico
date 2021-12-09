/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tokenizer.lexico2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Albert
 */
public class Ejercicio2Analizador {
    public static List<Token> lexico(String input) {
        List<Token> tokens = new ArrayList<Token>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreElements()) {
            String palabra = tokenizer.nextToken();
            boolean matched = false;
            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);
                if (matcher.find()) {
                    Token token = new Token();
                    token.setTipo(tokenTipo);
                    token.setValor(palabra);
                    tokens.add(token);
                    matched = true;
                    break;
                }
            }
            if (!matched) {

                Token token = new Token();
                token.setTipo(null);
                token.setValor(palabra);
                tokens.add(token);
                throw new RuntimeException("TOKEN INVALIDO " + palabra);
                // System.out.println("ERROR" + " "+token.getValor());
            }
        }
        return tokens;
    }

    /*ENTERO aux = -34;
ENTERO b = 56;
ENTERO c = aux * b;      
ENTERO suma = 34 / 45;*/


    public static void main(String[] args) {
        String input = "ENTERO suma = 34 / 45 ;";
        List<Token> lista = lexico(input);
        for (Token token : lista) {
            if (token.getTipo() != null) {
                int nro_chars = token.getValor().length();
                String valueStr = token.getValor().toString();
                String new_string = valueStr.substring(1);
                char fs = token.getValor().charAt(0);
                if (nro_chars > 1 && (valueStr.contains("*") || valueStr.contains("/") || valueStr.contains("=")
                        || valueStr.contains("+") || valueStr.contains("-"))) {
                    if (token.getTipo().toString() == "NUMERO" && (fs == '+' || fs == '-') && (!new_string.contains("*") && !new_string.contains("/") && !new_string.contains("=") && !new_string.contains("+") && !new_string.contains("-") ) ) {
                        System.out.println("NUMERO" + "  " + token.getValor());
                    }
                    else {
                        System.out.println("ERROR" + "  " + token.getValor());
                    }
                } else if (nro_chars > 6 && valueStr.contains("ENTERO"))
                    System.out.println("VARIABLE" + "  " + token.getValor());
                else
                    System.out.println(token.getTipo().toString() + "  " + token.getValor());
            } else
                System.out.println("ERROR" + "  " + token.getValor());
        }
    }
}
