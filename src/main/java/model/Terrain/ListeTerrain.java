package model.Terrain;

import java.util.ArrayList;
import java.util.List;
import model.DimensionFacteur;

/**
 *
 * @author ChocoPops
 */
public class ListeTerrain {
    private List<Terrain> terrains = new ArrayList<>(); 
    
    /**
    * Consructeur de la ListeTerrain.
    * Initialise les nombres d'objets Terrain dans la liste.
    * Initialise automatiquement leur coordonnees et leur taille.
    */
    public ListeTerrain() {
        this.setListeTerrain();
    }
    
    private void setListeTerrain() {
        int oldY = DimensionFacteur.getHauteurFenetre();
        for (int i = 0; i < 20; i++) {
            terrains.add(new TerrainFactory().creationTerrain()); 
            int y = oldY - terrains.get(i).getHauteur(); 
            terrains.get(i).setY(y);
            oldY = terrains.get(i).getY(); 
        }
    }
    
    /**
    * Obtenir la taille de la liste.
    */
    public int getListeSize() {
        return this.terrains.size(); 
    }
    
    /**
    * Obtenir une instance de la liste de type Terrain selon l'id.
    */
    public Terrain getTerrainById(final int id) {
        return terrains.get(id);
    }
}
