package model.Terrain;

import javax.swing.ImageIcon;
import model.DimensionFacteur;

/**
 *
 * @author ChocoPops
 */
public abstract class Terrain {
    private int hauteur; 
    private int longueur; 
    private ImageIcon image; 
    private int x; 
    private int y; 
    
    /**
 *
 * constructeur de la classe Terrain.
 */
    public Terrain() {
        this.x = 0; 
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
    * Initialise l'image du terrain.
    * Appel des methodes pour initialiser la taille.
    */
    public void setImage(final ImageIcon image) {
        this.image = image; 
        setHauteur(); 
        setLongueur(); 
    }
    
    /**
    * Initialise la hauteur selon la taille du terrain.
    */
    public void setHauteur() {
        this.hauteur = Math.round(this.image.getIconHeight() * DimensionFacteur.getFacteur()); 
    }
    
    /**
    * Initialise la longueur selon la taille du terrain.
    */
    public void setLongueur() {
        this.longueur = Math.round(this.image.getIconWidth() * DimensionFacteur.getFacteur()); 
    }
    
    public void setY(final int y) {
        this.y = y; 
    }
}
