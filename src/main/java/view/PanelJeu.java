package view;

import java.awt.Graphics;
import model.Pause;
import model.Terrain.ListeTerrain;

/**
 * Classe PanelJeu.
 * Affiche toutes les informations nécessaires au jeu.
 */
public class PanelJeu extends AbstractVue {
  
    /**
    * Constructeur de la classe PanelJeu.
    * @param listeTerrain
    */
    public PanelJeu(final ListeTerrain listeTerrain) {
        this.setListeTerrain(listeTerrain);
        this.setPause(new Pause());
        this.getPersonnage().setListHitbox(this.getListeTerrain());
        this.getControllerPerso().startThread();
        this.getControllerPerso().controllerKeyPanel();
        this.getControllerMaps().startThread();
        this.getControllerVec().startThread();
        this.getControllerPause().controllerKeyPanel();
        this.getThreadRafraichissement().startRafraichissement();
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
        this.dessinerScore(g);
        this.dessinerPause(g);
    }
}
