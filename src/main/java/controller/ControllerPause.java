
package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Pause;
import view.AbstractVue;
import view.Fenetre;

/**
 * Classe ControllerPause.
 */
public class ControllerPause extends AbstractController {

    /**
    * Constructeur de la classe ControllerPause.
     * @param panel
    */
    public ControllerPause(final AbstractVue panel) {
        super(panel);
    }

    @Override
    public void controllerKeyPanel() {
        Pause pause = getPanel().getPause(); 
        this.getPanel().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE && !getPerso().isGameOver()) {
                    actionPause(pause); 
                }
            }
        });
        
        this.getPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getX() <= pause.getX() + pause.getLongueur()
                    && e.getX() >= pause.getX()
                    && e.getY() >= pause.getY()
                    && e.getY() <= pause.getY() + pause.getHauteur()) {
                    actionPause(pause); 
                }
            }
        });
    }
    
    private void actionPause(final Pause pause) {
        if (!this.getPerso().isGameOver()) {
            if (pause.getEtat()) {
            Fenetre.getFenetre().resumeMusic();
            pause.setEtat(false);
            controlStart(); 
            } else {
                Fenetre.getFenetre().stopMusic();
                pause.setEtat(true);
                controlStop(); 
            }
        }
    }
    
    
    private void controlStart() {
        this.getPanel().getPause().setImageStart();
        this.getPanel().getControllerPerso().startThread();
        this.getPanel().getControllerMaps().startThread();
        this.getPanel().getControllerVec().startThread();
    }
    
    private void controlStop() {
        this.getPanel().getPause().setImageStop();
        this.getPanel().getControllerPerso().stopThread();
        this.getPanel().getControllerMaps().stopThread();
        this.getPanel().getControllerVec().stopThread();
    }

    @Override
    public void controller() {
        
    }
    
}
