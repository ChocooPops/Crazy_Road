package test;

import model.Personnage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class PersonnageTest {

    private Personnage personnage = new Personnage();

    @Test
    void setX() {
        personnage.setX(10);
        assertEquals(personnage.getX(), 10);
        System.out.println("Fonction pour set la position sur l'axe X fonctionnel");
    }

    @Test
    void setY() {
        personnage.setY(10);
        assertEquals(personnage.getY(), 10);
        System.out.println("Fonction pour set la position sur l'axe Y fonctionnel");
    }

    public void main() {
        this.setX();
        this.setY();
    }
}
