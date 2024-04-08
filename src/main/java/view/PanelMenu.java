package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Personnage;
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
    private Personnage personnage; 
    private Titre titre; 
    private Timer timer;
    
    /**
    * Constructeur de la classe PanelMenu.
    * Initialise la liset des terrains.
    */
    public PanelMenu() {
        this.titre = new Titre(); 
        this.setListeTerrain(new ListeTerrain());
        this.personnage = Personnage.getPersonnage(); 
        this.setLayout(new BorderLayout());
        setPanelBouton(); 
        new TimerDefilementVoiture(this); 
    }
    
    private void setPanelBouton() {
        JPanel panelFlow = new JPanel(); 
        panelFlow.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.btJouer = new JButton("Jouer");
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
        g.drawImage(this.personnage.getImage().getImage(), 
                this.personnage.getX(), this.personnage.getY(), 
                this.personnage.getLongueur(), this.personnage.getHauteur(), this); 
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
        public EcouteurJouer() {
            btJouer.addMouseListener(new MouseAdapter() {
                
            });
        }
    }
}
