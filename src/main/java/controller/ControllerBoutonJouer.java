package controller;

import view.AbstractVue;
import view.Fenetre;

/**
 *
 * @author ChocoPops
 */
public class ControllerBoutonJouer extends AbstractController {

    @Override
    public void controller(final AbstractVue panel) {
        panel.getTimerVoiture().stopTimerDefilementVoiture();
        Fenetre.getFenetre().setEcranJeu(panel.getListeTerrain());
    }
    
}
