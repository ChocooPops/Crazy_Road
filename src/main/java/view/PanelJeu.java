package view;

import controller.ControllerPersonnage;
import java.awt.Graphics;
import model.AnimationMort;
import model.Terrain.ListeTerrain;
import model.Titre;

/**
 *
 * @author ChocoPops
 */
public class PanelJeu extends AbstractVue {
    private Titre titre; 
    
    /**
    * Constructeur de la classe PanelJeu.
    */
    public PanelJeu(final ListeTerrain listeTerrain) {
        this.setListeTerrain(listeTerrain);
        this.titre = new Titre();
        this.setTimerVoiture(); 
        new ControllerPersonnage().controller(this); 
        
        new AnimationMort();
    }
    
    @Override
    public void update() {
        this.repaint(); 
    }
    
    /**
    * Methode pour dessiner toutes les elements importants dans le panel.
    */
    @Override
    public void paintComponent(final Graphics g) {
        this.dessinerTerrain(g);
        this.dessinerPersonnage(g);
        this.dessinerVehicule(g);
        this.verifierHitBox(g);
    }
}
