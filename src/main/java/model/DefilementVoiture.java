package model;

import model.Terrain.Terrain;
import view.AbstractVue;

/**
 *
 * @author ChocoPops
 */
public class DefilementVoiture extends Observable {
    private AbstractVue panel; 
    private boolean activation; 
    private Thread thread; 
    
    /**
     * Constructeur de la classe Timer qui observe le panel.
     * Se rafraichit toutes les 60 frames. 
     * Fait deplacer les voitures du panel.
    */
    public DefilementVoiture(final AbstractVue panel) {
        this.activation = true; 
        this.addObserver(panel);
        this.panel = panel; 
        this.thread = new Thread(new ThreadDefilementVoiture()); 
        this.startTimerDefilementVoiture();
    }
    
    /**
    * Definit le deroulement du deplacement des voitures dans le thread. 
    */
    public void deroulement() {
        for (Terrain terrain : panel.getListeTerrain().getListeTerrain()) {
            terrain.deplacerVoiture();
        }
        notifyAllObservers(); 
    }
    
    private void startTimerDefilementVoiture() {
        this.activation = true; 
        this.thread.start();
    }
    
    /**
     * Arreter le rafraichissement du thread. 
    */
    public void stopTimerDefilementVoiture() {
        this.activation = false; 
    }
    
    /**
    * Sous classe qui lance un thread.  
    */
    public class ThreadDefilementVoiture implements Runnable {

        @Override
        public void run() {
            while (activation) {
                try {
                    Thread.sleep(25);
                    deroulement(); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
