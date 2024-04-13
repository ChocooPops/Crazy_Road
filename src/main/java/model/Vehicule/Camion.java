package model.Vehicule;

import java.util.Random;
import javax.swing.ImageIcon;
import model.DimensionFacteur;
import model.Personnage;


/**
 *
 * @author ChocoPops
 */
public final class Camion extends Vehicule {
    
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
        this.setVitesse(3);
        this.setType("Camion");
    }
    
    /**
    * Mettre une couleur aléatoire au véhicule.
    */
    @Override
    public void setRandomImage() {
        int nb = new Random().nextInt(3); 
        String src; 
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
    
    
    /**
    * Outrepasse la éthode collision de la classe véhicule.
    * Crée un collision particulière pour le Camion.
     * @param personnage
     * @return 
    */
    @Override
    public boolean collision(final Personnage personnage) {
        int newX = Math.round(5 * DimensionFacteur.getFacteur()); 
        int newY = 0; 
        int newVecY = Math.round(21 * DimensionFacteur.getFacteur());
        return this.getX() < personnage.getX() + -(newX * 2) + personnage.getLongueur()
                && this.getX() + this.getLongueur() > personnage.getX() + newX
                && this.getY() + newVecY < personnage.getY() + personnage.getHauteur() + newY
                && this.getY() + newVecY > personnage.getY() + newY;
    }
}
