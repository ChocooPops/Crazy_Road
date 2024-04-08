package model.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import model.DimensionFacteur;
import model.Vehicule.Vehicule;
import model.Vehicule.VehiculeFactory;


/**
 *
 * @author ChocoPops
 */
public class Route extends Terrain {
    private List<Vehicule> listeVehicule = new ArrayList<>(); 
    
     /**
    * Instancie le type de terrain "Route" et son image.
    */
    public Route() {
        this.setImage(new ImageIcon("src/main/resources/terrain/route.png"));
        this.setType("Route");
    }
    
    @Override
    public void addVehicule(final int y) {
        int vehiculeY = y + Math.round(2 * DimensionFacteur.getFacteur());
        int nbVehicule = 2 + new Random().nextInt(3); 
        int longueurOldVec; 
        int direction = getRandomDirection(); 
        int typeVec = getRandomVehicule();
        if (direction > 0) {
            longueurOldVec = 0; 
        } else {
            longueurOldVec = DimensionFacteur.getLongueurFenetre(); 
        }
        for (int i = 0; i < nbVehicule; i++) {
            int vehiculeX = 0; 
            vehiculeX = longueurOldVec + this.getRandomX();
            Vehicule newVec = new VehiculeFactory()
                    .creationVehicule(typeVec, vehiculeX, vehiculeY, direction);
            this.listeVehicule.add(newVec);
            longueurOldVec = newVec.getX() + newVec.getLongueur(); 
        }
    }
    
    private int getRandomVehicule() {
        int vec = 0; 
        int nb = new Random().nextInt(10); 
        if (nb >= 4) {
            vec = 1; 
        } else if (nb == 0) {
            vec = 3; 
        } else {
            vec = 2; 
        }
        return vec;
    }
    private int getRandomDirection() {
        int nb = new Random().nextInt(2); 
        int sens = 0; 
        if (nb == 0)  {
            sens = 1; 
        } else {
            sens = -1; 
        }
        return sens; 
    }
    
    /**
    * Methode qui assure le deplacement des voitures dans la liste.
    */
    public void deplacerVoiture() {
        for (Vehicule vec : this.listeVehicule) {
            if (vec.getDirection() < 0 && vec.getX() + vec.getLongueur() < -40) {
                vec.setX(DimensionFacteur.getLongueurFenetre());
            } else if (vec.getDirection() > 0 && vec.getX() > DimensionFacteur.getLongueurFenetre() 
                    + vec.getLongueur()) {
                 vec.setX(-vec.getLongueur());
            }
            vec.setX(vec.getX() + vec.getVitesse() * vec.getDirection());    
        }
    }
    
    private int getRandomX() {
        return Math.round((10 + new Random().nextInt(150)) * DimensionFacteur.getFacteur());
    }
    
    @Override
    public List<Vehicule> getListeVehicule() {
        return this.listeVehicule; 
    }
}
