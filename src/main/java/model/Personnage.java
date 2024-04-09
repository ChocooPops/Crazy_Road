package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import model.Terrain.HitBox;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;

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
    private int x;
    private int y;
    private ListeTerrain listeHitbox; 
    private int avancementX; 
    private int avancementY;
    private boolean keyDroite; 
    private boolean keyGauche; 
    private boolean keyHaut; 
    private boolean keyBas; 
    private boolean directionX; 
    
    /**
     * Constructeur de la classe Personnage.
     */
    public Personnage() {
        this.imageReleased = new ImageIcon("src/main/resources/personnage/poule.png"); 
        this.imagePressed = new ImageIcon("src/main/resources/personnage/poule2.png"); 
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
        this.listeHitbox = liste; 
    }
    public ImageIcon getImage() {
        return this.image;
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
     *
     * Recupérer le personnage s'il est déjà créer ou le creer.
     */
    public static synchronized Personnage getPersonnage() {
        if (Personnage.personnage == null) {
            float facteur = DimensionFacteur.getFacteur();
            Personnage.personnage = new Personnage();
            Personnage.personnage.image = Personnage.personnage.imageReleased; 
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
                this.keyDroite = true; 
            }
        }
    }

    /**
     *
     */
    public void keyLeft() {
        if (this.checkCollision(2)) {
            if (this.x - Math.round(18.4 * DimensionFacteur.getFacteur()) >= 0) {
                this.keyGauche = true; 
            }
        }
    }

    /**
     *
     */
    public void keyUp() {
        if (this.checkCollision(3)) {
            if (this.y - Math.round((242 / 12) * DimensionFacteur.getFacteur()) > 0) {
                this.keyHaut = true; 
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
    * Effectuer un fli horizontale sur l'image. 
    */
    public void flipImageIconHorizontally() {
        this.directionX = true; 
        Image image = this.image.getImage();
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), 
                image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) bufferedImage.getGraphics();
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        g2d.setTransform(tx);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        this.image = new ImageIcon(bufferedImage);
    }  
}
