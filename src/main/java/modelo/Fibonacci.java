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

    /**
     * Método inica con dibujarTriángulo
     */
    public static void dibujarTriangulo() {
        
        
        Fibonacci.pascalEstadoInicial();
        
        for(int i=0; i<Fibonacci.DIMENSION_MAXIMA_MATRIZ;i++)
            for(int j=0; j<Fibonacci.DIMENSION_MAXIMA_MATRIZ && j<=i && i+j<DIMENSION_MAXIMA_MATRIZ;j++){
                color[i][j]=ColoresRGB.getColorRGB(i+j);
            }
    }
    
    /**
     * Método que genera a fibronacci
     * @return int
     */
    private static int[] generarFibonacci(){
        int[] retorno= new int[DIMENSION_MAXIMA_MATRIZ];
        for(int i=0; i<Fibonacci.DIMENSION_MAXIMA_MATRIZ;i++)
            for(int j=0; j<Fibonacci.DIMENSION_MAXIMA_MATRIZ && j<=i && i+j<DIMENSION_MAXIMA_MATRIZ;j++){
                retorno[i+j]+=PASCAL_MATRIZ[i][j];
            }
        return retorno;
    }

    /**
     * Método que obtiene valores tirados por ahí
     * @return valores
     */
    public static int[] getValores() {
        return valores;
    }
    
}
