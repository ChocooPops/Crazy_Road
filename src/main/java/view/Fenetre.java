package view;

import javax.swing.JFrame;

/**
 *
 * @author ChocoPops
 */
public class Fenetre extends JFrame {
    
    
    /**
    * Constructeur de la classe Fenetre.
    * Initialise les informations importantes de l'ecran.
    */
    public Fenetre() {
        this.setTitle("Crazy Road");
        this.getContentPane().add(new PanelMenu()); 
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
