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
public class Par_Impar extends trianguloPascal{

    private Par_Impar() {
    }

    
    public static  void dibujarTriangulo() {
        
        
        Par_Impar.pascalEstadoInicial();
        
        for(int i=0; i<Par_Impar.DIMENSION_MAXIMA_MATRIZ;i++)
            for(int j=0; j<Par_Impar.DIMENSION_MAXIMA_MATRIZ && j<=i;j++)
                if(PASCAL_MATRIZ[i][j]%2!=0)
                    color[i][j]=ColoresRGB.getColorRGB(6);
                else
                    color[i][j]=ColoresRGB.getColorRGB(2);
    }
    
}
