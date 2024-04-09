package view;

import controller.ControllerPersonnage;
import java.awt.Graphics;
import model.Terrain.ListeTerrain;
import model.Thread.DefilementMaps;
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
        this.getPersonnage().setListHitbox(this.getListeTerrain());
        new DefilementMaps(this); 
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
        super.paintComponent(g);
        this.dessinerTerrain(g);
        this.dessinerPersonnage(g);
        this.dessinerVehicule(g);
    }
}
