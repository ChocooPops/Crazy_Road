package test;

import model.Terrain.TerrainFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerrainFactoryTest {

    private TerrainFactory terrainFactory = new TerrainFactory();
    @Test
    void creationTerrain() {
        assertEquals(terrainFactory.creationTerrain().getType(), "Champ");
        System.out.println("creation du terrain initial fonctionnel");
    }
}
