package model.Terrain;

import java.util.ArrayList;
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
    private int vitesse = DimensionFacteur.getVitesseMap();
    
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
    public int getVitesse() {
        return this.vitesse; 
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
     * Fait descendre le terrain.
     */
    public void setDescenteTerrain() {
        this.y += this.vitesse; 
    }
    /**
     *
     * Methode override par les classes filles.
     * @param y
     */
    public void addCollision(final int y) {
    };

    /**
    * Methode override par les classes filles.
    */
    public void addVehicule(final int y) {
    }; 
    
    /**
    * Methode override par les classes filles.
    */
    public void deplacerVoiture() { }; 
    public List<Vehicule> getListeVehicule() {
        return null; 
    }

    /**
     * Methode override par les classes filles.Pour la liste des hitbox.
     * @return 
     */
    public abstract ArrayList<HitBox> getHitBoxes();
    
    /**
     * Methode override par les classes filles.Pour la liste des hitbox.
     */
    public abstract void setDescenteAllElementTerrain(); 
}
