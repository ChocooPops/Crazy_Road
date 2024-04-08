package view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.DimensionFacteur;
import model.Personnage;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.TimerDefilementVoiture;
import model.Vehicule.Vehicule;

/**
 * Classe abstraite pour controler les différentes vues. 
 */
public abstract class AbstractVue extends JPanel implements Observer {
    private int width = DimensionFacteur.getLongueurFenetre(); 
    private int height = DimensionFacteur.getHauteurFenetre(); 
    
    private ListeTerrain listeTerrain; 
    private Personnage personnage; 
    private TimerDefilementVoiture timerVoiture; 
    
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
    
    public TimerDefilementVoiture getTimerVoiture() {
        return this.timerVoiture; 
    }
    
    /**
    * Instancier un nouveau timer.
    */
    public void setTimerVoiture() {
        this.timerVoiture = new TimerDefilementVoiture(this); 
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
    * Dessiner le personnage.
    */
    public void dessinerPersonnage(final Graphics g) {
        g.drawImage(this.getPersonnage().getImage().getImage(), 
                this.getPersonnage().getX(), this.getPersonnage().getY(), 
                this.getPersonnage().getLongueur(), this.getPersonnage().getHauteur(), this);  
    }
}
