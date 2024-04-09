package model;

import javax.swing.ImageIcon;
import model.Terrain.HitBox;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;

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
    private boolean keyIsPressed;
    private ListeTerrain listeHitbox; 
    private int newX = Math.round((92 / 5) * DimensionFacteur.getFacteur()); 
    private int newY = Math.round((242 / 12) * DimensionFacteur.getFacteur());

    private Personnage() {
        this.keyIsPressed = false;
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
    public void setX(final int x) {
        this.x = x;
    }
    public void setY(final int y) {
        this.y = y;
    }
    public void setListHitbox(final ListeTerrain liste) {
        this.listeHitbox = liste; 
    }
    public ImageIcon getImage() {
        return this.image;
    }
    public int getAvancementX() {
        return this.newX; 
    }
    public int getAvancementY() {
        return this.newY; 
    }
    /**
     *
     * Recupérer le personnage s'il est déjà créer ou le creer.
     */
    public static synchronized Personnage getPersonnage() {
        if (Personnage.personnage == null) {
            float facteur = DimensionFacteur.getFacteur();
            Personnage.personnage = new Personnage();
            Personnage.personnage.image = new ImageIcon("src/main/resources/personnage/poule.png");
            Personnage.personnage.x = Math.round(92 * facteur);
            Personnage.personnage.y = Math.round(1573 / 6 * facteur);
            int largeur = Personnage.personnage.image.getIconWidth();
            int hauteur = Personnage.personnage.image.getIconHeight();
            Personnage.personnage.longueur = Math.round(facteur * largeur);
            Personnage.personnage.hauteur = Math.round(facteur * hauteur);
        }
        return Personnage.personnage;
    }

    /**
     *
     */
    public void keyRight() {
        if (this.checkCollision(1)) {
            if (this.x + Math.round(18.4 * DimensionFacteur.getFacteur())
                < DimensionFacteur.getLongueurFenetre()) {
                this.x += this.newX; 
            }
        }
    }

    /**
     *
     */
    public void keyLeft() {
        if (this.checkCollision(2)) {
            if (this.x - Math.round(18.4 * DimensionFacteur.getFacteur()) >= 0) {
                this.x -= this.newX;
            }
        }
    }

    /**
     *
     */
    public void keyUp() {
        if (this.checkCollision(3)) {
            if (this.y - Math.round((242 / 12) * DimensionFacteur.getFacteur()) > 0) {
                this.y -= this.newY; 
            }
        }
    }

    /**
     *
     */
    public void keyDown() {
        if (this.checkCollision(4)) {
            if (this.y + Math.round((242 / 12) * DimensionFacteur.getFacteur())
                < DimensionFacteur.getHauteurFenetre()) {
                this.y += this.newY; 
            }
        }
    }

    /**
     *
     * @return
     */
    public boolean keyIsPressed() {
        return this.keyIsPressed;
    }
    
    /**
    * Check si le personnage rencontre la collision d'un arbre. 
    */
    public boolean checkCollision(final int direction) {
        boolean op = true; 
        if (this.listeHitbox != null) {
            for (Terrain terrain : this.listeHitbox.getListeTerrain()) {
                if (terrain.getType().equals("Champ")) {
                   for (HitBox hitBox : terrain.getHitBoxes()) {
                     if (hitBox.collision(this, direction)) {
                         op = false; 
                     }
                 }  
                } 
               
            }
        }
        return op; 
    }

    /**
     *
     * @param op
     */
    public void setKeyPressed(final boolean op) {
        if (this.keyIsPressed != op) {
            this.keyIsPressed = op;
        }
    }
}
