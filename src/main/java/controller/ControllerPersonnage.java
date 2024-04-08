/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import model.Personnage;

/**
 *
 * @author p2204658
 */
public class ControllerPersonnage extends AbstractController{

    
    public void controller(JPanel panel) {
        Personnage perso = Personnage.getPersonnage(); 
        
        panel.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent arg0) {
                
            }

            @Override
            public void keyPressed(KeyEvent key) {
                if(perso.keyIsPressed())
                switch (key.getKeyCode()) {
                    case KeyEvent.VK_RIGHT :
                        perso.keyRight();
                        break; 
                    case KeyEvent.VK_LEFT :
                        perso.keyLeft();
                        break; 
                    case KeyEvent.VK_UP :
                        perso.keyUp();
                        break; 
                    case KeyEvent.VK_DOWN :
                        perso.keyDown();
                        break; 
                }
                perso.setKeyPressed(false);
                panel.repaint(); 
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                perso.setKeyPressed(true);
            }
            
        });
    }
    
}
