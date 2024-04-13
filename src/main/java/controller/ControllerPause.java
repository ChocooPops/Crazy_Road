
package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.Pause;
import view.AbstractVue;

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
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (pause.getEtat()) {
                        pause.setEtat(false);
                        controlStart(); 
                    } else {
                        pause.setEtat(true);
                        controlStop(); 
                    }
                }
            }
        });
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
