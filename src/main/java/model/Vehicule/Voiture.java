package model.Vehicule;

import javax.swing.ImageIcon;


/**
 *
 * @author ChocoPops
 */
public class Voiture extends Vehicule {
    private ImageIcon image; 
    
    /**
    * Constructeur de la classe Voiture.
    * Definit son image.
    */
    public Voiture(final int x, final int y, final int direction) {
        super(x, y, direction);
        this.setImage(new ImageIcon("src/main/resources/vehicule/voiture.png")); 
        setDirection(); 
    }
        
    
}
