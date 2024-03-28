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
    public Vehicule creationVehicule() {
        Vehicule vehicule = null; 
        int nb = new Random().nextInt(10); 
        if (nb >= 7) {
            vehicule = new Voiture(); 
        } else {
            vehicule = new Camion(); 
        }
        return vehicule; 
    }
}
