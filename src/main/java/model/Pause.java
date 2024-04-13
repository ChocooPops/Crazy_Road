
package model;

import javax.swing.ImageIcon;

/**
 * Classe Pause.
 */
public class Pause {
    
    private ImageIcon image; 
    private ImageIcon imageStart; 
    private ImageIcon imageStop;
    private int hauteur;
    private int longueur;
    private int x; 
    private int y;
    private boolean etat;
    
    /**
    * Constructeur de la classe ControllerPause.
    */
    public Pause() {
        this.imageStart = new ImageIcon("src/main/resources/pause/start.png"); 
        this.imageStop = new ImageIcon("src/main/resources/pause/stop.png"); 
        this.image = this.imageStart; 
        this.hauteur = DimensionFacteur.transformNbByFactor(this.image.getIconHeight()); 
        this.longueur = DimensionFacteur.transformNbByFactor(this.image.getIconWidth()); 
        this.x = DimensionFacteur.transformNbByFactor(184); 
        this.y = DimensionFacteur.transformNbByFactor(5); 
        this.etat = false;  
    }
    
    public int getX() {
        return this.x; 
    }
    public int getY() {
        return this.y; 
    }
    public int getHauteur() {
        return this.hauteur; 
    }
    public int getLongueur() {
        return this.longueur; 
    }
    public boolean getEtat() {
        return this.etat; 
    }
    public ImageIcon getImage() {
        return this.image; 
    }
    
    /**
    * Changer l'image de la pause pour l'image start.
    */
    public void setImageStart() {
        this.image = this.imageStart;
    }
    
    /**
    * Changer l'image de la pause pour l'image stop.
    */
    public void setImageStop() {
        this.image = this.imageStop;
    }
    
    /**
    * Changer l'etat de la pause.
    * Savoir si le jeu est lancé ou mis en pause
     * @param newEtat
    */
    public void setEtat(final boolean newEtat) {
        this.etat = newEtat; 
    }
}
