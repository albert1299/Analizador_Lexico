/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tokenizer.lexico2;

/**
 *
 * @author Albert
 */
public enum Tipos {
    ENTERO("[ENTERO]"),
    NUMERO ("[0-9]+"),
    MULTIPLICACION("[*]"),
    DIVISION("[/]"),
    SUMA("[+]"),
    RESTA("[-]"),
    VARIABLE("[a-zA-Z]+"),
    IGUAL("[=]"),
    PUNTO_Y_COMA("[;]");
    public final String patron;

    private Tipos(String patron) {
        this.patron = patron;
    }    
}
