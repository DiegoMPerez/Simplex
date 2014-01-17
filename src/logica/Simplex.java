/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.DecimalFormat;
import java.util.Stack;

/**
 *
 * @author diego
 */
public class Simplex {

    private double[][] matriz;
    private Pivote pivote;
    private double valorPivote;
    private Stack detalles;

    public Simplex() {
    }

    public Simplex(double[][] matriz) {
        this.matriz = matriz;
        pivote = new Pivote();
        detalles = new Stack();
    }

    //Método para encontrar la columna pivote
    public void columnaPivote() {
        double numero = 0;
        for (int i = 1; i < getMatriz().length; i++) {
            if (getMatriz()[0][i] < numero) {
                numero = getMatriz()[0][i];
                pivote.setColumna(i);
            }
        }
    }

    //Método para encontrar la fila pivote
    public void filaPivote() {
        double division;
        double valor = -1;
        int R = matriz[0].length - 1;
        int i = 1;
        int bandera = 0;
        do {
            try {
                division = getMatriz()[i][R] / getMatriz()[i][pivote.getColumna()];
                if (division > 0) {
                    if (bandera == 0) {
                        valor = division;
                        bandera = 1;
                        pivote.setFila(i);
                    } else {
                        if (division < valor) {
                            valor = division;
                            pivote.setFila(i);
                        }
                    }
                }
            } catch (Exception e) {

            }
            i++;
        } while (i < getMatriz().length);
        valorPivote = matriz[pivote.getFila()][pivote.getColumna()];
    }

    public void valorPivoteUno() {
        for (int i = 0; i < matriz[0].length; i++) {
            double numero = matriz[pivote.getFila()][i] * (1 / valorPivote);
            matriz[pivote.getFila()][i] = numero;
        }
    }

    public void ceroColunmaPivote() {
        double valorCero;
        for (int i = 0; i < matriz.length; i++) {
            valorCero = matriz[i][pivote.getColumna()] * -1;
            if (i != pivote.getFila()) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = (matriz[pivote.getFila()][j] * valorCero) + matriz[i][j];
                }
            }
        }
    }

    public String imprimirRespuesta() {
        String cad = "";
        cad += "Z = " + matriz[0][matriz[0].length - 1] + "\n";
        for (int i = 0; i < matriz[0].length; i++) {

        }
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length / 2; j++) {
                if (matriz[i][j] == 1 && matriz[0][j] == 0) {
                    cad += "X" + j + " = " + matriz[i][matriz[0].length - 1] + "\n";
                } else {
                    if (i == 1 && matriz[0][j] > 0) {
                        cad += "X" + j + " = 0" + "\n";
                    }
                }
            }
        }
        return cad;
    }

    public boolean varDesicionCero(int n) {

        for (int i = 1; i < matriz.length; i++) {
            if (matriz[0][i] < 0) {
                detalles.push(imprimirMatriz());
                detalles.push("-----------------   ITERACIÓN " + n + "----------------------------" + "\n");
                columnaPivote();
                filaPivote();
                getDetalles().push("fila Pivote: " + pivote.getFila() + "  ;  " + "columna Pivote: " + pivote.getColumna() + ";  VALOR: " + valorPivote + "\n");
                detalles.push(imprimirMatriz());
                valorPivoteUno();
                detalles.push("---------------------------------------------------------" + "\n");
                getDetalles().push("HACER UNO AL PIVOTE " + "\n");
                getDetalles().push(imprimirMatriz());
                detalles.push("---------------------------------------------------------" + "\n");
                ceroColunmaPivote();
                getDetalles().push("CERO COLUMNA PIVOTE" + "\n");
                getDetalles().push(imprimirMatriz());
                detalles.push("---------------------------------------------------------" + "\n");
                return false;
            }
        }
        return true;
    }

    public String imprimirMatriz() {
        DecimalFormat decim;
        decim = new DecimalFormat("#.##");
        String cad = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (pivote.getFila() == i && pivote.getColumna() == j) {
                    cad +="{"+ decim.format(matriz[i][j])+"}" + "\t";
                    j++;
                }
                cad += decim.format(matriz[i][j]) + "\t";
            }
            cad += "\n";
        }
        return cad;
    }

    /**
     * @return the pivote
     */
    public Pivote getPivote() {
        return pivote;
    }

    /**
     * @param pivote the pivote to set
     */
    public void setPivote(Pivote pivote) {
        this.pivote = pivote;
    }

    /**
     * @return the matris
     */
    public double[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matris the matris to set
     */
    public void setMatriz(double[][] matris) {
        this.matriz = matris;
    }

    /**
     * @return the detalles
     */
    public Stack getDetalles() {
        return detalles;
    }

}
