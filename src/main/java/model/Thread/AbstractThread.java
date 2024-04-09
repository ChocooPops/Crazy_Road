package model.Thread;

import model.Observable;
import view.AbstractVue;

/**
 *
 * @author ChocoPops
 */
public abstract class AbstractThread extends Observable implements Runnable {

    private Thread thread; 
    private AbstractVue panel; 
    private boolean activation; 
    
    /**
    * Constructeur de la classe AbstractThread.
    */
    public AbstractThread(final AbstractVue panel) {
        this.setPanel(panel);
        this.setThead(this);
        this.setActivation(true);
        this.getThread().start(); 
    }
    
    public AbstractVue getPanel() {
        return this.panel; 
    }
    public Thread getThread() {
        return this.thread;
    }
    public boolean isActivate() {
        return this.activation; 
    }
    
    public void setThead(final AbstractThread newThread) {
        this.thread = new Thread(newThread); 
    }
    public void setPanel(final AbstractVue newPanel) {
        this.panel = newPanel; 
    }
    public void setActivation(final boolean activation) {
        this.activation = activation; 
    }
    
    /**
    * Méthode abstraite.
    * Chaque classe fille a un deroulement unique.
    */
    public abstract void deroulement(); 
    
    @Override
    public void run() {
        while (activation) {
            try {
                 Thread.sleep(30);
                 deroulement(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
