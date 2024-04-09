package model.Terrain;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author ChocoPops
 */
public class Champ extends Terrain {

    private ArrayList<HitBox> listeArbre = new ArrayList<>();
    private int typeTerrain;

    /**
    * Instancie le type de terrain "Champ" et son image.
     * @param debut
    */
    public Champ(final boolean debut) {
        if (debut) {
            this.setImage(new ImageIcon(this.setImageBeginChamp()));
        } else {
            this.setImage(new ImageIcon(this.setImageChamp()));
        }
        this.setType("Champ");
    }

    @Override
    public ArrayList<HitBox> getHitBoxes() {
        return listeArbre;
    }

    /**
   * Choisit une image du terrain parmis six images.
   */
    private String setImageChamp() {
        int nb = new Random().nextInt(6);
        this.typeTerrain = nb;
        String src = ""; 
        switch (nb) {
            case 0 :
                src = "src/main/resources/terrain/terrain1.png";
                break; 
            case 1 :
                src = "src/main/resources/terrain/terrain2.png";
                break; 
            case 2 :
                src = "src/main/resources/terrain/terrain3.png";
                break; 
            case 3 :
                src = "src/main/resources/terrain/terrain4.png";
                break; 
            case 4 :
                src = "src/main/resources/terrain/terrain5.png";
                break;
            default :
                src = "src/main/resources/terrain/terrain6.png";
                break; 
        }
        return src; 
    }

    private String setImageBeginChamp() {
        this.typeTerrain = 0; 
        return "src/main/resources/terrain/terrain1.png";        
    }
    
    @Override
    public void addCollision(final int y) {
        switch (this.typeTerrain) {
            case 0 :
                listeArbre.add(new HitBox(91, y));
                listeArbre.add(new HitBox(355, y));
                break;
            case 1 :
                listeArbre.add(new HitBox(2, y));
                listeArbre.add(new HitBox(50, y));
                listeArbre.add(new HitBox(399, y));
                listeArbre.add(new HitBox(444, y));
                break;
            case 2 :
                listeArbre.add(new HitBox(132, y));
                listeArbre.add(new HitBox(178, y));
                listeArbre.add(new HitBox(399, y));
                break;
            case 3 :
                listeArbre.add(new HitBox(50, y));
                listeArbre.add(new HitBox(91, y));
                listeArbre.add(new HitBox(132, y));
                listeArbre.add(new HitBox(267, y));
                listeArbre.add(new HitBox(444, y));
                break;
            case 4 :
                listeArbre.add(new HitBox(2, y));
                listeArbre.add(new HitBox(222, y));
                break;
            default :
                listeArbre.add(new HitBox(91, y + 47));
                listeArbre.add(new HitBox(132, y + 47));
                listeArbre.add(new HitBox(399, y + 47));
                listeArbre.add(new HitBox(222, y + 47));
                listeArbre.add(new HitBox(2, y));
                listeArbre.add(new HitBox(132, y));
                listeArbre.add(new HitBox(267, y));
                listeArbre.add(new HitBox(399, y));
                break;
        }
    };
}
