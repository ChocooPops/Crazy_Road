package test;

import model.Pause;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PauseTest {

    private Pause pause = new Pause();
    @Test
    void setEtat() {
        pause.setEtat(true);
        assertEquals(pause.getEtat(), true);
        System.out.println("SetEtat Fonctionnel");
    }
}
