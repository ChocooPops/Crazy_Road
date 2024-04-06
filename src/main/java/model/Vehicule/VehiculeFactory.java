package model.Vehicule;

import java.util.Random;

/**
 *
 * @author ChocoPops
 */
public class VehiculeFactory {
    
    /**
 *
 * Constructeur de la classe.
 */
    public VehiculeFactory() {
        
    }
    
    /**
     * Création d'un véhicule aléatoire.
  */
    public Vehicule creationVehicule(final int y) {
        Vehicule vehicule = null; 
        int nb = new Random().nextInt(10); 
        if (nb >= 0) {
            vehicule = new Voiture(y); 
        } else {
            vehicule = new Camion(y); 
        }
        return vehicule; 
    }
}
