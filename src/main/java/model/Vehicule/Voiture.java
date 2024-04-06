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
    public Voiture(final int y) {
        super(y); 
        this.setImage(new ImageIcon("src/main/resources/vehicule/voiture.png")); 
        setDirection(); 
    }
    
    
}
