package test;

import model.Personnage;
import model.Terrain.HitBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HitBoxTest {

    private HitBox hitbox = new HitBox(10, 10);
    private Personnage personnage = new Personnage();

    @Test
    void setX() {
        hitbox.setX(10);
        assertEquals(hitbox.getX(), 10);
        System.out.println("set X fonctionnel");
    }

    @Test
    void setY() {
        hitbox.setY(10);
        assertEquals(hitbox.getY(), 10);
        System.out.println("set Y fonctionnel");
    }

    @Test
    void setHauteur() {
        hitbox.setHauteur(10);
        assertEquals(hitbox.getHauteur(), 10);
        System.out.println("set Hauteur fonctionnel");
    }

    @Test
    void setLongueur() {
        hitbox.setLongueur(10);
        assertEquals(hitbox.getLongueur(), 10);
        System.out.println("set Longueur fonctionnel");
    }
}
