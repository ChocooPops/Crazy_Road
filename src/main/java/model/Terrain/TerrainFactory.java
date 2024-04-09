package model.Terrain;

import java.util.Random;

/**
 *
 * @author ChocoPops
 */
public class TerrainFactory {
    
    private static int nbTerrainCreate = 0; 
    
    /**
    * constructeur de la classe.
    */
    public TerrainFactory() {
        
    }
    
    /**
    * Obtenir un terrain aleatoire.
    */
    public Terrain creationTerrain() {
        Terrain terrain = null; 
        if (TerrainFactory.nbTerrainCreate < 3) {
            terrain = new Champ(true); 
        } else {
            int nb = new Random().nextInt(10); 
            if (nb >= 6) {
                terrain = new Champ(false); 
            } else {
                terrain = new Route();
            }
        }
        TerrainFactory.nbTerrainCreate++; 
        return terrain; 
    }
}
