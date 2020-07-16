/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David B
 */
public class Bola extends Thread{
    
    private static int probabilidadIzquierda;
    private static boolean dobleVelocidad;
    private static int cantidadFilas;
    private int numeroBucket;
    private int filaActual;
    private int columnaActual;

    public Bola(int probabilidadIzquierda, boolean dobleVelocidad,int tamMatriz) {
        this.numeroBucket = 0;
        this.filaActual = 0;
        Bola.probabilidadIzquierda=probabilidadIzquierda;
        Bola.dobleVelocidad=dobleVelocidad;
        Bola.cantidadFilas=tamMatriz;
    }
    
    private Bola() {
        this.numeroBucket = 0;
        this.filaActual = 0;
        Bola.probabilidadIzquierda=50;
        Bola.dobleVelocidad=false;
        cantidadFilas=10;
    }
    
    

    @Override
    public void run() {
        
        for(int i=0;i<=cantidadFilas;i++){
            int lado= decidirLado(); //0 Izq y 1 es Derecha
            moverBola(lado);

        }
        
        
                
    }
    
    /**
     * Método para mover la bola
     * @param lado  indica el lado al que se mueve
     */
    private void moverBola(int lado){ //0 a IZQ y 1 a Der
        numeroBucket+=lado;
        filaActual++;
        columnaActual+=lado;
        
        System.out.println("numeroBucket: "+numeroBucket+" filaActual: "+filaActual+" columnaActual: "+columnaActual);
        
        //System.out.println("modelo.Bola.moverBola()");
                
    }
    
    /**
     * Método que decide un lado
     * @return 
     */
    private int decidirLado(){
        if(Math.round(Math.random()*100)<probabilidadIzquierda)
            return 0;
        if(Math.round(Math.random()*100)>probabilidadIzquierda)
            return 1;
        return (int) ((Math.random()*100)%2);
        }
    
}
