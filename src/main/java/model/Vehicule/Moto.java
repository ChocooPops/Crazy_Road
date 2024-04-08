package model.Vehicule;

import java.util.Random;
import javax.swing.ImageIcon;
import model.DimensionFacteur;

/**
 *
 * @author p2203115
 */
public class Moto extends Vehicule{
    
    
    /**
    * Constructeur de la classe Voiture.
    * Definit son image.
    * @param x
     * @param y
     * @param direction
    */
    public Moto(final int x, final int y, final int direction) {
        super(x, y, direction);
        this.setRandomImage();
        setDirection(); 
        this.setVitesse(6);
    }
        
    public void setRandomImage(){
        int nb = new Random().nextInt(2); 
        String src = ""; 
        switch (nb) {
            case 0 : src = "src/main/resources/vehicule/moto.png"; 
                break; 
            case 1 : src = "src/main/resources/vehicule/motoMarron.png"; 
                break;
            default : src = "src/main/resources/vehicule/moto.png"; 
                break; 
        }
        
        this.setImage(new ImageIcon(src)); 
    }
}
