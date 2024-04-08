package model.Vehicule;

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
    public Vehicule creationVehicule(final int type, final int x, 
            final int y, final int direction) {
        Vehicule vehicule = null;
        switch (type) {
            case 1 : vehicule = new Voiture(x, y, direction); 
                break; 
            case 2 : vehicule = new Camion(x, y, direction); 
                break; 
            default : vehicule = new Voiture(x, y, direction); 
                break; 
        }
        return vehicule; 
    }
}
