package model;

import javax.swing.ImageIcon;

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
    private int direction;

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
    public ImageIcon getImage() {
        return this.image;
    }

    public void setX(final int x) {
        this.x = x;
    }
    public void setY(final int y) {
        this.y = y;
    }

    public void setDirection(final int direction) {
        this.direction = direction;
    }

    /**
     *
     * Recupérer le personnage s'il est déjà créer ou le creer.
     */
    public static Personnage getPersonnage() {
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
        if (this.x + Math.round(18.4 * DimensionFacteur.getFacteur())
                < DimensionFacteur.getLongueurFenetre()) {
            this.x += Math.round(18.4 * DimensionFacteur.getFacteur());
        }
    }

    /**
     *
     */
    public void keyLeft() {
        if (this.x - Math.round(18.4 * DimensionFacteur.getFacteur()) >= 0) {
            this.x -= Math.round(18.4 * DimensionFacteur.getFacteur());
        }
    }

    /**
     *
     */
    public void keyUp() {
        if (this.y - Math.round((242 / 12) * DimensionFacteur.getFacteur()) > 0) {
            this.y -= Math.round((242 / 12) * DimensionFacteur.getFacteur());
        }
    }

    /**
     *
     */
    public void keyDown() {
        if (this.y + Math.round((242 / 12) * DimensionFacteur.getFacteur())
                < DimensionFacteur.getHauteurFenetre()) {
            this.y += Math.round((242 / 12) * DimensionFacteur.getFacteur());
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
     *
     * @param op
     */
    public void setKeyPressed(final boolean op) {
        if (this.keyIsPressed != op) {
            this.keyIsPressed = op;
        }
    }

    public int getDirection() {
        return this.direction;
    }
}
