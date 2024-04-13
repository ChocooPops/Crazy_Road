package controller;

import view.AbstractVue;
import view.Fenetre;

/**
 * Classe Controller du bouton jouer.
 */
public class ControllerBoutonJouer extends AbstractController {

    /**
    * Constructeur de la classe ControllerBoutonJouer.
    * Gère le bouton Jouer du panel.
     * @param panel
    */
    public ControllerBoutonJouer(final AbstractVue panel) {
        super(panel);
    }

    @Override
    public void controller() {
        this.getPanel().getThreadRafraichissement().stopRafraichissement();
        this.getPanel().getControllerVec().stopThread();
        this.getPanel().getControllerVec().interrutpionThread();
        Fenetre.getFenetre().setEcranJeu(this.getPanel().getListeTerrain());
    }
}
