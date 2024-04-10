package model.Thread;

import model.Personnage;
import model.Terrain.Terrain;
import view.AbstractVue;

/**
 * Classe DefilementVehicule.
 * Créer un thread responsbale des actions des Véhicules.
 */
public class DefilementVehicule extends AbstractThread {
    
    /**
    * Constructeur de la classe Timer qui observe le panel.Se rafraichit toutes les 60 frames. 
    * Fait deplacer les voitures du panel.
    * @param panel
    */
    public DefilementVehicule(final AbstractVue panel) {
        super(panel); 
        this.addObserver(this.getPanel());
    }
    
    /**
    * Definit le deroulement du deplacement des voitures dans le thread. 
    */
    @Override
    public void deroulement() {
        Personnage.getPersonnage().actionBouton();
        for (Terrain terrain : this.getPanel().getListeTerrain().getListeTerrain()) {
            terrain.deplacerVoiture();
        }
        Personnage.getPersonnage().checkCollisionVehicule(); 
        notifyAllObservers(); 
    }
}
