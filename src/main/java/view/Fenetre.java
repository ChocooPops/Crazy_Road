package view;

import javax.swing.JFrame;

/**
 *
 * @author ChocoPops
 */
public final class Fenetre extends JFrame {
    
    private static Fenetre fenetre; 
    /**
    * Constructeur de la classe Fenetre.
    * Initialise les informations importantes de l'ecran.
    */
    private Fenetre() {
       
    }
    
    /**
    *
    * Afficher l'ecran static.  
    */
    public void afficherFenetre() {
        if (Fenetre.fenetre != null) {
            Fenetre.fenetre.setVisible(true);
        }
    }
    
    /**
    *
    * Singleton de la variable static Fenetre. 
    */
    public static Fenetre getFenetre() {
        if (Fenetre.fenetre == null) {
            Fenetre.fenetre = new Fenetre(); 
            Fenetre.fenetre.setTitle("Crazy Road");
            Fenetre.fenetre.getContentPane().add(new PanelMenu()); 
            Fenetre.fenetre.pack();
            Fenetre.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Fenetre.fenetre.setResizable(false);
            Fenetre.fenetre.setLocationRelativeTo(null);
        }
        return Fenetre.fenetre; 
    }
}
