
package controller;

import view.AbstractVue;

/**
 * @author ChocoPops
 */
public class ControllerMaps extends AbstractController {

    /**
    * Constructeur de la classe ControllerMaps.
    * Gère défilement de la maps.
     * @param panel
    */
    public ControllerMaps(final AbstractVue panel) {
        super(panel);
        this.setThread();
    }

    @Override
    protected void controller() {
        this.getPanel().getListeTerrain().setDescenteAllElements();
        this.getPerso().setDescente();
    }
}
