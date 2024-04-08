package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import model.Personnage;

/**
 *
 * @author p2204658
 */
public class ControllerPersonnage extends AbstractController {

    /**
     *
     * @param panel
     */
    public void controller(final JPanel panel) {
        Personnage perso = Personnage.getPersonnage();

        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent arg0) {

            }

            @Override
            public void keyPressed(final KeyEvent key) {
                if (perso.keyIsPressed()) {
                    switch (key.getKeyCode()) {
                        case KeyEvent.VK_RIGHT :
                            perso.keyRight();
                            perso.setDirection(4);
                            break;
                        case KeyEvent.VK_LEFT :
                            perso.keyLeft();
                            perso.setDirection(1);
                            break;
                        case KeyEvent.VK_UP :
                            perso.keyUp();
                            perso.setDirection(2);
                            break;
                        case KeyEvent.VK_DOWN :
                            perso.keyDown();
                            perso.setDirection(3);
                            break;
                        default:break;
                    }
                    perso.setKeyPressed(false);
                    panel.repaint();
                }
            }

            @Override
            public void keyReleased(final KeyEvent arg0) {
                perso.setKeyPressed(true);
            }

        });
    }

}

