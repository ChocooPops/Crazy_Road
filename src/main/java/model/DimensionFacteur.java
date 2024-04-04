package model;

/**
 *
 * @author ChocoPops
 */
public final class DimensionFacteur {
    
    private static float facteur = (float) 2.45; 
    private static int width = Math.round(200 * DimensionFacteur.getFacteur()); 
    private static int height = Math.round(20 * 16 * DimensionFacteur.getFacteur()); 
    
    private DimensionFacteur() {
        
    }
    
    public static float getFacteur() {
        return DimensionFacteur.facteur;
    }
  
    public static int getHauteurFenetre() {
        return DimensionFacteur.height;
    }
    
    public static int getLongueurFenetre() {
        return DimensionFacteur.width;
    }
}
