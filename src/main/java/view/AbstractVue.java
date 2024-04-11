package view;

import javax.swing.JPanel;
import model.DimensionFacteur;
import model.Personnage;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.Thread.DefilementVehicule;
import model.Vehicule.Vehicule;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import model.Thread.AbstractThread;
import model.Thread.ActionPersonnage;
import model.Thread.DefilementMaps;
import java.awt.Font;

/**
 * Classe abstraite pour controler les différentes vues.
 */
public abstract class AbstractVue extends JPanel implements Observer {
    private int width = DimensionFacteur.getLongueurFenetre();
    private int height = DimensionFacteur.getHauteurFenetre();

    private ListeTerrain listeTerrain;
    private Personnage personnage;
    private AbstractThread threadVehicule;
    private AbstractThread threadMaps;
    private AbstractThread threadActionPerso;
    
    /**
    * Constructeur de la classe AbstractVue.
    * Initialise la taille du panel.
    */
    public AbstractVue() {
        this.setPreferredSize(new Dimension(this.width, this.height));
        this.personnage = Personnage.getPersonnage();
        this.personnage.setListHitbox(this.listeTerrain);
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

    public AbstractThread getThreadVehicule() {
        return this.threadVehicule;
    }
    public AbstractThread getThreadActionPerso() {
        return this.threadActionPerso;
    }
    public AbstractThread getThreadMaps() {
        return this.threadMaps;
    }

    /**
    * Instancier le thread responsable du defilement des véhicules.
    */
    public void setThreadVehicule() {
        this.threadVehicule = new DefilementVehicule(this); 
    }
    /**
    * Instancier le thread responsable des actions du personnages.
    */
    public void setThreadActionPerso() {
        this.threadActionPerso = new ActionPersonnage(this, this.getThreadMaps()); 
    }
    /**
    * Instancier le thread responsable du defilement de la Map.
    */
    public void setThreadMaps() {
        this.threadMaps = new DefilementMaps(this); 
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

