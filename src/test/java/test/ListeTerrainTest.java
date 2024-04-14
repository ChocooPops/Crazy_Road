package test;

import model.Terrain.ListeTerrain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListeTerrainTest {

    private ListeTerrain listeTerrain = new ListeTerrain();
    @Test
    void getListeSize() {
        assertEquals(listeTerrain.getListeSize(), 18);
        System.out.println("Taille de la liste de terrain conforme");
    }
}
