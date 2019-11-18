/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import jflex.SilentExit;

/**
 *
 * @author izasj
 */
public class GenLexer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println( System.getProperty("user.dir"));
        String opciones[] = new String[3];
        opciones[0]="-d";
        opciones[1]="src"
                +File.separator
                +"proyectocompfx"; //destino para la clase resultante
        opciones[2]="src"
                +File.separator
                +"analizadores"
                +File.separator+
                "lexico.jflex"; //cambiar el nombre de la fuente
        try {
            jflex.Main.generate(opciones);
        } catch (SilentExit ex) {
            Logger.getLogger(GenLexer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
