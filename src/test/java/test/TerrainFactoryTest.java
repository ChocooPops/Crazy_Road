package test;

import model.Terrain.TerrainFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TerrainFactoryTest {

    private TerrainFactory terrainFactory = new TerrainFactory();
    @Test
    void creationTerrain() {
        assertNotEquals(terrainFactory.creationTerrain(), null);
        System.out.println("creation du terrain fonctionnel");
    }
}
