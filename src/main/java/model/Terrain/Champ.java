package model.Terrain;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author ChocoPops
 */
public class Champ extends Terrain {
    
    /**
    * Instancie le type de terrain "Champ" et son image.
    */
    public Champ() {
        this.setImage(new ImageIcon(this.setImageChamp()));
        this.setType("Champ");
    }
    
    /**
   * Choisit une image du terrain parmis six images.
   */
    private String setImageChamp() {
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
