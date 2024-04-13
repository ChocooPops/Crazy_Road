package model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * Classe AudioPlayer.
 * Gère le son.
 */
public class AudioPlayer {
    
    private Clip clipMusic; 
    
   /**
   * Jouer le son du Menu.
   */
    public void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.
                    getAudioInputStream(new File("src/main/resources/musique/musique.wav"));
            this.clipMusic = AudioSystem.getClip();
            this.clipMusic.open(audioInputStream);
            this.clipMusic.loop(Clip.LOOP_CONTINUOUSLY);
            this.clipMusic.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
        }
    }
    
    /**
    * Arreter le son de la music principale.
    */
    public void stopMusic() {
        this.clipMusic.stop(); 
    }
    
    /**
    * Relancer la music.
    */
    public void resumeMusic() {
        this.clipMusic.start();
    }
   /**
   * Jouer le son du deplacement du perso.
   */
   public void playDeplacement() {
        try {
            AudioInputStream audioInputStream = AudioSystem.
                    getAudioInputStream(new File("src/main/resources/musique/deplacement.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
        }
    }
 
    /**
    * Jouer le son de la mort du perso.
    */
   public void playDeath() {
        try {
            AudioInputStream audioInputStream = AudioSystem.
                    getAudioInputStream(new File("src/main/resources/musique/death.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
        }
    }
}

