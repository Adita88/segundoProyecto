/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Bola;

/**
 *
 * @author David B
 */
public class ControladorBolas {
    ArrayList<Bola> bolas;

    public ControladorBolas() {
        bolas= new ArrayList<>();
    }

    public ControladorBolas(ArrayList<Bola> bolas) {
        this.bolas = bolas;
    }
    
    public synchronized void generarSimulacion(int cantBolas, int probIzquierda, boolean velocidad, int cantidadFilas){
        for(int i=0; i<cantBolas; i++){
            Bola temp= new Bola(probIzquierda,velocidad,cantidadFilas);
            temp.start();
//            try {
//                temp.wait(5000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ControladorBolas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            temp.notify();
        }
            
    }
    
}
