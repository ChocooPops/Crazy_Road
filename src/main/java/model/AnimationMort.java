package model;

import javax.swing.ImageIcon;

/**
 *
 * @author p2203115
 */
public class AnimationMort implements Runnable{
    private boolean activation;
    private Personnage personnage;
    private Thread thread;
    
    public AnimationMort() {
        this.activation = true;
        this.personnage = Personnage.getPersonnage();
        this.personnage.setJumpMort(true);
        personnage.setImage(new ImageIcon("src/main/resources/personnage/pouleMorte.png"));
        this.thread = new Thread(this);
        thread.start();
    }
    
    public void deroulement() {
        this.personnage.setGameOver();
    }
    
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
