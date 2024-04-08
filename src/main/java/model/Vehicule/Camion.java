package model.Vehicule;

import java.util.Random;
import javax.swing.ImageIcon;
import model.DimensionFacteur;


/**
 *
 * @author ChocoPops
 */
public class Camion extends Vehicule {
    
     /**
    * Constructeur de la classe Camion.
    * Definit son image.
     * @param x
     * @param y
     * @param direction
    */
    public Camion(final int x, final int y, final int direction) {
        super(x, y, direction);
        int yy = y - Math.round(16 * DimensionFacteur.getFacteur()); 
        this.setY(yy);
        this.setRandomImage();
        setDirection();
        this.setVitesse(3);
    }
    
    public void setRandomImage(){
        int nb = new Random().nextInt(3); 
        String src = ""; 
        switch (nb) {
            case 0 : src = "src/main/resources/vehicule/camionOrange.png"; 
                break; 
            case 1 : src = "src/main/resources/vehicule/camionBleu.png"; 
                break; 
            case 2 : src = "src/main/resources/vehicule/camion.png"; 
                break; 
            default : src = "src/main/resources/vehicule/camion.png"; 
                break; 
        }
        
        this.setImage(new ImageIcon(src)); 
    }
}
