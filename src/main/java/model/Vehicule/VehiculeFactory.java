package model.Vehicule;

/**
 * Classe VehiculeFactory.
 * S'occupe des créer des vehicules aléatoirement.
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
     * @param type
     * @param x
     * @param y
     * @param direction
     * @return 
    */
    public Vehicule creationVehicule(final int type, final int x, 
            final int y, final int direction) {
        Vehicule vehicule;
        switch (type) {
            case 1 : vehicule = new Voiture(x, y, direction); 
                break; 
            case 2 : vehicule = new Camion(x, y, direction); 
                break; 
            case 3 : vehicule = new Moto(x, y, direction); 
                break; 
            default : vehicule = new Voiture(x, y, direction); 
                break; 
        }
        return vehicule; 
    }
}
