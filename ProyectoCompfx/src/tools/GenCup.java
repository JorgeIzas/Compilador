/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;

/**
 *
 * @author izasj
 */
public class GenCup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String opciones[] = new String[5];
        opciones[0]="-destdir";
        opciones[1]="src"
                +File.separator+
                "proyectocompfx"; //cambiar destino
        opciones[2]="-parser";
        opciones[3]="AnalizadorSintactico"; //cambiar el nombre de la clase
        opciones[4]="src"
                +File.separator+
                "analizadores"
                +File.separator+
                "sintactico.jcup"; //cambiar el nombre de la fuente
        try {     
            java_cup.Main.main(opciones);
            } 
        catch (Exception e) {
            System.out.print(e);
            }
    }
    
}
