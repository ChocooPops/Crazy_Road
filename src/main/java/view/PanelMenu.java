package view;

import controller.ControllerBoutonJouer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.DimensionFacteur;
import model.Terrain.ListeTerrain;
import model.Thread.DefilementVehicule;
import model.Titre;

/**
 *
 * @author ChocoPops
 */
public class PanelMenu extends AbstractVue {

    private JButton btJouer;
    private Titre titre;
    private DefilementVehicule timer;

    /**
     * Constructeur de la classe PanelMenu.
     * Initialise la liset des terrains.
     */
    public PanelMenu() {
        this.titre = new Titre();
        this.setListeTerrain(new ListeTerrain());
        this.setLayout(new BorderLayout());
        this.setPanelBouton();
        this.setThreadVehicule();
        new EcouteurJouer(this);
    }

    private void setPanelBouton() {
        JPanel panelFlow = new JPanel();
        panelFlow.setLayout(new FlowLayout(FlowLayout.CENTER));

        float facteur = DimensionFacteur.getFacteur();

        ImageIcon iconBoutonPlayOrigine = new ImageIcon("src/main/resources/autres/boutonPlay.png");
        int largeur = Math.round(iconBoutonPlayOrigine.getIconWidth() * facteur / (float) 1.5);
        int hauteur = Math.round(iconBoutonPlayOrigine.getIconHeight() * facteur / (float) 1.5);
        Image imageRedimensionnee = iconBoutonPlayOrigine.getImage().
                getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
        ImageIcon iconBoutonPlay = new ImageIcon(imageRedimensionnee);
        this.btJouer = new JButton(iconBoutonPlay);
        this.setFocusable(true);

        btJouer.setPreferredSize(new Dimension(largeur, hauteur));
        btJouer.setOpaque(false);
        btJouer.setContentAreaFilled(false);
        btJouer.setBorderPainted(false);
        btJouer.setBorder(null);
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
        super.paintComponent(g);
        this.dessinerTerrain(g);
        this.dessinerPersonnage(g);
        this.dessinerVehicule(g);
        this.dessinerTitre(g);
    }

    /**
     * Dessiner le titre du jeu.
     */
    public void dessinerTitre(final Graphics g) {
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
     * Definit l'écouteur du bouton jouer.
     */
    public class EcouteurJouer {

        /**
         *
         * Definit l'écouteur du bouton jouer.
         */
        public EcouteurJouer(final AbstractVue panel) {
            btJouer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    new ControllerBoutonJouer().controller(panel);
                }
            });
        }
    }
}
