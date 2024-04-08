package model;

import javax.swing.ImageIcon;

/**
 *
 * Classe Titre.
 */
public class Titre {
    
    private int hauteur; 
    private int longueur; 
    private ImageIcon image; 
    private int x; 
    private int y; 
    private float facteur = DimensionFacteur.getFacteur(); 

    /**
    *
    * Constructeur de la classe Titre. 
    * Instancie l'image, la taille et les coordonées de l'image.
    */
    public Titre() {
        this.image = new ImageIcon("src/main/resources/titre/titre.png"); 
        this.hauteur = Math.round(this.image.getIconHeight() * facteur); 
        this.longueur = Math.round(this.image.getIconWidth() * facteur); 
        this.x = Math.round(22 * facteur); 
        this.y = Math.round(18 * facteur); 
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
