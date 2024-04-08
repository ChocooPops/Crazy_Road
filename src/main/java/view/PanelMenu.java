package view;

import controller.ControllerBoutonJouer;
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
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.TimerDefilementVoiture;
import model.Titre;
import model.Vehicule.Vehicule;

/**
 *
 * @author ChocoPops
 */
public class PanelMenu extends AbstractVue {
    
    private JButton btJouer; 
    private Titre titre; 
    private TimerDefilementVoiture timer;
    
    /**
    * Constructeur de la classe PanelMenu.
    * Initialise la liset des terrains.
    */
    public PanelMenu() {
        this.titre = new Titre(); 
        this.setListeTerrain(new ListeTerrain());
        this.setLayout(new BorderLayout());
        this.setPanelBouton(); 
        this.setTimerVoiture(); 
        new EcouteurJouer(this); 
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
        for (int i = 0; i < this.getListeTerrain().getListeSize(); i++) {
            Terrain terrain = this.getListeTerrain().
                    getTerrainById(this.getListeTerrain().
                            getListeSize() - i - 1); 
            g.drawImage(terrain.getImage().getImage(), terrain.getX(), terrain.getY(), 
                    terrain.getLongueur(), terrain.getHauteur(), this);  
            if (terrain.getType().equals("Route")) { 
                for (Vehicule vec : terrain.getListeVehicule()) {
                    g.drawImage(vec.getImage().getImage(), vec.getX(), vec.getY(), 
                         vec.getLongueur(), vec.getHauteur(), this);
                }
            }
        }
        g.drawImage(this.getPersonnage().getImage().getImage(), 
                this.getPersonnage().getX(), this.getPersonnage().getY(), 
                this.getPersonnage().getLongueur(), this.getPersonnage().getHauteur(), this); 
        g.drawImage(this.titre.getImage().getImage(), 
                this.titre.getX(), this.titre.getY(), 
                this.titre.getLongueur(), this.titre.getHauteur(), this); 
    }
    
    /**
     * Méthode pour faire avancer les voitures.
     */

    @Override
    public void update() {
        repaint(); 
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
        public EcouteurJouer(AbstractVue panel) {
            btJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new ControllerBoutonJouer().controller(panel);
            }
        });
        }
    }
}
