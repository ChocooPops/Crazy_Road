package controller;

import model.Terrain.Terrain;
import view.AbstractVue;

/**
 * Classe ControllerVehicule.
 */
public class ControllerVehicule extends AbstractController {

    /**
    * Constructeur de la classe ControllerVehicule.
    * Gère le déplacement des véhicules.
     * @param panel
    */
    public ControllerVehicule(final AbstractVue panel) {
        super(panel);
        this.setThread();
    }

    @Override
    public void controller() {
        for (Terrain terrain : this.getPanel().getListeTerrain().getListeTerrain()) {
            terrain.deplacerVoiture();
        }
    }
}
