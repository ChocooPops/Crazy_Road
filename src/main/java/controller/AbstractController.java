package controller;

import model.AudioPlayer;
import model.Personnage;
import view.AbstractVue;

/**
 * Classe abstraite pour controler les différents événements.
 */
public abstract class AbstractController {

    private AudioPlayer audio; 
    private boolean activation; 
    private AbstractVue panel; 
    private Personnage personnage; 
    private Thread thread; 
    
    /**
    * Constructeur de la classe AbstractController.
     * @param panel
    */
    public AbstractController(final AbstractVue panel) {
        this.panel = panel; 
        this.audio = new AudioPlayer(); 
        this.personnage = Personnage.getPersonnage();
        this.activation = false; 
    }
    
    /**
     * Fonction pour controller.
     */
    protected abstract void controller();
    
    public AudioPlayer getAudio() {
        return this.audio; 
    }
    public Personnage getPerso() {
        return this.personnage; 
    }
    public boolean isActivate() {
        return this.activation; 
    }
    public AbstractVue getPanel() {
        return this.panel; 
    }
    public Thread getThread() {
        return this.thread;
    }
    
    /**
    * Exécute le thread du controlleur.
    */
    public void startThread() {
        this.activation = true;
        if (!this.thread.isAlive()) {
            this.thread.start();
        }
    }
    
     /**
    * Arrete le thread du controlleur.
    */
    public void stopThread() {
        this.activation = false;
    }
    
    /**
    * Exécute le thread du controlleur.
    */
    public void setThread() {
        this.thread = new Thread(new ThreadController()); 
    }
    
    /**
    * Méthode override dans la classe fille ControllerPersonnage.
    * Gère les clés du clavier.
    */
    public void controllerActionPerso() { }
    
    /**
    * Sous classe.
    * Classe ThreadController.
    * Définit un thread selon la méthode controller; 
    */
    public class ThreadController implements Runnable {
        @Override
        public void run() {
            while (activation) {
                try {
                     Thread.sleep(30);
                     controller(); 
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
