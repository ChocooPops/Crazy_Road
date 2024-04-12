package model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author Félix
 */
public class AudioPlayer {
    
    Clip clip;
    AudioInputStream audioInputStream;
    boolean audioPlaying;
    
    
    /**
    *
    * constructeur de la classe.
    * @param filePath chemin du fichier audio.
    * @throws UnsupportedAudioFileException
    * @throws IOException
    * @throws LineUnavailableException
    */
    public AudioPlayer(final String filePath)
        throws UnsupportedAudioFileException,
        IOException, LineUnavailableException 
    {
        audioInputStream = 
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
          
        clip = AudioSystem.getClip();
          
        clip.open(audioInputStream);
        
        audioPlaying = false;
          

    }
    
    public boolean isPlaying() {
        return this.audioPlaying;
    }
    
    /**
    *
    * pour jouer l'audio.
    */
    public void play() 
    {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        this.audioPlaying = true;
    }
    
    /**
    *
    * pour stopper l'audio.
    * @throws UnsupportedAudioFileException
    * @throws IOException
    * @throws LineUnavailableException
    */
    public void stop() throws UnsupportedAudioFileException,
    IOException, LineUnavailableException 
    {
        clip.stop();
        clip.close();
        this.audioPlaying = false;
    }
}

