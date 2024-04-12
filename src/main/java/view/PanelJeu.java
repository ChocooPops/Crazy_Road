package view;

import controller.ControllerPersonnage;
import java.awt.Graphics;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import model.Terrain.ListeTerrain;
import model.Thread.AbstractThread;
import model.Titre;

/**
 * Classe PanelJeu.
 * Affiche toutes les informations nécessaires au jeu.
 */
public class PanelJeu extends AbstractVue {
    private Titre titre; 
    private AbstractThread threadDefilementMaps; 
    private AbstractThread threadDefilementVec; 
    private AbstractThread threadActionPerso; 
  
    /**
    * Constructeur de la classe PanelJeu.
    * @param listeTerrain
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     * @throws java.io.IOException
     * @throws javax.sound.sampled.LineUnavailableException
    */
    public PanelJeu(final ListeTerrain listeTerrain) throws UnsupportedAudioFileException, 
            IOException, LineUnavailableException{
        this.setListeTerrain(listeTerrain);
        this.titre = new Titre();
        new ControllerPersonnage().controller(this);
        this.getPersonnage().setListHitbox(this.getListeTerrain());
        this.setThreadVehicule();
        this.setThreadMaps();
        this.setThreadActionPerso();
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
        super.paintComponent(g);
        this.dessinerTerrain(g);
        this.dessinerPersonnage(g);
        this.dessinerVehicule(g);
        this.dessinerScore(g);
    }
}
