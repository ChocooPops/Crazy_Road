package view;

import javax.swing.JFrame;
import model.AudioPlayer;
import model.Terrain.ListeTerrain;

/**
 * Classe de la Fenetre.  
 */
public final class Fenetre extends JFrame {
    
    private AbstractVue panel; 
    private static Fenetre fenetre; 
    private AudioPlayer audio; 
    
    /**
    * Constructeur de la classe Fenetre.
    * Initialise les informations importantes de l'ecran.
    */
    private Fenetre() {
       this.setFocusable(false);
       this.audio = new AudioPlayer();
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
            Fenetre.fenetre.audio.playMusic();
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
        this.audio.playMusic();
    }
    
    /**
    * Arreter la music principale.
    */
    public void stopMusic() {
        this.audio.stopMusic();
    }
}
