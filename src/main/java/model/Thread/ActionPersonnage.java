
package model.Thread;

import model.Terrain.TerrainFactory;
import view.AbstractVue;
import view.Fenetre;

/**
 * Classe ActionPersonnage.
 */
public class ActionPersonnage extends AbstractThread {

    private AbstractThread threadMaps; 
    
    /**
    * Constructeur de la classe ActionPersonnage.
     * @param panel
     * @param threadMaps
    */
    public ActionPersonnage(final AbstractVue panel, final AbstractThread threadMaps) {
        super(panel);
        this.threadMaps = threadMaps;
    }

    @Override
    public void deroulement() {
        this.getPersonnage().actionBouton();
        this.getPersonnage().checkCollisionVehicule();
        this.getPersonnage().setGameOver();
        if (this.getPersonnage().horsEcran()) {
            this.setActivation(false);
            this.threadMaps.setActivation(false);
            this.getPersonnage().reinitilisation();
            TerrainFactory.reinitialisationCount();
            Fenetre.getFenetre().setEcranMenu();
        }
    }
}
