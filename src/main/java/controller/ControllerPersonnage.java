package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.AudioPlayer;
import model.Personnage;
import model.Terrain.TerrainFactory;
import view.AbstractVue;
import view.Fenetre;

/**
 *
 * Classe Controller qui control les deplacements du perso.
 */
public class ControllerPersonnage extends AbstractController {

    /**
    * Constructeur de la classe ControllerPersonnage.
    * Gère le déplacement et les interactions du personanage.
     * @param panel
    */
    public ControllerPersonnage(final AbstractVue panel) {
        super(panel); 
        this.setThread();
    }
    
    @Override
    public void controllerActionPerso() {
        Personnage perso = this.getPerso(); 
        this.getPanel().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent key) {
                if (!perso.isGameOver()) {
                    int code = key.getKeyCode(); 
                    if (code == KeyEvent.VK_RIGHT) {
                        perso.setDirectionX(true);
                    }
                    if (code == KeyEvent.VK_LEFT) {
                        perso.setDirectionX(false);
                    }
                    if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT
                        || code == KeyEvent.VK_DOWN || code == KeyEvent.VK_UP) {
                        perso.setImagePressed();
                    }
                }
            }
            
            @Override
            public void keyReleased(final KeyEvent key) {
                if (!perso.isGameOver()) {
                    switch (key.getKeyCode()) {
                        case KeyEvent.VK_RIGHT :
                            perso.keyRight();
                            perso.setImageReleased();
                            getAudio().playDeplacement();
                            break;
                        case KeyEvent.VK_LEFT :
                            perso.keyLeft();
                            perso.setImageReleased();
                            getAudio().playDeplacement();
                            break;
                        case KeyEvent.VK_UP :
                            perso.keyUp();
                            perso.setImageReleased();
                            getAudio().playDeplacement();
                            break;
                        case KeyEvent.VK_DOWN :
                            perso.keyDown();
                            perso.setImageReleased();
                            getAudio().playDeplacement();
                            break;
                        default:break;
                    }
                }
            }
        });
    }
    
    @Override
    protected void controller() {
        this.getPerso().actionBouton();
        if (this.getPerso().checkCollisionVehicule()) {
            Fenetre.getFenetre().stopMusic();
            new AudioPlayer().playDeath();
        }
        this.getPerso().setGameOver();
        if (this.getPerso().horsEcran()) {
            this.stopThread();
            this.getPerso().reinitilisation();
            TerrainFactory.reinitialisationCount();
            Fenetre.getFenetre().setEcranMenu();
        }
    }
}
