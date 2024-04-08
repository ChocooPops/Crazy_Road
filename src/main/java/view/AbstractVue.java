package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import model.DimensionFacteur;
import model.Personnage;
import model.Terrain.ListeTerrain;
import model.TimerDefilementVoiture;

/**
 *
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
}
