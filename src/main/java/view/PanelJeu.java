package view;

import java.awt.Graphics;
import model.Personnage;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.Titre;
import model.Vehicule.Vehicule;

/**
 *
 * @author ChocoPops
 */
public class PanelJeu extends AbstractVue {
    private Titre titre; 
    
    /**
    * Constructeur de la classe PanelJeu.
    */
    public PanelJeu(final ListeTerrain listeTerrain) {
        this.setListeTerrain(listeTerrain);
        this.setPersonnage(Personnage.getPersonnage());
        this.titre = new Titre();
        this.setFocusable(true);
    }
    
    
    @Override
    public void update() {
        this.repaint(); 
    }
    
    /**
    * Methode pour dessiner toutes les elements importants dans le panel.
    */
    @Override
    public void paintComponent(final Graphics g) {
        for (int i = 0; i < this.getListeTerrain().getListeSize(); i++) {
            Terrain terrain = this.getListeTerrain().
                    getTerrainById(this.getListeTerrain().
                            getListeSize() - i - 1); 
            g.drawImage(terrain.getImage().getImage(), terrain.getX(), terrain.getY(), 
                    terrain.getLongueur(), terrain.getHauteur(), this);  
            if (terrain.getType().equals("Route")) { 
                for (Vehicule vec : terrain.getListeVehicule()) {
                    g.drawImage(vec.getImage().getImage(), vec.getX(), vec.getY(), 
                         vec.getLongueur(), vec.getHauteur(), this);
                }
            }
        }
        g.drawImage(this.getPersonnage().getImage().getImage(), 
                this.getPersonnage().getX(), this.getPersonnage().getY(), 
                this.getPersonnage().getLongueur(), this.getPersonnage().getHauteur(), this); 
    }
    
}
