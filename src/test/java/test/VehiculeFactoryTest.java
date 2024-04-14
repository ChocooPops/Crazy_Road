package test;

import model.Vehicule.VehiculeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class VehiculeFactoryTest {

    private VehiculeFactory vehiculeFactory = new VehiculeFactory();
    @Test
    void creationVehicule() {
        assertNotEquals(vehiculeFactory.creationVehicule(1, 10, 10, 1), null);
        System.out.println("Création de véhicule fonctionnel");
    }
}
