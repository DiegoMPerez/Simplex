/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Interfaz.AnalizadorCadenas;
import java.text.DecimalFormat;

/**
 *
 * @author diego
 */
public class GenerarMatriz {

    private double[][] matriz;
    int puntero;
    private int nrovaribles;

    public GenerarMatriz() {
        puntero = 0;
        nrovaribles=0;
    }

    //Generar la matriz en base a la función objetivo
    public void generarMatriz(AnalizadorCadenas analizador) {
        int x = analizador.getPilaVarDesicion().size();
        setMatriz(new double[x][x * 2]);
        int i = 1;
        matriz[0][0] = 1;
        for (Object o : analizador.getPilaValores()) {
            getMatriz()[puntero][i] = Double.parseDouble(o.toString()) * -1;
            i++;
        }
        setNrovaribles(x-1);
        puntero++;
        holgura();
    }

    public void anadirFuncion(AnalizadorCadenas analizador) {
        if (puntero < matriz.length) {
            getMatriz()[puntero][0] = 0;
            for (int i = 1; i < analizador.getPilaValores().size(); i++) {
                String objeto = analizador.getPilaVarDesicion().get(i - 1).toString();
                int posicion = Integer.parseInt(objeto.substring(1));
                double num = Double.parseDouble(analizador.getPilaValores().get(i - 1).toString());
                getMatriz()[puntero][(posicion)] = num;
            }
            int tamanio = getMatriz()[0].length;
            int tamanioPila = analizador.getPilaValores().size();
            getMatriz()[puntero][tamanio - 1] = Double.parseDouble(analizador.getPilaValores().get(tamanioPila - 1).toString());
            puntero++;
        } else {
            redimensionar();
            anadirFuncion(analizador);
            holgura();
        }

    }

    public void redimensionar() {
        double[][] nuevaMatriz = new double[matriz.length + 1][matriz[0].length+1];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(j==matriz[0].length-1){
                    nuevaMatriz[i][j+1]=matriz[i][j];
                }else{
                    nuevaMatriz[i][j]=matriz[i][j];
                }
            }
        }
        matriz= nuevaMatriz;
    }

    public void holgura() {
        for (int i = 1; i < getMatriz().length; i++) {
            for (int j = getNrovaribles()+1, k = 1; j < getMatriz()[0].length - 1; j++, k++) {
                if (i == k) {
                    getMatriz()[i][j] = 1;
                }
            }
        }
    }

    public String toString() {
        DecimalFormat decim;
        decim = new DecimalFormat("#.##");
        String cad = "";
        for (double[] matriz1 : getMatriz()) {
            for (int j = 0; j < getMatriz()[0].length; j++) {
                cad += decim.format(matriz1[j]) + "\t";
            }
            cad += "\n";
        }
        return cad;
    }

    /**
     * @return the matriz
     */
    public double[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * @return the nrovaribles
     */
    public int getNrovaribles() {
        return nrovaribles;
    }

    /**
     * @param nrovaribles the nrovaribles to set
     */
    public void setNrovaribles(int nrovaribles) {
        this.nrovaribles = nrovaribles;
    }

}
