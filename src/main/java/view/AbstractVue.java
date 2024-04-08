package view;

import controller.AbstractController;
import controller.ControllerPersonnage;
import java.awt.Dimension;
import javax.swing.JPanel;
import model.DimensionFacteur;

/**
 *
 * Classe abstraite pour controler les différentes vues. 
 */
public abstract class AbstractVue extends JPanel {
    private int width = DimensionFacteur.getLongueurFenetre(); 
    private int height = DimensionFacteur.getHauteurFenetre(); 
    
    /**
    * Constructeur de la classe AbstractVue.
    * Initialise la taille du panel.
    */
    public AbstractVue() {
        this.setPreferredSize(new Dimension(this.width, this.height));
        AbstractController control = new ControllerPersonnage(); 
        control.controller(this);
    }
}
