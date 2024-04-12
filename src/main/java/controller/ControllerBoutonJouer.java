package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import model.AudioPlayer;
import view.AbstractVue;
import view.Fenetre;

/**
 * Classe Controller du bouton jouer.
 */
public class ControllerBoutonJouer extends AbstractController {
    
    private AudioPlayer audioPlayer;

    @Override
    public void controller(final AbstractVue panel) {
        
        panel.getThreadVehicule().setActivation(false);
        Fenetre.getFenetre().setEcranJeu(panel.getListeTerrain());
        
        this.audioPlayer = panel.getAudioPlayer();
        if (audioPlayer.isPlaying()) {
            try {
                audioPlayer.stop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(ControllerBoutonJouer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            audioPlayer.play();
        }
    }
    
}
