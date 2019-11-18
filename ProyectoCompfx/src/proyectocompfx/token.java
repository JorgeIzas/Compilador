/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompfx;

/**
 *
 * @author izasj
 */
public class token {
    private final int col; // columnas y fila de cada token encontrado
    private final int row;
    private final String cadena; //cadenas de texto devuletas por el analizador léxico
    private int entero; // el valor encontrado.
    
    public token(int col, int row, String cadena, boolean esDigito ) {
        this.col = col;
        this.row = row;
        this.cadena = cadena;
        if (esDigito){
        this.entero = Integer.parseInt(cadena);
        }
    }
    
    public token(int col, int row, String cadena ) {
        this.col = col;
        this.row = row;
        this.cadena = cadena;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public String getCadena() {
        return this.cadena;
    }
    
    public int getEntero() {
        return this.entero;
    }
}