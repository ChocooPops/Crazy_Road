package model.Thread;

import model.Terrain.Terrain;
import view.AbstractVue;

/**
 *
 * @author ChocoPops
 */
public class DefilementVoiture extends AbstractThread {

    
    /**
    * Constructeur de la classe Timer qui observe le panel.
    * Se rafraichit toutes les 60 frames. 
    * Fait deplacer les voitures du panel.
    */
    public DefilementVoiture(final AbstractVue panel) {
        this.setPanel(panel);
        this.addObserver(this.getPanel());
        this.getThread().start();
    }
    
    /**
    * Definit le deroulement du deplacement des voitures dans le thread. 
    */
    public void deroulement() {
        for (Terrain terrain : this.getPanel().getListeTerrain().getListeTerrain()) {
            terrain.deplacerVoiture();
        }
        notifyAllObservers(); 
    }
    
 
}
