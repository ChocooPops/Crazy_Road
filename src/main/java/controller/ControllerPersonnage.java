package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.Personnage;
import view.AbstractVue;

/**
 *
 * @author p2204658
 */
public class ControllerPersonnage extends AbstractController {

    /**
     *
     * @param panel
     */
    public void controller(final AbstractVue panel) {
        Personnage perso = Personnage.getPersonnage();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent key) {
                    switch (key.getKeyCode()) {
                        case KeyEvent.VK_RIGHT :
                            perso.keyRight();
                            break;
                        case KeyEvent.VK_LEFT :
                            perso.keyLeft();
                            break;
                        case KeyEvent.VK_UP :
                            perso.keyUp();
                            break;
                        case KeyEvent.VK_DOWN :
                            perso.keyDown();
                            break;
                        default:break;
                }
            }
        });
    }
}
