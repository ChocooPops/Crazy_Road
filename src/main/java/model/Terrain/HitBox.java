package model.Terrain;

import model.DimensionFacteur;
import model.Personnage;

/**
 * Classe HitBox.
 * Classe permettant de creer une hitbox pour les objets du jeu.
 */
public class HitBox {
    private int x;
    private int y;
    private int hauteur;
    private int longueur;
    private float facteur = DimensionFacteur.getFacteur();

    /**
    * Constructeur de la hitbox.
    * Instancie la taille et les coordonees de l'hitbox.
     * @param x
     * @param y
    */
    public HitBox(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.hauteur = Math.round(20 * facteur);
        this.longueur = Math.round(18 * facteur);
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

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public void setHauteur(final int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLongueur(final int longueur) {
        this.longueur = longueur;
    }

    /**
    * Check si le personnage rentrera en collision avec le perso.
     * @param personnage
     * @param direction
     * @return un boolean pour savoir si il y a une collision.
    */
    public boolean collision(final Personnage personnage, final int direction) {
        int newX = 0; 
        int newY = 0; 
        switch (direction) {
            case 1 : newX = personnage.getAvancementX(); //Right.
                break; 
            case 2 : newX = -personnage.getAvancementX(); //Left.
                break; 
            case 3 : newY = -personnage.getAvancementY(); //Up.
                break; 
            default : newY = personnage.getAvancementY(); //Down.
                break; 
        }
    
        return this.x < personnage.getX() + newX + personnage.getLongueur()
                && this.x + this.longueur > personnage.getX() + newX
                && this.y < personnage.getY() + personnage.getHauteur() + newY
                && this.y + this.hauteur > personnage.getY() + newY;
    }
    
    /**
    * Fait descendre la hitbox.
     * @param vitesse
    */
    public void setDescenteHitBox(final int vitesse) {
        this.y += vitesse; 
    }
}
