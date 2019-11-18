/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompfx;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Marvin
 */
public class TxTFilter extends FileFilter {
    final static String txt= "txt";
    public TxTFilter() {
    }
    
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            String extension = s.substring(i+1).toLowerCase();
            if (txt.equals(extension)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String getDescription() {
        return "Archivos .txt";
    }
}