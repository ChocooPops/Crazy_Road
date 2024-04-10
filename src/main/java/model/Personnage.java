package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import model.Terrain.HitBox;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.Vehicule.Vehicule;

/**
 *
 * @author ChocoPops
 */
public final class Personnage {

    private static Personnage personnage;
    private int hauteur;
    private int longueur;
    private ImageIcon image;
    private ImageIcon imageReleased; 
    private ImageIcon imagePressed;
    private ImageIcon imageMort; 
    private int x;
    private int y;
    private int direction;

    private ListeTerrain listeTerrain; 
    private int avancementX; 
    private int avancementY;
    private boolean keyDroite; 
    private boolean keyGauche; 
    private boolean keyHaut; 
    private boolean keyBas; 
    private boolean directionX; 
    
    private int gravity; 
    private boolean jumpMort;
    
    /**
     * Constructeur de la classe Personnage.
     */
    public Personnage() {
        this.setGravity();
        this.imageReleased = new ImageIcon("src/main/resources/personnage/poule.png"); 
        this.imagePressed = new ImageIcon("src/main/resources/personnage/poule2.png"); 
        this.imageMort = new ImageIcon("src/main/resources/personnage/pouleMorte.png"); 
        this.avancementX = Math.round((92 / 5) * DimensionFacteur.getFacteur()); 
        this.avancementY = Math.round((242 / 12) * DimensionFacteur.getFacteur());
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
        this.listeTerrain = liste; 
    }
    public void setImage(final ImageIcon newImage) {
        this.image = newImage;
    }
    public void setJumpMort(final boolean jumpMort) {
        this.jumpMort = jumpMort;
    }
    
    /**
    * Change l'image du perso pur l'image de mort.
    */
    public void setImageMort() {
        this.image = this.imageMort;
    }
    
    /**
    * Initialise la vitesse gravité.
    */
    public void setGravity() {
        this.gravity = Math.round(5 * DimensionFacteur.getFacteur());
    }
    public ImageIcon getImage() {
        return this.image;
    }
    
    /**
     * Met à jour la position du personnage pour l'animation de mort.
    */
    public void setGameOver() {
        if (jumpMort) {
            this.y -= gravity;
            gravity--;
        } else {
            this.y += gravity;
            gravity++;
        }
        if (gravity == 0) {
            jumpMort = false;
        }    
    }

    public int getAvancementX() {
        return this.avancementX; 
    }
    public int getAvancementY() {
        return this.avancementY; 
    }
    public void setDirectionX(final boolean op) {
        this.directionX = op; 
    }
    
    /**
     * Recupérer le personnage s'il est déjà créer ou le creer.
     * @return 
     */
    public static synchronized Personnage getPersonnage() {
        if (Personnage.personnage == null) {
            float facteur = DimensionFacteur.getFacteur();
            Personnage.personnage = new Personnage();
            Personnage.personnage.image = Personnage.personnage.imageReleased; 
            Personnage.personnage.x = Math.round(92 * facteur);
            Personnage.personnage.y = Math.round(1573 / 6 * facteur);
            Personnage.personnage.setGravity();
            int largeur = Personnage.personnage.image.getIconWidth();
            int hauteur = Personnage.personnage.image.getIconHeight();
            Personnage.personnage.longueur = Math.round(facteur * largeur);
            Personnage.personnage.hauteur = Math.round(facteur * hauteur);
        }
        return Personnage.personnage;
    }

    /**
     * KeyRight => deplacement direction droite.
     */
    public void keyRight() {
        if (this.checkCollisionArbre(1)) {
            if (this.x + Math.round(18.4 * DimensionFacteur.getFacteur())
                < DimensionFacteur.getLongueurFenetre()) {
                this.keyDroite = true; 
            }
        }
    }

    /**
     * KeyLeft => deplacement direction gauche.
     */
    public void keyLeft() {
        if (this.checkCollisionArbre(2)) {
            if (this.x - Math.round(18.4 * DimensionFacteur.getFacteur()) >= 0) {
                this.keyGauche = true; 
            }
        }
    }

    /**
     * KeyUp => deplacement direction haut.
     */
    public void keyUp() {
        if (this.checkCollisionArbre(3)) {
            if (this.y - Math.round((242 / 12) * DimensionFacteur.getFacteur()) > 0) {
                this.keyHaut = true; 
            }
        }
    }

    /**
     * KeyDown => deplacement direction bas.
     */
    public void keyDown() {
        if (this.checkCollisionArbre(4)) {
            if (this.y + Math.round((242 / 12) * DimensionFacteur.getFacteur())
                < DimensionFacteur.getHauteurFenetre()) {
                this.keyBas = true; 
            }
        }
    }
    
    /**
     * Dit au personnage s'il peut avancer ou non selon sa clé.
     */
    public void actionBouton() {
        if (keyDroite) {
            this.x += this.avancementX; 
            this.keyDroite = false; 
        }
        if (keyGauche) {
            this.x -= this.avancementX; 
            this.keyGauche = false; 
        }
        if (keyBas) {
            this.y += this.avancementY;  
            this.keyBas = false; 
        }
        if (keyHaut) {
            this.y -= this.avancementY; 
            this.keyHaut = false; 
        }
    }
    
    /**
    * Check si le personnage rencontre la collision d'un arbre.
     * @param direction
     * @return 
    */
    public boolean checkCollisionArbre(final int direction) {
        boolean op = true; 
        if (this.listeTerrain != null) {
            for (Terrain terrain : this.listeTerrain.getListeTerrain()) {
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
    * Check si le personnage rencontre la collision d'un véhicule.
     * @return 
    */
    public boolean checkCollisionVehicule() {
        boolean op = true; 
        if (this.listeTerrain != null) {
            for (Terrain terrain : this.listeTerrain.getListeTerrain()) {
                if (terrain.getType().equals("Route")) {
                    for (Vehicule vec : terrain.getListeVehicule()) {
                        if (vec.collision(this)) {
                            op = false;
                        }
                    }  
                }
            }
        }
        return op; 
    }
    
    /**
     * Fait descendre le personnage.
     */
    public void setDescente() {
        this.y += DimensionFacteur.getVitesseMap(); 
    }
    
    /**
     * Changer l'image du perso pour une image avec un style pressé. 
     */
    public void setImagePressed() {
        this.image = this.imagePressed; 
        if (this.directionX) {
            this.flipImageIconHorizontally();
        }
    }
    /**
     * Changer l'image du perso pour une image avec un style relaché. 
     */
    public void setImageReleased() {
       this.image = this.imageReleased; 
       if (this.directionX) {
            this.flipImageIconHorizontally();
        }
    }
    
    /**
    * Effectuer un flip horizontale sur l'image. 
    */
    public void flipImageIconHorizontally() {
        this.directionX = true; 
        Image newIcon = this.image.getImage();
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
}
