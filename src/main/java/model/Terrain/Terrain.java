package model.Terrain;

import javax.swing.ImageIcon;

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
}
