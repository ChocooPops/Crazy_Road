package model.Thread;

import model.Personnage;
import view.AbstractVue;

/**
 * Classe DefilementMaps.
 * Créer un thread responsbale des actions de la Maps.
 */
public class DefilementMaps extends AbstractThread {

    /**
     * Constucteur de la classe Defilement.
     * @param panel
     */
    public DefilementMaps(final AbstractVue panel) {
        super(panel); 
        
    }
    
    @Override
    public void deroulement() {
        this.getPanel().getListeTerrain().setDescenteAllElements();
        Personnage.getPersonnage().setDescente();
    }
}
