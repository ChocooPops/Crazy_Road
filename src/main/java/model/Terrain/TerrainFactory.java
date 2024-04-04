package model.Terrain;

import java.util.Random;

/**
 *
 * @author ChocoPops
 */
public class TerrainFactory {
    
    /**
 *
 * constructeur de la classe.
 */
    public TerrainFactory() {
        
    }
    
    /**
 *
 * Génère un terrain aléatoire.
 */
    public Terrain creationTerrain() {
        Terrain terrain = null; 
        int nb = new Random().nextInt(10); 
        if (nb >= 6) {
            terrain = new Champ(); 
        } else {
            terrain = new Route(); 
        }
        return terrain; 
    }
}
