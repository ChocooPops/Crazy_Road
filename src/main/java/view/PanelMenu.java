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
import javax.swing.Timer;
import model.Personnage;
import model.Terrain.ListeTerrain;
import model.Terrain.Terrain;
import model.Terrain.HitBox;
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
        this.setFocusable(true);
        setPanelBouton();
        new TimerDefilementVoiture(this);
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
            if (terrain.getType().equals("Champ")) {
                for (HitBox hitBox : terrain.getHitBoxes()) {
                    g.setColor(Color.RED);
                    g.drawRect(hitBox.getX(), hitBox.getY(),
                            hitBox.getLongueur(), hitBox.getHauteur());
                }
            }
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

        if (checkCollisions()) {
            g.setColor(Color.RED);
            g.drawString("Collision", 100, 100);
        }
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
     * Definit l'écouteur du bouton jouer.
     */
    public class EcouteurJouer {

        /**
         *
         * Definit l'écouteur du bouton jouer.
         */
        public EcouteurJouer() {
            btJouer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {

                }
            });
        }
    }

    /**
     *
     * Methode pour verifier les collisions si elles sont pénétrées.
     * @return un boolean pour savoir si il y a une collision.
     */
    public boolean checkCollisions() {
        for (Terrain terrain : this.getListeTerrain().getListeTerrain()) {
            if (terrain.getType().equals("Champ")) {
                for (HitBox hitBox : terrain.getHitBoxes()) {
                    if (hitBox.collision(personnage)) {
                        int direction = personnage.getDirection();

                        if (direction == 1) {
                            personnage.setX(hitBox.getX() + hitBox.getLongueur());
                        } else if (direction == 2) {
                            personnage.setY(hitBox.getY() + hitBox.getHauteur() + 4);
                        } else if (direction == 3) {
                            personnage.setY(hitBox.getY() - hitBox.getHauteur() - 4);
                        } else if (direction == 4) {
                            personnage.setX(hitBox.getX() - hitBox.getLongueur());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
