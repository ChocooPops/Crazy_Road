package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Personnage;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.Titre;

/**
 *
 * @author ChocoPops
 */
public class PanelMenu extends AbstractVue {
    
    private ListeTerrain listeTerrain; 
    private JButton btJouer; 
    private Personnage personnage; 
    private Titre titre; 
    
    /**
    * Constructeur de la classe PanelMenu.
    * Initialise la liset des terrains.
    */
    public PanelMenu() {
        this.titre = new Titre(); 
        this.listeTerrain = new ListeTerrain(); 
        this.personnage = Personnage.getPersonnage(); 
        this.setLayout(new BorderLayout());
        setPanelBouton(); 
    }
    
    private void setPanelBouton() {
        JPanel panelFlow = new JPanel(); 
        panelFlow.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        Icon iconBoutonplay = new ImageIcon("src/main/resources/autres/boutonPlay.png");
        this.btJouer = new JButton(iconBoutonplay);
        btJouer.setOpaque(false);
        btJouer.setContentAreaFilled(false);
        btJouer.setBorderPainted(false);

        panelFlow.add(this.btJouer); 
        panelFlow.setBackground(new Color(0x1d1d1d));
        panelFlow.setBorder(
                BorderFactory.createMatteBorder(5, 2, 0, 2, new Color(0x3f464f)));
        this.add(panelFlow, BorderLayout.SOUTH); 
        
        
    }
    
    /**
    * Methode pour dessiner toutes les elements importants dans le panel.
    */
    @Override
    public void paintComponent(final Graphics g) {
        for (int j = 0; j < listeTerrain.getListeSize(); j++) {
            Terrain terrain = listeTerrain.getTerrainById(j); 
            g.drawImage(terrain.getImage().getImage(), terrain.getX(), terrain.getY(), 
                    terrain.getLongueur(), terrain.getHauteur(), this); 
        }
        g.drawImage(this.personnage.getImage().getImage(), 
                this.personnage.getX(), this.personnage.getY(), 
                this.personnage.getLongueur(), this.personnage.getHauteur(), this); 
        g.drawImage(this.titre.getImage().getImage(), 
                this.titre.getX(), this.titre.getY(), 
                this.titre.getLongueur(), this.titre.getHauteur(), this); 
    }
    
    /**
    *
    * Sous classe du PanelMenu.
    * Definit l'écouteur du boton jouer. 
    */
    public class EcouteurJouer {
        
        /**
        *
        * Definit l'écouteur du boton jouer. 
        */
        public EcouteurJouer() {
            btJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                
            }
        });
        }
    }
}
