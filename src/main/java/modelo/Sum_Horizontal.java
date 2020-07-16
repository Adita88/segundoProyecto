/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author David B
 */
public class Sum_Horizontal extends trianguloPascal{
    
    private static final int[] valores= sumaHorizontal();
    
    private Sum_Horizontal() {
    }

    /**
     * Método que dibuja el triángulo
     */
    public static void dibujarTriangulo() {
        
        
        Sum_Horizontal.pascalEstadoInicial();
        
        for(int i=0; i<Sum_Horizontal.DIMENSION_MAXIMA_MATRIZ;i++)
            for(int j=0; j<Sum_Horizontal.DIMENSION_MAXIMA_MATRIZ && j<=i;j++)
                color[i][j]=ColoresRGB.getColorRGB(i);
    }
    
    /**
     * Método que realiza la suma Horizontal
     * @return int []
     */
    private static int[] sumaHorizontal(){
        int[] array=new int[DIMENSION_MAXIMA_MATRIZ];
        for(int i=0; i<Sum_Horizontal.DIMENSION_MAXIMA_MATRIZ;i++){
            int sumTotal=0;
            for(int j=0; j<Sum_Horizontal.DIMENSION_MAXIMA_MATRIZ;j++){
                sumTotal+=PASCAL_MATRIZ[i][j];
            }
            array[i]=sumTotal;
        }
        return array;
    }

    public static int[] getValores() {
        return valores;
    }
}
