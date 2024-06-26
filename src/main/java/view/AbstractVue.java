package view;

import controller.AbstractController;
import controller.ControllerMaps;
import controller.ControllerPause;
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
import model.Pause;
import model.Score;
import model.ThreadRafraichissement;

/**
 * Classe abstraite pour controler les différentes vues.
 */
public abstract class AbstractVue extends JPanel implements Observer {
    private int width = DimensionFacteur.getLongueurFenetre();
    private int height = DimensionFacteur.getHauteurFenetre();

    private ListeTerrain listeTerrain;
    private Personnage personnage;
    private Pause pause; 
    
    private ThreadRafraichissement thread; 
    private AbstractController controllerPerso; 
    private AbstractController controllerMaps; 
    private AbstractController controllerVec; 
    private AbstractController controllPause; 
    
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
        this.controllPause = new ControllerPause(this); 
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
    public void setPause(final Pause newPause) {
        this.pause = newPause; 
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
    public AbstractController getControllerPause() {
        return this.controllPause; 
    }
    public ThreadRafraichissement getThreadRafraichissement() {
        return this.thread; 
    }
    public Pause getPause() {
        return this.pause; 
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
      * @param g
     */
    public void dessinerScore(final Graphics g) {
        Score score = this.personnage.getScore(); 
        g.setColor(Color.black);
        g.setFont(new Font("impact", Font.BOLD, score.getTaille()));
        g.drawString("Score : " + score.getScore(), score.getX(), score.getY());
    }
    
    /**
    * Methode pour dessiner la forme de la sur l'écran.
     * @param g
    */
    public void dessinerPause(final Graphics g) {
         g.drawImage(this.pause.getImage().getImage(),
                this.pause.getX(), this.pause.getY(),
                this.pause.getLongueur(), this.pause.getHauteur(), this);
    }
    
}

