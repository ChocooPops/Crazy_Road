package model.Terrain;

import java.util.List;
import javax.swing.ImageIcon;
import model.DimensionFacteur;
import model.Vehicule.Vehicule;

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
    private String type; 
    
    /**
    *
    * Constructeur de la classe Terrain.
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
    public String getType() {
        return this.type; 
    }
    /**
    * Initialise l'image du terrain.Appel des methodes pour initialiser la taille.
     * @param image
    */
    public void setImage(final ImageIcon image) {
        this.image = image; 
        setHauteur(); 
        setLongueur(); 
    }
    
    public void setType(final String type) {
        this.type = type; 
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
    
    /**
    * Methode override par les classes filles.
    */
    public void addVehicule(final int y) {
    }; 
    public List<Vehicule> getListeVehicule() {
        return null; 
    }
}
