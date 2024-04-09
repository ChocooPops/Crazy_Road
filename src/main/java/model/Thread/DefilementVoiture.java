package model.Thread;

import model.Personnage;
import model.Terrain.Terrain;
import view.AbstractVue;

/**
 *
 * @author ChocoPops
 */
public class DefilementVoiture extends AbstractThread {

    
    /**
    * Constructeur de la classe Timer qui observe le panel.Se rafraichit toutes les 60 frames. 
    * Fait deplacer les voitures du panel.
    * @param panel
    */
    public DefilementVoiture(final AbstractVue panel) {
        super(panel); 
        this.addObserver(this.getPanel());
    }
    
    /**
    * Definit le deroulement du deplacement des voitures dans le thread. 
    */
    public void deroulement() {
        Personnage.getPersonnage().actionBouton();
        for (Terrain terrain : this.getPanel().getListeTerrain().getListeTerrain()) {
            terrain.deplacerVoiture();
        }
        notifyAllObservers(); 
    }
    
 
}
