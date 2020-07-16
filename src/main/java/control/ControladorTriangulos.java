/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.*;



/**
 *
 * @author David B
 */
public class ControladorTriangulos {
    trianguloPascal pascal;
    ControladorBolas controladorBolas;

    public ControladorTriangulos() {
        pascal= new trianguloPascal();
        controladorBolas= new ControladorBolas();
    }

    public ControladorTriangulos(trianguloPascal pascal, ControladorBolas controladorBolas) {
        this.pascal = pascal;
        this.controladorBolas = controladorBolas;
    }
    
    public int getCantidadFilas(){
        return pascal.getCantFilasMostrables();
    }
    
    public void setCantidadFilas(int cantidadFilas){
        pascal.setCantFilasMostrables(cantidadFilas);
    }
    
    public int[][] getValores(){
        return pascal.getPASCAL_MATRIZ();
    }
    
    public ColoresRGB[][] getColores(){
        return trianguloPascal.getColor();
    }
    
    public void pascal(){
        trianguloPascal.pascalEstadoInicial();
    }
    
    public void diagonales(){
        Diagonales.dibujarTriangulo();
    }
    
    public int[] fibonacci(){
        Fibonacci.dibujarTriangulo();
        return Fibonacci.getValores();
    }
    
    public void parImpar(){
        Par_Impar.dibujarTriangulo();
    }
    
    public void simetria(){
        Simetria.dibujarTriangulo();
    }
    
    public int[] sumaHorizontal(){
        Sum_Horizontal.dibujarTriangulo();
        return Sum_Horizontal.getValores();
    }
    
    public int[] getVectorSumaHorizontal(){
        return Sum_Horizontal.getValores();
    }
    
    public int[] getVectorFibonacci(){
        return Fibonacci.getValores();
    }
    
    public void quitarColores(){
        trianguloPascal.pascalEstadoInicial();
    }

    public void generarSimulacion(int cantBolas, int probIzquierda, boolean velocidad, int cantidadFilas){
        controladorBolas.generarSimulacion( cantBolas,  probIzquierda,  velocidad,  cantidadFilas);
    }
}
