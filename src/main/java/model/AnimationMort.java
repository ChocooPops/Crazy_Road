package model;

import javax.swing.ImageIcon;

/**
 *
 * @author p2203115
 */
public class AnimationMort implements Runnable {
    private boolean activation;
    private Personnage personnage;
    private Thread thread;
    
    /**
     * Constructeur de la classe AnimationMort.
    */
    public AnimationMort() {
        this.activation = true;
        this.personnage = Personnage.getPersonnage();
        this.personnage.setJumpMort(true);
        personnage.setImage(new ImageIcon("src/main/resources/personnage/pouleMorte.png"));
        this.thread = new Thread(this);
        thread.start();
    }
    
    /**
     * Definit le deroulement du thread.
    */
    public void deroulement() {
        this.personnage.setGameOver();
    }
    
    /**
     * Definit l'action du thread.
    */
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
