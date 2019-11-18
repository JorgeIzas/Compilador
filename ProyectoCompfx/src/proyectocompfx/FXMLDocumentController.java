/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompfx;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javax.swing.JFileChooser;

/**
 *
 * @author izasj
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea txtComp, txtError;
    
    @FXML
    private void abrirArchivos(ActionEvent event) throws IOException {
        txtComp.clear();
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Abrir TxT");
        chooser.addChoosableFileFilter(new TxTFilter());
        chooser.showOpenDialog(null);
        File archivo = chooser.getSelectedFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea = reader.readLine();
            while (linea != null) {
                txtComp.appendText(linea + "\n");
                linea = reader.readLine();
            }
            AnalizadorLexico lex = new AnalizadorLexico(new FileReader(archivo));
            AnalizadorSintactico parser = new AnalizadorSintactico(lex);
            parser.arbolSintactico.recorrerArbol();
            parser.arbolSintactico.recorrerArbol(Arbol.TIPO_RECORRIDO_GRAFO);
        } catch (Exception ex) {
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
