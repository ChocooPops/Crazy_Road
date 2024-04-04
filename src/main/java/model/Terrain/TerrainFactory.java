package model.Terrain;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author ChocoPops
 */
public class TerrainFactory {
    
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
        int nb = new Random().nextInt(10); 
        if (nb >= 6) {
            terrain = new Champ(); 
            terrain.setImage(new ImageIcon(setImageChamp()));
        } else {
            terrain = new Route(); 
            terrain.setImage(new ImageIcon("src/main/resources/terrain/route.png"));
        }
        return terrain; 
    }
    
    /**
    * Choisit une image du terrain parmis six images.
    */
    public String setImageChamp() {
        int nb = new Random().nextInt(6); 
        String src = ""; 
        switch (nb) {
            case 0 : src = "src/main/resources/terrain/terrain1.png"; 
                break; 
            case 1 : src = "src/main/resources/terrain/terrain2.png"; 
                break; 
            case 2 : src = "src/main/resources/terrain/terrain3.png"; 
                break; 
            case 3 : src = "src/main/resources/terrain/terrain4.png"; 
                break; 
            case 4 : src = "src/main/resources/terrain/terrain5.png"; 
                break;
            default : src = "src/main/resources/terrain/terrain6.png"; 
                break; 
        }
        return src; 
    }
}
