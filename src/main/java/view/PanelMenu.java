package view;

import java.awt.Graphics;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;

/**
 *
 * @author ChocoPops
 */
public class PanelMenu extends AbstractVue {
    
    private ListeTerrain listeTerrain; 
    
    /**
    * Constructeur de la classe PanelMenu.
    * Initialise la liset des terrains.
    */
    public PanelMenu() {
        this.listeTerrain = new ListeTerrain(); 
    }
    
    /**
    * Methode pour dessiner toutes les elements importants dans le panel.
    */
    @Override
    public void paintComponent(final Graphics g) {
        for (int j = 0; j < listeTerrain.getListeSize(); j++) {
            Terrain terrain = listeTerrain.getTerrainById(j); 
            g.drawImage(terrain.getImage().getImage(), terrain.getX(), terrain.getY(), 
                    terrain.getLongueur(), terrain.getHauteur(), this); 
        }
    }
}
