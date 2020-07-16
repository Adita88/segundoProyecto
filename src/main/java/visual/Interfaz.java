/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import modelo.*;

/**
 *
 * @author Usuario
 */
public class Interfaz {

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
////        System.out.println(modelo.trianguloPascual.factorial(5));
////        System.out.println(modelo.trianguloPascual.formula(5, 3));
////        System.out.println(modelo.trianguloPascual.crearMatriz(5));
////        System.out.println(modelo.trianguloPascual.crearMatriz(10));
//        trianguloPascal prueba = new trianguloPascal();
//        
//        prueba.dibujarTriangulo(1);
//        
//        System.out.println(prueba.toString());
//        
//        
//        
//    }
    
    public static void main(String[] args) {

    final JFrame frame = new JFrame("Test");
    frame.setLayout(new GridLayout(0, 1));

    frame.add(new JButton(new AbstractAction("Click to add") {
        public void actionPerformed(ActionEvent e) {

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.add(new JLabel("Bla"));
                    frame.validate();
                    frame.repaint();
                }
            });
        }
    }));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    SwingUtilities.invokeLater(new Runnable() {
        @Override public void run() {
            frame.setVisible(true);
        }
    });
}
    
}
