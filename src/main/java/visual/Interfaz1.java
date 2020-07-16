/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import control.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.ColoresRGB;

/**
 *
 * @author David B
 */
public class Interfaz1 extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz1
     */
    
    private static ControladorTriangulos controladorTringulos;
    private static final ArrayList<JToggleButton> listaBotonesToggle=new ArrayList<>();
    private static ArrayList<Component> listaOpcionesGalton;
    private static int probIzq=50;
    private static int probDer=50;
    private static final Rectangle tamEstandarEtiqueta = new Rectangle(30, 30);
    
            
    public Interfaz1() {
        initComponents();
        controladorTringulos= new ControladorTriangulos();
        inicializarListaOpcionesGalton();
        visibilidadOpcionesGalton(false);
        dibujarPascal();
        
    }
    
    private JLabel[][] generarMatrizLabels(boolean ... conIcono){
        
        boolean icono = conIcono.length > 0 ? conIcono[0] : false;
        
        
        JLabel[][] matrizLabels= new JLabel[controladorTringulos.getCantidadFilas()][controladorTringulos.getCantidadFilas()];
        
        int[][] valores= controladorTringulos.getValores();
        
        if(!icono)
            for(int fila=0; fila<controladorTringulos.getCantidadFilas(); fila++)
                for(int columna=0; columna<controladorTringulos.getCantidadFilas() && columna<=fila; columna++)
                    matrizLabels[fila][columna]= new JLabel(""+valores[fila][columna]);
            
        else
            for(int fila=0; fila<controladorTringulos.getCantidadFilas(); fila++)
                for(int columna=0; columna<controladorTringulos.getCantidadFilas() && columna<=fila; columna++)
                    matrizLabels[fila][columna]= new JLabel("⚫");

        return matrizLabels;
    }
    
    
    private void dibujar(){
        if(!botonGalton.isSelected())
            dibujarPascal();
        else
            dibujarGalton();
    }
    
    private void dibujarGalton(){
        panelPrincipal.removeAll();
        JLabel[][] labels= generarMatrizLabels(true);
        
        ColoresRGB[][] colores= controladorTringulos.getColores();
        
        for(int fila=0; fila<controladorTringulos.getCantidadFilas(); fila++){
            int posicionX = ((panelPrincipal.getWidth()/2)-((tamEstandarEtiqueta.width/2)*fila));
            for(int columna=0; columna<controladorTringulos.getCantidadFilas() && columna<=fila; columna++){
                
                JLabel labelActual=labels[fila][columna];
                
                int posicionXactual=posicionX+tamEstandarEtiqueta.width*columna;
                int posicionY= 40+(tamEstandarEtiqueta.height*fila);
                labelActual.setBounds(posicionXactual, posicionY, tamEstandarEtiqueta.width, tamEstandarEtiqueta.height);
                //labelActual.setOpaque(true);
                
                ColoresRGB color= colores[fila][columna];
                
                labelActual.setForeground(Color.WHITE);
                
                labelActual.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                labelActual.setBackground(new Color(ColoresRGB.getCodigoColor(color)[0],
                        ColoresRGB.getCodigoColor(color)[1], ColoresRGB.getCodigoColor(color)[2]));
                panelPrincipal.add(labels[fila][columna]);
            }
        }
        
        dibujarBuckets();

        panelPrincipal.validate();
        panelPrincipal.repaint();
        
        
        
    }
    
    private JLabel[] generarBucketsLabels(){
        JLabel[] vectorLabels= new JLabel[controladorTringulos.getCantidadFilas()+1];        
        for(int i=0; i<controladorTringulos.getCantidadFilas()+1; i++)
            vectorLabels[i]= new JLabel("0");
        return vectorLabels;
    }
    
    private void dibujarBuckets(){
        
        JLabel[] bucketsLabels=generarBucketsLabels();
        
        int fila= controladorTringulos.getCantidadFilas();
        int posicionX = ((panelPrincipal.getWidth()/2)-((tamEstandarEtiqueta.width/2)*(fila)));
        int posicionY= (controladorTringulos.getMaximoFilas()+2)*tamEstandarEtiqueta.height;
        
        for(int columna=0; columna<controladorTringulos.getCantidadFilas()+1; columna++){
            int posicionXactual=posicionX+tamEstandarEtiqueta.width*columna;
            JLabel labelActual= bucketsLabels[columna];
            labelActual.setBounds(posicionXactual, posicionY, tamEstandarEtiqueta.width, tamEstandarEtiqueta.height);
            labelActual.setOpaque(true);
            
            ColoresRGB color= ColoresRGB.getColorRGB(columna);
            labelActual.setForeground(Color.WHITE);
            labelActual.setHorizontalAlignment((int) CENTER_ALIGNMENT);
            
            labelActual.setBackground(new Color(ColoresRGB.getCodigoColor(color)[0],
            ColoresRGB.getCodigoColor(color)[1], ColoresRGB.getCodigoColor(color)[2]));
            panelPrincipal.add(bucketsLabels[columna]);
        }
        panelPrincipal.validate();
        panelPrincipal.repaint();
    }
    
    private void dibujarPascal(){
        panelPrincipal.removeAll();
        
        JLabel[][] labels= generarMatrizLabels();
        
        ColoresRGB[][] colores= controladorTringulos.getColores();
        
        for(int fila=0; fila<controladorTringulos.getCantidadFilas(); fila++){
            int posicionX = ((panelPrincipal.getWidth()/2)-((tamEstandarEtiqueta.width/2)*fila));
            for(int columna=0; columna<controladorTringulos.getCantidadFilas() && columna<=fila; columna++){
                
                JLabel labelActual=labels[fila][columna];
                
                int posicionXactual=posicionX+tamEstandarEtiqueta.width*columna;
                int posicionY= 40+(tamEstandarEtiqueta.height*fila);
                labelActual.setBounds(posicionXactual, posicionY, tamEstandarEtiqueta.width, tamEstandarEtiqueta.height);
                labelActual.setOpaque(true);
                
                ColoresRGB color= colores[fila][columna];
                
                labelActual.setForeground(Color.WHITE);
                
                labelActual.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                labelActual.setBackground(new Color(ColoresRGB.getCodigoColor(color)[0],
                        ColoresRGB.getCodigoColor(color)[1], ColoresRGB.getCodigoColor(color)[2]));
                panelPrincipal.add(labels[fila][columna]);
            }
        }
        
        dibujarVector();

        panelPrincipal.validate();
        panelPrincipal.repaint();
        
        
    }
    
    private JLabel[] generarVectorLabels(int[] valoresVector){
        JLabel[] vectorLabels= new JLabel[controladorTringulos.getCantidadFilas()];        
        for(int i=0; i<controladorTringulos.getCantidadFilas(); i++)
            vectorLabels[i]= new JLabel(""+valoresVector[i]);
        return vectorLabels;
    }
    
    private void dibujarVector(){
        if(!botonSumasHorizontales.isSelected() && !botonFibonacci.isSelected()) return;
        
//         int[] vector;
        
//        if(botonSumasHorizontales.isSelected()) vector=controladorTringulos.getVectorSumaHorizontal();
//        else vector=controladorTringulos.getVectorFibonacci();
        
        int[] vector = botonSumasHorizontales.isSelected() ? vector=controladorTringulos.getVectorSumaHorizontal() : controladorTringulos.getVectorFibonacci();
            
        JLabel[] vectorLabels= generarVectorLabels(vector);
        
        for(int fila=0; fila<controladorTringulos.getCantidadFilas(); fila++){
            JLabel labelActual= vectorLabels[fila];
            int posicionXactual=20;
            int posicionY= 40+(tamEstandarEtiqueta.height*fila);
            labelActual.setBounds(posicionXactual, posicionY, tamEstandarEtiqueta.width, tamEstandarEtiqueta.height);
            labelActual.setOpaque(true);
                
            ColoresRGB color= ColoresRGB.getColorRGB(fila);
                
            labelActual.setForeground(Color.WHITE);
                
            labelActual.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
            labelActual.setBackground(new Color(ColoresRGB.getCodigoColor(color)[0],
            ColoresRGB.getCodigoColor(color)[1], ColoresRGB.getCodigoColor(color)[2]));
            panelPrincipal.add(vectorLabels[fila]);
        }
    
    }
    
    

    private void inicializarListaOpcionesGalton(){
        listaOpcionesGalton= new ArrayList<>();
        listaOpcionesGalton.add(text_separacionEspacios_Galton);
        listaOpcionesGalton.add(textProbabilidad_Galton);
        listaOpcionesGalton.add(botonEquiprobable_Galton);
        listaOpcionesGalton.add(sliderProbabilidad_Galton);
        listaOpcionesGalton.add(textIzquierda_Galton);
        listaOpcionesGalton.add(textoDerecha_Galton);
        listaOpcionesGalton.add(botonVelocidadDobre_Galton);
        listaOpcionesGalton.add(textCantidadBolas_Galton);
        listaOpcionesGalton.add(inputCantidadBolas_Galton);
        listaOpcionesGalton.add(botonAplicar_Galton);
        listaOpcionesGalton.add(textContadorProbabilidad);
    }
    
    private class  alPresionarToggleButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JToggleButton boton = (JToggleButton) actionEvent.getSource();
            
            casosToggleButton(boton);
            
            
            if(!listaBotonesToggle.contains(boton)) listaBotonesToggle.add(boton);
            for (JToggleButton jToggleButton : listaBotonesToggle){
                if(jToggleButton!=boton)
                    jToggleButton.setSelected(false);
            }
            visibilidadOpcionesGalton(botonGalton.isSelected());
            
            dibujar();
        } 
    }
    
    private void casosToggleButton(JToggleButton boton){
        if(!boton.getModel().isSelected()){
                textTituloVentana.setText("Triangulo de Pascal");
                controladorTringulos.pascal();
        }
        else{
            textTituloVentana.setText(boton.getText()); 
            if(boton==botonDiagonales) controladorTringulos.diagonales();
            else if(boton==botonFibonacci) controladorTringulos.fibonacci();
            //else if(boton==botonGalton) controladorTringulos.galton();
            else if(boton==botonParesImpares) controladorTringulos.parImpar();
            else if(boton==botonSimetria) controladorTringulos.simetria();
            else if(boton==botonSumasHorizontales) controladorTringulos.sumaHorizontal();
        }
    }
    
    private class  alPresionarSliderFilas implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider barra = (JSlider) e.getSource();
            controladorTringulos.setCantidadFilas(barra.getValue());
            textContadorCantidadFilas.setText(""+barra.getValue());
            dibujar();
        }
    }
    
        private class  alPresionarSliderProbabilidad implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider barra = (JSlider) e.getSource();
            int diferencia= (barra.getValue()-50);
            probIzq=(50+diferencia);
            probDer=(50-diferencia);
            textContadorProbabilidad.setText(probIzq+"/"+probDer);
            //System.out.println(barra.getValue());
        }
    }
    
    private void visibilidadOpcionesGalton(boolean encendido){
        listaOpcionesGalton.forEach((Component _item) -> {
            _item.setVisible(encendido);
            if(encendido){
                if(_item instanceof JFormattedTextField){
                    ((JFormattedTextField) _item).setText("");
                } else if(_item instanceof JSlider){
                    ((JSlider) _item).setValue(50);
                }
            }
        });
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        textTituloVentana = new javax.swing.JLabel();
        sliderCantidadFilas = new javax.swing.JSlider();
        textCantidadFilas = new javax.swing.JLabel();
        botonDiagonales = new javax.swing.JToggleButton();
        botonParesImpares = new javax.swing.JToggleButton();
        botonSumasHorizontales = new javax.swing.JToggleButton();
        botonSimetria = new javax.swing.JToggleButton();
        botonFibonacci = new javax.swing.JToggleButton();
        botonGalton = new javax.swing.JToggleButton();
        text_separacionEspacios_Galton = new javax.swing.JLabel();
        textProbabilidad_Galton = new javax.swing.JLabel();
        botonEquiprobable_Galton = new javax.swing.JButton();
        sliderProbabilidad_Galton = new javax.swing.JSlider();
        textIzquierda_Galton = new javax.swing.JLabel();
        textoDerecha_Galton = new javax.swing.JLabel();
        botonVelocidadDobre_Galton = new javax.swing.JToggleButton();
        textCantidadBolas_Galton = new javax.swing.JLabel();
        inputCantidadBolas_Galton = new javax.swing.JFormattedTextField();
        botonAplicar_Galton = new javax.swing.JButton();
        textContadorCantidadFilas = new javax.swing.JLabel();
        textContadorProbabilidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Triangulo de Pascal");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(937, 649));
        setResizable(false);

        panelPrincipal.setLayout(null);

        textTituloVentana.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        textTituloVentana.setForeground(new java.awt.Color(29, 53, 87));
        textTituloVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTituloVentana.setLabelFor(this);
        textTituloVentana.setText("Pascal");
        textTituloVentana.setFocusable(false);

        sliderCantidadFilas.setValue(100);
        sliderCantidadFilas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderCantidadFilas.setFocusable(false);
        sliderCantidadFilas.setMaximumSize(new java.awt.Dimension(200, 26));
        sliderCantidadFilas.setMinimumSize(new java.awt.Dimension(200, 26));
        sliderCantidadFilas.setMinimum(1);
        sliderCantidadFilas.setMaximum(10);
        sliderCantidadFilas.setValue(10);
        sliderCantidadFilas.addChangeListener(new alPresionarSliderFilas());

        textCantidadFilas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textCantidadFilas.setForeground(new java.awt.Color(29, 53, 87));
        textCantidadFilas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textCantidadFilas.setLabelFor(sliderCantidadFilas);
        textCantidadFilas.setText("Cantidad Filas:");
        textCantidadFilas.setFocusable(false);

        botonDiagonales.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonDiagonales.setText("Diagonales");
        botonDiagonales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonDiagonales.setFocusable(false);
        botonDiagonales.setMaximumSize(new java.awt.Dimension(189, 31));
        botonDiagonales.setMinimumSize(new java.awt.Dimension(189, 31));
        botonDiagonales.setPreferredSize(new java.awt.Dimension(189, 31));
        botonDiagonales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDiagonalesActionPerformed(evt);
            }
        });
        botonDiagonales.addActionListener(new alPresionarToggleButton());

        botonParesImpares.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonParesImpares.setText("Pares e Impares");
        botonParesImpares.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonParesImpares.setFocusable(false);
        botonParesImpares.setMaximumSize(new java.awt.Dimension(189, 31));
        botonParesImpares.setMinimumSize(new java.awt.Dimension(189, 31));
        botonParesImpares.setPreferredSize(new java.awt.Dimension(189, 31));
        botonParesImpares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonParesImparesActionPerformed(evt);
            }
        });
        botonParesImpares.addActionListener(new alPresionarToggleButton());

        botonSumasHorizontales.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonSumasHorizontales.setText("Sumas horizontales");
        botonSumasHorizontales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSumasHorizontales.setFocusable(false);
        botonSumasHorizontales.setMaximumSize(new java.awt.Dimension(189, 31));
        botonSumasHorizontales.setMinimumSize(new java.awt.Dimension(189, 31));
        botonSumasHorizontales.setPreferredSize(new java.awt.Dimension(189, 31));
        botonSumasHorizontales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSumasHorizontalesActionPerformed(evt);
            }
        });
        botonSumasHorizontales.addActionListener(new alPresionarToggleButton());

        botonSimetria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonSimetria.setText("Simetría");
        botonSimetria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSimetria.setFocusable(false);
        botonSimetria.setMaximumSize(new java.awt.Dimension(189, 31));
        botonSimetria.setMinimumSize(new java.awt.Dimension(189, 31));
        botonSimetria.setPreferredSize(new java.awt.Dimension(189, 31));
        botonSimetria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSimetriaActionPerformed(evt);
            }
        });
        botonSimetria.addActionListener(new alPresionarToggleButton());

        botonFibonacci.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonFibonacci.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonFibonacci.setFocusable(false);
        botonFibonacci.setLabel("Sucesión de Fibonacci");
        botonFibonacci.setMaximumSize(new java.awt.Dimension(189, 31));
        botonFibonacci.setMinimumSize(new java.awt.Dimension(189, 31));
        botonFibonacci.setPreferredSize(new java.awt.Dimension(189, 31));
        botonFibonacci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFibonacciActionPerformed(evt);
            }
        });
        botonFibonacci.addActionListener(new alPresionarToggleButton());

        botonGalton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonGalton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGalton.setFocusable(false);
        botonGalton.setLabel("Maquina de Galton");
        botonGalton.setMaximumSize(new java.awt.Dimension(189, 31));
        botonGalton.setMinimumSize(new java.awt.Dimension(189, 31));
        botonGalton.setPreferredSize(new java.awt.Dimension(189, 31));
        botonGalton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGaltonActionPerformed(evt);
            }
        });
        botonGalton.addActionListener(new alPresionarToggleButton());

        text_separacionEspacios_Galton.setForeground(new java.awt.Color(230, 57, 70));
        text_separacionEspacios_Galton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_separacionEspacios_Galton.setText("-----------------------------------------------");
        text_separacionEspacios_Galton.setFocusable(false);

        textProbabilidad_Galton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        textProbabilidad_Galton.setForeground(new java.awt.Color(29, 53, 87));
        textProbabilidad_Galton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textProbabilidad_Galton.setLabelFor(sliderProbabilidad_Galton);
        textProbabilidad_Galton.setText("Probabilidad:");
        textProbabilidad_Galton.setFocusable(false);

        botonEquiprobable_Galton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEquiprobable_Galton.setText("50/50");
        botonEquiprobable_Galton.setFocusable(false);
        botonEquiprobable_Galton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEquiprobable_GaltonActionPerformed(evt);
            }
        });

        sliderProbabilidad_Galton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderProbabilidad_Galton.setFocusable(false);
        sliderProbabilidad_Galton.setMaximumSize(new java.awt.Dimension(200, 26));
        sliderProbabilidad_Galton.setMinimumSize(new java.awt.Dimension(200, 26));
        sliderProbabilidad_Galton.addChangeListener(new alPresionarSliderProbabilidad());

        textIzquierda_Galton.setForeground(new java.awt.Color(102, 102, 102));
        textIzquierda_Galton.setLabelFor(sliderProbabilidad_Galton);
        textIzquierda_Galton.setText("Izquierda");
        textIzquierda_Galton.setFocusable(false);

        textoDerecha_Galton.setForeground(new java.awt.Color(102, 102, 102));
        textoDerecha_Galton.setLabelFor(sliderProbabilidad_Galton);
        textoDerecha_Galton.setText("Derecha");
        textoDerecha_Galton.setFocusable(false);

        botonVelocidadDobre_Galton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonVelocidadDobre_Galton.setText("Velocidad x2");
        botonVelocidadDobre_Galton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVelocidadDobre_Galton.setFocusable(false);
        botonVelocidadDobre_Galton.setMaximumSize(new java.awt.Dimension(189, 31));
        botonVelocidadDobre_Galton.setMinimumSize(new java.awt.Dimension(189, 31));
        botonVelocidadDobre_Galton.setPreferredSize(new java.awt.Dimension(189, 31));
        botonVelocidadDobre_Galton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVelocidadDobre_GaltonActionPerformed(evt);
            }
        });

        textCantidadBolas_Galton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        textCantidadBolas_Galton.setForeground(new java.awt.Color(29, 53, 87));
        textCantidadBolas_Galton.setLabelFor(inputCantidadBolas_Galton);
        textCantidadBolas_Galton.setText("Cantidad de bolas");

        try {
            inputCantidadBolas_Galton.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputCantidadBolas_Galton.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputCantidadBolas_Galton.setFocusable(false);
        inputCantidadBolas_Galton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inputCantidadBolas_Galton.setMaximumSize(new java.awt.Dimension(189, 31));
        inputCantidadBolas_Galton.setMinimumSize(new java.awt.Dimension(189, 31));
        inputCantidadBolas_Galton.setPreferredSize(new java.awt.Dimension(189, 31));
        inputCantidadBolas_Galton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCantidadBolas_GaltonActionPerformed(evt);
            }
        });

        botonAplicar_Galton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonAplicar_Galton.setText("Aplicar");
        botonAplicar_Galton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAplicar_Galton.setFocusable(false);
        botonAplicar_Galton.setMaximumSize(new java.awt.Dimension(67, 31));
        botonAplicar_Galton.setMinimumSize(new java.awt.Dimension(67, 31));
        botonAplicar_Galton.setPreferredSize(new java.awt.Dimension(67, 31));
        botonAplicar_Galton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAplicar_GaltonActionPerformed(evt);
            }
        });

        textContadorCantidadFilas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textContadorCantidadFilas.setForeground(new java.awt.Color(230, 57, 70));
        textContadorCantidadFilas.setText("10");

        textContadorProbabilidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textContadorProbabilidad.setForeground(new java.awt.Color(230, 57, 70));
        textContadorProbabilidad.setText("50/50");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textTituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sliderCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textContadorCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textCantidadBolas_Galton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(textIzquierda_Galton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textoDerecha_Galton))
                                    .addComponent(botonSumasHorizontales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonParesImpares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonDiagonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonSimetria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sliderProbabilidad_Galton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(botonGalton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonFibonacci, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonVelocidadDobre_Galton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(textProbabilidad_Galton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textContadorProbabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonEquiprobable_Galton))
                                    .addComponent(text_separacionEspacios_Galton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputCantidadBolas_Galton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(botonAplicar_Galton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCantidadFilas)
                            .addComponent(textContadorCantidadFilas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textTituloVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonDiagonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonParesImpares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonSumasHorizontales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonSimetria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonFibonacci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonGalton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_separacionEspacios_Galton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textProbabilidad_Galton)
                                .addComponent(textContadorProbabilidad))
                            .addComponent(botonEquiprobable_Galton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sliderProbabilidad_Galton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textIzquierda_Galton)
                            .addComponent(textoDerecha_Galton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonVelocidadDobre_Galton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textCantidadBolas_Galton)
                        .addGap(5, 5, 5)
                        .addComponent(inputCantidadBolas_Galton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAplicar_Galton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSumasHorizontalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumasHorizontalesActionPerformed
        
    }//GEN-LAST:event_botonSumasHorizontalesActionPerformed

    private void botonVelocidadDobre_GaltonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVelocidadDobre_GaltonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVelocidadDobre_GaltonActionPerformed

    private void inputCantidadBolas_GaltonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCantidadBolas_GaltonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCantidadBolas_GaltonActionPerformed

    private void botonGaltonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGaltonActionPerformed
        controladorTringulos.generarSimulacion(5, 50, false, 9);
    }//GEN-LAST:event_botonGaltonActionPerformed

    private void botonFibonacciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFibonacciActionPerformed
        
    }//GEN-LAST:event_botonFibonacciActionPerformed

    private void botonSimetriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSimetriaActionPerformed
        
    }//GEN-LAST:event_botonSimetriaActionPerformed

    private void botonParesImparesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonParesImparesActionPerformed
        
    }//GEN-LAST:event_botonParesImparesActionPerformed

    private void botonDiagonalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDiagonalesActionPerformed
        
    }//GEN-LAST:event_botonDiagonalesActionPerformed

    private void botonEquiprobable_GaltonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEquiprobable_GaltonActionPerformed
        probDer=probIzq=50;
        sliderProbabilidad_Galton.setValue(50);
        textContadorProbabilidad.setText("50/50");
    }//GEN-LAST:event_botonEquiprobable_GaltonActionPerformed

    private void botonAplicar_GaltonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAplicar_GaltonActionPerformed
        dibujar();
    }//GEN-LAST:event_botonAplicar_GaltonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAplicar_Galton;
    private javax.swing.JToggleButton botonDiagonales;
    private javax.swing.JButton botonEquiprobable_Galton;
    private javax.swing.JToggleButton botonFibonacci;
    private javax.swing.JToggleButton botonGalton;
    private javax.swing.JToggleButton botonParesImpares;
    private javax.swing.JToggleButton botonSimetria;
    private javax.swing.JToggleButton botonSumasHorizontales;
    private javax.swing.JToggleButton botonVelocidadDobre_Galton;
    private javax.swing.JFormattedTextField inputCantidadBolas_Galton;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JSlider sliderCantidadFilas;
    private javax.swing.JSlider sliderProbabilidad_Galton;
    private javax.swing.JLabel textCantidadBolas_Galton;
    private javax.swing.JLabel textCantidadFilas;
    private javax.swing.JLabel textContadorCantidadFilas;
    private javax.swing.JLabel textContadorProbabilidad;
    private javax.swing.JLabel textIzquierda_Galton;
    private javax.swing.JLabel textProbabilidad_Galton;
    private javax.swing.JLabel textTituloVentana;
    private javax.swing.JLabel text_separacionEspacios_Galton;
    private javax.swing.JLabel textoDerecha_Galton;
    // End of variables declaration//GEN-END:variables
}
