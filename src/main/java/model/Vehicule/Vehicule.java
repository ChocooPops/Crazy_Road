package model.Vehicule;

import javax.swing.ImageIcon;

/**
 *
 * @author ChocoPops
 */
public abstract class Vehicule {
    
    private int hauteur; 
    private int longueur; 
    private int vitesse; 
    private ImageIcon image; 
    private int x; 
    private int y; 
    
    /**
 *
 * Constructeur de la classe.
 */
    public Vehicule() {
        
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
    public int getVitesse() {
        return this.vitesse; 
    }
    
}
