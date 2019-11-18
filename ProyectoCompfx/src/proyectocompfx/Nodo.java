/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompfx;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author izasj
 */
public class Nodo {
    private int tipo;
    private int operador;
    private int valor;
    private String identificador;
    private final ArrayList<Nodo> hijos;

    public static final int TIPO_EXPRESION=1;
    public static final int TIPO_NUMERO=2;
    public static final int TIPO_OPERADOR=3;
    public static final int TIPO_IDENTIFICADOR=4;
    
    public static final int OP_SUMA = 10;
    public static final int OP_RESTA = 11;
    public static final int OP_MULTI = 12;
    public static final int OP_DIVI = 13;
    public static final int OP_IGUAL = 14;
    
    public static final int NODO_ASIGNACION = 20;
    /**
     *
     * @param tipo de nodo a crear
     * @param valor del nodo a crear
     */
    public Nodo(int tipo, int valor) {
        this.hijos = new ArrayList<>();  
        this.tipo = tipo;
        switch (this.tipo) {
            case Nodo.TIPO_EXPRESION:
                break;
            case Nodo.TIPO_NUMERO:
                this.valor = valor;
                break;
            case Nodo.TIPO_OPERADOR:
                this.operador = valor;
                break;
            case Nodo.TIPO_IDENTIFICADOR:
                break;
        }
    }
    
    /**
     *
     * @param tipo de nodo a crear
     * @param valor del nodo a crear
     */
    public Nodo(int tipo, String valor) {
        this.hijos = new ArrayList<>();  
        this.tipo = tipo;
        switch (this.tipo) {
            case Nodo.TIPO_EXPRESION:
            case Nodo.TIPO_NUMERO:
            case Nodo.TIPO_OPERADOR:
                break;
            case Nodo.TIPO_IDENTIFICADOR:
                this.identificador = valor;
                break;
        }
    }
    
    public Nodo(int valor) {
        this.hijos = new ArrayList<>();
        this.tipo=TIPO_NUMERO;
        this.valor=valor;
        this.operador=0;
    }
    
    public Nodo() {
        this.hijos = new ArrayList<>();
        this.tipo=0;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the operador
     */
    public int getOperador() {
        return operador;
    }

    public String getOperadorString() {
        switch (operador) {
            case OP_SUMA:
                return "+";
            case OP_RESTA:
                return "-";
            case OP_MULTI:
                return "*";
            case OP_DIVI:
                return "/";
            case OP_IGUAL:
                return "=";
        }
        return "na";
    }
    
    /**
     * @param operador the operador to set
     */
    public void setOperador(int operador) {
        this.operador = operador;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }
    
    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the hijos
     */
    public List<Nodo> getHijos() {
        return hijos;
    }
    
    public boolean agregarHijo(Nodo nodo){
        return hijos.add(nodo);
    }
}
