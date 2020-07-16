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
public class Diagonales extends trianguloPascal {

    private Diagonales() {
    }

    
    public static void dibujarTriangulo(){
        
        
        Diagonales.pascalEstadoInicial();
        
        for(int i=0; i<Diagonales.DIMENSION_MAXIMA_MATRIZ;i++)
            for(int j=0; j<Diagonales.DIMENSION_MAXIMA_MATRIZ && j<=i;j++)
//                if(PASCAL_MATRIZ[i][j]!=0)
                    color[i][j]=ColoresRGB.getColorRGB(j);
        
        
//        for(int i=0; i<cantFilasMostrables;i++){
//            for(int j=0; j<cantFilasMostrables;j++){
//                System.out.print(PASCAL_MATRIZ[i][j]+", ");
//            }
//            System.out.println("");
//        }
       
    }
    
    
}
