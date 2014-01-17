/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo.simplex;

import Interfaz.AnalizadorCadenas;
import Interfaz.InterfazSimplex;
import java.awt.Checkbox;
import java.awt.Color;
import java.text.DecimalFormat;
import logica.GenerarMatriz;
import logica.Simplex;

/**
 *
 * @author diego
 */
public class MetodoSimplex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        AnalizadorCadenas a = new AnalizadorCadenas();
//        a.analizador("z=50x1+80x2");
//        AnalizadorCadenas b = new AnalizadorCadenas();
//        b.analizador("1x1+2x2=120");
//        AnalizadorCadenas c = new AnalizadorCadenas();
//        c.analizador("1x1+1x2=90");
//************************************************************
//        AnalizadorCadenas a = new AnalizadorCadenas();
//        a.analizador("z=3x1+5x2");
//        AnalizadorCadenas b = new AnalizadorCadenas();
//        b.analizador("1x1=4");
//        AnalizadorCadenas c = new AnalizadorCadenas();
//        c.analizador("2x2=12");
//        AnalizadorCadenas d = new AnalizadorCadenas();
//        d.analizador("3x1+2x2=18");
//************************************************************
//        AnalizadorCadenas a = new AnalizadorCadenas();
//        a.analizador("z=3x1+2x2+5x3");
//        AnalizadorCadenas b = new AnalizadorCadenas();
//        b.analizador("1x1+2x2+1x3=330");
//        AnalizadorCadenas c = new AnalizadorCadenas();
//        c.analizador("3x1+2x3=360");
//        AnalizadorCadenas d = new AnalizadorCadenas();
//        d.analizador("1x1+4x2=320");
 // PRUEBA          *******************************************
//        
//        AnalizadorCadenas a = new AnalizadorCadenas();
//        a.analizador("Z=170x1+160x2+175x3+180x4+195x5");
//        AnalizadorCadenas b = new AnalizadorCadenas();
//        b.analizador("1x1=48");
//        AnalizadorCadenas c = new AnalizadorCadenas();
//        c.analizador("1x1+1x2=79");
//        AnalizadorCadenas d = new AnalizadorCadenas();
//        d.analizador("1x1+1x2=65");
//        AnalizadorCadenas e = new AnalizadorCadenas();
//        e.analizador("1x1+1x2+1x3=87");
//        AnalizadorCadenas f = new AnalizadorCadenas();
//        f.analizador("1x2+1x3=64");
//        AnalizadorCadenas g = new AnalizadorCadenas();
//        g.analizador("1x3+1x4=73");
//        AnalizadorCadenas h = new AnalizadorCadenas();
//        h.analizador("1x3+1x4=82");
//        AnalizadorCadenas i = new AnalizadorCadenas();
//        i.analizador("1x4=43");
//        AnalizadorCadenas j = new AnalizadorCadenas();
//        j.analizador("1x4+1x5=52");
//        AnalizadorCadenas k = new AnalizadorCadenas();
//        k.analizador("1x5=15");
////        
//        GenerarMatriz gm = new GenerarMatriz();
//        gm.generarMatriz(a);
//        gm.anadirFuncion(b);
//        gm.anadirFuncion(c);
//        gm.anadirFuncion(d);
//        gm.anadirFuncion(e);
//        gm.anadirFuncion(f);
//        gm.anadirFuncion(g);
//        gm.anadirFuncion(h);
//        gm.anadirFuncion(i);
//        gm.anadirFuncion(j);
//        gm.anadirFuncion(k);
//***********************************************************************
//        AnalizadorCadenas a = new AnalizadorCadenas();
//        a.analizador("z=60x1+30x2+20x3");
//        AnalizadorCadenas b = new AnalizadorCadenas();
//        b.analizador("8x1+6x2+1x3<48");
//        AnalizadorCadenas c = new AnalizadorCadenas();
//        c.analizador("2x1+0.5x2+0.5x3<8");
//        AnalizadorCadenas d = new AnalizadorCadenas();
//        d.analizador("4x1+2x2+0.5x3<30");
//        AnalizadorCadenas e = new AnalizadorCadenas();
//        e.analizador("1x2<5");
//        
        GenerarMatriz gm = new GenerarMatriz();
//        gm.generarMatriz(a);
//        gm.anadirFuncion(b);
//        gm.anadirFuncion(c);
//        gm.anadirFuncion(d);
//        gm.anadirFuncion(e);

        //**************************************************************  
//        AnalizadorCadenas a = new AnalizadorCadenas();
//        a.analizador("z=1x1+1x2");
//        AnalizadorCadenas b = new AnalizadorCadenas();
//        b.analizador("-1x1+1x2=2");
//        AnalizadorCadenas c = new AnalizadorCadenas();
//        c.analizador("1x1+2x2=6");
//        AnalizadorCadenas d = new AnalizadorCadenas();
//        d.analizador("2x1+1x2=6");
        //*****************************************************
        AnalizadorCadenas a = new AnalizadorCadenas();
        a.analizador("4x1=9");
        
        AnalizadorCadenas b = new AnalizadorCadenas();
        
        
//        b.analizador("2x1+3x2=6");
//        AnalizadorCadenas c = new AnalizadorCadenas();
//        c.analizador("6x1+4x2=12");
//        AnalizadorCadenas d = new AnalizadorCadenas();
//        d.analizador("-2x1+2x2=2");
//
//        gm.generarMatriz(a);
//        gm.anadirFuncion(b);
//        gm.anadirFuncion(c);
//        gm.anadirFuncion(d);
//
//        System.out.println(gm.toString());
//
//        Simplex s = new Simplex(gm.getMatriz());
//        int ii = 0;
//        while (!s.varDesicionCero(ii+1)) {
//            ii++;
//            System.out.println("ITERACION" + ii + "   \n" + s.imprimirMatriz());
//        }
//
//        System.out.println(s.imprimirRespuesta());
//        
//        InterfazSimplex ifs= new InterfazSimplex();
//        ifs.setVisible(true);
        
        
        
        
    }
}
