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
            Personnage.personnage = new Personnage(); 
        }
        return Personnage.personnage; 
    }
}
