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
    private int maxY = DimensionFacteur.getHauteurFenetre();
    /**
    * Consructeur de la ListeTerrain.
    * Initialise les nombres d'objets Terrain dans la liste.
    * Initialise automatiquement leur coordonnees et leur taille.
    */
    public ListeTerrain() {
        this.setListeTerrain();
    }
    
    private void setListeTerrain() {
        for (int i = 0; i < 20; i++) {
            addTerrain(); 
        }
    }
    
    private void addTerrain() {
        Terrain terrain = new TerrainFactory().creationTerrain(); 
        int y = this.maxY - terrain.getHauteur(); 
        terrain.setY(y);
        this.maxY = terrain.getY(); 
        if (terrain.getType().equals("Route")) {
            int vehiculeY = maxY + Math.round(2 * DimensionFacteur.getFacteur());
            terrain.addVehicule(vehiculeY);
        }
        this.terrains.add(terrain); 
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
    
    public List<Terrain> getListeTerrain() {
        return this.terrains; 
    }
}
