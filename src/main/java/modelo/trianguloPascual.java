/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public class trianguloPascual {
    
    public static int factorial(int n){
        if (n == 0){
            return 1;
        } else {
            return (n * factorial(n-1));
        }
    }
    
    public static int formula(int x, int y){
        int formula = (factorial(x))/(factorial(y)*factorial(x-y));
        return formula;
    }
    
    public static int[][] crearMatriz(int cantFilas){
        
        int[][] matriz = new int[11][11];
        int k = 1;
        
        for(int i = 0; i < cantFilas; i++){
            //System.out.println(matriz[i]);
            for(int j = 0; j < k; j++){
                matriz[i][j] = formula(i, j);
            }
            k ++;
        }
        return matriz;
    }
   
    
    public static void triangulo(Graphics g, int x, int y, int ancho, int alto, int numFilas, int[][] matriz){
        int k = 1;
        int coordenadaX = x;
        int coordenadaY = y;
        
        for(int i = 0; i < numFilas; i++){
            
            for(int j = 0; j < k; j++){
                if(j != 0){       
                    if(i != 9){
                        coordenadaX += ancho * j + ancho/2;
                        g.drawRect(coordenadaX, coordenadaY, ancho, alto);
                        g.drawString(String.valueOf(matriz[i][j]), coordenadaX+12, coordenadaY+16);
                        coordenadaX -= ancho * j;
                    } else {
                        coordenadaX += ancho * j + ancho/2;
                        g.drawRect(coordenadaX, coordenadaY, ancho, alto);
                        g.drawString(String.valueOf(matriz[i][j]), coordenadaX+8, coordenadaY+18);
                        coordenadaX -= ancho * j;
                    }
                }else {
                    g.drawRect(coordenadaX, coordenadaY, ancho, alto);
                    g.drawString(String.valueOf(matriz[i][j]), coordenadaX+12, coordenadaY+16);
                }
                coordenadaX -= ancho/2;
                
            }  
            coordenadaY += alto;
            k ++;
        }
        
    }
}
