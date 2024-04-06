package model.Terrain;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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
       this.listeVehicule.add(new VehiculeFactory().creationVehicule(y)); 
    }
    
    @Override
    public List<Vehicule> getListeVehicule() {
        return this.listeVehicule; 
    }
}
