package controller;

import view.AbstractVue;
import view.Fenetre;

/**
 * Classe Controller du bouton jouer.
 */
public class ControllerBoutonJouer extends AbstractController {

    @Override
    public void controller(final AbstractVue panel) {
        panel.getTimerVoiture().setActivation(false);
        Fenetre.getFenetre().setEcranJeu(panel.getListeTerrain());
    }
    
}
