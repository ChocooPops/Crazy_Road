package test;

import model.Terrain.Route;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RouteTest {

    private Route route = new Route();
    @Test
    void getListeVehicule() {
        route.addVehicule(10);
        assertNotEquals(route.getListeVehicule(), null);
        System.out.println("GetListeVehicule fonctionnel");
    }

    @Test
    void getHitBoxes() {
        assertEquals(route.getHitBoxes(), null);
        System.out.println("GetHitBox fonctionnel");
    }
}
