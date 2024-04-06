package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;

/**
 *
 * @author ChocoPops
 */
public class PanelMenu extends AbstractVue {
    
    private ListeTerrain listeTerrain; 
    private JButton btJouer; 
    
    /**
    * Constructeur de la classe PanelMenu.
    * Initialise la liset des terrains.
    */
    public PanelMenu() {
        this.listeTerrain = new ListeTerrain(); 
        btJouer = new JButton("Jouer");
        this.setLayout(new BorderLayout());
        this.add(btJouer, BorderLayout.SOUTH); 
    }
    
    /**
    * Methode pour dessiner toutes les elements importants dans le panel.
    */
    @Override
    public void paintComponent(final Graphics g) {
        for (int j = 0; j < listeTerrain.getListeSize(); j++) {
            Terrain terrain = listeTerrain.getTerrainById(j); 
            g.drawImage(terrain.getImage().getImage(), terrain.getX(), terrain.getY(), 
                    terrain.getLongueur(), terrain.getHauteur(), this); 
        }
    }
    
    public class EcouteurJouer {
        
        public EcouteurJouer() {
            btJouer.addMouseListener(new MouseAdapter(){
                
            });
        }
    }
}
