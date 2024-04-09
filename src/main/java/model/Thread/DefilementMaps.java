package model.Thread;

import model.Personnage;
import view.AbstractVue;

/**
 *
 * @author ChocoPops
 */
public class DefilementMaps extends AbstractThread {

    /**
     *
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
