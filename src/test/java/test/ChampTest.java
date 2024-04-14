package test;

import model.Terrain.Champ;
import model.Terrain.HitBox;
import org.junit.jupiter.api.Test;

class ChampTest {

    private Champ champ = new Champ(true);

    @Test
    void getHitBoxes() {
        champ.addCollision(10);
        for (HitBox hitbox : champ.getHitBoxes()) {
            assert (hitbox.getX() > 0);
            assert (hitbox.getX() < 600);
        }
        System.out.println("HitBox fonctionnel");
    }
}
