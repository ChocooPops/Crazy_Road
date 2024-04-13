package view;

import java.awt.Graphics;
import model.Terrain.ListeTerrain;
import model.Titre;

/**
 * Classe PanelJeu.
 * Affiche toutes les informations nécessaires au jeu.
 */
public class PanelJeu extends AbstractVue {
    private Titre titre; 
  
    /**
    * Constructeur de la classe PanelJeu.
    * @param listeTerrain
    */
    public PanelJeu(final ListeTerrain listeTerrain) {
        this.setListeTerrain(listeTerrain);
        this.titre = new Titre();
        this.getPersonnage().setListHitbox(this.getListeTerrain());
        this.getControllerPerso().startThread();
        this.getControllerPerso().controllerActionPerso();
        this.getControllerMaps().startThread();
        this.getControllerVec().startThread();
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
    }
}
