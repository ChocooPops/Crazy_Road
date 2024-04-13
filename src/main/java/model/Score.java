
package model;

/**
 * Classe Score.
 */
public class Score {
    private int x; 
    private int y; 
    private int taille; 
    private int score; 
    private int verifScore; 
    
    Score() {
        this.x = DimensionFacteur.transformNbByFactor(7); 
        this.y = DimensionFacteur.transformNbByFactor(12); 
        this.taille = DimensionFacteur.transformNbByFactor(11); 
        this.score = 0; 
        this.verifScore = 0; 
    }
    
    public int getScore() {
        return this.score; 
    }
    public int getX() {
        return this.x; 
    }
    public int getY() {
        return this.y; 
    }
    public int getTaille() {
        return this.taille; 
    }
    
    /**
    * Reduire le score.
    */
    public void decrementerScore() {
        this.verifScore--; 
    }
    
    /**
    * Augmenter le score.
    */
    public void incrementerScore() {
        this.verifScore++; 
        if (this.verifScore > this.score) {
            this.score = this.verifScore;
        }
    }
}
