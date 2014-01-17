/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.Stack;

/**
 *
 * @author diego
 */
public class AnalizadorCadenas {

    private Stack pilaVarDesicion;
    private Stack pilaValores;

    public AnalizadorCadenas() {
        pilaVarDesicion = new Stack();
        pilaValores = new Stack();
    }

    public void analizador(String cadena) {
        String[] separador;
        separador = cadena.split("");
        for (int i = 1; i < separador.length; i++) {
            if (separador[i].equals("x") || separador[i].equals("X")) {
                //control de errores por no encontrar +,-
                String variable = "";
                while (i < separador.length) {
                    if (separador[i].equals("+") || separador[i].equals("-") || separador[i].equals("") || separador[i].equals("<") || separador[i].equals("=")) {
                        break;
                    }
                    variable += separador[i];
                    i++;
                }
                i--;
                getPilaVarDesicion().push(variable);
            } else {
                String valores = "";
                if (separador[i].equals("<") || separador[i].equals("=")) {
                    if (separador[i].equals("<")) {
                        getPilaVarDesicion().push("<");
                        i++;
                        while (i < separador.length) {
                            valores += separador[i];
                            i++;
                        }
                        getPilaValores().push(valores);
                    } else {
                        if (separador[i].equals("=")) {
                            getPilaVarDesicion().push("=");
                            i++;
                            while (i < separador.length) {
                                valores += separador[i];
                                i++;
                            }
                            getPilaValores().push(valores);
                        }
                    }
                } else {
                    if (separador[i].equals("z") || separador[i].equals("Z")) {
                        pilaVarDesicion.push("Z");
                        i += 2;
                    }
                    while (!separador[i].equals("x")) {
                        valores += separador[i];
                        i++;
                    }
                    i--;
                    getPilaValores().push(valores);
                }
            }
        }
    }

    public String imprimirPilaVaribles() {
        String cadena = "";
        for (Object object : getPilaVarDesicion()) {
            cadena += object + "\t";
        }
        return cadena;
    }

    /**
     * @return the pilaVarDesicion
     */
    public Stack getPilaVarDesicion() {
        return pilaVarDesicion;
    }

    /**
     * @param pilaVarDesicion the pilaVarDesicion to set
     */
    public void setPilaVarDesicion(Stack pilaVarDesicion) {
        this.pilaVarDesicion = pilaVarDesicion;
    }

    /**
     * @return the pilaValores
     */
    public Stack getPilaValores() {
        return pilaValores;
    }

    /**
     * @param pilaValores the pilaValores to set
     */
    public void setPilaValores(Stack pilaValores) {
        this.pilaValores = pilaValores;
    }

}
