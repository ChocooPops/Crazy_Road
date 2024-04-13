package view;

import controller.AbstractController;
import controller.ControllerMaps;
import controller.ControllerPersonnage;
import controller.ControllerVehicule;
import javax.swing.JPanel;
import model.DimensionFacteur;
import model.Personnage;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.Vehicule.Vehicule;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import model.ThreadRafraichissement;

/**
 * Classe abstraite pour controler les différentes vues.
 */
public abstract class AbstractVue extends JPanel implements Observer {
    private int width = DimensionFacteur.getLongueurFenetre();
    private int height = DimensionFacteur.getHauteurFenetre();

    private ListeTerrain listeTerrain;
    private Personnage personnage;
    
    private ThreadRafraichissement thread; 
    private AbstractController controllerPerso; 
    private AbstractController controllerMaps; 
    private AbstractController controllerVec; 
    
    /**
    * Constructeur de la classe AbstractVue.
    * Initialise la taille du panel.
    */
    public AbstractVue() {
        this.setPreferredSize(new Dimension(this.width, this.height));
        this.personnage = Personnage.getPersonnage();
        this.personnage.setListHitbox(this.listeTerrain);
        this.controllerPerso = new ControllerPersonnage(this); 
        this.controllerMaps = new ControllerMaps(this); 
        this.controllerVec = new ControllerVehicule(this); 
        this.thread = new ThreadRafraichissement(this); 
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
 
    public AbstractController getControllerPerso() {
        return this.controllerPerso; 
    }
    public AbstractController getControllerMaps() {
        return this.controllerMaps; 
    }
    public AbstractController getControllerVec() {
        return this.controllerVec; 
    }
    public ThreadRafraichissement getThreadRafraichissement() {
        return this.thread; 
    }
    
    /**
    * Dessiner les terrains.
    * @param g
    */
    public void dessinerTerrain(final Graphics g) {
        for (int i = 0; i < this.getListeTerrain().getListeSize(); i++) {
            Terrain terrain = this.getListeTerrain().
                    getTerrainById(this.getListeTerrain().
                            getListeSize() - i - 1);
            g.drawImage(terrain.getImage().getImage(), terrain.getX(), terrain.getY(),
                    terrain.getLongueur(), terrain.getHauteur(), this);
        }
    }

    /**
    * Dessiner les véhicules.
     * @param g
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
    * Dessiner le personnage.
     * @param g
    */
    public void dessinerPersonnage(final Graphics g) {
        g.drawImage(this.getPersonnage().getImage().getImage(),
                this.getPersonnage().getX(), this.getPersonnage().getY(),
                this.getPersonnage().getLongueur(), this.getPersonnage().getHauteur(), this);
    }

    /**
     * Methode pour dessiner le score sur l'écran.
     */
    public void dessinerScore(final Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("impact", Font.BOLD, 20));
        g.drawString("Score : " + this.personnage.getScore(), 10, 20);
    }
}

