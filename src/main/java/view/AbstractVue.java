package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import model.DimensionFacteur;
import model.Terrain.ListeTerrain;

/**
 *
 * Classe abstraite pour controler les différentes vues. 
 */
public abstract class AbstractVue extends JPanel implements Observer {
    private int width = DimensionFacteur.getLongueurFenetre(); 
    private int height = DimensionFacteur.getHauteurFenetre(); 
    
    private ListeTerrain listeTerrain; 
    
    /**
    * Constructeur de la classe AbstractVue.
    * Initialise la taille du panel.
    */
    public AbstractVue() {
        this.setPreferredSize(new Dimension(this.width, this.height));
    }
    
    public ListeTerrain getListeTerrain() {
        return this.listeTerrain; 
    }
    
    public void setListeTerrain(final ListeTerrain liste) {
        this.listeTerrain = liste; 
    }
}
