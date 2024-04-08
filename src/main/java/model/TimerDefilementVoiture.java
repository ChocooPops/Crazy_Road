package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.Terrain.Terrain;
import view.AbstractVue;

/**
 *
 * @author ChocoPops
 */
public class TimerDefilementVoiture extends Observable {
    private Timer timer; 
    private AbstractVue panel; 
    
    /**
     * Constructeur de la classe Timer qui observe le panel.
     * Se rafraichit toutes les 60 frames. 
     * Fait deplacer les voitures du panel.
    */
    public TimerDefilementVoiture(final AbstractVue panel) {
        this.addObserver(panel);
        this.panel = panel; 
        this.setTimer();
        this.startTimerDefilementVoiture();
    }
    
    private void setTimer() {
         timer = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                for (Terrain terrain : panel.getListeTerrain().getListeTerrain()) {
                    terrain.deplacerVoiture();
                }
                notifyAllObservers(); 
            }
        });
    }
    
    private void startTimerDefilementVoiture() {
        this.timer.start(); 
    }
    
    /**
     * Arreter le rafraichissement du timer. 
    */
    public void stopTimerDefilementVoiture() {
        this.timer.stop();
    }
}
