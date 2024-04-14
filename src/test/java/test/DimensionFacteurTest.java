package test;

import model.DimensionFacteur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DimensionFacteurTest {

    @Test
    void getFacteur() {
        assertEquals(DimensionFacteur.getFacteur(), (float) 2.45);
        System.out.println("Facteur bien présent");
    }
}
