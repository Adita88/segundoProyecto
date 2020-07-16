/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * 
 * @author David B
 */
public class Fibonacci extends trianguloPascal{
    
    private static final int[] valores= generarFibonacci();

    private Fibonacci() {
    }

    public static void dibujarTriangulo() {
        
        
        Fibonacci.pascalEstadoInicial();
        
        for(int i=0; i<Fibonacci.DIMENSION_MAXIMA_MATRIZ;i++)
            for(int j=0; j<Fibonacci.DIMENSION_MAXIMA_MATRIZ && j<=i && i+j<DIMENSION_MAXIMA_MATRIZ;j++){
                color[i][j]=ColoresRGB.getColorRGB(i+j);
            }
    }
    
    private static int[] generarFibonacci(){
        int[] retorno= new int[DIMENSION_MAXIMA_MATRIZ];
        for(int i=0; i<Fibonacci.DIMENSION_MAXIMA_MATRIZ;i++)
            for(int j=0; j<Fibonacci.DIMENSION_MAXIMA_MATRIZ && j<=i && i+j<DIMENSION_MAXIMA_MATRIZ;j++){
                retorno[i+j]+=PASCAL_MATRIZ[i][j];
            }
        return retorno;
    }

    public static int[] getValores() {
        return valores;
    }
    
}
