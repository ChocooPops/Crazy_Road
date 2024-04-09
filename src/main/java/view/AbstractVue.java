package view;

import javax.swing.JPanel;
import model.DimensionFacteur;
import model.Personnage;
import model.Terrain.HitBox;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.DefilementVoiture;
import model.Vehicule.Vehicule;

import java.awt.*;

/**
 * Classe abstraite pour controler les différentes vues.
 */
public abstract class AbstractVue extends JPanel implements Observer {
    private int width = DimensionFacteur.getLongueurFenetre();
    private int height = DimensionFacteur.getHauteurFenetre();

    private ListeTerrain listeTerrain;
    private Personnage personnage;
    private DefilementVoiture timerVoiture;

    /**
     * Constructeur de la classe AbstractVue.
     * Initialise la taille du panel.
     */
    public AbstractVue() {
        this.setPreferredSize(new Dimension(this.width, this.height));
        this.personnage = Personnage.getPersonnage();
    }

    public ListeTerrain getListeTerrain() {
        return this.listeTerrain;
    }

    public void setListeTerrain(final ListeTerrain liste) {
        this.listeTerrain = liste;
    }

    public void setPersonnage(final Personnage personnage) {
        this.personnage = personnage;
    }

    public Personnage getPersonnage() {
        return this.personnage;
    }

    public DefilementVoiture getTimerVoiture() {
        return this.timerVoiture;
    }

    /**
     * Instancier un nouveau timer.
     */
    public void setTimerVoiture() {
        this.timerVoiture = new DefilementVoiture(this);
    }

    /**
     * Dessiner les terrains.
     */
    public void dessinerTerrain(final Graphics g) {
        for (int i = 0; i < this.getListeTerrain().getListeSize(); i++) {
            Terrain terrain = this.getListeTerrain().
                    getTerrainById(this.getListeTerrain().
                            getListeSize() - i - 1);
            g.drawImage(terrain.getImage().getImage(), terrain.getX(), terrain.getY(),
                    terrain.getLongueur(), terrain.getHauteur(), this);
            if (terrain.getType().equals("Champ")) {
                for (HitBox hitBox : terrain.getHitBoxes()) {
                    g.setColor(Color.RED);
                    g.drawRect(hitBox.getX(), hitBox.getY(),
                            hitBox.getLongueur(), hitBox.getHauteur());
                }
            }
        }
    }

    /**
     * Dessiner les véhicules.
     */
    public void dessinerVehicule(final Graphics g) {
        for (int i = 0; i < this.getListeTerrain().getListeSize(); i++) {
            Terrain terrain = this.getListeTerrain().
                    getTerrainById(this.getListeTerrain().
                            getListeSize() - i - 1);
            if (terrain.getType().equals("Route")) {
                for (Vehicule vec : terrain.getListeVehicule()) {
                    g.drawImage(vec.getImage().getImage(), vec.getX(), vec.getY(),
                            vec.getLongueur(), vec.getHauteur(), this);
                }
            }
        }
    }

    /**
     *
     * Methode pour verifier les collisions si elles sont pénétrées.
     * @return un boolean pour savoir si il y a une collision.
     */
    public boolean verifierHitBox(final Graphics g) {
        for (Terrain terrain : this.getListeTerrain().getListeTerrain()) {
            if (terrain.getType().equals("Champ")) {
                for (HitBox hitBox : terrain.getHitBoxes()) {
                    if (hitBox.collision(personnage)) {
                        int direction = personnage.getDirection();

                        if (direction == 1) {
                            personnage.setX(hitBox.getX() + hitBox.getLongueur());
                        } else if (direction == 2) {
                            personnage.setY(hitBox.getY() + hitBox.getHauteur() + 4);
                        } else if (direction == 3) {
                            personnage.setY(hitBox.getY() - hitBox.getHauteur() - 4);
                        } else if (direction == 4) {
                            personnage.setX(hitBox.getX() - hitBox.getLongueur());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Dessiner le personnage.
     */
    public void dessinerPersonnage(final Graphics g) {
        g.drawImage(this.getPersonnage().getImage().getImage(),
                this.getPersonnage().getX(), this.getPersonnage().getY(),
                this.getPersonnage().getLongueur(), this.getPersonnage().getHauteur(), this);
    }

    public void dessinerScore(final Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("impact", Font.BOLD, 20));
        g.drawString("Score : " + this.personnage.getScore(), 10, 20);
    }
}

