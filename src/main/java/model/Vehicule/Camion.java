package model.Vehicule;

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
        this.setImage(new ImageIcon("src/main/resources/vehicule/camion.png")); 
        setDirection();
    }
}
