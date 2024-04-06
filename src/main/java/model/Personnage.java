package model;

import javax.swing.ImageIcon;

/**
 *
 * @author ChocoPops
 */
public final class Personnage {
    
    private int hauteur; 
    private int longueur; 
    private ImageIcon image; 
    private int x; 
    private int y; 
    private static Personnage personnage; 

    private Personnage() {

    }
    
    public int getHauteur() {
        return this.hauteur; 
    }
    public int getLongueur() {
        return this.longueur; 
    }
    public int getX() {
        return this.x; 
    }
    public int getY() {
        return this.y; 
    }
    public ImageIcon getImage() {
        return this.image; 
    }
    
    /**
 *
 * Recupérer le personnage s'il est déjà créer ou le creer.
 */
    public static Personnage getPersonnage() {
        if (Personnage.personnage == null) {
            float facteur = DimensionFacteur.getFacteur(); 
            Personnage.personnage = new Personnage(); 
            Personnage.personnage.image = new ImageIcon("src/main/resources/personnage/poule.png"); 
            Personnage.personnage.x = Math.round(92 * facteur); 
            Personnage.personnage.y = Math.round(1573 / 6 * facteur); 
            int largeur = Personnage.personnage.image.getIconWidth(); 
            int hauteur = Personnage.personnage.image.getIconHeight(); 
            Personnage.personnage.longueur = Math.round(facteur * largeur); 
            Personnage.personnage.hauteur = Math.round(facteur * hauteur); 
        }
        return Personnage.personnage; 
    }
}