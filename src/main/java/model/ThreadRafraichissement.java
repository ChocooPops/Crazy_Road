
package model;

import view.AbstractVue;

/**
 * Classe ThreadRafraichissement.
 * Observe les vues AbstractVue.
 */
public class ThreadRafraichissement extends Observable implements Runnable {

    private boolean activation; 
    private Thread thread; 
    
    /**
    * Constructeur de la classe ThreadRafraichissement.
     * @param newVue
    */
    public ThreadRafraichissement(final AbstractVue newVue) {
        this.addObserver(newVue); 
        this.thread = new Thread(this); 
    }

    @Override
    public void run() {
        while (activation) {
                try {
                    Thread.sleep(30);
                    this.notifyAllObservers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    
    /**
    * Exécuter le rafraichissement du panel.
    */
    public void startRafraichissement() {
        this.activation = true; 
        if (!this.thread.isAlive()) {
            this.thread.start(); 
        }
    }
    
    /**
    * Arreter le rafraichissement du panel.
    */
    public void stopRafraichissement() {
        this.activation = false; 
    }
    
}
