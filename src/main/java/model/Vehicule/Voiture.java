package model.Vehicule;

import java.util.Random;
import javax.swing.ImageIcon;


/**
 * Classe Voiture.
 */
public final class Voiture extends Vehicule {
    
    /**
    * Constructeur de la classe Voiture.
    * Definit son image.
    * @param x
     * @param y
     * @param direction
    */
    public Voiture(final int x, final int y, final int direction) {
        super(x, y, direction);
        this.setRandomImage();
        this.setVitesse(4);
        this.setType("Voiture");
    }
        
    /**
    * Mettre une couleur aléatoire au véhicule.
    */
    @Override
    public void setRandomImage() {
        int nb = new Random().nextInt(3); 
        String src; 
        switch (nb) {
            case 0 : src = "src/main/resources/vehicule/voitureVerte.png"; 
                break; 
            case 1 : src = "src/main/resources/vehicule/voitureViolette.png"; 
                break; 
            case 2 : src = "src/main/resources/vehicule/voiture.png"; 
                break; 
            default : src = "src/main/resources/vehicule/voiture.png"; 
                break; 
        }
        
        this.setImage(new ImageIcon(src)); 
    }
}
