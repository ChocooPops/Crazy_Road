package controller;

import model.AudioPlayer;
import view.AbstractVue;

/**
 * Classe abstraite pour controler les différents événements.
 */
public abstract class AbstractController {

    private AudioPlayer audio; 
    
    /**
    * Constructeur de la classe AbstractController.
    */
    public AbstractController() {
        this.audio = new AudioPlayer(); 
    }
    /**
     * Fonction pour controller.
     * @param panel
     */
    public abstract void controller(AbstractVue panel);
    
    public AudioPlayer getAudio() {
        return this.audio; 
    }

}
