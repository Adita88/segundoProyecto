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
public class Simetria extends trianguloPascal{

    private Simetria() {
    }

    public static void dibujarTriangulo() {
        
        
        Simetria.pascalEstadoInicial();
        
        for(int i=0; i<Simetria.DIMENSION_MAXIMA_MATRIZ;i++)
            for(int j=0; j<Simetria.DIMENSION_MAXIMA_MATRIZ && j<=i;j++)
                if(PASCAL_MATRIZ[i][j]!=0){
                    if(j==Math.floor(i/2))
                        color[i][j]=ColoresRGB.getColorRGB(4);
                    if(j<Math.floor(i/2))
                        color[i][j]=ColoresRGB.getColorRGB(1);
                    if(j>Math.floor(i/2))
                        color[i][j]=ColoresRGB.getColorRGB(8);
                    
                }
    }

}
