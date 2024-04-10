package model.Terrain;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import model.DimensionFacteur;

/**
 * Classe de le liste des Terrains.
 * S'occupe de la liste des terrains affichés sur l'écran.
 */
public class ListeTerrain {
    private List<Terrain> terrains = new CopyOnWriteArrayList<>();
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
        if (terrain.getType().equals("Champ")) {
            terrain.addCollision(y);
        }
        if (terrain.getType().equals("Route")) {
            terrain.addVehicule(y);
        }
        this.terrains.add(terrain); 
    }
    
    private void redifineMaxY() {
        this.maxY = this.terrains.get(this.getListeSize() - 1).getY(); 
    }
    
    /**
    * Obtenir la taille de la liste.
     * @return 
    */
    public int getListeSize() {
        return this.terrains.size(); 
    }
    
    /**
    * Obtenir une instance de la liste de type Terrain selon l'id.
     * @param id
     * @return 
    */
    public Terrain getTerrainById(final int id) {
        return terrains.get(id);
    }
    
    public List<Terrain> getListeTerrain() {
        return this.terrains; 
    }
    
    /**
     * Fait descendre tous les éléments possibles.
     */
    public void setDescenteAllElements() {
        for (Terrain terrain : this.getListeTerrain()) {
            terrain.setDescenteAllElementTerrain();
        }
        if (this.terrains.get(0).getY() > DimensionFacteur.getHauteurFenetre() + 40) {
            redifineMaxY(); 
            this.addTerrain();
            this.terrains.remove(0); 
        }
    }
}
