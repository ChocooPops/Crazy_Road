package model.Vehicule;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import model.DimensionFacteur;
import model.Personnage;

/**
 * Classe abstraite Vehicule.
 */
public abstract class Vehicule {
    
    private int hauteur; 
    private int longueur; 
    private int vitesse; 
    private ImageIcon image; 
    private int x; 
    private int y; 
    private int direction;
    private String type; 
    
    /**
    * Constructeur de la classe Vehicule.
     * @param x
     * @param y
     * @param direction
    */
    public Vehicule(final int x, final int y, final int direction) {
        this.y = y; 
        this.x = x; 
        this.direction = direction; 
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
    public String getType() {
        return this.type; 
    }
    public int getDirection() {
        return direction;
    }

    public void setX(final int x) {
        this.x = x;
    }
    public void setY(final int y) {
        this.y = y; 
    }
    public void setType(final String type) {
        this.type = type; 
    }
    public void setVitesse(final int vitesse) {
        this.vitesse = vitesse;
    }
    
    
    /**
    * Méthode qui instancie l'image du véhicule.
    * Change aussi les dimensions selon l'image.
     * @param image
    */
    public void setImage(final ImageIcon image) {
        this.image = image; 
        if (this.direction > 0) {
            flipImageIconHorizontally(this.image); 
        }
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
    
    /**
    * Effectuer un fli horizontale sur l'image.
     * @param icon
    */
    public void flipImageIconHorizontally(final ImageIcon icon) {
        Image newIcon = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(newIcon.getWidth(null), 
                newIcon.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) bufferedImage.getGraphics();
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-newIcon.getWidth(null), 0);
        g2d.setTransform(tx);
        g2d.drawImage(newIcon, 0, 0, null);
        g2d.dispose();

        this.image = new ImageIcon(bufferedImage);
    }  
    
    /**
    * Methode abstaite pour changer la couleur du véhicule.
    */
    public abstract void setRandomImage(); 
    
    /**
    * Fait descendre le véhicule.
    * @param vitesse
    */
    public void setDescenteVehicule(final int vitesse) {
        this.y += vitesse; 
    }
    
    /**
    * Méthode qui instancie l'image du véhicule.
     * @param personnage
     * @return 
    */
    public boolean collision(final Personnage personnage) {
        int newX = Math.round(5 * DimensionFacteur.getFacteur()); 
        int newY = 0; 
        return this.x < personnage.getX() + -(newX * 2) + personnage.getLongueur()
                && this.x + this.longueur > personnage.getX() + newX
                && this.y < personnage.getY() + personnage.getHauteur() + newY
                && this.y + this.hauteur > personnage.getY() + newY;
    }
}
