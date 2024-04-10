package view;

import javax.swing.JFrame;
import model.Terrain.ListeTerrain;

/**
 *
 * @author ChocoPops
 */
public final class Fenetre extends JFrame {
    
    private AbstractVue panel; 
    private static Fenetre fenetre; 
    
    /**
    * Constructeur de la classe Fenetre.
    * Initialise les informations importantes de l'ecran.
    */
    private Fenetre() {
       this.setFocusable(false);
    }
    
    /**
    * Afficher l'ecran static.  
    */
    public void afficherFenetre() {
        if (Fenetre.fenetre != null) {
            Fenetre.fenetre.setVisible(true);
        }
    }
    
    /**
    * Singleton de la variable static Fenetre. 
     * @return 
    */
    public static synchronized Fenetre getFenetre() {
        if (Fenetre.fenetre == null) {
            Fenetre.fenetre = new Fenetre(); 
            Fenetre.fenetre.setTitle("Crazy Road");
            Fenetre.fenetre.panel = new PanelMenu(); 
            Fenetre.fenetre.getContentPane().add(Fenetre.fenetre.panel); 
            Fenetre.fenetre.pack();
            Fenetre.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Fenetre.fenetre.setResizable(false);
            Fenetre.fenetre.setLocationRelativeTo(null);
        }
        return Fenetre.fenetre; 
    }
    
    /**
    * Changement d'écran vers l'écran jeu. 
     * @param listeTerrain
    */
    public void setEcranJeu(final ListeTerrain listeTerrain) {
        Fenetre.fenetre.panel = new PanelJeu(listeTerrain); 
        Fenetre.fenetre.getContentPane().removeAll(); 
        Fenetre.fenetre.getContentPane().add(Fenetre.fenetre.panel); 
        Fenetre.fenetre.revalidate();
        Fenetre.fenetre.repaint();
        Fenetre.fenetre.panel.setFocusable(true);
        Fenetre.fenetre.panel.requestFocus();
    }
    
    /**
    * Changement d'écran vers l'écran menu. 
    */
    public void setEcranMenu() {
        Fenetre.fenetre.panel = new PanelMenu(); 
        Fenetre.fenetre.getContentPane().removeAll(); 
        Fenetre.fenetre.getContentPane().add(Fenetre.fenetre.panel); 
        Fenetre.fenetre.revalidate();
        Fenetre.fenetre.repaint();
        Fenetre.fenetre.panel.setFocusable(false);
    }
}
