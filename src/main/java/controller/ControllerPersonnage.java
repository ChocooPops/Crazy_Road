package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.Personnage;
import view.AbstractVue;

/**
 *
 * Classe Controller qui control les deplacements du perso.
 */
public class ControllerPersonnage extends AbstractController {

    /**
     * @param panel
     */
    @Override
    public void controller(final AbstractVue panel) {
        Personnage perso = Personnage.getPersonnage();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent key) {
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
            
            @Override
            public void keyReleased(final KeyEvent key) {
                switch (key.getKeyCode()) {
                    case KeyEvent.VK_RIGHT :
                        perso.keyRight();
                        perso.setImageReleased();
                        break;
                    case KeyEvent.VK_LEFT :
                        perso.keyLeft();
                        perso.setImageReleased();
                        break;
                    case KeyEvent.VK_UP :
                        perso.keyUp();
                        perso.setImageReleased();
                        break;
                    case KeyEvent.VK_DOWN :
                        perso.keyDown();
                        perso.setImageReleased();
                        break;
                    default:break;
                }
            }
        });
    }
}
