package model.Terrain;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import model.DimensionFacteur;

/**
 *
 * @author ChocoPops
 */
public class Champ extends Terrain {

    private ArrayList<HitBox> listeArbre = new ArrayList<>();
    private int typeTerrain;
    private float facteur = DimensionFacteur.getFacteur(); 

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
                listeArbre.add(new HitBox(this.convertir(37), y));
                listeArbre.add(new HitBox(this.convertir(145), y));
                break;
            case 1 :
                listeArbre.add(new HitBox(this.convertir(1), y));
                listeArbre.add(new HitBox(this.convertir(19), y));
                listeArbre.add(new HitBox(this.convertir(163), y));
                listeArbre.add(new HitBox(this.convertir(181), y));
                break;
            case 2 :
                listeArbre.add(new HitBox(this.convertir(55), y));
                listeArbre.add(new HitBox(this.convertir(73), y));
                listeArbre.add(new HitBox(this.convertir(163), y));
                break;
            case 3 :
                listeArbre.add(new HitBox(this.convertir(19), y));
                listeArbre.add(new HitBox(this.convertir(37), y));
                listeArbre.add(new HitBox(this.convertir(55), y));
                listeArbre.add(new HitBox(this.convertir(109), y));
                listeArbre.add(new HitBox(this.convertir(181), y));
                break;
            case 4 :
                listeArbre.add(new HitBox(this.convertir(1), y));
                listeArbre.add(new HitBox(this.convertir(91), y));
                break;
            default :
                int hauteur2 = Math.round(20 * DimensionFacteur.getFacteur()); 
                listeArbre.add(new HitBox(this.convertir(1), y));
                listeArbre.add(new HitBox(this.convertir(55), y));
                listeArbre.add(new HitBox(this.convertir(109), y));
                listeArbre.add(new HitBox(this.convertir(163), y));
                listeArbre.add(new HitBox(this.convertir(37), y + hauteur2));
                listeArbre.add(new HitBox(this.convertir(55), y + hauteur2));
                listeArbre.add(new HitBox(this.convertir(91), y + hauteur2));
                listeArbre.add(new HitBox(this.convertir(163), y + hauteur2));
                break;
        }
    };
    
    private int convertir(final int nb) {
        return Math.round(this.facteur * nb); 
    }

    /**
     * Fait descendre tous les éléments liés au terrain. 
     */
    @Override
    public void setDescenteAllElementTerrain() {
        this.setDescenteTerrain();
        for (HitBox hitbox : this.listeArbre) {
            hitbox.setDescenteHitBox(this.getVitesse());
        }
    }
}
