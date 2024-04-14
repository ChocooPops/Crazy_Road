package test;

import model.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreTest {

    private Score score = new Score();
    @Test
    void getScore() {
        score.incrementerScore();
        assertEquals(score.getScore(), 1);
        System.out.println("Score fonctionnel");
    }
}
