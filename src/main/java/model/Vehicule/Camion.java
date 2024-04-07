package model.Vehicule;

import javax.swing.ImageIcon;


/**
 *
 * @author ChocoPops
 */
public class Camion extends Vehicule {
    
     /**
    * Constructeur de la classe Camion.
    * Definit son image.
    */
    public Camion(final int y) {
        super(y); 
        this.setImage(new ImageIcon("src/main/resources/vehicule/camion.png")); 
        setDirection();
    }
}
